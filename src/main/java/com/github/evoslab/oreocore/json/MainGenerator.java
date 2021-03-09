package com.github.evoslab.oreocore.json;

import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RuntimeResourcePack;

import java.util.Random;

public final class MainGenerator {

    private final String modid;
    private final RuntimeResourcePack resourcePack;
    public final BlockGenerator block;
    public final ItemGenerator item;

    public MainGenerator(String modid) {
        this(modid, RuntimeResourcePack.create(modid + ":" + modid + "_generator_" + generateRandomId()));
    }

    public MainGenerator(String modid, RuntimeResourcePack resourcePack) {
        this.modid = modid;
        this.resourcePack = resourcePack;
        RRPCallback.EVENT.register(a -> a.add(resourcePack));
        block = new BlockGenerator(modid, resourcePack);
        item = new ItemGenerator(modid, resourcePack);
    }

    private static String generateRandomId() {
        return String.format("%08x", new Random().nextInt());
    }

    public RuntimeResourcePack getResourcePack() {
        return resourcePack;
    }
}