package com.thnote.thnotemod.fluid;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import java.util.List;

public class GasFluid extends ForgeFlowingFluid {
    protected GasFluid(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isSource(FluidState pState) {
        return false;
    }

    @Override
    public int getAmount(FluidState pState) {
        return 0;
    }

    @Override
    public void tick(Level pLevel, BlockPos pPos, FluidState pState) {
        List<BlockPos> pPosList = List.of(pPos.east(), pPos.west(), pPos.south(), pPos.north());

        if (!pState.isSource()){
            FluidState fluidState = pLevel.getFluidState(pPos);
            FluidState downFluidState = pLevel.getFluidState(pPos.below());
            if (downFluidState.isEmpty() && fluidState.getValue(FALLING)){
                pLevel.setBlock(pPos, Blocks.AIR.defaultBlockState(), 2);
                pLevel.updateNeighborsAt(pPos, pLevel.getBlockState(pPos).getBlock());
            }
            int sourceNeighbours = 0;
            if (!fluidState.getValue(FALLING) && !isSource(fluidState)){
                for (BlockPos pos : pPosList){
                    FluidState fluidState1 = pLevel.getFluidState(pos);
                    if (!fluidState1.isEmpty() && fluidState1.getAmount() > fluidState.getAmount()){
                        sourceNeighbours++;
                    }
                }
                if (sourceNeighbours==0){
                    if (fluidState.getAmount() > 1){
                        if (fluidState.getAmount() == 7){
                            pLevel.setBlock(pPos, Blocks.AIR.defaultBlockState(), 2);
                            pLevel.updateNeighborsAt(pPos, pLevel.getBlockState(pPos).getBlock());

                        }else {
                            FluidState fluidState1 = this.getFlowing(fluidState.getAmount()-1, fluidState.getValue(FALLING));
                            pLevel.setBlock(pPos, fluidState1.createLegacyBlock(), 2);
                            pLevel.updateNeighborsAt(pPos, pLevel.getBlockState(pPos).getBlock());
                        }

                    }else {
                        pLevel.setBlock(pPos, Blocks.AIR.defaultBlockState(), 2);
                        pLevel.updateNeighborsAt(pPos, pLevel.getBlockState(pPos).getBlock());
                    }
                }
            }
        }


        spread(pLevel, pPos, pState);
    }

    @Override
    protected void spread(Level pLevel, BlockPos pPos, FluidState pState) {
        BlockPos upPos = pPos.above();
        List<BlockPos> pPosList = List.of(pPos.east(), pPos.west(), pPos.south(), pPos.north());

        spreadUp(upPos, pState, pLevel);
        spreadSides(pPos, pPosList, pState, pLevel);
    }

    private void spreadUp(BlockPos pPos, FluidState pState, Level pLevel){
        FluidState newFluidState = this.getFlowing(8, true);

        if (pLevel.getBlockState(pPos).is(Blocks.AIR)){

            pLevel.setBlock(pPos, newFluidState.createLegacyBlock(), 3);
        }
    }

    private void spreadSides(BlockPos pPos, List<BlockPos> pPosList, FluidState pState, Level pLevel){
        for (int i = 0; i < 4; i++) {
            if (!pLevel.getBlockState(pPos.above()).isAir() && this.getFluidType() != pLevel.getFluidState(pPos.above()).getFluidType()){
                if (pLevel.getBlockState(pPosList.get(i)).is(Blocks.AIR)){
                    if (pState.getAmount() > 1){
                        FluidState state = getFlowing(pState.getAmount()-1, false);
                        pLevel.setBlock(pPosList.get(i), state.createLegacyBlock(), 3);
                    }
                }
            }
            if (pState.isSource() && pLevel.getBlockState(pPosList.get(i)).is(Blocks.AIR)){
                FluidState state = getFlowing(7, false);
                pLevel.setBlock(pPosList.get(i), state.createLegacyBlock(), 3);
            }
        }
    }
}
