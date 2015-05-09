package dracocore.blocks.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRitualAltar extends ModelBase
{
  //fields
    ModelRenderer Base1;
    ModelRenderer Base2;
    ModelRenderer Colomn;
    ModelRenderer Base3;
    ModelRenderer Base4;
    ModelRenderer Base5;
    ModelRenderer Top1;
    ModelRenderer Top2;
    ModelRenderer Top3;
    ModelRenderer Top4;
    ModelRenderer Base6;
  
  public ModelRitualAltar()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Base1 = new ModelRenderer(this, 0, 0);
      Base1.addBox(-6F, 0F, -6F, 12, 2, 12);
      Base1.setRotationPoint(0F, 22F, 0F);
      Base1.setTextureSize(128, 64);
      Base1.mirror = true;
      setRotation(Base1, 0F, 0F, 0F);
      Base2 = new ModelRenderer(this, 0, 16);
      Base2.addBox(-5F, -1F, -5F, 10, 1, 10);
      Base2.setRotationPoint(0F, 22F, 0F);
      Base2.setTextureSize(128, 64);
      Base2.mirror = true;
      setRotation(Base2, 0F, 0F, 0F);
      Colomn = new ModelRenderer(this, 50, 0);
      Colomn.addBox(-2F, -11F, -2F, 4, 10, 4);
      Colomn.setRotationPoint(0F, 22F, 0F);
      Colomn.setTextureSize(128, 64);
      Colomn.mirror = true;
      setRotation(Colomn, 0F, 0F, 0F);
      Base3 = new ModelRenderer(this, 0, 29);
      Base3.addBox(-1F, -4F, -2F, 4, 3, 4);
      Base3.setRotationPoint(0F, 22F, 0F);
      Base3.setTextureSize(128, 64);
      Base3.mirror = true;
      setRotation(Base3, 0F, 0F, 0.7853982F);
      Base4 = new ModelRenderer(this, 0, 38);
      Base4.addBox(-2F, -4F, -3F, 4, 3, 4);
      Base4.setRotationPoint(0F, 22F, 0F);
      Base4.setTextureSize(128, 64);
      Base4.mirror = true;
      setRotation(Base4, 0.7853982F, 0F, 0F);
      Base5 = new ModelRenderer(this, 18, 29);
      Base5.addBox(-3F, -4F, -2F, 4, 3, 4);
      Base5.setRotationPoint(0F, 22F, 0F);
      Base5.setTextureSize(128, 64);
      Base5.mirror = true;
      setRotation(Base5, 0F, 0F, -0.7853982F);
      Top1 = new ModelRenderer(this, 41, 16);
      Top1.addBox(3.3F, -9.2F, -2F, 3, 3, 4);
      Top1.setRotationPoint(0F, 22F, 0F);
      Top1.setTextureSize(128, 64);
      Top1.mirror = true;
      setRotation(Top1, 0F, 0F, -0.7853982F);
      Top2 = new ModelRenderer(this, 41, 24);
      Top2.addBox(-6.3F, -9.2F, -2F, 3, 3, 4);
      Top2.setRotationPoint(0F, 22F, 0F);
      Top2.setTextureSize(128, 64);
      Top2.mirror = true;
      setRotation(Top2, 0F, 0F, 0.7853982F);
      Top3 = new ModelRenderer(this, 56, 16);
      Top3.addBox(-2F, -9.2F, -6.3F, 4, 3, 3);
      Top3.setRotationPoint(0F, 22F, 0F);
      Top3.setTextureSize(128, 64);
      Top3.mirror = true;
      setRotation(Top3, -0.7853982F, 0F, 0F);
      Top4 = new ModelRenderer(this, 56, 24);
      Top4.addBox(-2F, -9.2F, 3.3F, 4, 3, 3);
      Top4.setRotationPoint(0F, 22F, 0F);
      Top4.setTextureSize(128, 64);
      Top4.mirror = true;
      setRotation(Top4, 0.7853982F, 0F, 0F);
      Base6 = new ModelRenderer(this, 18, 38);
      Base6.addBox(-2F, -4F, -1F, 4, 3, 4);
      Base6.setRotationPoint(0F, 22F, 0F);
      Base6.setTextureSize(128, 64);
      Base6.mirror = true;
      setRotation(Base6, -0.7853982F, 0F, 0F);
  }
  
  public void render(float f5)
  {
    Base1.render(f5);
    Base2.render(f5);
    Colomn.render(f5);
    Base3.render(f5);
    Base4.render(f5);
    Base5.render(f5);
    Top1.render(f5);
    Top2.render(f5);
    Top3.render(f5);
    Top4.render(f5);
    Base6.render(f5);
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
