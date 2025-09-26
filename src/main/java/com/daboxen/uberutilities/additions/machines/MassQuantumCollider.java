package com.daboxen.uberutilities.additions.machines;

import com.daboxen.uberutilities.Uberutilities;
import com.daboxen.uberutilities.additions.items.Uberblocks;
import com.daboxen.uberutilities.api.RecipeTypes;
import static com.daboxen.uberutilities.Uberutilities.LOGGER;
import static com.daboxen.uberutilities.Uberutilities.UBER_REGISTRATE;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.api.recipe.OverclockingLogic;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMachines;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import net.minecraft.network.chat.Component;

public class MassQuantumCollider {
	public static final MultiblockMachineDefinition MASS_COLLIDER = UBER_REGISTRATE.multiblock("field_exciter", WorkableElectricMultiblockMachine::new)
		.rotationState(RotationState.ALL)
		.recipeType(RecipeTypes.MASS_COLLIDER)
		.recipeModifier(GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.create(1/3.6, OverclockingLogic.STD_VOLTAGE_FACTOR, true)))
		.appearanceBlock(Uberblocks.NEUTRONIUM_MACHINE_CASING)
		//spotless:off
		.pattern(definition -> FactoryBlockPattern.start()
			.aisle("                     ", "                     ", "                     ", "                     ", "                     ", "                     ", "                     ", "                     ", "        BBBBB        ", "        BBBBB        ", "        BBEBB        ", "        BBBBB        ", "        BBBBB        ", "                     ", "                     ", "                     ", "                     ", "                     ", "                     ", "                     ", "                     ")
			.aisle("                     ", "                     ", "                     ", "                     ", "                     ", "                     ", "        NNNNN        ", "        NNNNN        ", "      NNQQQQQNN      ", "      NNQQQQQNN      ", "      NNQQSQQNN      ", "      NNQQQQQNN      ", "      NNQQQQQNN      ", "        NNNNN        ", "        NNNNN        ", "                     ", "                     ", "                     ", "                     ", "                     ", "                     ")
			.aisle("                     ", "                     ", "                     ", "                     ", "        NNNNN        ", "        NNNNN        ", "      NNQQQQQNN      ", "      NNQQQQQNN      ", "    NNQQ-----QQNN    ", "    NNQQ--F--QQNN    ", "    NNQQ-FSF-QQNN    ", "    NNQQ--F--QQNN    ", "    NNQQ-----QQNN    ", "      NNQQQQQNN      ", "      NNQQQQQNN      ", "        NNNNN        ", "        NNNNN        ", "                     ", "                     ", "                     ", "                     ")
			.aisle("                     ", "                     ", "                     ", "        NNNNN        ", "      NNQQQQQNN      ", "      NNQQQQQNN      ", "    NNQQ-----QQNN    ", "    NNQQ-----QQNN    ", "   NQQ---------QQN   ", "   NQQ----F----QQN   ", "   NQQ---FSF---QQN   ", "   NQQ----F----QQN   ", "   NQQ---------QQN   ", "    NNQQ-----QQNN    ", "    NNQQ-----QQNN    ", "      NNQQQQQNN      ", "      NNQQQQQNN      ", "        NNNNN        ", "                     ", "                     ", "                     ")
			.aisle("                     ", "                     ", "        NNNNN        ", "      NNQQQQQNN      ", "     NQQ-----QQN     ", "    NNQQ-----QQNN    ", "   NQQ---------QQN   ", "   NQQ---------QQN   ", "  NQ-------------QN  ", "  NQ------F------QN  ", "  NQ-----FSF-----QN  ", "  NQ------F------QN  ", "  NQ-------------QN  ", "   NQQ---------QQN   ", "   NQQ---------QQN   ", "    NNQQ-----QQNN    ", "     NQQ-----QQN     ", "      NNQQQQQNN      ", "        NNNNN        ", "                     ", "                     ")
			.aisle("                     ", "                     ", "        NNNNN        ", "      NNQQQQQNN      ", "    NNQQ-----QQNN    ", "    NQ---------QN    ", "   NQ-----------QN   ", "   NQ-----------QN   ", "  NQ-------------QN  ", "  NQ------F------QN  ", "  NQ-----FSF-----QN  ", "  NQ------F------QN  ", "  NQ-------------QN  ", "   NQ-----------QN   ", "   NQ-----------QN   ", "    NQ---------QN    ", "    NNQQ-----QQNN    ", "      NNQQQQQNN      ", "        NNNNN        ", "                     ", "                     ")
			.aisle("                     ", "        NNNNN        ", "      NNQQQQQNN      ", "    NNQQ-----QQNN    ", "   NQQ---------QQN   ", "   NQ-----------QN   ", "  NQ-------------QN  ", "  NQ-------------QN  ", " NQ---------------QN ", " NQ-------F-------QN ", " NQ------FSF------QN ", " NQ-------F-------QN ", " NQ---------------QN ", "  NQ-------------QN  ", "  NQ-------------QN  ", "   NQ-----------QN   ", "   NQQ---------QQN   ", "    NNQQ-----QQNN    ", "      NNQQQQQNN      ", "        NNNNN        ", "                     ")
			.aisle("                     ", "        NNNNN        ", "      NNQQQQQNN      ", "    NNQQ-----QQNN    ", "   NQQ---------QQN   ", "   NQ-----------QN   ", "  NQ-------------QN  ", "  NQ-------------QN  ", " NQ---------------QN ", " NQ---------------QN ", " NQ-------S-------QN ", " NQ---------------QN ", " NQ---------------QN ", "  NQ-------------QN  ", "  NQ-------------QN  ", "   NQ-----------QN   ", "   NQQ---------QQN   ", "    NNQQ-----QQNN    ", "      NNQQQQQNN      ", "        NNNNN        ", "                     ")
			.aisle("        NNNNN        ", "      NNQQQQQNN      ", "    NNQQ-----QQNN    ", "   NQQ---------QQN   ", "  NQ-------------QN  ", "  NQ-------------QN  ", " NQ---------------QN ", " NQ---------------QN ", "NQ-----------------QN", "NQ-----------------QN", "NQ--------S--------QN", "NQ-----------------QN", "NQ-----------------QN", " NQ---------------QN ", " NQ---------------QN ", "  NQ-------------QN  ", "  NQ-------------QN  ", "   NQQ---------QQN   ", "    NNQQ-----QQNN    ", "      NNQQQQQNN      ", "        NNNNN        ")
			.aisle("        NNNNN        ", "      NNQQQQQNN      ", "    NNQQ--F--QQNN    ", "   NQQ----F----QQN   ", "  NQ------F------QN  ", "  NQ------F------QN  ", " NQ-------F-------QN ", " NQ---------------QN ", "NQ-----------------QN", "NQ-----------------QN", "NQFFFFF---K---FFFFFQN", "NQ-----------------QN", "NQ-----------------QN", " NQ---------------QN ", " NQ-------F-------QN ", "  NQ------F------QN  ", "  NQ------F------QN  ", "   NQQ----F----QQN   ", "    NNQQ--F--QQNN    ", "      NNQQQQQNN      ", "        NNNNN        ")
			.aisle("        NNHNN        ", "      NNQQIQQNN      ", "    NNQQ-FIF-QQNN    ", "   NQQ---FIF---QQN   ", "  NQ-----FIF-----QN  ", "  NQ-----FIF-----QN  ", " NQ------FIF------QN ", " NQ-------I-------QN ", "NQ--------I--------QN", "NQFFFFF---P---FFFFFQN", "HGGGGGGGGP-PGGGGGGGGH", "NQFFFFF---P---FFFFFQN", "NQ--------I--------QN", " NQ-------I-------QN ", " NQ------FIF------QN ", "  NQ-----FIF-----QN  ", "  NQ-----FIF-----QN  ", "   NQQ---FIF---QQN   ", "    NNQQ-FIF-QQNN    ", "      NNQQIQQNN      ", "        NNHNN        ")
			.aisle("        NNNNN        ", "      NNQQQQQNN      ", "    NNQQ--F--QQNN    ", "   NQQ----F----QQN   ", "  NQ------F------QN  ", "  NQ------F------QN  ", " NQ-------F-------QN ", " NQ---------------QN ", "NQ-----------------QN", "NQ-----------------QN", "NQFFFFF---Q---FFFFFQN", "NQ-----------------QN", "NQ-----------------QN", " NQ---------------QN ", " NQ-------F-------QN ", "  NQ------F------QN  ", "  NQ------F------QN  ", "   NQQ----F----QQN   ", "    NNQQ--F--QQNN    ", "      NNQQQQQNN      ", "        NNNNN        ")
			.aisle("        NNNNN        ", "      NNQQQQQNN      ", "    NNQQ-----QQNN    ", "   NQQ---------QQN   ", "  NQ-------------QN  ", "  NQ-------------QN  ", " NQ---------------QN ", " NQ---------------QN ", "NQ-----------------QN", "NQ-----------------QN", "NQ-----------------QN", "NQ-----------------QN", "NQ-----------------QN", " NQ---------------QN ", " NQ---------------QN ", "  NQ-------------QN  ", "  NQ-------------QN  ", "   NQQ---------QQN   ", "    NNQQ-----QQNN    ", "      NNQQQQQNN      ", "        NNNNN        ")
			.aisle("                     ", "        NNNNN        ", "      NNQQQQQNN      ", "    NNQQ-----QQNN    ", "   NQQ---------QQN   ", "   NQ-----------QN   ", "  NQ-------------QN  ", "  NQ-------------QN  ", " NQ---------------QN ", " NQ---------------QN ", " NQ---------------QN ", " NQ---------------QN ", " NQ---------------QN ", "  NQ-------------QN  ", "  NQ-------------QN  ", "   NQ-----------QN   ", "   NQQ---------QQN   ", "    NNQQ-----QQNN    ", "      NNQQQQQNN      ", "        NNNNN        ", "                     ")
			.aisle("                     ", "        NNNNN        ", "      NNQQQQQNN      ", "    NNQQ-----QQNN    ", "   NQQ---------QQN   ", "   NQ-----------QN   ", "  NQ-------------QN  ", "  NQ-------------QN  ", " NQ---------------QN ", " NQ---------------QN ", " NQ---------------QN ", " NQ---------------QN ", " NQ---------------QN ", "  NQ-------------QN  ", "  NQ-------------QN  ", "   NQ-----------QN   ", "   NQQ---------QQN   ", "    NNQQ-----QQNN    ", "      NNQQQQQNN      ", "        NNNNN        ", "                     ")
			.aisle("                     ", "                     ", "        NNNNN        ", "      NNQQQQQNN      ", "    NNQQ-----QQNN    ", "    NQ---------QN    ", "   NQ-----------QN   ", "   NQ-----------QN   ", "  NQ-------------QN  ", "  NQ-------------QN  ", "  NQ-------------QN  ", "  NQ-------------QN  ", "  NQ-------------QN  ", "   NQ-----------QN   ", "   NQ-----------QN   ", "    NQ---------QN    ", "    NNQQ-----QQNN    ", "      NNQQQQQNN      ", "        NNNNN        ", "                     ", "                     ")
			.aisle("                     ", "                     ", "        NNNNN        ", "      NNQQQQQNN      ", "     NQQ-----QQN     ", "    NNQQ-----QQNN    ", "   NQQ---------QQN   ", "   NQQ---------QQN   ", "  NQ-------------QN  ", "  NQ-------------QN  ", "  NQ-------------QN  ", "  NQ-------------QN  ", "  NQ-------------QN  ", "   NQQ---------QQN   ", "   NQQ---------QQN   ", "    NNQQ-----QQNN    ", "     NQQ-----QQN     ", "      NNQQQQQNN      ", "        NNNNN        ", "                     ", "                     ")
			.aisle("                     ", "                     ", "                     ", "        NNNNN        ", "      NNQQQQQNN      ", "      NNQQQQQNN      ", "    NNQQ-----QQNN    ", "    NNQQ-----QQNN    ", "   NQQ---------QQN   ", "   NQQ---------QQN   ", "   NQQ---------QQN   ", "   NQQ---------QQN   ", "   NQQ---------QQN   ", "    NNQQ-----QQNN    ", "    NNQQ-----QQNN    ", "      NNQQQQQNN      ", "      NNQQQQQNN      ", "        NNNNN        ", "                     ", "                     ", "                     ")
			.aisle("                     ", "                     ", "                     ", "                     ", "        NNNNN        ", "        NNNNN        ", "      NNQQQQQNN      ", "      NNQQQQQNN      ", "    NNQQ-----QQNN    ", "    NNQQ-----QQNN    ", "    NNQQ-----QQNN    ", "    NNQQ-----QQNN    ", "    NNQQ-----QQNN    ", "      NNQQQQQNN      ", "      NNQQQQQNN      ", "        NNNNN        ", "        NNNNN        ", "                     ", "                     ", "                     ", "                     ")
			.aisle("                     ", "                     ", "                     ", "                     ", "                     ", "                     ", "        NNNNN        ", "        NNNNN        ", "      NNQQQQQNN      ", "      NNQQQQQNN      ", "      NNQQQQQNN      ", "      NNQQQQQNN      ", "      NNQQQQQNN      ", "        NNNNN        ", "        NNNNN        ", "                     ", "                     ", "                     ", "                     ", "                     ", "                     ")
			.aisle("                     ", "                     ", "                     ", "                     ", "                     ", "                     ", "                     ", "                     ", "        NNNNN        ", "        NNNNN        ", "        NNCNN        ", "        NNNNN        ", "        NNNNN        ", "                     ", "                     ", "                     ", "                     ", "                     ", "                     ", "                     ", "                     ")
			.where(" ", Predicates.any())
			.where("-", Predicates.air())
			.where("C", Predicates.controller(Predicates.blocks(definition.get())))
			.where("E", Predicates.abilities(PartAbility.INPUT_ENERGY))
			.where("H", Predicates.abilities(PartAbility.EXPORT_FLUIDS_1X))
			.where("N", Predicates.blocks(Uberblocks.NEUTRONIUM_MACHINE_CASING.get()).or(Predicates.autoAbilities(true, false, false)))
			.where("Q", Predicates.blocks(Uberblocks.NAQUADAH_MACHINE_CASING.get()))
			.where("F", Predicates.blocks(ChemicalHelper.getBlock(TagPrefix.frameGt, NaquadahAlloy)))
			.where("G", Predicates.blocks(Uberblocks.HTP_ANTIMATTER_PIPE.get()))
			.where("I", Predicates.blocks(Uberblocks.HTP_MATTER_PIPE.get()))
			.where("P", Predicates.blocks(Uberblocks.HTP_PUMP.get()))
			.where("S", Predicates.blocks(GTBlocks.SUPERCONDUCTING_COIL.get()))
			.where("K", Predicates.heatingCoils())
			.where("B", Predicates.blocks(Uberblocks.NEUTRONIUM_MACHINE_CASING.get()).or(Predicates.blocks(GTMachines.ITEM_IMPORT_BUS[GTValues.ULV].get()).setExactLimit(1)))
			.build()
		)
		//spotless:on
		.workableCasingModel(Uberutilities.id("block/casing/solid/neutronium_casing"), GTCEu.id("block/multiblock/fusion_reactor"))
		.tooltips(Component.translatable("machine.uberutilities.mass_collider.tooltip.0"))
		.langValue("Mass Quantum Collider")
		.register();
	
	public static void init() {
		LOGGER.info("Registering the MQC");
	}
}