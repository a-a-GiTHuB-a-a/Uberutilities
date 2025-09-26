package com.daboxen.uberutilities.data.lang;

import static com.daboxen.uberutilities.Uberutilities.LOGGER;
import static com.gregtechceu.gtceu.data.lang.LangHandler.replace;
import com.tterrag.registrate.providers.RegistrateLangProvider;
import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class LangHandler {
	private static final Map<Supplier<String>, String> replacements = new HashMap<>();
	
	public static void addReplacementEntry(@Nonnull String key, @Nonnull String value) {
		replacements.put(()->key, value);
	}
	public static void addReplacementEntry(@Nonnull Supplier<String> key, @Nonnull String value) {
		replacements.put(key, value);
	}
	
	public static void init(RegistrateLangProvider provider) {
		//todo: outsource langgen to the actual places where all this stuff is made
		
		provider.add("uberutilities.fluid.type_antimatter.tooltip", "§khello§r§c§lANTIMATTER! HANDLE WITH EXTREME CAUTION!§r§kworld§r");
		provider.add("uberutilities.fluid_pipe.antimatter_proof", "§khello§r§c§lCapable of containing antimatter§r§kworld§r");
		
		provider.add("machine.uberutilities.mass_collider.tooltip.0", "Mass-producing quantum particles");
		
		for (Map.Entry<Supplier<String>, String> entry : replacements.entrySet()) {
			String key = entry.getKey().get();
			String name = entry.getValue();
			LOGGER.info("Replacing lang data at key {} with {}", key, name);
			replace(provider, key, name);
		}
	}
}
