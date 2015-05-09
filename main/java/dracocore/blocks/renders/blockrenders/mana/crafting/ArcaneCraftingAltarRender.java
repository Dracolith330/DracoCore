package dracocore.blocks.renders.blockrenders.mana.crafting;
 
import net.minecraft.client.model.ModelBook;
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
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;

import org.lwjgl.opengl.GL11;

import dracocore.References;
import dracocore.blocks.models.ModelArcaneCraftingAltar;
import dracocore.blocks.models.ModelBowl;
import dracocore.blocks.models.ModelCandles;
import dracocore.blocks.renders.RenderHelper;
import dracocore.blocks.tileentity.mana.crafting.TileEntityArcaneCraftingAltar;

public class ArcaneCraftingAltarRender extends TileEntitySpecialRenderer {
	private RenderHelper.ItemRender resultRenderer;
	float f6 = 0f;	
	public static String element;
	private ModelArcaneCraftingAltar aModel;
	private final RenderItem customRenderItem;
	private static final ResourceLocation field_147540_b = new ResourceLocation("textures/entity/enchanting_table_book.png");
    private ModelBook field_147541_c = new ModelBook();
    private static final ResourceLocation CandlesTexture = new ResourceLocation(References.texturelocation, "textures/BlockModels/Candle.png");
    private ModelCandles Candles = new ModelCandles();
    private static final ResourceLocation BowlTexture = new ResourceLocation(References.texturelocation, "textures/BlockModels/Bowl.png");
    private ModelBowl Bowl = new ModelBowl();
    
    private World worldObj;
    

    public ArcaneCraftingAltarRender() {
        aModel = new ModelArcaneCraftingAltar();
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
    
    
    public void renderAModelAt(TileEntityArcaneCraftingAltar tileentity1, double d, double d1, double d2, float f) 
    {
    	
    		
            this.bindTexture(new ResourceLocation(References.texturelocation, "textures/BlockModels/ArcaneCraftingAltar.png"));
            GL11.glPushMatrix();
            GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
            GL11.glScalef(1.0F, -1F, -1F);
            aModel.render(0.0625F);
            
            GL11.glPopMatrix();

            if (tileentity1 instanceof TileEntityArcaneCraftingAltar)
            {
            	TileEntityArcaneCraftingAltar tileAltar = (TileEntityArcaneCraftingAltar) tileentity1;
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
            	float f1 = (float)tileentity1.field_145926_a + f;
                
            	GL11.glTranslatef((float) d + 0.5F, (float) d1 + displacement + 0.55F, (float) d2 + 0.5F);
            	GL11.glScalef(0.8F, 0.8F, 0.8F);
            	GL11.glRotatef(10, 0.0F, 0.5F, 5.0F);
            	
            
            } else
            {
            	GL11.glTranslatef((float) d + 0.52F, (float) d1 + displacement + 0.48F, (float) d2 + 0.46F);
            	GL11.glScalef(0.7F, 0.7F, 0.7F);
            	GL11.glRotatef(90, 3F, -0.8F, 0.8F);
            }
            GL11.glScalef(scaleFactor, scaleFactor, scaleFactor);
            customRenderItem.doRender(ghostEntityItem, 0, 0, 0, 0, 0);
            }

            
            GL11.glPopMatrix();
            GL11.glEnable(GL11.GL_CULL_FACE);
            GL11.glEnable(GL11.GL_LIGHTING);
            
            GL11.glPushMatrix();
            
            GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.8F, (float)d2 + 0.5F);
    		GL11.glScaled(0.7, 0.7, 0.7);
    		GL11.glRotatef(180, 45, 0, 0);
            
            GL11.glPopMatrix();
            
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
            this.bindTexture(field_147540_b);
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
            
            GL11.glTranslatef(0.2F, 0.1F + MathHelper.sin(f1 * 0.1F) * 0.01F, -0.7F);
            float f6 = tileentity1.field_145927_n + (tileentity1.field_145930_m - tileentity1.field_145927_n) * f;
            GL11.glEnable(GL11.GL_CULL_FACE);
            
            
            GL11.glTranslatef(1.5F, 0.0F, 1.8F);
            GL11.glRotated(100, 0, 0, 10);
            
            GL11.glPopMatrix();
            
            }
    }


        public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f) {
        renderAModelAt((TileEntityArcaneCraftingAltar)tileentity, d, d1, d2, f);
    }
 
    
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
    	
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityArcaneCraftingAltar(), 0.0D, 0.0D, 0.0D, 0.0F);
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