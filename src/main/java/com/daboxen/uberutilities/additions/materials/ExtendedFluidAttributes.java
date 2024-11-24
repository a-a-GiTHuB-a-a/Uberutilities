package com.daboxen.uberutilities.additions.materials;

import com.daboxen.uberutilities.Uberutilities;
import com.gregtechceu.gtceu.api.fluids.attribute.FluidAttribute;
import net.minecraft.network.chat.Component;

public final class ExtendedFluidAttributes {
	/**
	 * Attribute for antimatter.
	 */
	public static final FluidAttribute ANTIMATTER = new FluidAttribute(Uberutilities.id("antimatter"),
		list -> list.accept(Component.translatable("uberutilities.fluid.type_antimatter.tooltip")),
		list -> list.accept(Component.translatable("uberutilities.fluid_pipe.antimatter_proof")));
}