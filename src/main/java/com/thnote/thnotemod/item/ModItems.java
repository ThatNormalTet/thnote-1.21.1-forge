package com.thnote.thnotemod.item;

import com.thnote.thnotemod.Thnote;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Thnote.MOD_ID);

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POTATO_RUBY = ITEMS.register("potato_ruby", () -> new Item(new Item.Properties()));


    public static void register(IEventBus iEventBus){
        ITEMS.register(iEventBus);
    }
}
