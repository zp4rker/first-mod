package com.zp4rker.fabric.firstmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientEntityEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

/**
 * @author zp4rker
 */
public class FirstMod implements ModInitializer {
    @Override
    public void onInitialize() {
        System.out.println("Mod loaded!");

        ClientEntityEvents.ENTITY_LOAD.register((entity, world) -> {
            if (entity instanceof PlayerEntity player) {
                Text msg = new LiteralText("Hello! Welcome to my first mod!").formatted(Formatting.GOLD);
                player.sendMessage(msg, false);
                player.playSound(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
            }
        });
    }
}
