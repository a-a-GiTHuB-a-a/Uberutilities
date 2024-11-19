package com.daboxen.überutilities.additions.items.circuits;

import com.daboxen.überutilities.Überutilities;
import com.gregtechceu.gtceu.api.GTValues;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.tags.ITagManager;

public class CircuitType {
	int tier;
	char color;
	String name;
	String[] descriptions;

	public CircuitType(int tier, char color, String name, String[] descriptions) {
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
			.lang(String.format("%s Processor", this.name))
			.tag(getTag(tier))
			.register();

		Überutilities.ÜBER_REGISTRATE.item(String.format("%s_processor_assembly", this.name.toLowerCase()), Item::new)
			.lang(String.format("%s Processor Assembly", this.name))	
			.tag(getTag(tier+1))
			.register();

		Überutilities.ÜBER_REGISTRATE.item(String.format("%s_processor_computer", this.name.toLowerCase()), Item::new)
			.lang(String.format("%s Processor Computer", this.name))	
			.tag(getTag(tier+2))
			.register();

		Überutilities.ÜBER_REGISTRATE.item(String.format("%s_processor_mainframe", this.name.toLowerCase()), Item::new)
			.lang(String.format("%s Processor Mainframe", this.name))	
			.tag(getTag(tier+3))
			.register();
	}

	public void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		
		generator.addProvider(
			// Tell generator to run only when client assets are generating
			event.includeClient(),
			// Localizations for American English
			new CircuitLanguageProvider(generator.getPackOutput(), Überutilities.MOD_ID, "en_us", this)
		);
	}
}