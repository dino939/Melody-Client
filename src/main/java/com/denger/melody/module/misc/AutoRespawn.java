package com.denger.melody.module.misc;

import com.denger.melody.module.Module;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static com.denger.melody.Melody.mc;

public class AutoRespawn extends Module {
    public AutoRespawn() {
        super("AutoRespawn", 0, Category.MISC, "Automatically starts running when you walk");
    }

    @SubscribeEvent
    public void onTick(TickEvent e) {
        if (isToggled()) {
            assert mc.player != null;
            if (mc.player.isDeadOrDying()) {
                try {
                    mc.player.respawn();
                } catch (Exception ex) {}

            }
        }
    }
}