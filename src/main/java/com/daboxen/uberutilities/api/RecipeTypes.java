package com.daboxen.uberutilities.api;

import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.lowdragmc.lowdraglib.gui.texture.ProgressTexture;

public class RecipeTypes {
	public static final GTRecipeType FIELD_EXCITER = GTRecipeTypes.register("field_exciter", GTRecipeTypes.MULTIBLOCK)
		.setMaxIOSize(1, 0, 0, 2)
		.setProgressBar(GuiTextures.ATOMIC_OVERLAY_1, ProgressTexture.FillDirection.LEFT_TO_RIGHT);
	
	public static void init() {
		//h
	}
}