package dracocore.blocks.renders.itemrenders.mana.generator;

import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import dracocore.blocks.tileentity.mana.generator.TileEntitySolarManaGenerator;

public class ItemSolarCrystalGenRender implements IItemRenderer {


	public ItemSolarCrystalGenRender() {

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
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntitySolarManaGenerator(), 0.0D, 0.0D, 0.0D, 0.0F);
	}
}