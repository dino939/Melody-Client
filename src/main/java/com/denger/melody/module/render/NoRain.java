package com.denger.melody.module.render;

import com.denger.melody.module.Module;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static com.denger.melody.Melody.mc;

public class NoRain extends Module {
    public NoRain() {
        super("NoRain", 0, Category.RENDER, "Dont show rain");
    }
    float lastRain;

    @SubscribeEvent
    public void RenderWorldLastEvent(RenderWorldLastEvent e) {
        if (mc.level != null & mc.player != null) return;
        if (isToggled())
        {
            mc.level.setRainLevel(0.0f);
        }
    }
}
//Rain ON = 1.0f
//Rain OFF = 0.0f