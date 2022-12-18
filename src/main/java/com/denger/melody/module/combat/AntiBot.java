package com.denger.melody.module.combat;

import com.denger.melody.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class AntiBot  extends Module {
    public AntiBot(){
        super("AntiBot",0,Category.COMBAT,"RemoveBots");
    }
    Minecraft mc = Minecraft.getInstance();

    @SubscribeEvent
    public void onUpdate(RenderPlayerEvent event) {
        if (mc.level != null) {
       for(final Entity entity : mc.level.entitiesForRendering()){
           if (entity instanceof PlayerEntity && entity.isInvisible() && entity != this.mc.player){
               entity.remove();
           }
            }
        }
    }
}
