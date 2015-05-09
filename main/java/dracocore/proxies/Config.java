package dracocore.proxies;

import java.io.File;
import java.util.Random;

import dracocore.items.general.ItemsGeneral;
import dracocore.items.mana.ItemsMana;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class Config
{
	
  public static Configuration config;
  public static final String CATEGORY_MODCOMP = "Mod Compatability";
  public static final String CATEGORY_MANAGEN = "Mana Generation";
  public static final String CATEGORY_POWERGEN = "Power Generation";
  public static int biomeTestID = 128;
  public static boolean ForceRegisterCopper = true;
  public static boolean ForceRegisterSilver = true;
  public static boolean ForceRegisterTin = true;
  public static boolean ForceRegisterBronze = true;
  public static boolean ForceRegisterLead = true;
  public static boolean ForceRegisterSteel = true;
  public static boolean ForceRegisterCobalt = true;
  public static boolean ForceRegisterNickel = true;
  public static boolean ForceRegisterPlatinum = true;
  public static boolean ForceRegisterUranium = true;
  public static boolean ForceRegisterZinc = true;
  public static boolean ForceRegisterOsmium = true;
  public static boolean ForceRegisterIridium = true;
  public static boolean ForceRegisterMercury = true;
  
  public static int SolarManaGeneratorManaPerSecond = 200;
  public static int BurnerManaGeneratorManaPerSecond = 50;
  
  public static void initialize(File file)
  {
    config = new Configuration(file);
    config.addCustomCategoryComment("Mod Compatability", "Mod compatability");
    config.addCustomCategoryComment("Mana Generation", "Mana generation");

    config.load();

    Property copper = config.get(CATEGORY_MODCOMP, "copper", true);
    copper.comment = "Enable copper? [Default true]";
    ForceRegisterCopper = copper.getBoolean();
    
    Property silver = config.get(CATEGORY_MODCOMP, "silver", true);
    silver.comment = "Enable silver? [Default true]";
    ForceRegisterSilver = silver.getBoolean();
    
    Property tin = config.get(CATEGORY_MODCOMP, "tin", true);
    tin.comment = "Enable tin? [Default true]";
    ForceRegisterTin = tin.getBoolean();

    Property bronze = config.get(CATEGORY_MODCOMP, "bronze", true);
    bronze.comment = "Enable bronze? [Default true]";
    ForceRegisterBronze = bronze.getBoolean();

    Property lead = config.get(CATEGORY_MODCOMP, "lead", true);
    lead.comment = "Enable lead? [Default true]";
    ForceRegisterLead = lead.getBoolean();

    Property steel = config.get(CATEGORY_MODCOMP, "steel", true);
    steel.comment = "Enable steel? [Default true]";
    ForceRegisterSteel = steel.getBoolean();

    Property cobalt = config.get(CATEGORY_MODCOMP, "cobalt", true);
    cobalt.comment = "Enable cobalt? [Default true]";
    ForceRegisterCobalt = cobalt.getBoolean();

    Property nickel = config.get(CATEGORY_MODCOMP, "nickel", true);
    nickel.comment = "Enable nickel? [Default true]";
    ForceRegisterNickel = nickel.getBoolean();

    Property platinum = config.get(CATEGORY_MODCOMP, "platinum", true);
    platinum.comment = "Enable platinum? [Default true]";
    ForceRegisterPlatinum = platinum.getBoolean();

    Property uranium = config.get(CATEGORY_MODCOMP, "uranium", true);
    uranium.comment = "Enable uranium? [Default true]";
    ForceRegisterUranium = uranium.getBoolean();

    Property zinc = config.get(CATEGORY_MODCOMP, "zinc", true);
    zinc.comment = "Enable zinc? [Default true]";
    ForceRegisterZinc = zinc.getBoolean();

    Property osmium = config.get(CATEGORY_MODCOMP, "osmium", true);
    osmium.comment = "Enable osmium? [Default true]";
    ForceRegisterOsmium = osmium.getBoolean();

    Property iridium = config.get(CATEGORY_MODCOMP, "iridium", true);
    iridium.comment = "Enable iridium? [Default true]";
    ForceRegisterIridium = iridium.getBoolean();

    Property mercury = config.get(CATEGORY_MODCOMP, "mercury", true);
    mercury.comment = "Enable mercury? [Default true]";
    ForceRegisterMercury = mercury.getBoolean();
    
    Property SMGMPS = config.get(CATEGORY_MANAGEN, "SMGMPS", 200);
    SMGMPS.comment = "Solar mana generator Mana per second? [Default 200]";
    SolarManaGeneratorManaPerSecond = SMGMPS.getInt();
        
    
    config.save();
  }
  
  public static void save()
  {
    config.save();
  }
  
  public static void initLoot()
  {
	  //new ItemStack(ConfigItems.itemThaumonomicon)
	  Random rand = new Random(System.currentTimeMillis());
	  
	  ItemStack[] commonLoot = {};
	  ItemStack[] uncommonLoot = {};
	  ItemStack[] rareLoot = {new ItemStack(ItemsGeneral.Dictionary), new ItemStack(ItemsMana.CrystalosWand)};
    
    	for (ItemStack is : commonLoot)
    	{
      		ChestGenHooks.addItem("dungeonChest", new WeightedRandomChestContent(is, 1, 3, 5));
      		ChestGenHooks.addItem("pyramidJungleChest", new WeightedRandomChestContent(is, 1, 3, 5));
      		ChestGenHooks.addItem("pyramidDesertyChest", new WeightedRandomChestContent(is, 1, 3, 5));
      		ChestGenHooks.addItem("mineshaftCorridor", new WeightedRandomChestContent(is, 1, 3, 4));
      		ChestGenHooks.addItem("strongholdCorridor", new WeightedRandomChestContent(is, 1, 3, 4));
      		ChestGenHooks.addItem("strongholdCrossing", new WeightedRandomChestContent(is, 1, 3, 4));
      		ChestGenHooks.addItem("strongholdLibrary", new WeightedRandomChestContent(is, 1, 3, 4));
      		
    	}
    	
    	for (ItemStack is : uncommonLoot)
    	{
      		ChestGenHooks.addItem("dungeonChest", new WeightedRandomChestContent(is, 1, 2, 4));
      		ChestGenHooks.addItem("pyramidJungleChest", new WeightedRandomChestContent(is, 1, 2, 4));
      		ChestGenHooks.addItem("pyramidDesertyChest", new WeightedRandomChestContent(is, 1, 2, 4));
      		ChestGenHooks.addItem("mineshaftCorridor", new WeightedRandomChestContent(is, 1, 2, 3));
      		ChestGenHooks.addItem("strongholdCorridor", new WeightedRandomChestContent(is, 1, 2, 3));
      		ChestGenHooks.addItem("strongholdCrossing", new WeightedRandomChestContent(is, 1, 2, 3));
      		ChestGenHooks.addItem("strongholdLibrary", new WeightedRandomChestContent(is, 1, 2, 3));
    	
    	}
    	
    	for (ItemStack is : rareLoot)
    	{
      		ChestGenHooks.addItem("dungeonChest", new WeightedRandomChestContent(is, 1, 1, 1));
      		ChestGenHooks.addItem("pyramidJungleChest", new WeightedRandomChestContent(is, 1, 1, 1));
      		ChestGenHooks.addItem("pyramidDesertyChest", new WeightedRandomChestContent(is, 1, 1, 1));
      		ChestGenHooks.addItem("mineshaftCorridor", new WeightedRandomChestContent(is, 1, 1, 1));
      		ChestGenHooks.addItem("strongholdCorridor", new WeightedRandomChestContent(is, 1, 1, 1));
      		ChestGenHooks.addItem("strongholdCrossing", new WeightedRandomChestContent(is, 1, 1, 1));
      		ChestGenHooks.addItem("strongholdLibrary", new WeightedRandomChestContent(is, 1, 1, 1));
    	
    	}
    	
  }
}
