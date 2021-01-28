package com.github.evoslab.oreocore.core;

import com.github.evoslab.oreocore.core.config.ModConfig;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OreoCore implements ModInitializer {

    public static final String MODID = "oreocore";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static final ModConfig CONFIG = AutoConfig.register(ModConfig.class, GsonConfigSerializer::new).getConfig();

    @Override
    public void onInitialize() {

    }
}
