package dracocore.api.transmission.tile;

import net.minecraftforge.common.util.ForgeDirection;
import dracocore.api.transmission.NetworkType;

public interface IConnector
{

    /**
     * @return If the connection is possible.
     */
    public boolean canConnect(ForgeDirection direction, NetworkType type);
}
