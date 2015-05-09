package dracocore.blocks.renders.blockrenders.mana.crafting;
 
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;

import org.lwjgl.opengl.GL11;

import dracocore.References;
import dracocore.blocks.models.ModelArcaneCraftingSlot;
import dracocore.blocks.models.ModelRing;
import dracocore.blocks.renders.RenderHelper;
import dracocore.blocks.tileentity.mana.crafting.TileEntityArcaneCraftingSlot;

public class ArcaneCraftingSlotRender extends TileEntitySpecialRenderer {
	private RenderHelper.ItemRender resultRenderer;
	float f6 = 0f;	
	public static String element;
	private ModelArcaneCraftingSlot aModel;
	private final RenderItem customRenderItem;
	private static final ResourceLocation RingTexture = new ResourceLocation(References.texturelocation, "textures/BlockModels/Bowl.png");
    private ModelRing Ring = new ModelRing();
    

    public ArcaneCraftingSlotRender() {
        aModel = new ModelArcaneCraftingSlot();
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
    
    
    public void renderAModelAt(TileEntityArcaneCraftingSlot tileentity1, double d, double d1, double d2, float f) {
    	
    	
    		this.bindTexture(new ResourceLocation(References.texturelocation, "textures/BlockModels/ArcaneCraftingSlot.png"));

    		
            GL11.glPushMatrix();
            GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
            GL11.glScalef(1.0F, -1F, -1F);
            aModel.render(0.0625F);
            GL11.glPopMatrix();

            if (tileentity1 instanceof TileEntityArcaneCraftingSlot)
            {
            	TileEntityArcaneCraftingSlot tileAltar = (TileEntityArcaneCraftingSlot) tileentity1;
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
            	
            GL11.glTranslatef((float) d + 0.5F, (float) d1 + displacement + 0.61F, (float) d2 + 0.515F);
            GL11.glRotatef(90, 0.0F, 0.5F, 0.5F);
            GL11.glScalef(0.7F, 0.7F, 0.7F);
            
            } else
            {
            GL11.glTranslatef((float) d + 0.51F, (float) d1 + displacement + 0.6F, (float) d2 + 0.43F);
            GL11.glRotatef(90, 1.0F, 0.0F, 0.0F);
            }
            GL11.glScalef(scaleFactor, scaleFactor, scaleFactor);
            customRenderItem.doRender(ghostEntityItem, 0, 0, 0, 0, 0);
            }

            GL11.glPopMatrix();
            GL11.glEnable(GL11.GL_CULL_FACE);
            GL11.glEnable(GL11.GL_LIGHTING);
            
            GL11.glPushMatrix();

            float displacement = 0.2F;
            float rotationAngle1 = (float) (720.0 * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL);
            GL11.glTranslatef((float) d + 0.5F, (float) d1 + displacement + 0.17F, (float) d2 + 0.5F);
            GL11.glRotatef(rotationAngle1, 0F, 0.5F, 0F);
    		GL11.glScaled(0.3, 0.3, 0.3);
            this.bindTexture(new ResourceLocation(References.texturelocation, "textures/BlockModels/Ring.png"));
    		this.Ring.render((Entity)null, 0, 0, 0, 0, 0.0F, 0.0625F);
    		
            GL11.glPopMatrix();
            
            GL11.glPushMatrix();

            float displacement1 = 0.2F;
            float rotationAngle11 = (float) (720.0 * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL);
            GL11.glTranslatef((float) d + 0.5F, (float) d1 + displacement1 + 0.17F, (float) d2 + 0.5F);
    		GL11.glRotatef(-rotationAngle11, 0F, 0.5F, 0F);
    		GL11.glScaled(0.3, 0.3, 0.3);
            this.bindTexture(new ResourceLocation(References.texturelocation, "textures/BlockModels/Ring.png"));
    		this.Ring.render((Entity)null, 0, 0, 0, 0, 0.0F, 0.0625F);
    		
            GL11.glPopMatrix();
            
            }
    }


        public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f) 
        {
        	//aModel.renderBloodAltar((TileEntityArcaneCraftingSlot) tileentity, d, d1, d2);
        	renderAModelAt((TileEntityArcaneCraftingSlot)tileentity, d, d1, d2, f);
        }
 
    
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
    	
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityArcaneCraftingSlot(), 0.0D, 0.0D, 0.0D, 0.0F);
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
}