package dracocore.blocks.tileentity.mana.storage;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import dracocore.api.network.IPacketReceiver;
import dracocore.api.power.ItemElectricBase;
import dracocore.api.transmission.NetworkType;
import dracocore.api.transmission.tile.IConnector;
import dracocore.blocks.tileentity.mana.crystal.TileBaseUniversalManaSource;

public class TileStaticCrystal extends TileManaStorage
{
    public TileStaticCrystal()
    {
    	super(1000000, 1000);
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
    			player.addChatMessage(new ChatComponentText("Mana: " + (double)Math.round(this.getEnergyStored() * 100) / 100));
    	}
	}
}
