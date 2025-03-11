package com.daboxen.uberutilities.api;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Block;

public class CasingItem {
	public BlockEntry<Block> block;
	public Material frameMaterial;
	public Material plateMaterial;
	/**
	 * The GT tier of the casing.
	 */
	public int tier;
	
	/**
	 * Create a new `CasingItem`.
	 * @param block - The block that represents the `CasingItem`.
	 * @param frameMaterial - The material used for the frame-box in the recipe.
	 * @param plateMaterial - The material used for the plates in the recipe.
	 * @param tier - The tier of the casing, represented by a number (1 = LV, 2 = MV, etc.)
	 */
	public CasingItem(BlockEntry<Block> block, Material frameMaterial, Material plateMaterial, int tier) {
		this.block = block;
		this.frameMaterial = frameMaterial;
		this.plateMaterial = plateMaterial;
		this.tier = tier;
	}
	
	
}
