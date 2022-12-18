package com.denger.melody.module.hud;

import com.denger.melody.module.Module;
import com.denger.melody.notifications.NotificationManager;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class Notifications extends Module {
    public Notifications() {
        super("Notifications", 0, Category.HUD, "Shows the watermark of the cheat");
    }

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent event){
        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            NotificationManager.render(event.getMatrixStack(), event);
        }
    }
}
