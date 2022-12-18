//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\deobf\Minecraft-Deobfuscator3000-1.2.3\1.12 stable mappings"!

//Decompiled by Procyon!

package com.denger.melody.module.combat;

import com.denger.melody.module.Module;
import com.denger.melody.utils.freands.FreandManager;
import io.netty.util.internal.ThreadLocalRandom;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerController;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.util.Hand;


public class AutoClicker extends Module
{
    Minecraft mc = Minecraft.getInstance();
    private double holdLength;
    private double min;
    private long hold;
    private double max;
    private boolean clicked;

    private double speed;
    private long lastClick;
    
    @Override
    public boolean onEnable() {
        super.onEnable();
        this.updateVals();
        return false;
    }
    public AutoClicker() {
        super("AutoClicker",0,Category.COMBAT,"Auto punch ");

    }

    private void updateVals() {
        this.min =  20;
        this.max = 20;
        if (this.min >= this.max) {
            this.max = this.min + 1.0;
        }
        this.speed = 1.0 / ThreadLocalRandom.current().nextDouble(this.min - 0.2, this.max);
        this.holdLength = this.speed / ThreadLocalRandom.current().nextDouble(this.min, this.max);
    }
    @SubscribeEvent
    public void onClick(InputEvent.MouseInputEvent event) {
        if (event.getAction() == 1){
            if (event.getButton() == 0){
                clicked = true;
            }
            else {clicked = false;}

        }
        else {clicked = false;}


    }
    @SubscribeEvent
    public void onTick(TickEvent event)  {
            if (mc.screen==null && clicked){
            if (System.currentTimeMillis() - this.lastClick > this.speed * 1000.0) {
                this.lastClick = System.currentTimeMillis();
                if (this.hold < this.lastClick) {
                    this.hold = this.lastClick;
                }
                try {
                    Entity target = ((EntityRayTraceResult) mc.hitResult).getEntity();

                    if (mc.player.getAttackStrengthScale(0) == 1) {
                        if (!FreandManager.isFriend(target.getName().getString())){
                            new PlayerController(mc, mc.player.connection).attack(mc.player, target);
                            mc.player.swing(Hand.MAIN_HAND);
                        }
                    }
                } catch (Exception ignored) {
                }
                this.updateVals();
            }
            else if (System.currentTimeMillis() - this.hold > this.holdLength * 1000.0) {
                KeyBinding.set(mc.options.keyAttack.getKey(), false);
                this.updateVals();

        }
    }
    }
}
