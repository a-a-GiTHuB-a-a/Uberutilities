package com.daboxen.uberutilities.data.lang;

import com.tterrag.registrate.providers.RegistrateLangProvider;

public class LangHandler {
	public static void init(RegistrateLangProvider provider) {
		//todo: outsource langgen to the actual places where all this stuff is made
		
		provider.add("material.uberutilities.anti_neutronium", "Anti-Neutronium");
		
		provider.add("uberutilities.fluid.type_antimatter.tooltip", "§khello§r§c§lANTIMATTER! HANDLE WITH EXTREME CAUTION!§r§kworld§r");
		provider.add("uberutilities.fluid_pipe.antimatter_proof", "§khello§r§c§lCapable of containing antimatter§r§kworld§r");
		
		provider.add("machine.uberutilities.field_exciter.tooltip.0", "Making matter out of pure energy");
	}
}
