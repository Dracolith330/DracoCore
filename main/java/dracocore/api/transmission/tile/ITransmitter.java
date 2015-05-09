package dracocore.api.transmission.tile;

import dracocore.api.transmission.NetworkType;

public interface ITransmitter extends INetworkProvider, INetworkConnection
{
    public NetworkType getNetworkType();
}
