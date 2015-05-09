package dracocore.proxies.handlers;

import dracocore.api.prefab.core.ToolTipHandler;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;


public class registerItemBlockAspects 
{
	static ToolTipHandler TTH;
	
	public static void init()
	{
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.acacia_stairs), "Arbor, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.activator_rail), "Metalum, Cognito, Machina");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.anvil), "Metalum, Fabrico, Ordo");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.bed), "Panus, Arbor");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.bedrock), "Terra, Infragilis");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.birch_stairs), "Arbor, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.bookshelf), "Cognito, Arbor");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.brewing_stand), "Aqua, Ignis, Terra");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.brick_block), "Terra, Ordo");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.brick_stairs), "Terra, Ordo");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.brown_mushroom_block), "Victus, Fungus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.cactus), "Arma, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.cake), "Nutrimen");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.carpet), "Panus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.carrots), "Nutrimen, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.clay), "Aqua, Terra");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.coal_block), "Ignis, Potentia");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.coal_ore), "Terra, Ignis");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.cobblestone), "Terra, Perdito");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.cobblestone_wall), "Terra, Perdito");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.cocoa), "Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.crafting_table), "Fabrico, Arbor");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.dark_oak_stairs), "Arbor, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.detector_rail), "Metalum, Machina");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.diamond_block), "Purus, Terra, Ordo, Lucrum");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.dirt), "Terra");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.dispenser), "Terra, Machina");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.dragon_egg), "Draconum, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.dropper), "Terra, Machina");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.emerald_block), "Purus, Terra, Ordo, Lucrum");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.emerald_ore), "Terra, Ordo, Lucrum");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.diamond_ore), "Terra, Ordo, Lucrum");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.enchanting_table), "Pracicanto, Cognito");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.end_portal), "Alienis");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.end_portal_frame), "Alienis, Terra");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.end_stone), "Alienis, Terra");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.ender_chest), "Alienis, Terra, Tenebrae");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.farmland), "Terra");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.fence), "Arbor, Tendicula");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.fence_gate), "Arbor, Vacuous");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.flower_pot), "Terra, Ordo");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.furnace), "Ignis, Terra");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.glass), "Purus, Ordo");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.glass_pane), "Purus, Ordo");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.glowstone), "Lux, Terra");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.gold_block), "Lucrum, Ordo, Metalum");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.gold_ore), "Terra, Metalum, Lucrum");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.golden_rail), "Metalum, Lucrum, Machina");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.gravel), "Terra");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.hardened_clay), "Terra");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.hay_block), "Nutrimen, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.heavy_weighted_pressure_plate), "Metalum, Ordo");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.ice), "Aqua, Ordo");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.iron_bars), "Metalum, Tendicula");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.iron_block), "Metalum, Ordo, Terra");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.iron_door), "Metalum, Ordo, Tendicula");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.iron_ore), "Metalum, Terra");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.jukebox), "Arbor, Purus, Sonus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.jungle_stairs), "Arbor, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.ladder), "Arbor, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.lapis_block), "Terra, Sensus, Ordo");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.lapis_ore), "Terra, Sensus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.lava), "Ignis, Terra");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.lever), "Arbor, Terra, Machina");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.light_weighted_pressure_plate), "Metalum, Lucrum, Machina");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.lit_furnace), "Ignis, Terra");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.lit_pumpkin), "Lux, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.lit_redstone_lamp), "Lux, Machina, Ordo");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.log), "Arbor, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.log2), "Arbor, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.melon_block), "Nutrimen, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.melon_stem), "Arbor, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.mob_spawner), "Terra, Perdito");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.monster_egg), "Perdito, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.mossy_cobblestone), "Terra, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.nether_brick), "Ignis, Terra, Ordo");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.nether_brick_fence), "Ignis, Terra, Tendicula");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.nether_brick_stairs), "Ignis, Terra, Ordo");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.nether_wart), "Ignis, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.netherrack), "Ignis, Terra");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.noteblock), "Arbor, Machina, Sonus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.oak_stairs), "Arbor, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.obsidian), "Terra, Tenebrae");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.packed_ice), "Aqua, Ordo");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.planks), "Arbor, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.potatoes), "Nutrimen, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.pumpkin), "Arbor, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.quartz_block), "Terra, Ignis, Ordo");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.quartz_ore), "Terra, Ignis");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.quartz_stairs), "Terra, Ignis, Ordo");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.rail), "Metalum, Machina, Iter");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.red_mushroom_block), "Fungus, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.redstone_block), "Machina, Ordo");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.redstone_lamp), "Machina, Lux, Ordo");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.redstone_ore), "Terra, Machina");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.redstone_torch), "Arbor, Machina, Lux");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.reeds), "Arbor, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.sandstone), "Perdito, Terra");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.sandstone_stairs), "Perdito, Terra");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.sapling), "Arbor, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.skull), "Humanus, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.snow), "Aqua, Ordo");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.snow_layer), "Aqua, Ordo");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.soul_sand), "Vivatus, Perdito");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.sponge), "Aqua, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.spruce_stairs), "Arbor, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.stained_hardened_clay), "Terra, Ordo");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.standing_sign), "Arbor, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.stone), "Terra, Ordo");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.stone_brick_stairs), "Terra, Ordo");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.stone_button), "Terra, Machina");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.stone_stairs), "Terra, Ordo");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.stonebrick), "Terra, Ordo");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.tnt), "Terra, Ignis, Perdito");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.torch), "Lux, Arbor");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.trapdoor), "Arbor, Tendicula");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.trapped_chest), "Arbor, Machina, Vacuous");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.tripwire), "Panus, Machina");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.unlit_redstone_torch), "Machina, Arbor");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.vine), "Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.wall_sign), "Arbor, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.water), "Aqua");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.waterlily), "Aqua, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.web), "Panus, Tendicula");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.wheat), "Messis, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.wooden_button), "Arbor, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.wooden_door), "Arbor, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.wooden_pressure_plate), "Arbor, Victus, Machina");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.wool), "Panus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.beacon), "Ordo, Pracicanto, Terra");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.brown_mushroom), "Fungus, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.cauldron), "Metalum, Ordo, Aqua");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.chest), "Arbor, Victus, Vacuous");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.daylight_detector), "Lux, Machina");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.deadbush), "Arbor, Perdito, Mortus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.double_plant), "Victus, aer");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.double_stone_slab), "Terra, Ordo");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.double_wooden_slab), "Arbor, Ordo");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.fire), "Ignis, Aer");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.grass), "Victus, Aer");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.hopper), "Metalum, Machina, Vacuous");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.leaves), "Aer, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.leaves2), "Aer, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.mycelium), "Fungus, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.piston), "Arbor, Terra, Machina");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.portal), "Ignis, Iter");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.powered_comparator), "Machina, Terra, Lux");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.powered_repeater), "Machina, Terra, Permutatio");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.red_flower), "Sensus, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.red_mushroom), "Fungus, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.redstone_wire), "Machina, Terra");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.sand), "Terra, Perdito");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.stained_glass), "Purus, Sensus, Ordo");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.stained_glass_pane), "Purus, Sensus, Ordo");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.sticky_piston), "Machina, Terra, Arbor, Limus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.stone_slab), "Terra, Ordo");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.tallgrass), "Aer, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.tripwire_hook), "Panus, Machina");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.unpowered_comparator), "Machina, Terra");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.unpowered_repeater), "Machina, Terra");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.wooden_slab), "Arbor, Victus");
		TTH.registerToolTipAspects(Item.getItemFromBlock(Blocks.yellow_flower), "Sensus, Victus");
		
		
		TTH.registerToolTipAspects(Items.coal, "Ignis, Potentia");
		
		
	}
	
}