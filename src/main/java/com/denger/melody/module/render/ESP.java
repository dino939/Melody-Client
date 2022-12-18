package com.denger.melody.module.render;

import com.denger.melody.module.Module;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static com.denger.melody.Melody.mc;

public class ESP extends Module {
    public ESP() {
        super("ESP", 0, Category.RENDER, "Shows players through walls");
    }

    @SubscribeEvent
    public void onRender(RenderPlayerEvent e) {
        if (isToggled()) {
            e.getEntity().setGlowing(true);
        }
    }

    @Override
    public void onDisable() {
        assert mc.level != null;
        for (PlayerEntity p : mc.level.players()) {
            p.setGlowing(false);
        }
    }
}
