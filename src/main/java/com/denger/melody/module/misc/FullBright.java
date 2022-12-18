package com.denger.melody.module.misc;

import com.denger.melody.module.Module;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static com.denger.melody.Melody.mc;

public class FullBright extends Module {
    public FullBright(){
        super("FullBright",0,Category.MISC,"just FullBright");
    }
    double old;
    @Override
    public boolean onEnable() {
        mc.player.addEffect(new EffectInstance(Effect.byId(16),999999999));
        return false;
    }
    @Override
    public void onDisable() {
        mc.player.removeEffect(Effect.byId(16));
    }

    @SubscribeEvent
    public void onLeave(LivingEvent.LivingUpdateEvent e){
        this.onDisable();
    }

}
