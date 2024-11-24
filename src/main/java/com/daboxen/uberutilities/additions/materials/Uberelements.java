package com.daboxen.uberutilities.additions;

import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.api.registry.GTRegistries;

public class Uberelements {
	public static void init() {}

	//thanks for the code! yoinked from cosmic core
	public static Element createAndRegisterElement(long protons, long neutrons, long halfLifeSeconds, String decayTo, String name, String symbol, boolean isIsotope) {
		Element element = new Element(protons, neutrons, halfLifeSeconds, decayTo, name, symbol, isIsotope);
		GTRegistries.ELEMENTS.register(name, element);
		return element;
	}

	public static final Element AntiNeutronium = createAndRegisterElement(0, 1000, -1, null, "anti_neutronium", "!Nt", false);
}