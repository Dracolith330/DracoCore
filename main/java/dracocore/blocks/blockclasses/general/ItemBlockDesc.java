package dracocore.blocks.blockclasses.general;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBlockDesc extends ItemBlockDC
{
    public static interface IBlockShiftDesc
    {
        String getShiftDescription(int meta);

        boolean showDescription(int meta);
    }

    public ItemBlockDesc(Fluid block, String fluid)
    {
        super(block, fluid);
    }

}
