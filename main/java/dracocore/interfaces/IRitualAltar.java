package dracocore.interfaces;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public interface IRitualAltar
{
	public void performRitual(World world, int x, int y, int z, String ritualID);
	public void setCooldown(int newCooldown);
	public int getCooldown();
	public void setVar1(int newVar1);
	public int getVar1();
	public void setActive(boolean active);
	public int getDirection();
	public World getWorld();
	public int getXCoord();
	public int getYCoord();
	public int getZCoord();
	public NBTTagCompound getCustomRitualTag();
	public void setCustomRitualTag(NBTTagCompound tag);
}