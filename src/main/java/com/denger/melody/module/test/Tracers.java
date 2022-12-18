package com.denger.melody.module.test;

import com.denger.melody.module.Module;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;


public class Tracers extends Module
{
    public Tracers() {
        super("Tracers", 0, com.denger.melody.module.Category.RENDER, "render lines from your crosshair to players");
    }

    @SubscribeEvent
    public void onWorldRender(final RenderWorldLastEvent renderWorldLastEvent) {

    }
}
//Vector3d