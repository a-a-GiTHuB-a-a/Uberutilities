package com.daboxen.uberutilities;

import com.daboxen.uberutilities.additions.materials.Uberelements;
import com.daboxen.uberutilities.additions.recipes.NewRecipes;
import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

@GTAddon
public class UberGTAddon implements IGTAddon {
	@Override
	public GTRegistrate getRegistrate() {
		return Uberutilities.UBER_REGISTRATE;
	}

	@Override
	public void initializeAddon() {

	}

	@Override
	public void registerElements() {
		Uberelements.init();
	}

	@Override
	public String addonModId() {
		return Uberutilities.MOD_ID;
	}

	@Override
	public void registerTagPrefixes() {
		//CustomTagPrefixes.init();
	}

	@Override
	public void addRecipes(Consumer<FinishedRecipe> provider) {
		NewRecipes.addRecipes(provider);
	}
	
	// If you have custom ingredient types, uncomment this & change to match your capability.
	// KubeJS WILL REMOVE YOUR RECIPES IF THESE ARE NOT REGISTERED.
	/*
	public static final ContentJS<Double> PRESSURE_IN = new ContentJS<>(NumberComponent.ANY_DOUBLE, GregitasRecipeCapabilities.PRESSURE, false);
	public static final ContentJS<Double> PRESSURE_OUT = new ContentJS<>(NumberComponent.ANY_DOUBLE, GregitasRecipeCapabilities.PRESSURE, true);

	@Override
	public void registerRecipeKeys(KJSRecipeKeyEvent event) {
		event.registerKey(CustomRecipeCapabilities.PRESSURE, Pair.of(PRESSURE_IN, PRESSURE_OUT));
	}
	*/

	@Override
	public boolean requiresHighTier() {
		return true;
	}
}
