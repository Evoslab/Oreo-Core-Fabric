package com.github.evoslab.cookiecore.datagen;

import com.github.evoslab.cookiecore.CookieCore;
import com.google.common.collect.ImmutableList;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.lang.JLang;
import net.devtech.arrp.json.loot.JLootTable;
import net.devtech.arrp.json.models.JModel;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.Contract;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static net.devtech.arrp.json.blockstate.JState.variant;
import static net.devtech.arrp.json.models.JModel.textures;

public class BlockGenerator extends Generator<Block, BlockGenerator> {

    private Function<Identifier, JState> blockStateGetter;
    private Function<Identifier, JModel> modelGetter;
    private Function<Identifier, JLootTable> lootTableGetter;
    private Function<Identifier, Block> blockGetter;
    private List<Identifier> ids;

    public BlockGenerator(String modid, RuntimeResourcePack resourcePack) {
        super(modid, resourcePack);
    }

    @Contract(value = "_ -> this", mutates = "this")
    public BlockGenerator setIds(List<Identifier> ids) {
        this.ids = ImmutableList.copyOf(ids);
        return this;
    }

    @Contract(value = "_ -> this", mutates = "this")
    public BlockGenerator setIds(Identifier... ids) {
        this.ids = ImmutableList.copyOf(ids);
        return this;
    }

    @Contract(value = "_ -> this", mutates = "this")
    public BlockGenerator setIds(String... paths) {
        //noinspection UnstableApiUsage
        this.ids = Arrays.stream(paths)
                .map(s -> new Identifier(namespace, s))
                .collect(ImmutableList.toImmutableList());
        return this;
    }

    @Contract(value = "_ -> this", mutates = "this")
    public BlockGenerator blockState(Function<Identifier, JState> getter) {
        this.blockStateGetter = getter;
        return this;
    }

    @Contract(value = "_ -> this", mutates = "this")
    public BlockGenerator model(Function<Identifier, JModel> getter) {
        this.modelGetter = getter;
        return this;
    }

    @Contract(value = "_ -> this", mutates = "this")
    public BlockGenerator lootTable(Function<Identifier, JLootTable> getter) {
        this.lootTableGetter = getter;
        return this;
    }

    @Contract(value = "_ -> this", mutates = "this")
    public BlockGenerator block(Function<Identifier, Block> getter) {
        this.blockGetter = getter;
        return this;
    }

    @Contract(value = "_ -> this", mutates = "this")
    public BlockGenerator block(Block block) {
        this.blockGetter = ignored -> block;
        return this;
    }

    @Contract(value = "_ -> this", mutates = "this")
    public BlockGenerator block(AbstractBlock.Settings settings) {
        return this.block(new Block(settings));
    }

    public BlockGenerator applyPreset(Function preset) {
        this.modelGetter = preset;
        return this;
    }

    @Override
    public RegistrableResults<Block> build() {
        return null;
    }

    public <T extends Block> T registerBlandBlock(T block, String path, String lang_en_us) {
        Identifier id = new Identifier(namespace, path);
        Registry.register(Registry.BLOCK, id, block);
        Registry.register(Registry.ITEM, id, new BlockItem(block, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

        resourcePack.addLang(CookieCore.id("en_us"), JLang.lang().translate(prefixPathAsStringLang(id, "block", path), lang_en_us));

        resourcePack.addBlockState(
                JState.state()
                        .add(variant()
                                .put("", JState.model(prefixPathAsString(id, "block")))
                        ),
                id
        );

        resourcePack.addModel(
                JModel.model("minecraft:block/cube_all")
                        .textures(textures()
                                .var("all", prefixPathAsString(id, "block"))
                        ),
                prefixPath(id, "block")
        );

        resourcePack.addModel(
                JModel.model(prefixPathAsString(id, "block")),
                prefixPath(id, "item")
        );

        return block;
    }

    public <T extends Block> T registerCarpetBlock(T block, String path) {
        Identifier id = new Identifier(namespace, path);
        Registry.register(Registry.BLOCK, id, block);
        Registry.register(Registry.ITEM, id, new BlockItem(block, new FabricItemSettings().group(ItemGroup.DECORATIONS)));

        resourcePack.addBlockState(
                JState.state()
                        .add(variant()
                                .put("", JState.model(prefixPathAsString(id, "block")))
                        ),
                id
        );

        resourcePack.addModel(
                JModel.model("overgrowth:block/flower_carpet")
                        .textures(textures()
                                .var("all", prefixPathAsString(id, "block"))
                        ),
                prefixPath(id, "block")
        );

        resourcePack.addModel(
                JModel.model(prefixPathAsString(id, "block")),
                prefixPath(id, "item")
        );

        return block;
    }

    public <T extends Block> T registerCarvedMelonBlock(T block, String path, String uncarved) {
        Identifier id = new Identifier(namespace, path);
        Identifier iduncarved = new Identifier("minecraft", uncarved);
        Registry.register(Registry.BLOCK, id, block);
        Registry.register(Registry.ITEM, id, new BlockItem(block, new FabricItemSettings().group(ItemGroup.DECORATIONS)));

        resourcePack.addBlockState(
                JState.state()
                        .add(variant()
                                .put("facing=east", JState.model(prefixPathAsString(id, "block")).y(90))
                                .put("facing=north", JState.model(prefixPathAsString(id, "block")))
                                .put("facing=south", JState.model(prefixPathAsString(id, "block")).y(180))
                                .put("facing=west", JState.model(prefixPathAsString(id, "block")).y(270))
                        ),
                id
        );

        resourcePack.addModel(
                JModel.model("minecraft:block/orientable")
                        .textures(textures()
                                .var("top", prefixPathAsStringTop(iduncarved, "block"))
                                .var("front", prefixPathAsString(id, "block"))
                                .var("side", prefixPathAsStringSide(iduncarved, "block"))
                        ),
                prefixPath(id, "block")
        );

        resourcePack.addModel(
                JModel.model(prefixPathAsString(id, "block")),
                prefixPath(id, "item")
        );

        return block;
    }

    /*
    {
  "variants": {
    "half=bottom,facing=east,carved_side=x": {
      "model": "autumnity:block/carved_large_pumpkin_slice_bottom_northeast_x"
    },
    "half=bottom,facing=north,carved_side=x": {
      "model": "autumnity:block/carved_large_pumpkin_slice_bottom_northwest_x"
    },
    "half=bottom,facing=west,carved_side=x": {
      "model": "autumnity:block/carved_large_pumpkin_slice_bottom_southwest_x"
    },
    "half=bottom,facing=south,carved_side=x": {
      "model": "autumnity:block/carved_large_pumpkin_slice_bottom_southeast_x"
    },
    "half=top,facing=east,carved_side=x": {
      "model": "autumnity:block/carved_large_pumpkin_slice_top_northeast_x"
    },
    "half=top,facing=north,carved_side=x": {
      "model": "autumnity:block/carved_large_pumpkin_slice_top_northwest_x"
    },
    "half=top,facing=west,carved_side=x": {
      "model": "autumnity:block/carved_large_pumpkin_slice_top_southwest_x"
    },
    "half=top,facing=south,carved_side=x": {
      "model": "autumnity:block/carved_large_pumpkin_slice_top_southeast_x"
    },
    "half=bottom,facing=east,carved_side=z": {
      "model": "autumnity:block/carved_large_pumpkin_slice_bottom_northeast_z"
    },
    "half=bottom,facing=north,carved_side=z": {
      "model": "autumnity:block/carved_large_pumpkin_slice_bottom_northwest_z"
    },
    "half=bottom,facing=west,carved_side=z": {
      "model": "autumnity:block/carved_large_pumpkin_slice_bottom_southwest_z"
    },
    "half=bottom,facing=south,carved_side=z": {
      "model": "autumnity:block/carved_large_pumpkin_slice_bottom_southeast_z"
    },
    "half=top,facing=east,carved_side=z": {
      "model": "autumnity:block/carved_large_pumpkin_slice_top_northeast_z"
    },
    "half=top,facing=north,carved_side=z": {
      "model": "autumnity:block/carved_large_pumpkin_slice_top_northwest_z"
    },
    "half=top,facing=west,carved_side=z": {
      "model": "autumnity:block/carved_large_pumpkin_slice_top_southwest_z"
    },
    "half=top,facing=south,carved_side=z": {
      "model": "autumnity:block/carved_large_pumpkin_slice_top_southeast_z"
    }
  }
}
     */

    public <T extends Block> T registerCrossBlock(T block, String path) {
        Identifier id = new Identifier(namespace, path);
        Registry.register(Registry.BLOCK, id, block);
        Registry.register(Registry.ITEM, id, new BlockItem(block, new FabricItemSettings().group(ItemGroup.DECORATIONS)));

        resourcePack.addBlockState(
                JState.state()
                        .add(variant()
                                .put("", JState.model(prefixPathAsString(id, "block")))
                        ),
                id
        );

        resourcePack.addModel(
                JModel.model("minecraft:block/cross")
                        .textures(textures()
                                .var("cross", prefixPathAsString(id, "block"))
                        ),
                prefixPath(id, "block")
        );

        resourcePack.addModel(
                JModel.model(prefixPathAsString(id, "block")),
                prefixPath(id, "item")
        );

        return block;
    }

    public <T extends Block> T registerBlankBlock(T block, String path) {
        Identifier id = new Identifier(namespace, path);
        Registry.register(Registry.BLOCK, id, block);
        Registry.register(Registry.ITEM, id, new BlockItem(block, new FabricItemSettings().group(ItemGroup.DECORATIONS)));

        return block;
    }

}