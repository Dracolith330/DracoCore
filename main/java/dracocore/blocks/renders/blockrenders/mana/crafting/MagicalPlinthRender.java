package dracocore.blocks.renders.blockrenders.mana.crafting;
 
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import dracocore.References;
import dracocore.blocks.models.ModelMagicalPlinth;
import dracocore.blocks.models.ModelRing;
import dracocore.blocks.renders.RenderHelper;
import dracocore.blocks.tileentity.mana.crafting.TileEntityMagicalPlinth;
import dracocore.blocks.tileentity.mana.generator.TileEntitySolarManaGenerator;

public class MagicalPlinthRender extends TileEntitySpecialRenderer {
	private RenderHelper.ItemRender resultRenderer;
	float f6 = 0f;	
	public static String element;
	private final RenderItem customRenderItem;
    public final IModelCustom MagicalPlinthModel;
    public final IModelCustom Crystal;

    public MagicalPlinthRender() 
    {
        MagicalPlinthModel = AdvancedModelLoader.loadModel(new ResourceLocation(References.texturelocation, "models/MagicalPlinth.obj"));
        Crystal = AdvancedModelLoader.loadModel(new ResourceLocation(References.texturelocation, "models/Crystal.obj"));
        
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
    
    
    public void renderAModelAt(TileEntityMagicalPlinth tileentity1, double d, double d1, double d2, float f) 
    {
    	
    		this.bindTexture(new ResourceLocation(References.texturelocation, "textures/model/MagicalPlinth.png"));
    		
            GL11.glPushMatrix();
            GL11.glTranslatef((float)d + 0.5F, (float)d1, (float)d2 + 0.5F);
            GL11.glScalef(0.7F, -1F, -0.7F);
            GL11.glRotated(180, 1, 0, 0);
            MagicalPlinthModel.renderAll();
            GL11.glPopMatrix();

            if (tileentity1 instanceof TileEntityMagicalPlinth)
            {
            	TileEntityMagicalPlinth tileAltar = (TileEntityMagicalPlinth) tileentity1;
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
            
            	if (ghostEntityItem.getEntityItem().getItem() instanceof ItemBlock)
            	{
            	
            		GL11.glTranslatef((float) d + 0.5F, (float) d1 + displacement + 0.85F, (float) d2 + 0.5F);
            		GL11.glRotatef(rotationAngle, 1.0F, 0.5F, 1.0F);
            		GL11.glScalef(0.7F, 0.7F, 0.7F);
            
            	}
            
            	else
            	{
            		GL11.glTranslatef((float) d + 0.5F, (float) d1 + displacement + 0.8F, (float) d2 + 0.5F);
            		GL11.glRotatef(rotationAngle, 0.0F, 1.0F, 0.0F);
            	}
            	
            	GL11.glScalef(scaleFactor, scaleFactor, scaleFactor);
            	customRenderItem.doRender(ghostEntityItem, 0, 0, 0, 0, 0);
            }

            GL11.glPopMatrix();
            GL11.glEnable(GL11.GL_CULL_FACE);
            GL11.glEnable(GL11.GL_LIGHTING);
            
            if (tileentity1 instanceof TileEntityMagicalPlinth)
            {
            	GL11.glPushMatrix();
                float displacement = 0.2F;
                float rotationAngle1 = (float) (720.0 * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL);
                GL11.glTranslatef((float) d + 0.5F, (float) d1 + 0.81F, (float) d2 + 0.5F);
                
                if (tileentity1.getStackInSlot(0) != null)
                {
                	GL11.glRotatef(rotationAngle1, 0F, 0.5F, 0F);
                }
                
                GL11.glScaled(1, 1, 1);
                this.bindTexture(new ResourceLocation(References.texturelocation, "textures/model/ManaPipe.png"));
                Crystal.renderAll();
                GL11.glPopMatrix();
                        
                GL11.glPushMatrix();
                float displacement1 = 0.2F;
                float rotationAngle11 = (float) (720.0 * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL);
                GL11.glTranslatef((float) d + 0.5F, (float) d1 + 0.81F, (float) d2 + 0.5F);
                        
                if (tileentity1.getStackInSlot(0) != null)
                {
                	GL11.glRotatef(rotationAngle11, 0F, 0.5F, 0F);
                }
                		
                GL11.glScaled(1.2 + MathHelper.sin(-rotationAngle1 * 0.1F) * 0.05F, 1.2 + MathHelper.sin(-rotationAngle1 * 0.1F) * 0.05F, 1.2 + MathHelper.sin(-rotationAngle1 * 0.1F) * 0.05F);
                float alpha = MathHelper.sin(Minecraft.getMinecraft().renderViewEntity.ticksExisted / 8.0F) * 0.1F + 0.5F;
                GL11.glAlphaFunc(516, 0.003921569F);
                GL11.glEnable(3042);
            	GL11.glBlendFunc(770, 1);
            	GL11.glDepthMask(false);
            	this.bindTexture(new ResourceLocation(References.texturelocation, "textures/misc/bubble.png"));
        		Crystal.renderAll();
            	GL11.glDepthMask(true);
            	GL11.glDisable(3042);
            	GL11.glAlphaFunc(516, 0.1F);
                GL11.glPopMatrix();
                       
            	GL11.glPushMatrix();
            	GL11.glAlphaFunc(516, 0.003921569F);
            	GL11.glEnable(3042);
            	GL11.glBlendFunc(770, 1);
            	GL11.glDepthMask(false);
            
            	if (tileentity1.getStackInSlot(0) != null)
                {
            		this.bindTexture(new ResourceLocation(References.texturelocation, "textures/misc/bubble.png"));
            		RenderHelper.renderFacingQuad(tileentity1.xCoord + 0.5D, tileentity1.yCoord + 1.1D, tileentity1.zCoord + 0.5D, 0.0F, 0.2F, 1, 1, 0, f);
                }
            	
            	GL11.glDepthMask(true);
            	GL11.glDisable(3042);
            	GL11.glAlphaFunc(516, 0.1F);
            	GL11.glPopMatrix();
            		
            	}
            }
    }


    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
    	
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityMagicalPlinth(), 0.0D, 0.0D, 0.0D, 0.0F);
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
			} 
			
			else
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


	@Override
	public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f) 
    {
    	renderAModelAt((TileEntityMagicalPlinth)tileentity, d, d1, d2, f);
    }
    
    
}