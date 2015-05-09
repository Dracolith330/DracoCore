package dracocore.blocks.blockclasses.mana;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import dracocore.CoreMain;
import dracocore.References;
import dracocore.api.transmission.NetworkType;
import dracocore.api.vector.Vector3;
import dracocore.blocks.blockclasses.general.ItemBlockDesc;
import dracocore.blocks.blockclasses.general.network.BlockTransmitter;
import dracocore.blocks.tileentity.mana.transfer.TileNullifiedManaPipe;

public class AcceleratedCrystalCluster extends BlockTransmitter implements ITileEntityProvider, ItemBlockDesc.IBlockShiftDesc
{
	@SideOnly(Side.CLIENT)
    private IIcon field_149935_N;
    @SideOnly(Side.CLIENT)
    private IIcon field_149936_O;
    
    public AcceleratedCrystalCluster()
    {
    	super(Material.cloth);
        this.setStepSound(Block.soundTypeStone);
        this.setResistance(0.2F);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        this.minVector = new Vector3(0.0, 0.0, 0.0);
        this.maxVector = new Vector3(1.0, 1.0, 1.0);
        this.setHardness(0.075F);
    }
    @Override
    public CreativeTabs getCreativeTabToDisplayOn()
    {
        return CoreMain.CoreTab;
    }
    @Override
    public boolean isOpaqueCube()
    {
        return false;
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
    public int damageDropped(int metadata)
    {
        return metadata;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata)
    {
    	return new TileAcceleratedCrystalCluster();
    }
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int idk, float what, float these, float are)
    {
    	TileAcceleratedCrystalCluster tileEntity = (TileAcceleratedCrystalCluster) world.getTileEntity(x, y, z);
		
		ItemStack playerItem = player.getCurrentEquippedItem();
    	
    		tileEntity.activateRitual(world, player);
    	return true;    	
    }
    @Override
    public NetworkType getNetworkType()
    {
        return NetworkType.MANA;
    }

    @Override
    public String getShiftDescription(int meta)
    {
            return "tile.manaPipe.description";
    }

    @Override
    public boolean showDescription(int meta)
    {
        return true;
    }
}
