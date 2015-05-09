package dracocore.energy;

import java.lang.reflect.Method;

import dracocore.api.transmission.NetworkType;
import dracocore.api.transmission.tile.IConnector;
import dracocore.api.vector.BlockVec3;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraftforge.common.util.ForgeDirection;

public class EnergyUtil
{
    private static boolean isMekLoaded = EnergyConfigHandler.isMekanismLoaded();
    private static boolean isRFLoaded = EnergyConfigHandler.isRFAPILoaded();
    private static boolean isIC2Loaded = EnergyConfigHandler.isIndustrialCraft2Loaded();
    private static boolean isBCLoaded = EnergyConfigHandler.isBuildcraftLoaded();
    private static boolean isBC6Loaded = isBCLoaded && EnergyConfigHandler.getBuildcraftVersion() == 6;
    private static boolean isBCReallyLoaded = EnergyConfigHandler.isBuildcraftReallyLoaded();
  
    public static boolean voltageParameterIC2 = false;
    public static Method demandedEnergyIC2 = null;
    public static Method injectEnergyIC2 = null;
    private static Class<?> clazzMekCable = null;
    public static Class<?> clazzEnderIOCable = null;
    private static Class<?> clazzPipeTile = null;
    private static Class<?> clazzPipeWood = null;  
    public static boolean initialisedIC2Methods = EnergyUtil.initialiseIC2Methods();
    
    public static TileEntity[] getAdjacentPowerConnections(TileEntity tile)
    {
        TileEntity[] adjacentConnections = new TileEntity[6];
        
        BlockVec3 thisVec = new BlockVec3(tile);
        for (ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS)
        {
            TileEntity tileEntity = thisVec.getTileEntityOnSide(tile.getWorldObj(), direction);

            if (tileEntity instanceof IConnector)
            {
                if (((IConnector) tileEntity).canConnect(direction.getOpposite(), NetworkType.POWER))
                {
                    adjacentConnections[direction.ordinal()] = tileEntity;
                }
                continue;
            }
        }

        return adjacentConnections;
    }
    
    public static float otherModsEnergyTransfer(TileEntity tileAdj, ForgeDirection inputAdj, float toSend, boolean simulate)
    {
        return 0F;
    }

    /**
     * Test whether an energy connection can be made to a tile using other mods' energy methods.
     * 
     * Parameters:
     * @param tileAdj - the tile under test, it might be an energy tile from another mod
     * @param inputAdj - the energy input side for that tile which is under test
     */
	public static boolean otherModCanReceive(TileEntity tileAdj, ForgeDirection inputAdj)
	{
		return false;
	}

    public static boolean initialiseIC2Methods()
    {
        return true;
    }
}
