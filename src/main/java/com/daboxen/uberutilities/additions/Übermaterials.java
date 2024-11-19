package com.daboxen.uberutilities.additions;

import com.daboxen.uberutilities.Überutilities;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.WireProperties;
import com.gregtechceu.gtceu.common.data.GTMaterials;

public class Übermaterials {
	public static Material UpQuark;
	public static Material AntiUpQuark;
	public static Material DownQuark;
	public static Material AntiDownQuark;

	public static Material AntiNeutronium;
	public static void init() {
		UpQuark = new Material.Builder(Überutilities.id("up_quark"))
			.gas(1)
			.color(0xff0000)
			.buildAndRegister();
		AntiUpQuark = new Material.Builder(Überutilities.id("anti_up_quark"))
			.gas(1)
			.color(0xff0000)
			.buildAndRegister();
		DownQuark = new Material.Builder(Überutilities.id("down_quark"))
			.gas(1)
			.color(0xff0000)
			.buildAndRegister();
		AntiDownQuark = new Material.Builder(Überutilities.id("anti_down_quark"))
			.gas(1)
			.color(0xff0000)
			.buildAndRegister();
		AntiNeutronium = new Material.Builder(Überutilities.id("anti_neutronium"))
			.element(Überelements.AntiNeutronium)
			.color(0x000000)
			.secondaryColor(0xffffff)
			.iconSet(MaterialIconSet.RADIOACTIVE)
			.ingot().fluid()
			.buildAndRegister();
	}

	public static void modifyMaterials() {
		GTMaterials.Duranium.setProperty(PropertyKey.WIRE, new WireProperties((int)GTValues.V[GTValues.UHV], 4, 96));
        GTMaterials.Neutronium.addFlags(MaterialFlags.GENERATE_LONG_ROD, MaterialFlags.GENERATE_ROUND);
	}
}