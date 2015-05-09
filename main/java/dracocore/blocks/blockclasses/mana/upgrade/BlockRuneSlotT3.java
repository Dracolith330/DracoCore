package dracocore.blocks.blockclasses.mana.upgrade;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dracocore.References;
import dracocore.api.superclass.RunicUpgrade;
import dracocore.blocks.tileentity.mana.upgrade.TileEntityRunicUpgradeT3;

public class BlockRuneSlotT3 extends BaseRuneSlot
{
    @SideOnly(Side.CLIENT)
    private IIcon field_149935_N;
    @SideOnly(Side.CLIENT)
    private IIcon field_149936_O;
    public static int type;
    
    public BlockRuneSlotT3()
    {
        super(Material.rock);
    }
    public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_)
    {
        float f = 0.0625F;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1F, 1F, 1F);
    }
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int idk, float what, float these, float are)
    {
    	TileEntityRunicUpgradeT3 tileEntity = (TileEntityRunicUpgradeT3) world.getTileEntity(x, y, z);
    	
    	if (tileEntity == null || player.isSneaking())
    	{
    		return false;
    	}
    	
    	ItemStack playerItem = player.getCurrentEquippedItem();
    	
    	if (tileEntity.getStackInSlot(0) == null && playerItem != null)
    	{
    		ItemStack newItem = playerItem.copy();
    		newItem.stackSize = 1;
    		--playerItem.stackSize;
    		tileEntity.setInventorySlotContents(0, newItem);
    		tileEntity.startCycle();
    	} 
    	else if (tileEntity.getStackInSlot(0) != null && playerItem == null)
    	{
    		player.inventory.addItemStackToInventory(tileEntity.getStackInSlot(0));
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
    	return true;
    }
    
    @Override
    public int getRenderType()
    {
    	return 0;
    }
    
    @Override
    public boolean isOpaqueCube()
    {
    	return true;
    }
    
    @Override
    public boolean hasTileEntity()
    {
    	return true;
    }
    @Override
    public void randomDisplayTick(World world, int x, int y, int z, Random rand)
    {
    	TileEntityRunicUpgradeT3 tileEntity = (TileEntityRunicUpgradeT3) world.getTileEntity(x, y, z);
    	
    	if (rand.nextInt(3) != 0)
    	{
    		return;
    	}
    }
    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
    {
        return new TileEntityRunicUpgradeT3();
    }
}