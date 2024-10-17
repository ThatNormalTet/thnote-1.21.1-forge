package com.thnote.thnotemod.block;

import com.thnote.thnotemod.Thnote;
import com.thnote.thnotemod.block.custom.Powderizer;
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

    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> POTATO_RUBY_BLOCK = registerBlock("potato_ruby_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
            .strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> POTATO_RUBY_ORE = registerBlock("potato_ruby_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
            .strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CONDENSED_EMERALD_BLOCK = registerBlock("condensed_emerald_block",
            () -> new Powderizer(BlockBehaviour.Properties.of()
            .strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<LiquidBlock> POTATO_WATER_BLOCK = registerBlock("potato_water_block", () -> new LiquidBlock(ModFluids.SOURCE_POTATO_WATER,
            BlockBehaviour.Properties.ofFullCopy(Blocks.WATER)));


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
