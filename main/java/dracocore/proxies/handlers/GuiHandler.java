package dracocore.proxies.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import dracocore.handbook.gui.GuiLexicon;

public class GuiHandler implements IGuiHandler
{

	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{

		TileEntity tile_entity = world.getTileEntity(x, y, z);

		switch(ID)
		{
		
		}
		return null;
	}

	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{

		TileEntity tile_entity = world.getTileEntity(x, y, z);

		switch(ID)
		{
		case 1:
			return GuiLexicon.currentOpenLexicon;
		}

		return null;

	}

}