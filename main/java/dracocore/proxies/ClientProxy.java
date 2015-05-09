package dracocore.proxies;

import net.minecraft.client.Minecraft;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import dracocore.CoreMain;
import dracocore.api.prefab.core.ToolTipHandler;
import dracocore.blocks.renders.blockrenders.mana.crystal.NullManaPipeRender;
import dracocore.blocks.renders.blockrenders.mana.transmission.TileEntityManaPipeRender;
import dracocore.blocks.renders.blockrenders.power.wire.HighGradeWireRender;
import dracocore.blocks.renders.blockrenders.power.wire.LowGradeWireRender;
import dracocore.blocks.renders.blockrenders.power.wire.MediumGradeWireRender;
import dracocore.blocks.renders.blockrenders.power.wire.PerfectGradeWireRender;
import dracocore.blocks.renders.blockrenders.power.wire.TileEntityCopperWireRender;
import dracocore.blocks.tileentity.mana.crystal.TileEntityManaPipe;
import dracocore.blocks.tileentity.power.wire.TileEntityHighGradeWire;
import dracocore.blocks.tileentity.power.wire.TileEntityLowGradeWire;
import dracocore.blocks.tileentity.power.wire.TileEntityMediumGradeWire;
import dracocore.blocks.tileentity.power.wire.TileEntityPerfectGradeWire;
import dracocore.handbook.core.LexiconEntry;
import dracocore.handbook.gui.GuiLexicon;
import dracocore.handbook.gui.GuiLexiconEntry;
import dracocore.handbook.gui.GuiLexiconIndex;
import dracocore.proxies.tickhandlers.TickHandlerClient;

public class ClientProxy extends CommonProxy 
{
	public static final EnumRarity DracoCoreItem = EnumHelper.addRarity("DCRarity", EnumChatFormatting.BLUE, "Draconic");
	
	private static Minecraft mc = FMLClientHandler.instance().getClient();
	private static int renderIdManaPipe;
	private static int renderIdCopperWire;
	
	@Override
	public void preInit(FMLPreInitializationEvent event)
	{
	}
	
	@Override
	public void init(FMLInitializationEvent event)
	{
		ClientProxy.registerHandlers();
		ClientProxy.registerTileEntityRenderers();
		ClientProxy.registerBlockHandlers();

	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event)
	{
		ClientProxy.registerItemRenderers();

	}
	
	@Override
    public void registerItemTooltipHandler()
    {
        MinecraftForge.EVENT_BUS.register(new ToolTipHandler());
    }
	@Override
	public void registerRenderThings() 
	{
		
	}
	
	public static void registerItemRenderers()
	{
		
	}
	
	public static void registerHandlers()
	{
		TickHandlerClient tickHandlerClient = new TickHandlerClient();
		FMLCommonHandler.instance().bus().register(tickHandlerClient);
		MinecraftForge.EVENT_BUS.register(tickHandlerClient);
		MinecraftForge.EVENT_BUS.register(CoreMain.proxy);
	}
	public static void registerTileEntityRenderers()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityManaPipe.class, new NullManaPipeRender());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLowGradeWire.class, new LowGradeWireRender());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMediumGradeWire.class, new MediumGradeWireRender());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHighGradeWire.class, new HighGradeWireRender());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPerfectGradeWire.class, new PerfectGradeWireRender());
	}
	
	public static void registerBlockHandlers()
	{
		ClientProxy.renderIdManaPipe = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new TileEntityManaPipeRender(ClientProxy.renderIdManaPipe));

		ClientProxy.renderIdCopperWire = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new TileEntityCopperWireRender(ClientProxy.renderIdCopperWire));
	}
	@Override
	public World getClientWorld()
	{
		return FMLClientHandler.instance().getClient().theWorld;
	}
	@Override
    public void setEntryToOpen(LexiconEntry entry) {
        GuiLexicon.currentOpenLexicon = new GuiLexiconEntry(entry, new GuiLexiconIndex(entry.category));
    }

    @Override
    public void setLexiconStack(ItemStack stack) {
        GuiLexicon.stackUsed = stack;
    }
	@Override
	public World getWorldForID(int dimensionID)
	{
		World world = ClientProxy.mc.theWorld;
		if (world != null && world.provider.dimensionId == dimensionID)
		{
			return world;
		}
		return null;
	}
}
