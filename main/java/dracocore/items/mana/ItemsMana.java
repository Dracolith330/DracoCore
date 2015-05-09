package dracocore.items.mana;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
import dracocore.CoreMain;
import dracocore.items.ItemsMain;
import dracocore.items.general.ThaumNativeClusters;

public class ItemsMana 
{
	public static Item ThaumNativeCluster;
	public static Item CrystalosWand;
	
	public static void init()
	{

		CrystalosWand = new CrystalosWand().setUnlocalizedName("CrystalosWand").setTextureName("CrystalosWand").setFull3D().setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerItem(CrystalosWand, CrystalosWand.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(CrystalosWand.getUnlocalizedName().substring(5));
		
		try 
		{
			Class.forName("thaumcraft.api.ThaumcraftApi");
			ThaumNativeCluster = new ThaumNativeClusters().setUnlocalizedName("NativeClusters").setCreativeTab(CoreMain.CoreTab);
			GameRegistry.registerItem(ThaumNativeCluster, ThaumNativeCluster.getUnlocalizedName().substring(5));
			ItemsMain.itemNames.add(ThaumNativeCluster.getUnlocalizedName().substring(5));
			System.out.println("Thaumcraft detected, now registering thaumcraft support.");

		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
}
