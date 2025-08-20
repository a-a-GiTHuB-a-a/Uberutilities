package com.daboxen.uberutilities.additions.items;

import com.daboxen.uberutilities.Uberutilities;
import com.daboxen.uberutilities.api.CasingItem;
import com.daboxen.uberutilities.api.ShapeableBlock;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.phys.shapes.Shapes;

import javax.annotation.Nonnull;
import java.lang.reflect.Method;
import java.util.ArrayList;

import static com.daboxen.uberutilities.Uberutilities.LOGGER;
import static com.daboxen.uberutilities.Uberutilities.UBER_REGISTRATE;

public class Uberblocks {
	public static final BlockEntry<Block> NEUTRONIUM_MACHINE_CASING = createCasing("Radiation-Blocking Neutronium Machine Casing", "neutronium_casing", Uberutilities.id("block/casing/solid/neutronium_casing"));
	public static final BlockEntry<Block> NAQUADAH_MACHINE_CASING = createCasing("Antimatter-Proof Naquadah Machine Casing", "naquadah_casing", Uberutilities.id("block/casing/solid/naquadah_casing"));
	public static final BlockEntry<ShapeableBlock> NEUTRON_GLASS = UBER_REGISTRATE.block("neutron_glass", props -> new ShapeableBlock(props,
			Shapes.box(1d/16, 1d/16, 1d/16, 15d/16, 15d/16, 15d/16), //center
			Shapes.box(0,0,0,1d/16,1,1d/16),
			Shapes.box(15d/16,0,0,1,1,1d/16),
			Shapes.box(0,0,15d/16,1d/16,1,1),
			Shapes.box(15d/16,0,15d/16,1,1,1), //pillars
			Shapes.box(1d/16,0,0,15d/16,1d/16,1d/16),
			Shapes.box(1d/16,15d/16,0,15d/16,1,1d/16),
			Shapes.box(1d/16,0,15d/16,15d/16,1d/16,1),
			Shapes.box(1d/16,15d/16,15d/16,15d/16,1,1), //edges.x
			Shapes.box(0,0,1d/16,1d/16,1d/16,15d/16),
			Shapes.box(15d/16,0,1d/16,1,1d/16,15d/16),
			Shapes.box(0,15d/16,1d/16,1d/16,1,15d/16),
			Shapes.box(15d/16,15d/16,1d/16,1,1,15d/16) //edges.z
		))
		.initialProperties(NEUTRONIUM_MACHINE_CASING)
		.properties(p -> p.sound(SoundType.GLASS))
		.addLayer(() -> RenderType::translucent)
		.blockstate((ctx, prov) -> prov.simpleBlock(ctx.getEntry(), prov.models().getExistingFile(Uberutilities.id("block/neutron_glass"))))
		.item()
		.build()
		.register();
	
	public static @Nonnull BlockEntry<Block> createCasing(@Nonnull String name, @Nonnull String id, @Nonnull ResourceLocation texture) {
		CasingItem casing = new CasingItem.CasingItemBuilder(id, texture).name(name).build();
		return casing.getBlock();
	}
	public static @Nonnull BlockEntry<Block> createCasing(@Nonnull String id, @Nonnull ResourceLocation texture) {
		CasingItem casing = new CasingItem.CasingItemBuilder(id, texture).build();
		return casing.getBlock();
	}
	
	public static void init() {
		LOGGER.info("Registering custom blocks");
		Method[] renderTypes = RenderType.class.getMethods();
		for (Method method : renderTypes) {LOGGER.info("Method: {}", method.getName());}
	}
}
