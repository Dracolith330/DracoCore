package dracocore.blocks.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAcidBath extends ModelBase
{
  //fields
    ModelRenderer Wall1;
    ModelRenderer Ore_Grate;
    ModelRenderer Wall2;
    ModelRenderer Wall3;
    ModelRenderer Wall4;
    ModelRenderer Bottom;
    ModelRenderer Acid;
  
  public ModelAcidBath()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Wall1 = new ModelRenderer(this, 95, 0);
      Wall1.addBox(7F, -14F, -7F, 1, 14, 14);
      Wall1.setRotationPoint(0F, 23F, 0F);
      Wall1.setTextureSize(128, 64);
      Wall1.mirror = true;
      setRotation(Wall1, 0F, 0F, 0F);
      Ore_Grate = new ModelRenderer(this, 0, 50);
      Ore_Grate.addBox(-7F, -13F, -7F, 14, 0, 14);
      Ore_Grate.setRotationPoint(0F, 23F, 0F);
      Ore_Grate.setTextureSize(128, 64);
      Ore_Grate.mirror = true;
      setRotation(Ore_Grate, 0F, 0F, 0F);
      Wall2 = new ModelRenderer(this, 0, 31);
      Wall2.addBox(-8F, -14F, -8F, 16, 14, 1);
      Wall2.setRotationPoint(0F, 23F, 0F);
      Wall2.setTextureSize(128, 64);
      Wall2.mirror = true;
      setRotation(Wall2, 0F, 0F, 0F);
      Wall3 = new ModelRenderer(this, 59, 0);
      Wall3.addBox(-8F, -14F, 7F, 16, 14, 1);
      Wall3.setRotationPoint(0F, 23F, 0F);
      Wall3.setTextureSize(128, 64);
      Wall3.mirror = true;
      setRotation(Wall3, 0F, 0F, 0F);
      Wall4 = new ModelRenderer(this, 95, 30);
      Wall4.addBox(-8F, -14F, -7F, 1, 14, 14);
      Wall4.setRotationPoint(0F, 23F, 0F);
      Wall4.setTextureSize(128, 64);
      Wall4.mirror = true;
      setRotation(Wall4, 0F, 0F, 0F);
      Bottom = new ModelRenderer(this, 30, 32);
      Bottom.addBox(-8F, 0F, -8F, 16, 1, 16);
      Bottom.setRotationPoint(0F, 23F, 0F);
      Bottom.setTextureSize(128, 64);
      Bottom.mirror = true;
      setRotation(Bottom, 0F, 0F, 0F);
      Acid = new ModelRenderer(this, 0, 0);
      Acid.addBox(-7F, -11F, -7F, 14, 11, 14);
      Acid.setRotationPoint(0F, 23F, 0F);
      Acid.setTextureSize(128, 64);
      Acid.mirror = true;
      setRotation(Acid, 0F, 0F, 0F);
  }
  
  public void render(float f5)
  {
    Wall1.render(f5);
    Ore_Grate.render(f5);
    Wall2.render(f5);
    Wall3.render(f5);
    Wall4.render(f5);
    Bottom.render(f5);
    Acid.render(f5);
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
