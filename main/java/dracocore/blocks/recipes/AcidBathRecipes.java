package dracocore.blocks.recipes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import dracocore.items.general.ItemsGeneral;

public class AcidBathRecipes
{
    private static final AcidBathRecipes smeltingBase = new AcidBathRecipes();
    /**
     * The list of smelting results.
     */
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();
    private static final String __OBFID = "CL_00000085";

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static AcidBathRecipes smelting()
    {
        return smeltingBase;
    }

    private AcidBathRecipes()
    {
    
    	this.func_151394_a(new ItemStack(ItemsGeneral.Dust, 1, 0),  new ItemStack(ItemsGeneral.CrushedPureOre, 2, 0), 0.5F);
    	this.func_151394_a(new ItemStack(ItemsGeneral.Dust, 1, 1),  new ItemStack(ItemsGeneral.CrushedPureOre, 2, 1), 0.5F);
    	this.func_151394_a(new ItemStack(ItemsGeneral.Dust, 1, 2),  new ItemStack(ItemsGeneral.CrushedPureOre, 2, 2), 0.5F);
    	this.func_151394_a(new ItemStack(ItemsGeneral.Dust, 1, 3),  new ItemStack(ItemsGeneral.CrushedPureOre, 2, 3), 0.5F);
    	this.func_151394_a(new ItemStack(ItemsGeneral.Dust, 1, 4),  new ItemStack(ItemsGeneral.CrushedPureOre, 2, 4), 0.5F);
    	this.func_151394_a(new ItemStack(ItemsGeneral.Dust, 1, 5),  new ItemStack(ItemsGeneral.CrushedPureOre, 2, 5), 0.5F);
    	this.func_151394_a(new ItemStack(ItemsGeneral.Dust, 1, 6),  new ItemStack(ItemsGeneral.CrushedPureOre, 2, 6), 0.5F);
    	this.func_151394_a(new ItemStack(ItemsGeneral.Dust, 1, 7),  new ItemStack(ItemsGeneral.CrushedPureOre, 2, 7), 0.5F);
    	this.func_151394_a(new ItemStack(ItemsGeneral.Dust, 1, 8),  new ItemStack(ItemsGeneral.CrushedPureOre, 2, 8), 0.5F);
    	
    }

    public void func_151393_a(Block p_151393_1_, ItemStack p_151393_2_, float p_151393_3_)
    {
        this.func_151396_a(Item.getItemFromBlock(p_151393_1_), p_151393_2_, p_151393_3_);
    }

    public void func_151396_a(Item p_151396_1_, ItemStack p_151396_2_, float p_151396_3_)
    {
        this.func_151394_a(new ItemStack(p_151396_1_, 1, 32767), p_151396_2_, p_151396_3_);
    }

    public void func_151394_a(ItemStack p_151394_1_, ItemStack p_151394_2_, float p_151394_3_)
    {
        this.smeltingList.put(p_151394_1_, p_151394_2_);
        this.experienceList.put(p_151394_2_, Float.valueOf(p_151394_3_));
    }

    /**
     * Returns the smelting result of an item.
     */
    public ItemStack getSmeltingResult(ItemStack p_151395_1_)
    {
        Iterator iterator = this.smeltingList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.func_151397_a(p_151395_1_, (ItemStack)entry.getKey()));

        return (ItemStack)entry.getValue();
    }

    private boolean func_151397_a(ItemStack p_151397_1_, ItemStack p_151397_2_)
    {
        return p_151397_2_.getItem() == p_151397_1_.getItem() && (p_151397_2_.getItemDamage() == 32767 || p_151397_2_.getItemDamage() == p_151397_1_.getItemDamage());
    }

    public Map getSmeltingList()
    {
        return this.smeltingList;
    }

    public float func_151398_b(ItemStack p_151398_1_)
    {
        float ret = p_151398_1_.getItem().getSmeltingExperience(p_151398_1_);
        if (ret != -1) return ret;

        Iterator iterator = this.experienceList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return 0.0F;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.func_151397_a(p_151398_1_, (ItemStack)entry.getKey()));

        return ((Float)entry.getValue()).floatValue();
    }
}