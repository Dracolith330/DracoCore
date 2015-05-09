package dracocore.api.transmission.mana;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraftforge.common.util.ForgeDirection;
import dracocore.api.transmission.NetworkType;
import dracocore.api.transmission.tile.IConnector;
import dracocore.api.vector.BlockVec3;

public class ManaUtil
{
    public static TileEntity[] getAdjacentPowerConnections(TileEntity tile)
    {
        TileEntity[] adjacentConnections = new TileEntity[6];
        
        BlockVec3 thisVec = new BlockVec3(tile);
        for (ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS)
        {
            TileEntity tileEntity = thisVec.getTileEntityOnSide(tile.getWorldObj(), direction);

            if (tileEntity instanceof IConnector)
            {
                if (((IConnector) tileEntity).canConnect(direction.getOpposite(), NetworkType.MANA))
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
        return false;
    }
}
