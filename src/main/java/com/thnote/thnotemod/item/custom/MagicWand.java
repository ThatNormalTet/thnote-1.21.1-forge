package com.thnote.thnotemod.item.custom;

import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SnowballItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class MagicWand extends SnowballItem {
    public MagicWand(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        pLevel.playSound(
                null,
                pPlayer.getX(),
                pPlayer.getY(),
                pPlayer.getZ(),
                SoundEvents.BEACON_ACTIVATE,
                SoundSource.NEUTRAL,
                0.5F,
                0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F)
        );
        if (!pLevel.isClientSide) {
            Vec3 vec3 = Vec3.directionFromRotation(pPlayer.getXRot(), pPlayer.getYRot());
            Fireball fireball = new LargeFireball(pLevel, pPlayer, vec3, 3);
            fireball.setPos(pPlayer.getX(), pPlayer.getY()+1, pPlayer.getZ());
            pLevel.addFreshEntity(fireball);
        }

        return InteractionResultHolder.success(pPlayer.getItemInHand(pHand));
    }

    @Override
    public Projectile asProjectile(Level pLevel, Position pPos, ItemStack pStack, Direction pDirection) {
        Snowball snowball = new Snowball(pLevel, pPos.x(), pPos.y(), pPos.z());
        snowball.setItem(pStack);
        return snowball;
    }
}
