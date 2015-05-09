package dracocore.blocks.tileentity.mana.crystal;

import java.util.Random;

import dracocore.blocks.BlocksMain;
import dracocore.blocks.tileentity.mana.storage.TileEntityElementalCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

public class TileEntityTunedCrystal extends TileEntity implements IInventory
{
    public static final int sizeInv = 1;
    private ItemStack[] inv;

    public int field_145926_a;
    public double mana;
    public float field_145933_i;
    public float field_145931_j;
    public float field_145932_k;
    public float field_145929_l;
    public float field_145930_m;
    public float field_145927_n;
    public float field_145928_o;
    public float field_145925_p;
    public float field_145924_q;
    static TileEntityElementalCrystal T0Crystal1;
	static TileEntityElementalCrystal T0Crystal2;
	static TileEntityElementalCrystal T0Crystal3;
	static TileEntityElementalCrystal T0Crystal4;
	static TileEntityElementalCrystal T1Crystal1;
	static TileEntityElementalCrystal T1Crystal2;
	static TileEntityElementalCrystal T1Crystal3;
	static TileEntityElementalCrystal T1Crystal4;
	static TileEntityElementalCrystal T2Crystal1;
	static TileEntityElementalCrystal T2Crystal2;
	static TileEntityElementalCrystal T2Crystal3;
	static TileEntityElementalCrystal T2Crystal4;
	static TileEntityElementalCrystal T3Crystal1;
	static TileEntityElementalCrystal T3Crystal2;
	static TileEntityElementalCrystal T3Crystal3;
	static TileEntityElementalCrystal T3Crystal4;
	static TileEntityElementalCrystal T4Crystal1;
	static TileEntityElementalCrystal T4Crystal2;
	static TileEntityElementalCrystal T4Crystal3;
	static TileEntityElementalCrystal T4Crystal4;
	static TileEntityElementalCrystal T5Crystal1;
	static TileEntityElementalCrystal T5Crystal2;
	static TileEntityElementalCrystal T5Crystal3;
	static TileEntityElementalCrystal T5Crystal4;
	static TileEntityElementalCrystal T6Crystal1;
	static TileEntityElementalCrystal T6Crystal2;
	static TileEntityElementalCrystal T6Crystal3;
	static TileEntityElementalCrystal T6Crystal4;
    private static Random field_145923_r = new Random();
	
	
    public TileEntityTunedCrystal()
    {
        this.inv = new ItemStack[1];
    }

    public int getRSPowerOutput()
    {
        return 5;
    }
    public void readClientNBT(NBTTagCompound tag)
    {
    	mana = tag.getDouble("mana");
    }
    
    public void writeClientNBT(NBTTagCompound tag)
    {
    	tag.setDouble("mana", mana);
    	
    }
    @Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList tagList = par1NBTTagCompound.getTagList("Inventory", Constants.NBT.TAG_COMPOUND);
        mana = par1NBTTagCompound.getDouble("mana");
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
        par1NBTTagCompound.setDouble("mana", mana);
        
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
        if(mana < 50000)
        {
        	mana += 0.05*this.getgenerationmultiplier(this);
        }
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
        
    	
    }
    public void activateRitual(World world)
    {
    	
    	if (world.isRemote)
    	{
    		return;
    	}
    	World worldSave = MinecraftServer.getServer().worldServers[0];
    	if (!world.isRemote)
    	{
    		
    			//player.addChatMessage(new ChatComponentText("Mana: " + mana));
    	}
    	worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
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
        return "TETCrystal";
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

    public double getgenerationmultiplier(TileEntityTunedCrystal tile)
    {
    	//if(tile.getWorldObj().getBlock(tile.xCoord, tile.yCoord-1, tile.zCoord) == BlocksMain.RunicUpgrade)
    	//{
    	//	return 20;
    	//}
    	//else{
    	return 1;
    	//}
    	
    }
    
    public void chargemanatobattery(TileEntityTunedCrystal tile)
    {
    	if(tile.getWorldObj().getTileEntity(tile.xCoord+2, tile.yCoord+3, tile.zCoord) != null && tile.getWorldObj().getTileEntity(tile.xCoord+2, tile.yCoord+3, tile.zCoord) instanceof TileEntityElementalCrystal){T0Crystal1 = (TileEntityElementalCrystal) tile.getWorldObj().getTileEntity(tile.xCoord+2, tile.yCoord+3, tile.zCoord);}
    	if(tile.getWorldObj().getTileEntity(tile.xCoord-2, tile.yCoord+3, tile.zCoord) != null && tile.getWorldObj().getTileEntity(tile.xCoord-2, tile.yCoord+3, tile.zCoord) instanceof TileEntityElementalCrystal){T0Crystal2 = (TileEntityElementalCrystal) tile.getWorldObj().getTileEntity(tile.xCoord-2, tile.yCoord+3, tile.zCoord);}
    	if(tile.getWorldObj().getTileEntity(tile.xCoord, tile.yCoord+3, tile.zCoord+2) != null && tile.getWorldObj().getTileEntity(tile.xCoord, tile.yCoord+3, tile.zCoord+2) instanceof TileEntityElementalCrystal){T0Crystal3 = (TileEntityElementalCrystal) tile.getWorldObj().getTileEntity(tile.xCoord, tile.yCoord+3, tile.zCoord+2);}
    	if(tile.getWorldObj().getTileEntity(tile.xCoord, tile.yCoord+3, tile.zCoord-2) != null && tile.getWorldObj().getTileEntity(tile.xCoord, tile.yCoord+3, tile.zCoord-2) instanceof TileEntityElementalCrystal){T0Crystal4 = (TileEntityElementalCrystal) tile.getWorldObj().getTileEntity(tile.xCoord, tile.yCoord+3, tile.zCoord-2);}
    	
    	if(tile.getWorldObj().getTileEntity(tile.xCoord+2, tile.yCoord+3, tile.zCoord+2) != null && tile.getWorldObj().getTileEntity(tile.xCoord+2, tile.yCoord+3, tile.zCoord+2) instanceof TileEntityElementalCrystal){T1Crystal1 = (TileEntityElementalCrystal) tile.getWorldObj().getTileEntity(tile.xCoord+2, tile.yCoord+3, tile.zCoord+2);}
    	if(tile.getWorldObj().getTileEntity(tile.xCoord-2, tile.yCoord+3, tile.zCoord+2) != null && tile.getWorldObj().getTileEntity(tile.xCoord-2, tile.yCoord+3, tile.zCoord+2) instanceof TileEntityElementalCrystal){T1Crystal2 = (TileEntityElementalCrystal) tile.getWorldObj().getTileEntity(tile.xCoord-2, tile.yCoord+3, tile.zCoord+2);}
    	if(tile.getWorldObj().getTileEntity(tile.xCoord+2, tile.yCoord+3, tile.zCoord-2) != null && tile.getWorldObj().getTileEntity(tile.xCoord+2, tile.yCoord+3, tile.zCoord-2) instanceof TileEntityElementalCrystal){T1Crystal3 = (TileEntityElementalCrystal) tile.getWorldObj().getTileEntity(tile.xCoord+2, tile.yCoord+3, tile.zCoord-2);}
    	if(tile.getWorldObj().getTileEntity(tile.xCoord-2, tile.yCoord+3, tile.zCoord-2) != null && tile.getWorldObj().getTileEntity(tile.xCoord-2, tile.yCoord+3, tile.zCoord-2) instanceof TileEntityElementalCrystal){T1Crystal4 = (TileEntityElementalCrystal) tile.getWorldObj().getTileEntity(tile.xCoord-2, tile.yCoord+3, tile.zCoord-2);}
    	
    	if(tile.getWorldObj().getTileEntity(tile.xCoord+3, tile.yCoord+3, tile.zCoord) != null && tile.getWorldObj().getTileEntity(tile.xCoord+3, tile.yCoord+3, tile.zCoord) instanceof TileEntityElementalCrystal){T2Crystal1 = (TileEntityElementalCrystal) tile.getWorldObj().getTileEntity(tile.xCoord+3, tile.yCoord+3, tile.zCoord);}
    	if(tile.getWorldObj().getTileEntity(tile.xCoord-3, tile.yCoord+3, tile.zCoord) != null && tile.getWorldObj().getTileEntity(tile.xCoord-3, tile.yCoord+3, tile.zCoord) instanceof TileEntityElementalCrystal){T2Crystal2 = (TileEntityElementalCrystal) tile.getWorldObj().getTileEntity(tile.xCoord-3, tile.yCoord+3, tile.zCoord);}
    	if(tile.getWorldObj().getTileEntity(tile.xCoord, tile.yCoord+3, tile.zCoord+3) != null && tile.getWorldObj().getTileEntity(tile.xCoord, tile.yCoord+3, tile.zCoord+3) instanceof TileEntityElementalCrystal){T2Crystal3 = (TileEntityElementalCrystal) tile.getWorldObj().getTileEntity(tile.xCoord, tile.yCoord+3, tile.zCoord+3);}
    	if(tile.getWorldObj().getTileEntity(tile.xCoord, tile.yCoord+3, tile.zCoord-3) != null && tile.getWorldObj().getTileEntity(tile.xCoord, tile.yCoord+3, tile.zCoord-3) instanceof TileEntityElementalCrystal){T2Crystal4 = (TileEntityElementalCrystal) tile.getWorldObj().getTileEntity(tile.xCoord, tile.yCoord+3, tile.zCoord-3);}
    	
    	if(tile.getWorldObj().getTileEntity(tile.xCoord+3, tile.yCoord+3, tile.zCoord+3) != null && tile.getWorldObj().getTileEntity(tile.xCoord+3, tile.yCoord+3, tile.zCoord+3) instanceof TileEntityElementalCrystal){T3Crystal1 = (TileEntityElementalCrystal) tile.getWorldObj().getTileEntity(tile.xCoord+3, tile.yCoord+3, tile.zCoord+3);}
    	if(tile.getWorldObj().getTileEntity(tile.xCoord-3, tile.yCoord+3, tile.zCoord+3) != null && tile.getWorldObj().getTileEntity(tile.xCoord-3, tile.yCoord+3, tile.zCoord+3) instanceof TileEntityElementalCrystal){T3Crystal2 = (TileEntityElementalCrystal) tile.getWorldObj().getTileEntity(tile.xCoord-3, tile.yCoord+3, tile.zCoord+3);}
    	if(tile.getWorldObj().getTileEntity(tile.xCoord+3, tile.yCoord+3, tile.zCoord-3) != null && tile.getWorldObj().getTileEntity(tile.xCoord+3, tile.yCoord+3, tile.zCoord-3) instanceof TileEntityElementalCrystal){T3Crystal3 = (TileEntityElementalCrystal) tile.getWorldObj().getTileEntity(tile.xCoord+3, tile.yCoord+3, tile.zCoord-3);}
    	if(tile.getWorldObj().getTileEntity(tile.xCoord-3, tile.yCoord+3, tile.zCoord-3) != null && tile.getWorldObj().getTileEntity(tile.xCoord-3, tile.yCoord+3, tile.zCoord-3) instanceof TileEntityElementalCrystal){T3Crystal4 = (TileEntityElementalCrystal) tile.getWorldObj().getTileEntity(tile.xCoord-3, tile.yCoord+3, tile.zCoord-3);}
    	
    	if(tile.getWorldObj().getTileEntity(tile.xCoord+4, tile.yCoord+3, tile.zCoord) != null && tile.getWorldObj().getTileEntity(tile.xCoord+4, tile.yCoord+3, tile.zCoord) instanceof TileEntityElementalCrystal){T4Crystal1 = (TileEntityElementalCrystal) tile.getWorldObj().getTileEntity(tile.xCoord+4, tile.yCoord+3, tile.zCoord);}
    	if(tile.getWorldObj().getTileEntity(tile.xCoord-4, tile.yCoord+3, tile.zCoord) != null && tile.getWorldObj().getTileEntity(tile.xCoord-4, tile.yCoord+3, tile.zCoord) instanceof TileEntityElementalCrystal){T4Crystal2 = (TileEntityElementalCrystal) tile.getWorldObj().getTileEntity(tile.xCoord-4, tile.yCoord+3, tile.zCoord);}
    	if(tile.getWorldObj().getTileEntity(tile.xCoord, tile.yCoord+3, tile.zCoord+4) != null && tile.getWorldObj().getTileEntity(tile.xCoord, tile.yCoord+3, tile.zCoord+4) instanceof TileEntityElementalCrystal){T4Crystal3 = (TileEntityElementalCrystal) tile.getWorldObj().getTileEntity(tile.xCoord, tile.yCoord+3, tile.zCoord+4);}
    	if(tile.getWorldObj().getTileEntity(tile.xCoord, tile.yCoord+3, tile.zCoord-4) != null && tile.getWorldObj().getTileEntity(tile.xCoord, tile.yCoord+3, tile.zCoord-4) instanceof TileEntityElementalCrystal){T4Crystal4 = (TileEntityElementalCrystal) tile.getWorldObj().getTileEntity(tile.xCoord, tile.yCoord+3, tile.zCoord-4);}
    	
    	if(tile.getWorldObj().getTileEntity(tile.xCoord+5, tile.yCoord+3, tile.zCoord) != null && tile.getWorldObj().getTileEntity(tile.xCoord+5, tile.yCoord+3, tile.zCoord) instanceof TileEntityElementalCrystal){T5Crystal1 = (TileEntityElementalCrystal) tile.getWorldObj().getTileEntity(tile.xCoord+5, tile.yCoord+3, tile.zCoord);}
    	if(tile.getWorldObj().getTileEntity(tile.xCoord-5, tile.yCoord+3, tile.zCoord) != null && tile.getWorldObj().getTileEntity(tile.xCoord-5, tile.yCoord+3, tile.zCoord) instanceof TileEntityElementalCrystal){T5Crystal2 = (TileEntityElementalCrystal) tile.getWorldObj().getTileEntity(tile.xCoord-5, tile.yCoord+3, tile.zCoord);}
    	if(tile.getWorldObj().getTileEntity(tile.xCoord, tile.yCoord+3, tile.zCoord+5) != null && tile.getWorldObj().getTileEntity(tile.xCoord, tile.yCoord+3, tile.zCoord+5) instanceof TileEntityElementalCrystal){T5Crystal3 = (TileEntityElementalCrystal) tile.getWorldObj().getTileEntity(tile.xCoord, tile.yCoord+3, tile.zCoord+5);}
    	if(tile.getWorldObj().getTileEntity(tile.xCoord, tile.yCoord+3, tile.zCoord-5) != null && tile.getWorldObj().getTileEntity(tile.xCoord, tile.yCoord+3, tile.zCoord-5) instanceof TileEntityElementalCrystal){T5Crystal4 = (TileEntityElementalCrystal) tile.getWorldObj().getTileEntity(tile.xCoord, tile.yCoord+3, tile.zCoord-5);}
    	
    	
        
    }
}
