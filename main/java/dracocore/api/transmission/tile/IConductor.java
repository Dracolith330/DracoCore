package dracocore.api.transmission.tile;

import dracocore.api.transmission.grid.IElectricityNetwork;

public interface IConductor extends ITransmitter
{
    /**
     * @return The tier of this conductor - must be 1 or 2
     */
    public int getTier();

    /**
     * @return This conductor's electricity network.
     */
    @Override
    public IElectricityNetwork getNetwork();
}
