package com.github.evoslab.cookiecore.blocks.lepton;

import com.github.evoslab.cookiecore.blocks.main.CookieCoreStairsBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;

public class LogStairsBlock extends CookieCoreStairsBlock {

    private final Block block;

    public LogStairsBlock(Block strippedBlock, BlockState state, Settings settings) {
        super(state, settings);
        this.block = strippedBlock;
    }

}
