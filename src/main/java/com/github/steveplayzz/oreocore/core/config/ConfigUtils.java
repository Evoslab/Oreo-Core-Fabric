package com.github.steveplayzz.oreocore.core.config;

import com.github.steveplayzz.oreocore.core.OreoCore;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.ConfigManager;
import me.sargunvohra.mcmods.autoconfig1u.serializer.ConfigSerializer;

public class ConfigUtils {

    private ConfigUtils() {
        // NO-OP
    }

    public static void serializeConfig() {
        try {
            ((ConfigManager<ModConfig>) AutoConfig.getConfigHolder(ModConfig.class)).getSerializer().serialize(OreoCore.CONFIG);
        } catch (ConfigSerializer.SerializationException serializeException) {
            OreoCore.LOGGER.error("Failed to serialize " + OreoCore.LOGGER.getName() + "'s config!", serializeException);
        }
    }
}
