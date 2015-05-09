/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 *
 * Botania is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 *
 * File Created @ [Jan 14, 2014, 6:15:28 PM (GMT)]
 */
package dracocore.handbook;

import java.util.ArrayList;
import java.util.List;

import dracocore.handbook.core.LexiconCategory;
import dracocore.handbook.core.LexiconEntry;

//Derived from the BopaniaAPI class, but the name didn't make sense in context
public final class CategoryManager {

    // All of these categories are initialized during botania's PreInit stage.
    
    public static LexiconCategory categoryBasics;
    public static LexiconCategory categoryMisc;
    public static LexiconCategory categoryMagic;
    public static LexiconCategory categoryTech;
    public static LexiconCategory categoryRituals;
    public static LexiconCategory categoryRecipes;
    public static LexiconCategory categoryMultiBlocks;
    public static LexiconCategory categoryMagiTech;
    private static List<LexiconCategory> categories = new ArrayList<LexiconCategory>();
    private static List<LexiconEntry> allEntries = new ArrayList<LexiconEntry>();

    /**
     * Adds a category to the list of registered categories to appear in the Lexicon.
     */
    public static void addCategory(LexiconCategory category) {
        categories.add(category);
        category.Categories.add(category);
    }

    /**
     * Gets all registered categories.
     */
    public static List<LexiconCategory> getAllCategories() {
        return categories;
    }

    /**
     * Gets all registered entries.
     */
    public static List<LexiconEntry> getAllEntries() {
        return allEntries;
    }

    /**
     * Registers a Lexicon Entry and adds it to the category passed in.
     */
    public static void addEntry(LexiconEntry entry, LexiconCategory category) {
        allEntries.add(entry);
        category.entries.add(entry);
    }

}
