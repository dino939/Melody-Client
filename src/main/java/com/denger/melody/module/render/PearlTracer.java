package com.denger.melody.module.render;

import com.denger.melody.module.Module;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EnderPearlEntity;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static com.denger.melody.Melody.mc;

public class PearlTracer extends Module {
    public PearlTracer(){
        super("PearlTracer",0,Category.RENDER," ");
    }
    @SubscribeEvent
    public void onRender(RenderWorldLastEvent e) {
        for (final Entity entity : mc.level.entitiesForRendering()){
            if (entity instanceof EnderPearlEntity){
                entity.setGlowing(true);
            }
        }

    }
}
