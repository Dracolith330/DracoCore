package dracocore.api.prefab.core;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.oredict.OreDictionary;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dracocore.blocks.blockclasses.general.BlocksGeneric;
import dracocore.blocks.blockclasses.general.block.BlockBase;

@SideOnly(Side.CLIENT)
public class ToolTipHandler
{

	/** Warning: do not add blocks to this array*/
	public static Block[] ModArray = new Block[] {BlocksGeneric.CoalVein};
	public static List<Item> ItemBlockList = new ArrayList<Item>();
	public static List<String> ItemBlockAspects = new ArrayList<String>();
	private String[] ores = OreDictionary.getOreNames();
    
    @SubscribeEvent
    public void handleItemTooltipEvent(ItemTooltipEvent event)
    {
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT))
        {
        	for(int x = 0; x < ModArray.length; x++)
        	{
        		if(event.itemStack != null && event.itemStack.getItem() == Item.getItemFromBlock(ModArray[x]))
        		{
                	event.toolTip.add(String.format("%s", ((BlockBase) ModArray[x]).tooltip));
        		}
        	}
        	for(int x = 0; x < ItemBlockList.size(); x++)
        	{
        		if(event.itemStack != null && event.itemStack.getItem() == ItemBlockList.get(x))
        		{
        			event.toolTip.add(ItemBlockAspects.get(x));
        		}
        	}
        	for (String ore : ores) 
        	{
        		if (OreDictionary.getOreIDs(event.itemStack).equals("ingotCopper"))
                {
        			for (ItemStack is : OreDictionary.getOres(ore))
        			{
        					event.toolTip.add("Metalum");
        			}
                }  
        	}
        }
    }
    /**Used to register aspects with items and blocks (plan to revamp this in favor of a similar system to that of thaumcraft)**/
    public static void registerToolTipAspects(Item item, String string)
    {
    	ItemBlockList.add(item);
    	ItemBlockAspects.add(string);
	}
}