package com.daboxen.uberutilities.api;

import static com.daboxen.uberutilities.Uberutilities.LOGGER;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;

public class IconSets {
	public static final MaterialIconSet WHITE_OUTLINE = new MaterialIconSet("white_outline", MaterialIconSet.METALLIC);
	public static final MaterialIconSet SUS = new MaterialIconSet("sus", MaterialIconSet.METALLIC);

	public static void init() {
		LOGGER.info("Adding material icons");
	}
}