package dracocore.proxies;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import dracocore.handbook.LexiconData;
import dracocore.handbook.core.LexiconEntry;
import dracocore.handbook.gui.GuiLexicon;
import dracocore.handbook.gui.GuiLexiconEntry;
import dracocore.handbook.gui.GuiLexiconIndex;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event)
	{
	}
	
	public void init(FMLInitializationEvent event)
	{
	}
	
	public void postInit(FMLPostInitializationEvent event)
	{
	}
	
	public void registerItemTooltipHandler() {
		// TODO Auto-generated method stub
		
	}

	public void registerRenderThings() {
		// TODO Auto-generated method stub
		
	}

	public World getClientWorld() {
		// TODO Auto-generated method stub
		return null;
	}
	public World getWorldForID(int dimensionID)
	{
		return FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(dimensionID);
	}

	public void setEntryToOpen(LexiconEntry entry) {
    }

    public void setLexiconStack(ItemStack stack) {
    }
}
