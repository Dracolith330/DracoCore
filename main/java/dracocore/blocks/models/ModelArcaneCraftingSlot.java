package dracocore.blocks.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelArcaneCraftingSlot extends ModelBase
{
  //fields
    ModelRenderer Arm8;
    ModelRenderer Base1;
    ModelRenderer Base2;
    ModelRenderer Base3;
    ModelRenderer Base4;
    ModelRenderer Base5;
    ModelRenderer Base6;
    ModelRenderer Base7;
    ModelRenderer Base8;
    ModelRenderer Base9;
    ModelRenderer Colomn;
    ModelRenderer Arm7;
    ModelRenderer Arm6;
    ModelRenderer Arm5;
    ModelRenderer Arm4;
    ModelRenderer Arm3;
    ModelRenderer Arm2;
    ModelRenderer Arm1;
  
  public ModelArcaneCraftingSlot()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Arm8 = new ModelRenderer(this, 5, 0);
      Arm8.addBox(-2.5F, -1F, -0.5F, 1, 1, 1);
      Arm8.setRotationPoint(0F, 11F, 0F);
      Arm8.setTextureSize(128, 64);
      Arm8.mirror = true;
      setRotation(Arm8, 0F, 0F, -0.7853982F);
      Base1 = new ModelRenderer(this, 11, 33);
      Base1.addBox(2.4F, 9F, -2F, 1, 2, 4);
      Base1.setRotationPoint(0F, 11F, 0F);
      Base1.setTextureSize(128, 64);
      Base1.mirror = true;
      setRotation(Base1, 0F, -0.7853982F, 0F);
      Base2 = new ModelRenderer(this, 0, 26);
      Base2.addBox(1F, -2F, -2F, 6, 2, 4);
      Base2.setRotationPoint(0F, 19F, 0F);
      Base2.setTextureSize(128, 64);
      Base2.mirror = true;
      setRotation(Base2, 0F, 0F, 0.7853982F);
      Base3 = new ModelRenderer(this, 0, 0);
      Base3.addBox(-7F, 3F, -7F, 14, 2, 14);
      Base3.setRotationPoint(0F, 19F, 0F);
      Base3.setTextureSize(128, 64);
      Base3.mirror = true;
      setRotation(Base3, 0F, 0F, 0F);
      Base4 = new ModelRenderer(this, 0, 17);
      Base4.addBox(-2F, -2F, 1F, 4, 2, 6);
      Base4.setRotationPoint(0F, 19F, 0F);
      Base4.setTextureSize(128, 64);
      Base4.mirror = true;
      setRotation(Base4, -0.7853982F, 0F, 0F);
      Base5 = new ModelRenderer(this, 21, 17);
      Base5.addBox(-2F, -2F, -7F, 4, 2, 6);
      Base5.setRotationPoint(0F, 19F, 0F);
      Base5.setTextureSize(128, 64);
      Base5.mirror = true;
      setRotation(Base5, 0.7853982F, 0F, 0F);
      Base6 = new ModelRenderer(this, 21, 26);
      Base6.addBox(-7F, -2F, -2F, 6, 2, 4);
      Base6.setRotationPoint(0F, 19F, 0F);
      Base6.setTextureSize(128, 64);
      Base6.mirror = true;
      setRotation(Base6, 0F, 0F, -0.7853982F);
      Base7 = new ModelRenderer(this, 0, 40);
      Base7.addBox(-2F, 9F, 2.4F, 4, 2, 1);
      Base7.setRotationPoint(0F, 11F, 0F);
      Base7.setTextureSize(128, 64);
      Base7.mirror = true;
      setRotation(Base7, 0F, -0.7853982F, 0F);
      Base8 = new ModelRenderer(this, 0, 33);
      Base8.addBox(-3.4F, 9F, -2F, 1, 2, 4);
      Base8.setRotationPoint(0F, 11F, 0F);
      Base8.setTextureSize(128, 64);
      Base8.mirror = true;
      setRotation(Base8, 0F, -0.7853982F, 0F);
      Base9 = new ModelRenderer(this, 11, 40);
      Base9.addBox(-2F, 9F, -3.4F, 4, 2, 1);
      Base9.setRotationPoint(0F, 11F, 0F);
      Base9.setTextureSize(128, 64);
      Base9.mirror = true;
      setRotation(Base9, 0F, -0.7853982F, 0F);
      Colomn = new ModelRenderer(this, 57, 0);
      Colomn.addBox(-1F, 3F, -1F, 2, 6, 2);
      Colomn.setRotationPoint(0F, 11F, 0F);
      Colomn.setTextureSize(128, 64);
      Colomn.mirror = true;
      setRotation(Colomn, 0F, 0F, 0F);
      Arm7 = new ModelRenderer(this, 0, 0);
      Arm7.addBox(-0.5F, -1F, -2.5F, 1, 1, 1);
      Arm7.setRotationPoint(0F, 11F, 0F);
      Arm7.setTextureSize(128, 64);
      Arm7.mirror = true;
      setRotation(Arm7, 0.7853982F, 0F, 0F);
      Arm6 = new ModelRenderer(this, 0, 3);
      Arm6.addBox(-0.5F, -1F, 1.5F, 1, 1, 1);
      Arm6.setRotationPoint(0F, 11F, 0F);
      Arm6.setTextureSize(128, 64);
      Arm6.mirror = true;
      setRotation(Arm6, -0.7853982F, 0F, 0F);
      Arm5 = new ModelRenderer(this, 5, 3);
      Arm5.addBox(1.5F, -1F, -0.5F, 1, 1, 1);
      Arm5.setRotationPoint(0F, 11F, 0F);
      Arm5.setTextureSize(128, 64);
      Arm5.mirror = true;
      setRotation(Arm5, 0F, 0F, 0.7853982F);
      Arm4 = new ModelRenderer(this, 62, 10);
      Arm4.addBox(2.5F, -1F, -0.5F, 1, 3, 1);
      Arm4.setRotationPoint(0F, 11F, 0F);
      Arm4.setTextureSize(128, 64);
      Arm4.mirror = true;
      setRotation(Arm4, 0F, 0F, 0.7853982F);
      Arm3 = new ModelRenderer(this, 57, 10);
      Arm3.addBox(-0.5F, -1F, 2.5F, 1, 3, 1);
      Arm3.setRotationPoint(0F, 11F, 0F);
      Arm3.setTextureSize(128, 64);
      Arm3.mirror = true;
      setRotation(Arm3, -0.7853982F, 0F, 0F);
      Arm2 = new ModelRenderer(this, 62, 15);
      Arm2.addBox(-3.5F, -1F, -0.5F, 1, 3, 1);
      Arm2.setRotationPoint(0F, 11F, 0F);
      Arm2.setTextureSize(128, 64);
      Arm2.mirror = true;
      setRotation(Arm2, 0F, 0F, -0.7853982F);
      Arm1 = new ModelRenderer(this, 57, 15);
      Arm1.addBox(-0.5F, -1F, -3.5F, 1, 3, 1);
      Arm1.setRotationPoint(0F, 11F, 0F);
      Arm1.setTextureSize(128, 64);
      Arm1.mirror = true;
      setRotation(Arm1, 0.7853982F, 0F, 0F);
  }
  
  public void render(float f5)
  {
    Arm8.render(f5);
    Base1.render(f5);
    Base2.render(f5);
    Base3.render(f5);
    Base4.render(f5);
    Base5.render(f5);
    Base6.render(f5);
    Base7.render(f5);
    Base8.render(f5);
    Base9.render(f5);
    Colomn.render(f5);
    Arm7.render(f5);
    Arm6.render(f5);
    Arm5.render(f5);
    Arm4.render(f5);
    Arm3.render(f5);
    Arm2.render(f5);
    Arm1.render(f5);
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
