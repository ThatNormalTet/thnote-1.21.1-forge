package com.thnote.thnotemod.fluid;

import com.thnote.thnotemod.Thnote;
import com.thnote.thnotemod.block.ModBlocks;
import com.thnote.thnotemod.item.ModItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
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
    public static final RegistryObject<FlowingFluid> FLOWING_POTATO_WATER = FLUIDS.register("flowing_water_fluid", () -> new PotatoWaterFluid.Flowing(new ForgeFlowingFluid.Properties(ModFluidTypes.POTATO_WATER_TYPE, ModFluids.SOURCE_POTATO_WATER , ModFluids.FLOWING_POTATO_WATER)));

    public static void register(IEventBus iEventBus){
        FLUIDS.register(iEventBus);
    }
}
