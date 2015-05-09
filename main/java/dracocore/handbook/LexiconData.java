/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 *
 * Botania is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 *
 * File Created @ [Jan 14, 2014, 9:12:15 PM (GMT)]
 */
package dracocore.handbook;

import net.minecraft.init.Items;
import net.minecraft.util.ResourceLocation;
import dracocore.CoreMain;
import dracocore.References;
import dracocore.handbook.core.BLexiconEntry;
import dracocore.handbook.core.DLexiconEntry;
import dracocore.handbook.core.LexiconCategory;
import dracocore.handbook.core.LexiconEntry;
import dracocore.handbook.pages.PageCraftingRecipe;
import dracocore.handbook.pages.PageImage;
import dracocore.handbook.pages.PageMultiBlock;
import dracocore.handbook.pages.PageRitualRecipe;
import dracocore.handbook.pages.PageText;
import dracocore.items.general.ItemsGeneral;
import dracocore.proxies.ModRecipes;



public final class LexiconData {

	static LexiconCategory categoryBasics;
	static LexiconCategory categoryMisc;
	static LexiconCategory categoryMagic;
	static LexiconCategory categoryTech;
	static LexiconCategory categoryRecipes;
	static LexiconCategory categoryRituals;
	static LexiconCategory categoryMultiBlocks;
	public static LexiconCategory categoryMagiTech;
	
	private static LexiconEntry handbook;
	
	public static void preinit()
	{
		categoryBasics = CategoryManager.categoryBasics = new LexiconCategory("Basics").setPriority(9).setIcon(new ResourceLocation(References.texturelocation + ":" + "textures/gui/basics.png"));
    	categoryMisc = CategoryManager.categoryMisc = new LexiconCategory("Mechanics").setPriority(1).setIcon(new ResourceLocation(References.texturelocation + ":" + "textures/gui/misc.png"));
    	categoryMagic = CategoryManager.categoryMagic = new LexiconCategory("Magic").setPriority(8).setIcon(new ResourceLocation(References.texturelocation + ":" + "textures/gui/magic.png"));
    	categoryTech = CategoryManager.categoryTech = new LexiconCategory("Tech").setPriority(6).setIcon(new ResourceLocation(References.texturelocation + ":" + "textures/gui/tech.png"));
    	categoryRecipes = CategoryManager.categoryRecipes = new LexiconCategory("Recipes").setPriority(5).setIcon(new ResourceLocation(References.texturelocation + ":" + "textures/gui/recipes.png"));
    	categoryRituals = CategoryManager.categoryRituals = new LexiconCategory("Rituals").setPriority(7).setIcon(new ResourceLocation(References.texturelocation + ":" + "textures/gui/rituals.png"));
    	categoryMultiBlocks = CategoryManager.categoryMultiBlocks = new LexiconCategory("MultiBlocks").setPriority(2).setIcon(new ResourceLocation(References.texturelocation + ":" + "textures/gui/multiblocks.png"));
        categoryMagiTech = CategoryManager.categoryMagiTech = new LexiconCategory("MagiTech").setPriority(0).setKnowledgeType(CoreMain.draconianKnowledge).setIcon(new ResourceLocation(References.texturelocation + ":" + "textures/gui/multiblocks.png"));
    	CategoryManager.addCategory(categoryBasics);
        CategoryManager.addCategory(categoryMisc);
        CategoryManager.addCategory(categoryRecipes);
        CategoryManager.addCategory(categoryMagic);
        CategoryManager.addCategory(categoryTech);
        CategoryManager.addCategory(categoryRituals);
        CategoryManager.addCategory(categoryMultiBlocks);
        CategoryManager.addCategory(categoryMagiTech);
        //CoreMain.addCategory(categoryMagic = new BLexiconCategory("magic", 8));
        //CoreMain.addCategory(categoryTech = new BLexiconCategory("tech", 8));
        //CoreMain.addCategory(categoryRecipes = new BLexiconCategory("recipes", 8));
        //CoreMain.addCategory(categoryMultiBlocks = new BLexiconCategory("multiblocks", 7));
        //CoreMain.addCategory(categoryMisc = new BLexiconCategory("misc", 5));
      	//CoreMain.addCategory(categoryRituals = new BLexiconCategory("rituals", 8));
        
		
	}
	
    public static void init() 
    {
        //Add categories
    	
      	new BLexiconEntry("Welcome", categoryBasics).setPriority().setLexiconPages(new PageText("0"), new PageImage("1", References.texturelocation + ":" + "textures/gui/EncyclopediaDraconia.png"), new PageText("2"), new PageText("3"));
      	
      	new BLexiconEntry("EncyclopediaDraconia", categoryBasics).setLexiconPages(new PageCraftingRecipe("0", ModRecipes.encyclopediaDraconia));
      	
      	new BLexiconEntry("ManaPipes", categoryMisc).setPriority().setLexiconPages(new PageText("0"), new PageText("1"), new PageText("2"), new PageText("3"));
      	//new BLexiconEntry("Wire", categoryMisc).setPriority().setLexiconPages(new PageText("0"), new PageCraftingRecipe("1", null), new PageText("2"), new PageText("3"));
      	
      	new BLexiconEntry("RitualofGaiasGift", categoryRituals).setLexiconPages(new PageText("0"), new PageRitualRecipe("1", 500, Items.diamond_pickaxe, ItemsGeneral.FakeItem, Items.ender_pearl, Items.ender_pearl, Items.ender_pearl, Items.ender_pearl, Items.ender_pearl, Items.ender_pearl, Items.ender_pearl, Items.ender_pearl, Items.ender_pearl, Items.ender_pearl, Items.ender_pearl));
    
      	new BLexiconEntry("InterestingPatterns", categoryMultiBlocks).setLexiconPages(new PageText("0"), new PageText("1"), new PageText("2"), new PageText("3"), new PageMultiBlock("4", References.texturelocation + ":" + "textures/gui/strangePatterns.png"));
      	
      	new DLexiconEntry("MagiTechOpening", categoryMagiTech).setPriority().setLexiconPages(new PageText("0"));
    
    
    
    }

    public static void postInit() {
    }
}

