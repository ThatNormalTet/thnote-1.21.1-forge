package com.thnote.thnotemod.block;

import com.thnote.thnotemod.Thnote;
import com.thnote.thnotemod.block.custom.Powderizer;
import com.thnote.thnotemod.block.custom.Test;
import com.thnote.thnotemod.fluid.ModFluids;
import com.thnote.thnotemod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Thnote.MOD_ID);

//    Register Blocks

    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> POTATO_RUBY_BLOCK = registerBlock("potato_ruby_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CONDENSED_EMERALD_BLOCK = registerBlock("condensed_emerald_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_BLOCK)));

//    Register Ores

    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
            .strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> POTATO_RUBY_ORE = registerBlock("potato_ruby_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DEEPSLATE_POTATO_RUBY_ORE = registerBlock("deepslate_potato_ruby_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));

//    Register Machines / Interactive Blocks

    public static final RegistryObject<Block> FLINT_BLOCK = registerBlock("flint_block",
            () -> new Powderizer(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> TEST = registerBlock("testblock",
            () -> new Test(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));

//    Register FluidBlocks

    public static final RegistryObject<LiquidBlock> POTATO_WATER_BLOCK = registerBlock("potato_water_block", () -> new LiquidBlock(ModFluids.SOURCE_POTATO_WATER,
            BlockBehaviour.Properties.ofFullCopy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> OXYGEN_BLOCK = registerBlock("oxygen_block", () -> new LiquidBlock(ModFluids.SOURCE_OXYGEN,
            BlockBehaviour.Properties.ofFullCopy(Blocks.WATER)));

//    Helper Methods

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, Supplier<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus iEventBus){
        BLOCKS.register(iEventBus);
    }
}
