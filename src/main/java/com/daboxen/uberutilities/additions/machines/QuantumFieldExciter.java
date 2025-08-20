package com.daboxen.uberutilities.additions.machines;

import com.daboxen.uberutilities.Uberutilities;
import static com.daboxen.uberutilities.Uberutilities.LOGGER;
import static com.daboxen.uberutilities.Uberutilities.UBER_REGISTRATE;
import com.daboxen.uberutilities.additions.items.Uberblocks;
import com.daboxen.uberutilities.api.RecipeTypes;
import com.daboxen.uberutilities.data.lang.LangHandler;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.api.recipe.OverclockingLogic;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import net.minecraft.network.chat.Component;

public class QuantumFieldExciter {
	public static final MultiblockMachineDefinition FIELD_EXCITER = UBER_REGISTRATE.multiblock("field_exciter", WorkableElectricMultiblockMachine::new)
		.rotationState(RotationState.ALL)
		.recipeType(RecipeTypes.FIELD_EXCITER)
		.recipeModifier(GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.create(1/3.6, OverclockingLogic.STD_VOLTAGE_FACTOR, true)))
		.appearanceBlock(Uberblocks.NEUTRONIUM_MACHINE_CASING)
		.pattern(definition -> FactoryBlockPattern.start()
			.aisle("         ", "         ", "  NNNNN  ", "  NNNNN  ", "  NNNNN  ", "  NNNNN  ", "  NNNNN  ", "         ", "         ")
			.aisle("         ", " NNNNNNN ", " NQQQQQN ", " NQQQQQN ", " NQQQQQN ", " NQQQQQN ", " NQQQQQN ", " NNNNNNN ", "         ")
			.aisle("  NNNNN  ", " NQQQQQN ", "NQ-----QN", "NQ-----QN", "NQ-----QN", "NQ-----QN", "NQ-----QN", " NQQQQQN ", "  NNNNN  ")
			.aisle("  NNNNN  ", " NQQQQQN ", "NQ-----QN", "NQ-----QN", "NQ-----QN", "NQ-----QN", "NQ-----QN", " NQQQQQN ", "  NNNNN  ")
			.aisle("  NNNNN  ", " NQQQQQN ", "NQ-----QN", "NQ-----QN", "NQ-----QN", "NQ-----QN", "NQ-----QN", " NQQQQQN ", "  NNNNN  ")
			.aisle("  NNNNN  ", " NQQQQQN ", "NQ-----QN", "NQ-----QN", "NQ-----QN", "NQ-----QN", "NQ-----QN", " NQQQQQN ", "  NNNNN  ")
			.aisle("  NNNNN  ", " NQQQQQN ", "NQ-----QN", "NQ-----QN", "NQ-----QN", "NQ-----QN", "NQ-----QN", " NQQQQQN ", "  NNNNN  ")
			.aisle("         ", " NNNNNNN ", " NQQQQQN ", " NQQQQQN ", " NQQQQQN ", " NQQQQQN ", " NQQQQQN ", " NNNNNNN ", "         ")
			.aisle("         ", "         ", "  NNNNN  ", "  NNNNN  ", "  NNNNN  ", "  NNMNN  ", "  NNNNN  ", "         ", "         ")
			.where('M', Predicates.controller(Predicates.blocks(definition.get())))
			.where('N', Predicates.blocks(Uberblocks.NEUTRONIUM_MACHINE_CASING.get())
				.or(Predicates.autoAbilities(RecipeTypes.FIELD_EXCITER))
			)
			.where('Q', Predicates.blocks(Uberblocks.NAQUADAH_MACHINE_CASING.get()))
			.where(' ', Predicates.any())
			.where('-', Predicates.air())
			.build()
		)
		.workableCasingModel(Uberutilities.id("block/casing/solid/neutronium_casing"), GTCEu.id("block/multiblock/fusion_reactor"))
		.tooltips(Component.translatable("machine.uberutilities.field_exciter.tooltip.0"))
		.langValue("Quantum Field Exciter")
		.register();
	
	public static void init() {
		LOGGER.info("Registering the QFE");
	}
}