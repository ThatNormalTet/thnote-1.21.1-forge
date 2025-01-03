package com.thnote.thnotemod.block.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;

public class Test extends Block {
    public Test(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        List<BlockPos> pPosList = List.of(pPos.east(), pPos.west(), pPos.south(), pPos.north(), pPos.above(), pPos.below());

        spread(pPosList, pState, pLevel);

        return InteractionResult.SUCCESS_NO_ITEM_USED;
    }

    private void spread(List<BlockPos> pPosList, BlockState pState, Level pLevel){
        for (BlockPos blockPos : pPosList) {
            if (isAir(pLevel.getBlockState(blockPos))) {
                pLevel.setBlock(blockPos, pState, 3);
            }
        }
    }
}
