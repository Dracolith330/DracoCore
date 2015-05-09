package dracocore.blocks.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRing extends ModelBase
{
  //fields
    ModelRenderer Ring1;
    ModelRenderer Ring2;
    ModelRenderer Ring3;
    ModelRenderer Ring4;
    ModelRenderer Ring5;
    ModelRenderer Ring6;
    ModelRenderer Ring7;
    ModelRenderer Ring8;
  
  public ModelRing()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Ring1 = new ModelRenderer(this, 0, 0);
      Ring1.addBox(-3F, -0.5F, -8.4F, 6, 1, 1);
      Ring1.setRotationPoint(0F, 23F, 0F);
      Ring1.setTextureSize(64, 32);
      Ring1.mirror = true;
      setRotation(Ring1, 0F, -0.7853982F, 0F);
      Ring2 = new ModelRenderer(this, 19, 0);
      Ring2.addBox(7.4F, -0.5F, -3F, 1, 1, 6);
      Ring2.setRotationPoint(0F, 23F, 0F);
      Ring2.setTextureSize(64, 32);
      Ring2.mirror = true;
      setRotation(Ring2, 0F, -0.7853982F, 0F);
      Ring3 = new ModelRenderer(this, 0, 10);
      Ring3.addBox(-8.4F, -0.5F, -3F, 1, 1, 6);
      Ring3.setRotationPoint(0F, 23F, 0F);
      Ring3.setTextureSize(64, 32);
      Ring3.mirror = true;
      setRotation(Ring3, 0F, -0.7853982F, 0F);
      Ring4 = new ModelRenderer(this, 19, 10);
      Ring4.addBox(-3F, -0.5F, 7.4F, 6, 1, 1);
      Ring4.setRotationPoint(0F, 23F, 0F);
      Ring4.setTextureSize(64, 32);
      Ring4.mirror = true;
      setRotation(Ring4, 0F, -0.7853982F, 0F);
      Ring5 = new ModelRenderer(this, 34, 0);
      Ring5.addBox(-4F, -0.5F, -8F, 8, 1, 1);
      Ring5.setRotationPoint(0F, 23F, 0F);
      Ring5.setTextureSize(64, 32);
      Ring5.mirror = true;
      setRotation(Ring5, 0F, 0F, 0F);
      Ring6 = new ModelRenderer(this, 38, 3);
      Ring6.addBox(-8F, -0.5F, -4F, 1, 1, 8);
      Ring6.setRotationPoint(0F, 23F, 0F);
      Ring6.setTextureSize(64, 32);
      Ring6.mirror = true;
      setRotation(Ring6, 0F, 0F, 0F);
      Ring7 = new ModelRenderer(this, 0, 20);
      Ring7.addBox(-4F, -0.5F, 7F, 8, 1, 1);
      Ring7.setRotationPoint(0F, 23F, 0F);
      Ring7.setTextureSize(64, 32);
      Ring7.mirror = true;
      setRotation(Ring7, 0F, 0F, 0F);
      Ring8 = new ModelRenderer(this, 22, 15);
      Ring8.addBox(7F, -0.5F, -4F, 1, 1, 8);
      Ring8.setRotationPoint(0F, 23F, 0F);
      Ring8.setTextureSize(64, 32);
      Ring8.mirror = true;
      setRotation(Ring8, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Ring1.render(f5);
    Ring2.render(f5);
    Ring3.render(f5);
    Ring4.render(f5);
    Ring5.render(f5);
    Ring6.render(f5);
    Ring7.render(f5);
    Ring8.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
  }

}
