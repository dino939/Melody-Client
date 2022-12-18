package com.denger.melody.module.misc;

import com.denger.melody.module.Module;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static com.denger.melody.Melody.mc;

public class AutoSprint extends Module {
    public AutoSprint() {super("AutoSprint", 0, Category.MISC, "Automatically starts running when you walk");}

    @SubscribeEvent
    public void onTick(TickEvent e) {
        if (isToggled()) {
            mc.options.keySprint.setDown(true);
        }
    }
}
