package dracocore.items.general;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
import dracocore.CoreMain;
import dracocore.items.ItemsMain;
import dracocore.items.power.Acid;

public class ItemsGeneral 
{
	public static Item Ingot;
	public static Item Wire;
	public static Item Plate;
	public static Item Nugget;
	public static Item Casing;
	public static Item Mold;
	public static Item Hammer;
	public static Item Rubber;
	public static Item OreChunk;
	public static Item Dust;
	public static Item CrystalineOre;
	public static Item CrushedPureOre;
	public static Item Servo;
	public static Item Grill;
	public static Item SawBlade;
	public static Item Acid;
	public static Item Piston;
	public static Item Latch;
	public static Item Rod;
	public static Item Screw;
	public static Item Belt;
	public static Item Gear;
	public static Item Hatch;
	public static Item Tank;
	public static Item RoboticArm;
	public static Item Spring;
	public static Item Coil;
	public static Item Conveyor;
	public static Item Bolt;
	public static Item Rail;
	public static Item Grate;
	public static Item Knife;
	public static Item Dictionary;
	public static Item DragonScales;
	public static Item DragonTalons;
	public static Item DragonFangs;
	public static Item CustomEggs;
	public static Item FakeItem;
	
	public static void init()
	{
		FakeItem = new FillerItem().setUnlocalizedName("FakeItem");
		GameRegistry.registerItem(FakeItem, FakeItem.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(FakeItem.getUnlocalizedName().substring(5));
		
		CustomEggs = new CustomEggs().setUnlocalizedName("monsterPlacer").setTextureName("spawn_egg").setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerItem(CustomEggs, CustomEggs.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(CustomEggs.getUnlocalizedName().substring(5));
		
		DragonScales = new FillerItem().setUnlocalizedName("DragonScales").setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerItem(DragonScales, DragonScales.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(DragonScales.getUnlocalizedName().substring(5));
		
		DragonTalons = new FillerItem().setUnlocalizedName("DragonTalons").setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerItem(DragonTalons, DragonTalons.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(DragonTalons.getUnlocalizedName().substring(5));
		
		DragonFangs = new FillerItem().setUnlocalizedName("DragonFangs").setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerItem(DragonFangs, DragonFangs.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(DragonFangs.getUnlocalizedName().substring(5));
		
		
		Dictionary = new ItemHandbook().setUnlocalizedName("EncyclopediaDraconia").setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerItem(Dictionary, Dictionary.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(Dictionary.getUnlocalizedName().substring(5));
		
		Piston = new FillerItem().setUnlocalizedName("Piston").setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerItem(Piston, Piston.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(Piston.getUnlocalizedName().substring(5));
		
		Latch = new FillerItem().setUnlocalizedName("Latch").setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerItem(Latch, Latch.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(Latch.getUnlocalizedName().substring(5));
		
		Rod = new FillerItem().setUnlocalizedName("Rod").setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerItem(Rod, Rod.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(Rod.getUnlocalizedName().substring(5));
		
		Screw = new FillerItem().setUnlocalizedName("Screw").setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerItem(Screw, Screw.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(Screw.getUnlocalizedName().substring(5));
		
		Belt = new FillerItem().setUnlocalizedName("Belt").setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerItem(Belt, Belt.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(Belt.getUnlocalizedName().substring(5));
		
		Gear = new FillerItem().setUnlocalizedName("Gear").setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerItem(Gear, Gear.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(Gear.getUnlocalizedName().substring(5));
		
		Hatch = new FillerItem().setUnlocalizedName("Hatch").setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerItem(Hatch, Hatch.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(Hatch.getUnlocalizedName().substring(5));
		
		Tank = new FillerItem().setUnlocalizedName("Tank").setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerItem(Tank, Tank.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(Tank.getUnlocalizedName().substring(5));
		
		RoboticArm = new FillerItem().setUnlocalizedName("RoboticArm").setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerItem(RoboticArm, RoboticArm.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(RoboticArm.getUnlocalizedName().substring(5));
		
		Spring = new FillerItem().setUnlocalizedName("Spring").setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerItem(Spring, Spring.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(Spring.getUnlocalizedName().substring(5));
		
		Coil = new FillerItem().setUnlocalizedName("Coil").setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerItem(Coil, Coil.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(Coil.getUnlocalizedName().substring(5));
		
		Conveyor = new FillerItem().setUnlocalizedName("Conveyor").setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerItem(Conveyor, Conveyor.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(Conveyor.getUnlocalizedName().substring(5));
		
		Bolt = new FillerItem().setUnlocalizedName("Bolt").setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerItem(Bolt, Bolt.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(Bolt.getUnlocalizedName().substring(5));
		
		Rail = new FillerItem().setUnlocalizedName("Rail").setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerItem(Rail, Rail.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(Rail.getUnlocalizedName().substring(5));
		
		Grate = new FillerItem().setUnlocalizedName("Grate").setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerItem(Grate, Grate.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(Grate.getUnlocalizedName().substring(5));
		
		Servo = new FillerItem().setUnlocalizedName("Servo").setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerItem(Servo, Servo.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(Servo.getUnlocalizedName().substring(5));
		
		Grill = new FillerItem().setUnlocalizedName("Grill").setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerItem(Grill, Grill.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(Grill.getUnlocalizedName().substring(5));
		
		SawBlade = new FillerItem().setUnlocalizedName("SawBlade").setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerItem(SawBlade, SawBlade.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(SawBlade.getUnlocalizedName().substring(5));
		
		Hammer = new FillerItem().setUnlocalizedName("Hammer").setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerItem(Hammer, Hammer.getUnlocalizedName().substring(5));
		Hammer.setContainerItem(Hammer);
		ItemsMain.itemNames.add(Hammer.getUnlocalizedName().substring(5));
		
		Dust = new multiItem("Dust").setUnlocalizedName("Dusts").setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerItem(Dust, Dust.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(Dust.getUnlocalizedName().substring(5));
		
		CrystalineOre = (new multiItem("CrystalineOre").setUnlocalizedName("CrystalineOre").setCreativeTab(CoreMain.CoreTab));
		GameRegistry.registerItem(CrystalineOre, CrystalineOre.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(CrystalineOre.getUnlocalizedName().substring(5));
		
		CrushedPureOre = (new multiItem("CrushedPurifiedOre").setUnlocalizedName("PureDust").setCreativeTab(CoreMain.CoreTab));
		GameRegistry.registerItem(CrushedPureOre, CrushedPureOre.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(CrushedPureOre.getUnlocalizedName().substring(5));
		
		Ingot = (new multiItem("Ingot").setUnlocalizedName("Ingot").setCreativeTab(CoreMain.CoreTab));
		GameRegistry.registerItem(Ingot, Ingot.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(Ingot.getUnlocalizedName().substring(5));
		
		OreChunk = (new multiItem("OreChunk").setUnlocalizedName("OreChunks").setCreativeTab(CoreMain.CoreTab));
		GameRegistry.registerItem(OreChunk, OreChunk.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(OreChunk.getUnlocalizedName().substring(5));
		
		Wire = (new FillerItem().setUnlocalizedName("Wire").setCreativeTab(CoreMain.CoreTab));
		GameRegistry.registerItem(Wire, Wire.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(Wire.getUnlocalizedName().substring(5));
		
		Plate = (new FillerItem().setUnlocalizedName("Plate").setCreativeTab(CoreMain.CoreTab));
		GameRegistry.registerItem(Plate, Plate.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(Plate.getUnlocalizedName().substring(5));
		
		Nugget = (new multiItem("Nugget").setUnlocalizedName("Nugget").setCreativeTab(CoreMain.CoreTab));
		GameRegistry.registerItem(Nugget, Nugget.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(Nugget.getUnlocalizedName().substring(5));
		
		Casing = (new FillerItem().setUnlocalizedName("Casing").setCreativeTab(CoreMain.CoreTab));
		GameRegistry.registerItem(Casing, Casing.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(Casing.getUnlocalizedName().substring(5));
		
		Mold = (new FillerItem().setUnlocalizedName("Mold").setCreativeTab(CoreMain.CoreTab));
		GameRegistry.registerItem(Mold, Mold.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(Mold.getUnlocalizedName().substring(5));
		

		Knife = new FillerItem().setUnlocalizedName("Knife").setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerItem(Knife, Knife.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(Knife.getUnlocalizedName().substring(5));
		
		Acid = new Acid().setUnlocalizedName("Acid").setCreativeTab(CoreMain.CoreTab);
		GameRegistry.registerItem(Acid, Acid.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(Acid.getUnlocalizedName().substring(5));
		
		Rubber = (new FillerItem().setUnlocalizedName("rubber").setCreativeTab(CoreMain.CoreTab));
		GameRegistry.registerItem(Rubber, Rubber.getUnlocalizedName().substring(5));
		ItemsMain.itemNames.add(Rubber.getUnlocalizedName().substring(5));
		
	}
	
	
	
	
	
	
	
}
