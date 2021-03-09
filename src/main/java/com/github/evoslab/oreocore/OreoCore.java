package com.github.evoslab.oreocore;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OreoCore implements ModInitializer {

	public static final String MOD_ID = "oreocore";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

	}

	public static Identifier id(String name) {
		return new Identifier(MOD_ID, name);
	}

}
