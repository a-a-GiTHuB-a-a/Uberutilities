package com.daboxen.uberutilities.additions.items;

import com.daboxen.uberutilities.Uberutilities;
import com.gregtechceu.gtceu.api.item.tool.GTToolType;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import javax.annotation.Nonnull;

import static com.daboxen.uberutilities.Uberutilities.LOGGER;
import static com.daboxen.uberutilities.Uberutilities.UBER_REGISTRATE;

public class Uberblocks {
	public static BlockEntry<Block> NEUTRONIUM_MACHINE_CASING = createCasing("neutronium_casing", Uberutilities.id("block/neutronium_casing"));
	
	public static @Nonnull BlockEntry<Block> createCasing(@Nonnull String name, @Nonnull ResourceLocation texture) {
		return createCasing(name, texture, 2);
	}
	
	public static @Nonnull BlockEntry<Block> createCasing(@Nonnull String name, @Nonnull ResourceLocation texture, int tier) {
		return UBER_REGISTRATE.block(name, Block::new)
			.initialProperties(() -> Blocks.IRON_BLOCK)
			.properties(p -> p.isValidSpawn((state, level, pos, ent) -> false))
			.properties(p -> (tier >= 3 ? p.explosionResistance(-1) : p))
			.tag(GTToolType.WRENCH.harvestTags.get(0), BlockTags.MINEABLE_WITH_PICKAXE)
			.blockstate((ctx, prov) -> prov.simpleBlock(ctx.getEntry(), prov.models().cubeAll(name, texture)))
			.item(BlockItem::new)
			.build()
			.register();
	}
	
	public static void init() {
		LOGGER.info("Registering custom blocks");
	}
}
