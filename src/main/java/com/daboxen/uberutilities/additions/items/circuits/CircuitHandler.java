package com.daboxen.uberutilities.additions.items.circuits;

import com.gregtechceu.gtceu.api.GTValues;

public class CircuitHandler {
	public static CircuitType NEUTRINO = new CircuitType(GTValues.ZPM, 'i', "Neutrino");

	public static void registerItems() {
		NEUTRINO.registerItems();
	}
}