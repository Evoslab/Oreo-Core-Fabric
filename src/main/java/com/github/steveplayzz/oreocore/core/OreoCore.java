package com.github.steveplayzz.oreocore.core;

import com.github.steveplayzz.oreocore.core.init.OreoCoreBlocks;
import com.github.steveplayzz.oreocore.core.config.ModConfig;
import com.github.steveplayzz.oreocore.core.init.OreoCoreItems;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OreoCore implements ModInitializer {

	public static final String MODID = "oreocore";
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	public static final ModConfig CONFIG = AutoConfig.register(ModConfig.class, GsonConfigSerializer::new).getConfig();

	public static Identifier ID(String path){
		return new Identifier(MODID, path);
	}

	@Override
	public void onInitialize() {
		OreoCoreBlocks.init();
		OreoCoreItems.init();
		new OreoCoreItems();
		new OreoCoreBlocks();

	}

	public static Identifier id(String name) {
		return new Identifier(MODID, name);
	}
}
