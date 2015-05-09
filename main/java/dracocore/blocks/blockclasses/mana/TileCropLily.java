package dracocore.blocks.blockclasses.mana;

import java.util.EnumSet;
import java.util.List;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.ForgeDirection;
import dracocore.api.transmission.NetworkType;
import dracocore.blocks.tileentity.mana.crystal.TileEntityManaPipe;
import dracocore.blocks.tileentity.mana.storage.TileManaStorage;
import dracocore.interfaces.IRitualAltar;

public class TileCropLily extends TileManaStorage
{

	protected TileEntity supertile;
	public int ticksExisted = 0;
	
	public TileCropLily() 
	{
		super(100000, 100000);
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
		if(ticksExisted % 5 == 0) {
			List<EntityLivingBase> entities = this.getWorldObj().getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(this.xCoord - 6, this.yCoord, this.zCoord - 6, this.xCoord + 6, this.yCoord + 1, this.zCoord + 6));
			IEntitySelector selector = getSelector();
		
			for(EntityLivingBase entity : entities) {
				if(!selector.isEntityApplicable(entity))
					continue;

				if(entity instanceof EntitySkeleton && ((EntitySkeleton) entity).getSkeletonType() == 1 && !this.worldObj.isRemote && this.storage.getEnergyStored() >= 1500) 
				{
					entity.setDead();
					EntitySkeleton entityskeleton = new EntitySkeleton(this.worldObj);
		            entityskeleton.setCurrentItemOrArmor(0, new ItemStack(Items.bow));
		            entityskeleton.setSkeletonType(0);
		            entityskeleton.setLocationAndAngles(entity.posX, entity.posY, entity.posZ, entity.rotationYaw, entity.rotationPitch);
		            this.worldObj.spawnEntityInWorld(entityskeleton);
		            this.storage.setEnergyStored(this.storage.getEnergyStored() - 1500);
					break;
				}
				
				if(entity instanceof EntityPigZombie && !this.worldObj.isRemote && this.storage.getEnergyStored() >= 1500) 
				{
					entity.setDead();
					EntityPig entitypigzombie = new EntityPig(this.worldObj);
		            entitypigzombie.setLocationAndAngles(entity.posX, entity.posY, entity.posZ, entity.rotationYaw, entity.rotationPitch);
		            this.worldObj.spawnEntityInWorld(entitypigzombie);
		            this.storage.setEnergyStored(this.storage.getEnergyStored() - 1500);
					break;
				}
				
				if(entity instanceof EntityCaveSpider && !(entity instanceof EntitySpider) && !this.worldObj.isRemote && this.storage.getEnergyStored() >= 1500) 
				{
					entity.setDead();
					EntitySpider entitycavespider = new EntitySpider(this.worldObj);
		            entitycavespider.setLocationAndAngles(entity.posX, entity.posY, entity.posZ, entity.rotationYaw, entity.rotationPitch);
		            this.worldObj.spawnEntityInWorld(entitycavespider);
		            this.storage.setEnergyStored(this.storage.getEnergyStored() - 1500);
					break;
				}
				
				if(entity instanceof EntityWitch && !this.worldObj.isRemote && this.storage.getEnergyStored() >= 1500) 
				{
					entity.setDead();
					EntityVillager entitywitch = new EntityVillager(this.worldObj);
		            entitywitch.setLocationAndAngles(entity.posX, entity.posY, entity.posZ, entity.rotationYaw, entity.rotationPitch);
		            this.worldObj.spawnEntityInWorld(entitywitch);
		            this.storage.setEnergyStored(this.storage.getEnergyStored() - 1500);
					break;
				}
				
				if(entity instanceof EntityMagmaCube && !(entity instanceof EntitySlime) && !this.worldObj.isRemote && this.storage.getEnergyStored() >= 1500)
				{
					entity.setDead();
					EntitySlime entitymagmacube = new EntitySlime(this.worldObj);
					entitymagmacube.setLocationAndAngles(entity.posX, entity.posY, entity.posZ, entity.rotationYaw, entity.rotationPitch);
		            this.worldObj.spawnEntityInWorld(entitymagmacube);
		            this.storage.setEnergyStored(this.storage.getEnergyStored() - 1500);
					break;
				}
			}
		}
		
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
	
	public IEntitySelector getSelector() {
		return new IEntitySelector() {

			@Override
			public boolean isEntityApplicable(Entity entity) {
				return !(entity instanceof EntityPlayer);
			}

		};
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
