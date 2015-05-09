package dracocore.proxies.helpers.rituals;

import net.minecraft.block.Block;
import net.minecraft.block.BlockMobSpawner;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import dracocore.api.mana.RitualEffect;
import dracocore.api.mana.RitualHandler;
import dracocore.blocks.tileentity.mana.crafting.TileEntityRitualAltar;
import dracocore.interfaces.IRitualAltar;

public class GaiasGiftEffect extends RitualEffect
{
	@Override
	public void performEffect(TileEntityRitualAltar altar1)
	{
		String[] blockblacklist = new String[]{Blocks.bedrock.getLocalizedName().toString(), Blocks.air.getLocalizedName().toString(), Blocks.command_block.getLocalizedName().toString(), Blocks.end_portal.getLocalizedName().toString(), Blocks.end_portal_frame.getLocalizedName().toString(), Blocks.portal.getLocalizedName().toString()};
		
		World world = altar1.getWorld();
		int x = altar1.getXCoord();
		int y = altar1.getYCoord() + 5;
		int z = altar1.getZCoord();
		
		int x1 = RitualHandler.upgradeblocks(altar1)/5;
		
		int xRep = 0;
		int yRep = 0;
		int zRep = 0;
		boolean replace = false;
		for (int j = 0; j <= 3+x1; j++)
		{
			for (int i = -1-x1; i <= 1+x1; i++)
			{
				for (int k = -1-x1; k <= 1+x1; k++)
				{

      	          	if ((!replace) && world.isAirBlock(x + i, y + j, z + k))
      	          	{
      	          		xRep = x + i;
      	          		yRep = y + j;
      	          		zRep = z + k;
      	          		replace = true;
      	          	}
				}
			}
		}
		if (replace)
		{
			for (int j = y - 1; j >= 0; j--)
			{
				for (int i = -4*RitualHandler.upgradeblocks(altar1)/2; i <= 4*RitualHandler.upgradeblocks(altar1)/2; i++)
				{
					for (int k = -4*RitualHandler.upgradeblocks(altar1)/2; k <= 4*RitualHandler.upgradeblocks(altar1)/2; k++)
					{
						Block block = world.getBlock(x + i, j, z + k);
						int meta = world.getBlockMetadata(x + i, j, z + k);
						if (block == null)
						{
							continue;
						}
						ItemStack itemStack = new ItemStack(block, 1, meta);
						int id = OreDictionary.getOreID(itemStack);
						
						if(altar1.slots.get(0) != null && altar1.slots.get(0).getStackInSlot(0) != null)
						{
							if(Item.getItemFromBlock(block) == altar1.slots.get(0).getStackInSlot(0).getItem() && altar1.getStackInSlot(0) != null)
							{
								ItemStack k4 = new ItemStack(altar1.getStackInSlot(0).getItem(), 1, (altar1.getStackInSlot(0).getItemDamage() + 1));
								altar1.setInventorySlotContents(0, k4);
								if(k4.getItemDamage() >= k4.getMaxDamage())
								{
									 altar1.setInventorySlotContents(0, null);
								}
								altar1.markDirty();
								swapBlocks(world, world, x + i, j, z + k, xRep, yRep, zRep);
								return;
							}
							if(altar1.slots.get(0).getStackInSlot(0).getItem() == Items.name_tag)
							{
								if(block.getLocalizedName().contains(altar1.slots.get(0).getStackInSlot(0).getDisplayName()) && !(blockblacklist.equals(block.getLocalizedName().toString())))
								{
									ItemStack k4 = new ItemStack(altar1.getStackInSlot(0).getItem(), 1, (altar1.getStackInSlot(0).getItemDamage() + 1));
									altar1.setInventorySlotContents(0, k4);
									if(k4.getItemDamage() >= k4.getMaxDamage())
									{
										 altar1.setInventorySlotContents(0, null);
									}
									altar1.markDirty();
									swapBlocks(world, world, x + i, j, z + k, xRep, yRep, zRep);
									return;
								}
							}
						}
						
						else if (id != -1 && altar1.getStackInSlot(0) != null)
						{
							String oreName = OreDictionary.getOreName(id);
							if (oreName.contains("ore"))
							{
								ItemStack k4 = new ItemStack(altar1.getStackInSlot(0).getItem(), 1, (altar1.getStackInSlot(0).getItemDamage() + 1));
								altar1.setInventorySlotContents(0, k4);
								if(k4.getItemDamage() >= k4.getMaxDamage())
								{
									 altar1.setInventorySlotContents(0, null);
								}
								altar1.markDirty();
								swapBlocks(world, world, x + i, j, z + k, xRep, yRep, zRep);
								return;
							}
						}
					}
				}
			}
		}
	}
	
	
	public static boolean swapBlocks(World worldI, World worldF, int xi, int yi, int zi, int xf, int yf, int zf)
	{
		TileEntity tileEntityI = worldI.getTileEntity(xi, yi, zi);
		TileEntity tileEntityF = worldF.getTileEntity(xf, yf, zf);
		TileEntity tileI;
		TileEntity tileF;
		NBTTagCompound nbttag1 = new NBTTagCompound();
		NBTTagCompound nbttag2 = new NBTTagCompound();
		if (tileEntityI != null)
		{
			tileEntityI.writeToNBT(nbttag1);
		}
		if (tileEntityF != null)
		{
			tileEntityF.writeToNBT(nbttag2);
		}
		Block blockI = worldI.getBlock(xi, yi, zi);
		Block blockF = worldF.getBlock(xf, yf, zf);
		if (blockI.equals(Blocks.air) && blockF.equals(Blocks.air))
		{
			return false;
		}
		if (blockI instanceof BlockMobSpawner || blockF instanceof BlockMobSpawner)
		{
			return false;
		}
		int metaI = worldI.getBlockMetadata(xi, yi, zi);
		int metaF = worldF.getBlockMetadata(xf, yf, zf);
		worldI.playSoundEffect(xi, yi, zi, "mob.endermen.portal", 1.0F, 1.0F);
		worldF.playSoundEffect(xf, yf, zf, "mob.endermen.portal", 1.0F, 1.0F);
		//CLEAR TILES
		Block finalBlock = blockF;
		if (finalBlock != null)
		{
			TileEntity tileToSet = finalBlock.createTileEntity(worldF, metaF);
			worldF.setTileEntity(xf, yf, zf, tileToSet);
		}
		Block initialBlock = blockI;
		if (initialBlock != null)
		{
			TileEntity tileToSet = initialBlock.createTileEntity(worldI, metaI);
			worldI.setTileEntity(xi, yi, zi, tileToSet);
		}
		//TILES CLEARED
		worldF.setBlock(xf, yf, zf, initialBlock, metaI, 3);
		if (tileEntityI != null)
		{
			TileEntity newTileEntityI = TileEntity.createAndLoadEntity(nbttag1);
			worldF.setTileEntity(xf, yf, zf, newTileEntityI);
			newTileEntityI.xCoord = xf;
			newTileEntityI.yCoord = yf;
			newTileEntityI.zCoord = zf;
		}
		worldI.setBlock(xi, yi, zi, finalBlock, metaF, 3);
		if (tileEntityF != null)
		{
			TileEntity newTileEntityF = TileEntity.createAndLoadEntity(nbttag2);
			worldI.setTileEntity(xi, yi, zi, newTileEntityF);
			newTileEntityF.xCoord = xi;
			newTileEntityF.yCoord = yi;
			newTileEntityF.zCoord = zi;
		}
		return true;
	}
}
