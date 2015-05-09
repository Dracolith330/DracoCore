package dracocore.blocks.blockclasses.general.block;

import java.util.Random;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import dracocore.blocks.blockclasses.general.BlocksGeneric;
import dracocore.items.general.ItemsGeneral;

public class OreVein extends BlockBase
{
    private static final String __OBFID = "CL_00000282";
    
    public OreVein(String ToolTip)
    {
        super(ToolTip);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
    	return ItemsGeneral.OreChunk;
    }
    public int quantityDropped(Random r)
    {
        return 1 + r.nextInt(2);
    }
    public int damageDropped(int p_149692_1_)
    {
    	return this == BlocksGeneric.CopperVein ? 0 : (this == BlocksGeneric.SilverVein ? 1 : (this == BlocksGeneric.TinVein ? 2 : (this == BlocksGeneric.LeadVein ? 4 : (this == BlocksGeneric.CobaltVein ? 5 : (this == BlocksGeneric.PlatinumVein ? 6 : (this == BlocksGeneric.UraniumVein ? 7 : 0))))));
    }
    /**
     * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i' (inclusive).
     */
    public int quantityDroppedWithBonus(int p_149679_1_, Random p_149679_2_)
    {
        if (p_149679_1_ > 0 && Item.getItemFromBlock(this) != this.getItemDropped(0, p_149679_2_, p_149679_1_))
        {
            int j = p_149679_2_.nextInt(p_149679_1_ + 2) - 1;

            if (j < 0)
            {
                j = 0;
            }

            return this.quantityDropped(p_149679_2_) * (j + 1);
        }
        else
        {
            return this.quantityDropped(p_149679_2_);
        }
    }

    /**
     * Drops the block items with a specified chance of dropping the specified items
     */
    public void dropBlockAsItemWithChance(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_)
    {
        super.dropBlockAsItemWithChance(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, p_149690_5_, p_149690_6_, p_149690_7_);
    }
    
}