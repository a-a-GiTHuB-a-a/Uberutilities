package com.daboxen.uberutilities.additions.machines;

import static com.daboxen.uberutilities.Uberutilities.LOGGER;

public class MachineRegistrar {
	public static void init() {
		LOGGER.info("Registering custom machines");
		Singleblocks.init();
		MassQuantumCollider.init();
	}
}
