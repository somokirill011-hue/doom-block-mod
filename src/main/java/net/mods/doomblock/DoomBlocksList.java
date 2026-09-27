package net.mods.doomblock.init;

import java.util.Set;
import net.minecraft.world.level.block.Block;
import net.mods.doomblock.init.DoomBlockModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;

public class DoomBlocksList {
    private static final Set<Block> DOOM_BLOCKS = Set.of(
        DoomBlockModBlocks.DOOM.get(),
        DoomBlockModBlocks.RED_DOOM.get(),
        DoomBlockModBlocks.ORANGE_DOOM.get(),
        DoomBlockModBlocks.YELLOW_DOOM.get(),
        DoomBlockModBlocks.LIME_DOOM.get(),
        DoomBlockModBlocks.LIGHT_BLUE_DOOM.get(),
        DoomBlockModBlocks.BLUE_DOOM.get(),
        DoomBlockModBlocks.PURPLE_DOOM.get(),
        DoomBlockModBlocks.MAGENTA_DOOM.get(),
        DoomBlockModBlocks.PINK_DOOM.get(),
        DoomBlockModBlocks.WHITE_DOOM.get(),
        DoomBlockModBlocks.INVISIBLE_DOOM.get()
    );

    public static boolean isDoomBlock(Block block) {
        return DOOM_BLOCKS.contains(block);
    }

    // Новая проверка: совпадает ли тип блока с нужным
    public static boolean matchesDoomType(Block block, String type) {
        if (!isDoomBlock(block)) return false;
        
        // Получаем имя блока через BuiltinRegistries (это работает в NeoForge 1.21)
        var loc = BuiltInRegistries.BLOCK.getKey(block);
        if (loc == null) return false;

        String path = loc.getPath();
        return DOOM_BLOCKS.contains(path) && path.equals(type);
    }
}
