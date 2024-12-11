package com.daboxen.uberutilities.api;

import static com.daboxen.uberutilities.Uberutilities.LOGGER;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;
import com.lowdragmc.lowdraglib.gui.texture.ProgressTexture;

public class RecipeTypes {
	public static final GTRecipeType FIELD_EXCITER = GTRecipeTypes.register("field_exciter", GTRecipeTypes.MULTIBLOCK)
		.setMaxIOSize(1, 0, 0, 2)
		.setProgressBar(GuiTextures.PROGRESS_BAR_FUSION, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
		.setSound(GTSoundEntries.ELECTROLYZER)
		.setEUIO(IO.IN);
	
	public static void init() {
		LOGGER.info("Registering recipe types");
	}
}