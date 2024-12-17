package com.daboxen.uberutilities.additions.materials;

import com.daboxen.uberutilities.Uberutilities;
import com.daboxen.uberutilities.api.ExtendedFluidAttributes;
import com.daboxen.uberutilities.api.IconSets;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.FluidProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.IMaterialProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.WireProperties;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import java.util.function.UnaryOperator;

public class Ubermaterials {
	public static Material UpQuark;
	public static Material AntiUpQuark;
	public static Material DownQuark;
	public static Material AntiDownQuark;

	public static Material AntiNeutronium;

	public static Material Amogusium;
	
	public static void init() {
		IconSets.init();

		UpQuark = new Material.Builder(Uberutilities.id("up_quark"))
			.gas(0)
			.color(0xff0000)
			.buildAndRegister()
			.setFormula("u");
		AntiUpQuark = new Material.Builder(Uberutilities.id("anti_up_quark"))
			.gas(new FluidBuilder().attribute(ExtendedFluidAttributes.ANTIMATTER).temperature(0))
			.color(0xff0000)
			.buildAndRegister()
			.setFormula("!u");
		DownQuark = new Material.Builder(Uberutilities.id("down_quark"))
			.gas(0)
			.color(0x0000ff)
			.buildAndRegister()
			.setFormula("d");
		AntiDownQuark = new Material.Builder(Uberutilities.id("anti_down_quark"))
		.gas(new FluidBuilder().attribute(ExtendedFluidAttributes.ANTIMATTER).temperature(0))
			.color(0x0000ff)
			.buildAndRegister()
			.setFormula("!d");

		AntiNeutronium = new Material.Builder(Uberutilities.id("anti_neutronium"))
			.element(Uberelements.AntiNeutronium)
			.color(0xff0000/*0x000000*/)//temp
			.secondaryColor(0xffffff)
			.iconSet(IconSets.WHITE_OUTLINE)
			.ingot().liquid(new FluidBuilder().attribute(ExtendedFluidAttributes.ANTIMATTER).temperature(100000))
			.buildAndRegister();

		Amogusium = new Material.Builder(Uberutilities.id("amogusium"))
			.element(Uberelements.Amogusium)
			.color(0xff0000)
			.secondaryColor(0x7fbfff)
			.iconSet(IconSets.SUS)
			.ingot().liquid(12000).plasma(1000000)
			.buildAndRegister();
	}
	
	public static <T extends IMaterialProperty> void modifyMaterialProperty(Material material, PropertyKey<T> key, UnaryOperator<T> modifier) {
		T prop = material.getProperty(key);
		material.getProperties().removeProperty(key);
		prop = modifier.apply(prop);
		material.setProperty(key, prop);
	}

	public static void modifyMaterials() {
		GTMaterials.Duranium.setProperty(PropertyKey.WIRE, new WireProperties((int)GTValues.V[GTValues.UHV], 4, 96));
        GTMaterials.Neutronium.addFlags(MaterialFlags.GENERATE_LONG_ROD, MaterialFlags.GENERATE_ROUND);
		
		modifyMaterialProperty(GTMaterials.Naquadah, PropertyKey.FLUID_PIPE, (pipe) -> {
			pipe.setCanContain(ExtendedFluidAttributes.ANTIMATTER, true);
			return pipe;
		});
	}
}