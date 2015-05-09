package dracocore.network;

import net.minecraft.tileentity.TileEntity;
import dracocore.api.power.IEnergyHandler;
import dracocore.api.vector.BlockVec3;
import dracocore.api.vector.Vector3;

public interface ILaserNode extends IEnergyHandler
{
    public Vector3 getInputPoint();

    public Vector3 getOutputPoint(boolean offset);

    public ILaserNode getTarget();

    public TileEntity getTile();

    public boolean canConnectTo(ILaserNode node);

    public Vector3 getColor();

    public void addNode(ILaserNode node);

    public void removeNode(ILaserNode node);

    public int compareTo(ILaserNode otherNode, BlockVec3 origin);
}
