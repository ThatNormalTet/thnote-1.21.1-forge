package com.thnote.thnotemod.item;

import com.thnote.thnotemod.Thnote;
import com.thnote.thnotemod.fluid.ModFluids;
import com.thnote.thnotemod.item.custom.MagicWand;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Thnote.MOD_ID);

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> POTATO_RUBY = ITEMS.register("potato_ruby", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MAGIC_WAND = ITEMS.register("magic_wand", () -> new MagicWand(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<BucketItem> POTATO_WATER_BUCKET = ITEMS.register("potato_water_bucket", () -> new BucketItem(ModFluids.SOURCE_POTATO_WATER,
            new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));

    public static final RegistryObject<BucketItem> OXYGEN_BUCKET = ITEMS.register("oxygen_bucket", () -> new BucketItem(ModFluids.SOURCE_OXYGEN,
            new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));

    public static void register(IEventBus iEventBus){
        ITEMS.register(iEventBus);
    }
}
