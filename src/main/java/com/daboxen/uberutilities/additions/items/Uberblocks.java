package com.daboxen.uberutilities.additions.items;

import com.daboxen.uberutilities.Uberutilities;
import com.gregtechceu.gtceu.api.data.tag.TagUtil;
import com.gregtechceu.gtceu.common.data.GTModels;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import javax.annotation.Nonnull;
import java.lang.reflect.Method; //TODO: remove when debug ends
import static com.daboxen.uberutilities.Uberutilities.LOGGER;
import static com.daboxen.uberutilities.Uberutilities.UBER_REGISTRATE;

public class Uberblocks {
	public static final BlockEntry<Block> NEUTRONIUM_MACHINE_CASING = createCasing("neutronium_casing", Uberutilities.id("block/neutronium_casing"), 5);
	public static final BlockEntry<Block> NEUTRON_GLASS = UBER_REGISTRATE.block("neutron_glass", Block::new)
		.initialProperties(NEUTRONIUM_MACHINE_CASING)
		.properties(p -> p.sound(SoundType.GLASS))
		.properties(BlockBehaviour.Properties::dynamicShape)
		.addLayer(() -> RenderType::translucent)
		.blockstate((ctx, prov) -> prov.simpleBlock(ctx.getEntry(), prov.models().getExistingFile(Uberutilities.id("block/neutron_glass"))))
		.item()
		.build()
		.register();
	
	public static @Nonnull BlockEntry<Block> createCasing(@Nonnull String name, @Nonnull ResourceLocation texture, int tier) {
		return UBER_REGISTRATE.block(name, Block::new)
			.initialProperties(() -> Blocks.IRON_BLOCK)
			.properties(p -> p.isValidSpawn((state, level, pos, ent) -> false))
			.properties(p -> (tier >= 3 ? p.explosionResistance(-1) : p))
			.addLayer(() -> RenderType::cutoutMipped)
			.blockstate(GTModels.cubeAllModel(name, texture))
			.tag(TagUtil.createBlockTag("mineable/wrench", false))
			.item()
			.build()
			.register();
	}
	
	public static void init() {
		LOGGER.info("Registering custom blocks");
		Method[] renderTypes = RenderType.class.getMethods();
		for (Method method : renderTypes) {LOGGER.info("Method: " + method.getName());}
	}
}
