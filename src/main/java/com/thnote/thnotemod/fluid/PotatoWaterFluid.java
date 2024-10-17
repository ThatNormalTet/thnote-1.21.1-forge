package com.thnote.thnotemod.fluid;

import com.thnote.thnotemod.block.ModBlocks;
import com.thnote.thnotemod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.WaterFluid;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import javax.annotation.Nullable;
import java.lang.reflect.Modifier;
import java.util.Optional;

public abstract class PotatoWaterFluid extends ForgeFlowingFluid {

    protected PotatoWaterFluid(Properties properties) {
        super(properties);
    }

    @Override
    public Fluid getFlowing() {
        return ModFluids.FLOWING_POTATO_WATER.get();
    }

    @Override
    public Fluid getSource() {
        return ModFluids.SOURCE_POTATO_WATER.get();
    }

    @Override
    public Item getBucket() {
        return ModItems.POTATO_WATER_BUCKET.get();
    }

    @Override
    public FluidType getFluidType() {
        return ModFluidTypes.POTATO_WATER_TYPE.get();
    }

    @Override
    public void animateTick(Level pLevel, BlockPos pPos, FluidState pState, RandomSource pRandom) {
        if (!pState.isSource() && !pState.getValue(FALLING)) {
            if (pRandom.nextInt(64) == 0) {
                pLevel.playLocalSound(
                        (double)pPos.getX() + 0.5,
                        (double)pPos.getY() + 0.5,
                        (double)pPos.getZ() + 0.5,
                        SoundEvents.WATER_AMBIENT,
                        SoundSource.BLOCKS,
                        pRandom.nextFloat() * 0.25F + 0.75F,
                        pRandom.nextFloat() + 0.5F,
                        false
                );
            }
        } else if (pRandom.nextInt(10) == 0) {
            pLevel.addParticle(
                    ParticleTypes.UNDERWATER,
                    (double)pPos.getX() + pRandom.nextDouble(),
                    (double)pPos.getY() + pRandom.nextDouble(),
                    (double)pPos.getZ() + pRandom.nextDouble(),
                    0.0,
                    0.0,
                    0.0
            );
        }
    }

    @Nullable
    @Override
    public ParticleOptions getDripParticle() {
        return ParticleTypes.DRIPPING_WATER;
    }

    @Override
    protected boolean canConvertToSource(Level pLevel) {
        return pLevel.getGameRules().getBoolean(GameRules.RULE_WATER_SOURCE_CONVERSION);
    }

    @Override
    protected void beforeDestroyingBlock(LevelAccessor pLevel, BlockPos pPos, BlockState pState) {
        BlockEntity blockentity = pState.hasBlockEntity() ? pLevel.getBlockEntity(pPos) : null;
        Block.dropResources(pState, pLevel, pPos, blockentity);
    }

    @Override
    public int getSlopeFindDistance(LevelReader pLevel) {
        return 4;
    }

    @Override
    public BlockState createLegacyBlock(FluidState pState) {
        return ModBlocks.POTATO_WATER_BLOCK.get().defaultBlockState().setValue(LiquidBlock.LEVEL, getLegacyLevel(pState));
    }

    @Override
    public boolean isSource(FluidState pState) {
        return false;
    }

    @Override
    public boolean isSame(Fluid pFluid) {
        return pFluid == ModFluids.SOURCE_POTATO_WATER.get() || pFluid == ModFluids.FLOWING_POTATO_WATER.get();
    }

    @Override
    public int getDropOff(LevelReader pLevel) {
        return 1;
    }

    @Override
    public int getAmount(FluidState pState) {
        return 0;
    }

    @Override
    public int getTickDelay(LevelReader pLevel) {
        return 5;
    }

    @Override
    public boolean canBeReplacedWith(FluidState pFluidState, BlockGetter pBlockReader, BlockPos pPos, Fluid pFluid, Direction pDirection) {
        return pDirection == Direction.DOWN && !pFluid.is(FluidTags.WATER);
    }

    @Override
    protected float getExplosionResistance() {
        return 100.0F;
    }

    @Override
    public Optional<SoundEvent> getPickupSound() {
        return Optional.of(SoundEvents.BUCKET_FILL);
    }

    public static class Flowing extends PotatoWaterFluid {
        protected Flowing(Properties properties) {
            super(properties);
        }

        @Override
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> pBuilder) {
            super.createFluidStateDefinition(pBuilder);
            pBuilder.add(LEVEL);
        }

        @Override
        public int getAmount(FluidState pState) {
            return pState.getValue(LEVEL);
        }

        @Override
        public boolean isSource(FluidState pState) {
            return false;
        }
    }

    public static class Source extends PotatoWaterFluid {
        protected Source(Properties properties) {
            super(properties);
        }

        @Override
        public int getAmount(FluidState pState) {
            return 8;
        }

        @Override
        public boolean isSource(FluidState pState) {
            return true;
        }
    }
}