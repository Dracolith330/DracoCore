package dracocore.blocks.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelCrystalizer extends ModelBase
{
  //fields
    ModelRenderer String1;
    ModelRenderer Bottom;
    ModelRenderer Wall1;
    ModelRenderer Wall2;
    ModelRenderer Wall3;
    ModelRenderer Wall4;
    ModelRenderer Water;
    ModelRenderer Pole;
    ModelRenderer String2;
  
  public ModelCrystalizer()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      String1 = new ModelRenderer(this, 0, 28);
      String1.addBox(0F, -13F, -1F, 0, 5, 2);
      String1.setRotationPoint(0F, 21F, 0F);
      String1.setTextureSize(128, 64);
      String1.mirror = true;
      setRotation(String1, 0F, -1.570796F, 0F);
      Bottom = new ModelRenderer(this, 0, 43);
      Bottom.addBox(-8F, 0F, -8F, 16, 3, 16);
      Bottom.setRotationPoint(0F, 21F, 0F);
      Bottom.setTextureSize(128, 64);
      Bottom.mirror = true;
      setRotation(Bottom, 0F, 0F, 0F);
      Wall1 = new ModelRenderer(this, 50, 0);
      Wall1.addBox(-8F, -13F, -8F, 16, 13, 2);
      Wall1.setRotationPoint(0F, 21F, 0F);
      Wall1.setTextureSize(128, 64);
      Wall1.mirror = true;
      setRotation(Wall1, 0F, 0F, 0F);
      Wall2 = new ModelRenderer(this, 53, 17);
      Wall2.addBox(-8F, -13F, 6F, 16, 13, 2);
      Wall2.setRotationPoint(0F, 21F, 0F);
      Wall2.setTextureSize(128, 64);
      Wall2.mirror = true;
      setRotation(Wall2, 0F, 0F, 0F);
      Wall3 = new ModelRenderer(this, 92, 0);
      Wall3.addBox(-8F, -13F, -6F, 2, 13, 12);
      Wall3.setRotationPoint(0F, 21F, 0F);
      Wall3.setTextureSize(128, 64);
      Wall3.mirror = true;
      setRotation(Wall3, 0F, 0F, 0F);
      Wall4 = new ModelRenderer(this, 91, 28);
      Wall4.addBox(6F, -13F, -6F, 2, 13, 12);
      Wall4.setRotationPoint(0F, 21F, 0F);
      Wall4.setTextureSize(128, 64);
      Wall4.mirror = true;
      setRotation(Wall4, 0F, 0F, 0F);
      Water = new ModelRenderer(this, 0, 0);
      Water.addBox(-6F, -8F, -6F, 12, 8, 12);
      Water.setRotationPoint(0F, 21F, 0F);
      Water.setTextureSize(128, 64);
      Water.mirror = true;
      setRotation(Water, 0F, 0F, 0F);
      Pole = new ModelRenderer(this, 16, 24);
      Pole.addBox(-6F, -13F, -1F, 12, 1, 2);
      Pole.setRotationPoint(0F, 21F, 0F);
      Pole.setTextureSize(128, 64);
      Pole.mirror = true;
      setRotation(Pole, 0F, 0F, 0F);
      String2 = new ModelRenderer(this, 8, 29);
      String2.addBox(0F, -13F, -1F, 0, 5, 2);
      String2.setRotationPoint(0F, 21F, 0F);
      String2.setTextureSize(128, 64);
      String2.mirror = true;
      setRotation(String2, 0F, 0F, 0F);
  }
  
  public void render(float f5)
  {
    String1.render(f5);
    Bottom.render(f5);
    Wall1.render(f5);
    Wall2.render(f5);
    Wall3.render(f5);
    Wall4.render(f5);
    Water.render(f5);
    Pole.render(f5);
    String2.render(f5);
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
