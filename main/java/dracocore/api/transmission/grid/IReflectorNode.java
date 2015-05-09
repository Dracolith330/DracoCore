package dracocore.api.transmission.grid;

import dracocore.api.vector.Vector3;

public interface IReflectorNode
{
    public Vector3 getInputPoint();

    public Vector3 getOutputPoint(boolean offset);
}
