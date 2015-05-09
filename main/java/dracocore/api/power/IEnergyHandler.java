package dracocore.api.power;

public interface IEnergyHandler
{
    /**
     * Add energy from an external source
     *
     * @param from     Energy Source that is providing power
     * @param amount   Maximum amount of energy to receive
     * @param simulate If true, the transfer will only be simulated.
     * @return The amount of energy that was successfully received (or would
     * have been, if simulated).
     */
    public float receiveEnergy(EnergySource from, float amount, boolean simulate);

    /**
     * Remove energy, transferring it to an external source
     *
     * @param from     Energy Source that is extracting power
     * @param amount   Maximum amount of energy to extract
     * @param simulate If true, the transfer will only be simulated.
     * @return The amount of energy that was successfully extracted (or would
     * have been, if simulated).
     */
    public float extractEnergy(EnergySource from, float amount, boolean simulate);

    /**
     * Returns true if the handler can interface with the provided energy source
     */
    public boolean nodeAvailable(EnergySource from);

    /**
     * Returns the amount of energy stored in this handler available to the
     * provided source
     */
    public float getEnergyStored(EnergySource from);

    /**
     * Returns the maximum amount of energy stored in this handler available to
     * the provided source
     */
    public float getMaxEnergyStored(EnergySource from);
}
