package com.daboxen.uberutilities.api;

import static com.daboxen.uberutilities.Uberutilities.UBER_REGISTRATE;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.tag.TagUtil;
import com.gregtechceu.gtceu.common.data.models.GTModels;
import com.tterrag.registrate.util.entry.BlockEntry;
import javax.annotation.Nonnull;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class CasingItem {
	private BlockEntry<Block> block;
	protected Material frameMaterial;
	protected Material plateMaterial;
	/**
	 * The GT tier of the casing.
	 */
	public int tier;
	
	/**
	 * Create a new `CasingItem`.
	 * @param block - The block that represents the `CasingItem`.
	 */
	public CasingItem(BlockEntry<Block> block) {
		this.block = block;
	}
	
	public BlockEntry<Block> getBlock() {
		return block;
	}
	
	public static class CasingItemBuilder {
		private CasingItem item;
		
		public CasingItemBuilder(@Nonnull String name, @Nonnull ResourceLocation texture) {
			item = new CasingItem(UBER_REGISTRATE.block(name, Block::new)
				.initialProperties(() -> Blocks.IRON_BLOCK)
				.properties(p -> p.isValidSpawn((state, level, pos, ent) -> false))
				.addLayer(() -> RenderType::cutoutMipped)
				.exBlockstate(GTModels.cubeAllModel(texture))
				.tag(TagUtil.createBlockTag("mineable/wrench", false))
				.item()
				.build()
				.register());
		}
		public CasingItem build() {
			return item;
		}
	}
}
