package com.github.evoslab.cookiecore;

import com.github.evoslab.cookiecore.datagen.MainGenerator;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CookieCore implements ModInitializer {

	public static final String MOD_ID = "cookiecore";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	private static final MainGenerator generator = new MainGenerator(MOD_ID);

	public static Block EXAMPLE_BLOCK = generator.block.registerBlandBlock(new Block(FabricBlockSettings.of(Material.AIR)), "example_block","Example Block");

	@Override
	public void onInitialize() {

		//TODO: Add Flamboyant stuff

	}

	public static Identifier id(String name) {
		return new Identifier(MOD_ID, name);
	}

}
