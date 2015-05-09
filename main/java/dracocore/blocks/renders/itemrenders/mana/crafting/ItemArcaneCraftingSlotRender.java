package dracocore.blocks.renders.itemrenders.mana.crafting;

import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import dracocore.blocks.models.ModelArcaneCraftingSlot;
import dracocore.blocks.tileentity.mana.crafting.TileEntityArcaneCraftingSlot;

public class ItemArcaneCraftingSlotRender implements IItemRenderer {

	private ModelArcaneCraftingSlot InfuserModel;

	public ItemArcaneCraftingSlotRender() {

		InfuserModel = new ModelArcaneCraftingSlot();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {

		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {

		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityArcaneCraftingSlot(), 0.0D, 0.0D, 0.0D, 0.0F);
	}
}