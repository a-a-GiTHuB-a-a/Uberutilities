package com.daboxen.uberutilities.api;

import com.daboxen.uberutilities.Uberutilities;
import com.gregtechceu.gtceu.api.fluids.attribute.FluidAttribute;
import net.minecraft.network.chat.Component;

public final class ExtendedFluidAttributes {
	/**
	 * Attribute for antimatter.
	 */
	public static final FluidAttribute ANTIMATTER = new FluidAttribute(Uberutilities.id("antimatter"),
		list -> list.accept(Component.translatable("fluid.uberutilities.type_antimatter.tooltip")),
		list -> list.accept(Component.translatable("fluid_pipe.uberutilities.antimatter_proof")));
}