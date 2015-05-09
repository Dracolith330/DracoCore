package dracocore.api.transmission.tile;

public interface IElectricalStorage
{
    /**
     * Sets the amount of joules this unit has stored.
     */
    public void setEnergyStored(float energy);

    /**
     * * @return Get the amount of energy currently stored in the block.
     */
    public float getEnergyStored();

    /**
     * @return Get the max amount of energy that can be stored in the block.
     */
    public float getMaxEnergyStored();
}
