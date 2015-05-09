package dracocore.api.transmission.tile;

import dracocore.api.transmission.grid.IGridNetwork;

@SuppressWarnings("rawtypes")
public interface INetworkProvider
{
    public IGridNetwork getNetwork();

    public void setNetwork(IGridNetwork network);
}
