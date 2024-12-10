package com.daboxen.uberutilities.additions.items.circuits;

import com.gregtechceu.gtceu.api.GTValues;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class CircuitLanguageProvider extends LanguageProvider {
	private CircuitType type;

	CircuitLanguageProvider(PackOutput output, String mod_id, String lang, CircuitType type) {
		super(output, mod_id, lang);
	}

	@Override
	protected void addTranslations() {
		this.add(
			String.format("item.uberutilities.%s_processor.tooltip.0", type.name.toLowerCase()),
			type.descriptions[0]
		);
		this.add(
			String.format("item.uberutilities.%s_processor.tooltip.1", type.name.toLowerCase()),
			String.format("§%c%s-Tier Circuit§r", type.color, GTValues.VN[type.tier])
		);

		this.add(
			String.format("item.uberutilities.%s_processor_assembly.tooltip.0", type.name.toLowerCase()),
			type.descriptions[1]
		);
		this.add(
			String.format("item.uberutilities.%s_processor_assembly.tooltip.1", type.name.toLowerCase()),
			String.format("§%c%s-Tier Circuit§r", type.color, GTValues.VN[type.tier + 1])
		);

		this.add(
			String.format("item.uberutilities.%s_processor_computer.tooltip.0", type.name.toLowerCase()),
			type.descriptions[2]
		);
		this.add(
			String.format("item.uberutilities.%s_processor_computer.tooltip.1", type.name.toLowerCase()),
			String.format("§%c%s-Tier Circuit§r", type.color, GTValues.VN[type.tier + 2])
		);

		this.add(
			String.format("item.uberutilities.%s_processor_mainframe.tooltip.0", type.name.toLowerCase()),
			type.descriptions[3]
		);
		this.add(
			String.format("item.uberutilities.%s_processor_mainframe.tooltip.1", type.name.toLowerCase()),
			String.format("§%c%s-Tier Circuit§r", type.color, GTValues.VN[type.tier + 3])
		);
	}
}
