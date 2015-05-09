package dracocore.items.mana;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import dracocore.blocks.blockclasses.mana.BlocksMagic;
import dracocore.blocks.blockclasses.mana.storage.ElementalCrystal;
import dracocore.blocks.tileentity.mana.generator.TileEntityCrystalManaSource;
import dracocore.blocks.tileentity.mana.storage.TileEntityElementalCrystal;
import dracocore.proxies.Config;

public class WandCore extends Item
{
	public double currentMana = 0;
	
	public int maxCapacity(){return 0;};
	
	public void setCurrentMana(double d){currentMana = d;};
	
	public double getCurrentMana(){return currentMana;};
	
	@Override
	public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
		if(p_77659_1_.stackTagCompound == null) p_77659_1_.setTagCompound(new NBTTagCompound());
		
		System.out.println(Config.ForceRegisterZinc);
		
        boolean flag = this.currentMana != maxCapacity();
        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(p_77659_2_, p_77659_3_, flag);

        if (movingobjectposition == null)
        {
            return p_77659_1_;
        }
        else
        {
            if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
            {
                int i = movingobjectposition.blockX;
                int j = movingobjectposition.blockY;
                int k = movingobjectposition.blockZ;

                    if (!p_77659_3_.canPlayerEdit(i, j, k, movingobjectposition.sideHit, p_77659_1_))
                    {
                        return p_77659_1_;
                    }

                    Block material = p_77659_2_.getBlock(i, j, k);
                    int l = p_77659_2_.getBlockMetadata(i, j, k);

                    if (material == BlocksMagic.CrystalManaSource)
                    {
                        TileEntityCrystalManaSource tile = (TileEntityCrystalManaSource) p_77659_2_.getTileEntity(i, j, k);

                        if(tile.mana >= maxCapacity())
                        {
                        	tile.takeMana(maxCapacity());
                            setCurrentMana(maxCapacity());
                        }
                        else
                        {
                            setCurrentMana(tile.mana);
                        	tile.takeMana(tile.mana);
                        }
                    }
                    
                    if(material instanceof ElementalCrystal)
                    {
                    	TileEntityElementalCrystal tile = (TileEntityElementalCrystal) p_77659_2_.getTileEntity(i, j, k);
                    	transferMana(tile, p_77659_1_.getTagCompound().getDouble("Mana"));
                    }
                    

                }
            p_77659_1_.stackTagCompound.setDouble("Mana", currentMana);
            return p_77659_1_;
        }
        
        
    }
	

	public void transferMana(TileEntityElementalCrystal tile, double Mana)
	{
		//tile.addMana(Mana);
		setCurrentMana(0);
	}
	
	@Override
	public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) 
	{
	    if(par1ItemStack.stackTagCompound == null) par1ItemStack.setTagCompound(new NBTTagCompound());
	}
	
	@Override
	public boolean getShareTag()
	{
		return true;
	}
	  
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if( par1ItemStack.stackTagCompound == null ) par1ItemStack.setTagCompound(new NBTTagCompound());

	    par3List.add(I18n.format("Mana: " + par1ItemStack.getTagCompound().getDouble("Mana")));
	}
}
