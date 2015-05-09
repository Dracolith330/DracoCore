package dracocore.blocks.blockclasses.general;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dracocore.CoreMain;
import dracocore.References;

public class ItemBlockDC extends BlockFluidClassic
{
    private IIcon stillIcon;
    private IIcon flowingIcon;
    private final String fluidName;
    private final Fluid fluid;

    public ItemBlockDC(Fluid fluid, String assetName)
    {
        super(fluid, Material.water);
        this.setRenderPass(1);
        this.fluidName = assetName;
        this.fluid = fluid;
    }

    @Override
    public CreativeTabs getCreativeTabToDisplayOn()
    {
        return CoreMain.CoreTab;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
        return par1 != 0 && par1 != 1 ? this.flowingIcon : this.stillIcon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.stillIcon = par1IconRegister.registerIcon(References.texturelocation + this.fluidName + "_still");
        this.flowingIcon = par1IconRegister.registerIcon(References.texturelocation + this.fluidName + "_flow");
        this.fluid.setStillIcon(this.stillIcon);
        this.fluid.setFlowingIcon(this.flowingIcon);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float hitX, float hitY, float hitZ)
    {
    	return super.onBlockActivated(world, x, y, z, entityPlayer, side, hitX, hitY, hitZ);	
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random rand)
    {
        super.randomDisplayTick(world, x, y, z, rand);
    }

    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z)
    {
        if (world.getBlock(x, y, z).getMaterial().isLiquid())
        {
            return false;
        }

        return super.canDisplace(world, x, y, z);
    }

    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z)
    {
        if (world.getBlock(x, y, z).getMaterial().isLiquid())
        {
            return false;
        }

        return super.displaceIfPossible(world, x, y, z);
    }

    public IIcon getStillIcon()
    {
        return this.stillIcon;
    }

    public IIcon getFlowingIcon()
    {
        return this.flowingIcon;
    }
}
