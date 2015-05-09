package dracocore.blocks.renders.itemrenders.mana.upgrade;

import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import dracocore.blocks.models.ModelMagicalPlinth;
import dracocore.blocks.tileentity.mana.upgrade.TileEntityRunicUpgradeT3;

public class ItemRunicUpgradeT3Render implements IItemRenderer {

	private ModelMagicalPlinth InfuserModel;

	public ItemRunicUpgradeT3Render() {

		InfuserModel = new ModelMagicalPlinth();
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
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityRunicUpgradeT3(), 0.0D, 0.0D, 0.0D, 0.0F);
	}
}