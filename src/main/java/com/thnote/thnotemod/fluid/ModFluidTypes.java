package com.thnote.thnotemod.fluid;

import com.thnote.thnotemod.Thnote;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluidTypes {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, Thnote.MOD_ID);

    public static final RegistryObject<FluidType> POTATO_WATER_TYPE = registerFluidType("potato_water_type", false);

    public static RegistryObject<FluidType> registerFluidType(String name, Boolean isGas){
        if (!isGas) {
            return FLUID_TYPES.register(name, () -> new FluidType(FluidType.Properties.create()
                    .canDrown(true)
                    .canPushEntity(true)
                    .canSwim(true)
                    .density(1)
                    .canConvertToSource(true)
            ));
        }else {
            return FLUID_TYPES.register(name, () -> new FluidType(FluidType.Properties.create()
                    .canDrown(true)
                    .canPushEntity(false)
                    .canSwim(false)
                    .density(-1)
                    .canConvertToSource(false)
            ));
        }
    }

    public static void register(IEventBus iEventBus){
        FLUID_TYPES.register(iEventBus);
    }
}
