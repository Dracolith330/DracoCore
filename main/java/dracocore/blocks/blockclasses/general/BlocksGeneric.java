package dracocore.blocks.blockclasses.general;

import cpw.mods.fml.common.registry.GameRegistry;
import dracocore.CoreMain;
import dracocore.References;
import dracocore.blocks.blockclasses.general.block.BlockBase;
import dracocore.blocks.blockclasses.general.block.Ore;
import dracocore.blocks.blockclasses.general.block.OreVein;
import net.minecraft.block.Block;

public class BlocksGeneric 
{
	

	public static Block CopperOre;
	public static Block SilverOre;
	public static Block TinOre;
	public static Block BronzeOre;
	public static Block LeadOre;
	public static Block CobaltOre;
	public static Block PlatinumOre;
	public static Block UraniumOre;
	
	public static Block CopperVein;
	public static Block SilverVein;
	public static Block TinVein;
	public static Block BronzeVein;
	public static Block LeadVein;
	public static Block CobaltVein;
	public static Block PlatinumVein;
	public static Block UraniumVein;
	
	public static Block IronVein;
	public static Block DiamondVein;
	public static Block LapisVein;
	public static Block EmeraldVein;
	public static Block QuartzVein;
	public static Block CoalVein;
	public static Block GoldVein;
	
	public static Block CopperBlock;
	public static Block SilverBlock;
	public static Block TinBlock;
	public static Block BronzeBlock;
	public static Block LeadBlock;
	public static Block CobaltBlock;
	public static Block PlatinumBlock;
	public static Block UraniumBlock;
	
	public static void init()
	{
		registerOres();
		registerVeins();
		registerMetalBlocks();
		
		
		
		
		
		
	}

	public static void registerOres()
	{
		CopperOre = new Ore("").setBlockName("Copperore").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setBlockTextureName(References.texturelocation + ":" + "Copper ore");
	    GameRegistry.registerBlock(CopperOre, CopperOre.getUnlocalizedName().substring(5));
	    CopperOre.setHarvestLevel("pickaxe", 2);
	    
	    SilverOre = new Ore("").setBlockName("Silverore").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setBlockTextureName(References.texturelocation + ":" + "Silver ore");
	    GameRegistry.registerBlock(SilverOre, SilverOre.getUnlocalizedName().substring(5));
		SilverOre.setHarvestLevel("pickaxe", 2);
		
	    TinOre = new Ore("").setBlockName("Tinore").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setBlockTextureName(References.texturelocation + ":" + "Tin ore");
	    GameRegistry.registerBlock(TinOre, TinOre.getUnlocalizedName().substring(5));
	    TinOre.setHarvestLevel("pickaxe", 2);
	    
	    LeadOre = new Ore("").setBlockName("Leadore").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setBlockTextureName(References.texturelocation + ":" + "Lead ore");
	    GameRegistry.registerBlock(LeadOre, LeadOre.getUnlocalizedName().substring(5));
	    LeadOre.setHarvestLevel("pickaxe", 2);
	    
	    CobaltOre = new Ore("").setBlockName("Cobaltore").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setBlockTextureName(References.texturelocation + ":" + "Cobalt ore");
	    GameRegistry.registerBlock(CobaltOre, CobaltOre.getUnlocalizedName().substring(5));
	    CobaltOre.setHarvestLevel("pickaxe", 2);
	    
	    PlatinumOre = new Ore("").setBlockName("Platinumore").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setBlockTextureName(References.texturelocation + ":" + "Platinum ore");
	    GameRegistry.registerBlock(PlatinumOre, PlatinumOre.getUnlocalizedName().substring(5));
	    PlatinumOre.setHarvestLevel("pickaxe", 2);
	    
	    UraniumOre = new Ore("").setBlockName("Uraniumore").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setBlockTextureName(References.texturelocation + ":" + "Uranium ore");
	    GameRegistry.registerBlock(UraniumOre, UraniumOre.getUnlocalizedName().substring(5));
		UraniumOre.setHarvestLevel("pickaxe", 2);
	}
	
	public static void registerVeins()
	{
		CopperVein = new OreVein("").setBlockName("Coppervein").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setBlockTextureName(References.texturelocation + ":" + "Copper vein");
		GameRegistry.registerBlock(CopperVein, CopperVein.getUnlocalizedName().substring(5));
		CopperVein.setHarvestLevel("pickaxe", 1);
		
		SilverVein = new OreVein("").setBlockName("Silvervein").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setBlockTextureName(References.texturelocation + ":" + "Silver vein");
		GameRegistry.registerBlock(SilverVein, SilverVein.getUnlocalizedName().substring(5));
		SilverVein.setHarvestLevel("pickaxe", 2);
		
		TinVein = new OreVein("").setBlockName("Tinvein").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setBlockTextureName(References.texturelocation + ":" + "Tin vein");
		GameRegistry.registerBlock(TinVein, TinVein.getUnlocalizedName().substring(5));
		TinVein.setHarvestLevel("pickaxe", 1);
		
		LeadVein = new OreVein("").setBlockName("Leadvein").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setBlockTextureName(References.texturelocation + ":" + "Lead vein");
		GameRegistry.registerBlock(LeadVein, LeadVein.getUnlocalizedName().substring(5));
		LeadVein.setHarvestLevel("pickaxe", 2);
		
		CobaltVein = new OreVein("").setBlockName("Cobaltvein").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setBlockTextureName(References.texturelocation + ":" + "Cobalt vein");
		GameRegistry.registerBlock(CobaltVein, CobaltVein.getUnlocalizedName().substring(5));
		CobaltVein.setHarvestLevel("pickaxe", 3);
		
		PlatinumVein = new OreVein("").setBlockName("Platinumvein").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setBlockTextureName(References.texturelocation + ":" + "Platinum vein");
		GameRegistry.registerBlock(PlatinumVein, PlatinumVein.getUnlocalizedName().substring(5));
		PlatinumVein.setHarvestLevel("pickaxe", 3);
		
		UraniumVein = new OreVein("").setBlockName("Uraniumvein").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setBlockTextureName(References.texturelocation + ":" + "Uranium vein");
		GameRegistry.registerBlock(UraniumVein, UraniumVein.getUnlocalizedName().substring(5));
		UraniumVein.setHarvestLevel("pickaxe", 2);
		
		IronVein = new OreVein("").setBlockName("IronVein").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setBlockTextureName(References.texturelocation + ":" + "Iron vein");
		GameRegistry.registerBlock(IronVein, IronVein.getUnlocalizedName().substring(5));
		IronVein.setHarvestLevel("pickaxe", 1);

		DiamondVein = new OreVein("").setBlockName("DiamondVein").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setBlockTextureName(References.texturelocation + ":" + "Diamond vein");
		GameRegistry.registerBlock(DiamondVein, DiamondVein.getUnlocalizedName().substring(5));
		DiamondVein.setHarvestLevel("pickaxe", 2);
		
		LapisVein = new OreVein("").setBlockName("LapisVein").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setBlockTextureName(References.texturelocation + ":" + "Lapis vein");
		GameRegistry.registerBlock(LapisVein, LapisVein.getUnlocalizedName().substring(5));
		LapisVein.setHarvestLevel("pickaxe", 1);
		
		EmeraldVein = new OreVein("").setBlockName("EmeraldVein").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setBlockTextureName(References.texturelocation + ":" + "Emerald vein");
		GameRegistry.registerBlock(EmeraldVein, EmeraldVein.getUnlocalizedName().substring(5));
		EmeraldVein.setHarvestLevel("pickaxe", 2);
		
		QuartzVein = new OreVein("").setBlockName("QuartzVein").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setBlockTextureName(References.texturelocation + ":" + "Quartz vein");
		GameRegistry.registerBlock(QuartzVein, QuartzVein.getUnlocalizedName().substring(5));
		QuartzVein.setHarvestLevel("pickaxe", 1);
		
		CoalVein = new OreVein("").setBlockName("CoalVein").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setBlockTextureName(References.texturelocation + ":" + "Coal vein");
		GameRegistry.registerBlock(CoalVein, CoalVein.getUnlocalizedName().substring(5));
		CoalVein.setHarvestLevel("pickaxe", 0);
		
		GoldVein = new OreVein("").setBlockName("GoldVein").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setBlockTextureName(References.texturelocation + ":" + "Gold vein");
		GameRegistry.registerBlock(GoldVein, GoldVein.getUnlocalizedName().substring(5));
		GoldVein.setHarvestLevel("pickaxe", 2);
	}
	
	public static void registerMetalBlocks()
	{
		CopperBlock = new BlockBase("").setBlockName("Blockofcopper").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setBlockTextureName(References.texturelocation + ":" + "Block of copper");
		GameRegistry.registerBlock(CopperBlock, CopperBlock.getUnlocalizedName().substring(5));
		CopperBlock.setHarvestLevel("pickaxe", 1);
		
		SilverBlock = new BlockBase("").setBlockName("Blockofsilver").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setBlockTextureName(References.texturelocation + ":" + "Block of silver");
		GameRegistry.registerBlock(SilverBlock, SilverBlock.getUnlocalizedName().substring(5));
		SilverBlock.setHarvestLevel("pickaxe", 2);
		
		TinBlock = new BlockBase("").setBlockName("Blockoftin").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setBlockTextureName(References.texturelocation + ":" + "Block of tin");
		GameRegistry.registerBlock(TinBlock, TinBlock.getUnlocalizedName().substring(5));
		TinBlock.setHarvestLevel("pickaxe", 1);
		
		BronzeBlock = new BlockBase("").setBlockName("Blockofbronze").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setBlockTextureName(References.texturelocation + ":" + "Block of bronze");
		GameRegistry.registerBlock(BronzeBlock, BronzeBlock.getUnlocalizedName().substring(5));
		BronzeBlock.setHarvestLevel("pickaxe", 2);
		
		LeadBlock = new BlockBase("").setBlockName("Blockoflead").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setBlockTextureName(References.texturelocation + ":" + "Block of lead");
		GameRegistry.registerBlock(LeadBlock, LeadBlock.getUnlocalizedName().substring(5));
		LeadBlock.setHarvestLevel("pickaxe", 2);
		
		CobaltBlock = new BlockBase("").setBlockName("Blockofcobalt").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setBlockTextureName(References.texturelocation + ":" + "Block of cobalt");
		GameRegistry.registerBlock(CobaltBlock, CobaltBlock.getUnlocalizedName().substring(5));
		CobaltBlock.setHarvestLevel("pickaxe", 3);
		
		PlatinumBlock = new BlockBase("").setBlockName("Blockofplatinum").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setBlockTextureName(References.texturelocation + ":" + "Block of platinum");
		GameRegistry.registerBlock(PlatinumBlock, PlatinumBlock.getUnlocalizedName().substring(5));
		PlatinumBlock.setHarvestLevel("pickaxe", 3);
		
		UraniumBlock = new BlockBase("").setBlockName("Blockofuranium").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setBlockTextureName(References.texturelocation + ":" + "Block of uranium");
		GameRegistry.registerBlock(UraniumBlock, UraniumBlock.getUnlocalizedName().substring(5));
		UraniumBlock.setHarvestLevel("pickaxe", 2);
	}
}
