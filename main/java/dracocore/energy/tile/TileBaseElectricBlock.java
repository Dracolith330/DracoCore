package dracocore.energy.tile;

import java.util.EnumSet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import dracocore.api.network.IPacketReceiver;
import dracocore.api.power.TileBaseUniversalElectrical;
import dracocore.api.tile.IDisableableMachine;
import dracocore.api.transmission.NetworkType;
import dracocore.api.transmission.tile.IConnector;
import dracocore.network.Annotations.NetworkedField;
import dracocore.network.Annotations.RuntimeInterface;

public abstract class TileBaseElectricBlock extends TileBaseUniversalElectrical implements IPacketReceiver, IDisableableMachine, IConnector
{
    //	public int energyPerTick = 200;
    //	private final float ueMaxEnergy;

    @NetworkedField(targetSide = Side.CLIENT)
    public boolean disabled = false;
    @NetworkedField(targetSide = Side.CLIENT)
    public int disableCooldown = 0;
    @NetworkedField(targetSide = Side.CLIENT)
    public boolean hasEnoughEnergyToRun = false;

    public boolean shouldPullEnergy()
    {
        return this.shouldUseEnergy() || this.getEnergyStored(null) < this.getMaxEnergyStored();
    }

    public abstract boolean shouldUseEnergy();

    public abstract ForgeDirection getElectricInputDirection();

    public abstract ItemStack getBatteryInSlot();

    //	public TileBaseElectricBlock()
    //	{
    //		this.storage.setMaxReceive(ueWattsPerTick);
    //		this.storage.setMaxExtract(0);
    //		this.storage.setCapacity(maxEnergy);
    ////		this.ueMaxEnergy = maxEnergy;
    ////		this.ueWattsPerTick = ueWattsPerTick;
    //
    //		/*
    //		 * if (PowerFramework.currentFramework != null) { this.bcPowerProvider =
    //		 * new GCCoreLinkedPowerProvider(this);
    //		 * this.bcPowerProvider.configure(20, 1, 10, 10, 1000); }
    //		 */
    //	}

    //	@Override
    //	public float getMaxEnergyStored()
    //	{
    //		return this.ueMaxEnergy;
    //	}

    public int getScaledElecticalLevel(int i)
    {
        return (int) Math.floor(this.getEnergyStored(null) * i / this.getMaxEnergyStored(null));
        //- this.ueWattsPerTick;
    }

    //	@Override
    //	public float getRequest(ForgeDirection direction)
    //	{
    //		if (this.shouldPullEnergy())
    //		{
    //			return this.ueWattsPerTick * 2;
    //		}
    //		else
    //		{
    //			return 0;
    //		}
    //	}
    //
    //	@Override
    //	public float getProvide(ForgeDirection direction)
    //	{
    //		return 0;
    //	}

    @Override
    public void updateEntity()
    {
        if (!this.worldObj.isRemote)
        {
            if (this.shouldPullEnergy() && this.getEnergyStored(null) < this.getMaxEnergyStored(null) && this.getBatteryInSlot() != null && this.getElectricInputDirection() != null)
            {
                this.discharge(this.getBatteryInSlot());
                // this.receiveElectricity(this.getElectricInputDirection(),
                // ElectricityPack.getFromWatts(ElectricItemHelper.dischargeItem(this.getBatteryInSlot(),
                // this.getRequest(ForgeDirection.UNKNOWN)), this.getVoltage()),
                // true);
            }

            if (this.getEnergyStored(null) > this.storage.getMaxExtract())
            {
                this.hasEnoughEnergyToRun = true;
                if (this.shouldUseEnergy())
                {
                    this.storage.extractEnergy(this.storage.getMaxExtract(), false);
                }
            }
            else
            {
                this.hasEnoughEnergyToRun = false;
                if (this.getEnergyStored(null) > 0) this.storage.extractEnergy(5F, false);
            }
        }

        super.updateEntity();

        if (!this.worldObj.isRemote)
        {
            if (this.disableCooldown > 0)
            {
                this.disableCooldown--;
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);

        nbt.setBoolean("isDisabled", this.getDisabled(0));
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);

        this.setDisabled(0, nbt.getBoolean("isDisabled"));
    }

    @Override
    public void setDisabled(int index, boolean disabled)
    {
        if (this.disableCooldown == 0)
        {
            this.disabled = disabled;
            this.disableCooldown = 10;
        }
    }

    @Override
    public boolean getDisabled(int index)
    {
        return this.disabled;
    }

    @RuntimeInterface(clazz = "ic2.api.tile.IWrenchable", modID = "IC2")
    public boolean wrenchCanSetFacing(EntityPlayer entityPlayer, int side)
    {
        return false;
    }

    @RuntimeInterface(clazz = "ic2.api.tile.IWrenchable", modID = "IC2")
    public short getFacing()
    {
        return (short) this.worldObj.getBlockMetadata(MathHelper.floor_double(this.xCoord), MathHelper.floor_double(this.yCoord), MathHelper.floor_double(this.zCoord));
    }

    @RuntimeInterface(clazz = "ic2.api.tile.IWrenchable", modID = "IC2")
    public void setFacing(short facing)
    {

    }

    @RuntimeInterface(clazz = "ic2.api.tile.IWrenchable", modID = "IC2")
    public boolean wrenchCanRemove(EntityPlayer entityPlayer)
    {
        return false;
    }

    @RuntimeInterface(clazz = "ic2.api.tile.IWrenchable", modID = "IC2")
    public float getWrenchDropRate()
    {
        return 1.0F;
    }

    @RuntimeInterface(clazz = "ic2.api.tile.IWrenchable", modID = "IC2")
    public ItemStack getWrenchDrop(EntityPlayer entityPlayer)
    {
        return this.getBlockType().getPickBlock(null, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
    }

    @Override
    public EnumSet<ForgeDirection> getElectricalInputDirections()
    {
        if (this.getElectricInputDirection() == null)
        {
            return EnumSet.noneOf(ForgeDirection.class);
        }

        return EnumSet.of(this.getElectricInputDirection());
    }

    public boolean isUseableByPlayer(EntityPlayer entityplayer)
    {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this && entityplayer.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64.0D;
    }

    @Override
    public boolean canConnect(ForgeDirection direction, NetworkType type)
    {
        if (direction == null || direction.equals(ForgeDirection.UNKNOWN) || type != NetworkType.POWER)
        {
            return false;
        }

        return direction == this.getElectricInputDirection();
    }
}
