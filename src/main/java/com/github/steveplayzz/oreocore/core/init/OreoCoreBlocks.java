package com.github.steveplayzz.oreocore.core.init;

import com.github.steveplayzz.oreocore.core.util.BlockItemPair;
import com.github.steveplayzz.oreocore.core.util.BlockWithItem;
import com.github.steveplayzz.oreocore.core.util.RegistryHelper;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class OreoCoreBlocks {

    public static FabricBlockSettings settings(Material material, float hardness)
    {
        return FabricBlockSettings.of(material).hardness(hardness).resistance(hardness);
    }

    public static BlockItemPair registerBlockAndItem(Block block, Identifier id){
        BlockItem bi = new BlockItem(block, OreoCoreItems.settings());
        Registry.register(Registry.BLOCK, id, block);
        Registry.register(Registry.ITEM, id, bi);
        return BlockItemPair.of(block, bi);
    }

    public static void init() {
        RegistryHelper.register(Registry.BLOCK, Block.class, OreoCoreBlocks.class, (reg, bl, id)->{

            if(!(bl instanceof BlockWithItem))
                return;

            BlockWithItem info = (BlockWithItem)bl;
            if(!info.hasItem())
                return;

            info.registerItem(id);
        });
    }
}