package com.github.evoslab.cookiecore.blocks.lepton;

import net.minecraft.block.Block;
import net.minecraft.block.WallBlock;

public class LogWallBlock extends WallBlock {

    private final Block block;

    public LogWallBlock(Block strippedBlock, Settings settings) {
        super(settings);
        this.block = strippedBlock;
    }

}
