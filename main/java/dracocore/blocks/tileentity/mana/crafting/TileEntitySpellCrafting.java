package dracocore.blocks.tileentity.mana.crafting;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import dracocore.api.mana.RitualHandler;
import dracocore.interfaces.IRitualAltar;

public class TileEntitySpellCrafting extends TileEntity implements IInventory, IRitualAltar
{
    public static final int sizeInv = 13;
    private ItemStack[] inv;
    public int field_145926_a;
    public float field_145933_i;
    public float field_145931_j;
    public float field_145932_k;
    public float field_145929_l;
    public float field_145930_m;
    public float field_145927_n;
    public float field_145928_o;
    public float field_145925_p;
    public float field_145924_q;
    private static Random field_145923_r = new Random();
    
    
    
    public boolean isRunning;
    public int runningTime;
    private boolean isActive;
    private String currentRitualString;
    private String owner;
    private NBTTagCompound customRitualTag;
	private EntityPlayer player;


    
    public TileEntitySpellCrafting()
    {
        this.inv = new ItemStack[13];
        isActive = false;
        owner = "";
        currentRitualString = "";
        isRunning = false;
        runningTime = 0;
        this.customRitualTag = new NBTTagCompound();
    }

    public int getRSPowerOutput()
    {
        return 5;
    }
    public void readClientNBT(NBTTagCompound tag)
    {
    	currentRitualString = tag.getString("currentRitualString");
    	isRunning = tag.getBoolean("isRunning");
    	runningTime = tag.getInteger("runningTime");
    }
    
    public void writeClientNBT(NBTTagCompound tag)
    {
    	tag.setString("currentRitualString", currentRitualString);
    	tag.setBoolean("isRunning", isRunning);
    	tag.setInteger("runningTime", runningTime);
    	
    }
    @Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList tagList = par1NBTTagCompound.getTagList("Inventory", Constants.NBT.TAG_COMPOUND);
        isActive = par1NBTTagCompound.getBoolean("isActive");
        owner = par1NBTTagCompound.getString("owner");
        currentRitualString = par1NBTTagCompound.getString("currentRitualString");
        isRunning = par1NBTTagCompound.getBoolean("isRunning");
        runningTime = par1NBTTagCompound.getInteger("runningTime");
        customRitualTag = par1NBTTagCompound.getCompoundTag("customRitualTag");
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
        par1NBTTagCompound.setString("owner", owner);
        par1NBTTagCompound.setString("currentRitualString", currentRitualString);
        par1NBTTagCompound.setBoolean("isRunning", isRunning);
        par1NBTTagCompound.setInteger("runningTime", runningTime);
        par1NBTTagCompound.setTag("customRitualTag", customRitualTag);
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
    public void activateRitual(World world, EntityPlayer player)
    {
    	if (world.isRemote)
    	{
    		return;
    	}
    	World worldSave = MinecraftServer.getServer().worldServers[0];
    	if (!world.isRemote)
    	{
    			player.addChatMessage(new ChatComponentText("A rush of energy flows through the ritual!"));
    	}
    	isActive = true;
    	isRunning = true;
    	worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }
    
    public void setOwner(String owner)
    {
    	this.owner = owner;
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
        return "TESpellCrafter";
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

    public void turnritualoff()
    {
    	this.isActive = false;
    }
    
    //Logic for the actual block is under here
    @Override
    public void updateEntity()
    {
    	this.field_145927_n = this.field_145930_m;
        this.field_145925_p = this.field_145928_o;
        EntityPlayer entityplayer = this.worldObj.getClosestPlayer((double)((float)this.xCoord + 0.5F), (double)((float)this.yCoord + 0.5F), (double)((float)this.zCoord + 0.5F), 3.0D);

        if (entityplayer != null)
        {
            double d0 = entityplayer.posX - (double)((float)this.xCoord + 0.5F);
            double d1 = entityplayer.posZ - (double)((float)this.zCoord + 0.5F);
            this.field_145924_q = (float)Math.atan2(d1, d0);
            this.field_145930_m += 0.1F;

            if (this.field_145930_m < 0.5F || field_145923_r.nextInt(40) == 0)
            {
                float f1 = this.field_145932_k;

                do
                {
                    this.field_145932_k += (float)(field_145923_r.nextInt(4) - field_145923_r.nextInt(4));
                }
                while (f1 == this.field_145932_k);
            }
        }
        else
        {
            this.field_145924_q += 0.02F;
            this.field_145930_m -= 0.1F;
        }

        while (this.field_145928_o >= (float)Math.PI)
        {
            this.field_145928_o -= ((float)Math.PI * 2F);
        }

        while (this.field_145928_o < -(float)Math.PI)
        {
            this.field_145928_o += ((float)Math.PI * 2F);
        }

        while (this.field_145924_q >= (float)Math.PI)
        {
            this.field_145924_q -= ((float)Math.PI * 2F);
        }

        while (this.field_145924_q < -(float)Math.PI)
        {
            this.field_145924_q += ((float)Math.PI * 2F);
        }

        float f2;

        for (f2 = this.field_145924_q - this.field_145928_o; f2 >= (float)Math.PI; f2 -= ((float)Math.PI * 2F))
        {
            ;
        }

        while (f2 < -(float)Math.PI)
        {
            f2 += ((float)Math.PI * 2F);
        }

        this.field_145928_o += f2 * 0.4F;

        if (this.field_145930_m < 0.0F)
        {
            this.field_145930_m = 0.0F;
        }

        if (this.field_145930_m > 1.0F)
        {
            this.field_145930_m = 1.0F;
        }

        ++this.field_145926_a;
        this.field_145931_j = this.field_145933_i;
        float f = (this.field_145932_k - this.field_145933_i) * 0.4F;
        float f3 = 0.2F;

        if (f < -f3)
        {
            f = -f3;
        }

        if (f > f3)
        {
            f = f3;
        }

        this.field_145929_l += (f - this.field_145929_l) * 0.9F;
        this.field_145933_i += this.field_145929_l;
        
        if (worldObj.getWorldTime() % 100 == 0)
        {
            startCycle();
        }

        if (getStackInSlot(0) == null)
        {
            return;
        }
        int worldTime = (int) (worldObj.getWorldTime() % 24000);
    	
        if (worldTime % 1 == 0)
        {
            
            if (worldObj != null)
            {
                worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
            }
        }
        
        	
        	
        if (isRunning && runningTime < 200)
       	{
       		runningTime++;
       	} 
        else if (!isRunning && runningTime > 0)
       	{
       		runningTime--;
       	}
       	if (!isActive)
       	{
       		return;
       	}
       	if (worldObj.isRemote)
       	{
       		return;
       	}
        if (worldObj.getBlockPowerInput(xCoord, yCoord, zCoord) > 0)
       	{
       		if (isRunning)
       		{
        		isRunning = false;
        		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        	}
      		return;
       	}
       	else
       	{
       		if (!isRunning)
       		{
        		isRunning = true;
        		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        	}
       	}
       	performRitual(worldObj, xCoord, yCoord, zCoord, currentRitualString);
        	
    }

    public void performRitual(World world, int x, int y, int z, String currentRitualString2)
    {
    	//RitualHandler.RitualHandlerBegin(world, player, x, y, z, this);
    }
    
    public String getOwner()
    {
    	return owner;
    }

    public void setActive(boolean active)
    {
    	this.isActive = active;
    	this.isRunning = active;
    	worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
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
    public boolean isItemValidForSlot(int slot, ItemStack itemstack)
    {
        return slot == 0;
    }

	@Override
	public void setCooldown(int newCooldown) {
		
	}

	@Override
	public int getCooldown() {
		return 0;
	}

	@Override
	public void setVar1(int newVar1) {
		
	}

	@Override
	public int getVar1() {
		return 0;
	}

	@Override
	public int getDirection() {
		return 0;
	}

	@Override
	public World getWorld() {
		return this.getWorldObj();
	}

	@Override
	public int getXCoord() {
		return xCoord;
	}

	@Override
	public int getYCoord() {
		return yCoord;
	}

	@Override
	public int getZCoord() {
		return zCoord;
	}
	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		writeClientNBT(nbttagcompound);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, -999, nbttagcompound);
	}
	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
	{
		super.onDataPacket(net, packet);
		readClientNBT(packet.func_148857_g());
	}
	@Override
	public NBTTagCompound getCustomRitualTag()
	{
		return this.customRitualTag;
	}
	@Override
	public void setCustomRitualTag(NBTTagCompound tag)
	{
		this.customRitualTag = tag;
	}
	public boolean gettileactive()
	{
		return this.isActive;
	}
}
