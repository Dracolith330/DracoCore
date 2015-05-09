package dracocore.blocks.renders.blockrenders.mana.generator;
 
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
import dracocore.blocks.models.modelCrystal;
import dracocore.blocks.renders.RenderHelper;
import dracocore.blocks.tileentity.mana.generator.TileEntityCrystalManaSource;

public class CrystalManaSourceRender extends TileEntitySpecialRenderer {
	private RenderHelper.ItemRender resultRenderer;
	float f6 = 0f;	
	public static String element;
    private static final ResourceLocation crystalTexture = new ResourceLocation(References.texturelocation, "textures/BlockModels/crystal.png");
    private modelCrystal crystal = new modelCrystal();
    private static final ResourceLocation ringTexture = new ResourceLocation(References.texturelocation, "textures/BlockModels/ring.png");
    private ModelRing ring = new ModelRing();
    Random rand = new Random();
    
    public void renderAModelAt(TileEntityCrystalManaSource tileentity1, double d, double d1, double d2, float f) 
    {
    	float f1 = (float)tileentity1.field_145926_a + f;
    	float f2;
    	EntityPlayer p = Minecraft.getMinecraft().thePlayer;
    	float shade = MathHelper.sin((p.cameraPitch + rand.nextInt(10)) / (5.0F + rand.nextFloat())) * 0.075F + 0.925F;
    	   
    	int var19 = (int)(210.0F * shade);
        int var20 = var19 % 65536;
        int var21 = var19 / 65536;
        
        for (f2 = tileentity1.field_145928_o - tileentity1.field_145925_p; f2 >= (float)Math.PI; f2 -= ((float)Math.PI * 2F))
        {
            ;
        }

        while (f2 < -(float)Math.PI)
        {
            f2 += ((float)Math.PI * 2F);
        }
        
    	float f3 = tileentity1.field_145925_p + f2 * f;
        
    	 
    	float f4 = tileentity1.field_145931_j + (tileentity1.field_145933_i - tileentity1.field_145931_j) * f + 0.25F;
        float f5 = tileentity1.field_145931_j + (tileentity1.field_145933_i - tileentity1.field_145931_j) * f + 0.75F;
        f4 = (f4 - (float)MathHelper.truncateDoubleToInt((double)f4)) * 1.6F - 0.3F;
        f5 = (f5 - (float)MathHelper.truncateDoubleToInt((double)f5)) * 1.6F - 0.3F;
        
        if (f4 < 0.0F)
        {
            f4 = 0.0F;
        }

        if (f5 < 0.0F)
        {
            f5 = 0.0F;
        }

        if (f4 > 1.0F)
        {
            f4 = 1.0F;
        }

        if (f5 > 1.0F)
        {
            f5 = 1.0F;
        }
       
        GL11.glPushMatrix();
        GL11.glEnable(2977);
        float displacement2 = 0.2F;
        float rotationAngle2 = (float) (720.0 * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL);
        GL11.glEnable(3042);
        GL11.glEnable(32826);
        GL11.glBlendFunc(770, 771);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.anisotropicFilteringMax, var20 / 1.0F, var21 / 1.0F);
        GL11.glTranslatef((float) d + 0.5F, (float) d1 + displacement2 + 0.0F - MathHelper.sin(f1 * 0.05F) * 0.05F, (float) d2 + 0.5F);
        GL11.glScaled(0.05, 0.25, 0.05);
        this.bindTexture(new ResourceLocation(References.texturelocation, "textures/BlockModels/Crystal.png"));
        this.crystal.render((Entity)null, f1, f4, f5, f6, 0.0F, 0.0625F);
        GL11.glScalef(1.0F, 1.0F, 1.0F);
        GL11.glDisable(32826);
        GL11.glDisable(3042);
        GL11.glPopMatrix();

        GL11.glPushMatrix();
        GL11.glEnable(2977);
        GL11.glEnable(3042);
        GL11.glEnable(32826);
        GL11.glBlendFunc(770, 771);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.anisotropicFilteringMax, var20 / 1.0F, var21 / 1.0F);
        GL11.glTranslatef((float) d + 0.5F, (float) d1 + displacement2 + 0.0F + MathHelper.sin(f1 * 0.05F) * 0.05F, (float) d2 + 0.5F);
        GL11.glScaled(0.05, 0.25, 0.05);
        this.bindTexture(new ResourceLocation(References.texturelocation, "textures/BlockModels/Crystal.png"));
        this.crystal.render((Entity)null, f1, f4, f5, f6, 0.0F, 0.0625F);
        GL11.glScalef(1.0F, 1.0F, 1.0F);
        GL11.glDisable(32826);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
        
        GL11.glPushMatrix();
        GL11.glEnable(2977);
        GL11.glEnable(3042);
        GL11.glEnable(32826);
        GL11.glBlendFunc(770, 771);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.anisotropicFilteringMax, var20 / 1.0F, var21 / 1.0F);
        GL11.glTranslatef((float) d + 0.6F + MathHelper.sin(f1 * 0.05F) * 0.05F, (float) d1 + displacement2 + 0.23F, (float) d2 + 0.5F);
        GL11.glScaled(0.25, 0.05, 0.05);
        this.bindTexture(new ResourceLocation(References.texturelocation, "textures/BlockModels/Crystal.png"));
        this.crystal.render((Entity)null, f1, f4, f5, f6, 0.0F, 0.0625F);
        GL11.glScalef(1.0F, 1.0F, 1.0F);
        GL11.glDisable(32826);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
        
        GL11.glPushMatrix();
        GL11.glEnable(2977);
        GL11.glEnable(3042);
        GL11.glEnable(32826);
        GL11.glBlendFunc(770, 771);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.anisotropicFilteringMax, var20 / 1.0F, var21 / 1.0F);
        GL11.glTranslatef((float) d + 0.4F - MathHelper.sin(f1 * 0.05F) * 0.05F, (float) d1 + displacement2 + 0.23F, (float) d2 + 0.5F);
        GL11.glScaled(0.25, 0.05, 0.05);
        this.bindTexture(new ResourceLocation(References.texturelocation, "textures/BlockModels/Crystal.png"));
        this.crystal.render((Entity)null, f1, f4, f5, f6, 0.0F, 0.0625F);
        GL11.glScalef(1.0F, 1.0F, 1.0F);
        GL11.glDisable(32826);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
        
        GL11.glPushMatrix();
        GL11.glEnable(2977);
        GL11.glEnable(3042);
        GL11.glEnable(32826);
        GL11.glBlendFunc(770, 771);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.anisotropicFilteringMax, var20 / 1.0F, var21 / 1.0F);
        GL11.glTranslatef((float) d + 0.5F, (float) d1 + displacement2 + 0.23F, (float) d2 + 0.6F + MathHelper.sin(f1 * 0.05F) * 0.05F);
        GL11.glScaled(0.05, 0.05, 0.25);
        this.bindTexture(new ResourceLocation(References.texturelocation, "textures/BlockModels/Crystal.png"));
        this.crystal.render((Entity)null, f1, f4, f5, f6, 0.0F, 0.0625F);
        GL11.glScalef(1.0F, 1.0F, 1.0F);
        GL11.glDisable(32826);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
        
        GL11.glPushMatrix();
        GL11.glEnable(2977);
        GL11.glEnable(3042);
        GL11.glEnable(32826);
        GL11.glBlendFunc(770, 771);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.anisotropicFilteringMax, var20 / 1.0F, var21 / 1.0F);
        GL11.glTranslatef((float) d + 0.5F, (float) d1 + displacement2 + 0.23F, (float) d2 + 0.4F - MathHelper.sin(f1 * 0.05F) * 0.05F);
        GL11.glScaled(0.05, 0.05, 0.25);
        this.bindTexture(new ResourceLocation(References.texturelocation, "textures/BlockModels/Crystal.png"));
        this.crystal.render((Entity)null, f1, f4, f5, f6, 0.0F, 0.0625F);
        GL11.glScalef(1.0F, 1.0F, 1.0F);
        GL11.glDisable(32826);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
        
		GL11.glPushMatrix();
		GL11.glAlphaFunc(516, 0.003921569F);
		GL11.glEnable(3042);
		GL11.glBlendFunc(770, 1);
		GL11.glDepthMask(false);

		this.bindTexture(new ResourceLocation(References.texturelocation, "textures/misc/PureMana.png"));
		RenderHelper.renderFacingQuad(tileentity1.xCoord + 0.5D, tileentity1.yCoord + 0.5D, tileentity1.zCoord + 0.5D, 0.0F, 0.32F + MathHelper.sin(f1 * 0.05F) * 0.08F, 1, 1, 0, f);

		GL11.glDepthMask(true);
		GL11.glDisable(3042);
		GL11.glAlphaFunc(516, 0.1F);
		GL11.glPopMatrix();
		
    }


        public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f) 
        {
        	//aModel.renderBloodAltar((TileEntityElementalCrystal) tileentity, d, d1, d2);
        	renderAModelAt((TileEntityCrystalManaSource)tileentity, d, d1, d2, f);
        }
 
    
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
    	
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityCrystalManaSource(), 0.0D, 0.0D, 0.0D, 0.0F);
	}
    
}