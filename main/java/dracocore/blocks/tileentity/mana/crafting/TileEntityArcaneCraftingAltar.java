package dracocore.blocks.tileentity.mana.crafting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
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
import dracocore.api.superclass.RunicUpgrade;
import dracocore.blocks.blockclasses.mana.upgrade.BaseRuneSlot;
import dracocore.blocks.recipes.ArcaneCraftingRecipes;
import dracocore.blocks.tileentity.mana.storage.TileManaStorage;
import dracocore.blocks.tileentity.mana.upgrade.TileEntityRunicUpgradeT1;
import dracocore.interfaces.IRitualAltar;
import dracocore.items.general.ItemsGeneral;
import dracocore.proxies.handlers.NewPacketHandler;


public class TileEntityArcaneCraftingAltar extends TileManaStorage implements IInventory, IRitualAltar
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
    private static boolean populatedlist = false;
    private static Random field_145923_r = new Random();
    static TileEntityArcaneCraftingAltar altar;
	static List<TileEntityArcaneCraftingSlot> slots = new ArrayList<TileEntityArcaneCraftingSlot>();
    static List<RunicUpgrade> runicupgrades = new ArrayList<RunicUpgrade>(12);
    static ItemStack output;
    static int timer = 0;
	
	
	World world;
    
    public static boolean isRunning;
    public int runningTime;
    private boolean isActive;
    private String currentRitualString;
    private String owner;
    private NBTTagCompound customRitualTag;
	private EntityPlayer player;
	static int Cost = 10;
	static int RunningTime = 10;

    
    public TileEntityArcaneCraftingAltar()
    {
		super(10000, 0);
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
    		if(this.checkvalidrecipe())
    		{
    			player.addChatMessage(new ChatComponentText("Energy begins to flow to the altar."));
    		}
    		if(!this.checkvalidrecipe())
    		{
    			player.addChatMessage(new ChatComponentText("You're wand pulses, but resists continuing."));
    		}
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
        return "TECraftingAltar";
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
        if (isRunning && runningTime >= 1 && begincrafting())
        {
        	continuecrafting(world, this.xCoord, this.yCoord, this.zCoord);
        }
       	
       	performRitual(worldObj, xCoord, yCoord, zCoord, currentRitualString);
        	
    }
    
    public static boolean begincrafting()
	{
		return checkvalidrecipe();
	}
    
    public static void setAltar(TileEntityArcaneCraftingAltar thisaltar)
	{
		altar = thisaltar;
		slots.add(0, (TileEntityArcaneCraftingSlot) altar.getWorldObj().getTileEntity(altar.xCoord+1, altar.yCoord, altar.zCoord-3));
		slots.add(1, (TileEntityArcaneCraftingSlot) altar.getWorldObj().getTileEntity(altar.xCoord+3, altar.yCoord, altar.zCoord-3));
		slots.add(2, (TileEntityArcaneCraftingSlot) altar.getWorldObj().getTileEntity(altar.xCoord+3, altar.yCoord, altar.zCoord-1));
		slots.add(3, (TileEntityArcaneCraftingSlot) altar.getWorldObj().getTileEntity(altar.xCoord+3, altar.yCoord, altar.zCoord+1));
		slots.add(4, (TileEntityArcaneCraftingSlot) altar.getWorldObj().getTileEntity(altar.xCoord+3, altar.yCoord, altar.zCoord+3));
		slots.add(5, (TileEntityArcaneCraftingSlot) altar.getWorldObj().getTileEntity(altar.xCoord+1, altar.yCoord, altar.zCoord+3));
		slots.add(6, (TileEntityArcaneCraftingSlot) altar.getWorldObj().getTileEntity(altar.xCoord-1, altar.yCoord, altar.zCoord+3));
		slots.add(7, (TileEntityArcaneCraftingSlot) altar.getWorldObj().getTileEntity(altar.xCoord-3, altar.yCoord, altar.zCoord+3));
		slots.add(8, (TileEntityArcaneCraftingSlot) altar.getWorldObj().getTileEntity(altar.xCoord-3, altar.yCoord, altar.zCoord+1));
		slots.add(9, (TileEntityArcaneCraftingSlot) altar.getWorldObj().getTileEntity(altar.xCoord-3, altar.yCoord, altar.zCoord-1));
		slots.add(10, (TileEntityArcaneCraftingSlot) altar.getWorldObj().getTileEntity(altar.xCoord-3, altar.yCoord, altar.zCoord-3));
		slots.add(11, (TileEntityArcaneCraftingSlot) altar.getWorldObj().getTileEntity(altar.xCoord-1, altar.yCoord, altar.zCoord-3));

	}
    
    private static boolean checkvalidrecipe()
	{	   
        
		Iterator<Entry<String, List<Object>>> it = ArcaneCraftingRecipes.getCraftingList().iterator();
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
																	output = (ItemStack) values.get(13);
																	Cost = (Integer) values.get(14);
																	RunningTime = (Integer) values.get(15);
																	return true;
																}
																else
																{
																	isRunning = false;
																	return false;
																}
			}
		return false;
	}
    
    public static void continuecrafting(World world, int x, int y, int z)
	{
		timer++;
		
		double x4 = getEfficiencyUpgrades(altar);
		
		if(!slots.isEmpty() && slots.get(0) != null)
		{
			slots.get(0).isactive = true;
			if(timer >= RunningTime/12/x4 && slots.get(1) != null)
			{
				slots.get(1).isactive = true;
				slots.get(0).isactive = false;
				if(timer >= RunningTime/11/x4 && slots.get(2) != null)
				{
					slots.get(2).isactive = true;
					slots.get(1).isactive = false;
            	
					if(timer >= RunningTime/10/x4 && slots.get(3) != null)
					{
						slots.get(3).isactive = true;
						slots.get(2).isactive = false;
                	
						if(timer >= RunningTime/9/x4 && slots.get(4) != null)
						{
							slots.get(4).isactive = true;
							slots.get(3).isactive = false;
                    	
							if(timer >= RunningTime/8/x4 && slots.get(5) != null)
							{
								slots.get(5).isactive = true;
								slots.get(4).isactive = false;
                        	
								if(timer >= RunningTime/7/x4 && slots.get(6) != null)
								{
									slots.get(6).isactive = true;
									slots.get(5).isactive = false;
                            	
									if(timer >= RunningTime/6/x4 && slots.get(7) != null)
									{
										slots.get(7).isactive = true;
										slots.get(6).isactive = false;
                                	
										if(timer >= RunningTime/5/x4 && slots.get(8) != null)
										{
											slots.get(8).isactive = true;
											slots.get(7).isactive = false;
                                    	
											if(timer >= RunningTime/4/x4 && slots.get(9) != null)
											{
												slots.get(9).isactive = true;
												slots.get(8).isactive = false;
                                        	
												if(timer >= RunningTime/3/x4 && slots.get(10) != null)
												{
													slots.get(10).isactive = true;
													slots.get(9).isactive = false;
                                            	
													if(timer >= RunningTime/2/x4 && slots.get(11) != null)
													{
														slots.get(11).isactive = true;
														slots.get(10).isactive = false;
                                                	
														if(timer >= RunningTime/x4)
														{
															slots.get(11).isactive = false;
															
															for(int x1 = 0; x1<12;x1++)
															{
																slots.get(x1).decrStackSize(0, 1);
																//slots.get(x1).markDirty();
															}
															
															altar.decrStackSize(0, 1);
															altar.setInventorySlotContents(0, output);
															altar.startCycle();
															
															if(altar.getStackInSlot(0) == output)
															{
																timer = 0;
																altar.turnritualoff();
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	public static double getEfficiencyUpgrades(TileEntityArcaneCraftingAltar altar1)
	{
		if(!populatedlist)
		{
			for(int x = 0; x < 12; x++)
				runicupgrades.add(x, null);
			populatedlist = true;
		}
		
		if(altar != null && altar.getWorld().getTileEntity(altar1.getXCoord()+1, altar1.getYCoord()-1, altar1.getZCoord()-2) instanceof RunicUpgrade){runicupgrades.set(0, (RunicUpgrade) altar.getWorld().getTileEntity(altar1.getXCoord()+1, altar1.getYCoord()-1, altar1.getZCoord()-2));}
		if(altar != null && altar.getWorld().getTileEntity(altar1.getXCoord()+2, altar1.getYCoord()-1, altar1.getZCoord()-2) instanceof RunicUpgrade){runicupgrades.set(1, (RunicUpgrade) altar.getWorld().getTileEntity(altar1.getXCoord()+2, altar1.getYCoord()-1, altar1.getZCoord()-2));}
		if(altar != null && altar.getWorld().getTileEntity(altar1.getXCoord()+2, altar1.getYCoord()-1, altar1.getZCoord()-1) instanceof RunicUpgrade){runicupgrades.set(2, (RunicUpgrade) altar.getWorld().getTileEntity(altar1.getXCoord()+2, altar1.getYCoord()-1, altar1.getZCoord()-1));}
		if(altar != null && altar.getWorld().getTileEntity(altar1.getXCoord()+2, altar1.getYCoord()-1, altar1.getZCoord()+1) instanceof RunicUpgrade){runicupgrades.set(3, (RunicUpgrade) altar.getWorld().getTileEntity(altar1.getXCoord()+2, altar1.getYCoord()-1, altar1.getZCoord()+1));}
		if(altar != null && altar.getWorld().getTileEntity(altar1.getXCoord()+2, altar1.getYCoord()-1, altar1.getZCoord()+2) instanceof RunicUpgrade){runicupgrades.set(4, (RunicUpgrade) altar.getWorld().getTileEntity(altar1.getXCoord()+2, altar1.getYCoord()-1, altar1.getZCoord()+2));}
		if(altar != null && altar.getWorld().getTileEntity(altar1.getXCoord()+1, altar1.getYCoord()-1, altar1.getZCoord()+2) instanceof RunicUpgrade){runicupgrades.set(5, (RunicUpgrade) altar.getWorld().getTileEntity(altar1.getXCoord()+1, altar1.getYCoord()-1, altar1.getZCoord()+2));}
		if(altar != null && altar.getWorld().getTileEntity(altar1.getXCoord()-1, altar1.getYCoord()-1, altar1.getZCoord()+2) instanceof RunicUpgrade){runicupgrades.set(6, (RunicUpgrade) altar.getWorld().getTileEntity(altar1.getXCoord()-1, altar1.getYCoord()-1, altar1.getZCoord()+2));}
		if(altar != null && altar.getWorld().getTileEntity(altar1.getXCoord()-2, altar1.getYCoord()-1, altar1.getZCoord()+2) instanceof RunicUpgrade){runicupgrades.set(7, (RunicUpgrade) altar.getWorld().getTileEntity(altar1.getXCoord()-2, altar1.getYCoord()-1, altar1.getZCoord()+2));}
		if(altar != null && altar.getWorld().getTileEntity(altar1.getXCoord()-2, altar1.getYCoord()-1, altar1.getZCoord()+1) instanceof RunicUpgrade){runicupgrades.set(8, (RunicUpgrade) altar.getWorld().getTileEntity(altar1.getXCoord()-2, altar1.getYCoord()-1, altar1.getZCoord()+1));}
		if(altar != null && altar.getWorld().getTileEntity(altar1.getXCoord()-2, altar1.getYCoord()-1, altar1.getZCoord()-1) instanceof RunicUpgrade){runicupgrades.set(9, (RunicUpgrade) altar.getWorld().getTileEntity(altar1.getXCoord()-2, altar1.getYCoord()-1, altar1.getZCoord()-1));}
		if(altar != null && altar.getWorld().getTileEntity(altar1.getXCoord()-2, altar1.getYCoord()-1, altar1.getZCoord()-2) instanceof RunicUpgrade){runicupgrades.set(10, (RunicUpgrade) altar.getWorld().getTileEntity(altar1.getXCoord()-2, altar1.getYCoord()-1, altar1.getZCoord()-2));}
		if(altar != null && altar.getWorld().getTileEntity(altar1.getXCoord()-1, altar1.getYCoord()-1, altar1.getZCoord()-2) instanceof RunicUpgrade){runicupgrades.set(11, (RunicUpgrade) altar.getWorld().getTileEntity(altar1.getXCoord()-1, altar1.getYCoord()-1, altar1.getZCoord()-2));}

		double i = 1;
		
		if(!runicupgrades.isEmpty())
		{
			for(int x = 0; x < runicupgrades.size() && !(x > 12); x++)
			{
				if(runicupgrades.get(x) != null && runicupgrades.get(x) instanceof RunicUpgrade)
				{i += 0.1 * runicupgrades.get(x).tierMultiplier();}
				
				if(runicupgrades.get(x) instanceof RunicUpgrade && runicupgrades.get(x).getStackInSlot(0) != null && runicupgrades.get(x).getStackInSlot(0).getItem() == Items.baked_potato)
				{i++;}
			}
		}

		return i;
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

	@Override
	public void performRitual(World world, int x, int y, int z, String ritualID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void markDirty() {
		// TODO Auto-generated method stub
		
	}
}
