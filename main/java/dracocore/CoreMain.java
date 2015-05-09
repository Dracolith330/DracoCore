package dracocore;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import dracocore.blocks.BlocksMain;
import dracocore.blocks.blockclasses.mana.BlocksMagic;
import dracocore.blocks.blockclasses.mana.TileAcceleratedCrystalCluster;
import dracocore.blocks.blockclasses.mana.TileCorruptObelisk;
import dracocore.blocks.blockclasses.mana.TilePureSpark;
import dracocore.blocks.blockclasses.power.BlocksTech;
import dracocore.blocks.renders.blockrenders.mana.crafting.ArcaneCraftingAltarRender;
import dracocore.blocks.renders.blockrenders.mana.crafting.ArcaneCraftingSlotRender;
import dracocore.blocks.renders.blockrenders.mana.crafting.MagicalPlinthRender;
import dracocore.blocks.renders.blockrenders.mana.crafting.RitualAltarRender;
import dracocore.blocks.renders.blockrenders.mana.crafting.SpellCraftingRender;
import dracocore.blocks.renders.blockrenders.mana.crystal.ClusteredManaPipeRender;
import dracocore.blocks.renders.blockrenders.mana.crystal.ElementalManaPipeRender;
import dracocore.blocks.renders.blockrenders.mana.crystal.NullManaPipeRender;
import dracocore.blocks.renders.blockrenders.mana.crystal.StaticManaPipeRender;
import dracocore.blocks.renders.blockrenders.mana.generator.CrystalManaSourceRender;
import dracocore.blocks.renders.blockrenders.mana.generator.SolarGeneratorRenderer;
import dracocore.blocks.renders.blockrenders.mana.storage.CrystalClusterRender;
import dracocore.blocks.renders.blockrenders.mana.storage.ElementalCrystalRender;
import dracocore.blocks.renders.blockrenders.mana.storage.NulifiedCrystalRender;
import dracocore.blocks.renders.blockrenders.mana.storage.StaticCrystalRender;
import dracocore.blocks.renders.blockrenders.mana.upgrade.RunicUpgradeT1Render;
import dracocore.blocks.renders.blockrenders.mana.upgrade.RunicUpgradeT2Render;
import dracocore.blocks.renders.blockrenders.mana.upgrade.RunicUpgradeT3Render;
import dracocore.blocks.renders.blockrenders.mana.upgrade.RunicUpgradeT4Render;
import dracocore.blocks.renders.blockrenders.power.wire.AcceleratedCrystalClusterRender;
import dracocore.blocks.renders.blockrenders.power.wire.CorruptObeliskRender;
import dracocore.blocks.renders.blockrenders.power.wire.HighGradeWireRender;
import dracocore.blocks.renders.blockrenders.power.wire.LowGradeWireRender;
import dracocore.blocks.renders.blockrenders.power.wire.MediumGradeWireRender;
import dracocore.blocks.renders.blockrenders.power.wire.PerfectGradeWireRender;
import dracocore.blocks.renders.blockrenders.power.wire.PureSparkRender;
import dracocore.blocks.renders.itemrenders.mana.crafting.ItemArcaneCraftingAltarRender;
import dracocore.blocks.renders.itemrenders.mana.crafting.ItemArcaneCraftingSlotRender;
import dracocore.blocks.renders.itemrenders.mana.crafting.ItemMagicalPlinthRender;
import dracocore.blocks.renders.itemrenders.mana.crafting.ItemRitualAltarRender;
import dracocore.blocks.renders.itemrenders.mana.crafting.ItemSpellCraftingRender;
import dracocore.blocks.renders.itemrenders.mana.crystal.ItemClusterManaPipeRender;
import dracocore.blocks.renders.itemrenders.mana.crystal.ItemElementalManaPipeRender;
import dracocore.blocks.renders.itemrenders.mana.crystal.ItemNullifiedManaPipeRender;
import dracocore.blocks.renders.itemrenders.mana.crystal.ItemStaticManaPipeRender;
import dracocore.blocks.renders.itemrenders.mana.generator.ItemAcceleratedCrystalClusterRender;
import dracocore.blocks.renders.itemrenders.mana.generator.ItemCorruptObeliskRender;
import dracocore.blocks.renders.itemrenders.mana.generator.ItemCrystalManaSourceRender;
import dracocore.blocks.renders.itemrenders.mana.generator.ItemPureSparkRender;
import dracocore.blocks.renders.itemrenders.mana.generator.ItemSolarCrystalGenRender;
import dracocore.blocks.renders.itemrenders.mana.storage.ItemCrystalClusterRender;
import dracocore.blocks.renders.itemrenders.mana.storage.ItemElementalCrystalRender;
import dracocore.blocks.renders.itemrenders.mana.storage.ItemNullifiedCrystalRender;
import dracocore.blocks.renders.itemrenders.mana.storage.ItemStaticCrystalRender;
import dracocore.blocks.renders.itemrenders.power.wire.ItemHighGradeWireRender;
import dracocore.blocks.renders.itemrenders.power.wire.ItemLowGradeWireRender;
import dracocore.blocks.renders.itemrenders.power.wire.ItemMediumGradeWireRender;
import dracocore.blocks.renders.itemrenders.power.wire.ItemPerfectGradeWireRender;
import dracocore.blocks.tileentity.mana.crafting.TileEntityArcaneCraftingAltar;
import dracocore.blocks.tileentity.mana.crafting.TileEntityArcaneCraftingSlot;
import dracocore.blocks.tileentity.mana.crafting.TileEntityMagicalPlinth;
import dracocore.blocks.tileentity.mana.crafting.TileEntityRitualAltar;
import dracocore.blocks.tileentity.mana.crafting.TileEntitySpellCrafting;
import dracocore.blocks.tileentity.mana.generator.TileEntityCrystalManaSource;
import dracocore.blocks.tileentity.mana.generator.TileEntitySolarManaGenerator;
import dracocore.blocks.tileentity.mana.storage.TileCrystalCluster;
import dracocore.blocks.tileentity.mana.storage.TileEntityElementalCrystal;
import dracocore.blocks.tileentity.mana.storage.TileNulifiedCrystal;
import dracocore.blocks.tileentity.mana.storage.TileStaticCrystal;
import dracocore.blocks.tileentity.mana.transfer.TileClusteredManaPipe;
import dracocore.blocks.tileentity.mana.transfer.TileElementalManaPipe;
import dracocore.blocks.tileentity.mana.transfer.TileNullifiedManaPipe;
import dracocore.blocks.tileentity.mana.transfer.TileStaticManaPipe;
import dracocore.blocks.tileentity.mana.upgrade.TileEntityRunicUpgradeT1;
import dracocore.blocks.tileentity.mana.upgrade.TileEntityRunicUpgradeT2;
import dracocore.blocks.tileentity.mana.upgrade.TileEntityRunicUpgradeT3;
import dracocore.blocks.tileentity.mana.upgrade.TileEntityRunicUpgradeT4;
import dracocore.blocks.tileentity.power.wire.TileEntityHighGradeWire;
import dracocore.blocks.tileentity.power.wire.TileEntityLowGradeWire;
import dracocore.blocks.tileentity.power.wire.TileEntityMediumGradeWire;
import dracocore.blocks.tileentity.power.wire.TileEntityPerfectGradeWire;
import dracocore.energy.grid.ChunkPowerHandler;
import dracocore.handbook.LexiconData;
import dracocore.handbook.core.KnowledgeType;
import dracocore.items.ItemsMain;
import dracocore.items.general.CustomEntityList;
import dracocore.network.PipeHandler;
import dracocore.proxies.CommonProxy;
import dracocore.proxies.Config;
import dracocore.proxies.InterModCompatability;
import dracocore.proxies.ModRecipes;
import dracocore.proxies.handlers.GuiHandler;
import dracocore.proxies.handlers.NewPacketHandler;
import dracocore.proxies.helpers.MobDeathItemDropper;
import dracocore.proxies.tickhandlers.TickHandlerServer;

@Mod(modid = References.modid, name = References.modname, version = References.modversion, dependencies = "required-after:Thaumcraft")

public class CoreMain
{
	@SidedProxy(clientSide = References.clientproxy, serverSide = References.serverproxy)
	public static CommonProxy proxy;
	@Instance(References.modid)
	public static CoreMain instance;
	public static Map<String, KnowledgeType> knowledgeTypes = new HashMap<String, KnowledgeType>();

	public static KnowledgeType basicKnowledge, draconianKnowledge;
	
	public static boolean MagicEnabled = false;
	public static boolean TechEnabled = false;
	//public static boolean GregTechInstalled = false;
	public static boolean ThaumcraftInstalled = false;

    public static final String BASE_CONFIG_FILE = "DracoCore/DracoCore.conf";
    
	private GuiHandler guiHandler = new GuiHandler();
	public static final CreativeTabs CoreTab = new CoreTab(CreativeTabs.getNextID(), "DracoCore Tab");

	public static PipeHandler PacketHandler;
	
	@Mod.EventHandler
	  public void preLoad(FMLPreInitializationEvent event)
	  {

		basicKnowledge = registerKnowledgeType("minecraft", EnumChatFormatting.RESET, true);
		
		/*
		 * Unlocked by having high tier magic and technology devices nearby in a specific pattern
		 * 
		 *     X X O O O X X		B P P P P P B
		 * 	   X S X O X S X		P C X X X C P
		 * 	   O X X O X X O		P X X X X X P
		 * 0 - O O O D O O O	1 - P X X X X X P
		 * 	   O X X O X X O		P X X X X X P
		 * 	   X S X O X S X		P C X X X C P
		 * 	   X X O O O X X		B P P P P P B
		 * 
		 * 	Legend;
		 * 		X-Any Block
		 * 		S-Tier 4 runic slot
		 * 		O-Obsidian
		 * 		D-Diamond Block
		 * 		P-Perfect Grade Wire
		 * 		C-Elemental Crystal Cluster
		 * 		B-Energy Cube
		 */
		draconianKnowledge = registerKnowledgeType("Draconian", EnumChatFormatting.DARK_RED, false);
		
		proxy.preInit(event);
		
		try
	    {
			Config.initialize(new File(event.getModConfigurationDirectory(), CoreMain.BASE_CONFIG_FILE));
	    }
	    catch (Exception e)
	    {
	    	LogManager.getLogger(References.modname).info(References.getErrorMessage());
	    }
	    finally
	    {
	    	if (Config.config != null) 
	    	{
	    		Config.save();
	     	}
	    }
		FMLLog.log(Level.INFO, References.modid + " is now integrating neural uplink.");
		
		if(Loader.isModLoaded("Thaumcraft"))
		{
			LogManager.getLogger(References.modname).info("there is a strong sense of aura in the air, now begining neural integration...");
			ThaumcraftInstalled = true;
		}
		else
			LogManager.getLogger(References.modname).info("Unable to sense the outerlands, continueing standard integration...");

		
		
		BlocksMain.init();
		ItemsMain.init();
		FMLLog.log(Level.INFO, References.modid + " has finished preLoad Initialization.");
		NewPacketHandler.INSTANCE.ordinal();

		LexiconData.preinit();
	}
	
	public static KnowledgeType registerKnowledgeType(String id, EnumChatFormatting color, boolean autoUnlock) {
		KnowledgeType type = new KnowledgeType(id, color, autoUnlock);
		knowledgeTypes.put(id, type);
		return type;
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		proxy.init(event);

		CoreMain.PacketHandler = PipeHandler.init();
		
		registerEntityEgg(EntityDragon.class, 0x000000, 0x4f0034);
		proxy.registerItemTooltipHandler();
		NetworkRegistry.INSTANCE.registerGuiHandler(this, guiHandler);
		InterModCompatability.init();
		ModRecipes.init();
        ChunkPowerHandler.initiate();
		registerTiles();
		
		if(ThaumcraftInstalled)
	    {
			  InterModCompatability.registerThaumcraftRecipesandAspects();
	    }

		MinecraftForge.EVENT_BUS.register(new MobDeathItemDropper());
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) 
	{
		LexiconData.init();
		Config.initLoot();
		proxy.postInit(event);
		
		if(ThaumcraftInstalled)
		{
			  InterModCompatability.registerthaumcraftresearch();
	    }
		FMLCommonHandler.instance().bus().register(new TickHandlerServer());
	}
	
	@Mod.EventHandler
	public void serverStarting(FMLServerStartingEvent event) {
		
	}
	
	public void registerTileEntities(Block block, Class<? extends TileEntity> tile, TileEntitySpecialRenderer tileRenderer, IItemRenderer itemRenderer, String name, String secondaryName)
	{
		GameRegistry.registerTileEntity(tile, name);
		ClientRegistry.registerTileEntity(tile, secondaryName, tileRenderer);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(block), itemRenderer);
	}
	
	public void registerTiles()
	{
		GameRegistry.registerTileEntity(TilePureSpark.class, "PureSpark");
		ClientRegistry.registerTileEntity(TilePureSpark.class, "PSpark", new PureSparkRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlocksMagic.PureSpark), new ItemPureSparkRender());
		
		GameRegistry.registerTileEntity(TileAcceleratedCrystalCluster.class, "AcceleratedCrystalCluster");
		ClientRegistry.registerTileEntity(TileAcceleratedCrystalCluster.class, "AcceleratedCCluster", new AcceleratedCrystalClusterRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlocksMagic.AcceleratedCrystalCluster), new ItemAcceleratedCrystalClusterRender());
		
		GameRegistry.registerTileEntity(TileEntityMagicalPlinth.class, "MagicalPlinth");
		ClientRegistry.registerTileEntity(TileEntityMagicalPlinth.class, "Plinth", new MagicalPlinthRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlocksMagic.MagicalPlinth), new ItemMagicalPlinthRender());
		
		GameRegistry.registerTileEntity(TileEntityRitualAltar.class, "RAltar");
		ClientRegistry.registerTileEntity(TileEntityRitualAltar.class, "RitualAltar", new RitualAltarRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlocksMagic.RitualAltar), new ItemRitualAltarRender());
		
		GameRegistry.registerTileEntity(TileEntityArcaneCraftingSlot.class, "ACSlot");
		ClientRegistry.registerTileEntity(TileEntityArcaneCraftingSlot.class, "ArcaneCSlot", new ArcaneCraftingSlotRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlocksMagic.ArcaneCraftingSlot), new ItemArcaneCraftingSlotRender());
		
		GameRegistry.registerTileEntity(TileEntityArcaneCraftingAltar.class, "ACAltar");
		ClientRegistry.registerTileEntity(TileEntityArcaneCraftingAltar.class, "ArcaneCAltar", new ArcaneCraftingAltarRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlocksMagic.ArcaneCraftingAltar), new ItemArcaneCraftingAltarRender());
		
		GameRegistry.registerTileEntity(TileEntityElementalCrystal.class, "ECrystal");
		ClientRegistry.registerTileEntity(TileEntityElementalCrystal.class, "ElementalCrystal", new ElementalCrystalRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlocksMagic.ChargedCrystalCluser), new ItemElementalCrystalRender());
		
		GameRegistry.registerTileEntity(TileEntitySpellCrafting.class, "SCrafting");
		ClientRegistry.registerTileEntity(TileEntitySpellCrafting.class, "SpellCrafting", new SpellCraftingRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlocksMagic.SpellCrafter), new ItemSpellCraftingRender());
		
		GameRegistry.registerTileEntity(TileEntityCrystalManaSource.class, "MSource");
		ClientRegistry.registerTileEntity(TileEntityCrystalManaSource.class, "ManaSource", new CrystalManaSourceRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlocksMagic.CrystalManaSource), new ItemCrystalManaSourceRender());
		
		GameRegistry.registerTileEntity(TileNullifiedManaPipe.class, "NMPipe");
		ClientRegistry.registerTileEntity(TileNullifiedManaPipe.class, "NullifiedManaPipe", new NullManaPipeRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlocksMagic.NullManaPipe), new ItemNullifiedManaPipeRender());
		
		GameRegistry.registerTileEntity(TileStaticManaPipe.class, "SMPipe");
		ClientRegistry.registerTileEntity(TileStaticManaPipe.class, "StaticManaPipe", new StaticManaPipeRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlocksMagic.StaticManaPipe), new ItemStaticManaPipeRender());
		
		GameRegistry.registerTileEntity(TileClusteredManaPipe.class, "CMPipe");
		ClientRegistry.registerTileEntity(TileClusteredManaPipe.class, "ClusteredManaPipe", new ClusteredManaPipeRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlocksMagic.ClusterManaPipe), new ItemClusterManaPipeRender());
		
		GameRegistry.registerTileEntity(TileElementalManaPipe.class, "EMPipe");
		ClientRegistry.registerTileEntity(TileElementalManaPipe.class, "ElementalManaPipe", new ElementalManaPipeRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlocksMagic.ElementalManaPipe), new ItemElementalManaPipeRender());
		
		GameRegistry.registerTileEntity(TileEntitySolarManaGenerator.class, "SCrystalGen");
		ClientRegistry.registerTileEntity(TileEntitySolarManaGenerator.class, "SolarCrystalGen", new SolarGeneratorRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlocksMagic.SolarManaGenerator), new ItemSolarCrystalGenRender());
		
		GameRegistry.registerTileEntity(TileEntityRunicUpgradeT1.class, "RUpgradeT1");
		ClientRegistry.registerTileEntity(TileEntityRunicUpgradeT1.class, "RunicUpgradeT1", new RunicUpgradeT1Render());
		GameRegistry.registerTileEntity(TileEntityRunicUpgradeT2.class, "RUpgradeT2");
		ClientRegistry.registerTileEntity(TileEntityRunicUpgradeT2.class, "RunicUpgradeT2", new RunicUpgradeT2Render());
		GameRegistry.registerTileEntity(TileEntityRunicUpgradeT3.class, "RUpgradeT3");
		ClientRegistry.registerTileEntity(TileEntityRunicUpgradeT3.class, "RunicUpgradeT3", new RunicUpgradeT3Render());
		GameRegistry.registerTileEntity(TileEntityRunicUpgradeT4.class, "RUpgradeT4");
		ClientRegistry.registerTileEntity(TileEntityRunicUpgradeT4.class, "RunicUpgradeT4", new RunicUpgradeT4Render());
		
		GameRegistry.registerTileEntity(TileNulifiedCrystal.class, "NCrystal");
		ClientRegistry.registerTileEntity(TileNulifiedCrystal.class, "NulifiedCrystal", new NulifiedCrystalRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlocksMagic.NullifiedCrystal), new ItemNullifiedCrystalRender());
		
		GameRegistry.registerTileEntity(TileStaticCrystal.class, "SCrystal");
		ClientRegistry.registerTileEntity(TileStaticCrystal.class, "StaticCrystal", new StaticCrystalRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlocksMagic.StaticCrystal), new ItemStaticCrystalRender());
		
		GameRegistry.registerTileEntity(TileCrystalCluster.class, "CrystalC");
		ClientRegistry.registerTileEntity(TileCrystalCluster.class, "CrystalCluster", new CrystalClusterRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlocksMagic.CrystalCLuster), new ItemCrystalClusterRender());
		
		GameRegistry.registerTileEntity(TileEntityLowGradeWire.class, "LGWire");
		ClientRegistry.registerTileEntity(TileEntityLowGradeWire.class, "LowGradeWire", new LowGradeWireRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlocksTech.LowGradeWire), new ItemLowGradeWireRender());
		
		GameRegistry.registerTileEntity(TileEntityMediumGradeWire.class, "MGWire");
		ClientRegistry.registerTileEntity(TileEntityMediumGradeWire.class, "MediumGradeWire", new MediumGradeWireRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlocksTech.MediumGradeWire), new ItemMediumGradeWireRender());
		
		GameRegistry.registerTileEntity(TileEntityHighGradeWire.class, "HGWire");
		ClientRegistry.registerTileEntity(TileEntityHighGradeWire.class, "HighGradeWire", new HighGradeWireRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlocksTech.HighGradeWire), new ItemHighGradeWireRender());
		
		GameRegistry.registerTileEntity(TileEntityPerfectGradeWire.class, "PGWire");
		ClientRegistry.registerTileEntity(TileEntityPerfectGradeWire.class, "PerfectGradeWire", new PerfectGradeWireRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlocksTech.PerfectGradeWire), new ItemPerfectGradeWireRender());
		
		GameRegistry.registerTileEntity(TileCorruptObelisk.class, "CObelisk");
		ClientRegistry.registerTileEntity(TileCorruptObelisk.class, "CorruptObelisk", new CorruptObeliskRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlocksMagic.CorruptObelisk), new ItemCorruptObeliskRender());
		
	}

	public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor) 
	{
		int id = getUniqueEntityId();
		CustomEntityList.IDtoClassMapping.put(id, entity);
		CustomEntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
	}
	public static int getUniqueEntityId()
	{           
		int startEntityId = 0;
		do 
		{
			startEntityId++;
		} 
		while (CustomEntityList.getStringFromID(startEntityId) != null);

		return startEntityId;
	}
	
	public static IRecipe getLatestAddedRecipe() {
		List<IRecipe> list = CraftingManager.getInstance().getRecipeList();
		return list.get(list.size() - 1);
	}

	/**
	 * Gets the last x recipes added to the recipe list.
	 */
	public static List<IRecipe> getLatestAddedRecipes(int x) {
		List<IRecipe> list = CraftingManager.getInstance().getRecipeList();
		List<IRecipe> newList = new ArrayList();
		for(int i = x - 1; i >= 0; i--)
			newList.add(list.get(list.size() - 1 - i));

		return newList;
	}
}
