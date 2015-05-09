package dracocore.blocks.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelOreSmasher extends ModelBase
{
  //fields
    ModelRenderer Strut1;
    ModelRenderer PistonArm;
    ModelRenderer Strut2;
    ModelRenderer Strut3;
    ModelRenderer Strut4;
    ModelRenderer Base;
    ModelRenderer Top;
    ModelRenderer PistonPlate;
  
  public ModelOreSmasher()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Strut1 = new ModelRenderer(this, 95, 19);
      Strut1.addBox(6F, -6F, -8F, 2, 6, 2);
      Strut1.setRotationPoint(0F, 18F, 0F);
      Strut1.setTextureSize(128, 64);
      Strut1.mirror = true;
      setRotation(Strut1, 0F, 0F, 0F);
      PistonArm = new ModelRenderer(this, 65, 30);
      PistonArm.addBox(-1F, -9F, -1F, 2, 3, 2);
      PistonArm.setRotationPoint(0F, 18F, 0F);
      PistonArm.setTextureSize(128, 64);
      PistonArm.mirror = true;
      setRotation(PistonArm, 0F, 0F, 0F);
      Strut2 = new ModelRenderer(this, 85, 19);
      Strut2.addBox(-8F, -6F, -8F, 2, 6, 2);
      Strut2.setRotationPoint(0F, 18F, 0F);
      Strut2.setTextureSize(128, 64);
      Strut2.mirror = true;
      setRotation(Strut2, 0F, 0F, 0F);
      Strut3 = new ModelRenderer(this, 75, 19);
      Strut3.addBox(-8F, -6F, 6F, 2, 6, 2);
      Strut3.setRotationPoint(0F, 18F, 0F);
      Strut3.setTextureSize(128, 64);
      Strut3.mirror = true;
      setRotation(Strut3, 0F, 0F, 0F);
      Strut4 = new ModelRenderer(this, 65, 19);
      Strut4.addBox(6F, -6F, 6F, 2, 6, 2);
      Strut4.setRotationPoint(0F, 18F, 0F);
      Strut4.setTextureSize(128, 64);
      Strut4.mirror = true;
      setRotation(Strut4, 0F, 0F, 0F);
      Base = new ModelRenderer(this, 0, 0);
      Base.addBox(-8F, 0F, -8F, 16, 6, 16);
      Base.setRotationPoint(0F, 18F, 0F);
      Base.setTextureSize(128, 64);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      Top = new ModelRenderer(this, 0, 26);
      Top.addBox(-8F, -10F, -8F, 16, 4, 16);
      Top.setRotationPoint(0F, 18F, 0F);
      Top.setTextureSize(128, 64);
      Top.mirror = true;
      setRotation(Top, 0F, 0F, 0F);
      PistonPlate = new ModelRenderer(this, 65, 0);
      PistonPlate.addBox(-8F, -6F, -8F, 16, 1, 16);
      PistonPlate.setRotationPoint(0F, 18F, 0F);
      PistonPlate.setTextureSize(128, 64);
      PistonPlate.mirror = true;
      setRotation(PistonPlate, 0F, 0F, 0F);
  }
  
  public void render(float f5)
  {
    Strut1.render(f5);
    PistonArm.render(f5);
    Strut2.render(f5);
    Strut3.render(f5);
    Strut4.render(f5);
    Base.render(f5);
    Top.render(f5);
    PistonPlate.render(f5);
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
