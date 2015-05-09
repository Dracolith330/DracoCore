package dracocore.blocks.renders.itemrenders.mana.crystal;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import dracocore.References;
import dracocore.blocks.models.ModelManaPipe;
import dracocore.blocks.renders.blockrenders.mana.crystal.ClusteredManaPipeRender;
import dracocore.blocks.tileentity.mana.transfer.TileClusteredManaPipe;

public class ItemClusterManaPipeRender implements IItemRenderer {

	private static final ResourceLocation ManaPipe = new ResourceLocation(References.texturelocation, "textures/model/ClusteredManaPipe.png");
    public final IModelCustom Pipe;
    
	public ItemClusterManaPipeRender() {

		Pipe = AdvancedModelLoader.loadModel(new ResourceLocation(References.texturelocation, "models/ManaPipe.obj"));
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {

		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {

		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) 
	{
		
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(ManaPipe);
    	
    	GL11.glPushMatrix();

		GL11.glScalef(3F, 3F, 3F);
    	
    	if(type == type.EQUIPPED)
    	{
    		GL11.glTranslated(0.2, -0.8, 0.2);
    		GL11.glScalef(1F, 1F, 1F);
    	}
    	if(type == type.EQUIPPED_FIRST_PERSON)
    	{
    		GL11.glTranslated(0.1, -0.8, 0.1);
    		GL11.glScalef(1F, 1F, 1F);
    	}
    	if(type == type.INVENTORY)
    	{
    		GL11.glTranslated(0.0, -1.6, 0.0);
    		GL11.glScalef(1.6F, 1.6F, 1.6F);
    	}
    	if(type == type.ENTITY)
    	{
    		GL11.glTranslated(0.0, -1.8, 0.0);
    		GL11.glScalef(2F, 2F, 2F);
    	}
    	
    	Pipe.renderPart("Center");
    	
    	GL11.glPopMatrix();
    	
	}
}