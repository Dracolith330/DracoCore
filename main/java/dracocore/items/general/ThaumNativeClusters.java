package dracocore.items.general;

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

public class ThaumNativeClusters extends Item
{
    /** List of dye color names */
    public static final String[] dyeColorNames = new String[] {"Cobalt", "Nickel", "Platinum", "Tungsten", "Unobtainum", "Uranium", "Scandium", "Chromium", "Manganese", "Zinc", "Yttrium", "Zirconium", "Niobium", "Molybdenum", "Ruthenium", "Rhodium", "Palladium", "Cadmium", "Lutetium", "Hafnium", "Tantalum", "Rhenium", "Osmium", "Iridium", "Titanium"};
    @SideOnly(Side.CLIENT)
    private IIcon[] field_94594_d;

    public ThaumNativeClusters()
    {
        super();
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
    }

    @SideOnly(Side.CLIENT)

    /**
     * Gets an icon index based on an item's damage value
     */
    public IIcon getIconFromDamage(int par1)
    {
        int j = MathHelper.clamp_int(par1, 0, dyeColorNames.length);
        return this.field_94594_d[j];
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
        for (int j = 0; j < this.dyeColorNames.length; ++j)
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
            this.field_94594_d[i] = iconRegister.registerIcon(References.texturelocation+":"+"ThaumcraftSupport/NativeClusters/NativeCluster_"+dyeColorNames[i]+".png");
        }
    }
}
