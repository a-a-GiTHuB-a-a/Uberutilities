package com.daboxen.uberutilities.additions.machines;

import com.daboxen.uberutilities.Uberutilities;
import com.daboxen.uberutilities.additions.items.Uberblocks;
import com.daboxen.uberutilities.api.RecipeTypes;
import static com.daboxen.uberutilities.Uberutilities.LOGGER;
import static com.daboxen.uberutilities.Uberutilities.UBER_REGISTRATE;
import com.gregtechceu.gtceu.GTCEu;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.api.recipe.OverclockingLogic;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.DyeColor;

public class QuantumFieldExciter {
	public static final MultiblockMachineDefinition FIELD_EXCITER = UBER_REGISTRATE.multiblock("field_exciter", WorkableElectricMultiblockMachine::new)
		.rotationState(RotationState.ALL)
		.recipeType(RecipeTypes.FIELD_EXCITER)
		.recipeModifier(GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.create(1/3.6, OverclockingLogic.STD_VOLTAGE_FACTOR, true)))
		.appearanceBlock(Uberblocks.NEUTRONIUM_MACHINE_CASING)
		//spotless:off
		.pattern(definition -> FactoryBlockPattern.start()
			.aisle("                     ", "                     ", "                     ", "                     ", "                     ", "                     ", "                     ", "                     ", "        NNNNN        ", "        NNNNN        ", "        NNNNN        ", "        NNNNN        ", "        NNNNN        ", "                     ", "                     ", "                     ", "                     ", "                     ", "                     ", "                     ", "                     ")
			.aisle("                     ", "                     ", "                     ", "                     ", "                     ", "                     ", "        NNNNN        ", "        NNNNN        ", "      NNQQQQQNN      ", "      NNQQQQQNN      ", "      NNQQQQQNN      ", "      NNQQQQQNN      ", "      NNQQQQQNN      ", "        NNNNN        ", "        NNNNN        ", "                     ", "                     ", "                     ", "                     ", "                     ", "                     ")
			.aisle("                     ", "                     ", "                     ", "                     ", "        NNNNN        ", "        NNNNN        ", "      NNQQQQQNN      ", "      NNQQQQQNN      ", "    NNQQ-----QQNN    ", "    NNQQ--D--QQNN    ", "    NNQQ-DKD-QQNN    ", "    NNQQ--D--QQNN    ", "    NNQQ-----QQNN    ", "      NNQQQQQNN      ", "      NNQQQQQNN      ", "        NNNNN        ", "        NNNNN        ", "                     ", "                     ", "                     ", "                     ")
			.aisle("                     ", "                     ", "                     ", "        NNNNN        ", "      NNQQQQQNN      ", "      NNQQQQQNN      ", "    NNQQ-----QQNN    ", "    NNQQ-----QQNN    ", "   NQQ---------QQN   ", "   NQQ----D----QQN   ", "   NQQ---DKD---QQN   ", "   NQQ----D----QQN   ", "   NQQ---------QQN   ", "    NNQQ-----QQNN    ", "    NNQQ-----QQNN    ", "      NNQQQQQNN      ", "      NNQQQQQNN      ", "        NNNNN        ", "                     ", "                     ", "                     ")
			.aisle("                     ", "                     ", "        NNNNN        ", "      NNQQQQQNN      ", "     NQQ-----QQN     ", "    NNQQ-----QQNN    ", "   NQQ---------QQN   ", "   NQQ---------QQN   ", "  NQ-------------QN  ", "  NQ------D------QN  ", "  NQ-----DKD-----QN  ", "  NQ------D------QN  ", "  NQ-------------QN  ", "   NQQ---------QQN   ", "   NQQ---------QQN   ", "    NNQQ-----QQNN    ", "     NQQ-----QQN     ", "      NNQQQQQNN      ", "        NNNNN        ", "                     ", "                     ")
			.aisle("                     ", "                     ", "        NNNNN        ", "      NNQQQQQNN      ", "    NNQQ-----QQNN    ", "    NQ---------QN    ", "   NQ-----------QN   ", "   NQ-----------QN   ", "  NQ-------------QN  ", "  NQ------D------QN  ", "  NQ-----DKD-----QN  ", "  NQ------D------QN  ", "  NQ-------------QN  ", "   NQ-----------QN   ", "   NQ-----------QN   ", "    NQ---------QN    ", "    NNQQ-----QQNN    ", "      NNQQQQQNN      ", "        NNNNN        ", "                     ", "                     ")
			.aisle("                     ", "        NNNNN        ", "      NNQQQQQNN      ", "    NNQQ-----QQNN    ", "   NQQ---------QQN   ", "   NQ-----------QN   ", "  NQ-------------QN  ", "  NQ-------------QN  ", " NQ---------------QN ", " NQ-------D-------QN ", " NQ------DKD------QN ", " NQ-------D-------QN ", " NQ---------------QN ", "  NQ-------------QN  ", "  NQ-------------QN  ", "   NQ-----------QN   ", "   NQQ---------QQN   ", "    NNQQ-----QQNN    ", "      NNQQQQQNN      ", "        NNNNN        ", "                     ")
			.aisle("                     ", "        NNNNN        ", "      NNQQQQQNN      ", "    NNQQ-----QQNN    ", "   NQQ---------QQN   ", "   NQ-----------QN   ", "  NQ-------------QN  ", "  NQ-------------QN  ", " NQ---------------QN ", " NQ---------------QN ", " NQ-------K-------QN ", " NQ---------------QN ", " NQ---------------QN ", "  NQ-------------QN  ", "  NQ-------------QN  ", "   NQ-----------QN   ", "   NQQ---------QQN   ", "    NNQQ-----QQNN    ", "      NNQQQQQNN      ", "        NNNNN        ", "                     ")
			.aisle("        NNNNN        ", "      NNQQQQQNN      ", "    NNQQ-----QQNN    ", "   NQQ---------QQN   ", "  NQ-------------QN  ", "  NQ-------------QN  ", " NQ---------------QN ", " NQ---------------QN ", "NQ-----------------QN", "NQ-----------------QN", "NQ--------K--------QN", "NQ-----------------QN", "NQ-----------------QN", " NQ---------------QN ", " NQ---------------QN ", "  NQ-------------QN  ", "  NQ-------------QN  ", "   NQQ---------QQN   ", "    NNQQ-----QQNN    ", "      NNQQQQQNN      ", "        NNNNN        ")
			.aisle("        NNNNN        ", "      NNQQQQQNN      ", "    NNQQ--D--QQNN    ", "   NQQ----D----QQN   ", "  NQ------D------QN  ", "  NQ------D------QN  ", " NQ-------D-------QN ", " NQ---------------QN ", "NQ-----------------QN", "NQ-----------------QN", "NQDDDDD---H---DDDDDQN", "NQ-----------------QN", "NQ-----------------QN", " NQ---------------QN ", " NQ-------D-------QN ", "  NQ------D------QN  ", "  NQ------D------QN  ", "   NQQ----D----QQN   ", "    NNQQ--D--QQNN    ", "      NNQQQQQNN      ", "        NNNNN        ")
			.aisle("        NNNNN        ", "      NNQQQQQNN      ", "    NNQQ-DED-QQNN    ", "   NQQ---DED---QQN   ", "  NQ-----DED-----QN  ", "  NQ-----DED-----QN  ", " NQ------DED------QN ", " NQ-------I-------QN ", "NQ--------I--------QN", "NQDDDDD---H---DDDDDQN", "NQEEEEEGGH-HGGEEEEEQN", "NQDDDDD---H---DDDDDQN", "NQ--------I--------QN", " NQ-------I-------QN ", " NQ------DED------QN ", "  NQ-----DED-----QN  ", "  NQ-----DED-----QN  ", "   NQQ---DED---QQN   ", "    NNQQ-DED-QQNN    ", "      NNQQQQQNN      ", "        NNNNN        ")
			.aisle("        NNNNN        ", "      NNQQQQQNN      ", "    NNQQ--D--QQNN    ", "   NQQ----D----QQN   ", "  NQ------D------QN  ", "  NQ------D------QN  ", " NQ-------D-------QN ", " NQ---------------QN ", "NQ-----------------QN", "NQ-----------------QN", "NQDDDDD-------DDDDDQN", "NQ-----------------QN", "NQ-----------------QN", " NQ---------------QN ", " NQ-------D-------QN ", "  NQ------D------QN  ", "  NQ------D------QN  ", "   NQQ----D----QQN   ", "    NNQQ--D--QQNN    ", "      NNQQQQQNN      ", "        NNNNN        ")
			.aisle("        NNNNN        ", "      NNQQQQQNN      ", "    NNQQ-----QQNN    ", "   NQQ---------QQN   ", "  NQ-------------QN  ", "  NQ-------------QN  ", " NQ---------------QN ", " NQ---------------QN ", "NQ-----------------QN", "NQ-----------------QN", "NQ-----------------QN", "NQ-----------------QN", "NQ-----------------QN", " NQ---------------QN ", " NQ---------------QN ", "  NQ-------------QN  ", "  NQ-------------QN  ", "   NQQ---------QQN   ", "    NNQQ-----QQNN    ", "      NNQQQQQNN      ", "        NNNNN        ")
			.aisle("                     ", "        NNNNN        ", "      NNQQQQQNN      ", "    NNQQ-----QQNN    ", "   NQQ---------QQN   ", "   NQ-----------QN   ", "  NQ-------------QN  ", "  NQ-------------QN  ", " NQ---------------QN ", " NQ---------------QN ", " NQ---------------QN ", " NQ---------------QN ", " NQ---------------QN ", "  NQ-------------QN  ", "  NQ-------------QN  ", "   NQ-----------QN   ", "   NQQ---------QQN   ", "    NNQQ-----QQNN    ", "      NNQQQQQNN      ", "        NNNNN        ", "                     ")
			.aisle("                     ", "        NNNNN        ", "      NNQQQQQNN      ", "    NNQQ-----QQNN    ", "   NQQ---------QQN   ", "   NQ-----------QN   ", "  NQ-------------QN  ", "  NQ-------------QN  ", " NQ---------------QN ", " NQ---------------QN ", " NQ---------------QN ", " NQ---------------QN ", " NQ---------------QN ", "  NQ-------------QN  ", "  NQ-------------QN  ", "   NQ-----------QN   ", "   NQQ---------QQN   ", "    NNQQ-----QQNN    ", "      NNQQQQQNN      ", "        NNNNN        ", "                     ")
			.aisle("                     ", "                     ", "        NNNNN        ", "      NNQQQQQNN      ", "    NNQQ-----QQNN    ", "    NQ---------QN    ", "   NQ-----------QN   ", "   NQ-----------QN   ", "  NQ-------------QN  ", "  NQ-------------QN  ", "  NQ-------------QN  ", "  NQ-------------QN  ", "  NQ-------------QN  ", "   NQ-----------QN   ", "   NQ-----------QN   ", "    NQ---------QN    ", "    NNQQ-----QQNN    ", "      NNQQQQQNN      ", "        NNNNN        ", "                     ", "                     ")
			.aisle("                     ", "                     ", "        NNNNN        ", "      NNQQQQQNN      ", "     NQQ-----QQN     ", "    NNQQ-----QQNN    ", "   NQQ---------QQN   ", "   NQQ---------QQN   ", "  NQ-------------QN  ", "  NQ-------------QN  ", "  NQ-------------QN  ", "  NQ-------------QN  ", "  NQ-------------QN  ", "   NQQ---------QQN   ", "   NQQ---------QQN   ", "    NNQQ-----QQNN    ", "     NQQ-----QQN     ", "      NNQQQQQNN      ", "        NNNNN        ", "                     ", "                     ")
			.aisle("                     ", "                     ", "                     ", "        NNNNN        ", "      NNQQQQQNN      ", "      NNQQQQQNN      ", "    NNQQ-----QQNN    ", "    NNQQ-----QQNN    ", "   NQQ---------QQN   ", "   NQQ---------QQN   ", "   NQQ---------QQN   ", "   NQQ---------QQN   ", "   NQQ---------QQN   ", "    NNQQ-----QQNN    ", "    NNQQ-----QQNN    ", "      NNQQQQQNN      ", "      NNQQQQQNN      ", "        NNNNN        ", "                     ", "                     ", "                     ")
			.aisle("                     ", "                     ", "                     ", "                     ", "        NNNNN        ", "        NNNNN        ", "      NNQQQQQNN      ", "      NNQQQQQNN      ", "    NNQQ-----QQNN    ", "    NNQQ-----QQNN    ", "    NNQQ-----QQNN    ", "    NNQQ-----QQNN    ", "    NNQQ-----QQNN    ", "      NNQQQQQNN      ", "      NNQQQQQNN      ", "        NNNNN        ", "        NNNNN        ", "                     ", "                     ", "                     ", "                     ")
			.aisle("                     ", "                     ", "                     ", "                     ", "                     ", "                     ", "        NNNNN        ", "        NNNNN        ", "      NNQQQQQNN      ", "      NNQQQQQNN      ", "      NNQQQQQNN      ", "      NNQQQQQNN      ", "      NNQQQQQNN      ", "        NNNNN        ", "        NNNNN        ", "                     ", "                     ", "                     ", "                     ", "                     ", "                     ")
			.aisle("                     ", "                     ", "                     ", "                     ", "                     ", "                     ", "                     ", "                     ", "        NNNNN        ", "        NNNNN        ", "        NNMNN        ", "        NNNNN        ", "        NNNNN        ", "                     ", "                     ", "                     ", "                     ", "                     ", "                     ", "                     ", "                     ")
			.where(" ", Predicates.any())
			.where("-", Predicates.air())
			.where("M", Predicates.controller(Predicates.blocks(definition.get())))
			.where("N", Predicates.blocks(Uberblocks.NEUTRONIUM_MACHINE_CASING.get()))
			.where("Q", Predicates.blocks(Uberblocks.NAQUADAH_MACHINE_CASING.get()))
			.where("D", Predicates.blocks(ChemicalHelper.getBlock(TagPrefix.frameGt, NaquadahAlloy)))
			.where("E", Predicates.blocks(GTBlocks.BORDERLESS_LAMPS.get(DyeColor.RED)))
			.where("G", Predicates.blocks(ChemicalHelper.getBlock(TagPrefix.block, Naquadah)))
			.where("H", Predicates.blocks(GTBlocks.MACHINE_CASING_UEV.get()))
			.where("I", Predicates.blocks(ChemicalHelper.getBlock(TagPrefix.block, Neutronium)))
			.where("K", Predicates.blocks(GTBlocks.HIGH_POWER_CASING.get()))
			.build()
		)
		//spotless:on
		.workableCasingModel(Uberutilities.id("block/casing/solid/neutronium_casing"), GTCEu.id("block/multiblock/fusion_reactor"))
		.tooltips(Component.translatable("machine.uberutilities.field_exciter.tooltip.0"))
		.langValue("Quantum Field Exciter")
		.register();
	
	public static void init() {
		LOGGER.info("Registering the QFE");
	}
}