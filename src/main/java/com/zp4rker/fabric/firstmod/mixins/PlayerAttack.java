package com.zp4rker.fabric.firstmod.mixins;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author zp4rker
 */
@Mixin(PlayerEntity.class)
public abstract class PlayerAttack {
    @Shadow public abstract void sendMessage(Text message, boolean actionBar);

    @Inject(at = @At("HEAD"), method = "attack")
    private void playerAttack(Entity target, CallbackInfo info) {
        this.sendMessage(Text.of("You attacked!"), false);
    }
}
