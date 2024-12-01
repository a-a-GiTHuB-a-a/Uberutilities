package com.daboxen.uberutilities.additions.items;

import com.daboxen.uberutilities.Uberutilities;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

import static com.daboxen.uberutilities.Uberutilities.LOGGER;
import static com.daboxen.uberutilities.Uberutilities.UBER_REGISTRATE;

public class Uberblocks {
	public static BlockEntry<Block> NEUTRONIUM_MACHINE_CASING = generateCasing("neutronium_casing", Uberutilities.id("block/neutronium_casing"));
	
	public static BlockEntry<Block> generateCasing(String name, ResourceLocation texture) {
		return UBER_REGISTRATE.block(name, Block::new)
			.tag(TagKey.create(Registries.BLOCK, new ResourceLocation("forge", "mineable/wrench")))
			.item(BlockItem::new)
			.build()
			.register();
	}
	
	public static void init() {
		LOGGER.info("Registering custom blocks");
	}
}
