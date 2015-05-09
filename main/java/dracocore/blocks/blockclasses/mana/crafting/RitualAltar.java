package dracocore.blocks.blockclasses.mana.crafting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dracocore.References;
import dracocore.api.mana.RitualHandler;
import dracocore.blocks.blockclasses.general.network.BlockTileGC;
import dracocore.blocks.tileentity.mana.crafting.TileEntityMagicalPlinth;
import dracocore.blocks.tileentity.mana.crafting.TileEntityRitualAltar;
import dracocore.items.mana.ItemsMana;
import dracocore.items.mana.WandCore;

public class RitualAltar extends BlockTileGC
{
    @SideOnly(Side.CLIENT)
    private IIcon field_149935_N;
    @SideOnly(Side.CLIENT)
    private IIcon field_149936_O;
    public static int type;

    
	
	
    public RitualAltar()
    {
        super(Material.rock);
    }
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon(References.texturelocation + ":" + "Blank");
        this.field_149936_O = p_149651_1_.registerIcon(References.texturelocation + ":" + "Blank");
        this.field_149935_N = p_149651_1_.registerIcon(References.texturelocation + ":" + "Blank");
    }
    public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_)
    {
        float f = 0.0625F;
        this.setBlockBounds(0.19F, 0.0F, 0.19F, 0.81F, 0.9F, 0.81F);
    }
    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_1_ == 1 ? this.field_149935_N : (p_149691_1_ == 0 ? this.field_149935_N : (p_149691_1_ != p_149691_2_ ? this.blockIcon : this.field_149936_O));
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int idk, float what, float these, float are)
    {
    	TileEntityRitualAltar tileEntity = (TileEntityRitualAltar) world.getTileEntity(x, y, z);

    	if (tileEntity == null || player.isSneaking())
    	{
    		return false;
    	}
    	
    	ItemStack playerItem = player.getCurrentEquippedItem();
    	if (tileEntity.getStackInSlot(0) != null && playerItem != null && playerItem.getItem() instanceof WandCore)
    	{
    			tileEntity.setOwner(player.getDisplayName());
    			tileEntity.activateRitual(world, player);
    			tileEntity.setActive(true);
    	}
    	else if (tileEntity.getStackInSlot(0) == null && playerItem != null)
    	{
    		ItemStack newItem = playerItem.copy();
    		newItem.stackSize = 1;
    		--playerItem.stackSize;
    		tileEntity.setInventorySlotContents(0, newItem);
    		tileEntity.startCycle();
    	} 
    	else if (tileEntity.getStackInSlot(0) != null && playerItem == null)
    	{
    		ItemStack newItem2 = tileEntity.getStackInSlot(0).copy();
    		newItem2.stackSize = 1;
    		player.inventory.addItemStackToInventory(newItem2);
    		tileEntity.setInventorySlotContents(0, null);
    	}
    	
    	world.markBlockForUpdate(x, y, z);
    	return true;
    }
    
    @Override
    public void breakBlock(World world, int x, int y, int z, Block par5, int par6)
    {
    	dropItems(world, x, y, z);
    	super.breakBlock(world, x, y, z, par5, par6);
    }
    
    private void dropItems(World world, int x, int y, int z)
    {
    	Random rand = new Random();
    	TileEntity tileEntity = world.getTileEntity(x, y, z);
    	
    	if (!(tileEntity instanceof IInventory))
    	{
    		return;
    	}
    	
    	IInventory inventory = (IInventory) tileEntity;
    	
    	for (int i = 0; i < inventory.getSizeInventory(); i++)
    	{
    		ItemStack item = inventory.getStackInSlot(i);
    		
    		if (item != null && item.stackSize > 0)
    		{
    			float rx = rand.nextFloat() * 0.8F + 0.1F;
    			float ry = rand.nextFloat() * 0.8F + 0.1F;
    			float rz = rand.nextFloat() * 0.8F + 0.1F;
    			EntityItem entityItem = new EntityItem(world,
    					x + rx, y + ry, z + rz,
    					new ItemStack(item.getItem(), item.stackSize, item.getItemDamage()));
    			
    			if (item.hasTagCompound())
    			{
    				entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
    			}
    			
    			float factor = 0.05F;
    			entityItem.motionX = rand.nextGaussian() * factor;
    			entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
    			entityItem.motionZ = rand.nextGaussian() * factor;
    			world.spawnEntityInWorld(entityItem);
    			item.stackSize = 0;
    		}
    	}
    }
    @Override
    public boolean renderAsNormalBlock()
    {
    	return false;
    }
    
    @Override
    public int getRenderType()
    {
    	return -1;
    }
    
    @Override
    public boolean isOpaqueCube()
    {
    	return false;
    }
    
    @Override
    public boolean hasTileEntity()
    {
    	return true;
    }
    @Override
    public void randomDisplayTick(World world, int x, int y, int z, Random rand)
    {
    	TileEntityRitualAltar tileEntity = (TileEntityRitualAltar) world.getTileEntity(x, y, z);
    	
    	if (rand.nextInt(3) != 0)
    	{
    		return;
    	}
    	
    }
    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
    {
        return new TileEntityRitualAltar();
    }
    
    
    
}