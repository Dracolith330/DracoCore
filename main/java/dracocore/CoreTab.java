package dracocore;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import dracocore.blocks.blockclasses.general.BlocksGeneric;

public final class CoreTab extends CreativeTabs
{
	public CoreTab(int par1, String par2Str)
	{
		super(par1, par2Str);
		this.setBackgroundImageName("item_search.png");
	}



	public String getTranslatedTabLabel()
	{
		return "Draco Core";
	}

	@Override
	public boolean hasSearchBar() {
		return true;
	}
	
	@Override
	public Item getTabIconItem() 
	{
		return Item.getItemFromBlock(BlocksGeneric.CopperOre);
	}
}
