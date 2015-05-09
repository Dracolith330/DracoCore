package dracocore.blocks.renders.blockrenders.mana.upgrade;
 
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;

import org.lwjgl.opengl.GL11;

import dracocore.References;
import dracocore.blocks.models.ModelMagicalPlinth;
import dracocore.blocks.models.ModelRing;
import dracocore.blocks.renders.QuadHelper;
import dracocore.blocks.renders.RenderHelper;
import dracocore.blocks.tileentity.mana.upgrade.TileEntityRunicUpgradeT1;
import dracocore.blocks.tileentity.mana.upgrade.TileEntityRunicUpgradeT2;

public class RunicUpgradeT2Render extends TileEntitySpecialRenderer {
	private RenderHelper.ItemRender resultRenderer;
	float f6 = 0f;	
	public static String element;
	private ModelMagicalPlinth aModel;
	private final RenderItem customRenderItem;
	private static final ResourceLocation RingTexture = new ResourceLocation(References.texturelocation, "textures/BlockModels/Bowl.png");
    private ModelRing Ring = new ModelRing();
    

    public RunicUpgradeT2Render() {
        aModel = new ModelMagicalPlinth();
        customRenderItem = new RenderItem()
        {
        @Override
        public boolean shouldBob()
        {
        return false;
        }
        };
        customRenderItem.setRenderManager(RenderManager.instance);
    }
    
    
    public void renderAModelAt(TileEntityRunicUpgradeT2 tileentity1, double d, double d1, double d2, float f) {
    	
    	
		this.bindTexture(new ResourceLocation(References.texturelocation, "textures/BlockModels/MagicalPlinth.png"));

		
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
        GL11.glScalef(1.0F, -1F, -1F);
        GL11.glPopMatrix();

        if (tileentity1 instanceof TileEntityRunicUpgradeT2)
        {
        	TileEntityRunicUpgradeT2 tileAltar = (TileEntityRunicUpgradeT2) tileentity1;
        	GL11.glDisable(GL11.GL_LIGHTING);
        	GL11.glPushMatrix();

        	if (tileentity1.getStackInSlot(0) != null)
        	{
        		float scaleFactor = getGhostItemScaleFactor(tileentity1.getStackInSlot(0));
        		float rotationAngle = (float) (720.0 * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL);
        		EntityItem ghostEntityItem = new EntityItem(tileentity1.getWorldObj());
        		ghostEntityItem.hoverStart = 0.0F;
        		ghostEntityItem.setEntityItemStack(tileentity1.getStackInSlot(0));
        		float displacement = 0.2F;
        		GL11.glTranslatef((float) d + 0.5F, (float) d1 + displacement + 0.8F, (float) d2 + 0.35F);
        		GL11.glRotatef(90, 1.0F, 0.0F, 0.0F);
        		customRenderItem.doRender(ghostEntityItem, 0, 0, 0, 0, 0);
        	}
        	
        	GL11.glPopMatrix();
        	GL11.glEnable(GL11.GL_CULL_FACE);
        	GL11.glEnable(GL11.GL_LIGHTING);
        	GL11.glDisable(GL11.GL_LIGHTING);
        	GL11.glPushMatrix();

        	if (tileentity1.getStackInSlot(0) != null)
        	{
        		float scaleFactor = getGhostItemScaleFactor(tileentity1.getStackInSlot(0));
        		float rotationAngle = (float) (720.0 * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL);
        		EntityItem ghostEntityItem = new EntityItem(tileentity1.getWorldObj());
        		ghostEntityItem.hoverStart = 0.0F;
        		ghostEntityItem.setEntityItemStack(tileentity1.getStackInSlot(0));
        		float displacement = 0.2F;
        		GL11.glTranslatef((float) d + 0.5F, (float) d1 + displacement - 0.2F, (float) d2 + 0.35F);
        		GL11.glRotatef(90, 1.0F, 0.0F, 0.0F);
        		customRenderItem.doRender(ghostEntityItem, 0, 0, 0, 0, 0);
        	}
        	
        	GL11.glPopMatrix();
        	GL11.glEnable(GL11.GL_CULL_FACE);
        	GL11.glEnable(GL11.GL_LIGHTING);
        	GL11.glDisable(GL11.GL_LIGHTING);
        	GL11.glPushMatrix();

        	if (tileentity1.getStackInSlot(0) != null)
        	{
        		float scaleFactor = getGhostItemScaleFactor(tileentity1.getStackInSlot(0));
        		float rotationAngle = (float) (720.0 * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL);
        		EntityItem ghostEntityItem = new EntityItem(tileentity1.getWorldObj());
        		ghostEntityItem.hoverStart = 0.0F;
        		ghostEntityItem.setEntityItemStack(tileentity1.getStackInSlot(0));
        		float displacement = 0.2F;
        		GL11.glTranslatef((float) d + 0.5F, (float) d1 + displacement + 0.2F, (float) d2 - 0F);
        		customRenderItem.doRender(ghostEntityItem, 0, 0, 0, 0, 0);
        	}
        	
        	GL11.glPopMatrix();
        	GL11.glEnable(GL11.GL_CULL_FACE);
        	GL11.glEnable(GL11.GL_LIGHTING);
        	GL11.glDisable(GL11.GL_LIGHTING);
        	GL11.glPushMatrix();

        	if (tileentity1.getStackInSlot(0) != null)
        	{
        		float scaleFactor = getGhostItemScaleFactor(tileentity1.getStackInSlot(0));
        		float rotationAngle = (float) (720.0 * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL);
        		EntityItem ghostEntityItem = new EntityItem(tileentity1.getWorldObj());
        		ghostEntityItem.hoverStart = 0.0F;
        		ghostEntityItem.setEntityItemStack(tileentity1.getStackInSlot(0));
        		float displacement = 0.2F;
        		GL11.glTranslatef((float) d + 0.5F, (float) d1 + displacement + 0.2F, (float) d2 + 1F);
        		customRenderItem.doRender(ghostEntityItem, 0, 0, 0, 0, 0);
        	}
        	
        	GL11.glPopMatrix();
        	GL11.glEnable(GL11.GL_CULL_FACE);
        	GL11.glEnable(GL11.GL_LIGHTING);
        	GL11.glPushMatrix();

        	if (tileentity1.getStackInSlot(0) != null)
        	{
        		float scaleFactor = getGhostItemScaleFactor(tileentity1.getStackInSlot(0));
        		float rotationAngle = (float) (720.0 * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL);
        		EntityItem ghostEntityItem = new EntityItem(tileentity1.getWorldObj());
        		ghostEntityItem.hoverStart = 0.0F;
        		ghostEntityItem.setEntityItemStack(tileentity1.getStackInSlot(0));
        		float displacement = 0.2F;
        		GL11.glTranslatef((float) d + 1F, (float) d1 + displacement + 0.2F, (float) d2 + 0.5F);
        		GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
        		customRenderItem.doRender(ghostEntityItem, 0, 0, 0, 0, 0);
        	}
        	
        	GL11.glPopMatrix();
        	GL11.glEnable(GL11.GL_CULL_FACE);
        	GL11.glEnable(GL11.GL_LIGHTING);
        	GL11.glPushMatrix();

        	if (tileentity1.getStackInSlot(0) != null)
        	{
        		float scaleFactor = getGhostItemScaleFactor(tileentity1.getStackInSlot(0));
        		float rotationAngle = (float) (720.0 * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL);
        		EntityItem ghostEntityItem = new EntityItem(tileentity1.getWorldObj());
        		ghostEntityItem.hoverStart = 0.0F;
        		ghostEntityItem.setEntityItemStack(tileentity1.getStackInSlot(0));
        		float displacement = 0.2F;
        		GL11.glTranslatef((float) d, (float) d1 + displacement + 0.2F, (float) d2 + 0.5F);
        		GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
        		customRenderItem.doRender(ghostEntityItem, 0, 0, 0, 0, 0);
        	}
        	
        	GL11.glPopMatrix();
        	GL11.glEnable(GL11.GL_CULL_FACE);
        	GL11.glEnable(GL11.GL_LIGHTING);

        }
}


        public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f) 
        {
        	renderAModelAt((TileEntityRunicUpgradeT2)tileentity, d, d1, d2, f);
        }
 
    
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
    	
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityRunicUpgradeT2(), 0.0D, 0.0D, 0.0D, 0.0F);
	}
    
    private float getGhostItemScaleFactor(ItemStack itemStack)
	{
		float scaleFactor = 1.0F;
		if (itemStack != null)
		{
		if (itemStack.getItem() instanceof ItemBlock)
		{
		switch (customRenderItem.getMiniBlockCount(itemStack, (byte) 1))
		{
		case 1:
		return 0.90F;
		case 2:
		return 0.90F;
		case 3:
		return 0.90F;
		case 4:
		return 0.90F;
		case 5:
		return 0.80F;
		default:
		return 0.90F;
		}
		} else
		{
		switch (customRenderItem.getMiniItemCount(itemStack, (byte) 1))
		{
		case 1:
		return 0.65F;
		case 2:
		return 0.65F;
		case 3:
		return 0.65F;
		case 4:
		return 0.65F;
		default:
		return 0.65F;
		}
		}
		}
		return scaleFactor;
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