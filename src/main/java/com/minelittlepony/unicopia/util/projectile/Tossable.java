package com.minelittlepony.unicopia.util.projectile;

import com.minelittlepony.unicopia.magic.Caster;

import net.minecraft.block.BlockState;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;

public interface Tossable<T> {

    /**
     * Called once the projectile lands either hitting the ground or an entity.
     */
    void onImpact(Caster<?> caster, BlockPos pos, BlockState state);

    /**
     * The sound made when thrown.
     */
    default SoundEvent getThrowSound(T stack) {
        return SoundEvents.ENTITY_SNOWBALL_THROW;
    }

    /**
     * The amount of damage to be dealt when the projectile collides with an entity.
     */
    default int getThrowDamage(T stack) {
        return 0;
    }
}