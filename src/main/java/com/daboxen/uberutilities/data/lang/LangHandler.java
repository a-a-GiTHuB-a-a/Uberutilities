package com.daboxen.uberutilities.data.lang;

import static com.gregtechceu.gtceu.data.lang.LangHandler.replace;
import com.tterrag.registrate.providers.RegistrateLangProvider;
import javax.annotation.Nonnull;
import java.util.Map;

public class LangHandler {
	private static Map<String, String> replacements;
	
	public static void addReplacementEntry(@Nonnull String key, @Nonnull String value) {
		replacements.put(key, value);
	}
	
	public static void init(RegistrateLangProvider provider) {
		//todo: outsource langgen to the actual places where all this stuff is made
		
		provider.add("uberutilities.fluid.type_antimatter.tooltip", "§khello§r§c§lANTIMATTER! HANDLE WITH EXTREME CAUTION!§r§kworld§r");
		provider.add("uberutilities.fluid_pipe.antimatter_proof", "§khello§r§c§lCapable of containing antimatter§r§kworld§r");
		
		provider.add("machine.uberutilities.field_exciter.tooltip.0", "Making matter out of pure energy");
		
		for (Map.Entry<String, String> entry : replacements.entrySet()) {
			replace(provider, entry.getKey(), entry.getValue());
		}
	}
}
