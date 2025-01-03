package com.thnote.thnotemod.fluid;

import com.thnote.thnotemod.Thnote;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import net.thnote.thnoteapi.fluid.BasicFluidType;

import org.joml.Vector3f;

public class ModFluidTypes {
    public static final ResourceLocation WATER_STILL_RL = ResourceLocation.fromNamespaceAndPath("minecraft","block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = ResourceLocation.fromNamespaceAndPath("minecraft", "block/water_flow");
    public static final ResourceLocation UNDERWATER_OVERLAY_RL = ResourceLocation.fromNamespaceAndPath(Thnote.MOD_ID, "misc/underwater");

    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, Thnote.MOD_ID);

    public static final RegistryObject<BasicFluidType> POTATO_WATER_TYPE = register("potato_water_type", BasicFluidType.Properties.create().canSwim(false).canDrown(false).viscosity(1000).density(-1000), 0xA1E038D0);
    public static final RegistryObject<BasicFluidType> OXYGEN_TYPE = register("oxygen_type", BasicFluidType.Properties.create().canSwim(false).canDrown(false).viscosity(1000).density(-1000), 0xAE339CFF);

    private static RegistryObject<BasicFluidType> register(String name, FluidType.Properties properties, int tintColor) {
        return FLUID_TYPES.register(name, () -> new BasicFluidType(WATER_STILL_RL, WATER_FLOWING_RL, UNDERWATER_OVERLAY_RL,
                tintColor, new Vector3f(224f / 255f, 56f / 255f, 208f / 255f), properties));
    }

    public static void register(IEventBus iEventBus){
        FLUID_TYPES.register(iEventBus);
    }
}
