package dracocore.blocks.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSpellCrafter extends ModelBase
{
  //fields
    ModelRenderer Base1;
    ModelRenderer ScrollHandle1;
    ModelRenderer Base2;
    ModelRenderer Base3;
    ModelRenderer Scroll;
    ModelRenderer ScrollRoll1;
    ModelRenderer ScrollRoll2;
    ModelRenderer ScrollHandle2;
    ModelRenderer Base4;
  
  public ModelSpellCrafter()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Base1 = new ModelRenderer(this, 0, 0);
      Base1.addBox(-5F, 3F, -5F, 10, 2, 10);
      Base1.setRotationPoint(0F, 19F, 0F);
      Base1.setTextureSize(128, 64);
      Base1.mirror = true;
      setRotation(Base1, 0F, 0F, 0F);
      ScrollHandle1 = new ModelRenderer(this, 20, 24);
      ScrollHandle1.addBox(-5F, 1.1F, -4.5F, 10, 1, 1);
      ScrollHandle1.setRotationPoint(0F, 11F, 0F);
      ScrollHandle1.setTextureSize(128, 64);
      ScrollHandle1.mirror = true;
      setRotation(ScrollHandle1, 0F, 0F, 0F);
      Base2 = new ModelRenderer(this, 0, 14);
      Base2.addBox(-3.5F, 10F, -3.5F, 7, 1, 7);
      Base2.setRotationPoint(0F, 11F, 0F);
      Base2.setTextureSize(128, 64);
      Base2.mirror = true;
      setRotation(Base2, 0F, 0F, 0F);
      Base3 = new ModelRenderer(this, 20, 31);
      Base3.addBox(-3F, 1F, -3F, 6, 1, 6);
      Base3.setRotationPoint(0F, 11F, 0F);
      Base3.setTextureSize(128, 64);
      Base3.mirror = true;
      setRotation(Base3, 0F, 0F, 0F);
      Scroll = new ModelRenderer(this, 42, 0);
      Scroll.addBox(-4F, 0.5F, -4F, 8, 1, 8);
      Scroll.setRotationPoint(0F, 11F, 0F);
      Scroll.setTextureSize(128, 64);
      Scroll.mirror = true;
      setRotation(Scroll, 0F, 0F, 0F);
      ScrollRoll1 = new ModelRenderer(this, 42, 17);
      ScrollRoll1.addBox(-4F, 0.6F, -5F, 8, 2, 2);
      ScrollRoll1.setRotationPoint(0F, 11F, 0F);
      ScrollRoll1.setTextureSize(128, 64);
      ScrollRoll1.mirror = true;
      setRotation(ScrollRoll1, 0F, 0F, 0F);
      ScrollRoll2 = new ModelRenderer(this, 42, 11);
      ScrollRoll2.addBox(-4F, 0.6F, 3F, 8, 2, 2);
      ScrollRoll2.setRotationPoint(0F, 11F, 0F);
      ScrollRoll2.setTextureSize(128, 64);
      ScrollRoll2.mirror = true;
      setRotation(ScrollRoll2, 0F, 0F, 0F);
      ScrollHandle2 = new ModelRenderer(this, 20, 28);
      ScrollHandle2.addBox(-5F, 1.1F, 3.5F, 10, 1, 1);
      ScrollHandle2.setRotationPoint(0F, 11F, 0F);
      ScrollHandle2.setTextureSize(128, 64);
      ScrollHandle2.mirror = true;
      setRotation(ScrollHandle2, 0F, 0F, 0F);
      Base4 = new ModelRenderer(this, 0, 24);
      Base4.addBox(-2F, 1F, -2F, 4, 9, 4);
      Base4.setRotationPoint(0F, 11F, 0F);
      Base4.setTextureSize(128, 64);
      Base4.mirror = true;
      setRotation(Base4, 0F, 0F, 0F);
  }
  
  public void render(float f5)
  {
    Base1.render(f5);
    ScrollHandle1.render(f5);
    Base2.render(f5);
    Base3.render(f5);
    Scroll.render(f5);
    ScrollRoll1.render(f5);
    ScrollRoll2.render(f5);
    ScrollHandle2.render(f5);
    Base4.render(f5);
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
