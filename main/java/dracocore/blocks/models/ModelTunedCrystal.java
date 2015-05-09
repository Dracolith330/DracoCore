package dracocore.blocks.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import dracocore.References;
import dracocore.blocks.tileentity.mana.crystal.TileEntityTunedCrystal;

public class ModelTunedCrystal extends ModelBase
{
  //fields
    public ModelRenderer Base1;
    public ModelRenderer Base2;
    public ModelRenderer Base3;
    public ModelRenderer Base4;
    public ModelRenderer Base5;
    public ModelRenderer Base6;
    public ModelRenderer Test;
  
  public ModelTunedCrystal()
  {
	  
	  
    textureWidth = 128;
    textureHeight = 64;
    
      Base1 = new ModelRenderer(this, 0, 0);
      Base1.addBox(-8F, 0F, -8F, 16, 4, 16);
      Base1.setRotationPoint(0F, 20F, 0F);
      Base1.setTextureSize(64, 32);
      Base1.mirror = true;
      setRotation(Base1, 0F, 0F, 0F);
      Base2 = new ModelRenderer(this, 0, 40);
      Base2.addBox(-2F, -3.3F, -2F, 12, 4, 4);
      Base2.setRotationPoint(0F, 13F, 0F);
      Base2.setTextureSize(64, 32);
      Base2.mirror = true;
      setRotation(Base2, 0F, 0F, 1.047198F);
      Base3 = new ModelRenderer(this, 0, 22);
      Base3.addBox(-2F, -3.3F, -10F, 4, 4, 12);
      Base3.setRotationPoint(0F, 13F, 0F);
      Base3.setTextureSize(64, 32);
      Base3.mirror = true;
      setRotation(Base3, 1.047198F, 0F, 0F);
      Base4 = new ModelRenderer(this, 0, 50);
      Base4.addBox(-10F, -3.3F, -2F, 12, 4, 4);
      Base4.setRotationPoint(0F, 13F, 0F);
      Base4.setTextureSize(64, 32);
      Base4.mirror = true;
      setRotation(Base4, 0F, 0F, -1.047198F);
      Base5 = new ModelRenderer(this, 34, 22);
      Base5.addBox(-2F, -3.3F, -2F, 4, 4, 12);
      Base5.setRotationPoint(0F, 13F, 0F);
      Base5.setTextureSize(64, 32);
      Base5.mirror = true;
      setRotation(Base5, -1.047198F, 0F, 0F);
      Base6 = new ModelRenderer(this, 34, 40);
      Base6.addBox(-4F, 0F, -4F, 8, 4, 8);
      Base6.setRotationPoint(0F, 16.2F, 0F);
      Base6.setTextureSize(64, 32);
      Base6.mirror = true;
      setRotation(Base6, 0F, -0.7853982F, 0F);
  }
  
  public void render(float f5)
  {
    Base1.render(f5);
    Base2.render(f5);
    Base3.render(f5);
    Base4.render(f5);
    Base5.render(f5);
    Base6.render(f5);
  }
  
  public void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f5)
  {
  }
  
  public void renderBloodAltar()
  {
	  //modeltest.renderAll();
  }
  
  	public void renderBloodAltar(TileEntityTunedCrystal altar, double x, double y, double z)
  	{
  		float scale = 0.1f;
  		// Push a blank matrix onto the stack
  		GL11.glPushMatrix();
  		// Move the object into the correct position on the block (because the OBJ's origin is the center of the object)
  		GL11.glTranslatef((float) x + 0.5f, (float) y, (float) z + 0.5f);
  		// Scale our object to about half-size in all directions (the OBJ file is a little large)
  		GL11.glScalef(scale, scale, scale);
  		// Bind the texture, so that OpenGL properly textures our block.
  		//FMLClientHandler.instance().getClient().renderEngine.bindTexture("/mods/alchemicalwizardry/textures/models/altar.png");
  		// Render the object, using modelTutBox.renderAll();
  		this.renderBloodAltar();
  		// Pop this matrix from the stack.
  		GL11.glPopMatrix();
  	}
}
