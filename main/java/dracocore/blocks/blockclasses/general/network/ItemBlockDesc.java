package dracocore.blocks.blockclasses.general.network;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dracocore.blocks.blockclasses.general.block.BlockBase;
import dracocore.blocks.tileentity.mana.storage.TileEntityElementalCrystal;
import dracocore.energy.tile.TileBaseUniversalElectricalSource;

public class ItemBlockDesc extends ItemBlockGC
{
    public static interface IBlockShiftDesc
    {
        String getShiftDescription(int meta);

        boolean showDescription(int meta);
    }

    public ItemBlockDesc(Block block)
    {
        super(block);
    }

    @Override
    public void onCreated(ItemStack stack, World world, EntityPlayer player)
    {
        if (!world.isRemote) return;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List info, boolean advanced)
    {
        if (this.field_150939_a instanceof IBlockShiftDesc && ((IBlockShiftDesc) this.field_150939_a).showDescription(stack.getItemDamage()))
        {
            if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
            {
                info.addAll(FMLClientHandler.instance().getClient().fontRenderer.listFormattedStringToWidth(((IBlockShiftDesc) this.field_150939_a).getShiftDescription(stack.getItemDamage()), 150));
            }
            else
            {
                if (this.field_150939_a instanceof BlockBase)
                {
                    TileEntity te = ((BlockBase) this.field_150939_a).createTileEntity(null, stack.getItemDamage() & 12);
                    if (te instanceof TileBaseUniversalElectricalSource && !(te instanceof TileEntityElementalCrystal))
                    {
                        float powerDrawn = ((TileBaseUniversalElectricalSource) te).storage.getMaxExtract();
                        if (powerDrawn > 0)
                        {
                        }
                    }
                }
                else if (this.field_150939_a instanceof BlockBase)
                {
                    TileEntity te = ((BlockBase) this.field_150939_a).createTileEntity(player.worldObj, stack.getItemDamage() & 12);
                    if (te instanceof TileBaseUniversalElectricalSource)
                    {
                        float powerDrawn = ((TileBaseUniversalElectricalSource) te).storage.getMaxExtract();
                        if (powerDrawn > 0)
                        {
                           // info.add(EnumChatFormatting.GREEN + GCCoreUtil.translateWithFormat("itemDesc.powerdraw.name", EnergyDisplayHelper.getEnergyDisplayS(powerDrawn * 20)));
                        }
                    }
                }
                //info.add(GCCoreUtil.translateWithFormat("itemDesc.shift.name", GameSettings.getKeyDisplayString(FMLClientHandler.instance().getClient().gameSettings.keyBindSneak.getKeyCode())));
            }
        }
    }
}
