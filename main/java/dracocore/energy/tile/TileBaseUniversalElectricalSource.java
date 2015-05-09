package dracocore.energy.tile;

import java.util.EnumSet;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import dracocore.api.network.ElectricItemHelper;
import dracocore.api.network.IItemElectric;
import dracocore.api.power.TileBaseUniversalElectrical;
import dracocore.api.transmission.grid.IElectricityNetwork;
import dracocore.api.transmission.tile.IConductor;
import dracocore.api.vector.BlockVec3;
import dracocore.energy.EnergyUtil;

public class TileBaseUniversalElectricalSource extends TileBaseUniversalElectrical
{
    public float produce()
    {
        return this.extractEnergy(null, this.produce(false), false);
    }

    public float produce(boolean simulate)
    {
        float amountProduced = 0;

        if (!this.worldObj.isRemote)
        {
            EnumSet<ForgeDirection> outputDirections = this.getElectricalOutputDirections();
            outputDirections.remove(ForgeDirection.UNKNOWN);

            BlockVec3 thisVec = new BlockVec3(this);
            for (ForgeDirection direction : outputDirections)
            {
                TileEntity tileAdj = thisVec.getTileEntityOnSide(this.worldObj, direction);

                if (tileAdj != null)
                {
                    float toSend = this.extractEnergy(null, Math.min(this.getEnergyStored() - amountProduced, this.getEnergyStored() / outputDirections.size()), true);
                    if (toSend <= 0)
                    {
                        continue;
                    }

                    if (tileAdj instanceof TileBaseConductor)
                    {
                        IElectricityNetwork network = ((IConductor) tileAdj).getNetwork();
                        if (network != null)
                        {
                            amountProduced += (toSend - network.produce(toSend, !simulate, this.tier, this));
                        }
                    }
                    else if (tileAdj instanceof TileBaseUniversalElectrical)
                    {
                  		amountProduced += ((TileBaseUniversalElectrical) tileAdj).receiveElectricity(direction.getOpposite(), toSend, this.tier, !simulate);
                    }
                    else
                    {
                        amountProduced += EnergyUtil.otherModsEnergyTransfer(tileAdj, direction.getOpposite(), toSend, simulate);
                    }
                }
            }
        }

        return amountProduced;
    }

    /**
     * Recharges electric item.
     */
    public void recharge(ItemStack itemStack)
    {
        if (itemStack != null)
        {
            Item item = itemStack.getItem();
            float maxExtractSave = this.storage.getMaxExtract();
            if (this.tier > 1)
            {
                this.storage.setMaxExtract(maxExtractSave * 2.5F);
            }
            float energyToCharge = this.storage.extractEnergy(this.storage.getMaxExtract(), true);

            if (item instanceof IItemElectric)
            {
                this.storage.extractEnergy(ElectricItemHelper.chargeItem(itemStack, energyToCharge), false);
            }

            if (this.tier > 1)
            {
                this.storage.setMaxExtract(maxExtractSave);
            }
        }
    }

    @Override
    public float getProvide(ForgeDirection direction)
    {
       
        if (this.getElectricalOutputDirections().contains(direction))
        {
            return this.storage.extractEnergy(Float.MAX_VALUE, true);
        }

        return 0F;
    }

    public EnumSet<ForgeDirection> getElectricalOutputDirectionMain()
    {
        return EnumSet.allOf(ForgeDirection.class);
    }

}
