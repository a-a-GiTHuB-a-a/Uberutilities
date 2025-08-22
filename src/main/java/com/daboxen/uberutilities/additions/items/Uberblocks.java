package com.daboxen.uberutilities.additions.items;

import com.daboxen.uberutilities.Uberutilities;
import static com.daboxen.uberutilities.Uberutilities.LOGGER;
import static com.daboxen.uberutilities.Uberutilities.UBER_REGISTRATE;
import com.daboxen.uberutilities.api.CasingItem;
import com.daboxen.uberutilities.api.ShapeableBlock;
import com.daboxen.uberutilities.data.models.Models;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.tterrag.registrate.util.entry.BlockEntry;
import javax.annotation.Nonnull;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.phys.shapes.Shapes;

public class Uberblocks {
	public static final BlockEntry<Block> NEUTRONIUM_MACHINE_CASING = createCasing("Radiation-Blocking Neutronium Machine Casing", "neutronium_casing", Uberutilities.id("block/casing/solid/neutronium_casing"));
	public static final BlockEntry<Block> NAQUADAH_MACHINE_CASING = createCasing("Antimatter-Proof Naquadah Machine Casing", "naquadah_casing", Uberutilities.id("block/casing/solid/naquadah_casing"));

    public static final BlockEntry<Block> HTP_MATTER_PIPE = createCasing("Encased High-Throughput Matter Pipe", "htp_matter_pipe", Uberutilities.id("block/casing/pipe/htp_matter_pipe"));
    public static final BlockEntry<Block> HTP_ANTIMATTER_PIPE = createCasing("Encased High-Throughput Antimatter Pipe", "htp_antimatter_pipe", Uberutilities.id("block/casing/pipe/htp_antimatter_pipe"));
	public static final BlockEntry<Block> HTP_PUMP = createCasing("Encased High-Throughput Fluid Pump", "htp_pump", Uberutilities.id("block/casing/pipe/htp_pump"));

	public static final BlockEntry<Block> EMISSION_CASING_LV = createEmissionCasing(GTValues.LV);
	public static final BlockEntry<Block> EMISSION_CASING_MV = createEmissionCasing(GTValues.MV);
	public static final BlockEntry<Block> EMISSION_CASING_HV = createEmissionCasing(GTValues.HV);
	public static final BlockEntry<Block> EMISSION_CASING_EV = createEmissionCasing(GTValues.EV);
	public static final BlockEntry<Block> EMISSION_CASING_IV = createEmissionCasing(GTValues.IV);
	public static final BlockEntry<Block> EMISSION_CASING_LuV = createEmissionCasing(GTValues.LuV);
	public static final BlockEntry<Block> EMISSION_CASING_ZPM = createEmissionCasing(GTValues.ZPM);
	public static final BlockEntry<Block> EMISSION_CASING_UV = createEmissionCasing(GTValues.UV);
	public static final BlockEntry<Block> EMISSION_CASING_UHV = createEmissionCasing(GTValues.UHV);
	public static final BlockEntry<Block> EMISSION_CASING_UEV = createEmissionCasing(GTValues.UEV);
	public static final BlockEntry<Block> EMISSION_CASING_UIV = createEmissionCasing(GTValues.UIV);
	public static final BlockEntry<Block> EMISSION_CASING_UXV = createEmissionCasing(GTValues.UXV);
	public static final BlockEntry<Block> EMISSION_CASING_OpV = createEmissionCasing(GTValues.OpV);
	public static final BlockEntry<Block> EMISSION_CASING_MAX = createEmissionCasing(GTValues.MAX);
	public static final List<BlockEntry<Block>> EMISSION_CASINGS = Arrays.asList(
		EMISSION_CASING_LV,
		EMISSION_CASING_MV,
		EMISSION_CASING_HV,
		EMISSION_CASING_EV,
		EMISSION_CASING_IV,
		EMISSION_CASING_LuV,
		EMISSION_CASING_ZPM,
		EMISSION_CASING_UV,
		EMISSION_CASING_UHV,
		EMISSION_CASING_UEV,
		EMISSION_CASING_UIV,
		EMISSION_CASING_UXV,
		EMISSION_CASING_OpV,
		EMISSION_CASING_MAX
	);
	
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
	public static @Nonnull BlockEntry<Block> createEmissionCasing(int tier) {
		String tierName = GTValues.VN[tier].toLowerCase(Locale.ROOT);
		var entry = UBER_REGISTRATE
			.block("%s_emission_casing".formatted(tierName), Block::new)
			.lang("%s High-Energy Emission Casing".formatted(GTValues.VN[tier]))
			.initialProperties(() -> Blocks.IRON_BLOCK)
			.properties(p -> p.isValidSpawn((state, level, pos, ent) -> false))
			.addLayer(() -> RenderType::cutoutMipped)
			.blockstate(Models.createEmissionCasingModel(tierName))
			.tag(CustomTags.MINEABLE_WITH_CONFIG_VALID_PICKAXE_WRENCH)
			.item(BlockItem::new)
			.build()
			.register();
		return entry;
	}
	
	public static void init() {
		LOGGER.info("Registering custom blocks");
		Method[] renderTypes = RenderType.class.getMethods();
		for (Method method : renderTypes) {LOGGER.info("Method: {}", method.getName());}
	}
}
