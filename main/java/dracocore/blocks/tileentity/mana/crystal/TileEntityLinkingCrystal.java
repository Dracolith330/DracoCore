package dracocore.blocks.tileentity.mana.crystal;

import java.text.DecimalFormat;
import java.util.Random;

import dracocore.blocks.tileentity.mana.storage.TileEntityElementalCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

public class TileEntityLinkingCrystal extends TileEntity implements IInventory
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
    
    static TileEntityLinkingCrystal LCrystal1;
	static TileEntityLinkingCrystal LCrystal2;
	static TileEntityLinkingCrystal LCrystal3;
	static TileEntityLinkingCrystal LCrystal4;
	static TileEntityLinkingCrystal LCrystal5;
	static TileEntityLinkingCrystal LCrystal6;
	
	static TileEntityElementalCrystal ECrystal1;
	static TileEntityElementalCrystal ECrystal2;
	static TileEntityElementalCrystal ECrystal3;
	static TileEntityElementalCrystal ECrystal4;
	static TileEntityElementalCrystal ECrystal5;
	static TileEntityElementalCrystal ECrystal6;
    private static Random field_145923_r = new Random();

    public TileEntityLinkingCrystal()
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
    	for(int x = 0; x < 8; x++)
    	{
    		if(this.getWorldObj().getTileEntity(this.xCoord, this.yCoord+x, this.zCoord) != null && this.getWorldObj().getTileEntity(this.xCoord, this.yCoord+x, this.zCoord) instanceof TileEntityElementalCrystal){ECrystal1 = (TileEntityElementalCrystal) this.getWorldObj().getTileEntity(this.xCoord, this.yCoord+x, this.zCoord);break;}
    	}
    	for(int x = 0; x < 8; x++)
    	{
    		if(this.getWorldObj().getTileEntity(this.xCoord, this.yCoord-x, this.zCoord) != null && this.getWorldObj().getTileEntity(this.xCoord, this.yCoord-x, this.zCoord) instanceof TileEntityElementalCrystal){ECrystal1 = (TileEntityElementalCrystal) this.getWorldObj().getTileEntity(this.xCoord, this.yCoord-x, this.zCoord);break;}
    	}
    	for(int x = 0; x < 8; x++)
    	{
    		if(this.getWorldObj().getTileEntity(this.xCoord+x, this.yCoord, this.zCoord) != null && this.getWorldObj().getTileEntity(this.xCoord+x, this.yCoord, this.zCoord) instanceof TileEntityElementalCrystal){ECrystal1 = (TileEntityElementalCrystal) this.getWorldObj().getTileEntity(this.xCoord+x, this.yCoord, this.zCoord);break;}
    	}
    	for(int x = 0; x < 8; x++)
    	{
    		if(this.getWorldObj().getTileEntity(this.xCoord-x, this.yCoord, this.zCoord) != null && this.getWorldObj().getTileEntity(this.xCoord-x, this.yCoord, this.zCoord) instanceof TileEntityElementalCrystal){ECrystal1 = (TileEntityElementalCrystal) this.getWorldObj().getTileEntity(this.xCoord-x, this.yCoord, this.zCoord);break;}
    	}
    	for(int x = 0; x < 8; x++)
    	{
    		if(this.getWorldObj().getTileEntity(this.xCoord, this.yCoord, this.zCoord+x) != null && this.getWorldObj().getTileEntity(this.xCoord, this.yCoord, this.zCoord+x) instanceof TileEntityElementalCrystal){ECrystal1 = (TileEntityElementalCrystal) this.getWorldObj().getTileEntity(this.xCoord, this.yCoord, this.zCoord+x);break;}
    	}
    	for(int x = 0; x < 8; x++)
    	{
    		if(this.getWorldObj().getTileEntity(this.xCoord, this.yCoord, this.zCoord-x) != null && this.getWorldObj().getTileEntity(this.xCoord, this.yCoord, this.zCoord-x) instanceof TileEntityElementalCrystal){ECrystal1 = (TileEntityElementalCrystal) this.getWorldObj().getTileEntity(this.xCoord, this.yCoord, this.zCoord-x);break;}
    	}
    	
    	
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

       
        {
        	//if(ECrystal1 != null && ECrystal1.mana >= 100 && this.mana < 1000000){ECrystal1.chargemanatobattery(ECrystal4);ECrystal1.mana -= 100;}
        	//if(ECrystal2 != null && ECrystal2.mana >= 100 && this.mana < 1000000){ECrystal2.chargemanatobattery(ECrystal4);ECrystal2.mana -= 100;}
        	//if(ECrystal3 != null && ECrystal3.mana >= 100 && this.mana < 1000000){ECrystal3.chargemanatobattery(ECrystal4);ECrystal3.mana -= 100;}
        	//if(ECrystal4 != null && ECrystal4.mana >= 100 && this.mana < 1000000){ECrystal4.chargemanatobattery(ECrystal4);ECrystal4.mana -= 100;}
        	//if(ECrystal5 != null && ECrystal5.mana >= 100 && this.mana < 1000000){ECrystal5.chargemanatobattery(ECrystal4);ECrystal5.mana -= 100;}
        	//if(ECrystal6 != null && ECrystal6.mana >= 100 && this.mana < 1000000){ECrystal6.chargemanatobattery(ECrystal4);ECrystal6.mana -= 100;}
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
        //++mana;
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
    public void activateRitual(World world, EntityPlayer player)
    {
    	if (world.isRemote)
    	{
    		return;
    	}
    	World worldSave = MinecraftServer.getServer().worldServers[0];
    	if (!world.isRemote)
    	{
    			player.addChatMessage(new ChatComponentText("Mana: " + (double)Math.round(mana * 100) / 100));
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
        return "TELinkingCrystal";
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

}
