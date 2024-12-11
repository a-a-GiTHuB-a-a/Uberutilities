package com.daboxen.uberutilities.additions.materials;

import com.daboxen.uberutilities.Uberutilities;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.FluidPipeProperties;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.WireProperties;
import com.gregtechceu.gtceu.api.data.chemical.material.registry.MaterialRegistry;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.common.data.GTMaterials;

public class Ubermaterials {
	public static Material UpQuark;
	public static Material AntiUpQuark;
	public static Material DownQuark;
	public static Material AntiDownQuark;

	public static Material AntiNeutronium;

	public static Material Amogusium;

	public static final PropertyKey<ExtendedFluidPipeProperties> EXTENDED_FLUID_PIPE = new PropertyKey<>("extended_fluid_pipe", ExtendedFluidPipeProperties.class);
	
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
			.ingot().liquid(500).plasma(1000000)
			.buildAndRegister();
	}

	public static void modifyMaterials() {
		GTMaterials.Duranium.setProperty(PropertyKey.WIRE, new WireProperties((int)GTValues.V[GTValues.UHV], 4, 96));
        GTMaterials.Neutronium.addFlags(MaterialFlags.GENERATE_LONG_ROD, MaterialFlags.GENERATE_ROUND);

		//TODO: uncomment once my PR is merged
		for (MaterialRegistry registry : GTCEuAPI.materialManager.getRegistries()) {
			for (Material material : registry.getAllMaterials()) {
				if (material.hasProperty(PropertyKey.FLUID_PIPE)) {
					FluidPipeProperties oldProp = material.getProperty(PropertyKey.FLUID_PIPE);
					material.getProperties().removeProperty(PropertyKey.FLUID_PIPE);
					ExtendedFluidPipeProperties newProp = new ExtendedFluidPipeProperties(
						oldProp.getMaxFluidTemperature(),
						oldProp.getThroughput(),
						oldProp.isGasProof(),
						oldProp.isAcidProof(),
						oldProp.isCryoProof(),
						oldProp.isPlasmaProof(),
						false,
						oldProp.getChannels()
					);
					material.setProperty(EXTENDED_FLUID_PIPE, newProp);
				}
			}
		}
		
		GTMaterials.NaquadahAlloy.getProperty(EXTENDED_FLUID_PIPE).setAntimatterProof(true);
	}
}