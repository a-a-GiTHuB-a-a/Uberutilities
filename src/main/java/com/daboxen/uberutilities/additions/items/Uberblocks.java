package com.daboxen.uberutilities.additions.items;

import com.daboxen.uberutilities.Uberutilities;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Block;

import static com.daboxen.uberutilities.Uberutilities.LOGGER;

public class Uberblocks {
	public static BlockEntry<Block> NEUTRONIUM_MACHINE_CASING = GTBlocks.createCasingBlock("neutronium_casing", Uberutilities.id("blocks/neutronium_casing"));
	
	public static void init() {
		LOGGER.info("Registering custom blocks");
	}
}
