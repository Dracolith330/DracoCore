package dracocore.blocks.renders.blockrenders.power.wire;
 
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import dracocore.References;
import dracocore.api.transmission.power.PowerUtil;
import dracocore.blocks.blockclasses.mana.TileAcceleratedCrystalCluster;
import dracocore.blocks.blockclasses.mana.TileCorruptObelisk;
import dracocore.blocks.renders.QuadHelper;
import dracocore.blocks.tileentity.mana.generator.TileEntitySolarManaGenerator;

public class AcceleratedCrystalClusterRender extends TileEntitySpecialRenderer 
{
    private static final ResourceLocation Wire = new ResourceLocation(References.texturelocation, "textures/model/.png");
    public final IModelCustom Obelisk;

    public AcceleratedCrystalClusterRender() 
    {
    	this.Obelisk = AdvancedModelLoader.loadModel(new ResourceLocation(References.texturelocation, "models/AcceleratedCrystalCluster.obj"));
    }
    
    
    public void renderModelAt(TileAcceleratedCrystalCluster tileentity, double d, double d1, double d2, float f)
    {
    	FMLClientHandler.instance().getClient().renderEngine.bindTexture(AcceleratedCrystalClusterRender.Wire);
    	float rotationAngle = (float) (720.0 * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL);
    	
    	GL11.glDisable(GL11.GL_LIGHTING);
    	GL11.glPushMatrix();
    	GL11.glTranslatef((float) d + 0.5F, (float) d1 + 0.05F, (float) d2 + 0.5F);
    	GL11.glScalef(3.85F, 3.5F, 3.85F);
    	Obelisk.renderPart("Base");
    	Obelisk.renderPart("MainCrystal");
    	renderAndRotate("RotatingCrystal1", rotationAngle, true);
    	renderAndRotate("RotatingCrystal2", rotationAngle, false);
    	
    	GL11.glPopMatrix();
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glEnable(GL11.GL_LIGHTING);
        
    }

    private void renderAndRotate(String s, float f, boolean positive)
    {
    	if(positive)
    		GL11.glRotatef(f, 0, 1, 0);
    	else
    		GL11.glRotated(-f*2, 0, 1, 0);
    	Obelisk.renderPart(s);
    }
    
    public void renderIcon(int par1, int par2, IIcon par3Icon, int par4, int par5, int brightness) 
    {
    	Tessellator tessellator = Tessellator.instance;
    	tessellator.startDrawingQuads();
    	tessellator.setBrightness(brightness);
    	tessellator.addVertexWithUV(par1 + 0, par2 + par5, 0, par3Icon.getMinU(), par3Icon.getMaxV());
    	tessellator.addVertexWithUV(par1 + par4, par2 + par5, 0, par3Icon.getMaxU(), par3Icon.getMaxV());
    	tessellator.addVertexWithUV(par1 + par4, par2 + 0, 0, par3Icon.getMaxU(), par3Icon.getMinV());
    	tessellator.addVertexWithUV(par1 + 0, par2 + 0, 0, par3Icon.getMinU(), par3Icon.getMinV());
    	tessellator.draw();
    }
    
    public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f) 
    {
    	renderModelAt((TileAcceleratedCrystalCluster)tileentity, d, d1, d2, f);
    }
    
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) 
    {	
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileAcceleratedCrystalCluster(), 0.0D, 0.0D, 0.0D, 0.0F);
	}
}