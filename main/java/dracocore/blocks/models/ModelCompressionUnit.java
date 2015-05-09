package dracocore.blocks.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelCompressionUnit extends ModelBase
{
  //fields
    ModelRenderer Bottom;
    ModelRenderer PistonFace2;
    ModelRenderer Wall2;
    ModelRenderer Wall3;
    ModelRenderer PistonArm1;
    ModelRenderer Wall4;
    ModelRenderer Wall1;
    ModelRenderer PistonFace1;
    ModelRenderer PistonArm2;
  
  public ModelCompressionUnit()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Bottom = new ModelRenderer(this, 0, 43);
      Bottom.addBox(-8F, 0F, -8F, 16, 3, 16);
      Bottom.setRotationPoint(0F, 21F, 0F);
      Bottom.setTextureSize(128, 64);
      Bottom.mirror = true;
      setRotation(Bottom, 0F, 0F, 0F);
      PistonFace2 = new ModelRenderer(this, 1, 0);
      PistonFace2.addBox(-6F, -10F, -8F, 12, 1, 14);
      PistonFace2.setRotationPoint(0F, 21F, 0F);
      PistonFace2.setTextureSize(128, 64);
      PistonFace2.mirror = true;
      setRotation(PistonFace2, 0F, 0F, 0F);
      Wall2 = new ModelRenderer(this, 4, 17);
      Wall2.addBox(-8F, -13F, 6F, 16, 13, 2);
      Wall2.setRotationPoint(0F, 21F, 0F);
      Wall2.setTextureSize(128, 64);
      Wall2.mirror = true;
      setRotation(Wall2, 0F, 0F, 0F);
      Wall3 = new ModelRenderer(this, 74, 0);
      Wall3.addBox(-6F, -13F, -8F, 12, 3, 14);
      Wall3.setRotationPoint(0F, 21F, 0F);
      Wall3.setTextureSize(128, 64);
      Wall3.mirror = true;
      setRotation(Wall3, 0F, 0F, 0F);
      PistonArm1 = new ModelRenderer(this, 43, 28);
      PistonArm1.addBox(-1F, -13F, -2F, 2, 4, 2);
      PistonArm1.setRotationPoint(0F, 21F, 0F);
      PistonArm1.setTextureSize(128, 64);
      PistonArm1.mirror = true;
      setRotation(PistonArm1, 0F, 0F, 0F);
      Wall4 = new ModelRenderer(this, 91, 35);
      Wall4.addBox(6F, -13F, -8F, 2, 13, 14);
      Wall4.setRotationPoint(0F, 21F, 0F);
      Wall4.setTextureSize(128, 64);
      Wall4.mirror = true;
      setRotation(Wall4, 0F, 0F, 0F);
      Wall1 = new ModelRenderer(this, 53, 14);
      Wall1.addBox(-8F, -13F, -8F, 2, 13, 14);
      Wall1.setRotationPoint(0F, 21F, 0F);
      Wall1.setTextureSize(128, 64);
      Wall1.mirror = true;
      setRotation(Wall1, 0F, 0F, 0F);
      PistonFace1 = new ModelRenderer(this, 91, 20);
      PistonFace1.addBox(-6F, -1F, -8F, 12, 1, 12);
      PistonFace1.setRotationPoint(0F, 21F, 0F);
      PistonFace1.setTextureSize(128, 64);
      PistonFace1.mirror = true;
      setRotation(PistonFace1, 0F, 0F, 0F);
      PistonArm2 = new ModelRenderer(this, 80, 48);
      PistonArm2.addBox(-1F, -1F, -2F, 2, 4, 2);
      PistonArm2.setRotationPoint(0F, 21F, 0F);
      PistonArm2.setTextureSize(128, 64);
      PistonArm2.mirror = true;
      setRotation(PistonArm2, 0F, 0F, 0F);
  }
  
  public void render(float f5)
  {
    Bottom.render(f5);
    PistonFace2.render(f5);
    Wall2.render(f5);
    Wall3.render(f5);
    PistonArm1.render(f5);
    Wall4.render(f5);
    Wall1.render(f5);
    PistonFace1.render(f5);
    PistonArm2.render(f5);
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
