package dracocore.blocks;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.resources.I18n;
import dracocore.blocks.blockclasses.general.BlocksGeneric;
import dracocore.blocks.blockclasses.mana.BlocksMagic;
import dracocore.blocks.blockclasses.power.BlocksTech;



public class BlocksMain 
{
	
	public static final List<String> blockNames = new ArrayList<String>();
	
	public static void init()
	{
		BlocksGeneric.init();
		BlocksMagic.init();
		BlocksTech.init();
		
		for(int i = 0; i < blockNames.size(); i++)
		{
			
			I18n.format("tile." + blockNames.get(i) + ".name", new Object[0]);
			
		}
		
		
	
	}
	
	
	
	
	
}
