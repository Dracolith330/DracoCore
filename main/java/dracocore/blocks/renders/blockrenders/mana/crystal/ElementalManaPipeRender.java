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
import dracocore.blocks.tileentity.mana.transfer.TileElementalManaPipe;

public class ElementalManaPipeRender extends TileEntitySpecialRenderer 
{
    private static final ResourceLocation ManaPipe = new ResourceLocation(References.texturelocation, "textures/model/ElementalManaPipe.png");
    public final IModelCustom Pipe;
    public final IModelCustom Crystal;

    public ElementalManaPipeRender() 
    {
    	this.Pipe = AdvancedModelLoader.loadModel(new ResourceLocation(References.texturelocation, "models/ManaPipe.obj"));
    	this.Crystal = AdvancedModelLoader.loadModel(new ResourceLocation(References.texturelocation, "models/Crystal.obj"));
    }
    
    
    public void renderModelAt(TileElementalManaPipe tileEntity, double d, double d1, double d2, float f)
    {
    	FMLClientHandler.instance().getClient().renderEngine.bindTexture(ElementalManaPipeRender.ManaPipe);
    	
    	GL11.glPushMatrix();
    	GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);
    	GL11.glScalef(1.0F, -1F, -1F);
    	Pipe.renderPart("Center");
    	
    	float rotationAngle2 = (float) (720.0 * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL);
        
    	TileEntity[] adjecentConnections = ManaUtil.getAdjacentPowerConnections(tileEntity);
    	
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
    	renderModelAt((TileElementalManaPipe)tileentity, d, d1, d2, f);
    }
    
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) 
    {
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileElementalManaPipe(), 0.0D, 0.0D, 0.0D, 0.0F);
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