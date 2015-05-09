package dracocore.blocks.blockclasses.power.machines;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import dracocore.CoreMain;
import dracocore.api.transmission.NetworkType;
import dracocore.blocks.blockclasses.general.ItemBlockDesc;
import dracocore.blocks.blockclasses.general.network.BlockTransmitter;
import dracocore.blocks.tileentity.mana.crafting.TileEntityArcaneCraftingAltar;
import dracocore.blocks.tileentity.power.machine.TileEntityStoneSmasher;
import dracocore.items.mana.WandCore;

public class StoneSmasher extends BlockTransmitter implements ITileEntityProvider, ItemBlockDesc.IBlockShiftDesc
{
	
    public StoneSmasher()
    {
        super(Material.rock);
        this.setStepSound(Block.soundTypeStone);
        this.setResistance(0.2F);
        this.setHardness(0.075F);
    }

    @Override
    public CreativeTabs getCreativeTabToDisplayOn()
    {
        return CoreMain.CoreTab;
    }

    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
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
    	return new TileEntityStoneSmasher();
    }
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int idk, float what, float these, float are)
    {
    	TileEntityStoneSmasher tileEntity = (TileEntityStoneSmasher) world.getTileEntity(x, y, z);
    	
    	if (tileEntity == null || player.isSneaking())
    	{
    		return false;
    	}
    	
    	ItemStack playerItem = player.getCurrentEquippedItem();
    	if (tileEntity.getStackInSlot(0) != null && playerItem != null && playerItem.getItem() instanceof WandCore)
    	{
    		System.out.println(tileEntity.getStackInSlot(0).toString() + " " + tileEntity.getStackInSlot(0).stackSize);
    			//tileEntity.activateRitual(world, player);
    	}
    	else if (tileEntity.getStackInSlot(0) == null && playerItem != null)
    	{
    		ItemStack newItem = playerItem.copy();
    		newItem.stackSize = 1;
    		--playerItem.stackSize;
    		tileEntity.setInventorySlotContents(0, newItem);
    		tileEntity.startCycle();
    	}
    	else if(tileEntity.getStackInSlot(0) != null && playerItem != null && playerItem.getItem() == tileEntity.getStackInSlot(0).getItem())
    	{
    		--playerItem.stackSize;
    		tileEntity.getStackInSlot(0).stackSize++;
    		tileEntity.startCycle();
    	}
    	else if (tileEntity.getStackInSlot(0) != null && playerItem == null)
    	{
    		ItemStack newItem2 = tileEntity.getStackInSlot(0).copy();
    		newItem2.stackSize = 1;
    		player.inventory.addItemStackToInventory(newItem2);
    		
    		if(tileEntity.getStackInSlot(0).stackSize <= 1)
    			tileEntity.setInventorySlotContents(0, null);
    		else
    			tileEntity.getStackInSlot(0).stackSize--;
    	}
    	
    	
    	world.markBlockForUpdate(x, y, z);
    	return true;
    }
    @Override
    public NetworkType getNetworkType()
    {
        return NetworkType.POWER;
    }

    @Override
    public String getShiftDescription(int meta)
    {
            return "tile.aluminumWire.description";
    }

    @Override
    public boolean showDescription(int meta)
    {
        return true;
    }
}
