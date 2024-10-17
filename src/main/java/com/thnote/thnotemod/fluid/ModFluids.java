package com.thnote.thnotemod.fluid;

import com.thnote.thnotemod.Thnote;
import com.thnote.thnotemod.block.ModBlocks;
import com.thnote.thnotemod.item.ModItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, Thnote.MOD_ID);

    public static final RegistryObject<FlowingFluid> SOURCE_POTATO_WATER = FLUIDS.register("potato_water_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.POTATO_WATER_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_POTATO_WATER = FLUIDS.register("flowing_water_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.POTATO_WATER_PROPERTIES));

    public static final ForgeFlowingFluid.Properties POTATO_WATER_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.POTATO_WATER_TYPE, SOURCE_POTATO_WATER, FLOWING_POTATO_WATER)
            .slopeFindDistance(2).levelDecreasePerBlock(1).block(ModBlocks.POTATO_WATER_BLOCK)
            .bucket(ModItems.POTATO_WATER_BUCKET);

    public static void register(IEventBus iEventBus){
        FLUIDS.register(iEventBus);
    }
}
