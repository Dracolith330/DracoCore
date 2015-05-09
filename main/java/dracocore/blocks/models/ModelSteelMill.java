package dracocore.blocks.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSteelMill extends ModelBase
{
  //fields
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Grate;
    ModelRenderer Leg4;
    ModelRenderer PitLog1;
    ModelRenderer Brim1;
    ModelRenderer Brim2;
    ModelRenderer Brim3;
    ModelRenderer Brim4;
    ModelRenderer PitLog2;
    ModelRenderer PitLog3;
    ModelRenderer PitLog4;
  
  public ModelSteelMill()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Leg1 = new ModelRenderer(this, 0, 18);
      Leg1.addBox(-8F, -7F, -8F, 2, 8, 2);
      Leg1.setRotationPoint(0F, 23F, 0F);
      Leg1.setTextureSize(128, 64);
      Leg1.mirror = true;
      setRotation(Leg1, 0F, 0F, 0F);
      Leg2 = new ModelRenderer(this, 0, 18);
      Leg2.addBox(-8F, -7F, 6F, 2, 8, 2);
      Leg2.setRotationPoint(0F, 23F, 0F);
      Leg2.setTextureSize(128, 64);
      Leg2.mirror = true;
      setRotation(Leg2, 0F, 0F, 0F);
      Leg3 = new ModelRenderer(this, 0, 18);
      Leg3.addBox(6F, -7F, 6F, 2, 8, 2);
      Leg3.setRotationPoint(0F, 23F, 0F);
      Leg3.setTextureSize(128, 64);
      Leg3.mirror = true;
      setRotation(Leg3, 0F, 0F, 0F);
      Grate = new ModelRenderer(this, 0, 0);
      Grate.addBox(-6F, -7F, -6F, 12, 0, 12);
      Grate.setRotationPoint(0F, 23F, 0F);
      Grate.setTextureSize(128, 64);
      Grate.mirror = true;
      setRotation(Grate, 0F, 0F, 0F);
      Leg4 = new ModelRenderer(this, 0, 18);
      Leg4.addBox(6F, -7F, -8F, 2, 8, 2);
      Leg4.setRotationPoint(0F, 23F, 0F);
      Leg4.setTextureSize(128, 64);
      Leg4.mirror = true;
      setRotation(Leg4, 0F, 0F, 0F);
      PitLog1 = new ModelRenderer(this, 12, 25);
      PitLog1.addBox(-4F, 0F, -1F, 8, 1, 2);
      PitLog1.setRotationPoint(0F, 23F, 0F);
      PitLog1.setTextureSize(128, 64);
      PitLog1.mirror = true;
      setRotation(PitLog1, 0F, 0.7853982F, 0F);
      Brim1 = new ModelRenderer(this, 67, 22);
      Brim1.addBox(-8F, -8F, -8F, 2, 1, 16);
      Brim1.setRotationPoint(0F, 23F, 0F);
      Brim1.setTextureSize(128, 64);
      Brim1.mirror = true;
      setRotation(Brim1, 0F, 0F, 0F);
      Brim2 = new ModelRenderer(this, 15, 20);
      Brim2.addBox(-6F, -8F, -8F, 12, 1, 2);
      Brim2.setRotationPoint(0F, 23F, 0F);
      Brim2.setTextureSize(128, 64);
      Brim2.mirror = true;
      setRotation(Brim2, 0F, 0F, 0F);
      Brim3 = new ModelRenderer(this, 15, 15);
      Brim3.addBox(-6F, -8F, 6F, 12, 1, 2);
      Brim3.setRotationPoint(0F, 23F, 0F);
      Brim3.setTextureSize(128, 64);
      Brim3.mirror = true;
      setRotation(Brim3, 0F, 0F, 0F);
      Brim4 = new ModelRenderer(this, 67, 2);
      Brim4.addBox(6F, -8F, -8F, 2, 1, 16);
      Brim4.setRotationPoint(0F, 23F, 0F);
      Brim4.setTextureSize(128, 64);
      Brim4.mirror = true;
      setRotation(Brim4, 0F, 0F, 0F);
      PitLog2 = new ModelRenderer(this, 0, 30);
      PitLog2.addBox(-1F, 0F, -4F, 2, 1, 8);
      PitLog2.setRotationPoint(0F, 23F, 0F);
      PitLog2.setTextureSize(128, 64);
      PitLog2.mirror = true;
      setRotation(PitLog2, 0F, 0F, 0F);
      PitLog3 = new ModelRenderer(this, 0, 43);
      PitLog3.addBox(-4F, 0F, -1F, 8, 1, 2);
      PitLog3.setRotationPoint(0F, 23F, 0F);
      PitLog3.setTextureSize(128, 64);
      PitLog3.mirror = true;
      setRotation(PitLog3, 0F, 0F, 0F);
      PitLog4 = new ModelRenderer(this, 0, 49);
      PitLog4.addBox(-4F, 0F, -1F, 8, 1, 2);
      PitLog4.setRotationPoint(0F, 23F, 0F);
      PitLog4.setTextureSize(128, 64);
      PitLog4.mirror = true;
      setRotation(PitLog4, 0F, -0.7853982F, 0F);
  }
  
  public void render(float f5)
  {
    Leg1.render(f5);
    Leg2.render(f5);
    Leg3.render(f5);
    Grate.render(f5);
    Leg4.render(f5);
    PitLog1.render(f5);
    Brim1.render(f5);
    Brim2.render(f5);
    Brim3.render(f5);
    Brim4.render(f5);
    PitLog2.render(f5);
    PitLog3.render(f5);
    PitLog4.render(f5);
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
