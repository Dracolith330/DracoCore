package dracocore.blocks.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWireMill extends ModelBase
{
  //fields
    ModelRenderer Base;
    ModelRenderer MillSpool;
    ModelRenderer BaseBack;
    ModelRenderer BaseArm;
    ModelRenderer BaseArm2;
  
  public ModelWireMill()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Base = new ModelRenderer(this, 0, 0);
      Base.addBox(-8F, 0F, -8F, 16, 12, 16);
      Base.setRotationPoint(0F, 12F, 0F);
      Base.setTextureSize(128, 64);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      MillSpool = new ModelRenderer(this, 0, 31);
      MillSpool.addBox(-6F, 2F, -2F, 12, 1, 1);
      MillSpool.setRotationPoint(0F, 10F, 0F);
      MillSpool.setTextureSize(128, 64);
      MillSpool.mirror = true;
      setRotation(MillSpool, -0.7853982F, 0F, 0F);
      BaseBack = new ModelRenderer(this, 0, 50);
      BaseBack.addBox(-8F, -2F, -8F, 16, 4, 4);
      BaseBack.setRotationPoint(0F, 10F, 0F);
      BaseBack.setTextureSize(128, 64);
      BaseBack.mirror = true;
      setRotation(BaseBack, 0F, 0F, 0F);
      BaseArm = new ModelRenderer(this, 0, 36);
      BaseArm.addBox(-8F, 1.4F, -4.2F, 2, 4, 6);
      BaseArm.setRotationPoint(0F, 10F, 0F);
      BaseArm.setTextureSize(128, 64);
      BaseArm.mirror = true;
      setRotation(BaseArm, -0.7853982F, 0F, 0F);
      BaseArm2 = new ModelRenderer(this, 18, 36);
      BaseArm2.addBox(6F, 1.4F, -4.2F, 2, 4, 6);
      BaseArm2.setRotationPoint(0F, 10F, 0F);
      BaseArm2.setTextureSize(128, 64);
      BaseArm2.mirror = true;
      setRotation(BaseArm2, -0.7853982F, 0F, 0F);
  }
  
  public void render(float f5)
  {
    Base.render(f5);
    MillSpool.render(f5);
    BaseBack.render(f5);
    BaseArm.render(f5);
    BaseArm.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
  }

}
