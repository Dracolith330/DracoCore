package dracocore.api.power;

import java.util.EnumSet;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;
import dracocore.api.network.ElectricItemHelper;
import dracocore.api.network.IItemElectric;
import dracocore.energy.tile.EnergyStorageTile;
import dracocore.network.Annotations.AltForVersion;
import dracocore.network.Annotations.VersionSpecific;
import dracocore.network.ReceiverMode;

public abstract class TileBaseUniversalElectrical extends EnergyStorageTile //implements IElectrical, IElectricalStorage
{
    protected boolean isAddedToEnergyNet;
    protected Object powerHandlerBC;

    @Override
    public double getPacketRange()
    {
        return 12.0D;
    }

    @Override
    public int getPacketCooldown()
    {
        return 3;
    }

    @Override
    public boolean isNetworkedTile()
    {
        return true;
    }

    public EnumSet<ForgeDirection> getElectricalInputDirections()
    {
        return EnumSet.allOf(ForgeDirection.class);
    }

    public EnumSet<ForgeDirection> getElectricalOutputDirections()
    {
        return EnumSet.noneOf(ForgeDirection.class);
    }

    @Override
    public float getRequest(ForgeDirection direction)
    {
        if (this.getElectricalInputDirections().contains(direction) || direction == ForgeDirection.UNKNOWN)
        	return super.getRequest(direction);
        
        return 0F;
    }

    @Override
    public float receiveElectricity(ForgeDirection from, float receive, int tier, boolean doReceive)
    {
        if (this.getElectricalInputDirections().contains(from) || from == ForgeDirection.UNKNOWN)
        {
        	return super.receiveElectricity(from, receive, tier, doReceive);
        }
        
        return 0F;
    }
    
    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
    }

    /**
     * Discharges electric item.
     */
    @VersionSpecific(version = "[1.7.2]")
    public void discharge(ItemStack itemStack)
    {
        if (itemStack != null)
        {
            Item item = itemStack.getItem();
            float energyToDischarge = this.getRequest(ForgeDirection.UNKNOWN);

            if (item instanceof IItemElectric)
            {
                this.storage.receiveEnergyGC(ElectricItemHelper.dischargeItem(itemStack, energyToDischarge));
            }
        }
    }

    @AltForVersion(version = "[1.7.10]")
    public void dischargeB(ItemStack itemStack)
    {
        if (itemStack != null)
        {
            Item item = itemStack.getItem();
            float energyToDischarge = this.getRequest(ForgeDirection.UNKNOWN);

            if (item instanceof IItemElectric)
            {
                this.storage.receiveEnergyGC(ElectricItemHelper.dischargeItem(itemStack, energyToDischarge));
            }
        }
    }

    @Override
    public void initiate()
    {
        super.initiate();
    }

    @Override
    public void updateEntity()
    {
        super.updateEntity();
    }


    @Override
    public void invalidate()
    {
        super.invalidate();
    }

    @Override
    public void onChunkUnload()
    {
        super.onChunkUnload();
    }

    @Override
    public ReceiverMode getModeFromDirection(ForgeDirection direction)
    {
        if (this.getElectricalInputDirections().contains(direction))
        {
            return ReceiverMode.RECEIVE;
        }
        else if (this.getElectricalOutputDirections().contains(direction))
        {
            return ReceiverMode.EXTRACT;
        }

        return null;
    }

    public void updateFacing()
    {
    }
}
