package com.daboxen.uberutilities.additions.items.circuits;

import com.gregtechceu.gtceu.api.GTValues;
import net.minecraftforge.data.event.GatherDataEvent;

public class CircuitHandler {
	public static CircuitType NEUTRINO = new CircuitType(GTValues.ZPM, 'i', "Neutrino", new String[]{
		"Possibly Picoscopic!",
		"Practically Impractical",
		"Probably Carcinogenic",
		"Plainly Puny"
	});

	public static void registerItems() {
		NEUTRINO.registerItems();
	}

	public static void gatherData(GatherDataEvent event) {
		NEUTRINO.gatherData(event);
	}
}