package dracocore.blocks.renders.blockrenders.mana.crystal;
 
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
import dracocore.api.transmission.mana.ManaUtil;
import dracocore.blocks.blockclasses.mana.TileCorruptObelisk;
import dracocore.blocks.renders.QuadHelper;
import dracocore.blocks.tileentity.mana.crystal.TileEntityManaPipe;
import dracocore.blocks.tileentity.mana.transfer.TileStaticManaPipe;

public class StaticManaPipeRender extends TileEntitySpecialRenderer 
{
    private static final ResourceLocation ManaPipe = new ResourceLocation(References.texturelocation, "textures/model/StaticManaPipe.png");
    public final IModelCustom Pipe;
    public final IModelCustom Crystal;

    public StaticManaPipeRender() {
    	
    	this.Pipe = AdvancedModelLoader.loadModel(new ResourceLocation(References.texturelocation, "models/ManaPipe.obj"));
    	this.Crystal = AdvancedModelLoader.loadModel(new ResourceLocation(References.texturelocation, "models/Crystal.obj"));
    	
    }
    
    
    public void renderModelAt(TileStaticManaPipe tileEntity, double d, double d1, double d2, float f)
    {
    	FMLClientHandler.instance().getClient().renderEngine.bindTexture(StaticManaPipeRender.ManaPipe);
    	
    	GL11.glPushMatrix();
    	GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);
    	GL11.glScalef(1.0F, -1F, -1F);
    	float rotationAngle2 = (float) (720.0 * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL);
        
    	TileEntity[] adjecentConnections = ManaUtil.getAdjacentPowerConnections(tileEntity);

    	Pipe.renderPart("Center");
    	
    	if (adjecentConnections[0] != null)
    	{
    		Pipe.renderPart("PipeUp");
    		renderCrystal(Crystal, "CrystalUp", 0, 1.5, 0, rotationAngle2);
    	}
    	if (adjecentConnections[1] != null)
    	{
    		Pipe.renderPart("PipeDown");
    		renderCrystal(Crystal, "CrystalDown", 0, 0.5, 0, rotationAngle2);
    	}
    	//Right
    	if (adjecentConnections[2] != null)
    	{
    		Pipe.renderPart("PipeRight");
    		renderCrystal(Crystal, "CrystalRight", 0, 0.5, -1, rotationAngle2);
    	}
    	//Left
    	if (adjecentConnections[3] != null)
    	{
    		Pipe.renderPart("PipeLeft");
    		renderCrystal(Crystal, "CrystalLeft", 0, -0.5, -1, rotationAngle2);
    	}
    	//Back
    	if (adjecentConnections[4] != null)
    	{
    		Pipe.renderPart("PipeBack");
    		renderCrystal(Crystal, "CrystalBack", 1, 0.5, 0, rotationAngle2);
    	}
    	//Front
    	if (adjecentConnections[5] != null)
    	{
    		Pipe.renderPart("PipeFront");
    		renderCrystal(Crystal, "CrystalFront", 1, -0.5, 0, rotationAngle2);
    	}
    	GL11.glPopMatrix();
    }

    public void renderCrystal(IModelCustom crystal, String loc, double Posx, double PosY, double PosZ, double d)
    {
    	GL11.glPushMatrix();

		if(loc == "CrystalUp" || loc == "CrystalDown")
		{	
			//GL11.glRotated(d, 0, 1, 0);
			GL11.glTranslated(Posx, PosY, PosZ);
		}
		
		if(loc == "CrystalRight" || loc == "CrystalLeft")
		{
			//GL11.glRotated(d, 0, 0, 1);
			GL11.glRotatef(90, 1, 0, 0);
			GL11.glTranslated(Posx, PosY, PosZ);
		}
		
		if(loc == "CrystalFront" || loc == "CrystalBack")
		{
			//GL11.glRotated(d, 1, 0, 0);
			GL11.glRotatef(90, 0, 0, 1);
			GL11.glTranslated(Posx, PosY, PosZ);
		}
		
		crystal.renderPart("Crystal");
		
    	GL11.glPopMatrix();
    }

    public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f) 
    {
    	renderModelAt((TileStaticManaPipe)tileentity, d, d1, d2, f);
    }
 
    
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
    	
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileStaticManaPipe(), 0.0D, 0.0D, 0.0D, 0.0F);
	}
    
    public static void renderFacingQuad(double px, double py, double pz, float angle, float scale, float alpha, int frames, int cframe, float partialTicks)
    {
      if ((Minecraft.getMinecraft().renderViewEntity instanceof EntityPlayer))
      {
        Tessellator tessellator = Tessellator.instance;
        float arX = ActiveRenderInfo.rotationX;
        float arZ = ActiveRenderInfo.rotationZ;
        float arYZ = ActiveRenderInfo.rotationYZ;
        float arXY = ActiveRenderInfo.rotationXY;
        float arXZ = ActiveRenderInfo.rotationXZ;
        
        EntityPlayer player = (EntityPlayer)Minecraft.getMinecraft().renderViewEntity;
        double iPX = player.prevPosX + (player.posX - player.prevPosX) * partialTicks;
        double iPY = player.prevPosY + (player.posY - player.prevPosY) * partialTicks;
        double iPZ = player.prevPosZ + (player.posZ - player.prevPosZ) * partialTicks;
        
        GL11.glTranslated(-iPX, -iPY, -iPZ);
        
        tessellator.startDrawingQuads();
        tessellator.setBrightness(220);
        
        Vec3 v1 = Vec3.createVectorHelper(-arX * scale - arYZ * scale, -arXZ * scale, -arZ * scale - arXY * scale);
        Vec3 v2 = Vec3.createVectorHelper(-arX * scale + arYZ * scale, arXZ * scale, -arZ * scale + arXY * scale);
        Vec3 v3 = Vec3.createVectorHelper(arX * scale + arYZ * scale, arXZ * scale, arZ * scale + arXY * scale);
        Vec3 v4 = Vec3.createVectorHelper(arX * scale - arYZ * scale, -arXZ * scale, arZ * scale - arXY * scale);
        if (angle != 0.0F)
        {
          Vec3 pvec = Vec3.createVectorHelper(iPX, iPY, iPZ);
          Vec3 tvec = Vec3.createVectorHelper(px, py, pz);
          Vec3 qvec = pvec.subtract(tvec).normalize();
          QuadHelper.setAxis(qvec, angle).rotate(v1);
          QuadHelper.setAxis(qvec, angle).rotate(v2);
          QuadHelper.setAxis(qvec, angle).rotate(v3);
          QuadHelper.setAxis(qvec, angle).rotate(v4);
        }
        float f2 = cframe / frames;
        float f3 = (cframe + 1) / frames;
        float f4 = 0.0F;
        float f5 = 1.0F;
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        tessellator.addVertexWithUV(px + v1.xCoord, py + v1.yCoord, pz + v1.zCoord, f2, f5);
        tessellator.addVertexWithUV(px + v2.xCoord, py + v2.yCoord, pz + v2.zCoord, f3, f5);
        tessellator.addVertexWithUV(px + v3.xCoord, py + v3.yCoord, pz + v3.zCoord, f3, f4);
        tessellator.addVertexWithUV(px + v4.xCoord, py + v4.yCoord, pz + v4.zCoord, f2, f4);
        
        tessellator.draw();
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
}