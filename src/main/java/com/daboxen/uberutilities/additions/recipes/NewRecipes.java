package com.daboxen.uberutilities.additions.recipes;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class NewRecipes {
	public static void addRecipes(Consumer<FinishedRecipe> provider) {
		AlloySmelterRecipes.addRecipes(provider);
	}
}