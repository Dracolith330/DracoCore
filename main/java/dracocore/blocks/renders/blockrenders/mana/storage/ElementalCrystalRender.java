package dracocore.blocks.renders.blockrenders.mana.storage;
 
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
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import dracocore.References;
import dracocore.blocks.models.ModelRing;
import dracocore.blocks.renders.RenderHelper;
import dracocore.blocks.tileentity.mana.storage.TileEntityElementalCrystal;

public class ElementalCrystalRender extends TileEntitySpecialRenderer 
{
	private RenderHelper.ItemRender resultRenderer;
	float f6 = 0f;	
	public static String element;
    private static final ResourceLocation ringTexture = new ResourceLocation(References.texturelocation, "textures/BlockModels/ring.png");
    private ModelRing ring = new ModelRing();
    Random rand = new Random();
    private static final ResourceLocation ManaPipe = new ResourceLocation(References.texturelocation, "textures/model/ManaPipe.png");
    public final IModelCustom Crystal;
    public final IModelCustom ImportandExport;
    
    public ElementalCrystalRender() 
    {
    	this.Crystal = AdvancedModelLoader.loadModel(new ResourceLocation(References.texturelocation, "models/Crystal.obj"));
    	this.ImportandExport = AdvancedModelLoader.loadModel(new ResourceLocation(References.texturelocation, "models/ImportandExport.obj"));
    }
    
    public void renderAModelAt(TileEntityElementalCrystal tileentity1, double d, double d1, double d2, float f) 
    {
    	float f1 = (float)tileentity1.ticks + f;
    	float f2;
    	int facing = tileentity1.facing;
    	EntityPlayer p = Minecraft.getMinecraft().thePlayer;
    	float shade = MathHelper.ceiling_float_int((p.cameraYaw + rand.nextInt(10)) / (5.0F + rand.nextFloat())) * 0.075F + 0.925F;
    	   
    	int var19 = (int)(210.0F * shade);
        int var20 = var19 % 65536;
        int var21 = var19 / 65536;
        
        IModelCustom Crystal = this.Crystal;

        IModelCustom ImportandExport = this.ImportandExport;
        
        GL11.glPushMatrix();
        
        GL11.glEnable(2977);
        GL11.glEnable(3042);
        GL11.glEnable(32826);
        GL11.glBlendFunc(770, 771);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.anisotropicFilteringMax, var20 / 1.0F, var21 / 1.0F);
        float displacement2 = 0.2F;
        float rotationAngle2 = (float) (720.0 * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL);
        GL11.glTranslatef((float) d + 0.5F, (float) d1 + displacement2+0.31F + MathHelper.sin(f1 * 0.1F) * 0.05F, (float) d2 + 0.5F);
		GL11.glScaled(2, 5, 2);
        GL11.glRotatef(-rotationAngle2, 0, 1, 0);
    	FMLClientHandler.instance().getClient().renderEngine.bindTexture(ManaPipe);
        Crystal.renderAll();
        GL11.glScalef(1.0F, 1.0F, 1.0F);
        GL11.glDisable(32826);
        GL11.glDisable(3042);

        GL11.glPopMatrix();
        
        GL11.glPushMatrix();
        

        translateFromOrientation(d+0.5F, d1 + displacement2+0.3004F, d2+0.5F, facing);
        
        GL11.glEnable(2977);
        GL11.glEnable(3042);
        GL11.glEnable(32826);
        GL11.glBlendFunc(770, 771);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.anisotropicFilteringMax, var20 / 1.0F, var21 / 1.0F);
		GL11.glScaled(0.9, 1, 0.9);
        GL11.glRotatef(90, 0, 1, 0);
        GL11.glRotatef(90, 0, 1, 0);
    	FMLClientHandler.instance().getClient().renderEngine.bindTexture(ManaPipe);
        ImportandExport.renderAll();
        GL11.glScalef(1.0F, 1.0F, 1.0F);
        GL11.glDisable(32826);
        GL11.glDisable(3042);

        GL11.glPopMatrix();
        
        GL11.glPushMatrix();
        
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.anisotropicFilteringMax, var20 / 1.0F, var21 / 1.0F);
        float displacement1 = 0.2F;
        float rotationAngle11 = (float) (720.0 * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL);
        GL11.glTranslatef((float) d + 0.5F, (float) d1 + displacement1 - 0.05F + MathHelper.sin(f1 * 0.1F) * 0.05F, (float) d2 + 0.5F);
        GL11.glScaled(0.35, 0.4, 0.35);
        this.bindTexture(new ResourceLocation(References.texturelocation, "textures/BlockModels/Ring.png"));
		this.ring.render((Entity)null, 0, 0, 0, 0, 0.0F, 0.0625F);
		GL11.glDisable(GL11.GL_BLEND);
		
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.anisotropicFilteringMax, var20 / 1.0F, var21 / 1.0F);
        GL11.glTranslatef((float) d + 0.5F, (float) d1 + displacement1 - 0.45F + MathHelper.sin(f1 * 0.1F) * 0.05F, (float) d2 + 0.5F);
        GL11.glScaled(0.35, 0.4, 0.35);
        this.bindTexture(new ResourceLocation(References.texturelocation, "textures/BlockModels/Ring.png"));
		this.ring.render((Entity)null, 0, 0, 0, 0, 0.0F, 0.0625F);
		GL11.glDisable(GL11.GL_BLEND);
		
        GL11.glPopMatrix();
        
        
        
        GL11.glPushMatrix();
        
        GL11.glEnable(2977);
        GL11.glEnable(3042);
        GL11.glEnable(32826);
        GL11.glBlendFunc(770, 771);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.anisotropicFilteringMax, var20 / 1.0F, var21 / 1.0F);
        GL11.glTranslatef((float) d + 0.3F, (float) d1 + displacement2 + 0.53F - MathHelper.sin(f1 * 0.1F) * 0.05F, (float) d2 + 0.3F);
        GL11.glScaled(0.5, 2, 0.5);
        GL11.glRotatef(-rotationAngle2, 0, 1, 0);
    	FMLClientHandler.instance().getClient().renderEngine.bindTexture(ManaPipe);
        Crystal.renderAll();
        GL11.glScalef(1.0F, 1.0F, 1.0F);
        GL11.glDisable(32826);
        GL11.glDisable(3042);

        GL11.glPopMatrix();
        GL11.glPushMatrix();
        
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.anisotropicFilteringMax, var20 / 1.0F, var21 / 1.0F);
        GL11.glTranslatef((float) d + 0.3F, (float) d1 + displacement1 + 0.15F - MathHelper.sin(f1 * 0.1F) * 0.05F, (float) d2 + 0.3F);
        GL11.glScaled(0.1, 0.2, 0.1);
        this.bindTexture(new ResourceLocation(References.texturelocation, "textures/BlockModels/Ring.png"));
		this.ring.render((Entity)null, 0, 0, 0, 0, 0.0F, 0.0625F);
		GL11.glDisable(GL11.GL_BLEND);
		
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.anisotropicFilteringMax, var20 / 1.0F, var21 / 1.0F);
        GL11.glTranslatef((float) d + 0.3F, (float) d1 + displacement1 + 0.32F - MathHelper.sin(f1 * 0.1F) * 0.05F, (float) d2 + 0.3F);
        GL11.glScaled(0.1, 0.2, 0.1);
        this.bindTexture(new ResourceLocation(References.texturelocation, "textures/BlockModels/Ring.png"));
		this.ring.render((Entity)null, 0, 0, 0, 0, 0.0F, 0.0625F);
		GL11.glDisable(GL11.GL_BLEND);
		
        GL11.glPopMatrix();
        
        
        
        
        GL11.glPushMatrix();
        
        GL11.glEnable(2977);
        GL11.glEnable(3042);
        GL11.glEnable(32826);
        GL11.glBlendFunc(770, 771);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.anisotropicFilteringMax, var20 / 1.0F, var21 / 1.0F);
        GL11.glTranslatef((float) d + 0.7F, (float) d1 + displacement2 + 0.1F + MathHelper.sin(f1 * 0.1F) * 0.05F, (float) d2 + 0.3F);
		GL11.glScaled(0.5, 2, 0.5);
        GL11.glRotatef(rotationAngle2, 0, 1, 0);
    	FMLClientHandler.instance().getClient().renderEngine.bindTexture(ManaPipe);
        Crystal.renderAll();
        GL11.glScalef(1.0F, 1.0F, 1.0F);
        GL11.glDisable(32826);
        GL11.glDisable(3042);

        GL11.glPopMatrix();
        GL11.glPushMatrix();
        
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.anisotropicFilteringMax, var20 / 1.0F, var21 / 1.0F);
        GL11.glTranslatef((float) d + 0.7F, (float) d1 + displacement1 - 0.29F + MathHelper.sin(f1 * 0.1F) * 0.05F, (float) d2 + 0.3F);
        GL11.glScaled(0.1, 0.2, 0.1);
        this.bindTexture(new ResourceLocation(References.texturelocation, "textures/BlockModels/Ring.png"));
		this.ring.render((Entity)null, 0, 0, 0, 0, 0.0F, 0.0625F);
		GL11.glDisable(GL11.GL_BLEND);
		
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.anisotropicFilteringMax, var20 / 1.0F, var21 / 1.0F);
        GL11.glTranslatef((float) d + 0.7F, (float) d1 + displacement1 - 0.1F + MathHelper.sin(f1 * 0.1F) * 0.05F, (float) d2 + 0.3F);
        GL11.glScaled(0.1, 0.2, 0.1);
        this.bindTexture(new ResourceLocation(References.texturelocation, "textures/BlockModels/Ring.png"));
		this.ring.render((Entity)null, 0, 0, 0, 0, 0.0F, 0.0625F);
		GL11.glDisable(GL11.GL_BLEND);
		
        GL11.glPopMatrix();
        
        
        
        
        GL11.glPushMatrix();
        
        GL11.glEnable(2977);
        GL11.glEnable(3042);
        GL11.glEnable(32826);
        GL11.glBlendFunc(770, 771);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.anisotropicFilteringMax, var20 / 1.0F, var21 / 1.0F);
        GL11.glTranslatef((float) d + 0.1F + displacement2, (float) d1 + displacement2 + 0.3F + MathHelper.sin(f1 * 0.1F) * 0.05F, (float) d2 + 0.7F);
		GL11.glScaled(0.5, 2, 0.5);
        GL11.glRotatef(rotationAngle2, 0, 1, 0);
    	FMLClientHandler.instance().getClient().renderEngine.bindTexture(ManaPipe);
        Crystal.renderAll();
        GL11.glScalef(1.0F, 1.0F, 1.0F);
        GL11.glDisable(32826);
        GL11.glDisable(3042);

        GL11.glPopMatrix();
        GL11.glPushMatrix();
        
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.anisotropicFilteringMax, var20 / 1.0F, var21 / 1.0F);
        GL11.glTranslatef((float) d + 0.1F  + displacement2, (float) d1 + displacement1 + 0.1F + MathHelper.sin(f1 * 0.1F) * 0.05F, (float) d2 + 0.7F);
        GL11.glScaled(0.1, 0.2, 0.1);
        this.bindTexture(new ResourceLocation(References.texturelocation, "textures/BlockModels/Ring.png"));
		this.ring.render((Entity)null, 0, 0, 0, 0, 0.0F, 0.0625F);
		GL11.glDisable(GL11.GL_BLEND);
		
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.anisotropicFilteringMax, var20 / 1.0F, var21 / 1.0F);
        GL11.glTranslatef((float) d + 0.1F  + displacement2, (float) d1 + displacement1 - 0.08F + MathHelper.sin(f1 * 0.1F) * 0.05F, (float) d2 + 0.7F);
        GL11.glScaled(0.1, 0.2, 0.1);
        this.bindTexture(new ResourceLocation(References.texturelocation, "textures/BlockModels/Ring.png"));
		this.ring.render((Entity)null, 0, 0, 0, 0, 0.0F, 0.0625F);
		GL11.glDisable(GL11.GL_BLEND);
		
        GL11.glPopMatrix();
        
        
        
        
        GL11.glPushMatrix();
        
        GL11.glEnable(2977);
        GL11.glEnable(3042);
        GL11.glEnable(32826);
        GL11.glBlendFunc(770, 771);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.anisotropicFilteringMax, var20 / 1.0F, var21 / 1.0F);
        GL11.glTranslatef((float) d + 0.7F, (float) d1 + displacement2 + 0.42F - MathHelper.sin(f1 * 0.1F) * 0.05F, (float) d2 + 0.7F);
        GL11.glScaled(0.5, 2, 0.5);
        GL11.glRotatef(-rotationAngle2, 0, 1, 0);
    	FMLClientHandler.instance().getClient().renderEngine.bindTexture(ManaPipe);
        Crystal.renderAll();
        GL11.glScalef(1.0F, 1.0F, 1.0F);
        GL11.glDisable(32826);
        GL11.glDisable(3042);

        GL11.glPopMatrix();
        GL11.glPushMatrix();
        
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.anisotropicFilteringMax, var20 / 1.0F, var21 / 1.0F);
        GL11.glTranslatef((float) d + 0.7F, (float) d1 + displacement1 + 0.04F - MathHelper.sin(f1 * 0.1F) * 0.05F, (float) d2 + 0.7F);
        GL11.glScaled(0.1, 0.2, 0.1);
        this.bindTexture(new ResourceLocation(References.texturelocation, "textures/BlockModels/Ring.png"));
		this.ring.render((Entity)null, 0, 0, 0, 0, 0.0F, 0.0625F);
		GL11.glDisable(GL11.GL_BLEND);
		
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.anisotropicFilteringMax, var20 / 1.0F, var21 / 1.0F);
        GL11.glTranslatef((float) d + 0.7F, (float) d1 + displacement1 + 0.23F - MathHelper.sin(f1 * 0.1F) * 0.05F, (float) d2 + 0.7F);
        GL11.glScaled(0.1, 0.2, 0.1);
        this.bindTexture(new ResourceLocation(References.texturelocation, "textures/BlockModels/Ring.png"));
		this.ring.render((Entity)null, 0, 0, 0, 0, 0.0F, 0.0625F);
		GL11.glDisable(GL11.GL_BLEND);
		
        GL11.glPopMatrix();
        
        GL11.glPushMatrix();
		GL11.glAlphaFunc(516, 0.003921569F);
		GL11.glEnable(3042);
		GL11.glBlendFunc(770, 1);
		GL11.glDepthMask(false);
		float alpha = MathHelper.sin(Minecraft.getMinecraft().renderViewEntity.ticksExisted / 8.0F) * 0.1F + 0.5F;
		this.bindTexture(new ResourceLocation(References.texturelocation, "textures/misc/bubble.png"));
		RenderHelper.renderFacingQuad(tileentity1.xCoord + 0.5D, tileentity1.yCoord + 0.5D + MathHelper.sin(f1 * 0.1F) * 0.05F, tileentity1.zCoord + 0.5D, 0.0F, 0.65F, 1, 1, 0, f);
		GL11.glDepthMask(true);
		GL11.glDisable(3042);
		GL11.glAlphaFunc(516, 0.1F);
		GL11.glPopMatrix();
        
        
        
    }

    private void translateFromOrientation(double x, double y, double z, int orientation)
    {
      GL11.glTranslated(x, y, z);
      switch (orientation)
      {
      case 5: 
        GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F); break;
      case 3: 
        GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F); break;
      case 2: 
        GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
      }
    }
        public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f) 
        {
        	//aModel.renderBloodAltar((TileEntityElementalCrystal) tileentity, d, d1, d2);
        	renderAModelAt((TileEntityElementalCrystal)tileentity, d, d1, d2, f);
        }
 
    
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
    	
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityElementalCrystal(), 0.0D, 0.0D, 0.0D, 0.0F);
	}
    
}