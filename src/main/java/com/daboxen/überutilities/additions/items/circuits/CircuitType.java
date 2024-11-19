package com.daboxen.überutilities.additions.items.circuits;

import com.daboxen.überutilities.Überutilities;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.data.recipe.CustomTags;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent.RegisterHelper;
import net.minecraftforge.registries.tags.ITagManager;

public class CircuitType {
	int tier;
	char color;
	String name;
	String[] descriptions;

	CircuitType(int tier, char color, String name, String[] descriptions) {
		this.tier = tier;
		this.color = color;
		this.name = name;
		this.descriptions = descriptions;
	}

	private TagKey<Item> getTag(int tier) {
		ITagManager<Item> tagManager = ForgeRegistries.ITEMS.tags();
		return tagManager.createTagKey(new ResourceLocation("gtceu:circuits/" + GTValues.VN[tier].toLowerCase()));
	}

	public void registerItems() {
		Überutilities.ÜBER_REGISTRATE.item(String.format("%s_processor", this.name.toLowerCase()), Item::new)
			.tag(getTag(tier))
			.register();
	}

	public void gatherData(GatherDataEvent event) {
		event.getGenerator().addProvider(
			// Tell generator to run only when client assets are generating
			event.includeClient(),
			// Localizations for American English
			output -> new CircuitLanguageProvider(output, Überutilities.MOD_ID, "en_us", this)
		);
	}
}