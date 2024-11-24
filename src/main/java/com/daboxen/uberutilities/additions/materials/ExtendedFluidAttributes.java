import com.gregtechceu.gtceu.api.fluids.attribute.FluidAttributes;

public final class ExtendedFluidAttributes extends FluidAttributes {
	/**
	 * Attribute for antimatter.
	 */
	public static final FluidAttribute ANTIMATTER = public static final FluidAttribute ACID = new FluidAttribute(Uberutilities.id("antimatter"),
		list -> list.accept(Component.translatable("uberutilities.fluid.type_antimatter.tooltip")),
		list -> list.accept(Component.translatable("uberutilities.fluid_pipe.antimatter_proof")));
}