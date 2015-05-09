package dracocore.blocks.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import dracocore.References;
import dracocore.blocks.tileentity.mana.crafting.TileEntityMagicalPlinth;

public class ModelMagicalPlinth extends ModelBase
{
  //fields
    public ModelRenderer Base1;
    public ModelRenderer Base2;
    public ModelRenderer Base3;
    public ModelRenderer Base4;
    public ModelRenderer Base5;
    public ModelRenderer Base6;
    public ModelRenderer Ring1;
    public ModelRenderer RingArm1;
    public ModelRenderer RingArm2;
    public ModelRenderer RingArm3;
    public ModelRenderer RingArm4;
    public ModelRenderer Ring2;
    public ModelRenderer Ring3;
    public ModelRenderer Ring4;
    public ModelRenderer Ring5;
    public ModelRenderer Ring6;
    public ModelRenderer Ring7;
    public ModelRenderer Ring8;
    public ModelRenderer BaseArm1;
    public ModelRenderer BaseArm2;
    public ModelRenderer BaseArm3;
    public ModelRenderer BaseArm4;
    public ModelRenderer Test;
  
  public ModelMagicalPlinth()
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
      Ring1 = new ModelRenderer(this, 68, 30);
      Ring1.addBox(-5.3F, -2.5F, 1.36F, 1, 5, 1);
      Ring1.setRotationPoint(0F, 9F, 0F);
      Ring1.setTextureSize(64, 32);
      Ring1.mirror = true;
      setRotation(Ring1, 1.570796F, 0F, 0F);
      RingArm1 = new ModelRenderer(this, 72, 0);
      RingArm1.addBox(-5F, -2.3F, -0.5F, 2, 1, 1);
      RingArm1.setRotationPoint(0F, 9F, 0F);
      RingArm1.setTextureSize(64, 32);
      RingArm1.mirror = true;
      setRotation(RingArm1, 0F, 0F, 0F);
      RingArm2 = new ModelRenderer(this, 66, 0);
      RingArm2.addBox(-0.5F, -5F, 1.3F, 1, 2, 1);
      RingArm2.setRotationPoint(0F, 9F, 0F);
      RingArm2.setTextureSize(64, 32);
      RingArm2.mirror = true;
      setRotation(RingArm2, 1.570796F, 0F, 0F);
      RingArm3 = new ModelRenderer(this, 66, 5);
      RingArm3.addBox(3F, -2.3F, -0.5F, 2, 1, 1);
      RingArm3.setRotationPoint(0F, 9F, 0F);
      RingArm3.setTextureSize(64, 32);
      RingArm3.mirror = true;
      setRotation(RingArm3, 0F, 0F, 0F);
      RingArm4 = new ModelRenderer(this, 74, 4);
      RingArm4.addBox(-0.5F, -5F, -2.26F, 1, 2, 1);
      RingArm4.setRotationPoint(0F, 9F, 0F);
      RingArm4.setTextureSize(64, 32);
      RingArm4.mirror = true;
      setRotation(RingArm4, -1.570796F, 0F, 0F);
      Ring2 = new ModelRenderer(this, 73, 8);
      Ring2.addBox(4.5F, -2F, 1.34F, 1, 4, 1);
      Ring2.setRotationPoint(0F, 9F, 0F);
      Ring2.setTextureSize(64, 32);
      Ring2.mirror = true;
      setRotation(Ring2, 1.55F, -0.8F, 0F);
      Ring3 = new ModelRenderer(this, 66, 8);
      Ring3.addBox(-5.5F, -2F, -2.36F, 1, 4, 1);
      Ring3.setRotationPoint(0F, 9F, 0F);
      Ring3.setTextureSize(64, 32);
      Ring3.mirror = true;
      setRotation(Ring3, -1.55F, -0.8F, 0F);
      Ring4 = new ModelRenderer(this, 68, 22);
      Ring4.addBox(4.3F, -2.5F, 1.32F, 1, 5, 1);
      Ring4.setRotationPoint(0F, 9F, 0F);
      Ring4.setTextureSize(64, 32);
      Ring4.mirror = true;
      setRotation(Ring4, 1.570796F, 0F, 0F);
      Ring5 = new ModelRenderer(this, 73, 30);
      Ring5.addBox(1.36F, -2.5F, -5.3F, 1, 5, 1);
      Ring5.setRotationPoint(0F, 9F, 0F);
      Ring5.setTextureSize(64, 32);
      Ring5.mirror = true;
      setRotation(Ring5, 0F, 0F, -1.570796F);
      Ring6 = new ModelRenderer(this, 72, 15);
      Ring6.addBox(4.5F, -2.2F, -2.33F, 1, 4, 1);
      Ring6.setRotationPoint(0F, 9F, 0F);
      Ring6.setTextureSize(64, 32);
      Ring6.mirror = true;
      setRotation(Ring6, -1.57F, 0.8F, 0.0F);
      Ring7 = new ModelRenderer(this, 74, 22);
      Ring7.addBox(1.32F, -2.5F, 4.3F, 1, 5, 1);
      Ring7.setRotationPoint(0F, 9F, 0F);
      Ring7.setTextureSize(64, 32);
      Ring7.mirror = true;
      setRotation(Ring7, 0F, 0F, -1.570796F);
      Ring8 = new ModelRenderer(this, 66, 15);
      Ring8.addBox(-5.5F, -2.1F, 1.3F, 1, 4, 1);
      Ring8.setRotationPoint(0F, 9F, 0F);
      Ring8.setTextureSize(64, 32);
      Ring8.mirror = true;
      setRotation(Ring8, 1.55F, 0.8F, 0F);
      BaseArm1 = new ModelRenderer(this, 0, 60);
      BaseArm1.addBox(-4.7F, 1.7F, -0.5F, 5, 1, 1);
      BaseArm1.setRotationPoint(0F, 9F, 0F);
      BaseArm1.setTextureSize(64, 32);
      BaseArm1.mirror = true;
      setRotation(BaseArm1, 0F, 0F, 0.7853982F);
      BaseArm2 = new ModelRenderer(this, 40, 54);
      BaseArm2.addBox(-0.5F, -4.7F, -2.7F, 1, 5, 1);
      BaseArm2.setRotationPoint(0F, 9F, 0F);
      BaseArm2.setTextureSize(64, 32);
      BaseArm2.mirror = true;
      setRotation(BaseArm2, 0.7853982F, 0F, 0F);
      BaseArm3 = new ModelRenderer(this, 17, 60);
      BaseArm3.addBox(-0.2F, 1.7F, -0.5F, 5, 1, 1);
      BaseArm3.setRotationPoint(0F, 9F, 0F);
      BaseArm3.setTextureSize(64, 32);
      BaseArm3.mirror = true;
      setRotation(BaseArm3, 0F, 0F, -0.7853982F);
      BaseArm4 = new ModelRenderer(this, 34, 54);
      BaseArm4.addBox(-0.5F, -4.7F, 1.74F, 1, 5, 1);
      BaseArm4.setRotationPoint(0F, 9F, 0F);
      BaseArm4.setTextureSize(64, 32);
      BaseArm4.mirror = true;
      setRotation(BaseArm4, -0.7853982F, 0F, 0F);
  }
  
  public void render(float f5)
  {
    Base1.render(f5);
    Base2.render(f5);
    Base3.render(f5);
    Base4.render(f5);
    Base5.render(f5);
    Base6.render(f5);
    Ring1.render(f5);
    Ring2.render(f5);
    Ring3.render(f5);
    Ring4.render(f5);
    Ring5.render(f5);
    Ring6.render(f5);
    Ring7.render(f5);
    Ring8.render(f5);
    RingArm1.render(f5);
    RingArm2.render(f5);
    RingArm3.render(f5);
    RingArm4.render(f5);
    BaseArm1.render(f5);
    BaseArm2.render(f5);
    BaseArm3.render(f5);
    BaseArm4.render(f5);
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
  
  	public void renderBloodAltar(TileEntityMagicalPlinth altar, double x, double y, double z)
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
