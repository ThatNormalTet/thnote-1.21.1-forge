package com.thnote.thnotemod.block.custom;

import com.thnote.thnotemod.block.ModBlocks;
import com.thnote.thnotemod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class Powderizer extends Block {
    public Powderizer(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult) {
        List<ItemStack> requiredItemList = List.of(
                new ItemStack(ModBlocks.RUBY_ORE.get()),
                new ItemStack(ModBlocks.POTATO_RUBY_ORE.get()),
                new ItemStack(ModBlocks.DEEPSLATE_RUBY_ORE.get()),
                new ItemStack(ModBlocks.DEEPSLATE_POTATO_RUBY_ORE.get()));

        for (ItemStack stack : requiredItemList)
            if (pPlayer.getItemInHand(pHand).getItem() == stack.getItem()) {
                Vec3 vec3 = Vec3.atLowerCornerWithOffset(pPos, 0.5, 1.01, 0.5);
                ItemEntity itemEntity = new ItemEntity(pLevel, vec3.x, vec3.y, vec3.z, checkHeldBlock(stack));
                pLevel.addFreshEntity(itemEntity);

                ItemStack itemStack = new ItemStack(pStack.getItem(), pStack.getCount() - 1);
                pPlayer.setItemInHand(pHand, itemStack);
            }
        return ItemInteractionResult.SUCCESS;
    }

    private ItemStack checkHeldBlock(ItemStack stack){
        if (stack.is(ModBlocks.RUBY_ORE.get().asItem()) || stack.is(ModBlocks.DEEPSLATE_RUBY_ORE.get().asItem())){
            return new ItemStack(ModItems.RUBY.get());
        }
        if (stack.is(ModBlocks.POTATO_RUBY_ORE.get().asItem()) || stack.is(ModBlocks.DEEPSLATE_POTATO_RUBY_ORE.get().asItem())){
            return new ItemStack(ModItems.POTATO_RUBY.get());
        }
        return new ItemStack(Items.AIR);
    }
}
