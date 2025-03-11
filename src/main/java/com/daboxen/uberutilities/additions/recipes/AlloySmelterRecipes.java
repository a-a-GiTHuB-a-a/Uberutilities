package com.daboxen.uberutilities.additions.recipes;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.ALLOY_SMELTER_RECIPES;

import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import net.minecraft.data.recipes.FinishedRecipe;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public class AlloySmelterRecipes {
	public static void addRecipes(Consumer<FinishedRecipe> provider) {
		addMaterialRecipes(provider, new MaterialStack(Bronze, 8), new MaterialStack(Lead, 1), new MaterialStack(Potin, 9));
	}
	
	public static void addMaterialRecipes(Consumer<FinishedRecipe> provider, MaterialStack s1, MaterialStack s2, MaterialStack product) {
		Material mat1 = s1.material();
		Material mat2 = s2.material();
		Material matProd = product.material();
		int count1 = (int)s1.amount();
		int count2 = (int)s2.amount();
		int countProd = (int)product.amount();
		
		final String recipeNape = mat1.getName() + "_%s_and_" + mat2.getName() +
			"_%s_into_" + matProd.getName();
		
		String[] modes1;
		String[] modes2;
		
		if (mat1.hasProperty(PropertyKey.INGOT)) {
			modes1 = new String[]{"ingot", "dust"};
		} else {
			modes1 = new String[]{"dust"};
		}
		if (mat2.hasProperty(PropertyKey.INGOT)) {
			modes2 = new String[]{"ingot", "dust"};
		} else {
			modes2 = new String[]{"dust"};
		}
		
		for (@Nonnull String mode1 : modes1) {
			for (@Nonnull String mode2 : modes2) {
				TagPrefix pref1 = "dust".equals(mode1) ? TagPrefix.dust : TagPrefix.ingot;
				TagPrefix pref2 = "dust".equals(mode2) ? TagPrefix.dust : TagPrefix.ingot;
				
				ALLOY_SMELTER_RECIPES.recipeBuilder(String.format(recipeNape, mode1, mode2))
					.duration(countProd * 50).EUt(16)
					.inputItems(pref1, mat1, count1)
					.inputItems(pref2, mat2, count2)
					.outputItems(TagPrefix.ingot, matProd, countProd)
					.save(provider);
			}
		}
	}
}