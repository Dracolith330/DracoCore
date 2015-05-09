package dracocore.blocks.tileentity.mana.generator;

import java.util.EnumSet;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import dracocore.api.network.IPacketReceiver;
import dracocore.api.transmission.NetworkType;
import dracocore.api.transmission.tile.IConnector;
import dracocore.api.vector.BlockVec3;
import dracocore.energy.tile.TileBaseUniversalElectricalSource;
import dracocore.network.ISolarLevel;
import dracocore.proxies.Config;

public class TileEntitySolarManaGenerator extends TileBaseUniversalElectricalSource implements IInventory, ISidedInventory, IPacketReceiver, IConnector
{
	public static final int sizeInv = 1;
    private ItemStack[] inv;
	int timer = 0;
    static TileEntityCrystalManaSource ThisCrystal;
    public float targetAngle;
    public float currentAngle;
    public int solarStrength = 0;
    public boolean disabled = false;
    public int generateWatts = 0;
    private boolean initialised = false;
    public static final int MAX_GENERATE_WATTS = Config.SolarManaGeneratorManaPerSecond;
    
    public TileEntitySolarManaGenerator()
    {
    	this(1);
    }
    
	public TileEntitySolarManaGenerator(int tier)
    {
        this.inv = new ItemStack[1];this.storage.setMaxExtract(TileEntitySolarManaGenerator.MAX_GENERATE_WATTS);
    	this.storage.setMaxReceive(TileEntitySolarManaGenerator.MAX_GENERATE_WATTS);
    	if (tier == 2)
    	{
    		this.storage.setCapacity(1000000);
    	}
    	this.setTier(tier);
    	this.initialised = true;
    }
    @Override
    public void updateEntity()
    {
    	if (!this.initialised)
    	{
    		int metadata = this.getBlockMetadata();
    		this.storage.setCapacity(1000000);
    		this.initialised = true;
    	}
    	this.receiveEnergy(null, this.generateWatts, false);
    	
    	super.updateEntity();
    	
    	if (!this.worldObj.isRemote)
    	{
    		if (!this.getDisabled(0) && this.ticks % 20 == 0)
    		{
    			this.solarStrength = 0;
    			if (this.worldObj.isDaytime() || !this.worldObj.isRaining() && !this.worldObj.isThundering())
    			{
    				double distance = 100.0D;
    				double sinA = -Math.sin((this.currentAngle - 77.5D) * Math.PI / 180.0D);
    				double cosA = Math.abs(Math.cos((this.currentAngle - 77.5D) * Math.PI / 180.0D));
    				for (int x = -1; x <= 1; x++)
    				{
    					for (int z = -1; z <= 1; z++)
    					{
    						if (this.tier == 1)
    						{
    							if (this.worldObj.canBlockSeeTheSky(this.xCoord + x, this.yCoord + 2, this.zCoord + z))
    							{
    								boolean valid = true;
    								for (int y = this.yCoord + 3; y < 256; y++)
    								{
    									Block block = this.worldObj.getBlock(this.xCoord + x, y, this.zCoord + z);
    									if (block.isOpaqueCube())
    									{
    										valid = false;
    										break;
    									}
    								}
    								if (valid)
    								{
    									this.solarStrength++;
    								}
    							}
    						}
    						else
    						{
    							boolean valid = true;
    							BlockVec3 blockVec = new BlockVec3(this).translate(x, 3, z);
    							for (double d = 0.0D; d < distance; d++)
    							{
    								BlockVec3 blockAt = blockVec.clone().translate((int) (d * sinA), (int) (d * cosA), 0);
    								Block block = blockAt.getBlock(this.worldObj);
    								if (block.isOpaqueCube())
    								{
    									valid = false;
    									break;
    								}
    							}
    							if (valid)
    							{
    								this.solarStrength++;
    							}
    						}
    					}
    				}
    			}
    		}
    	}
    	float angle = this.worldObj.getCelestialAngle(1.0F) - 0.7845194F < 0 ? 1.0F - 0.7845194F : -0.7845194F;
    	float celestialAngle = (this.worldObj.getCelestialAngle(1.0F) + angle) * 360.0F;
    	celestialAngle %= 360;
    	if (this.tier == 1)
    	{
    		if (!this.worldObj.isDaytime() || this.worldObj.isRaining() || this.worldObj.isThundering())
    		{
    			this.targetAngle = 77.5F + 180.0F;
    		}
    		else
    		{
    			this.targetAngle = 77.5F;
    		}
    	}
    	else
    	{
    		if (celestialAngle > 30 && celestialAngle < 150)
    		{
    			float difference = this.targetAngle - celestialAngle;
    			this.targetAngle -= difference / 20.0F;
    		}
    		else if (!this.worldObj.isDaytime() || this.worldObj.isRaining() || this.worldObj.isThundering())
    		{
    			this.targetAngle = 77.5F + 180.0F;
    		}
    		else if (celestialAngle < 50)
    		{
    			this.targetAngle = 50;
    		}
    		else if (celestialAngle > 150)
    		{
    			this.targetAngle = 150;
    		}
    	}
    	
    	float difference = this.targetAngle - this.currentAngle;
    	this.currentAngle += difference / 20.0F;
    	if (!this.worldObj.isRemote)
    	{
    		if (this.getGenerate() > 0.0F)
    		{
    			this.generateWatts = Math.min(Math.max(this.getGenerate(), 0), TileEntitySolarManaGenerator.MAX_GENERATE_WATTS);
    		}
    		else
    		{
    			this.generateWatts = 0;
    		}
    	}
    	this.produce();
    }
    
    public int getGenerate()
    {
    	if (this.getDisabled(0))
    	{
    		return 0;
    	}
    	float angle = this.worldObj.getCelestialAngle(1.0F) - 0.784690560F < 0 ? 1.0F - 0.784690560F : -0.784690560F;
    	float celestialAngle = (this.worldObj.getCelestialAngle(1.0F) + angle) * 360.0F;
    	
    	celestialAngle %= 360;
    	float difference = (180.0F - Math.abs(this.currentAngle % 180 - celestialAngle)) / 180.0F;
    	
    	return (int) Math.floor(1 / 100.0F * difference * difference * (this.solarStrength * (Math.abs(difference) * 500.0F)) * this.getSolarBoost());
    }
    
    public float getSolarBoost()
    {
    	return (float) (this.worldObj.provider instanceof ISolarLevel ? ((ISolarLevel) this.worldObj.provider).getSolarEnergyMultiplier() : 1.0F);
    }

    public int getRSPowerOutput()
    {
        return 5;
    }
    public boolean getDisabled(int index)
    {
    	return this.disabled;
    }
    @Override
    public int getSizeInventory()
    {
        return inv.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot)
    {
        return inv[slot];
    }
    
    
    public void activateRitual(World world, EntityPlayer player)
    {
    	if (world.isRemote)
    	{
    		return;
    	}
    	World worldSave = MinecraftServer.getServer().worldServers[0];
    	if (!world.isRemote)
    	{
    			player.addChatMessage(new ChatComponentText("Mana: " + (double)Math.round(this.getEnergyStored() * 100) / 100));
    	}
    	worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }
    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
    	super.readFromNBT(nbt);
    	this.storage.setCapacity(nbt.getFloat("maxEnergy"));
    	this.currentAngle = nbt.getFloat("currentAngle");
    	this.targetAngle = nbt.getFloat("targetAngle");
    	this.initialised = false;
    }
    @Override
    public void writeToNBT(NBTTagCompound nbt)
    {
    	super.writeToNBT(nbt);
    	nbt.setFloat("maxEnergy", this.getMaxEnergyStored());
    	nbt.setFloat("currentAngle", this.currentAngle);
    	nbt.setFloat("targetAngle", this.targetAngle);
    }
    @Override
    public EnumSet<ForgeDirection> getElectricalInputDirections()
    {
    	return EnumSet.noneOf(ForgeDirection.class);
    }
    @Override
    public EnumSet<ForgeDirection> getElectricalOutputDirections()
    {
    	return EnumSet.allOf(ForgeDirection.class);
    }
    @Override
    public EnumSet<ForgeDirection> getElectricalOutputDirectionMain()
    {
    	return EnumSet.allOf(ForgeDirection.class);
    }
    
    @Override
    public ItemStack decrStackSize(int slot, int amt)
    {
        ItemStack stack = getStackInSlot(slot);

        if (stack != null)
        {
            if (stack.stackSize <= amt)
            {
                setInventorySlotContents(slot, null);
            } else
            {
                stack = stack.splitStack(amt);

                if (stack.stackSize == 0)
                {
                    setInventorySlotContents(slot, null);
                }
            }
        }

        return stack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot)
    {
        ItemStack stack = getStackInSlot(slot);

        if (stack != null)
        {
            setInventorySlotContents(slot, null);
        }

        return stack;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack)
    {
        inv[slot] = itemStack;
        this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);

        if (itemStack != null && itemStack.stackSize > getInventoryStackLimit())
        {
            itemStack.stackSize = getInventoryStackLimit();
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

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer)
    {
        return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && entityPlayer.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
    }

    @Override
    public void openInventory()
    {
    }

    @Override
    public void closeInventory()
    {
    }

    public void handlePacketData(int[] intData, int[] fluidData, int capacity)
    {
        if (intData == null)
        {
            return;
        }

        if (intData.length == 3)
        {
            for (int i = 0; i < 1; i++)
            {
                if (intData[i * 3 + 2] != 0)
                {
                    ItemStack is = new ItemStack(Item.getItemById(intData[i * 3]), intData[i * 3 + 2], intData[i * 3 + 1]);
                    inv[i] = is;
                } else
                {
                    inv[i] = null;
                }
            }
        }

    }

    public int[] buildIntDataList()
    {
        int[] sortList = new int[1 * 3];
        int pos = 0;

        for (ItemStack is : inv)
        {
            if (is != null)
            {
                sortList[pos++] = Item.getIdFromItem(is.getItem());
                sortList[pos++] = is.getItemDamage();
                sortList[pos++] = is.stackSize;
            } else
            {
                sortList[pos++] = 0;
                sortList[pos++] = 0;
                sortList[pos++] = 0;
            }
        }

        return sortList;
    }

    

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemstack)
    {
        return true;
    }

	@Override
	public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_,
			int p_102007_3_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_,
			int p_102008_3_) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean canConnect(ForgeDirection direction, NetworkType type)
	{
		if (direction == null || direction.equals(ForgeDirection.UP) || type != NetworkType.MANA)
		{
			return false;
		}
		return true;
	}
}
