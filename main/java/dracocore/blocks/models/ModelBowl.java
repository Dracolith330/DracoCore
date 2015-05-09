package dracocore.blocks.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBowl extends ModelBase
{
  //fields
    ModelRenderer BowlBase;
    ModelRenderer BowlWall1;
    ModelRenderer BowlWall2;
    ModelRenderer BowlWall3;
    ModelRenderer BowlWall4;
  
  public ModelBowl()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      BowlBase = new ModelRenderer(this, 0, 0);
      BowlBase.addBox(-3F, 0F, -3F, 6, 2, 6);
      BowlBase.setRotationPoint(0F, 22F, 0F);
      BowlBase.setTextureSize(64, 32);
      BowlBase.mirror = true;
      setRotation(BowlBase, 0F, 0F, 0F);
      BowlWall1 = new ModelRenderer(this, 0, 9);
      BowlWall1.addBox(-3F, 2F, -2F, 6, 1, 2);
      BowlWall1.setRotationPoint(0F, 22F, 0F);
      BowlWall1.setTextureSize(64, 32);
      BowlWall1.mirror = true;
      setRotation(BowlWall1, -1.22173F, 0F, 0F);
      BowlWall2 = new ModelRenderer(this, 25, 0);
      BowlWall2.addBox(-3F, 2F, 0F, 6, 1, 2);
      BowlWall2.setRotationPoint(0F, 22F, 0F);
      BowlWall2.setTextureSize(64, 32);
      BowlWall2.mirror = true;
      setRotation(BowlWall2, 1.22173F, 0F, 0F);
      BowlWall3 = new ModelRenderer(this, 25, 4);
      BowlWall3.addBox(0F, 2F, -3F, 2, 1, 6);
      BowlWall3.setRotationPoint(0F, 22F, 0F);
      BowlWall3.setTextureSize(64, 32);
      BowlWall3.mirror = true;
      setRotation(BowlWall3, 0F, 0F, -1.22173F);
      BowlWall4 = new ModelRenderer(this, 0, 13);
      BowlWall4.addBox(-2F, 2F, -3F, 2, 1, 6);
      BowlWall4.setRotationPoint(0F, 22F, 0F);
      BowlWall4.setTextureSize(64, 32);
      BowlWall4.mirror = true;
      setRotation(BowlWall4, 0F, 0F, 1.22173F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    BowlBase.render(f5);
    BowlWall1.render(f5);
    BowlWall2.render(f5);
    BowlWall3.render(f5);
    BowlWall4.render(f5);
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
