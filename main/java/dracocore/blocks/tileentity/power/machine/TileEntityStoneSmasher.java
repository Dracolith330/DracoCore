package dracocore.blocks.tileentity.power.machine;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import dracocore.api.network.IPacketReceiver;
import dracocore.api.power.ItemElectricBase;
import dracocore.api.transmission.NetworkType;
import dracocore.api.transmission.tile.IConnector;
import dracocore.blocks.tileentity.power.storage.TileEnergyStorage;
import dracocore.energy.tile.TileBaseUniversalElectricalSource;
import dracocore.proxies.handlers.NewPacketHandler;

public class TileEntityStoneSmasher extends TileEnergyStorage implements IPacketReceiver, ISidedInventory, IConnector
{
    public static final int sizeInv = 3;
    private ItemStack[] inv;
    static int timer = 0;
    public static boolean isRunning;
    public int runningTime;
    private boolean isActive;
    
    public final Set<EntityPlayer> playersUsing = new HashSet<EntityPlayer>();
    public int scaledEnergyLevel;
    public int lastScaledEnergyLevel;
    private float lastEnergy = 0;

    private boolean initialised = false;

    public TileEntityStoneSmasher()
    {
    	super(1000, 0);
    	this.inv = new ItemStack[1];
        isActive = false;
        isRunning = false;
        runningTime = 0;
    }

    @Override
    public void updateEntity()
    {
    	/*
        if (!this.initialised)
        {
            int metadata = this.getBlockMetadata();

            //for version update compatibility
            Block b = this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord);
                this.storage.setCapacity(2500000);
                this.storage.setMaxExtract(1500);
                this.setTierGC(2);
        }
	    */
        float energy = this.storage.getEnergyStored();
        if (this.getTier() == 1 && !this.worldObj.isRemote)
        {
            if (this.lastEnergy - energy > this.storage.getMaxExtract() - 1)
            {
                //Deplete faster if being drained at maximum output
                this.storage.extractEnergy(25, false);
            }
        }
        this.lastEnergy = energy;

        super.updateEntity();

        this.scaledEnergyLevel = (int) Math.floor((this.getEnergyStored() + 49) * 16 / this.getMaxEnergyStored());

        if (this.scaledEnergyLevel != this.lastScaledEnergyLevel)
        {
            this.worldObj.func_147479_m(this.xCoord, this.yCoord, this.zCoord);
        }

        if (!this.worldObj.isRemote)
        {
            this.recharge(this.inv[0]);
            //this.discharge(this.inv[1]);
        }

        if (!this.worldObj.isRemote)
        {
            this.produce();
        }

        this.lastScaledEnergyLevel = this.scaledEnergyLevel;
    }

    @Override
    public void openInventory()
    {
    }

    @Override
    public void closeInventory()
    {
    }

    public void readClientNBT(NBTTagCompound tag)
    {
    	isRunning = tag.getBoolean("isRunning");
    	runningTime = tag.getInteger("runningTime");
    }
    
    public void writeClientNBT(NBTTagCompound tag)
    {
    	tag.setBoolean("isRunning", isRunning);
    	tag.setInteger("runningTime", runningTime);
    	
    }
    @Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList tagList = par1NBTTagCompound.getTagList("Inventory", Constants.NBT.TAG_COMPOUND);
        isActive = par1NBTTagCompound.getBoolean("isActive");
        isRunning = par1NBTTagCompound.getBoolean("isRunning");
        runningTime = par1NBTTagCompound.getInteger("runningTime");
        for (int i = 0; i < tagList.tagCount(); i++)
        {
            NBTTagCompound tag = (NBTTagCompound) tagList.getCompoundTagAt(i);
            int slot = tag.getByte("Slot");

            if (slot >= 0 && slot < inv.length)
            {
                inv[slot] = ItemStack.loadItemStackFromNBT(tag);
            }
        }

    }
    @Override
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        NBTTagList itemList = new NBTTagList();
        par1NBTTagCompound.setBoolean("isActive", isActive);
        par1NBTTagCompound.setBoolean("isRunning", isRunning);
        par1NBTTagCompound.setInteger("runningTime", runningTime);
        for (int i = 0; i < inv.length; i++)
        {
            ItemStack stack = inv[i];

            if (inv[i] != null)
            {
                NBTTagCompound tag = new NBTTagCompound();
                tag.setByte("Slot", (byte) i);
                inv[i].writeToNBT(tag);
                itemList.appendTag(tag);
            }
        }

        par1NBTTagCompound.setTag("Inventory", itemList);

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

    @Override
    public ItemStack decrStackSize(int par1, int par2)
    {
        if (this.inv[par1] != null)
        {
            ItemStack var3;

            if (this.inv[par1].stackSize <= par2)
            {
                var3 = this.inv[par1];
                this.inv[par1] = null;
                return var3;
            }
            else
            {
                var3 = this.inv[par1].splitStack(par2);

                if (this.inv[par1].stackSize == 0)
                {
                    this.inv[par1] = null;
                }

                return var3;
            }
        }
        else
        {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int par1)
    {
        if (this.inv[par1] != null)
        {
            ItemStack var2 = this.inv[par1];
            this.inv[par1] = null;
            return var2;
        }
        else
        {
            return null;
        }
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
        return "tile.machine.8.name";
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 1;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
    {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this && par1EntityPlayer.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64.0D;
    }

    @Override
    public boolean hasCustomInventoryName()
    {
        return true;
    }

    @Override
    public boolean isItemValidForSlot(int slotID, ItemStack itemstack)
    {
        return ItemElectricBase.isElectricItem(itemstack.getItem());
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int slotID)
    {
        return new int[] { 0, 1 };
    }

    @Override
    public boolean canInsertItem(int slotID, ItemStack itemstack, int side)
    {
        if (itemstack.getItem() instanceof ItemElectricBase)
        {
            if (slotID == 0)
            {
                return ((ItemElectricBase) itemstack.getItem()).getTransfer(itemstack) > 0;
            }
            else if (slotID == 1)
            {
                return ((ItemElectricBase) itemstack.getItem()).getElectricityStored(itemstack) > 0;
            }
        }
        return false;
    }

    @Override
    public boolean canExtractItem(int slotID, ItemStack itemstack, int side)
    {
        if (itemstack.getItem() instanceof ItemElectricBase)
        {
            if (slotID == 0)
            {
                return ((ItemElectricBase) itemstack.getItem()).getTransfer(itemstack) <= 0;
            }
            else if (slotID == 1)
            {
                return ((ItemElectricBase) itemstack.getItem()).getElectricityStored(itemstack) <= 0 || this.getEnergyStored() >= this.getMaxEnergyStored();
            }
        }

        return false;

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
    public boolean canConnect(ForgeDirection direction, NetworkType type)
    {
        if (direction == null || type != NetworkType.POWER)
        {
            return false;
        }

        int metadata = this.getBlockMetadata() & 3;

        return true;
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
    			player.addChatMessage(new ChatComponentText("DE: " + (double)Math.round(this.getEnergyStored() * 100) / 100));
    	}
    	worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}
	public void handlePacketData(int[] intData)
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

    public void startCycle()
    {
        if (worldObj != null)
        {
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        }

        this.checkAndSetAltar();

        
        if (getStackInSlot(0) == null)
        {
            return;
        }

       
    }

    public void checkAndSetAltar()
    {
        boolean checkUpgrade = true;

        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }

	@Override
	public Packet getDescriptionPacket()
	{
		return NewPacketHandler.getPacket(this);
	}
	
	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
	{
		super.onDataPacket(net, packet);
		readClientNBT(packet.func_148857_g());
	}
	
	public boolean gettileactive()
	{
		return this.isActive;
	}

	@Override
	public void markDirty() {
		// TODO Auto-generated method stub
		
	}
}
