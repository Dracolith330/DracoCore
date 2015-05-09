package dracocore.blocks.blockclasses.mana;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.WeightedRandom;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.oredict.OreDictionary;
import dracocore.api.transmission.NetworkType;
import dracocore.blocks.tileentity.mana.storage.TileManaStorage;

public class TileAcceleratedCrystalCluster extends TileManaStorage
{

	public int ticksExisted = 0;

	public TileAcceleratedCrystalCluster() 
	{
		super(1000000, 1000000);
	}
	
	@Override
    public EnumSet<ForgeDirection> getElectricalInputDirections()
    {
        return EnumSet.allOf(ForgeDirection.class);
    }
	
	@Override
    public EnumSet<ForgeDirection> getElectricalOutputDirections()
    {
        return EnumSet.noneOf(ForgeDirection.class);
    }

    @Override
    public EnumSet<ForgeDirection> getElectricalOutputDirectionMain()
    {
        return EnumSet.noneOf(ForgeDirection.class);
    }
	
	@Override
	public void updateEntity()
	{
		
		if(!this.getWorldObj().isRemote && this.storage.getEnergyStored() >= 200000 && ticksExisted % 100 == 0) {
			ChunkCoordinates coords = getCoordsToPut();
			if(coords != null) {
				ItemStack stack = getOreToPut();
				if(stack != null) 
				{
					Block block = Block.getBlockFromItem(stack.getItem());
					int meta = stack.getItemDamage();
					this.getWorldObj().setBlock(coords.posX, coords.posY, coords.posZ, block, meta, 1 | 2);
					this.getWorldObj().playAuxSFX(2001, coords.posX, coords.posY, coords.posZ, Block.getIdFromBlock(block) + (meta << 12));

		            this.storage.setEnergyStored(this.storage.getEnergyStored() - 200000);
				}
			}
		}
		
	}
	
	public ItemStack getOreToPut() {
		Collection<WeightedRandom.Item> values = new ArrayList();
		for(String s : OreDictionary.getOreNames())
			if((s.contains("ore") || s.contains("vein")) && !(s.matches("endercore")))
				values.add(new StringRandomItem(OreDictionary.getOreID(s), s));

		String ore = ((StringRandomItem) WeightedRandom.getRandomItem(this.getWorldObj().rand, values)).s;

		List<ItemStack> ores = OreDictionary.getOres(ore);

			for(ItemStack stack : ores) 
			{
				
				Item item = stack.getItem();
				String clname = item.getClass().getName();

				if((clname.startsWith("gregtech") || clname.startsWith("gregapi")))
					continue;

				return stack;
			}

		return getOreToPut();
	}
	
	public ChunkCoordinates getCoordsToPut() {
		List<ChunkCoordinates> possibleCoords = new ArrayList();

		for(int i = -3; i < 3 + 1; i++)
			for(int j = -3; j < 3; j++)
				for(int k = -3; k < 3 + 1; k++) {
					int x = this.xCoord + i;
					int y = this.yCoord + j;
					int z = this.zCoord + k;
					Block block = this.getWorldObj().getBlock(x, y, z);
					if(block != null && block.isReplaceableOreGen(this.getWorldObj(), x, y, z, Blocks.stone))
						possibleCoords.add(new ChunkCoordinates(x, y, z));
				}

		if(possibleCoords.isEmpty())
			return null;
		return possibleCoords.get(this.getWorldObj().rand.nextInt(possibleCoords.size()));
	}
	
	@Override
    public boolean canConnect(ForgeDirection direction, NetworkType type)
    {
        if (direction == null || direction.equals(ForgeDirection.UNKNOWN) || type != NetworkType.MANA)
        {
            return false;
        }

        int metadata = this.getBlockMetadata() & 3;

        return direction == ForgeDirection.getOrientation(metadata) || direction == ForgeDirection.getOrientation((metadata));
    }
	
	private static class StringRandomItem extends WeightedRandom.Item {

		public String s;

		public StringRandomItem(int par1, String s) {
			super(par1);
			this.s = s;
		}

	}
	
	@Override
    public String getInventoryName()
    {
        return "TEManaCrystalSource";
    }
	
	@Override
    public boolean hasCustomInventoryName()
    {
        return false;
    }
	
}
