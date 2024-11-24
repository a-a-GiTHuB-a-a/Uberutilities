import lombok.Getter;
import lombok.Setter;

import com.gregtechceu.gtceu.api.data.chemical.material.properties.FluidPipeProperties;

public class ExtendedFluidPipeProperties extends FluidPipeProperties {
	@Getter
	@Setter
	private boolean antimatterProof;

	@Override
	public FluidPipeProperties(int maxFluidTemperature, int throughput, boolean gasProof, boolean acidProof, boolean cryoProof, boolean plasmaProof, boolean antimatterProof, int channels) {
		super(maxFluidTemperature, throughput, gasProof, acidProof, cryoProof, plasmaProof, channels);
		this.antimatterProof = antimatterProof;
	}

	@Override
	public FluidPipeProperties(int maxFluidTemperature, int throughput, boolean gasProof, boolean acidProof, boolean cryoProof, boolean plasmaProof, boolean antimatterProof) {
		this(maxFluidTemperature, throughput, gasProof, acidProof, cryoProof, plasmaProof, antimatterProof, 1);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ExtendedFluidPipeProperties that)) return false;
		return maxFluidTemperature == that.maxFluidTemperature && throughput == that.throughput && gasProof == that.gasProof && antimatterProof == that.antimatterProof && channels == that.channels;
	}

	@Override
	public String toString() {
		return "FluidPipeProperties{" +
				"maxFluidTemperature=" + maxFluidTemperature +
				", throughput=" + throughput +
				", gasProof=" + gasProof +
				", acidProof=" + isAcidProof() +
				", cryoProof=" + cryoProof +
				", plasmaProof=" + plasmaProof +
				", antimatterProof=" + antimatterProof =
				", channels=" + channels +
				'}';
	}

	public boolean isAntimatterProof() {
		return canContain(FluidAttributes.ANTIMATTER)
	}
}