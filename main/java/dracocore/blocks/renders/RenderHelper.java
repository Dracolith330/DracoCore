package dracocore.blocks.renders;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;

import org.lwjgl.opengl.GL11;

public class RenderHelper
{
	public static void applyFloatingRotations()
	{
		GL11.glRotatef(-RenderManager.instance.playerViewY, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(RenderManager.instance.playerViewX, 1.0F, 0.0F, 0.0F);
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
	
	public static void renderFloatingText(float x, float y, float z, float scale, String text, int color)
	{
		FontRenderer fontRenderer = RenderManager.instance.getFontRenderer();
		GL11.glPushMatrix();
		GL11.glTranslatef(x, y, z);
		applyFloatingRotations();
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		GL11.glScalef(0.05F * scale, 0.05F * scale, 1.0F);
		fontRenderer.drawString(text, -fontRenderer.getStringWidth(text) / 2, -fontRenderer.FONT_HEIGHT / 2, color);
		GL11.glPopMatrix();
	}

	public static void renderFloatingRect(float x, float y, float z, float w, float h, Color c)
	{
		FontRenderer fontRenderer = RenderManager.instance.getFontRenderer();
		GL11.glPushMatrix();
		GL11.glTranslatef(x, y, z);
		applyFloatingRotations();
		GL11.glScalef(0.05F, 0.05F, 1.0F);

		GL11.glColor4f(c.getRed() / 256.0F, c.getGreen() / 256.0F, c.getBlue() / 256.0F, c.getAlpha() / 256.0F);
		GL11.glBindTexture(3553, 0);
		GL11.glBegin(7);
		GL11.glVertex3f(-w - 1.0F, -h - 1.0F, 0.001F);
		GL11.glVertex3f(-w - 1.0F, h, 0.001F);
		GL11.glVertex3f(w, h, 0.001F);
		GL11.glVertex3f(w, -h - 1.0F, 0.001F);
		GL11.glEnd();
		GL11.glDisable(3042);
		GL11.glPopMatrix();
	}

	public static void renderFloatingTextWithBackground(float x, float y, float z, float scale, String text, int color, Color bgColor)
	{
		FontRenderer fontRenderer = RenderManager.instance.getFontRenderer();
		GL11.glPushMatrix();
		GL11.glTranslatef(x, y, z);
		applyFloatingRotations();
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		GL11.glScalef(0.05F * scale, 0.05F * scale, 1.0F);

		int h = fontRenderer.FONT_HEIGHT / 2;
		int w = fontRenderer.getStringWidth(text) / 2;
		GL11.glEnable(3042);
		GL11.glBlendFunc(770, 771);
		GL11.glColor4f(bgColor.getRed() / 256.0F, bgColor.getGreen() / 256.0F, bgColor.getBlue() / 256.0F, bgColor.getAlpha() / 256.0F);
		GL11.glBindTexture(3553, 0);
		GL11.glBegin(7);
		GL11.glVertex3f(-w - 1, -h - 1, 0.001F);
		GL11.glVertex3f(-w - 1, h, 0.001F);
		GL11.glVertex3f(w, h, 0.001F);
		GL11.glVertex3f(w, -h - 1, 0.001F);
		GL11.glEnd();
		GL11.glDisable(3042);

		fontRenderer.drawString(text, -fontRenderer.getStringWidth(text) / 2, -fontRenderer.FONT_HEIGHT / 2, color);
		GL11.glPopMatrix();
	}

	public static class ItemRender extends RenderItem
	{
		private boolean bob;
		private boolean spread;

		public ItemRender(boolean bob, boolean spread)
		{
			this.bob = bob;
			this.spread = spread;
			setRenderManager(RenderManager.instance);
		}

		public void render(EntityItem item, float x, float y, float z, boolean showNum)
		{
			doRender(item, x, y, z, 0.0F, 0.0F);

			int number = item.getEntityItem().stackSize;
			if ((number > 0) && (showNum))
			{
				GL11.glDisable(2896);
				RenderHelper.renderFloatingTextWithBackground(x, y + (this.bob ? 0.6F : 0.4F), z, 0.4F, "" + number, Color.white.getRGB(), new Color(0.0F, 0.0F, 0.0F, 0.5F));
				GL11.glEnable(2896);
			}
		}

		public boolean shouldBob()
		{
			return this.bob;
		}

		public boolean shouldSpreadItems()
		{
			return this.spread;
		}
	}
}