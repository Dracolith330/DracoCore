package dracocore.items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.resources.I18n;
import dracocore.items.general.ItemsGeneral;
import dracocore.items.mana.ItemsMana;
import dracocore.items.power.ItemsPower;

public class ItemsMain 
{
	public static final String[] MetalTypes = new String[] {"Copper", "Silver", "Tin", "Bronze", "Lead", "Cobalt", "Platinum", "Uranium"};
    
	
	public static final List<String> itemNames = new ArrayList<String>();
	
	public static void init()
	{
		
		ItemsGeneral.init();
		ItemsMana.init();
		ItemsPower.init();
		
		for(int i = 0; i < itemNames.size(); i++)
		{
			I18n.format("item." + itemNames.get(i) + ".name", new Object[0]);
		}
	}
}
