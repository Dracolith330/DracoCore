package dracocore.blocks.renders.itemrenders.mana.storage;

import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import dracocore.blocks.tileentity.mana.storage.TileEntityElementalCrystal;
import dracocore.blocks.tileentity.mana.storage.TileNulifiedCrystal;

public class ItemNullifiedCrystalRender implements IItemRenderer {


	public ItemNullifiedCrystalRender() {

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
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileNulifiedCrystal(), 0.0D, 0.0D, 0.0D, 0.0F);
	}
}