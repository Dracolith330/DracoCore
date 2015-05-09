package dracocore.blocks.renders.blockrenders.mana.generator;
 
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import dracocore.References;
import dracocore.blocks.tileentity.mana.generator.TileEntitySolarManaGenerator;

public class SolarGeneratorRenderer extends TileEntitySpecialRenderer {
	
    Random rand = new Random();
    public final IModelCustom SMGenerator;
    
    public SolarGeneratorRenderer() 
    {
        SMGenerator = AdvancedModelLoader.loadModel(new ResourceLocation(References.texturelocation, "models/SolarManaGenerator.obj"));
    }
    
    
    public void renderAModelAt(TileEntitySolarManaGenerator tileentity1, double d, double d1, double d2, float f) {
    	
    	float f1 = (float)tileentity1.ticks + f;
    	EntityPlayer p = Minecraft.getMinecraft().thePlayer;
    	float shade = MathHelper.sin((p.cameraPitch + rand.nextInt(10)) / (5.0F + rand.nextFloat())) * 0.075F + 0.925F;
    	   
    	int var19 = (int)(210.0F * shade);
        int var20 = var19 % 65536;
        int var21 = var19 / 65536;
    	
    		this.bindTexture(new ResourceLocation(References.texturelocation, "textures/BlockModels/SolarManaGenerator.png"));

    		
            GL11.glPushMatrix();
            GL11.glTranslatef((float)d + 0.5F, (float)d1 + 0.54F, (float)d2 + 0.5F);
            GL11.glScalef(1.0F, -1F, -1F);
            GL11.glRotatef(180, 0, 0, 1);
            SMGenerator.renderAll();
            GL11.glPopMatrix();

            if (tileentity1 instanceof TileEntitySolarManaGenerator)
            {
            	TileEntitySolarManaGenerator tileAltar = (TileEntitySolarManaGenerator) tileentity1;
            	
            	float waterLevel = (float) tileAltar.storage.getEnergyStored() / (float) tileAltar.getMaxEnergyStored() * 0.4F;

            	float s = 1F / 16F;
            	float v = 1F / 8F;
            	float w = -v * 3.5F;

            	GL11.glDisable(GL11.GL_LIGHTING);
            	GL11.glPushMatrix();

            	
            	GL11.glPopMatrix();
            	GL11.glEnable(GL11.GL_CULL_FACE);
            	GL11.glEnable(GL11.GL_LIGHTING);
        		
            }
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
        renderAModelAt((TileEntitySolarManaGenerator)tileentity, d, d1, d2, f);
    }
 
    
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
    	
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntitySolarManaGenerator(), 0.0D, 0.0D, 0.0D, 0.0F);
	}
    
}