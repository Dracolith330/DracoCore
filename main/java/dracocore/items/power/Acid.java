package dracocore.items.power;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dracocore.References;

public class Acid extends Item
{

    /** List of dye color names */
	public static final String[] dyeColorNames = new String[] {"AceticAcid", "BoricAcid", "CitricAcid", "HydrochloricAcid", "HydrofluoricAcid", "NitricAcid", "OxalicAcid", "PhosphoricAcid", "SulfuricAcid"};
    public static final String[] field_94595_b = new String[] {"Acid_Acetic", "Acid_Boric", "Acid_Citric", "Acid_Hydrochloric", "Acid_Hydrofluoric", "Acid_Nitric", "Acid_Oxalic", "Acid_Phosphoric", "Acid_Sulfuric"};
    @SideOnly(Side.CLIENT)
    private IIcon[] field_94594_d;

    public Acid()
    {
        super();
        this.setHasSubtypes(true);
    }
    @SideOnly(Side.CLIENT)

    /**
     * Gets an icon index based on an item's damage value
     */
    public IIcon getIconFromDamage(int meta)
	{
		return field_94594_d[meta];
	}
    /**
     * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     */
    public String getUnlocalizedName(ItemStack par1ItemStack)
    {
        int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, dyeColorNames.length);
        return super.getUnlocalizedName() + "." + dyeColorNames[i];
    }

    @SideOnly(Side.CLIENT)

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int j = 0; j < dyeColorNames.length; ++j)
        {
            par3List.add(new ItemStack(par1, 1, j));
        }
    }
    @SideOnly(Side.CLIENT)
	@Override
    public void registerIcons(IIconRegister iconRegister)
    {
		this.field_94594_d = new IIcon[dyeColorNames.length];

        for (int i = 0; i < this.field_94594_d.length; ++i)
        {
            this.field_94594_d[i] = iconRegister.registerIcon(References.texturelocation+":"+"16x/Acids/"+field_94595_b[i]);
        }
    }
}