package dracocore.blocks.renders.itemrenders.mana.generator;

import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import dracocore.blocks.blockclasses.mana.TilePureSpark;

public class ItemPureSparkRender implements IItemRenderer {


	public ItemPureSparkRender() {

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
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TilePureSpark(), 0.0D, 0.0D, 0.0D, 0.0F);
	}
}