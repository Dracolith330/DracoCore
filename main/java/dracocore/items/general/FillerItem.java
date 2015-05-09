package dracocore.items.general;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dracocore.References;

public class FillerItem extends Item {

	public FillerItem() {
		super();
	}

	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {

		itemIcon = iconRegister.registerIcon(References.texturelocation
				 + ":" + "16x/"
				+ this.getUnlocalizedName().substring(
						this.getUnlocalizedName().indexOf(".") + 1));}
	
	
}
