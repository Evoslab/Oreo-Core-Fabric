package com.github.evoslab.cookiecore.datagen;

import net.devtech.arrp.api.RuntimeResourcePack;
import net.minecraft.util.Identifier;

public abstract class Generator<T, This extends Generator<T, This>> {

    public final String namespace;
    protected final RuntimeResourcePack resourcePack;

    public Generator(String namespace, RuntimeResourcePack resourcePack) {
        this.namespace = namespace;
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

    protected static String prefixPathAsStringLang(Identifier id, String prefix, String idlang) {
        return prefix + "." + id.getNamespace() + "." + idlang;
    }

    protected static String prefixPathAsStringTop(Identifier id, String prefix) {
        return id.getNamespace() + ":" + prefix + "/" + id.getPath() + "_top";
    }

    protected static String prefixPathAsStringSide(Identifier id, String prefix) {
        return id.getNamespace() + ":" + prefix + "/" + id.getPath() + "_side";
    }

    protected static Identifier prefixPathTop(Identifier id, String prefix) {
        return new Identifier(id.getNamespace(), prefix + "/" + id.getPath() + "_top");
    }

    protected static String prefixPathAsStringInner(Identifier id, String prefix) {
        return id.getNamespace() + ":" + prefix + "/" + id.getPath() + "_inner";
    }

    protected static String prefixPathAsStringOuter(Identifier id, String prefix) {
        return id.getNamespace() + ":" + prefix + "/" + id.getPath() + "_outer";
    }

    protected static String prefixPathAsStringDouble(Identifier id, String prefix) {
        return id.getNamespace() + ":" + prefix + "/" + id.getPath() + "_double";
    }

}
