package com.denger.melody.module.render;

import com.denger.melody.clickgui.settings.ModeSetting;
import com.denger.melody.module.Module;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static com.denger.melody.Melody.mc;

public class setTime extends Module
{
    public static ModeSetting mode = new ModeSetting("Mode","Day","Noon","Night","Midnight");
    public setTime(){
        super("TimeSet",0, com.denger.melody.module.Category.RENDER,"Just time set");
        addSetting(mode);
    }

    @SubscribeEvent
    public void RenderWorldLastEvent(RenderWorldLastEvent e) {
        if (mc.level != null & mc.player != null) return;
        if (isToggled()) {
                switch (mode.getMode()) {
                    case "Day":
                        mc.level.setDayTime((long) 1037.0);
                        break;
                    case "Noon":
                        mc.level.setDayTime((long) 6164.0);
                        break;
                    case "Night":
                        mc.level.setDayTime((long) 13042.0);
                        break;
                    case "Midnight":
                        mc.level.setDayTime((long) 18037.0);
                        break;
                }
            }
    }}
