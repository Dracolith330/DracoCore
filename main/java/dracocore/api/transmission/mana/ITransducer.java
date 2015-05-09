package dracocore.api.transmission.mana;

import dracocore.api.transmission.grid.IElectricityNetwork;
import dracocore.api.transmission.tile.ITransmitter;

public interface ITransducer extends ITransmitter
{
    /**
     * @return The tier of this conductor - must be 1 or 2
     */
    public int getTier();

    /**
     * @return This conductor's electricity network.
     */
    @Override
    public IManaNetwork getNetwork();
}
