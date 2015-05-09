package dracocore.energy.mana;

import java.lang.reflect.Constructor;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.common.eventhandler.Event;
import dracocore.api.power.EnergyNetwork;
import dracocore.api.transmission.tile.IConductor;
import dracocore.api.transmission.tile.IElectrical;
import dracocore.api.vector.BlockVec3;
import dracocore.blocks.tileentity.mana.crystal.TileBaseManaTransducer;
import dracocore.energy.EnergyConfigHandler;
import dracocore.energy.EnergyUtil;
import dracocore.network.Annotations.RuntimeInterface;
import dracocore.network.Annotations.VersionSpecific;

public abstract class TileEntityManaTransducer extends TileBaseManaTransducer
{
    protected boolean isAddedToEnergyNet;
    protected Object powerHandlerBC;

    //	public float buildcraftBuffer = EnergyConfigHandler.BC3_RATIO * 50;
    private float IC2surplusJoules = 0F;

    public TileEntityManaTransducer()
    {
        this.initBC();
    }

    @Override
    public void onNetworkChanged()
    {
    }

    private void initBC()
    {
    }

    @Override
    public TileEntity[] getAdjacentConnections()
    {
        return EnergyUtil.getAdjacentPowerConnections(this);
    }

    @Override
    public boolean canUpdate()
    {
        return true;
    }

    @Override
    public void updateEntity()
    {
        super.updateEntity();

        if (!this.isAddedToEnergyNet)
        {
            if (!this.worldObj.isRemote)
            {
                if (EnergyConfigHandler.isIndustrialCraft2Loaded())
                {
                    this.initIC();
                }
            }

            this.isAddedToEnergyNet = true;
        }
    }

    @Override
    public void invalidate()
    {
        this.IC2surplusJoules = 0F;
        this.unloadTileIC2();
        super.invalidate();
    }

    @Override
    public void onChunkUnload()
    {
        this.unloadTileIC2();
        super.onChunkUnload();
    }

    protected void initIC()
    {
        if (EnergyConfigHandler.isIndustrialCraft2Loaded() && !this.worldObj.isRemote)
        {
            try
            {
                Class<?> tileLoadEvent = Class.forName("ic2.api.energy.event.EnergyTileLoadEvent");
                Class<?> energyTile = Class.forName("ic2.api.energy.tile.IEnergyTile");
                Constructor<?> constr = tileLoadEvent.getConstructor(energyTile);
                Object o = constr.newInstance(this);

                if (o != null && o instanceof Event)
                {
                    MinecraftForge.EVENT_BUS.post((Event) o);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    private void unloadTileIC2()
    {
        if (this.isAddedToEnergyNet && this.worldObj != null)
        {
            if (!this.worldObj.isRemote && EnergyConfigHandler.isIndustrialCraft2Loaded())
            {
                try
                {
                    Class<?> tileLoadEvent = Class.forName("ic2.api.energy.event.EnergyTileUnloadEvent");
                    Class<?> energyTile = Class.forName("ic2.api.energy.tile.IEnergyTile");
                    Constructor<?> constr = tileLoadEvent.getConstructor(energyTile);
                    Object o = constr.newInstance(this);

                    if (o != null && o instanceof Event)
                    {
                        MinecraftForge.EVENT_BUS.post((Event) o);
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            this.isAddedToEnergyNet = false;
        }
    }

    @VersionSpecific(version = "[1.7.2]")
    @RuntimeInterface(clazz = "ic2.api.energy.tile.IEnergySink", modID = "IC2")
    public double demandedEnergyUnits()
    {
        if (this.getNetwork() == null)
        {
            return 0.0;
        }

        if (this.IC2surplusJoules < 0.001F)
        {
            this.IC2surplusJoules = 0F;
            float result = this.getNetwork().getRequest(this) * EnergyConfigHandler.TO_IC2_RATIO;
            //Cap energy which IC2 can put into Alu Wire at 128 EU/t for regular, 256 EU/t for heavy
            result = Math.max(((EnergyNetwork) this.getNetwork()).networkTierGC == 2 ? 256F : 128F, result);
            return result;
        }

        this.IC2surplusJoules = this.getNetwork().produce(this.IC2surplusJoules, true, 1, this);
        if (this.IC2surplusJoules < 0.001F)
        {
            this.IC2surplusJoules = 0F;
            float result = this.getNetwork().getRequest(this) * EnergyConfigHandler.TO_IC2_RATIO;
            //Cap energy which IC2 can put into Alu Wire at 128 EU/t for regular, 256 EU/t for heavy
            result = Math.max(((EnergyNetwork) this.getNetwork()).networkTierGC == 2 ? 256F : 128F, result);
            return result;
        }
        return 0D;
    }

    @VersionSpecific(version = "[1.7.10]")
    @RuntimeInterface(clazz = "ic2.api.energy.tile.IEnergySink", modID = "IC2")
    public double getDemandedEnergy()
    {
        if (this.getNetwork() == null)
        {
            return 0.0;
        }

        if (this.IC2surplusJoules < 0.001F)
        {
            this.IC2surplusJoules = 0F;
            return this.getNetwork().getRequest(this) * EnergyConfigHandler.TO_IC2_RATIO;
        }

        this.IC2surplusJoules = this.getNetwork().produce(this.IC2surplusJoules, true, 1, this);
        if (this.IC2surplusJoules < 0.001F)
        {
            this.IC2surplusJoules = 0F;
            return this.getNetwork().getRequest(this) * EnergyConfigHandler.TO_IC2_RATIO;
        }
        return 0D;
    }

}
