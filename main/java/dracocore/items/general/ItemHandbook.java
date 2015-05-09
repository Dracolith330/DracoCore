package dracocore.items.general;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dracocore.CoreMain;
import dracocore.References;
import dracocore.blocks.blockclasses.mana.BlocksMagic;
import dracocore.blocks.blockclasses.power.BlocksTech;
import dracocore.handbook.CategoryManager;
import dracocore.handbook.core.KnowledgeType;
import dracocore.handbook.core.LexiconEntry;
import dracocore.handbook.helpers.ItemNBTHelper;
import dracocore.handbook.interfaces.ILexicon;

/**
 * Created by pixlepix on 12/27/14.
 * *HEAVILY* based off of/stolen from Vazkii
 */
public class ItemHandbook extends Item implements ILexicon {
	
    private static final String TAG_KNOWLEDGE_PREFIX = "knowledge.";
    private static final String TAG_FORCED_MESSAGE = "forcedMessage";
    private static final String TAG_QUEUE_TICKS = "queueTicks";
    boolean skipSound = false;
    private static final int[][] BlockLocations = new int[][] {
		//OBSIDIAN//
    	{ 1, 0, 0 }, { 2, 0, 0 }, { 3, 0, 0 },
		{ 3, 0, 1 }, { 3, 0, -1 }, { -1, 0, 0 },
		{ -2, 0, 0 }, { -3, 0, 0 }, { -3, 0, 1 },
		{ -3, 0, -1 }, { 0, 0, 1 }, { 0, 0, 2 },
		{ 0, 0, 3 }, { -1, 0, 3 }, { 1, 0, 3 },
		{ 0, 0, -1 }, { 0, 0, -2 }, { 0, 0, -3 },
		{ -1, 0, -3 }, { 1, 0, -3 },
		
		//T4 Upgrade Runes//
		{ 2, 0, -2 }, { 2, 0, 2 }, { -2, 0, -2 }, { -2, 0, 2 },
		
		//CrystalCluster//
		{ 2, 1, -2 }, { 2, 1, 2 }, { -2, 1, -2 }, { -2, 1, 2 }
		
		//Perfect Wire//
		, { -2, 1, -3 }, { -1, 1, -3 }, { 0, 1, -3 }, { 1, 1, -3 }, { 2, 1, -3 }
		, { -2, 1, 3 }, { -1, 1, 3 }, { 0, 1, 3 }, { 1, 1, 3 }, { 2, 1, 3 }
		, { 3, 1, 2 }, { 3, 1, 1 }, { 3, 1, 0 }, { 3, 1, 1 }, { 3, 1, 2 }
		, { -3, 1, -2 }, { -3, 1, -1 }, { -3, 1, 0 }, { -3, 1, 1 }, { -3, 1, 2 }
	};
    
    
    public ItemHandbook() {
        super();
        setMaxStackSize(1);
    }

    public static void setForcedPage(ItemStack stack, String forced) {
        ItemNBTHelper.setString(stack, TAG_FORCED_MESSAGE, forced);
    }

    public static String getForcedPage(ItemStack stack) {
        return ItemNBTHelper.getString(stack, TAG_FORCED_MESSAGE, "");
    }
    
    @Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		list.add(new ItemStack(item));
		ItemStack creative = new ItemStack(item);
		for(String s : CoreMain.knowledgeTypes.keySet()) {
			KnowledgeType type = CoreMain.knowledgeTypes.get(s);
			unlockKnowledge(creative, type);
		}
		list.add(creative);
	}
    
    private static LexiconEntry getEntryFromForce(ItemStack stack) {
        String force = getForcedPage(stack);
        for (LexiconEntry entry : CategoryManager.getAllEntries())
            if (entry.unlocalizedName.equals(force)) {
                return entry;
            }

        return null;
    }
    
    @Override
	public void unlockKnowledge(ItemStack stack, KnowledgeType knowledge) {
		ItemNBTHelper.setBoolean(stack, TAG_KNOWLEDGE_PREFIX + knowledge.id, true);
	}
    
    public static int getQueueTicks(ItemStack stack) {
        return ItemNBTHelper.getInt(stack, TAG_QUEUE_TICKS, 0);
    }

    public static void setQueueTicks(ItemStack stack, int ticks) {
        ItemNBTHelper.setInt(stack, TAG_QUEUE_TICKS, ticks);
    }

    @Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
        if (par2EntityPlayer.isSneaking() && !ItemNBTHelper.getBoolean(par1ItemStack, TAG_KNOWLEDGE_PREFIX + CoreMain.draconianKnowledge.id, false)) 
        {
            Block block = par3World.getBlock(par4, par5, par6);
            if (block == Blocks.diamond_block) 
            {                
            	if(checkArrayValues(par3World, 0, 20, Blocks.obsidian, par4, par5, par6).size() == 20)
            	{
            		if(checkArrayValues(par3World, 20, 24, BlocksMagic.RuneSlotT4, par4, par5, par6).size() == 4)
                	{            		
            			if(checkArrayValues(par3World, 24, 28, BlocksMagic.ChargedCrystalCluser, par4, par5, par6).size() == 4)
                    	{
            				if(checkArrayValues(par3World, 28, 48, BlocksTech.PerfectGradeWire, par4, par5, par6).size() == 20)
                        	{
            		    		((ILexicon) par1ItemStack.getItem()).unlockKnowledge(par1ItemStack, CoreMain.draconianKnowledge);
            					return true;
                        	}
                    	}
                	}
            	}
        	}
        }
        return false;
    }
    
    private List checkArrayValues(World world, int start, int end, Block block, int x, int y, int z)
    {
    	List values = new ArrayList(){};
    	for(int s = start; s < end; s++)
    	{
				int parX = x + BlockLocations[s][0];
				int parY = y + BlockLocations[s][1];
				int parZ = z + BlockLocations[s][2];

				Block blockat = world.getBlock(parX, parY, parZ);
				if(blockat == block)
				{
					values.add(BlockLocations[s]);
				}
    	}
		return values;
    }

    private void addStringToTooltip(String s, List<String> tooltip) {
        tooltip.add(s.replaceAll("&", "\u00a7"));
    }

    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        String force = getForcedPage(par1ItemStack);
        if (force != null && !force.isEmpty()) {
            LexiconEntry entry = getEntryFromForce(par1ItemStack);
            if (entry != null) {
            	CoreMain.proxy.setEntryToOpen(entry);
            } else {
                par3EntityPlayer.addChatMessage(new ChatComponentTranslation("dracocore.misc.cantOpen").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.RED)));
            }
            setForcedPage(par1ItemStack, "");
        }
        CoreMain.proxy.setLexiconStack(par1ItemStack);
        par3EntityPlayer.openGui(CoreMain.instance, 1, par2World, 0, 0, 0);
        if (!par2World.isRemote && !skipSound)
            par2World.playSoundAtEntity(par3EntityPlayer, "dracocore:lexiconOpen", 0.5F, 1F);
        skipSound = false;
        return par1ItemStack;
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int idk, boolean something) {
        int ticks = getQueueTicks(stack);
        if (ticks > 0 && entity instanceof EntityPlayer) {
            skipSound = ticks < 5;
            if (ticks == 1)
                onItemRightClick(stack, world, (EntityPlayer) entity);
            setQueueTicks(stack, ticks - 1);
        }
    }

    @Override
    public EnumRarity getRarity(ItemStack par1ItemStack) {
        return EnumRarity.uncommon;
    }
    
    @Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		if(GuiScreen.isShiftKeyDown()) {
			List<KnowledgeType> typesKnown = new ArrayList();
			for(String s : CoreMain.knowledgeTypes.keySet()) {
				KnowledgeType type = CoreMain.knowledgeTypes.get(s);
				if(isKnowledgeUnlocked(par1ItemStack, type))
					typesKnown.add(type);
			}

			String format = typesKnown.size() == 1 ? "botaniamisc.knowledgeTypesSingular" : "botaniamisc.knowledgeTypesPlural";
			addStringToTooltip(String.format(StatCollector.translateToLocal(format), typesKnown.size()), par3List);

			for(KnowledgeType type : typesKnown)
				addStringToTooltip(" \u2022 " + StatCollector.translateToLocal(type.getUnlocalizedName()), par3List);

		} else addStringToTooltip(StatCollector.translateToLocal("botaniamisc.shiftinfo"), par3List);
	}
    
    @Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) 
	{
		itemIcon = par1IconRegister.registerIcon(References.modid + ":" + this.getUnlocalizedName().substring(5));
	}

    @Override
	public boolean isKnowledgeUnlocked(ItemStack stack, KnowledgeType knowledge) {
		return knowledge.autoUnlock || ItemNBTHelper.getBoolean(stack, TAG_KNOWLEDGE_PREFIX + knowledge.id, false);
	}
}
