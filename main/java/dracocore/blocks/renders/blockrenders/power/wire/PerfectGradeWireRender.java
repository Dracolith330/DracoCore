package dracocore.blocks.renders.blockrenders.power.wire;
 
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import dracocore.References;
import dracocore.api.transmission.power.PowerUtil;
import dracocore.blocks.renders.QuadHelper;
import dracocore.blocks.tileentity.power.wire.TileEntityPerfectGradeWire;

public class PerfectGradeWireRender extends TileEntitySpecialRenderer 
{
    private static final ResourceLocation Wire = new ResourceLocation(References.texturelocation, "textures/model/PerfectGradeWire.png");
    public final IModelCustom WireModel;

    public PerfectGradeWireRender() {
    	
    	this.WireModel = AdvancedModelLoader.loadModel(new ResourceLocation(References.texturelocation, "models/wire.obj"));
    	
    }
    
    
    public void renderModelAt(TileEntityPerfectGradeWire tileentity, double d, double d1, double d2, float f)
    {
    	// Texture file
    	FMLClientHandler.instance().getClient().renderEngine.bindTexture(PerfectGradeWireRender.Wire);
    	GL11.glPushMatrix();
    	GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1F, (float) d2 + 0.5F);
    	GL11.glScalef(1.0F, -1F, -1F);
    	float rotationAngle2 = (float) (720.0 * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL);
        
    	TileEntity[] adjecentConnections = PowerUtil.getAdjacentPowerConnections(tileentity);
    	int metadata = tileentity.getWorldObj().getBlockMetadata(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord);
    	IModelCustom Pipe = null;
    	IModelCustom Crystal = null;
    	
    	if (metadata == 0)
    	{
    		Pipe = this.WireModel;
    	}
    	if (adjecentConnections[0] != null)
    	{
    		Pipe.renderPart("WireUp");
    	}
    	if (adjecentConnections[1] != null)
    	{
    		Pipe.renderPart("WireDown");
    	}
    	//Right
    	if (adjecentConnections[2] != null)
    	{
    		Pipe.renderPart("WireBack");
    	}
    	//Left
    	if (adjecentConnections[3] != null)
    	{
    		Pipe.renderPart("WireFront");
    	}
    	//Back
    	if (adjecentConnections[4] != null)
    	{
    		Pipe.renderPart("WireLeft");
    	}
    	//Front
    	if (adjecentConnections[5] != null)
    	{
    		Pipe.renderPart("WireRight");
    	}
    	Pipe.renderPart("Center");
    	GL11.glPopMatrix();
    }

    public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f) 
    {
    	renderModelAt((TileEntityPerfectGradeWire)tileentity, d, d1, d2, f);
    }
 
    
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
    	
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityPerfectGradeWire(), 0.0D, 0.0D, 0.0D, 0.0F);
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
}