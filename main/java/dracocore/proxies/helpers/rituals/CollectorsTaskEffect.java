package dracocore.proxies.helpers.rituals;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import dracocore.api.mana.RitualHandler;
import dracocore.blocks.tileentity.mana.crafting.TileEntityRitualAltar;
import dracocore.interfaces.IRitualAltar;

public class CollectorsTaskEffect 
{

	

	public static boolean canCombine(ItemStack stack1, ItemStack stack2)
	{
		if (stack1 == null)
		{
			return false;
		}
		if (stack2 == null)
		{
			return true;
		}
		if (stack1.isItemStackDamageable() ^ stack2.isItemStackDamageable())
		{
			return false;
		}
		boolean tagsEqual = ItemStack.areItemStackTagsEqual(stack1, stack2);
		return stack1.getItem() == stack2.getItem() && tagsEqual && stack1.getItemDamage() == stack2.getItemDamage() && Math.min(stack2.getMaxStackSize() - stack2.stackSize, stack1.stackSize) > 0;
	}

	public static ItemStack[] combineStacks(ItemStack stack1, ItemStack stack2)
	{
		ItemStack[] returned = new ItemStack[2];
		if (canCombine(stack1, stack2))
		{
			int transferedAmount = stack2 == null ? stack1.stackSize : Math.min(stack2.getMaxStackSize() - stack2.stackSize, stack1.stackSize);
			if (transferedAmount > 0)
			{
				ItemStack copyStack = stack1.splitStack(transferedAmount);
				if (stack2 == null)
				{
					stack2 = copyStack;
				} else
				{
					stack2.stackSize += transferedAmount;
				}
			}
		}
		returned[0] = stack1;
		returned[1] = stack2;
		return returned;
		}
	public static ItemStack insertStackIntoInventory(ItemStack stack, IInventory inventory)
	{
		if (stack == null)
		{
			return stack;
		}
		for (int i = 0; i < inventory.getSizeInventory(); i++)
		{
			ItemStack[] combinedStacks = combineStacks(stack, inventory.getStackInSlot(i));
			stack = combinedStacks[0];
			inventory.setInventorySlotContents(i, combinedStacks[1]);
			if (stack.stackSize <= 0)
			{
				return stack;
			}
		}
		return stack;
	}
	
	public static void performeffect(TileEntityRitualAltar altar1, ItemStack itemStack)
	{
		World world = altar1.getWorld();
		boolean isSilkTouch = RitualHandler.getFortuneUpgrade(altar1);
		int x = altar1.getXCoord();
		int y = altar1.getYCoord();
		int z = altar1.getZCoord();
		TileEntity tile = world.getTileEntity(x, y-1, z);
		IInventory tileEntity;
		if (tile instanceof IInventory)
		{
			tileEntity = (IInventory) tile;
		} else
		{
			return;
		}
		if (tileEntity.getSizeInventory() <= 0)
		{
			return;
		}
		boolean hasRoom = false;
		for (int i = 0; i < tileEntity.getSizeInventory(); i++)
		{
			if (tileEntity.getStackInSlot(i) == null)
			{
				hasRoom = true;
				break;
			}
		}
		if (!hasRoom)
		{
			return; //Prevents overflow
		}
		int fortuneLevel = RitualHandler.upgradeblocks(altar1)/4;
		
		for (int j = 5; j < 11; j++)
		{
			for (int i = -3-RitualHandler.upgradeblocks(altar1); i <= 3+RitualHandler.upgradeblocks(altar1); i++)
			{
				for (int k = -3-RitualHandler.upgradeblocks(altar1); k <= 3+RitualHandler.upgradeblocks(altar1); k++)
				{
					Block block = world.getBlock(x + i, y + j, z + k);
					int meta = world.getBlockMetadata(x + i, y + j, z + k);
					if (block != null && !world.isAirBlock(x + i, y + j, z + k))
					{
						if (isSilkTouch && block.canSilkHarvest(world, null, x + i, y + j, z + k, meta))
						{
							ItemStack item = new ItemStack(block, 1, meta);
							ItemStack copyStack = item.copyItemStack(item);
							insertStackIntoInventory(copyStack, tileEntity);
							if (copyStack.stackSize > 0)
							{
								world.spawnEntityInWorld(new EntityItem(world, x + 0.4, y + 2, z + 0.5, copyStack));
							}
						}
						else
						{
							ArrayList<ItemStack> itemDropList = block.getDrops(world, x + i, y + j, z + k, meta, fortuneLevel);
							if (itemDropList != null)
							{
								int invSize = tileEntity.getSizeInventory();
								for (ItemStack item : itemDropList)
								{
									ItemStack copyStack = item.copyItemStack(item);
									insertStackIntoInventory(copyStack, tileEntity);
									if (copyStack.stackSize > 0)
									{
										world.spawnEntityInWorld(new EntityItem(world, x + 0.4, y + 2, z + 0.5, copyStack));
									}
								}
							}
						}
						world.setBlockToAir(x + i, y + j, z + k);
						world.playSoundEffect(x + i, y + j, z + k, "mob.endermen.portal", 1.0F, 1.0F);
						return;
					}
				}
			}
		}
	}
}
