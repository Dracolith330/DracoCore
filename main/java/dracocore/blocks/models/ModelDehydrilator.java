package dracocore.blocks.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDehydrilator extends ModelBase
{
  //fields
    ModelRenderer Wall1;
    ModelRenderer Door;
    ModelRenderer Wall2;
    ModelRenderer Bottom;
    ModelRenderer Wall3;
    ModelRenderer Top;
    ModelRenderer DoorOpen;
    ModelRenderer Grill1;
    ModelRenderer Grill2;
    ModelRenderer Grill3;
    ModelRenderer Grill4;
    ModelRenderer Grill5;
    ModelRenderer Grill6;
    ModelRenderer Grill7;
    ModelRenderer Grill8;
    ModelRenderer Grill9;
    ModelRenderer Grill10;
    ModelRenderer Grill11;
  
  public ModelDehydrilator()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Wall1 = new ModelRenderer(this, 0, 37);
      Wall1.addBox(7F, -12F, -7F, 1, 12, 14);
      Wall1.setRotationPoint(0F, 22F, 0F);
      Wall1.setTextureSize(128, 64);
      Wall1.mirror = true;
      setRotation(Wall1, 0F, 0F, 0F);
      Door = new ModelRenderer(this, 93, 0);
      Door.addBox(0F, -6F, -1F, 16, 12, 1);
      Door.setRotationPoint(-8F, 16F, -7F);
      Door.setTextureSize(128, 64);
      Door.mirror = true;
      setRotation(Door, 0F, 1.570796F, 0F);
      Wall2 = new ModelRenderer(this, 97, 16);
      Wall2.addBox(-8F, -12F, -7F, 1, 12, 14);
      Wall2.setRotationPoint(0F, 22F, 0F);
      Wall2.setTextureSize(128, 64);
      Wall2.mirror = true;
      setRotation(Wall2, 0F, 0F, 0F);
      Bottom = new ModelRenderer(this, 62, 44);
      Bottom.addBox(-8F, 0F, -8F, 16, 2, 16);
      Bottom.setRotationPoint(0F, 22F, 0F);
      Bottom.setTextureSize(128, 64);
      Bottom.mirror = true;
      setRotation(Bottom, 0F, 0F, 0F);
      Wall3 = new ModelRenderer(this, 0, 21);
      Wall3.addBox(-8F, -12F, 7F, 16, 12, 1);
      Wall3.setRotationPoint(0F, 22F, 0F);
      Wall3.setTextureSize(128, 64);
      Wall3.mirror = true;
      setRotation(Wall3, 0F, 0F, 0F);
      Top = new ModelRenderer(this, 31, 23);
      Top.addBox(-8F, -14F, -8F, 16, 2, 16);
      Top.setRotationPoint(0F, 22F, 0F);
      Top.setTextureSize(128, 64);
      Top.mirror = true;
      setRotation(Top, 0F, 0F, 0F);
      DoorOpen = new ModelRenderer(this, 93, 0);
      DoorOpen.addBox(0F, -6F, -1F, 16, 12, 1);
      DoorOpen.setRotationPoint(-8F, 16F, -7F);
      DoorOpen.setTextureSize(128, 64);
      DoorOpen.mirror = true;
      setRotation(DoorOpen, 0F, 0F, 0F);
      Grill1 = new ModelRenderer(this, 0, 0);
      Grill1.addBox(-8F, -1F, -7F, 16, 0, 14);
      Grill1.setRotationPoint(0F, 22F, 0F);
      Grill1.setTextureSize(128, 64);
      Grill1.mirror = true;
      setRotation(Grill1, 0F, 0F, 0F);
      Grill2 = new ModelRenderer(this, 0, 0);
      Grill2.addBox(-8F, -11F, -7F, 16, 0, 14);
      Grill2.setRotationPoint(0F, 22F, 0F);
      Grill2.setTextureSize(128, 64);
      Grill2.mirror = true;
      setRotation(Grill2, 0F, 0F, 0F);
      Grill3 = new ModelRenderer(this, 0, 0);
      Grill3.addBox(-8F, -10F, -7F, 16, 0, 14);
      Grill3.setRotationPoint(0F, 22F, 0F);
      Grill3.setTextureSize(128, 64);
      Grill3.mirror = true;
      setRotation(Grill3, 0F, 0F, 0F);
      Grill4 = new ModelRenderer(this, 0, 0);
      Grill4.addBox(-8F, -9F, -7F, 16, 0, 14);
      Grill4.setRotationPoint(0F, 22F, 0F);
      Grill4.setTextureSize(128, 64);
      Grill4.mirror = true;
      setRotation(Grill4, 0F, 0F, 0F);
      Grill5 = new ModelRenderer(this, 0, 0);
      Grill5.addBox(-8F, -8F, -7F, 16, 0, 14);
      Grill5.setRotationPoint(0F, 22F, 0F);
      Grill5.setTextureSize(128, 64);
      Grill5.mirror = true;
      setRotation(Grill5, 0F, 0F, 0F);
      Grill6 = new ModelRenderer(this, 0, 0);
      Grill6.addBox(-8F, -7F, -7F, 16, 0, 14);
      Grill6.setRotationPoint(0F, 22F, 0F);
      Grill6.setTextureSize(128, 64);
      Grill6.mirror = true;
      setRotation(Grill6, 0F, 0F, 0F);
      Grill7 = new ModelRenderer(this, 0, 0);
      Grill7.addBox(-8F, -6F, -7F, 16, 0, 14);
      Grill7.setRotationPoint(0F, 22F, 0F);
      Grill7.setTextureSize(128, 64);
      Grill7.mirror = true;
      setRotation(Grill7, 0F, 0F, 0F);
      Grill8 = new ModelRenderer(this, 0, 0);
      Grill8.addBox(-8F, -5F, -7F, 16, 0, 14);
      Grill8.setRotationPoint(0F, 22F, 0F);
      Grill8.setTextureSize(128, 64);
      Grill8.mirror = true;
      setRotation(Grill8, 0F, 0F, 0F);
      Grill9 = new ModelRenderer(this, 0, 0);
      Grill9.addBox(-8F, -4F, -7F, 16, 0, 14);
      Grill9.setRotationPoint(0F, 22F, 0F);
      Grill9.setTextureSize(128, 64);
      Grill9.mirror = true;
      setRotation(Grill9, 0F, 0F, 0F);
      Grill10 = new ModelRenderer(this, 0, 0);
      Grill10.addBox(-8F, -3F, -7F, 16, 0, 14);
      Grill10.setRotationPoint(0F, 22F, 0F);
      Grill10.setTextureSize(128, 64);
      Grill10.mirror = true;
      setRotation(Grill10, 0F, 0F, 0F);
      Grill11 = new ModelRenderer(this, 0, 0);
      Grill11.addBox(-8F, -2F, -7F, 16, 0, 14);
      Grill11.setRotationPoint(0F, 22F, 0F);
      Grill11.setTextureSize(128, 64);
      Grill11.mirror = true;
      setRotation(Grill11, 0F, 0F, 0F);
  }
  
  public void render(float f5)
  {
    Wall1.render(f5);
    Door.render(f5);
    Wall2.render(f5);
    Bottom.render(f5);
    Wall3.render(f5);
    Top.render(f5);
    DoorOpen.render(f5);
    Grill1.render(f5);
    Grill2.render(f5);
    Grill3.render(f5);
    Grill4.render(f5);
    Grill5.render(f5);
    Grill6.render(f5);
    Grill7.render(f5);
    Grill8.render(f5);
    Grill9.render(f5);
    Grill10.render(f5);
    Grill11.render(f5);
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
