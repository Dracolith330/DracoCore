package dracocore.blocks.tileentity.mana.generator;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityManaGenerator extends TileEntity implements IInventory
{
	public static HashMap<ItemStack, Double> burntime = new HashMap<ItemStack, Double>();
	public double mana = 0;
	public double manastoragesize = 1;
	public double naturalRegen = 1;
    public float field_145933_i;
    public float field_145931_j;
    public float field_145932_k;
    public float field_145929_l;
    public float field_145930_m;
    public float field_145927_n;
    public float field_145928_o;
    public float field_145925_p;
    public float field_145924_q;

    public int field_145926_a;
    
    
    private static Random field_145923_r = new Random();
    
    
    
	public double getStoredMana()
	{
		return mana;
	}
	
	public static Set<Entry<ItemStack, Double>> getCraftingList()
	{
	    return burntime.entrySet();
	}
	
	public void setStartingMana(int Mana)
	{
		mana = Mana;
	}
	
	public void naturalManaRegenoverTime(double NaturalGen)
	{
		naturalRegen = NaturalGen;
	}
	
	public void registerBurnableItem(Item item, double generatedMana)
	{
		burntime.put(new ItemStack(item), generatedMana);
	}
	
	public void registerBurnableItem(Block item, double generatedMana)
	{
		burntime.put(new ItemStack(item), generatedMana);
	}

	public void addMana(double Mana)
	{
		mana += Mana;
	}
	
	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ItemStack getStackInSlot(int p_70301_1_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getInventoryName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void openInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public double getNaturalRegenTime()
	{
		return naturalRegen;
	}
	
	public void setMaxManaStorageSize(double Size)
	{
		manastoragesize = Size;
	}
	
	public double getMaxStorageSize()
	{
		return manastoragesize;
	}
	
	public void takeMana(double d)
    {
    	this.mana -= d;
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
    public void updateEntity()
    {
    	this.field_145927_n = this.field_145930_m;
        this.field_145925_p = this.field_145928_o;
        EntityPlayer entityplayer = this.worldObj.getClosestPlayer((double)((float)this.xCoord + 0.5F), (double)((float)this.yCoord + 0.5F), (double)((float)this.zCoord + 0.5F), 3.0D);

        if(this.mana <= 0)
        {
        	this.getWorldObj().setBlockToAir(this.xCoord, this.yCoord, this.zCoord);
        }
		
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
}
