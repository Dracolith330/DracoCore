package dracocore.network;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;

public class WorldCoordinates
  implements Comparable
{
  public int x;
  public int y;
  public int z;
  public int dim;
  
  public WorldCoordinates() {}
  
  public WorldCoordinates(int par1, int par2, int par3, int d)
  {
    this.x = par1;
    this.y = par2;
    this.z = par3;
    this.dim = d;
  }
  
  public WorldCoordinates(TileEntity tile)
  {
    this.x = tile.xCoord;
    this.y = tile.yCoord;
    this.z = tile.zCoord;
    this.dim = tile.getWorldObj().provider.dimensionId;
  }
  
  public WorldCoordinates(WorldCoordinates par1ChunkCoordinates)
  {
    this.x = par1ChunkCoordinates.x;
    this.y = par1ChunkCoordinates.y;
    this.z = par1ChunkCoordinates.z;
    this.dim = par1ChunkCoordinates.dim;
  }
  
  public boolean equals(Object par1Obj)
  {
    if (!(par1Obj instanceof WorldCoordinates)) {
      return false;
    }
    WorldCoordinates coordinates = (WorldCoordinates)par1Obj;
    return (this.x == coordinates.x) && (this.y == coordinates.y) && (this.z == coordinates.z) && (this.dim == coordinates.dim);
  }
  
  public int hashCode()
  {
    return this.x + this.y << 8 + this.z << 16 + this.dim << 24;
  }
  
  public int compareWorldCoordinate(WorldCoordinates par1)
  {
    return this.dim == par1.dim ? this.y - par1.y : this.y == par1.y ? this.z - par1.z : this.z == par1.z ? this.x - par1.x : -1;
  }
  
  public void set(int par1, int par2, int par3, int d)
  {
    this.x = par1;
    this.y = par2;
    this.z = par3;
    this.dim = d;
  }
  
  public float getDistanceSquared(int par1, int par2, int par3)
  {
    float f = this.x - par1;
    float f1 = this.y - par2;
    float f2 = this.z - par3;
    return f * f + f1 * f1 + f2 * f2;
  }
  
  public float getDistanceSquaredToWorldCoordinates(WorldCoordinates par1ChunkCoordinates)
  {
    return getDistanceSquared(par1ChunkCoordinates.x, par1ChunkCoordinates.y, par1ChunkCoordinates.z);
  }
  
  public int compareTo(Object par1Obj)
  {
    return compareWorldCoordinate((WorldCoordinates)par1Obj);
  }
  
  public void readNBT(NBTTagCompound nbt)
  {
    this.x = nbt.getInteger("w_x");
    this.y = nbt.getInteger("w_y");
    this.z = nbt.getInteger("w_z");
    this.dim = nbt.getInteger("w_d");
  }
  
  public void writeNBT(NBTTagCompound nbt)
  {
    nbt.setInteger("w_x", this.x);
    nbt.setInteger("w_y", this.y);
    nbt.setInteger("w_z", this.z);
    nbt.setInteger("w_d", this.dim);
  }
}
