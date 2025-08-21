package com.daboxen.uberutilities.api;

import com.daboxen.uberutilities.data.lang.LangHandler;
import static com.daboxen.uberutilities.Uberutilities.UBER_REGISTRATE;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.common.data.models.GTModels;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.tterrag.registrate.util.entry.BlockEntry;
import java.util.ArrayList;
import javax.annotation.Nonnull;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class CasingItem {
	public static ArrayList<CasingItem> casings = new ArrayList<>();
	private BlockEntry<Block> block;
	private String name;
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
		private final CasingItem item;
		
		public CasingItemBuilder(@Nonnull String id, @Nonnull ResourceLocation texture) {
			item = new CasingItem(UBER_REGISTRATE.block(id, Block::new)
				.initialProperties(() -> Blocks.IRON_BLOCK)
				.properties(p -> p.isValidSpawn((state, level, pos, ent) -> false))
				.addLayer(() -> RenderType::cutoutMipped)
				.exBlockstate(GTModels.cubeAllModel(texture))
				.tag(CustomTags.MINEABLE_WITH_CONFIG_VALID_PICKAXE_WRENCH)
				.item()
				.build()
				.register());
		}
		public CasingItemBuilder name(@Nonnull String name) {
			item.name = name;
			return this;
		}
		public CasingItem build() {
			casings.add(item);
			if (item.name != null) {
				LangHandler.addReplacementEntry(()->item.block.get().getDescriptionId(), item.name);
			}
			return item;
		}
	}
}