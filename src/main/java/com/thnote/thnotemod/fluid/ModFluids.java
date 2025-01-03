package com.thnote.thnotemod.fluid;

import com.thnote.thnotemod.Thnote;
import com.thnote.thnotemod.fluid.fluids.OxygenGas;
import com.thnote.thnotemod.fluid.fluids.PotatoWaterFluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, Thnote.MOD_ID);

    public static final RegistryObject<FlowingFluid> SOURCE_POTATO_WATER = FLUIDS.register("source_potato_water_fluid", () -> new PotatoWaterFluid.Source(new ForgeFlowingFluid.Properties(ModFluidTypes.POTATO_WATER_TYPE, ModFluids.SOURCE_POTATO_WATER , ModFluids.FLOWING_POTATO_WATER)));
    public static final RegistryObject<FlowingFluid> FLOWING_POTATO_WATER = FLUIDS.register("flowing_potato_water_fluid", () -> new PotatoWaterFluid.Flowing(new ForgeFlowingFluid.Properties(ModFluidTypes.POTATO_WATER_TYPE, ModFluids.SOURCE_POTATO_WATER , ModFluids.FLOWING_POTATO_WATER)));

    public static final RegistryObject<FlowingFluid> SOURCE_OXYGEN = FLUIDS.register("source_oxygen_gas", () -> new OxygenGas.Source(new ForgeFlowingFluid.Properties(ModFluidTypes.OXYGEN_TYPE, ModFluids.SOURCE_OXYGEN, ModFluids.FLOWING_OXYGEN)));
    public static final RegistryObject<FlowingFluid> FLOWING_OXYGEN = FLUIDS.register("flowing_oxygen_gas", () -> new OxygenGas.Flowing(new ForgeFlowingFluid.Properties(ModFluidTypes.OXYGEN_TYPE, ModFluids.SOURCE_OXYGEN, ModFluids.FLOWING_OXYGEN)));

    public static void register(IEventBus iEventBus){
        FLUIDS.register(iEventBus);
    }
}
