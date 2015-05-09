package dracocore.blocks.renders.blockrenders.mana.crystal;
 
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;

import org.lwjgl.opengl.GL11;

import dracocore.References;
import dracocore.blocks.models.ModelRing;
import dracocore.blocks.models.ModelTunedCrystal;
import dracocore.blocks.models.modelCrystal;
import dracocore.blocks.renders.RenderHelper;
import dracocore.blocks.tileentity.mana.crystal.TileEntityTunedCrystal;

public class TunedCrystalRender extends TileEntitySpecialRenderer {
	private RenderHelper.ItemRender resultRenderer;
	float f6 = 0f;	
	public static String element;
	private ModelTunedCrystal aModel;
	private static final ResourceLocation RingTexture = new ResourceLocation(References.texturelocation, "textures/BlockModels/Bowl.png");
    private ModelRing Ring = new ModelRing();
    private static final ResourceLocation crystalTexture = new ResourceLocation(References.texturelocation, "textures/BlockModels/crystal.png");
    private modelCrystal crystal = new modelCrystal();
    Random rand = new Random();

    public TunedCrystalRender() {
        aModel = new ModelTunedCrystal();
    }
    
    
    public void renderAModelAt(TileEntityTunedCrystal tileentity1, double d, double d1, double d2, float f) {
    	
    	float f1 = (float)tileentity1.field_145926_a + f;
    	EntityPlayer p = Minecraft.getMinecraft().thePlayer;
    	float shade = MathHelper.sin((p.cameraPitch + rand.nextInt(10)) / (5.0F + rand.nextFloat())) * 0.075F + 0.925F;
    	   
    	int var19 = (int)(210.0F * shade);
        int var20 = var19 % 65536;
        int var21 = var19 / 65536;
        
    		this.bindTexture(new ResourceLocation(References.texturelocation, "textures/BlockModels/MagicalPlinth.png"));

    		
            GL11.glPushMatrix();
            GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
            GL11.glScalef(1.0F, -1F, -1F);
            aModel.render(0.0625F);
            GL11.glPopMatrix();

            if (tileentity1 instanceof TileEntityTunedCrystal)
            {
            	TileEntityTunedCrystal tileAltar = (TileEntityTunedCrystal) tileentity1;
            	GL11.glDisable(GL11.GL_LIGHTING);
            	GL11.glPushMatrix();

            	GL11.glPopMatrix();
            	GL11.glEnable(GL11.GL_CULL_FACE);
            	GL11.glEnable(GL11.GL_LIGHTING);
            	
            	GL11.glPushMatrix();

            	float displacement1 = 0.2F;
            	float rotationAngle11 = (float) (720.0 * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL);
            	OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.anisotropicFilteringMax, var20 / 1.0F, var21 / 1.0F);
            	GL11.glTranslatef((float) d + 0.5F, (float) d1 + displacement1 + 0.9F + MathHelper.sin(f1 * 0.1F) * 0.05F, (float) d2 + 0.5F);
    			GL11.glRotatef(-rotationAngle11, 0F, 0.5F, 0F);
    			GL11.glScaled(0.35, 0.3, 0.35);
            	this.bindTexture(new ResourceLocation(References.texturelocation, "textures/BlockModels/Ring.png"));
    			this.Ring.render((Entity)null, 0, 0, 0, 0, 0.0F, 0.0625F);
    		
            	GL11.glPopMatrix();
            	GL11.glPushMatrix();

            	OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.anisotropicFilteringMax, var20 / 1.0F, var21 / 1.0F);
            	GL11.glTranslatef((float) d + 0.5F, (float) d1 + displacement1 + 0.65F + MathHelper.sin(f1 * 0.1F) * 0.05F, (float) d2 + 0.5F);
    			GL11.glRotatef(rotationAngle11, 0F, 0.5F, 0F);
    			GL11.glScaled(0.35, 0.3, 0.35);
            	this.bindTexture(new ResourceLocation(References.texturelocation, "textures/BlockModels/Ring.png"));
    			this.Ring.render((Entity)null, 0, 0, 0, 0, 0.0F, 0.0625F);
    		
            	GL11.glPopMatrix();
            	GL11.glPushMatrix();
            
            	GL11.glEnable(2977);
            	GL11.glEnable(3042);
            	GL11.glEnable(32826);
            	GL11.glBlendFunc(770, 771);
            	OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.anisotropicFilteringMax, var20 / 1.0F, var21 / 1.0F);
            	float displacement2 = 0.2F;
            	float rotationAngle2 = (float) (720.0 * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL);
            	GL11.glTranslatef((float) d + 0.5F, (float) d1 + displacement2+0.6F + MathHelper.sin(f1 * 0.1F) * 0.05F, (float) d2 + 0.5F);
            	GL11.glRotatef(rotationAngle11, 0F, 0.5F, 0F);
    			GL11.glScaled(0.2, 0.55, 0.2);
            	this.bindTexture(new ResourceLocation(References.texturelocation, "textures/BlockModels/Crystal.png"));
            	this.crystal.render((Entity)null, 0, 0, 0, 0, 0.0F, 0.0625F);
            	GL11.glScalef(1.0F, 1.0F, 1.0F);
            	GL11.glDisable(32826);
            	GL11.glDisable(3042);
            
            	GL11.glPopMatrix();
            	
            	GL11.glPushMatrix();
        		GL11.glAlphaFunc(516, 0.003921569F);
        		GL11.glEnable(3042);
        		GL11.glBlendFunc(770, 1);
        		GL11.glDepthMask(false);

        		this.bindTexture(new ResourceLocation(References.texturelocation, "textures/misc/bubble.png"));
        		RenderHelper.renderFacingQuad(tileentity1.xCoord + 0.5D, tileentity1.yCoord + 1.43D + MathHelper.sin(f1 * 0.1F) * 0.05F, tileentity1.zCoord + 0.5D, 0.0F, 0.5F, 1, 1, 0, f);

        		GL11.glDepthMask(true);
        		GL11.glDisable(3042);
        		GL11.glAlphaFunc(516, 0.1F);
        		GL11.glPopMatrix();
            	
            }
    }


        public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f) 
        {
        	aModel.renderBloodAltar((TileEntityTunedCrystal) tileentity, d, d1, d2);
        	renderAModelAt((TileEntityTunedCrystal)tileentity, d, d1, d2, f);
        }
 
    
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
    	
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityTunedCrystal(), 0.0D, 0.0D, 0.0D, 0.0F);
	}
    
}