package dracocore.api.transmission.tile;

import net.minecraft.tileentity.TileEntity;

public interface INetworkConnection extends IConnector
{

    /**
     * Gets a list of all the connected TileEntities that this conductor is
     * connected to. The array's length should be always the 6 adjacent wires.
     *
     * @return
     */
    public TileEntity[] getAdjacentConnections();

    /**
     * Refreshes the conductor
     */
    public void refresh();

    public void onNetworkChanged();
}
