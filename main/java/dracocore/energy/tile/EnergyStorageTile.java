package dracocore.energy.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import dracocore.api.power.EnergySource;
import dracocore.api.power.EnergySource.EnergySourceAdjacent;
import dracocore.api.power.IEnergyHandler;
import dracocore.api.transmission.NetworkType;
import dracocore.api.transmission.tile.IElectrical;
import dracocore.blocks.tileentity.generic.TileEntityAdvanced;
import dracocore.network.Annotations.NetworkedField;
import dracocore.network.ReceiverMode;

public abstract class EnergyStorageTile extends TileEntityAdvanced implements IEnergyHandler, IElectrical
{
    @NetworkedField(targetSide = Side.CLIENT)
    public EnergyStorage storage = new EnergyStorage(16000, 10);
    public int tier = 1;
    public int poweredByTier = 1;

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {

        super.readFromNBT(nbt);
        this.storage.readFromNBT(nbt);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt)
    {

        super.writeToNBT(nbt);
        this.storage.writeToNBT(nbt);
    }

    public abstract ReceiverMode getModeFromDirection(ForgeDirection direction);

    @Override
    public float receiveEnergy(EnergySource from, float amount, boolean simulate)
    {
        return this.storage.receiveEnergy(amount, simulate);
    }

    @Override
    public float extractEnergy(EnergySource from, float amount, boolean simulate)
    {
        return this.storage.extractEnergy(amount, simulate);
    }

    @Override
    public boolean nodeAvailable(EnergySource from)
    {
        if (!(from instanceof EnergySourceAdjacent))
        {
            return false;
        }

        return this.getModeFromDirection(((EnergySourceAdjacent) from).direction) != ReceiverMode.UNDEFINED;
    }

    @Override
    public float getEnergyStored(EnergySource from)
    {
        return this.storage.getEnergyStored();
    }

    public float getEnergyStored()
    {
        return this.storage.getEnergyStored();
    }

    @Override
    public float getMaxEnergyStored(EnergySource from)
    {
        return this.storage.getCapacity();
    }

    public float getMaxEnergyStored()
    {
        return this.storage.getCapacity();
    }

    @Override
    public boolean canConnect(ForgeDirection direction, NetworkType type)
    {
        return false;
    }

    //Five methods for compatibility with basic electricity
    @Override
    public float receiveElectricity(ForgeDirection from, float receive, int tier, boolean doReceive)
    {
        this.poweredByTier = tier;
        return this.storage.receiveEnergy(receive, !doReceive);
    }

    @Override
    public float provideElectricity(ForgeDirection from, float request, boolean doProvide)
    {
        return this.storage.extractEnergy(request, !doProvide);
    }

    @Override
    public float getRequest(ForgeDirection direction)
    {
        return Math.min(this.storage.getCapacity() - this.storage.getEnergyStored(), this.storage.getMaxReceive());
    }

    @Override
    public float getProvide(ForgeDirection direction)
    {
        return 0;
    }

    public int getTier()
    {
        return this.tier;
    }

    public void setTier(int newTier)
    {
        this.tier = newTier;
    }
}