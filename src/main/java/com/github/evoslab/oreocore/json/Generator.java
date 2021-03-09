package com.github.evoslab.oreocore.json;

import net.devtech.arrp.api.RuntimeResourcePack;
import net.minecraft.util.Identifier;

import static com.github.evoslab.oreocore.OreoCore.*;

public abstract class Generator<T, This extends Generator<T, This>> {

    public final String namespace;
    protected final RuntimeResourcePack resourcePack;

    public Generator(String namespace, RuntimeResourcePack resourcePack) {
        this.namespace = MOD_ID;
        this.resourcePack = resourcePack;
    }

    public abstract RegistrableResults<T> build();

    @SuppressWarnings("unchecked")
    public This buildAndOutput(RegistrableResults<T> to) {
        to.putAll(this.build());
        return (This)this;
    }

    protected static Identifier prefixPath(Identifier id, String prefix) {
        return new Identifier(id.getNamespace(), prefix + "/" + id.getPath());
    }

    protected static String prefixPathAsString(Identifier id, String prefix) {
        return id.getNamespace() + ":" + prefix + "/" + id.getPath();
    }

    protected static String prefixPathAsStringTop(Identifier id, String prefix) {
        return id.getNamespace() + ":" + prefix + "/" + id.getPath() + "_top";
    }

    protected static String prefixPathAsStringSide(Identifier id, String prefix) {
        return id.getNamespace() + ":" + prefix + "/" + id.getPath() + "_side";
    }

}
