package dracocore.blocks.slot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotFaithInfuser extends Slot
{
  public SlotFaithInfuser(EntityPlayer entityplayer, IInventory iinventory, int i, int j, int k)
  {
    super(iinventory, i, j, k);
  }

  public boolean isItemValid(ItemStack itemstack)
  {
    return false;
  }
}