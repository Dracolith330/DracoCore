package dracocore.handbook.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dracocore.References;
import dracocore.handbook.core.LexiconEntry;
import dracocore.handbook.gui.IGuiLexiconEntry;
import dracocore.items.general.ItemsGeneral;

public class PageRitualRecipe extends PageRecipe {

	
	String name;
	boolean oreDictRecipe, shapelessRecipe;
	int recipeAt = 0;
	List<Object> recipes = new ArrayList<Object>();
	
	static double Cost = 0;
    private RenderHelper resultRenderer;
	
	private static final ResourceLocation craftingOverlay = new ResourceLocation(
			References.modid, "textures/gui/dictionary/test.png");

	
	int ticksElapsed = 0;

	public PageRitualRecipe(String unlocalizedName, double cost, Item Center, Item slot1, Item slot2, Item slot3, Item slot4, Item slot5, Item slot6, Item slot7, Item slot8, Item slot9, Item slot10, Item slot11, Item slot12) {
		super(unlocalizedName);
		recipes.add(0, new ItemStack(Center));
    	recipes.add(1, new ItemStack(slot1));
    	recipes.add(2, new ItemStack(slot2));
    	recipes.add(3, new ItemStack(slot3));
    	recipes.add(4, new ItemStack(slot4));
    	recipes.add(5, new ItemStack(slot5));
    	recipes.add(6, new ItemStack(slot6));
    	recipes.add(7, new ItemStack(slot7));
    	recipes.add(8, new ItemStack(slot8));
    	recipes.add(9, new ItemStack(slot9));
    	recipes.add(10, new ItemStack(slot10));
    	recipes.add(11, new ItemStack(slot11));
    	recipes.add(12, new ItemStack(slot12));
    	this.Cost = cost;
    	for(int x = 14; x <= recipes.size(); x++)
		{
			recipes.remove(x);
		}
	}
	
	public void drawCenteredStringNoShadow(FontRenderer par1FontRenderer,
			String par2Str, int par3, int par4, int par5) {
		par1FontRenderer.drawString(par2Str,
				par3 - (par1FontRenderer.getStringWidth(par2Str) / 2), par4,
				par5);
	}

	void drawHeader(FontRenderer font, GuiScreen gui, String string) {
		final boolean unicode = font.getUnicodeFlag();
		font.setUnicodeFlag(true);

		//drawCenteredStringNoShadow(
				//font,
				//string,
				//((IGuiLexiconEntry) gui).getLeft()
						//+ font.getStringWidth(string),
				//((IGuiLexiconEntry) gui).getTop() + 10, 0);

		font.setUnicodeFlag(unicode);
	}

	@Override
	public void onPageAdded(LexiconEntry entry, int index) {
	}

	@SideOnly(Side.CLIENT)
	public void renderCraftingRecipe(IGuiLexiconEntry gui, IRecipe recipe) {
		if (recipe instanceof ShapedRecipes) {
			final ShapedRecipes shaped = (ShapedRecipes) recipe;

			for (int y = 0; y < shaped.recipeHeight; y++)
				for (int x = 0; x < shaped.recipeWidth; x++)
					renderItemAtGridPos(gui, 1 + x, 1 + y,
							shaped.recipeItems[(y * shaped.recipeWidth) + x],
							true);
		} else if (recipe instanceof ShapedOreRecipe) {
			final ShapedOreRecipe shaped = (ShapedOreRecipe) recipe;
			final int width = (Integer) ReflectionHelper.getPrivateValue(
					ShapedOreRecipe.class, shaped, 4);
			final int height = (Integer) ReflectionHelper.getPrivateValue(
					ShapedOreRecipe.class, shaped, 5);

			for (int y = 0; y < height; y++)
				for (int x = 0; x < width; x++) {
					final Object input = shaped.getInput()[(y * width) + x];
					if (input != null)
						renderItemAtGridPos(
								gui,
								1 + x,
								1 + y,
								input instanceof ItemStack ? (ItemStack) input
										: ((ArrayList<ItemStack>) input).get(0),
								true);
				}

			oreDictRecipe = true;
		} else if (recipe instanceof ShapelessRecipes) {
			final ShapelessRecipes shapeless = (ShapelessRecipes) recipe;

			drawGrid: {
				for (int y = 0; y < 3; y++)
					for (int x = 0; x < 3; x++) {
						final int index = (y * 3) + x;

						if (index >= shapeless.recipeItems.size())
							break drawGrid;

						renderItemAtGridPos(gui, 1 + x, 1 + y,
								(ItemStack) shapeless.recipeItems.get(index),
								true);
					}
			}

			shapelessRecipe = true;
		} else if (recipe instanceof ShapelessOreRecipe) {
			final ShapelessOreRecipe shapeless = (ShapelessOreRecipe) recipe;

			drawGrid: {
				for (int y = 0; y < 3; y++)
					for (int x = 0; x < 3; x++) {
						final int index = (y * 3) + x;

						if (index >= shapeless.getRecipeSize())
							break drawGrid;

						final Object input = shapeless.getInput().get(index);
						if (input != null)
							renderItemAtGridPos(
									gui,
									1 + x,
									1 + y,
									input instanceof ItemStack ? (ItemStack) input
											: ((ArrayList<ItemStack>) input)
													.get(0), true);
					}
			}

			shapelessRecipe = true;
			oreDictRecipe = true;
		}

		renderItemAtGridPos(gui, 2, 0, recipe.getRecipeOutput(), false);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void renderRecipe(IGuiLexiconEntry gui, int mx, int my) {

		final FontRenderer fontRendererObj = ((GuiScreen) gui).mc.fontRenderer;
		final String cost = "" + Cost;
		
		final boolean unicode = fontRendererObj.getUnicodeFlag();
		fontRendererObj.setUnicodeFlag(true);

		final String title = StatCollector
				.translateToLocal("dracocore.gui.dictionary.multiblock");
		drawCenteredStringNoShadow(fontRendererObj, title, gui.getLeft()
				+ fontRendererObj.getStringWidth(title), gui.getTop() + 10, 0);
		
		drawCenteredStringNoShadow(fontRendererObj, "Cost: " + cost, gui.getLeft()
				+ fontRendererObj.getStringWidth(title) - 50, gui.getTop() + 140, 0);
		
		
		fontRendererObj.setUnicodeFlag(unicode);

		oreDictRecipe = shapelessRecipe = false;

		final TextureManager render = Minecraft.getMinecraft().renderEngine;
		//render.bindTexture(craftingOverlay);

		
		
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glColor4f(1F, 1F, 1F, 1F);
		//((GuiScreen) gui).drawTexturedModalRect(gui.getLeft(),
		//		gui.getTop() + 10, 0, 0, gui.getWidth(), gui.getHeight());

		int iconX = gui.getLeft() + 115;
		final int iconY = gui.getTop() + 12 + 10;

		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

		//render.bindTexture(craftingOverlay);
		
		renderItemAtGridPos(gui, 2, 1.5, (ItemStack) recipes.get(0), true);
		renderItemAtGridPos(gui, 2, 0.1, (ItemStack) recipes.get(1), true);
		renderItemAtGridPos(gui, 2, 2.9, (ItemStack) recipes.get(7), true);

		renderItemAtGridPos(gui, 3.4, 1.5, (ItemStack) recipes.get(4), true);
		renderItemAtGridPos(gui, 0.6, 1.5, (ItemStack) recipes.get(10), true);
		
		renderItemAtGridPos(gui, 2.8, 0.1, (ItemStack) recipes.get(2), true);
		renderItemAtGridPos(gui, 2.8, 2.9, (ItemStack) recipes.get(6), true);
		
		renderItemAtGridPos(gui, 3.4, 0.7, (ItemStack) recipes.get(3), true);
		renderItemAtGridPos(gui, 0.6, 0.7, (ItemStack) recipes.get(11), true);
		
		renderItemAtGridPos(gui, 1.2, 0.1, (ItemStack) recipes.get(12), true);
		renderItemAtGridPos(gui, 1.2, 2.9, (ItemStack) recipes.get(8), true);
		
		renderItemAtGridPos(gui, 3.4, 2.3, (ItemStack) recipes.get(5), true);
		renderItemAtGridPos(gui, 0.6, 2.3, (ItemStack) recipes.get(9), true);
		
		
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void updateScreen() {
		if ((ticksElapsed % 20) == 0) {
			recipeAt++;

			if (recipeAt == recipes.size())
				recipeAt = 0;
		}
		++ticksElapsed;
	}
}
