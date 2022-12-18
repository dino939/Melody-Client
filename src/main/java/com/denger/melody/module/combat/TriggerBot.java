package com.denger.melody.module.combat;

import com.denger.melody.module.Module;
import com.denger.melody.utils.freands.FreandManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerController;
import net.minecraft.entity.Entity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class TriggerBot extends Module {
    public TriggerBot() {
        super("TriggerBot",0,Category.COMBAT,"Auto Hit");
    }
    Minecraft mc = Minecraft.getInstance();
    @SubscribeEvent
    public void onRender(RenderWorldLastEvent e) {
        if (mc.hitResult != null) {
            try {
                Entity target = ((EntityRayTraceResult) mc.hitResult).getEntity();

                if (mc.player.getAttackStrengthScale(0) == 1) {
                    if (!FreandManager.isFriend(target.getName().getString())){
                    new PlayerController(mc, mc.player.connection).attack(mc.player, target);
                    mc.player.swing(Hand.MAIN_HAND);
                    mc.player.resetAttackStrengthTicker();
                    }
                }
            } catch (Exception ignored) {
            }
        }
    }
}