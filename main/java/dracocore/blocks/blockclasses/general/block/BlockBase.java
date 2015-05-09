package dracocore.blocks.blockclasses.general.block;

import java.util.List;

import dracocore.blocks.BlocksMain;
import dracocore.blocks.blockclasses.general.BlocksGeneric;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;

public class BlockBase extends Block
{

	public String tooltip;
	
    public BlockBase(String s)
    {
        super(Material.rock);
    	tooltip = s;
    }
    
    @Override
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity)
    {
        if (entity instanceof EntityWither)
        {
            return this != Blocks.bedrock && this != Blocks.end_portal && this != Blocks.end_portal_frame && this != Blocks.command_block;
        }
        else if (entity instanceof EntityDragon)
        {
            return this != Blocks.obsidian && this != Blocks.end_stone && this != Blocks.bedrock && this != BlocksGeneric.PlatinumOre; 
        }

        return true;
    }
    
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean bool) 
    {
    	list.add(tooltip);
    }
   	
    
    
}