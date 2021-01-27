package com.github.steveplayzz.oreocore.core.init;

import com.github.steveplayzz.oreocore.core.util.RegistryHelper;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

public class OreoCoreItems {

    public static Item.Settings settings(){
        return new Item.Settings(); // group goes here .group(OreoCore.GROUP);
    }

    public static void init() {

        RegistryHelper.register(Registry.ITEM, Item.class, OreoCoreItems.class);

    }

}
