package com.daboxen.uberutilities.additions;

import com.daboxen.uberutilities.Überutilities;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.WireProperties;
import com.gregtechceu.gtceu.common.data.GTMaterials;

public class Übermaterials {
	public static void init() {}

	public static void modifyMaterials() {
		GTMaterials.Duranium.setProperty(PropertyKey.WIRE, new WireProperties((int)GTValues.V[GTValues.UHV], 4, 96));
        GTMaterials.Neutronium.addFlags(MaterialFlags.GENERATE_LONG_ROD, MaterialFlags.GENERATE_ROUND);
	}

	public static final Element ElementAntiNeutronium = new Element(0, -1000, -1, null, "anti_neutronium", "!Nt", false);

	public static final Material UpQuark = new Material.Builder(Überutilities.id("up_quark"))
		.gas(0)
		.color(0xff0000)
		.buildAndRegister();
	public static final Material AntiUpQuark = new Material.Builder(Überutilities.id("anti_up_quark"))
		.gas(0)
		.color(0xff0000)
		.buildAndRegister();
	public static final Material DownQuark = new Material.Builder(Überutilities.id("down_quark"))
		.gas(0)
		.color(0xff0000)
		.buildAndRegister();
	public static final Material AntiDownQuark = new Material.Builder(Überutilities.id("anti_down_quark"))
		.gas(0)
		.color(0xff0000)
		.buildAndRegister();
	public static final Material AntiNeutronium = new Material.Builder(Überutilities.id("anti_neutronium"))
		.element(ElementAntiNeutronium)
		.buildAndRegister();
}