package dracocore.proxies.helpers;

import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dracocore.items.general.ItemsGeneral;

public class MobDeathItemDropper {

    private static double rand;

    @SubscribeEvent
    public void onEntityDrop(LivingDropsEvent event) {
    	if(event.entity instanceof EntityDragon) 
    	{
  		  	event.entity.entityDropItem(new ItemStack(ItemsGeneral.DragonScales, 1), 0.0F);
  		  	event.entity.entityDropItem(new ItemStack(ItemsGeneral.DragonFangs, 1), 0.0F);
  			event.entity.entityDropItem(new ItemStack(ItemsGeneral.DragonTalons), 0.0F);
    	}
    }
    

}