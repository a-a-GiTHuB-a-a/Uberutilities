package com.daboxen.uberutilities.data.models;

import com.daboxen.uberutilities.Uberutilities;
import com.gregtechceu.gtceu.GTCEu;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import net.minecraft.world.level.block.Block;

public class Models {
	public static NonNullBiConsumer<DataGenContext<Block, Block>, RegistrateBlockstateProvider> createEmissionCasingModel(String tierName) {
		return (ctx, prov) -> {
			prov.simpleBlock(ctx.getEntry(), prov.models()
				.withExistingParent("%s_emission_casing".formatted(tierName), Uberutilities.id("block/emission_casing"))
				.texture("base_bottom", GTCEu.id("block/casings/voltage/%s/bottom".formatted(tierName)))
				.texture("base_top", GTCEu.id("block/casings/voltage/%s/top".formatted(tierName)))
				.texture("base_side", GTCEu.id("block/casings/voltage/%s/side".formatted(tierName))));
		};
	}
}