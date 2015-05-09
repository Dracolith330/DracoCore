package dracocore.items.mana;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dracocore.References;
import dracocore.blocks.BlocksMain;
import dracocore.blocks.tileentity.mana.generator.TileEntityCrystalManaSource;

public class CrystalosWand extends WandCore
{
	
	public CrystalosWand()
	{
		super();
		this.setMaxStackSize(1);
        setNoRepair();
	}
	
	@Override
	public int maxCapacity() 
	{
		return 1000;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) 
	{
		itemIcon = par1IconRegister.registerIcon(References.modid + ":" + this.getUnlocalizedName().substring(5));
	}

}
