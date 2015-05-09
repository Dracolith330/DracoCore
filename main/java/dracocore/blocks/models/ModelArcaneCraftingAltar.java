package dracocore.blocks.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelArcaneCraftingAltar extends ModelBase
{
  //fields
    ModelRenderer Base1;
    ModelRenderer Base2;
    ModelRenderer Base3;
    ModelRenderer Base4;
    ModelRenderer Base5;
    ModelRenderer Base6;
    ModelRenderer Base7;
    ModelRenderer Base8;
    ModelRenderer Base9;
    ModelRenderer Colomn1;
    ModelRenderer Colomn2;
    ModelRenderer Colomn3;
    ModelRenderer Colomn4;
    ModelRenderer Colomn5;
    ModelRenderer Colomn6;
    ModelRenderer Colomn7;
    ModelRenderer Arm1;
    ModelRenderer Colomn8;
    ModelRenderer Colomn9;
    ModelRenderer Arm2;
    ModelRenderer Arm3;
    ModelRenderer Arm4;
  
  public ModelArcaneCraftingAltar()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Base1 = new ModelRenderer(this, 11, 33);
      Base1.addBox(1.4F, 9F, -1F, 1, 2, 2);
      Base1.setRotationPoint(0F, 11F, 0F);
      Base1.setTextureSize(64, 32);
      Base1.mirror = true;
      setRotation(Base1, 0F, -0.7853982F, 0F);
      Base2 = new ModelRenderer(this, 0, 26);
      Base2.addBox(0F, -1F, -1F, 5, 1, 2);
      Base2.setRotationPoint(0F, 19F, 0F);
      Base2.setTextureSize(64, 32);
      Base2.mirror = true;
      setRotation(Base2, 0F, 0F, 0.7853982F);
      Base3 = new ModelRenderer(this, 0, 0);
      Base3.addBox(-5F, 3F, -5F, 10, 2, 10);
      Base3.setRotationPoint(0F, 19F, 0F);
      Base3.setTextureSize(64, 32);
      Base3.mirror = true;
      setRotation(Base3, 0F, 0F, 0F);
      Base4 = new ModelRenderer(this, 0, 17);
      Base4.addBox(-1F, -1F, 0F, 2, 1, 5);
      Base4.setRotationPoint(0F, 19F, 0F);
      Base4.setTextureSize(64, 32);
      Base4.mirror = true;
      setRotation(Base4, -0.7853982F, 0F, 0F);
      Base5 = new ModelRenderer(this, 21, 17);
      Base5.addBox(-1F, -1F, -5F, 2, 1, 5);
      Base5.setRotationPoint(0F, 19F, 0F);
      Base5.setTextureSize(64, 32);
      Base5.mirror = true;
      setRotation(Base5, 0.7853982F, 0F, 0F);
      Base6 = new ModelRenderer(this, 21, 26);
      Base6.addBox(-5F, -1F, -1F, 5, 1, 2);
      Base6.setRotationPoint(0F, 19F, 0F);
      Base6.setTextureSize(64, 32);
      Base6.mirror = true;
      setRotation(Base6, 0F, 0F, -0.7853982F);
      Base7 = new ModelRenderer(this, 0, 40);
      Base7.addBox(-1F, 9F, 1.4F, 2, 2, 1);
      Base7.setRotationPoint(0F, 11F, 0F);
      Base7.setTextureSize(64, 32);
      Base7.mirror = true;
      setRotation(Base7, 0F, -0.7853982F, 0F);
      Base8 = new ModelRenderer(this, 0, 33);
      Base8.addBox(-2.4F, 9F, -1F, 1, 2, 2);
      Base8.setRotationPoint(0F, 11F, 0F);
      Base8.setTextureSize(64, 32);
      Base8.mirror = true;
      setRotation(Base8, 0F, -0.7853982F, 0F);
      Base9 = new ModelRenderer(this, 11, 40);
      Base9.addBox(-1F, 9F, -2.4F, 2, 2, 1);
      Base9.setRotationPoint(0F, 11F, 0F);
      Base9.setTextureSize(64, 32);
      Base9.mirror = true;
      setRotation(Base9, 0F, -0.7853982F, 0F);
      Colomn1 = new ModelRenderer(this, 57, 12);
      Colomn1.addBox(-1F, 3F, -1F, 2, 5, 2);
      Colomn1.setRotationPoint(0F, 11F, 0F);
      Colomn1.setTextureSize(64, 32);
      Colomn1.mirror = true;
      setRotation(Colomn1, 0F, 0F, 0F);
      Colomn2 = new ModelRenderer(this, 65, 0);
      Colomn2.addBox(-3.2F, 1F, -1F, 1, 1, 2);
      Colomn2.setRotationPoint(0F, 11F, 0F);
      Colomn2.setTextureSize(64, 32);
      Colomn2.mirror = true;
      setRotation(Colomn2, 0F, 0F, -0.7853982F);
      Colomn3 = new ModelRenderer(this, 72, 0);
      Colomn3.addBox(-1F, 2.2F, -2F, 2, 1, 1);
      Colomn3.setRotationPoint(0F, 11F, 0F);
      Colomn3.setTextureSize(64, 32);
      Colomn3.mirror = true;
      setRotation(Colomn3, 0.7853982F, 0F, 0F);
      Colomn4 = new ModelRenderer(this, 57, 22);
      Colomn4.addBox(-1F, 3F, 0.5F, 2, 8, 1);
      Colomn4.setRotationPoint(0F, 11F, 0F);
      Colomn4.setTextureSize(64, 32);
      Colomn4.mirror = true;
      setRotation(Colomn4, 0F, 0F, 0F);
      Colomn5 = new ModelRenderer(this, 65, 5);
      Colomn5.addBox(-2F, 2.2F, -1F, 1, 1, 2);
      Colomn5.setRotationPoint(0F, 11F, 0F);
      Colomn5.setTextureSize(64, 32);
      Colomn5.mirror = true;
      setRotation(Colomn5, 0F, 0F, -0.7853982F);
      Colomn6 = new ModelRenderer(this, 72, 5);
      Colomn6.addBox(-1F, 1F, -3.2F, 2, 1, 1);
      Colomn6.setRotationPoint(0F, 11F, 0F);
      Colomn6.setTextureSize(64, 32);
      Colomn6.mirror = true;
      setRotation(Colomn6, 0.7853982F, 0F, 0F);
      Colomn7 = new ModelRenderer(this, 65, 22);
      Colomn7.addBox(0.5F, 3F, -1F, 1, 8, 2);
      Colomn7.setRotationPoint(0F, 11F, 0F);
      Colomn7.setTextureSize(64, 32);
      Colomn7.mirror = true;
      setRotation(Colomn7, 0F, 0F, 0F);
      Arm1 = new ModelRenderer(this, 82, 0);
      Arm1.addBox(-0.5F, 2.5F, -0.5F, 2, 1, 1);
      Arm1.setRotationPoint(0F, 11F, 0F);
      Arm1.setTextureSize(64, 32);
      Arm1.mirror = true;
      setRotation(Arm1, 0F, 0F, 0.7853982F);
      Colomn8 = new ModelRenderer(this, 57, 34);
      Colomn8.addBox(-1.5F, 3F, -1F, 1, 8, 2);
      Colomn8.setRotationPoint(0F, 11F, 0F);
      Colomn8.setTextureSize(64, 32);
      Colomn8.mirror = true;
      setRotation(Colomn8, 0F, 0F, 0F);
      Colomn9 = new ModelRenderer(this, 65, 34);
      Colomn9.addBox(-1F, 3F, -1.6F, 2, 8, 1);
      Colomn9.setRotationPoint(0F, 11F, 0F);
      Colomn9.setTextureSize(64, 32);
      Colomn9.mirror = true;
      setRotation(Colomn9, 0F, 0F, 0F);
      Arm2 = new ModelRenderer(this, 90, 0);
      Arm2.addBox(-0.5F, 2.5F, -0.6F, 1, 1, 2);
      Arm2.setRotationPoint(0F, 11F, 0F);
      Arm2.setTextureSize(64, 32);
      Arm2.mirror = true;
      setRotation(Arm2, -0.7853982F, 0F, 0F);
      Arm3 = new ModelRenderer(this, 82, 4);
      Arm3.addBox(-0.5F, 2.5F, -1.5F, 1, 1, 2);
      Arm3.setRotationPoint(0F, 11F, 0F);
      Arm3.setTextureSize(64, 32);
      Arm3.mirror = true;
      setRotation(Arm3, 0.7853982F, 0F, 0F);
      Arm4 = new ModelRenderer(this, 90, 5);
      Arm4.addBox(-1.5F, 2.5F, -0.5F, 2, 1, 1);
      Arm4.setRotationPoint(0F, 11F, 0F);
      Arm4.setTextureSize(64, 32);
      Arm4.mirror = true;
      setRotation(Arm4, 0F, 0F, -0.7853982F);
  }
  
  public void render(float f5)
  {
    Base1.render(f5);
    Base2.render(f5);
    Base3.render(f5);
    Base4.render(f5);
    Base5.render(f5);
    Base6.render(f5);
    Base7.render(f5);
    Base8.render(f5);
    Base9.render(f5);
    Colomn1.render(f5);
    Colomn2.render(f5);
    Colomn3.render(f5);
    Colomn4.render(f5);
    Colomn5.render(f5);
    Colomn6.render(f5);
    Colomn7.render(f5);
    Arm1.render(f5);
    Colomn8.render(f5);
    Colomn9.render(f5);
    Arm2.render(f5);
    Arm3.render(f5);
    Arm4.render(f5);
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
