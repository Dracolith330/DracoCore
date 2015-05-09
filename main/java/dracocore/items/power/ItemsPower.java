package dracocore.items.power;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
import dracocore.CoreMain;
import dracocore.items.ItemsMain;
import dracocore.items.general.FillerItem;
import dracocore.items.general.multiItem;

public class ItemsPower 
{
	public static Item EmptyCell;
	public static Item MachineistsToolBox;
	
	
	
	
	public static void init()
	{
		EmptyCell = (new FillerItem().setUnlocalizedName("EmptyCell").setCreativeTab(CoreMain.CoreTab));
		GameRegistry.registerItem(EmptyCell, EmptyCell.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(EmptyCell.getUnlocalizedName().substring(5));
		

		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
}
