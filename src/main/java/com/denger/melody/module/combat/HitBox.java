package com.denger.melody.module.combat;

import com.denger.melody.clickgui.settings.NumberSetting;
import com.denger.melody.module.Module;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static com.denger.melody.Melody.mc;

public class HitBox extends Module {

    public HitBox(){
        super("HitBox",0,Category.COMBAT,"Do big hitbox");
        addSetting(Settings);
    }
    public static NumberSetting Settings = new NumberSetting("Settings",0,10,0.3,1);

    @SubscribeEvent
    public void onUpdate(RenderPlayerEvent e) {
        float Size = (float) Settings.getValueFloat();
        Entity player = e.getEntity();

        if (player != mc.player) {

            player.setBoundingBox(new AxisAlignedBB(
                            player.getX() - Size,
                            player.getBoundingBox().minY,
                            player.getZ() - Size,
                            player.getX() + Size,
                            player.getBoundingBox().maxY,
                            player.getZ() + Size
                    )
            );
        }
    }
}
