package dracocore.proxies;

import java.util.HashMap;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;
import thaumcraft.api.ItemApi;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import cpw.mods.fml.common.event.FMLInterModComms;
import dracocore.References;
import dracocore.blocks.blockclasses.general.BlocksGeneric;
import dracocore.interfaces.RetroResearchItem;
import dracocore.items.ItemsMain;
import dracocore.items.general.ItemsGeneral;
import dracocore.items.mana.ItemsMana;


public class InterModCompatability 
{

	static HashMap<String, Object> recipes = new HashMap();
	
	public static void init()
	{
		
		for(int i = 0; i < ItemsMain.MetalTypes.length; i++)
		{
			OreDictionary.registerOre("nugget" + ItemsMain.MetalTypes[i], new ItemStack(ItemsGeneral.Nugget, 1, i));
			OreDictionary.registerOre("ingot" + ItemsMain.MetalTypes[i], new ItemStack(ItemsGeneral.Ingot, 1, i));
			
		}

		OreDictionary.registerOre("oreCopper", new ItemStack(Item.getItemFromBlock(BlocksGeneric.CopperOre)));
		OreDictionary.registerOre("oreSilver", new ItemStack(Item.getItemFromBlock(BlocksGeneric.SilverOre)));
		OreDictionary.registerOre("oreTin", new ItemStack(Item.getItemFromBlock(BlocksGeneric.TinOre)));
		OreDictionary.registerOre("oreLead", new ItemStack(Item.getItemFromBlock(BlocksGeneric.LeadOre)));
		OreDictionary.registerOre("oreCobalt", new ItemStack(Item.getItemFromBlock(BlocksGeneric.CobaltOre)));
		OreDictionary.registerOre("orePlatinum", new ItemStack(Item.getItemFromBlock(BlocksGeneric.PlatinumOre)));
		OreDictionary.registerOre("oreUranium", new ItemStack(Item.getItemFromBlock(BlocksGeneric.UraniumOre)));
		
		OreDictionary.registerOre("blockCopper", new ItemStack(Item.getItemFromBlock(BlocksGeneric.CopperBlock)));
		OreDictionary.registerOre("blockSilver", new ItemStack(Item.getItemFromBlock(BlocksGeneric.SilverBlock)));
		OreDictionary.registerOre("blockTin", new ItemStack(Item.getItemFromBlock(BlocksGeneric.TinBlock)));
		OreDictionary.registerOre("blockBronze", new ItemStack(Item.getItemFromBlock(BlocksGeneric.BronzeBlock)));
		OreDictionary.registerOre("blockLead", new ItemStack(Item.getItemFromBlock(BlocksGeneric.LeadBlock)));
		OreDictionary.registerOre("blockCobalt", new ItemStack(Item.getItemFromBlock(BlocksGeneric.CobaltBlock)));
		OreDictionary.registerOre("blockPlatinum", new ItemStack(Item.getItemFromBlock(BlocksGeneric.PlatinumBlock)));
		OreDictionary.registerOre("blockUranium", new ItemStack(Item.getItemFromBlock(BlocksGeneric.UraniumBlock)));
		
		OreDictionary.registerOre("veinCopper", new ItemStack(Item.getItemFromBlock(BlocksGeneric.CopperVein)));
		OreDictionary.registerOre("veinSilver", new ItemStack(Item.getItemFromBlock(BlocksGeneric.SilverVein)));
		OreDictionary.registerOre("veinTin", new ItemStack(Item.getItemFromBlock(BlocksGeneric.TinVein)));
		OreDictionary.registerOre("veinLead", new ItemStack(Item.getItemFromBlock(BlocksGeneric.LeadVein)));
		OreDictionary.registerOre("veinCobalt", new ItemStack(Item.getItemFromBlock(BlocksGeneric.CobaltVein)));
		OreDictionary.registerOre("veinPlatinum", new ItemStack(Item.getItemFromBlock(BlocksGeneric.PlatinumVein)));
		OreDictionary.registerOre("veinUranium", new ItemStack(Item.getItemFromBlock(BlocksGeneric.UraniumVein)));
    	//CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(ItemsMain.Grill, 1, 3), "S", "", "", 'S', "nuggetCopper"));
		    	
		}
	
	public static void registerthaumcraftresearch()
	{
		      ResearchCategories.registerCategory("DracoCore", new ResourceLocation(References.texturelocation, "textures/items/dust.png"), new ResourceLocation("thaumcraft", "textures/gui/gui_researchback.png"));
		      new RetroResearchItem("RETROCRUCIBLE", "DracoCore", "CRUCIBLE", "ALCHEMY", -12, 0, ItemApi.getBlock("blockMetalDevice", 0)).setParents(new String[] { "DRACOCORECENTER" }).registerResearchItem();
		      new RetroResearchItem("RETROPUREIRON", "DracoCore", "PUREIRON", "ALCHEMY", -20, 0, ItemApi.getItem("itemNugget", 16)).setParents(new String[] { "RETROCRUCIBLE" }).registerResearchItem();
		      new RetroResearchItem("RETROMETALTRANSMUTE", "DracoCore", "TRANSIRON", "ALCHEMY", -12, -8, ItemApi.getItem("itemNugget", 0)).setParents(new String[] { "RETROCRUCIBLE" }).registerResearchItem();
		      new ResearchItem("DRACOCORECENTER", "DracoCore", new AspectList(), 0,  0, 1, new ItemStack(ItemsMana.ThaumNativeCluster, 1, 0)).setPages(new ResearchPage[] { new ResearchPage("dc.research_page.DRACOCORECENTER.1"), new ResearchPage("dc.research_page.DRACOCORECENTER.2"), new ResearchPage("dc.research_page.DRACOCORECENTER.3"), new ResearchPage("dc.research_page.DRACOCORECENTER.4"), new ResearchPage("dc.research_page.DRACOCORECENTER.5"), new ResearchPage("dc.research_page.DRACOCORECENTER.6"), new ResearchPage("dc.research_page.DRACOCORECENTER.7"), new ResearchPage("dc.research_page.DRACOCORECENTER.8")}).setSpecial().setAutoUnlock().registerResearchItem();
		      	      
		      new ResearchItem("PURECOBALT", "DracoCore", new AspectList().add(Aspect.METAL, 3).add(Aspect.ORDER, 3)    , -24,  1, 1, new ItemStack(ItemsMana.ThaumNativeCluster, 1, 0)).setPages(new ResearchPage[] { new ResearchPage("dc.research_page.PURECOBALT.1"), new ResearchPage((CrucibleRecipe)recipes.get("PureCobalt"))}).setParents(new String[] { "RETROPUREIRON" }).setConcealed().setSecondary().registerResearchItem();
		      new ResearchItem("PUREPLATINUM", "DracoCore", new AspectList().add(Aspect.METAL, 3).add(Aspect.ORDER, 3)  , -23,  2, 1, new ItemStack(ItemsMana.ThaumNativeCluster, 1, 2)).setPages(new ResearchPage[] { new ResearchPage("dc.research_page.PUREPLATINUM.1"), new ResearchPage((CrucibleRecipe)recipes.get("PurePlatinum"))}).setParents(new String[] { "RETROPUREIRON" }).setConcealed().setSecondary().registerResearchItem();
		      new ResearchItem("PUREURANIUM", "DracoCore", new AspectList().add(Aspect.METAL, 3).add(Aspect.ORDER, 3)   , -23,  3, 1, new ItemStack(ItemsMana.ThaumNativeCluster, 1, 5)).setPages(new ResearchPage[] { new ResearchPage("dc.research_page.PUREURANIUM.1"), new ResearchPage((CrucibleRecipe)recipes.get("PureUranium"))}).setParents(new String[] { "RETROPUREIRON" }).setConcealed().setSecondary().registerResearchItem();
		      
			  System.out.println("[DracoCore] - ... integration complete");
			  
			  /*
			  final AMAspect Faith = new AMAspect("Fides",0x0069d1, new Aspect[] {Aspect.AURA, Aspect.MAGIC});
			  HashMap<String, Object> recipes = new HashMap();
			  
			  recipes.put("INFUSERCORE", ThaumcraftApi.addInfusionCraftingRecipe("INFUSION", new ItemStack(ItemsMain.InfuserCore, 1, 0), 5, new AspectList().add(Aspect.MAGIC, 20).add(Aspect.MECHANISM, 20).add(Aspect.AURA, 20), new ItemStack(ItemsMain.ingotset1, 1, 11), new ItemStack[]{new ItemStack(Item.ingotIron), new ItemStack(Item.ingotIron), new ItemStack(Item.diamond), new ItemStack(BlocksMain.NaviGenerationblocks, 1, 7)}));
			  
			  
			  
		  */
	}
	
	public static void registerThaumcraftRecipesandAspects()
	{

	      
		  ThaumcraftApi.registerObjectTag(new ItemStack(ItemsGeneral.Casing), new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}, new AspectList().add(Aspect.METAL, 1));
		  ThaumcraftApi.registerObjectTag(new ItemStack(ItemsGeneral.Hammer),  new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}, new AspectList().add(Aspect.METAL, 3).add(Aspect.TOOL, 1));
		  ThaumcraftApi.registerObjectTag(new ItemStack(ItemsGeneral.Mold),  new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}, new AspectList().add(Aspect.METAL, 1));
		  ThaumcraftApi.registerObjectTag(new ItemStack(ItemsGeneral.Plate),  new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}, new AspectList().add(Aspect.METAL, 1));
		  ThaumcraftApi.registerObjectTag(new ItemStack(ItemsGeneral.Wire),  new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}, new AspectList().add(Aspect.METAL, 1));
		  ThaumcraftApi.registerObjectTag(new ItemStack(BlocksGeneric.CopperOre), new AspectList().add(Aspect.METAL, 3).add(Aspect.FIRE, 1));
		  ThaumcraftApi.registerObjectTag(new ItemStack(BlocksGeneric.LeadOre), new AspectList().add(Aspect.METAL, 3).add(Aspect.FIRE, 1));
		  ThaumcraftApi.registerObjectTag(new ItemStack(BlocksGeneric.PlatinumOre), new AspectList().add(Aspect.METAL, 3).add(Aspect.GREED, 1).add(Aspect.ELDRITCH, 2));
		  ThaumcraftApi.registerObjectTag(new ItemStack(BlocksGeneric.UraniumOre), new AspectList().add(Aspect.METAL, 3).add(Aspect.GREED, 4));
		  ThaumcraftApi.registerObjectTag(new ItemStack(BlocksGeneric.CobaltOre), new AspectList().add(Aspect.CRYSTAL, 3));
		  ThaumcraftApi.registerObjectTag(new ItemStack(BlocksGeneric.CopperBlock), new AspectList().add(Aspect.METAL, 5));
		  ThaumcraftApi.registerObjectTag(new ItemStack(BlocksGeneric.LeadBlock), new AspectList().add(Aspect.METAL, 5));
		  ThaumcraftApi.registerObjectTag(new ItemStack(BlocksGeneric.CobaltBlock), new AspectList().add(Aspect.METAL, 5));
		  ThaumcraftApi.registerObjectTag(new ItemStack(BlocksGeneric.BronzeBlock), new AspectList().add(Aspect.METAL, 5).add(Aspect.GREED, 3));
		  ThaumcraftApi.registerObjectTag(new ItemStack(BlocksGeneric.PlatinumBlock), new AspectList().add(Aspect.CRYSTAL, 3));
		  ThaumcraftApi.registerObjectTag(new ItemStack(BlocksGeneric.SilverBlock), new AspectList().add(Aspect.METAL, 3).add(Aspect.FIRE, 1));
		  ThaumcraftApi.registerObjectTag(new ItemStack(BlocksGeneric.TinBlock), new AspectList().add(Aspect.CRYSTAL, 3));
		  
		  
		  ThaumcraftApi.registerObjectTag(new ItemStack(ItemsGeneral.Ingot), new int[]{0, 2, 3, 4, 5, 8, 10}, new AspectList().add(Aspect.METAL, 3));
		  ThaumcraftApi.registerObjectTag(new ItemStack(ItemsGeneral.Ingot), new int[]{1, 7, 9, 11}, new AspectList().add(Aspect.METAL, 3).add(Aspect.GREED, 1));
		  ThaumcraftApi.registerObjectTag(new ItemStack(ItemsGeneral.Ingot), new int[]{6}, new AspectList().add(Aspect.METAL, 3).add(Aspect.ORDER, 1));
		  ThaumcraftApi.registerObjectTag(new ItemStack(ItemsGeneral.Ingot), new int[]{12}, new AspectList().add(Aspect.METAL, 3).add(Aspect.POISON, 1));
		  

		  ItemStack thaumclusters = ItemApi.getItem("itemNugget", 19);
				
		  //"Cobalt", "Nickel", "Platinum", "Tungsten", "Unobtainum", "Uranium", "Scandium", "Chromium", "Manganese", "Zinc", "Yttrium", "Zirconium", "Niobium", "Molybdenum", "Ruthenium", "Rhodium", "Palladium", "Cadmium", "Lutetium", "Hafnium", "Tantalum", "Rhenium", "Osmium", "Iridium", "Titanium"
		  FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Item.getIdFromItem(Item.getItemFromBlock(BlocksGeneric.SilverOre)) + ",0," + Item.getIdFromItem(thaumclusters.getItem()) + ",19,1.0");
		  FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Item.getIdFromItem(Item.getItemFromBlock(BlocksGeneric.TinOre)) + ",0," + Item.getIdFromItem(thaumclusters.getItem()) + ",18,1.0");
		  FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Item.getIdFromItem(Item.getItemFromBlock(BlocksGeneric.LeadOre)) + ",0," + Item.getIdFromItem(thaumclusters.getItem()) + ",20,1.0");
		  FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Item.getIdFromItem(Item.getItemFromBlock(BlocksGeneric.CopperOre)) + ",0," + Item.getIdFromItem(thaumclusters.getItem()) + ",17,1.0");
		  
		  FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Item.getIdFromItem(Item.getItemFromBlock(BlocksGeneric.CobaltOre)) + ",0," + Item.getIdFromItem(ItemsMana.ThaumNativeCluster) + ",0,1.0");
		  FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Item.getIdFromItem(Item.getItemFromBlock(BlocksGeneric.PlatinumOre)) + ",0," + Item.getIdFromItem(ItemsMana.ThaumNativeCluster) + ",2,1.0");
		  FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Item.getIdFromItem(Item.getItemFromBlock(BlocksGeneric.UraniumOre)) + ",0," + Item.getIdFromItem(ItemsMana.ThaumNativeCluster) + ",5,1.0");
				  
				  //"Copper", "Silver", "Tin", "Lead", "Cobalt", "Nickel", "Platinum", "Tungsten", "Unobtainum", "Uranium", "Scandium", "Chromium", "Manganese", "Zinc", "Yttrium", "Zirconium", "Niobium", "Molybdenum", "Ruthenium", "Rhodium", "Palladium", "Cadmium", "Lutetium", "Hafnium", "Tantalum", "Rhenium", "Osmium", "Iridium", "Mercury"
				  FurnaceRecipes.smelting().func_151394_a(new ItemStack(ItemsMana.ThaumNativeCluster, 1, 0), new ItemStack(ItemsGeneral.Ingot, 2, 7), 1.0F);
				  FurnaceRecipes.smelting().func_151394_a(new ItemStack(ItemsMana.ThaumNativeCluster, 1, 1), new ItemStack(ItemsGeneral.Ingot, 2, 9), 1.0F);
				  FurnaceRecipes.smelting().func_151394_a(new ItemStack(ItemsMana.ThaumNativeCluster, 1, 2), new ItemStack(ItemsGeneral.Ingot, 2, 10), 1.0F);
				  FurnaceRecipes.smelting().func_151394_a(new ItemStack(ItemsMana.ThaumNativeCluster, 1, 3), new ItemStack(ItemsGeneral.Ingot, 2, 11), 1.0F);
				  FurnaceRecipes.smelting().func_151394_a(new ItemStack(ItemsMana.ThaumNativeCluster, 1, 4), new ItemStack(ItemsGeneral.Ingot, 2, 11), 1.0F);
				  FurnaceRecipes.smelting().func_151394_a(new ItemStack(ItemsMana.ThaumNativeCluster, 1, 5), new ItemStack(ItemsGeneral.Ingot, 2, 12), 1.0F);
				  FurnaceRecipes.smelting().func_151394_a(new ItemStack(ItemsMana.ThaumNativeCluster, 1, 6), new ItemStack(ItemsGeneral.Ingot, 2, 13), 1.0F);
				  FurnaceRecipes.smelting().func_151394_a(new ItemStack(ItemsMana.ThaumNativeCluster, 1, 7), new ItemStack(ItemsGeneral.Ingot, 2, 14), 1.0F);
				  FurnaceRecipes.smelting().func_151394_a(new ItemStack(ItemsMana.ThaumNativeCluster, 1, 8), new ItemStack(ItemsGeneral.Ingot, 2, 15), 1.0F);
				  FurnaceRecipes.smelting().func_151394_a(new ItemStack(ItemsMana.ThaumNativeCluster, 1, 9), new ItemStack(ItemsGeneral.Ingot, 2, 16), 1.0F);
				  FurnaceRecipes.smelting().func_151394_a(new ItemStack(ItemsMana.ThaumNativeCluster, 1, 10), new ItemStack(ItemsGeneral.Ingot, 2, 17), 1.0F);
				  FurnaceRecipes.smelting().func_151394_a(new ItemStack(ItemsMana.ThaumNativeCluster, 1, 11), new ItemStack(ItemsGeneral.Ingot, 2, 18), 1.0F);
				  FurnaceRecipes.smelting().func_151394_a(new ItemStack(ItemsMana.ThaumNativeCluster, 1, 12), new ItemStack(ItemsGeneral.Ingot, 2, 19), 1.0F);
				  FurnaceRecipes.smelting().func_151394_a(new ItemStack(ItemsMana.ThaumNativeCluster, 1, 13), new ItemStack(ItemsGeneral.Ingot, 2, 20), 1.0F);
				  FurnaceRecipes.smelting().func_151394_a(new ItemStack(ItemsMana.ThaumNativeCluster, 1, 14), new ItemStack(ItemsGeneral.Ingot, 2, 21), 1.0F);
				  FurnaceRecipes.smelting().func_151394_a(new ItemStack(ItemsMana.ThaumNativeCluster, 1, 15), new ItemStack(ItemsGeneral.Ingot, 2, 22), 1.0F);
				  FurnaceRecipes.smelting().func_151394_a(new ItemStack(ItemsMana.ThaumNativeCluster, 1, 16), new ItemStack(ItemsGeneral.Ingot, 2, 23), 1.0F);
				  FurnaceRecipes.smelting().func_151394_a(new ItemStack(ItemsMana.ThaumNativeCluster, 1, 17), new ItemStack(ItemsGeneral.Ingot, 2, 24), 1.0F);
				  FurnaceRecipes.smelting().func_151394_a(new ItemStack(ItemsMana.ThaumNativeCluster, 1, 18), new ItemStack(ItemsGeneral.Ingot, 2, 25), 1.0F);
				  FurnaceRecipes.smelting().func_151394_a(new ItemStack(ItemsMana.ThaumNativeCluster, 1, 19), new ItemStack(ItemsGeneral.Ingot, 2, 26), 1.0F);
				  FurnaceRecipes.smelting().func_151394_a(new ItemStack(ItemsMana.ThaumNativeCluster, 1, 20), new ItemStack(ItemsGeneral.Ingot, 2, 27), 1.0F);
				  FurnaceRecipes.smelting().func_151394_a(new ItemStack(ItemsMana.ThaumNativeCluster, 1, 21), new ItemStack(ItemsGeneral.Ingot, 2, 28), 1.0F);
				  FurnaceRecipes.smelting().func_151394_a(new ItemStack(ItemsMana.ThaumNativeCluster, 1, 22), new ItemStack(ItemsGeneral.Ingot, 2, 29), 1.0F);
				  FurnaceRecipes.smelting().func_151394_a(new ItemStack(ItemsMana.ThaumNativeCluster, 1, 23), new ItemStack(ItemsGeneral.Ingot, 2, 30), 1.0F);
				  FurnaceRecipes.smelting().func_151394_a(new ItemStack(ItemsMana.ThaumNativeCluster, 1, 24), new ItemStack(ItemsGeneral.Ingot, 2, 31), 1.0F);
				  
				  
				  //"Copper", "Silver", "Tin", "Bronze", "Lead", "Titanium", "Steel", "Cobalt", "Nickel", "Platinum", "Tungsten", "Unobtainum", "Uranium", "Scandium", "Chromium", "Manganese", "Zinc", "Yttrium", "Zirconium", "Niobium", "Molybdenum", "Ruthenium", "Rhodium", "Palladium", "Cadmium", "Lutetium", "Hafnium", "Tantalum", "Rhenium", "Osmium", "Iridium", "Mercury"
				  
					 
				  recipes.put("PureCobalt", ThaumcraftApi.addCrucibleRecipe("PURECOBALT", new ItemStack(ItemsMana.ThaumNativeCluster, 1, 0), "oreCobalt", new AspectList().merge(Aspect.METAL, 1).merge(Aspect.ORDER, 1)));
				  recipes.put("PureNickel", ThaumcraftApi.addCrucibleRecipe("PURENICKEL", new ItemStack(ItemsMana.ThaumNativeCluster, 1, 1), "oreNickel", new AspectList().merge(Aspect.METAL, 1).merge(Aspect.ORDER, 1)));
				  recipes.put("PurePlatinum", ThaumcraftApi.addCrucibleRecipe("PUREPLATINUM", new ItemStack(ItemsMana.ThaumNativeCluster, 1, 2), "orePlatinum", new AspectList().merge(Aspect.METAL, 1).merge(Aspect.ORDER, 1)));
				  recipes.put("PureTungsten", ThaumcraftApi.addCrucibleRecipe("PURETUNGSTEN", new ItemStack(ItemsMana.ThaumNativeCluster, 1, 3), "oreTungsten", new AspectList().merge(Aspect.METAL, 1).merge(Aspect.ORDER, 1)));
				  recipes.put("PureUnobtainum", ThaumcraftApi.addCrucibleRecipe("PUREUNOBTAINUM", new ItemStack(ItemsMana.ThaumNativeCluster, 1, 4), "oreUnobtainum", new AspectList().merge(Aspect.METAL, 1).merge(Aspect.ORDER, 1)));
				  recipes.put("PureUranium", ThaumcraftApi.addCrucibleRecipe("PUREURANIUM", new ItemStack(ItemsMana.ThaumNativeCluster, 1, 5), "oreUranium", new AspectList().merge(Aspect.METAL, 1).merge(Aspect.ORDER, 1)));
				  recipes.put("PureScandium", ThaumcraftApi.addCrucibleRecipe("PURESCANDIUM", new ItemStack(ItemsMana.ThaumNativeCluster, 1, 6), "oreScandium", new AspectList().merge(Aspect.METAL, 1).merge(Aspect.ORDER, 1)));
				  recipes.put("PureChromium", ThaumcraftApi.addCrucibleRecipe("PURECHROMIUM", new ItemStack(ItemsMana.ThaumNativeCluster, 1, 7), "oreChromium", new AspectList().merge(Aspect.METAL, 1).merge(Aspect.ORDER, 1)));
				  recipes.put("PureManganese", ThaumcraftApi.addCrucibleRecipe("PUREMANGANESE", new ItemStack(ItemsMana.ThaumNativeCluster, 1, 8), "oreManganese", new AspectList().merge(Aspect.METAL, 1).merge(Aspect.ORDER, 1)));
				  recipes.put("PureZinc", ThaumcraftApi.addCrucibleRecipe("PUREZINC", new ItemStack(ItemsMana.ThaumNativeCluster, 1, 9), "oreZinc", new AspectList().merge(Aspect.METAL, 1).merge(Aspect.ORDER, 1)));
				  recipes.put("PureYttrium", ThaumcraftApi.addCrucibleRecipe("PUREYTTRIUM", new ItemStack(ItemsMana.ThaumNativeCluster, 1, 10), "oreYttrium", new AspectList().merge(Aspect.METAL, 1).merge(Aspect.ORDER, 1)));
				  recipes.put("PureZirconium", ThaumcraftApi.addCrucibleRecipe("PUREZIRCONIUM", new ItemStack(ItemsMana.ThaumNativeCluster, 1, 11), "oreZirconium", new AspectList().merge(Aspect.METAL, 1).merge(Aspect.ORDER, 1)));
				  recipes.put("PureNiobium", ThaumcraftApi.addCrucibleRecipe("PURENIOBIUM", new ItemStack(ItemsMana.ThaumNativeCluster, 1, 12), "oreNiobium", new AspectList().merge(Aspect.METAL, 1).merge(Aspect.ORDER, 1)));
				  recipes.put("PureMolybdenum", ThaumcraftApi.addCrucibleRecipe("PUREMOLYBDENUM", new ItemStack(ItemsMana.ThaumNativeCluster, 1, 13), "oreMolybdenum", new AspectList().merge(Aspect.METAL, 1).merge(Aspect.ORDER, 1)));
				  recipes.put("PureRuthenium", ThaumcraftApi.addCrucibleRecipe("PURERUTHENIUM", new ItemStack(ItemsMana.ThaumNativeCluster, 1, 14), "oreRuthenium", new AspectList().merge(Aspect.METAL, 1).merge(Aspect.ORDER, 1)));
				  recipes.put("PureRhodium", ThaumcraftApi.addCrucibleRecipe("PURERHODIUM", new ItemStack(ItemsMana.ThaumNativeCluster, 1, 15), "oreRhodium", new AspectList().merge(Aspect.METAL, 1).merge(Aspect.ORDER, 1)));
				  recipes.put("PurePalladium", ThaumcraftApi.addCrucibleRecipe("PUREPALLADIUM", new ItemStack(ItemsMana.ThaumNativeCluster, 1, 16), "orePalladium", new AspectList().merge(Aspect.METAL, 1).merge(Aspect.ORDER, 1)));
				  recipes.put("PureCadmium", ThaumcraftApi.addCrucibleRecipe("PURECADMIUM", new ItemStack(ItemsMana.ThaumNativeCluster, 1, 17), "oreCadmium", new AspectList().merge(Aspect.METAL, 1).merge(Aspect.ORDER, 1)));
				  recipes.put("PureLutetium", ThaumcraftApi.addCrucibleRecipe("PURELUTETIUM", new ItemStack(ItemsMana.ThaumNativeCluster, 1, 18), "oreLutetium", new AspectList().merge(Aspect.METAL, 1).merge(Aspect.ORDER, 1)));
				  recipes.put("PureHafnium", ThaumcraftApi.addCrucibleRecipe("PUREHAFNIUM", new ItemStack(ItemsMana.ThaumNativeCluster, 1, 19), "oreHafnium", new AspectList().merge(Aspect.METAL, 1).merge(Aspect.ORDER, 1)));
				  recipes.put("PureTantalum", ThaumcraftApi.addCrucibleRecipe("PURETANTALUM", new ItemStack(ItemsMana.ThaumNativeCluster, 1, 20), "oreTantalum", new AspectList().merge(Aspect.METAL, 1).merge(Aspect.ORDER, 1)));
				  recipes.put("PureRhenium", ThaumcraftApi.addCrucibleRecipe("PURERHENIUM", new ItemStack(ItemsMana.ThaumNativeCluster, 1, 21), "oreRhenium", new AspectList().merge(Aspect.METAL, 1).merge(Aspect.ORDER, 1)));
				  recipes.put("PureOsmium", ThaumcraftApi.addCrucibleRecipe("PUREOSMIUM", new ItemStack(ItemsMana.ThaumNativeCluster, 1, 22), "oreOsmium", new AspectList().merge(Aspect.METAL, 1).merge(Aspect.ORDER, 1)));
				  recipes.put("PureIridium", ThaumcraftApi.addCrucibleRecipe("PUREIRIDIUM", new ItemStack(ItemsMana.ThaumNativeCluster, 1, 23), "oreIridium", new AspectList().merge(Aspect.METAL, 1).merge(Aspect.ORDER, 1)));
				  recipes.put("PureTitanium", ThaumcraftApi.addCrucibleRecipe("PURETITANIUM", new ItemStack(ItemsMana.ThaumNativeCluster, 1, 24), "oreTitanium", new AspectList().merge(Aspect.METAL, 1).merge(Aspect.ORDER, 1)));
				  
	}
}