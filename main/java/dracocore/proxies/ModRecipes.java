package dracocore.proxies;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.ShapedOreRecipe;
import dracocore.CoreMain;
import dracocore.api.mana.RitualEffect;
import dracocore.api.mana.Rituals;
import dracocore.blocks.blockclasses.mana.BlocksMagic;
import dracocore.blocks.recipes.ArcaneCraftingRecipes;
import dracocore.items.general.ItemsGeneral;
import dracocore.proxies.helpers.rituals.GaiasGiftEffect;

public class ModRecipes 
{
	public static IRecipe encyclopediaDraconia;
	
	public static void init()
	{
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(ItemsGeneral.Dictionary, 1), "FBF", "GIG", 'F', Items.feather, 'B', Items.book, 'I', new ItemStack(Items.dye, 1, 0), 'G', "ingotGold"));
		encyclopediaDraconia = CoreMain.getLatestAddedRecipe();
		
		//GameRegistry.addRecipe(new ItemStack(Item.getItemFromBlock(Blocks.iron_block), 1), new Object [] {"BIB", "SHS", "I", 'B', Item.getItemFromBlock(Blocks.iron_block), 'I', Items.iron_ingot, 'S', Items.stick, 'H', Item.getItemFromBlock(Blocks.iron_block)});
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Item.getItemFromBlock(Blocks.iron_block), 1), "S", 'S', ItemsGeneral.Gear));
		
		ArcaneCraftingRecipes.registerArcaneCraftingRecipe("UpgradeRuneT1", 50, 64000, Item.getItemFromBlock(Blocks.dragon_egg), ItemsGeneral.FakeItem, Items.gold_ingot, Item.getItemFromBlock(Blocks.stonebrick), Item.getItemFromBlock(Blocks.stonebrick), Items.gold_ingot, Items.ender_pearl, Items.ender_pearl, Items.gold_ingot, Item.getItemFromBlock(Blocks.stonebrick), Item.getItemFromBlock(Blocks.stonebrick), Items.gold_ingot, Items.ender_pearl, Item.getItemFromBlock(BlocksMagic.RuneSlotT1));
		ArcaneCraftingRecipes.registerArcaneCraftingRecipe("UpgradeRuneT2", 50, 64000, Item.getItemFromBlock(BlocksMagic.RuneSlotT1), Items.ender_pearl, Items.gold_ingot, Item.getItemFromBlock(Blocks.iron_block), Item.getItemFromBlock(Blocks.iron_block), Items.gold_ingot, Items.ender_pearl, Items.ender_pearl, Items.gold_ingot, Item.getItemFromBlock(Blocks.iron_block), Item.getItemFromBlock(Blocks.iron_block), Items.gold_ingot, Items.ender_pearl, Item.getItemFromBlock(BlocksMagic.RuneSlotT2));
		ArcaneCraftingRecipes.registerArcaneCraftingRecipe("UpgradeRuneT3", 50, 64000, Item.getItemFromBlock(BlocksMagic.RuneSlotT2), Items.ender_pearl, Items.gold_ingot, Item.getItemFromBlock(Blocks.gold_block), Item.getItemFromBlock(Blocks.gold_block), Items.gold_ingot, Items.ender_pearl, Items.ender_pearl, Items.gold_ingot, Item.getItemFromBlock(Blocks.gold_block), Item.getItemFromBlock(Blocks.gold_block), Items.gold_ingot, Items.ender_pearl, Item.getItemFromBlock(BlocksMagic.RuneSlotT3));
		ArcaneCraftingRecipes.registerArcaneCraftingRecipe("UpgradeRuneT4", 50, 64000, Item.getItemFromBlock(BlocksMagic.RuneSlotT3), Items.ender_pearl, Items.gold_ingot, Item.getItemFromBlock(Blocks.diamond_block), Item.getItemFromBlock(Blocks.diamond_block), Items.gold_ingot, Items.ender_pearl, Items.ender_pearl, Items.gold_ingot, Item.getItemFromBlock(Blocks.diamond_block), Item.getItemFromBlock(Blocks.diamond_block), Items.gold_ingot, Items.ender_pearl, Item.getItemFromBlock(BlocksMagic.RuneSlotT4));
		
		Rituals.registerRitualEffect("GaiasGift", 14, 500, Items.diamond_pickaxe, ItemsGeneral.FakeItem, Items.ender_pearl, Items.ender_pearl, Items.ender_pearl, Items.ender_pearl, Items.ender_pearl, Items.ender_pearl, Items.ender_pearl, Items.ender_pearl, Items.ender_pearl, Items.ender_pearl, Items.ender_pearl, new GaiasGiftEffect());
		
		
		
		
		
	}
	
}
