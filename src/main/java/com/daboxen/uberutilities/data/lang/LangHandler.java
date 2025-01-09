package com.daboxen.uberutilities.data.lang;

import com.tterrag.registrate.providers.RegistrateLangProvider;

public class LangHandler {
	public static void init(RegistrateLangProvider provider) {
		//todo: outsource langgen to the actual places where all this stuff is made
		
		provider.add("material.uberutilities.anti_neutronium", "Anti-Neutronium");
		provider.add("material.uberutilities.up_quark", "Up Quark");
		provider.add("material.uberutilities.anti_up_quark", "Anti Up Quark");
		provider.add("material.uberutilities.down_quark", "Down Quark");
		provider.add("material.uberutilities.anti_down_quark", "Anti Down Quark");
		
		provider.add("uberutilities.fluid.type_antimatter.tooltip", "§khello§r§c§lANTIMATTER! HANDLE WITH EXTREME CAUTION!§r§kworld§r");
		provider.add("uberutilities.fluid_pipe.antimatter_proof", "§khello§r§c§lCapable of containing antimatter§r§kworld§r");
		
		provider.add("machine.uberutilities.field_exciter.tooltip.0", "Making matter out of pure energy");
		provider.add("block.uberutilities.field_exciter", "Quantum Field Exciter");
	}
}
