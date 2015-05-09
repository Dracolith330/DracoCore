package dracocore.blocks.blockclasses.mana.storage;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dracocore.References;
import dracocore.blocks.blockclasses.general.network.BlockTileGC;
import dracocore.blocks.blockclasses.general.network.ItemBlockDesc;
import dracocore.blocks.tileentity.mana.crafting.TileEntityRitualAltar;
import dracocore.blocks.tileentity.mana.storage.TileCrystalCluster;
import dracocore.blocks.tileentity.mana.storage.TileEntityElementalCrystal;

public class CrystalCluster extends BlockTileGC implements ItemBlockDesc.IBlockShiftDesc
{
    @SideOnly(Side.CLIENT)
    private IIcon field_149935_N;
    @SideOnly(Side.CLIENT)
    private IIcon field_149936_O;
    public static int type;
    private boolean isactive;
    int capacity = 0;
    int extract = 0;
    
    public CrystalCluster()
    {
        super(Material.rock);
        isactive = false;
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
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1F, 1F, 1F);
        
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
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLiving, ItemStack itemStack)
    {
    	int l = MathHelper.floor_double(entityLiving.rotationYaw * 4.0F / 360.0F + 0.5D) & 0x3;
    	int metadata = world.getBlockMetadata(x, y, z);
        TileEntity tile = world.getTileEntity(x, y, z);
    	int change = 0;
    	
    	if (l == 0) {
            ((TileCrystalCluster)tile).facing = 2;
            change = 3;
          }
          if (l == 1) {
            ((TileCrystalCluster)tile).facing = 5;
            change = 1;
          }
          if (l == 2) {
            ((TileCrystalCluster)tile).facing = 3;
            change = 2;
          }
          if (l == 3) {
            ((TileCrystalCluster)tile).facing = 4;
            change = 0;
          }
    	world.setBlockMetadataWithNotify(x, y, z, (metadata & 12) + change, 3);
    }
    
    @Override
    public void breakBlock(World world, int x, int y, int z, Block par5, int par6)
    {
    	dropItems(world, x, y, z);
    	super.breakBlock(world, x, y, z, par5, par6);
    }
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int idk, float what, float these, float are)
    {
    	TileCrystalCluster tileEntity = (TileCrystalCluster) world.getTileEntity(x, y, z);
		tileEntity.activateRitual(world, player);
		
    	return true;    	
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
    
    public void setactive()
    {
    	this.isactive = true;
    }
    public void setinactive()
    {
    	this.isactive = false;
    }
    
    @Override
    public boolean hasTileEntity()
    {
    	return true;
    }
    @Override
    public void randomDisplayTick(World world, int x, int y, int z, Random rand)
    {
    	TileCrystalCluster tileEntity = (TileCrystalCluster) world.getTileEntity(x, y, z);
    }
    
    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
    {
        return new TileCrystalCluster();
    }
    
	@Override
	public String getShiftDescription(int meta) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean showDescription(int meta) {
		// TODO Auto-generated method stub
		return false;
	}
}