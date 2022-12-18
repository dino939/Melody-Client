package com.denger.melody.module.misc;

import com.denger.melody.module.Module;
import com.denger.melody.utils.freands.FreandManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static com.denger.melody.Melody.mc;

public class MiddleClick extends Module {
    public MiddleClick(){
        super("MiddleClick",0,Category.MISC,"MiddleClick");
    }
    int a = 0;
    @SubscribeEvent
    public void onMiddleClick(InputEvent.MouseInputEvent event) {


        try {
            Entity target = ((EntityRayTraceResult) mc.hitResult    ).getEntity();
            if (mc.player == null || mc.level == null) return;

            if (event.getButton() == 2) {
                if (mc.hitResult != null) {
                    if (target instanceof PlayerEntity){
                        if (a != 1)
                        {
                            FreandManager.toggleFriend((target.getEntity().getName().getString()));
                        a = 1;
                        }
                        else if(a == 1)
                        {
                        a = 0;
                        }
                    }

                }

            }
        }
        catch (Exception ignored) {
        }
    }
}
