package com.zp4rker.fabric.firstmod.mixins;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author zp4rker
 */
@Mixin(PlayerEntity.class)
public abstract class PlayerJump {
    @Shadow public abstract void sendMessage(Text message, boolean actionBar);

    @Inject(at = @At("HEAD"), method = "jump()V")
    private void playerJump(CallbackInfo info) {
        Entity entity = ((Entity) (Object) this);
        BlockPos pos = entity.getBlockPos();
        String coords = "X: " + pos.getX() + " Y: " + pos.getY() + " Z: " + pos.getZ();
        this.sendMessage(Text.of(coords), false);
    }
}
