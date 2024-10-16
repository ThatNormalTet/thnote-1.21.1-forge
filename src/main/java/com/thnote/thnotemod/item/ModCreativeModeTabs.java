package com.thnote.thnotemod.item;

import com.thnote.thnotemod.Thnote;
import com.thnote.thnotemod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Thnote.MOD_ID);

    public static final RegistryObject<CreativeModeTab> THNOTE = TABS.register("thnote", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.RUBY.get()))
            .title(Component.translatable("creative_tab.thnote.thnote_tab"))
            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(ModItems.RUBY.get());
                pOutput.accept(ModItems.POTATO_RUBY.get());
                pOutput.accept(ModBlocks.RUBY_BLOCK.get());
                pOutput.accept(ModBlocks.RUBY_ORE.get());
                pOutput.accept(ModBlocks.POTATO_RUBY_ORE.get());

            })
            .build());

    public static final RegistryObject<CreativeModeTab> THNOTE_MACHINES = TABS.register("thnote_machines", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.RUBY.get()))
            .title(Component.translatable("creative_tab.thnote.thnote_machines_tab"))
            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(ModBlocks.CONDENSED_EMERALD_BLOCK.get());
            })
            .build());

    public static final void register(IEventBus iEventBus){
        TABS.register(iEventBus);
    }
}
