package com.daboxen.uberutilities.additions.items.circuits;

import com.daboxen.uberutilities.Uberutilities;
import com.gregtechceu.gtceu.api.GTValues;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.tags.ITagManager;

public class CircuitType {
	int tier;
	char color;
	String name;
	
	ItemEntry<Item> PROCESSOR;
	ItemEntry<Item> ASSEMBLY;
	ItemEntry<Item> COMPUTER;
	ItemEntry<Item> MAINFRAME;

	public CircuitType(int tier, char color, String name) {
		this.tier = tier;
		this.color = color;
		this.name = name;
	}

	private TagKey<Item> getTag(int tier) {
		ITagManager<Item> tagManager = ForgeRegistries.ITEMS.tags();
		return tagManager.createTagKey(new ResourceLocation("gtceu:circuits/" + GTValues.VN[tier].toLowerCase()));
	}

	public void registerItems() {
		PROCESSOR = Uberutilities.UBER_REGISTRATE.item(String.format("%s_processor", this.name.toLowerCase()), Item::new)
			.lang(String.format("%s Processor", this.name))
			.tag(getTag(tier))
			.defaultModel()
			.register();

		ASSEMBLY = Uberutilities.UBER_REGISTRATE.item(String.format("%s_processor_assembly", this.name.toLowerCase()), Item::new)
			.lang(String.format("%s Processor Assembly", this.name))	
			.tag(getTag(tier+1))
			.defaultModel()
			.register();

		COMPUTER = Uberutilities.UBER_REGISTRATE.item(String.format("%s_processor_computer", this.name.toLowerCase()), Item::new)
			.lang(String.format("%s Processor Computer", this.name))	
			.tag(getTag(tier+2))
			.defaultModel()
			.register();

		MAINFRAME = Uberutilities.UBER_REGISTRATE.item(String.format("%s_processor_mainframe", this.name.toLowerCase()), Item::new)
			.lang(String.format("%s Processor Mainframe", this.name))	
			.tag(getTag(tier+3))
			.defaultModel()
			.register();
	}
}