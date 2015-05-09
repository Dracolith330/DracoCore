package dracocore.blocks.recipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ArcaneCraftingRecipes 
{

	private static Map<String, List<Object>> craftingRecipes = new HashMap<String, List<Object>>();
    
	
	
	
	
	public static void registerArcaneCraftingRecipe(String recipename, int activationCost, int timer, Item Catalyst, Item Slot1, Item Slot2, Item Slot3, Item Slot4, Item Slot5, Item Slot6, Item Slot7, Item Slot8, Item Slot9, Item Slot10, Item Slot11, Item Slot12, Item Result)
    {
    	List<Object> recipe = new ArrayList<Object>();
    	recipe.add(0, new ItemStack(Catalyst));
    	recipe.add(1, new ItemStack(Slot1));
    	recipe.add(2, new ItemStack(Slot2));
    	recipe.add(3, new ItemStack(Slot3));
    	recipe.add(4, new ItemStack(Slot4));
    	recipe.add(5, new ItemStack(Slot5));
    	recipe.add(6, new ItemStack(Slot6));
    	recipe.add(7, new ItemStack(Slot7));
    	recipe.add(8, new ItemStack(Slot8));
    	recipe.add(9, new ItemStack(Slot9));
    	recipe.add(10, new ItemStack(Slot10));
    	recipe.add(11, new ItemStack(Slot11));
    	recipe.add(12, new ItemStack(Slot12));
    	recipe.add(13, new ItemStack(Result));
    	recipe.add(14, activationCost);
    	recipe.add(15, timer);
    	
    	
    	craftingRecipes.put(recipename, recipe);
    }
    
    public ItemStack getCraftingResult(ItemStack item)
    {
        Iterator iterator = this.craftingRecipes.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.checkRecipe(item, (ItemStack)entry.getKey()));

        return (ItemStack)entry.getValue();
    }
    
    public static Set<Entry<String, List<Object>>> getCraftingList()
    {
        return craftingRecipes.entrySet();
    }
    
	private boolean checkRecipe(ItemStack name, ItemStack item)
    {
        return item.getItem() == name.getItem() && (item.getItemDamage() == 32767 || item.getItemDamage() == name.getItemDamage());
    }
}
