package com.daboxen.uberutilities.additions.items;

import com.daboxen.uberutilities.Uberutilities;
import com.daboxen.uberutilities.api.ShapeableBlock;
import com.gregtechceu.gtceu.api.data.tag.TagUtil;
import com.gregtechceu.gtceu.common.data.GTModels;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.phys.shapes.Shapes;

import javax.annotation.Nonnull;
import java.lang.reflect.Method; //TODO: remove when debug ends
import static com.daboxen.uberutilities.Uberutilities.LOGGER;
import static com.daboxen.uberutilities.Uberutilities.UBER_REGISTRATE;

public class Uberblocks {
	public static final BlockEntry<Block> NEUTRONIUM_MACHINE_CASING = createCasing("neutronium_casing", Uberutilities.id("block/neutronium_casing"), 5);
	public static final BlockEntry<ShapeableBlock> NEUTRON_GLASS = UBER_REGISTRATE.block("neutron_glass", props -> new ShapeableBlock(props,
			Shapes.box(1, 1, 1, 15, 15, 15), //center
			Shapes.box(0,0,0,1,16,1),
			Shapes.box(15,0,0,16,16,1),
			Shapes.box(0,0,15,1,16,16),
			Shapes.box(15,0,15,16,16,16), //pillars
			Shapes.box(1,0,0,15,1,1),
			Shapes.box(1,15,0,15,16,1),
			Shapes.box(1,0,15,15,1,16),
			Shapes.box(1,15,15,15,16,16), //edges.x
			Shapes.box(0,0,1,1,1,15),
			Shapes.box(15,0,1,16,1,15),
			Shapes.box(0,15,1,1,16,15),
			Shapes.box(15,15,1,16,16,15) //edges.z
		))
		.initialProperties(NEUTRONIUM_MACHINE_CASING)
		.properties(p -> p.sound(SoundType.GLASS))
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
