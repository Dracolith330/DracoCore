package dracocore.blocks.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCandles extends ModelBase
{
  //fields
    ModelRenderer WhickTall;
    ModelRenderer CandleTall;
    ModelRenderer CandleMed;
    ModelRenderer CandleShort;
    ModelRenderer WhickShort;
    ModelRenderer WhickMed;
  
  public ModelCandles()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      WhickTall = new ModelRenderer(this, 14, 2);
      WhickTall.addBox(-2F, -5.5F, -8F, 1, 2, 1);
      WhickTall.setRotationPoint(0F, 25F, 0F);
      WhickTall.setTextureSize(128, 64);
      WhickTall.mirror = true;
      setRotation(WhickTall, 0F, 0F, 0F);
      CandleTall = new ModelRenderer(this, 0, 0);
      CandleTall.addBox(-3F, -5F, -9F, 3, 4, 3);
      CandleTall.setRotationPoint(0F, 25F, 0F);
      CandleTall.setTextureSize(128, 64);
      CandleTall.mirror = true;
      setRotation(CandleTall, 0F, 0F, 0F);
      CandleMed = new ModelRenderer(this, 0, 9);
      CandleMed.addBox(-0.5F, -4F, -11F, 2, 3, 2);
      CandleMed.setRotationPoint(0F, 25F, 0F);
      CandleMed.setTextureSize(128, 64);
      CandleMed.mirror = true;
      setRotation(CandleMed, 0F, 0F, 0F);
      CandleShort = new ModelRenderer(this, 0, 16);
      CandleShort.addBox(0F, -3F, -8.5F, 2, 2, 2);
      CandleShort.setRotationPoint(0F, 25F, 0F);
      CandleShort.setTextureSize(128, 64);
      CandleShort.mirror = true;
      setRotation(CandleShort, 0F, 0F, 0F);
      WhickShort = new ModelRenderer(this, 10, 15);
      WhickShort.addBox(0.5F, -3.5F, -8F, 1, 2, 1);
      WhickShort.setRotationPoint(0F, 25F, 0F);
      WhickShort.setTextureSize(128, 64);
      WhickShort.mirror = true;
      setRotation(WhickShort, 0F, 0F, 0F);
      WhickMed = new ModelRenderer(this, 10, 10);
      WhickMed.addBox(0F, -4.5F, -10.5F, 1, 2, 1);
      WhickMed.setRotationPoint(0F, 25F, 0F);
      WhickMed.setTextureSize(128, 64);
      WhickMed.mirror = true;
      setRotation(WhickMed, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    WhickTall.render(f5);
    CandleTall.render(f5);
    CandleMed.render(f5);
    CandleShort.render(f5);
    WhickShort.render(f5);
    WhickMed.render(f5);
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
