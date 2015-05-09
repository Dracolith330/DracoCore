package dracocore.energy;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.Loader;

public class EnergyConfigHandler
{
    private static Configuration config;

    public static float BC3_RATIO = 16F;

    public static float RF_RATIO = EnergyConfigHandler.BC3_RATIO / 10F;

    public static float IC2_RATIO = EnergyConfigHandler.BC3_RATIO / 2.44F;

    public static float MEKANISM_RATIO = EnergyConfigHandler.IC2_RATIO / 10F;

    public static float TO_BC_RATIO = 1 / EnergyConfigHandler.BC3_RATIO;

    public static float TO_RF_RATIO = 1 / EnergyConfigHandler.RF_RATIO;

    public static float TO_IC2_RATIO = 1 / EnergyConfigHandler.IC2_RATIO;

    public static float TO_MEKANISM_RATIO = 1 / EnergyConfigHandler.MEKANISM_RATIO;

    public static Object gasOxygen = null;
    public static Object gasHydrogen = null;
    
    public static boolean displayEnergyUnitsBC = false;
    public static boolean displayEnergyUnitsIC2 = false;
    public static boolean displayEnergyUnitsMek = false;
    public static boolean displayEnergyUnitsRF = false;

    private static boolean cachedIC2Loaded = false;
    private static boolean cachedIC2LoadedValue = false;
    private static boolean cachedBCLoaded = false;
    private static boolean cachedBCLoadedValue = false;
    private static boolean cachedBCReallyLoaded = false;
    private static boolean cachedBCReallyLoadedValue = false;
    private static int cachedBCVersion = -1;
    private static boolean cachedMekLoaded = false;
    private static boolean cachedMekLoadedValue = false;
    private static boolean cachedRFLoaded = false;
    private static boolean cachedRFLoadedValue = false;


    public static void setDefaultValues(File file)
    {
        if (EnergyConfigHandler.config == null)
        {
            EnergyConfigHandler.config = new Configuration(file);
        }

        EnergyConfigHandler.config.load();
        EnergyConfigHandler.IC2_RATIO = (float) EnergyConfigHandler.config.get("Compatibility", "IndustrialCraft Conversion Ratio", EnergyConfigHandler.IC2_RATIO).getDouble(EnergyConfigHandler.IC2_RATIO);
        EnergyConfigHandler.RF_RATIO = (float) EnergyConfigHandler.config.get("Compatibility", "RF Conversion Ratio", EnergyConfigHandler.RF_RATIO).getDouble(EnergyConfigHandler.RF_RATIO);
        EnergyConfigHandler.BC3_RATIO = (float) EnergyConfigHandler.config.get("Compatibility", "BuildCraft Conversion Ratio", EnergyConfigHandler.BC3_RATIO).getDouble(EnergyConfigHandler.BC3_RATIO);
        EnergyConfigHandler.MEKANISM_RATIO = (float) EnergyConfigHandler.config.get("Compatibility", "Mekanism Conversion Ratio", EnergyConfigHandler.MEKANISM_RATIO).getDouble(EnergyConfigHandler.MEKANISM_RATIO);
        EnergyConfigHandler.TO_IC2_RATIO = 1 / EnergyConfigHandler.IC2_RATIO;
        EnergyConfigHandler.TO_BC_RATIO = 1 / EnergyConfigHandler.BC3_RATIO;
        EnergyConfigHandler.TO_RF_RATIO = 1 / EnergyConfigHandler.RF_RATIO;
        EnergyConfigHandler.TO_MEKANISM_RATIO = 1 / EnergyConfigHandler.MEKANISM_RATIO;

        EnergyConfigHandler.displayEnergyUnitsBC = EnergyConfigHandler.config.get("Display", "If BuildCraft is loaded, show Galacticraft machines energy as MJ instead of gJ?", false).getBoolean(false);
        EnergyConfigHandler.displayEnergyUnitsIC2 = EnergyConfigHandler.config.get("Display", "If IndustrialCraft2 is loaded, show Galacticraft machines energy as EU instead of gJ?", false).getBoolean(false);
        EnergyConfigHandler.displayEnergyUnitsMek = EnergyConfigHandler.config.get("Display", "If Mekanism is loaded, show Galacticraft machines energy as Joules (J) instead of gJ?", false).getBoolean(false);
        if (!EnergyConfigHandler.isBuildcraftLoaded())
        {
            EnergyConfigHandler.displayEnergyUnitsBC = false;
        }
        if (!EnergyConfigHandler.isIndustrialCraft2Loaded())
        {
            EnergyConfigHandler.displayEnergyUnitsIC2 = false;
        }
        if (!EnergyConfigHandler.isMekanismLoaded())
        {
            EnergyConfigHandler.displayEnergyUnitsMek = false;
        }
        if (EnergyConfigHandler.displayEnergyUnitsIC2)
        {
            EnergyConfigHandler.displayEnergyUnitsBC = false;
        }
        if (EnergyConfigHandler.displayEnergyUnitsMek)
        {
            EnergyConfigHandler.displayEnergyUnitsBC = false;
            EnergyConfigHandler.displayEnergyUnitsIC2 = false;
        }

        EnergyConfigHandler.config.save();
    }

    public static void initGas()
    {
    }

    /**
     * Checks using the FML loader too see if IC2 is loaded
     */
    public static boolean isIndustrialCraft2Loaded()
    {
        if (!cachedIC2Loaded)
        {
            cachedIC2Loaded = true;
            cachedIC2LoadedValue = Loader.isModLoaded("IC2");
        }

        return cachedIC2LoadedValue;
    }

    /**
     * Checks using the FML loader to see if BC (or BC API) is loaded
     */
    public static boolean isBuildcraftLoaded()
    {
        if (!cachedBCLoaded)
        {
            cachedBCLoaded = true;
            //if (Loader.isModLoaded("BuildCraft|Energy"))
            //	cachedBCLoadedValue = true;
            //else
            {
            	int count = 0;
            	try {
	            	if (Class.forName("buildcraft.api.mj.MjAPI") != null) count++;           			
	            	if (Class.forName("buildcraft.api.power.IPowerReceptor") != null) count++;
	            	if (Class.forName("buildcraft.api.power.PowerHandler") != null) count++;
	            	if (Class.forName("buildcraft.api.power.IPowerEmitter") != null) count++;
	            	if (Class.forName("buildcraft.api.mj.IBatteryObject") != null) count++;
	            	if (Class.forName("buildcraft.api.mj.ISidedBatteryProvider") != null) count++;
            	} catch (Exception e) { }
            	
            	cachedBCLoadedValue = (count==6);
            }
        }

        return cachedBCLoadedValue;
    }

    public static boolean isBuildcraftReallyLoaded()
    {
        if (!cachedBCReallyLoaded)
        {
            cachedBCReallyLoaded = true;
            cachedBCReallyLoadedValue = Loader.isModLoaded("BuildCraft|Energy");
        }

        return cachedBCReallyLoadedValue;
    }

    public static int getBuildcraftVersion()
    {
        if (cachedBCVersion != -1)
        {
            return cachedBCVersion;
        }

        if (cachedBCLoaded)
        {
            boolean bc6Found = true;

            try
            {
                Class.forName("buildcraft.api.mj.MjAPI");
            }
            catch (Throwable t)
            {
                bc6Found = false;
            }

            if (bc6Found)
            {
                cachedBCVersion = 6;
            }
            else
            {
                cachedBCVersion = 5;
            }
        }

        return cachedBCVersion;
    }

    public static boolean isRFAPILoaded()
    {
        if (!cachedRFLoaded)
        {
            cachedRFLoaded = true;
            cachedRFLoadedValue = false;
            try {
            	cachedRFLoadedValue = (Class.forName("cofh.api.energy.IEnergyHandler") != null);
            } catch (Exception e) { }
        }

        return cachedRFLoadedValue;
    }

    public static boolean isMekanismLoaded()
    {
        if (!cachedMekLoaded)
        {
            cachedMekLoaded = true;
            cachedMekLoadedValue = Loader.isModLoaded("Mekanism");
        }

        return cachedMekLoadedValue;
    }
}
