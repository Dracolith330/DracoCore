package dracocore.blocks.renders.blockrenders.mana.crafting;
 
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;

import org.lwjgl.opengl.GL11;

import dracocore.References;
import dracocore.blocks.models.ModelSpellCrafter;
import dracocore.blocks.renders.RenderHelper;
import dracocore.blocks.renders.RenderHelper.ItemRender;
import dracocore.blocks.tileentity.mana.crafting.TileEntitySpellCrafting;

public class SpellCraftingRender extends TileEntitySpecialRenderer {
	private RenderHelper.ItemRender resultRenderer;
	float f6 = 0f;	
	public static String element;
	private ModelSpellCrafter aModel;
	private final RenderItem customRenderItem;
	private final RenderItem customRenderItem2;
	private final RenderItem customRenderItem3;
	private final RenderItem customRenderItem4;
	private final RenderItem customRenderItem5;
	private final RenderItem customRenderItem6;
	private final RenderItem customRenderItem7;
	private final RenderItem customRenderItem8;
	private final RenderItem customRenderItem9;
	private final RenderItem customRenderItem10;
	private final RenderItem customRenderItem11;
	private final RenderItem customRenderItem12;
	private final RenderItem customRenderItem13;
	
    private World worldObj;
    

    public SpellCraftingRender() {
        aModel = new ModelSpellCrafter();
        customRenderItem = new RenderItem(){@Override public boolean shouldBob(){return false;}};
        customRenderItem2 = new RenderItem(){@Override public boolean shouldBob(){return false;}};
        customRenderItem3 = new RenderItem(){@Override public boolean shouldBob(){return false;}};
        customRenderItem4 = new RenderItem(){@Override public boolean shouldBob(){return false;}};
        customRenderItem5 = new RenderItem(){@Override public boolean shouldBob(){return false;}};
        customRenderItem6 = new RenderItem(){@Override public boolean shouldBob(){return false;}};
        customRenderItem7 = new RenderItem(){@Override public boolean shouldBob(){return false;}};
        customRenderItem8 = new RenderItem(){@Override public boolean shouldBob(){return false;}};
        customRenderItem9 = new RenderItem(){@Override public boolean shouldBob(){return false;}};
        customRenderItem10 = new RenderItem(){@Override public boolean shouldBob(){return false;}};
        customRenderItem11 = new RenderItem(){@Override public boolean shouldBob(){return false;}};
        customRenderItem12 = new RenderItem(){@Override public boolean shouldBob(){return false;}};
        customRenderItem13 = new RenderItem(){@Override public boolean shouldBob(){return false;}};
        
        customRenderItem.setRenderManager(RenderManager.instance);
        customRenderItem2.setRenderManager(RenderManager.instance);
        customRenderItem3.setRenderManager(RenderManager.instance);
        customRenderItem4.setRenderManager(RenderManager.instance);
        customRenderItem5.setRenderManager(RenderManager.instance);
        customRenderItem6.setRenderManager(RenderManager.instance);
        customRenderItem7.setRenderManager(RenderManager.instance);
        customRenderItem8.setRenderManager(RenderManager.instance);
        customRenderItem9.setRenderManager(RenderManager.instance);
        customRenderItem10.setRenderManager(RenderManager.instance);
        customRenderItem11.setRenderManager(RenderManager.instance);
        customRenderItem12.setRenderManager(RenderManager.instance);
        customRenderItem13.setRenderManager(RenderManager.instance);
        
    }
    
    
    public void renderAModelAt(TileEntitySpellCrafting tileentity1, double d, double d1, double d2, float f) 
    {
    	
    		
            this.bindTexture(new ResourceLocation(References.texturelocation, "textures/BlockModels/SpellCrafting.png"));
            GL11.glPushMatrix();
            GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
            GL11.glScalef(1.0F, -1F, -1F);
            aModel.render(0.0625F);
            GL11.glPopMatrix();
            float scaleFactor = getGhostItemScaleFactor(tileentity1.getStackInSlot(0));
        	float rotationAngle = (float) (720.0 * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL);
        	
            if (tileentity1 instanceof TileEntitySpellCrafting)
            {
            	TileEntitySpellCrafting tileAltar = (TileEntitySpellCrafting) tileentity1;
            	GL11.glDisable(GL11.GL_LIGHTING);
            	GL11.glPushMatrix();

            if (tileentity1.getStackInSlot(0) != null)
            {
            	EntityItem ghostEntityItem = new EntityItem(tileentity1.getWorldObj());
            	ghostEntityItem.hoverStart = 0.0F;
            	ghostEntityItem.setEntityItemStack(tileentity1.getStackInSlot(0));
            	float displacement = 0.2F;
            	if (ghostEntityItem.getEntityItem().getItem() instanceof ItemBlock)
            	{
            		GL11.glTranslatef((float) d + 0.5F, (float) d1 + displacement + 0.7F, (float) d2 + 0.5F);
            		GL11.glScalef(0.8F, 0.8F, 0.8F);
            		GL11.glRotatef(10, 0.0F, 0.4F, 0.0F);
            	}
            	else
            	{
            		GL11.glTranslatef((float) d + 0.52F, (float) d1 + displacement + 0.65F, (float) d2 + 0.46F);
            		GL11.glScalef(0.7F, 0.7F, 0.7F);
            		GL11.glRotatef(90, 3F, -0.8F, 0.8F);
            	}
            	GL11.glScalef(scaleFactor, scaleFactor, scaleFactor);
            	customRenderItem.doRender(ghostEntityItem, 0, 0, 0, 0, 0);
            }
            if (tileentity1.getStackInSlot(1) != null)
            {
            	EntityItem ghostEntityItem2 = new EntityItem(tileentity1.getWorldObj());
            	ghostEntityItem2.hoverStart = 0.0F;
            	ghostEntityItem2.setEntityItemStack(tileentity1.getStackInSlot(1));
            	float displacement = 0.2F;
            	if (ghostEntityItem2.getEntityItem().getItem() instanceof ItemBlock)
            	{
            		GL11.glTranslatef((float) d + 0.5F, (float) d1 + displacement + 0.7F, (float) d2 + 0.5F);
            		GL11.glScalef(0.8F, 0.8F, 0.8F);
            		GL11.glRotatef(10, 0.0F, 0.4F, 0.0F);
            	}
            	else
            	{
            		GL11.glTranslatef((float) d + 0.52F, (float) d1 + displacement + 0.65F, (float) d2 + 0.46F);
            		GL11.glScalef(0.7F, 0.7F, 0.7F);
            		GL11.glRotatef(90, 3F, -0.8F, 0.8F);
            	}
            	GL11.glScalef(scaleFactor, scaleFactor, scaleFactor);
            	customRenderItem2.doRender(ghostEntityItem2, 0, 0, 0, 0, 0);
            }
            
            GL11.glPopMatrix();
            GL11.glEnable(GL11.GL_CULL_FACE);
            GL11.glEnable(GL11.GL_LIGHTING);
            
            GL11.glPushMatrix();
            GL11.glTranslatef((float)d + 0.5F, (float)d1 + 0.8F, (float)d2 + 0.5F);
    		GL11.glScaled(0.7, 0.7, 0.7);
    		
    		float f1 = (float)tileentity1.field_145926_a + f;
            GL11.glTranslatef(0.0F, 0.1F + MathHelper.sin(f1 * 0.1F) * 0.01F, 0.0F);
            float f2;

            for (f2 = tileentity1.field_145928_o - tileentity1.field_145925_p; f2 >= (float)Math.PI; f2 -= ((float)Math.PI * 2F))
            {
                ;
            }

            while (f2 < -(float)Math.PI)
            {
                f2 += ((float)Math.PI * 2F);
            }

            float f3 = tileentity1.field_145925_p + f2 * f;
            GL11.glRotatef(-f3 * 180.0F / (float)Math.PI, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(80.0F, 0.0F, 0.0F, 1.0F);
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
            
            GL11.glPopMatrix();
            
            }
    }


        public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f) {
        renderAModelAt((TileEntitySpellCrafting)tileentity, d, d1, d2, f);
    }
 
    
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
    	
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntitySpellCrafting(), 0.0D, 0.0D, 0.0D, 0.0F);
	}
    
    private float getGhostItemScaleFactor(ItemStack itemStack)
	{
		float scaleFactor = 1.0F;
		if (itemStack != null)
		{
				if (itemStack.getItem() instanceof ItemBlock)
				{
					switch (customRenderItem.getMiniBlockCount(itemStack, (byte) 1)){case 1:return 0.90F;case 2:return 0.90F;case 3:return 0.90F;case 4:return 0.90F;case 5:return 0.80F;default:return 0.90F;}
				} 
				else
				{
					switch (customRenderItem.getMiniItemCount(itemStack, (byte) 1)){case 1:return 0.65F;case 2:return 0.65F;case 3:return 0.65F;case 4:return 0.65F;default:return 0.65F;}
				}
		}
		return scaleFactor;
	}
    
}