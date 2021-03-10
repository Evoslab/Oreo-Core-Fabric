package com.github.evoslab.cookiecore.blocks.lepton;

import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;

public class LogSlabBlock extends SlabBlock {

    private final Block block;

    public LogSlabBlock(Block strippedBlock, Settings settings) {
        super(settings);
        this.block = strippedBlock;
    }

}
