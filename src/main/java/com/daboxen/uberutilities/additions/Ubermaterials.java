package com.daboxen.uberutilities.additions;

import com.daboxen.uberutilities.Uberutilities;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.WireProperties;
import com.gregtechceu.gtceu.common.data.GTMaterials;

public class Ubermaterials {
	public static Material UpQuark;
	public static Material AntiUpQuark;
	public static Material DownQuark;
	public static Material AntiDownQuark;

	public static Material AntiNeutronium;
	public static void init() {
		IconSets.init();

		UpQuark = new Material.Builder(Uberutilities.id("up_quark"))
			.gas(1)
			.color(0xff0000)
			.buildAndRegister()
			.setFormula("u");
		AntiUpQuark = new Material.Builder(Uberutilities.id("anti_up_quark"))
			.gas(1)
			.color(0xff0000)
			.buildAndRegister()
			.setFormula("!u");
		DownQuark = new Material.Builder(Uberutilities.id("down_quark"))
			.gas(1)
			.color(0x0000ff)
			.buildAndRegister()
			.setFormula("d");
		AntiDownQuark = new Material.Builder(Uberutilities.id("anti_down_quark"))
			.gas(1)
			.color(0x0000ff)
			.buildAndRegister()
			.setFormula("!d");

		AntiNeutronium = new Material.Builder(Uberutilities.id("anti_neutronium"))
			.element(Uberelements.AntiNeutronium)
			.color(0x000000)
			.secondaryColor(0xffffff)
			.iconSet(IconSets.WHITE_OUTLINE)
			.ingot().liquid(100000)
			.buildAndRegister();
	}

	public static void modifyMaterials() {
		GTMaterials.Duranium.setProperty(PropertyKey.WIRE, new WireProperties((int)GTValues.V[GTValues.UHV], 4, 96));
        GTMaterials.Neutronium.addFlags(MaterialFlags.GENERATE_LONG_ROD, MaterialFlags.GENERATE_ROUND);
	}
}