package dracocore.blocks.blockclasses.mana;

import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import dracocore.CoreMain;
import dracocore.References;
import dracocore.blocks.BlocksMain;
import dracocore.blocks.blockclasses.mana.crafting.ArcaneCraftingAltar;
import dracocore.blocks.blockclasses.mana.crafting.ArcaneCraftingSlot;
import dracocore.blocks.blockclasses.mana.crafting.BlockSpellCrafting;
import dracocore.blocks.blockclasses.mana.crafting.MagicalPlinth;
import dracocore.blocks.blockclasses.mana.crafting.RitualAltar;
import dracocore.blocks.blockclasses.mana.crystal.TunedCrystal;
import dracocore.blocks.blockclasses.mana.generator.BlockCrystalManaSource;
import dracocore.blocks.blockclasses.mana.generator.SolarCrystalGenerator;
import dracocore.blocks.blockclasses.mana.storage.CrystalCluster;
import dracocore.blocks.blockclasses.mana.storage.ElementalCrystal;
import dracocore.blocks.blockclasses.mana.storage.NullifiedCrystal;
import dracocore.blocks.blockclasses.mana.storage.StaticCrystal;
import dracocore.blocks.blockclasses.mana.transfer.ClusterManaPipe;
import dracocore.blocks.blockclasses.mana.transfer.ElementalManaPipe;
import dracocore.blocks.blockclasses.mana.transfer.NullManaPipe;
import dracocore.blocks.blockclasses.mana.transfer.StaticManaPipe;
import dracocore.blocks.blockclasses.mana.upgrade.BlockRuneSlotT1;
import dracocore.blocks.blockclasses.mana.upgrade.BlockRuneSlotT2;
import dracocore.blocks.blockclasses.mana.upgrade.BlockRuneSlotT3;
import dracocore.blocks.blockclasses.mana.upgrade.BlockRuneSlotT4;

public class BlocksMagic 
{
	
	
	public static Block RuneSlotT1;
	public static Block RuneSlotT2;
	public static Block RuneSlotT3;
	public static Block RuneSlotT4;
	
	
	//TRANSFER//
	public static Block NullManaPipe;
	public static Block StaticManaPipe;
	public static Block ClusterManaPipe;
	public static Block ElementalManaPipe;
	
	//GENERATORS//
	public static Block SolarManaGenerator;
	public static Block CrystalManaSource;
	
	//STORAGE//
	public static Block NullifiedCrystal;
	public static Block StaticCrystal;
	public static Block CrystalCLuster;
	public static Block ChargedCrystalCluser;
	
	//MACHINES//
	public static Block SpellCrafter;
	public static Block ArcaneCraftingSlot;
	public static Block ArcaneCraftingAltar;
	public static Block MagicalPlinth;
	public static Block RitualAltar;
	public static Block CorruptObelisk;
	public static Block PureSpark;
	public static Block CropLily;
	public static Block AcceleratedCrystalCluster;
	public static Block LuxGenerator;
	
	public static void init()
	{
		CropLily = new CropLily().setBlockName("CropLily").setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerBlock(CropLily, CropLily.getUnlocalizedName().substring(5));
		BlocksMain.blockNames.add(CropLily.getUnlocalizedName().substring(5));
		
		LuxGenerator = new LuxGenerator().setBlockName("LuxGenerator").setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerBlock(LuxGenerator, LuxGenerator.getUnlocalizedName().substring(5));
		BlocksMain.blockNames.add(LuxGenerator.getUnlocalizedName().substring(5));
		LuxGenerator.setHarvestLevel("pickaxe", 1);
		
		PureSpark = new PureSpark().setBlockName("PureSpark").setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerBlock(PureSpark, PureSpark.getUnlocalizedName().substring(5));
		BlocksMain.blockNames.add(PureSpark.getUnlocalizedName().substring(5));
		PureSpark.setHarvestLevel("pickaxe", 1);
		
		AcceleratedCrystalCluster = new AcceleratedCrystalCluster().setBlockName("AcceleratedCrystalCluster").setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerBlock(AcceleratedCrystalCluster, AcceleratedCrystalCluster.getUnlocalizedName().substring(5));
		BlocksMain.blockNames.add(AcceleratedCrystalCluster.getUnlocalizedName().substring(5));
		AcceleratedCrystalCluster.setHarvestLevel("pickaxe", 1);
		
		CorruptObelisk = new CorruptObelisk().setBlockName("CorruptObelisk").setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerBlock(CorruptObelisk, CorruptObelisk.getUnlocalizedName().substring(5));
		BlocksMain.blockNames.add(CorruptObelisk.getUnlocalizedName().substring(5));
		CorruptObelisk.setHarvestLevel("pickaxe", 1);
		
		NullManaPipe = new NullManaPipe().setBlockName("NullifiedManaPipe").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setLightLevel(1.0F).setBlockTextureName(References.texturelocation + ":" + "NullifiedManaPipe");
		GameRegistry.registerBlock(NullManaPipe, NullManaPipe.getUnlocalizedName().substring(5));
		BlocksMain.blockNames.add(NullManaPipe.getUnlocalizedName().substring(5));
		NullManaPipe.setHarvestLevel("pickaxe", 1);
		
		StaticManaPipe = new StaticManaPipe().setBlockName("StaticManaPipe").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setLightLevel(1.0F).setBlockTextureName(References.texturelocation + ":" + "StaticManaPipe");
		GameRegistry.registerBlock(StaticManaPipe, StaticManaPipe.getUnlocalizedName().substring(5));
		BlocksMain.blockNames.add(StaticManaPipe.getUnlocalizedName().substring(5));
		StaticManaPipe.setHarvestLevel("pickaxe", 1);
		
		ClusterManaPipe = new ClusterManaPipe().setBlockName("ClusterManaPipe").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setLightLevel(1.0F).setBlockTextureName(References.texturelocation + ":" + "ClusteredManaPipe");
		GameRegistry.registerBlock(ClusterManaPipe, ClusterManaPipe.getUnlocalizedName().substring(5));
		BlocksMain.blockNames.add(ClusterManaPipe.getUnlocalizedName().substring(5));
		ClusterManaPipe.setHarvestLevel("pickaxe", 1);
		
		ElementalManaPipe = new ElementalManaPipe().setBlockName("ElemenetalManaPipe").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setLightLevel(1.0F).setBlockTextureName(References.texturelocation + ":" + "ElementalManaPipe");
		GameRegistry.registerBlock(ElementalManaPipe, ElementalManaPipe.getUnlocalizedName().substring(5));
		BlocksMain.blockNames.add(ElementalManaPipe.getUnlocalizedName().substring(5));
		ElementalManaPipe.setHarvestLevel("pickaxe", 1);
		
		SolarManaGenerator = new SolarCrystalGenerator().setBlockName("SolarManaGenerator").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setLightLevel(1.0F).setBlockTextureName(References.texturelocation + ":" + "RuneSlotT1");
		GameRegistry.registerBlock(SolarManaGenerator, SolarManaGenerator.getUnlocalizedName().substring(5));
		BlocksMain.blockNames.add(SolarManaGenerator.getUnlocalizedName().substring(5));
		SolarManaGenerator.setHarvestLevel("pickaxe", 1);
		
		RuneSlotT1 = new BlockRuneSlotT1().setBlockName("RuneSlotT1").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setLightLevel(1.0F).setBlockTextureName(References.texturelocation + ":" + "RuneSlotT1");
		GameRegistry.registerBlock(RuneSlotT1, RuneSlotT1.getUnlocalizedName().substring(5));
		BlocksMain.blockNames.add(RuneSlotT1.getUnlocalizedName().substring(5));
		RuneSlotT1.setHarvestLevel("pickaxe", 2);
		
		RuneSlotT2 = new BlockRuneSlotT2().setBlockName("RuneSlotT2").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setLightLevel(1.0F).setBlockTextureName(References.texturelocation + ":" + "RuneSlotT2");
		GameRegistry.registerBlock(RuneSlotT2, RuneSlotT2.getUnlocalizedName().substring(5));
		BlocksMain.blockNames.add(RuneSlotT2.getUnlocalizedName().substring(5));
		RuneSlotT2.setHarvestLevel("pickaxe", 2);
		
		RuneSlotT3 = new BlockRuneSlotT3().setBlockName("RuneSlotT3").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setLightLevel(1.0F).setBlockTextureName(References.texturelocation + ":" + "RuneSlotT3");
		GameRegistry.registerBlock(RuneSlotT3, RuneSlotT3.getUnlocalizedName().substring(5));
		BlocksMain.blockNames.add(RuneSlotT3.getUnlocalizedName().substring(5));
		RuneSlotT3.setHarvestLevel("pickaxe", 2);
		
		RuneSlotT4 = new BlockRuneSlotT4().setBlockName("RuneSlotT4").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setLightLevel(1.0F).setBlockTextureName(References.texturelocation + ":" + "RuneSlotT4");
		GameRegistry.registerBlock(RuneSlotT4, RuneSlotT4.getUnlocalizedName().substring(5));
		BlocksMain.blockNames.add(RuneSlotT4.getUnlocalizedName().substring(5));
		RuneSlotT4.setHarvestLevel("pickaxe", 2);
		
		CrystalManaSource = new BlockCrystalManaSource().setBlockName("CrystalManaSource").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setLightLevel(1.0F).setBlockTextureName(References.texturelocation + ":" + "RunicUpgrade");
		GameRegistry.registerBlock(CrystalManaSource, CrystalManaSource.getUnlocalizedName().substring(5));
		BlocksMain.blockNames.add(CrystalManaSource.getUnlocalizedName().substring(5));
		CrystalManaSource.setHarvestLevel("pickaxe", 2);
		
		SpellCrafter = new BlockSpellCrafting().setBlockName("SpellCrafter").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setLightLevel(1.0F).setBlockTextureName(References.texturelocation + ":" + "RunicUpgrade");
		GameRegistry.registerBlock(SpellCrafter, SpellCrafter.getUnlocalizedName().substring(5));
		BlocksMain.blockNames.add(SpellCrafter.getUnlocalizedName().substring(5));
		SpellCrafter.setHarvestLevel("pickaxe", 2);
		
		NullifiedCrystal = new NullifiedCrystal().setBlockName("NullifiedCrystal").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setLightLevel(1.0F).setBlockTextureName(References.texturelocation + ":" + "RunicUpgrade");
		GameRegistry.registerBlock(NullifiedCrystal, NullifiedCrystal.getUnlocalizedName().substring(5));
		BlocksMain.blockNames.add(NullifiedCrystal.getUnlocalizedName().substring(5));
		NullifiedCrystal.setHarvestLevel("pickaxe", 2);
		
		StaticCrystal = new StaticCrystal().setBlockName("StaticCrystal").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setLightLevel(1.0F).setBlockTextureName(References.texturelocation + ":" + "RunicUpgrade");
		GameRegistry.registerBlock(StaticCrystal, StaticCrystal.getUnlocalizedName().substring(5));
		BlocksMain.blockNames.add(StaticCrystal.getUnlocalizedName().substring(5));
		StaticCrystal.setHarvestLevel("pickaxe", 2);
		
		CrystalCLuster = new CrystalCluster().setBlockName("CrystalCluster").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setLightLevel(1.0F).setBlockTextureName(References.texturelocation + ":" + "RunicUpgrade");
		GameRegistry.registerBlock(CrystalCLuster, CrystalCLuster.getUnlocalizedName().substring(5));
		BlocksMain.blockNames.add(CrystalCLuster.getUnlocalizedName().substring(5));
		CrystalCLuster.setHarvestLevel("pickaxe", 2);
		
		ChargedCrystalCluser = new ElementalCrystal().setBlockName("ElementalCrystal").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab).setLightLevel(1.0F).setBlockTextureName(References.texturelocation + ":" + "RunicUpgrade");
		GameRegistry.registerBlock(ChargedCrystalCluser, ChargedCrystalCluser.getUnlocalizedName().substring(5));
		BlocksMain.blockNames.add(ChargedCrystalCluser.getUnlocalizedName().substring(5));
		ChargedCrystalCluser.setHarvestLevel("pickaxe", 2);

		MagicalPlinth = new MagicalPlinth().setBlockName("MagicalPlinth").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerBlock(MagicalPlinth, MagicalPlinth.getUnlocalizedName().substring(5));
		BlocksMain.blockNames.add(MagicalPlinth.getUnlocalizedName().substring(5));
		MagicalPlinth.setHarvestLevel("pickaxe", 1);
		
		RitualAltar = new RitualAltar().setBlockName("RitualAltar").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerBlock(RitualAltar, RitualAltar.getUnlocalizedName().substring(5));
		BlocksMain.blockNames.add(RitualAltar.getUnlocalizedName().substring(5));
		RitualAltar.setHarvestLevel("pickaxe", 1);
		
		ArcaneCraftingSlot = new ArcaneCraftingSlot().setBlockName("ArcaneCraftingSlot").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerBlock(ArcaneCraftingSlot, ArcaneCraftingSlot.getUnlocalizedName().substring(5));
		BlocksMain.blockNames.add(ArcaneCraftingSlot.getUnlocalizedName().substring(5));
		ArcaneCraftingSlot.setHarvestLevel("pickaxe", 1);
		
		ArcaneCraftingAltar = new ArcaneCraftingAltar().setBlockName("ArcaneCraftingAltar").setHardness(3.0F).setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerBlock(ArcaneCraftingAltar, ArcaneCraftingAltar.getUnlocalizedName().substring(5));
		BlocksMain.blockNames.add(ArcaneCraftingAltar.getUnlocalizedName().substring(5));
		ArcaneCraftingAltar.setHarvestLevel("pickaxe", 1);
		
		
		
		
	}
}
