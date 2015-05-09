package dracocore.api.mana;

import java.util.Random;

import dracocore.blocks.tileentity.mana.crafting.TileEntityRitualAltar;
import dracocore.blocks.tileentity.mana.storage.TileManaStorage;
import dracocore.interfaces.IRitualAltar;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class RitualHandler 
{

	private static EntityPlayer player;
	private static World world;
	static int x;
	static int y;
	static int z;
	static Random rand;
	
	static TileEntityRitualAltar altar;
	static TileManaStorage ManaCrystal;
	
	public static void RitualHandlerBegin(World localworld, EntityPlayer localplayer, int localx, int localy, int localz, TileEntityRitualAltar tile)
	{

		world = localworld;
		player = localplayer;
		x = localx;
		y = localy;
		z = localz;
		altar = tile;
	
		
		
	}
	
	public static int upgradeblocks(IRitualAltar altar)
	{
		
		int i = 1;
		
		int[] xcoords = new int[]{altar.getXCoord()+1, altar.getXCoord()+2, altar.getXCoord()+2, altar.getXCoord()+2, altar.getXCoord()+2, altar.getXCoord()+1, altar.getXCoord()-1, altar.getXCoord()-2, altar.getXCoord()-2, altar.getXCoord()-2, altar.getXCoord()-2, altar.getXCoord()-1};
		int[] zcoords = new int[]{altar.getZCoord()-2, altar.getZCoord()-2, altar.getZCoord()-1, altar.getZCoord()+1, altar.getZCoord()+2, altar.getZCoord()+2, altar.getZCoord()+2, altar.getZCoord()+2, altar.getZCoord()+1, altar.getZCoord()-1, altar.getZCoord()-2, altar.getZCoord()-2};
		
		for(int x = 0; x < xcoords.length; x++)
		{
			if(altar.getWorld().getBlock(xcoords[x], altar.getYCoord()-1, zcoords[x]) == Blocks.bookshelf)
			{
				i++;
			}
			else if(altar.getWorld().getBlock(xcoords[x], altar.getYCoord()-1, zcoords[x]) == Blocks.diamond_block)
			{
				i+=2;
			}
			//else if(altar.getWorld().getBlock(xcoords[x], altar.getYCoord()-1, zcoords[x]) == BlocksMain.RunicUpgrade)
			//{
			//	i+=3;
			//}
			else{}
		}
		
		
		return i;
	}
	public static int getSpeedUpgrades(IRitualAltar altar)
	{
		
		int i = 1;
		
		int[] xcoords = new int[]{altar.getXCoord()+1, altar.getXCoord()+2, altar.getXCoord()+2, altar.getXCoord()+2, altar.getXCoord()+2, altar.getXCoord()+1, altar.getXCoord()-1, altar.getXCoord()-2, altar.getXCoord()-2, altar.getXCoord()-2, altar.getXCoord()-2, altar.getXCoord()-1};
		int[] zcoords = new int[]{altar.getZCoord()-2, altar.getZCoord()-2, altar.getZCoord()-1, altar.getZCoord()+1, altar.getZCoord()+2, altar.getZCoord()+2, altar.getZCoord()+2, altar.getZCoord()+2, altar.getZCoord()+1, altar.getZCoord()-1, altar.getZCoord()-2, altar.getZCoord()-2};
		
		for(int x = 0; x < xcoords.length; x++)
		{
			if(altar.getWorld().getBlock(xcoords[x], altar.getYCoord()-1, zcoords[x]) == Blocks.bookshelf)
			{
				i++;
			}
			else if(altar.getWorld().getBlock(xcoords[x], altar.getYCoord()-1, zcoords[x]) == Blocks.diamond_block)
			{
				i+=2;
			}
			
			else{}
		}
		
		
		return i;
	}
	public static boolean getFortuneUpgrade(IRitualAltar altar)
	{
		
		boolean i = false;
		
		int[] xcoords = new int[]{altar.getXCoord()+1, altar.getXCoord()+2, altar.getXCoord()+2, altar.getXCoord()+2, altar.getXCoord()+2, altar.getXCoord()+1, altar.getXCoord()-1, altar.getXCoord()-2, altar.getXCoord()-2, altar.getXCoord()-2, altar.getXCoord()-2, altar.getXCoord()-1};
		int[] zcoords = new int[]{altar.getZCoord()-2, altar.getZCoord()-2, altar.getZCoord()-1, altar.getZCoord()+1, altar.getZCoord()+2, altar.getZCoord()+2, altar.getZCoord()+2, altar.getZCoord()+2, altar.getZCoord()+1, altar.getZCoord()-1, altar.getZCoord()-2, altar.getZCoord()-2};
		
		for(int x = 0; x < xcoords.length; x++)
		{
			if(altar.getWorld().getBlock(xcoords[x], altar.getYCoord()-1, zcoords[x]) == Blocks.bookshelf)
			{
				i = true;
			}
			
			else{}
		}
		
		
		return i;
	}
	
}
