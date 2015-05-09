package dracocore.blocks.tileentity.mana.crystal;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dracocore.api.power.EnergyNetwork;
import dracocore.api.transmission.NetworkType;
import dracocore.api.transmission.grid.IElectricityNetwork;
import dracocore.api.transmission.grid.IGridNetwork;
import dracocore.api.transmission.tile.IConductor;
import dracocore.api.transmission.tile.IConnector;
import dracocore.api.transmission.tile.INetworkProvider;
import dracocore.api.vector.BlockVec3;
import dracocore.blocks.tileentity.generic.TileEntityAdvanced;
import dracocore.proxies.tickhandlers.TickHandlerServer;

@SuppressWarnings({ "unchecked", "rawtypes" })
public abstract class TileBaseManaTransducer extends TileEntityAdvanced implements IConductor
{
    private IGridNetwork network;

    public TileEntity[] adjacentConnections = null;

    @Override
    public void validate()
    {
    	super.validate();
    	if (!this.worldObj.isRemote)
    	{
    		TickHandlerServer.manaTransmitterUpdates.add(this);
    	}
    }
    
    @Override
    public void invalidate()
    {
        if (!this.worldObj.isRemote)
        {
            this.getNetwork().split(this);
        }

        super.invalidate();
    }

    @Override
    public boolean canUpdate()
    {
        return false;
    }

    @Override
    public IElectricityNetwork getNetwork()
    {
        if (this.network == null)
        {
            EnergyNetwork network = new EnergyNetwork();
            network.getTransmitters().add(this);
            this.setNetwork(network);
        }

        return (IElectricityNetwork) this.network;
    }

    @Override
    public void setNetwork(IGridNetwork network)
    {
        this.network = network;
    }

    @Override
    public void refresh()
    {
        if (!this.worldObj.isRemote)
        {
            this.adjacentConnections = null;

            this.getNetwork().refresh();
            

            BlockVec3 thisVec = new BlockVec3(this);
            for (ForgeDirection side : ForgeDirection.VALID_DIRECTIONS)
            {
                TileEntity tileEntity = thisVec.getTileEntityOnSide(this.worldObj, side);

                if (tileEntity != null)
                {
                    if (tileEntity.getClass() == this.getClass() && tileEntity instanceof INetworkProvider && !this.getNetwork().equals(((INetworkProvider) tileEntity).getNetwork()))
                    {
                    	((INetworkProvider) tileEntity).getNetwork().merge(this.getNetwork());
                    }
                }
            }
        }
    }

    @Override
    public TileEntity[] getAdjacentConnections()
    {
        /**
         * Cache the adjacentConnections.
         */
        if (this.adjacentConnections == null)
        {
            this.adjacentConnections = new TileEntity[6];

            BlockVec3 thisVec = new BlockVec3(this);
            for (int i = 0; i < 6; i++)
            {
                ForgeDirection side = ForgeDirection.getOrientation(i);
                TileEntity tileEntity = thisVec.getTileEntityOnSide(this.worldObj, side);

                if (tileEntity instanceof IConnector)
                {
                    if (((IConnector) tileEntity).canConnect(side.getOpposite(), NetworkType.MANA))
                    {
                        this.adjacentConnections[i] = tileEntity;
                    }
                }
            }
        }

        return this.adjacentConnections;
    }

    @Override
    public boolean canConnect(ForgeDirection direction, NetworkType type)
    {
        return type == NetworkType.MANA;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getRenderBoundingBox()
    {
        return AxisAlignedBB.getBoundingBox(this.xCoord, this.yCoord, this.zCoord, this.xCoord + 1, this.yCoord + 1, this.zCoord + 1);
    }

    @Override
    public NetworkType getNetworkType()
    {
        return NetworkType.MANA;
    }
}
