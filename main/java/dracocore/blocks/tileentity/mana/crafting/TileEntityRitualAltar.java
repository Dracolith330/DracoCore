package dracocore.blocks.tileentity.mana.crafting;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.Packet;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.ForgeDirection;
import dracocore.api.mana.RitualEffect;
import dracocore.api.mana.Rituals;
import dracocore.api.transmission.NetworkType;
import dracocore.blocks.tileentity.mana.storage.TileManaStorage;
import dracocore.interfaces.IRitualAltar;
import dracocore.items.general.ItemsGeneral;
import dracocore.proxies.handlers.NewPacketHandler;

public class TileEntityRitualAltar extends TileManaStorage implements IInventory, IRitualAltar
{
    public static final int sizeInv = 1;
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
    private static double effecttimer = 0;
    
	public static List<TileEntityMagicalPlinth> slots = new ArrayList<TileEntityMagicalPlinth>();
    
    public static boolean isRunning;
    public int runningTime;
    private static boolean isActive;
    private String currentRitualString;
    private String owner;
    private NBTTagCompound customRitualTag;
	private EntityPlayer player;
	static int Cost = 10;
    static ItemStack output;
    static int timer = 0;
    static RitualEffect effect;

    static TileEntityRitualAltar altar;

    
    public TileEntityRitualAltar()
    {
    	super(10000, 50);
        this.inv = new ItemStack[1];
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
    		if(this.checkvalidT1recipe())
    		{
    			player.addChatMessage(new ChatComponentText("Energy begins to flow to the altar."));
    		}
    		if(!this.checkvalidT1recipe())
    		{
    			player.addChatMessage(new ChatComponentText("You're wand pulses, but resists continuing."));
    		}
    	}
    	isActive = true;
    	isRunning = true;
    	worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }
    public void readMana(World world, EntityPlayer player)
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
    

	private static boolean checkvalidT1recipe()
	{
		Iterator<Entry<String, List<Object>>> it = Rituals.getCraftingList().iterator();
		while (it.hasNext()) 
		{
			Map.Entry pairs = (Map.Entry)it.next();
			ArrayList<Object> values = (ArrayList<Object>) pairs.getValue();
		   
			if(altar != null &&  altar.getStackInSlot(0).getItem() == ((ItemStack) values.get(0)).getItem())
				if(slots.get(0) != null && ((slots.get(0).getStackInSlot(0) == null || slots.get(0).getStackInSlot(0) != null) && ((ItemStack) values.get(1)).getItem() == ItemsGeneral.FakeItem || slots.get(0).getStackInSlot(0) != null && slots.get(0).getStackInSlot(0).getItem() == ((ItemStack) values.get(1)).getItem()))
					if(slots.get(1) != null && ((slots.get(1).getStackInSlot(0) == null || slots.get(1).getStackInSlot(0) != null) && ((ItemStack) values.get(2)).getItem() == ItemsGeneral.FakeItem || slots.get(1).getStackInSlot(0) != null && slots.get(1).getStackInSlot(0).getItem() == ((ItemStack) values.get(2)).getItem()))
						if(slots.get(2) != null && ((slots.get(2).getStackInSlot(0) == null || slots.get(2).getStackInSlot(0) != null) && ((ItemStack) values.get(3)).getItem() == ItemsGeneral.FakeItem || slots.get(2).getStackInSlot(0) != null && slots.get(2).getStackInSlot(0).getItem() == ((ItemStack) values.get(3)).getItem()))
							if(slots.get(3) != null && ((slots.get(3).getStackInSlot(0) == null || slots.get(3).getStackInSlot(0) != null) && ((ItemStack) values.get(4)).getItem() == ItemsGeneral.FakeItem || slots.get(3).getStackInSlot(0) != null && slots.get(3).getStackInSlot(0).getItem() == ((ItemStack) values.get(4)).getItem()))
								if(slots.get(4) != null && ((slots.get(4).getStackInSlot(0) == null || slots.get(4).getStackInSlot(0) != null) && ((ItemStack) values.get(5)).getItem() == ItemsGeneral.FakeItem || slots.get(4).getStackInSlot(0) != null && slots.get(4).getStackInSlot(0).getItem() == ((ItemStack) values.get(5)).getItem()))
									if(slots.get(5) != null && ((slots.get(5).getStackInSlot(0) == null || slots.get(5).getStackInSlot(0) != null) && ((ItemStack) values.get(6)).getItem() == ItemsGeneral.FakeItem || slots.get(5).getStackInSlot(0) != null && slots.get(5).getStackInSlot(0).getItem() == ((ItemStack) values.get(6)).getItem()))
										if(slots.get(6) != null && ((slots.get(6).getStackInSlot(0) == null || slots.get(6).getStackInSlot(0) != null) && ((ItemStack) values.get(7)).getItem() == ItemsGeneral.FakeItem || slots.get(6).getStackInSlot(0) != null && slots.get(6).getStackInSlot(0).getItem() == ((ItemStack) values.get(7)).getItem()))
											if(slots.get(7) != null && ((slots.get(7).getStackInSlot(0) == null || slots.get(7).getStackInSlot(0) != null) && ((ItemStack) values.get(8)).getItem() == ItemsGeneral.FakeItem || slots.get(7).getStackInSlot(0) != null && slots.get(7).getStackInSlot(0).getItem() == ((ItemStack) values.get(8)).getItem()))
												if(slots.get(8) != null && ((slots.get(8).getStackInSlot(0) == null || slots.get(8).getStackInSlot(0) != null) && ((ItemStack) values.get(9)).getItem() == ItemsGeneral.FakeItem || slots.get(8).getStackInSlot(0) != null && slots.get(8).getStackInSlot(0).getItem() == ((ItemStack) values.get(9)).getItem()))
													if(slots.get(9) != null && ((slots.get(9).getStackInSlot(0) == null || slots.get(9).getStackInSlot(0) != null) && ((ItemStack) values.get(10)).getItem() == ItemsGeneral.FakeItem || slots.get(9).getStackInSlot(0) != null && slots.get(9).getStackInSlot(0).getItem() == ((ItemStack) values.get(10)).getItem()))
														if(slots.get(10) != null && ((slots.get(10).getStackInSlot(0) == null || slots.get(10).getStackInSlot(0) != null) && ((ItemStack) values.get(11)).getItem() == ItemsGeneral.FakeItem || slots.get(10).getStackInSlot(0) != null && slots.get(10).getStackInSlot(0).getItem() == ((ItemStack) values.get(11)).getItem()))
															if(slots.get(11) != null && ((slots.get(11).getStackInSlot(0) == null || slots.get(11).getStackInSlot(0) != null) && ((ItemStack) values.get(12)).getItem() == ItemsGeneral.FakeItem || slots.get(11).getStackInSlot(0) != null && slots.get(11).getStackInSlot(0).getItem() == ((ItemStack) values.get(12)).getItem()))
															{
																Cost = (Integer) values.get(14);
																effect = (RitualEffect) values.get(13);
																return true;
															}
															else
															{
																isRunning = false;
																isActive = false;
																return false;
															}
    	}
		return false;
	}
	
	public static void setAltar(TileEntityRitualAltar thisaltar)
	{
		altar = thisaltar;
		slots.add(0, (TileEntityMagicalPlinth) altar.getWorldObj().getTileEntity(altar.xCoord, altar.yCoord, altar.zCoord-3));
		slots.add(1, (TileEntityMagicalPlinth) altar.getWorldObj().getTileEntity(altar.xCoord+2, altar.yCoord, altar.zCoord-3));
		slots.add(2, (TileEntityMagicalPlinth) altar.getWorldObj().getTileEntity(altar.xCoord+3, altar.yCoord, altar.zCoord-2));
		slots.add(3, (TileEntityMagicalPlinth) altar.getWorldObj().getTileEntity(altar.xCoord+3, altar.yCoord, altar.zCoord));
		slots.add(4, (TileEntityMagicalPlinth) altar.getWorldObj().getTileEntity(altar.xCoord+3, altar.yCoord, altar.zCoord+2));
		slots.add(5, (TileEntityMagicalPlinth) altar.getWorldObj().getTileEntity(altar.xCoord+2, altar.yCoord, altar.zCoord+3));
		slots.add(6, (TileEntityMagicalPlinth) altar.getWorldObj().getTileEntity(altar.xCoord, altar.yCoord, altar.zCoord+3));
		slots.add(7, (TileEntityMagicalPlinth) altar.getWorldObj().getTileEntity(altar.xCoord-2, altar.yCoord, altar.zCoord+3));
		slots.add(8, (TileEntityMagicalPlinth) altar.getWorldObj().getTileEntity(altar.xCoord-3, altar.yCoord, altar.zCoord+2));
		slots.add(9, (TileEntityMagicalPlinth) altar.getWorldObj().getTileEntity(altar.xCoord-3, altar.yCoord, altar.zCoord));
		slots.add(10, (TileEntityMagicalPlinth) altar.getWorldObj().getTileEntity(altar.xCoord-3, altar.yCoord, altar.zCoord-2));
		slots.add(11, (TileEntityMagicalPlinth) altar.getWorldObj().getTileEntity(altar.xCoord-2, altar.yCoord, altar.zCoord-3));

	}
	
	private static void clearandrefresh(ItemStack item, ItemStack item2, ItemStack item3, ItemStack item4, ItemStack item5, ItemStack item6, ItemStack item7, ItemStack item8, ItemStack item9, ItemStack item10, ItemStack item11, ItemStack item12, ItemStack item13)
	{
		//altar.setInventorySlotContents(0, item13);
		altar.markDirty();
		slots.get(0).setInventorySlotContents(0, item);
		slots.get(0).markDirty();
		slots.get(1).setInventorySlotContents(0, item2);
		slots.get(1).markDirty();
		slots.get(2).setInventorySlotContents(0, item3);
		slots.get(2).markDirty();
		slots.get(3).setInventorySlotContents(0, item4);
		slots.get(3).markDirty();
		slots.get(4).setInventorySlotContents(0, item5);
		slots.get(4).markDirty();
		slots.get(5).setInventorySlotContents(0, item6);
		slots.get(5).markDirty();
		slots.get(6).setInventorySlotContents(0, item7);
		slots.get(6).markDirty();
		slots.get(7).setInventorySlotContents(0, item8);
		slots.get(7).markDirty();
		slots.get(8).setInventorySlotContents(0, item9);
		slots.get(8).markDirty();
		slots.get(9).setInventorySlotContents(0, item10);
		slots.get(9).markDirty();
		slots.get(10).setInventorySlotContents(0, item11);
		slots.get(10).markDirty();
		slots.get(11).setInventorySlotContents(0, item12);
		slots.get(11).markDirty();
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
        return "TERitualAltar";
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
    
    @Override
    public void updateEntity()
    {
        if (!isActive)
       	{
       		return;
       	}

        if (worldObj.getWorldTime() % 100 == 0)
        {
            startCycle();
        }
        
        if (getStackInSlot(0) == null)
        {
            return;
        }
        
        int worldTime = (int) (worldObj.getWorldTime() % 100);
    	
        if (worldTime % 100 == 0)
        {
            
            if (worldObj != null)
            {
                worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
            }
        }

        setAltar(this);
        
        if (isRunning && runningTime < 100)
       	{
       		runningTime++;
       	} 
        if (isRunning && runningTime >= 1 && checkvalidT1recipe())
        {
        	continuecrafting(worldObj, this.xCoord, this.yCoord, this.zCoord);
        }
        
       	performRitual(worldObj, xCoord, yCoord, zCoord, currentRitualString);
        	
    }

    public void performRitual(World world, int x, int y, int z, String currentRitualString2)
    {
    	if(this.checkvalidT1recipe())
    	{
    		this.continuecrafting(worldObj, x, y, z);
    	}
    }

    public static void continuecrafting(World world, int x, int y, int z)
	{
    	if(effect != null)
    	{
    		effecttimer++;
    		
    		if(effecttimer >= 100)
    		{
    			effect.performEffect(altar);
    			effecttimer = 0;
    		}
    	}
	}
    
    public String getOwner()
    {
    	return owner;
    }
    
    @Override
    public boolean canConnect(ForgeDirection direction, NetworkType type)
    {
        if (direction == null || direction.equals(ForgeDirection.UNKNOWN) || type != NetworkType.MANA)
        {
            return false;
        }

        int metadata = this.getBlockMetadata() & 3;

        return direction == ForgeDirection.DOWN;
    }
    
    @Override
    public EnumSet<ForgeDirection> getElectricalInputDirections()
    {
        return EnumSet.of(ForgeDirection.DOWN);
    }
    
    @Override
    public EnumSet<ForgeDirection> getElectricalOutputDirectionMain()
    {
        return EnumSet.of(ForgeDirection.DOWN);
    }
    
    public void setActive(boolean active)
    {
    	this.isActive = active;
    	this.isRunning = active;
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
        return NewPacketHandler.getPacket(this);
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
