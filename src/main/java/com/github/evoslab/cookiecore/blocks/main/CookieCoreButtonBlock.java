package com.github.evoslab.cookiecore.blocks.main;

import net.minecraft.block.AbstractButtonBlock;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class CookieCoreButtonBlock extends AbstractButtonBlock {

    public CookieCoreButtonBlock(Settings settings) {
        super(false, settings);
    }

    public SoundEvent getClickSound(boolean powered) {
        return powered ? SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON : SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF;
    }

}
