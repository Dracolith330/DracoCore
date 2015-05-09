package dracocore.blocks.renders.itemrenders.mana.generator;

import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import dracocore.blocks.blockclasses.mana.TileAcceleratedCrystalCluster;
import dracocore.blocks.blockclasses.mana.TileCorruptObelisk;

public class ItemAcceleratedCrystalClusterRender implements IItemRenderer {


	public ItemAcceleratedCrystalClusterRender() {

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
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileAcceleratedCrystalCluster(), 0.0D, 0.0D, 0.0D, 0.0F);
	}
}