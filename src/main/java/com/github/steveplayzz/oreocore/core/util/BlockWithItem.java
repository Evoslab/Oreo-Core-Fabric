package com.github.steveplayzz.oreocore.core.util;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public interface BlockWithItem
{
    default boolean hasItem()
    {
        return true;

    }
    default Item.Settings makeItemSettings()
    {
        return new Item.Settings(); //add this here for group: .group(OreoCore.GROUP);
    }

    default Item makeItem()
    {
        return new BlockItem((Block)this, makeItemSettings());
    }

    default void registerItem(Identifier id)
    {
        Registry.register(Registry.ITEM, id, makeItem());
    }
}