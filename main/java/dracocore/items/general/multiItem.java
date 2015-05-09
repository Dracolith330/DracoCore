package dracocore.items.general;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dracocore.References;
import dracocore.items.ItemsMain;

public class multiItem extends Item
{
	
	
	
    /** List of dye color names */
    @SideOnly(Side.CLIENT)
    private IIcon[] field_94594_d;
    String itemDesc;

    public multiItem(String lore)
    {
        super();
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        itemDesc = lore;
    }
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int par1)
    {
        int j = MathHelper.clamp_int(par1, 0, ItemsMain.MetalTypes.length);
        return this.field_94594_d[j];
    }
    /**
     * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     */
    public String getUnlocalizedName(ItemStack par1ItemStack)
    {
        int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, ItemsMain.MetalTypes.length);
        return super.getUnlocalizedName() + "." + ItemsMain.MetalTypes[i];
    }

    @SideOnly(Side.CLIENT)

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int j = 0; j < ItemsMain.MetalTypes.length; ++j)
        {
            par3List.add(new ItemStack(par1, 1, j));
        }
    }

    @SideOnly(Side.CLIENT)
	@Override
    public void registerIcons(IIconRegister iconRegister)
    {
		this.field_94594_d = new IIcon[ItemsMain.MetalTypes.length];

        for (int i = 0; i < this.field_94594_d.length; ++i)
        {
            this.field_94594_d[i] = iconRegister.registerIcon(References.texturelocation+":"+"Parts/"+this.getUnlocalizedName().substring(5)+"/"+this.getUnlocalizedName().substring(5)+"_"+ItemsMain.MetalTypes[i]);
        }
    }
    
    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
    	switch(par1ItemStack.getItemDamage())
    	{
    	
    	case 0:
    		par3List.add(I18n.format("dracocore." + itemDesc + "_sub1.desc", new Object[0]));
    		break;
    	case 1:
    		par3List.add(I18n.format("dracocore." + itemDesc + "_sub2.desc", new Object[0]));
    		break;
    	case 2:
    		par3List.add(I18n.format("dracocore." + itemDesc + "_sub3.desc", new Object[0]));
    		break;
    	case 3:
    		par3List.add(I18n.format("dracocore." + itemDesc + "_sub4.desc", new Object[0]));
    		break;
    	case 4:
    		par3List.add(I18n.format("dracocore." + itemDesc + "_sub5.desc", new Object[0]));
    		break;
    	case 5:
    		par3List.add(I18n.format("dracocore." + itemDesc + "_sub6.desc", new Object[0]));
    		break;
    	case 6:
    		par3List.add(I18n.format("dracocore." + itemDesc + "_sub7.desc", new Object[0]));
    		break;
    	case 7:
    		par3List.add(I18n.format("dracocore." + itemDesc + "_sub8.desc", new Object[0]));
    		break;
    	case 8:
    		par3List.add(I18n.format("dracocore." + itemDesc + "_sub9.desc", new Object[0]));
    		break;
    	case 9:
    		par3List.add(I18n.format("dracocore." + itemDesc + "_sub10.desc", new Object[0]));
    		break;
    	case 10:
    		par3List.add(I18n.format("dracocore." + itemDesc + "_sub11.desc", new Object[0]));
    		break;
    	case 11:
    		par3List.add(I18n.format("dracocore." + itemDesc + "_sub12.desc", new Object[0]));
    		break;
    	case 12:
    		par3List.add(I18n.format("dracocore." + itemDesc + "_sub13.desc", new Object[0]));
    		break;
    	case 13:
    		par3List.add(I18n.format("dracocore." + itemDesc + "_sub14.desc", new Object[0]));
    		break;
    	case 14:
    		par3List.add(I18n.format("dracocore." + itemDesc + "_sub15.desc", new Object[0]));
    		break;
    	case 15:
    		par3List.add(I18n.format("dracocore." + itemDesc + "_sub16.desc", new Object[0]));
    		break;
    	case 16:
    		par3List.add(I18n.format("dracocore." + itemDesc + "_sub17.desc", new Object[0]));
    		break;
    	case 17:
    		par3List.add(I18n.format("dracocore." + itemDesc + "_sub18.desc", new Object[0]));
    		break;
    	case 18:
    		par3List.add(I18n.format("dracocore." + itemDesc + "_sub19.desc", new Object[0]));
    		break;
    	case 19:
    		par3List.add(I18n.format("dracocore." + itemDesc + "_sub20.desc", new Object[0]));
    		break;
    	case 20:
    		par3List.add(I18n.format("dracocore." + itemDesc + "_sub21.desc", new Object[0]));
    		break;
    	case 21:
    		par3List.add(I18n.format("dracocore." + itemDesc + "_sub22.desc", new Object[0]));
    		break;
    	case 22:
    		par3List.add(I18n.format("dracocore." + itemDesc + "_sub23.desc", new Object[0]));
    		break;
    	case 23:
    		par3List.add(I18n.format("dracocore." + itemDesc + "_sub24.desc", new Object[0]));
    		break;
    	case 24:
    		par3List.add(I18n.format("dracocore." + itemDesc + "_sub25.desc", new Object[0]));
    		break;
    	case 25:
    		par3List.add(I18n.format("dracocore." + itemDesc + "_sub26.desc", new Object[0]));
    		break;
    	case 26:
    		par3List.add(I18n.format("dracocore." + itemDesc + "_sub27.desc", new Object[0]));
    		break;
    	case 27:
    		par3List.add(I18n.format("dracocore." + itemDesc + "_sub28.desc", new Object[0]));
    		break;
    	case 28:
    		par3List.add(I18n.format("dracocore." + itemDesc + "_sub29.desc", new Object[0]));
    		break;
    	case 29:
    		par3List.add(I18n.format("dracocore." + itemDesc + "_sub30.desc", new Object[0]));
    		break;
    	case 30:
    		par3List.add(I18n.format("dracocore." + itemDesc + "_sub31.desc", new Object[0]));
    		break;
    	case 31:
    		par3List.add(I18n.format("dracocore." + itemDesc + "_sub32.desc", new Object[0]));
    		break;
    	}
    	 
    }
}
