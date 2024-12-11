package com.daboxen.uberutilities.api;

import com.gregtechceu.gtceu.api.data.chemical.material.properties.FluidPipeProperties;

public class ExtendedFluidPipeProperties extends FluidPipeProperties {
	private boolean antimatterProof;

	public void setAntimatterProof(boolean val) {
		antimatterProof = val;
	}

	public ExtendedFluidPipeProperties(int maxFluidTemperature, int throughput, boolean gasProof, boolean acidProof, boolean cryoProof, boolean plasmaProof, boolean antimatterProof, int channels) {
		super(maxFluidTemperature, throughput, gasProof, acidProof, cryoProof, plasmaProof, channels);
		this.antimatterProof = antimatterProof;
	}

	public ExtendedFluidPipeProperties(int maxFluidTemperature, int throughput, boolean gasProof, boolean acidProof, boolean cryoProof, boolean plasmaProof, boolean antimatterProof) {
		this(maxFluidTemperature, throughput, gasProof, acidProof, cryoProof, plasmaProof, antimatterProof, 1);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ExtendedFluidPipeProperties that)) return false;
		return super.equals(that) && antimatterProof == that.antimatterProof;
	}

	@Override
	public String toString() {
		return "FluidPipeProperties{" +
			"maxFluidTemperature=" + getMaxFluidTemperature() +
			", throughput=" + getThroughput() +
			", gasProof=" + isGasProof() +
			", acidProof=" + isAcidProof() +
			", cryoProof=" + isCryoProof() +
			", plasmaProof=" + isPlasmaProof() +
			", antimatterProof=" + isAntimatterProof() +
			", channels=" + getChannels() +
			'}';
	}

	public boolean isAntimatterProof() {
		return canContain(ExtendedFluidAttributes.ANTIMATTER);
	}
}