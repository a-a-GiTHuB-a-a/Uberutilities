package com.daboxen.uberutilities.data;

import com.daboxen.uberutilities.data.lang.LangHandler;
import com.tterrag.registrate.providers.ProviderType;
import static com.daboxen.uberutilities.Uberutilities.UBER_REGISTRATE;

public class Datagen {
	public static void init() {
		UBER_REGISTRATE.addDataGenerator(ProviderType.LANG, LangHandler::init);
	}
}