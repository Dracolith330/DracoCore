package dracocore.api.power;

public interface IEnergyStorage
{
    /**
     * Add energy to the storage.
     *
     * @param amount   Maximum amount of energy to receive
     * @param simulate If true, the transfer will only be simulated.
     * @return The amount of energy that was successfully received (or would
     * have been, if simulated).
     */
    public float receiveEnergy(float amount, boolean simulate);

    /**
     * Remove energy from the storage.
     *
     * @param amount   Maximum amount of energy to extract
     * @param simulate If true, the transfer will only be simulated.
     * @return The amount of energy that was successfully extracted (or would
     * have been, if simulated).
     */
    public float extractEnergy(float amount, boolean simulate);

    /**
     * Returns the amount of energy stored
     */
    public float getEnergyStored();

    /**
     * Returns the maximum amount of energy stored
     */
    public float getCapacity();
}
