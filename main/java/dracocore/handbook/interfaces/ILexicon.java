package dracocore.handbook.interfaces;

import net.minecraft.item.ItemStack;
import dracocore.handbook.core.KnowledgeType;

/**
 * Basic interface for the Lexica Botania.
 */
public interface ILexicon {

	/**
	 * Gets if a specific knowledge is unlocked. Check the knowledge types in
	 * BotaniaAPI.
	 */
	public boolean isKnowledgeUnlocked(ItemStack stack, KnowledgeType knowledge);

	/**
	 * Unlocks a specfic type of knowledge.
	 */
	public void unlockKnowledge(ItemStack stack, KnowledgeType knowledge);

}
