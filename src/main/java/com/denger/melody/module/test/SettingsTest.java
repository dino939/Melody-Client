package com.denger.melody.module.test;

import com.denger.melody.clickgui.settings.NumberSetting;
import com.denger.melody.module.Module;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class SettingsTest extends Module {
    public SettingsTest()
    {
        super("TestSettings",0,Category.COMBAT,"Do big hitbox");
        addSetting(Settings);
    }
    public static NumberSetting Settings = new NumberSetting("Settings",1,100,50,1);
    @SubscribeEvent
    public void onTick(TickEvent e)
    {
        final float value = (float) Settings.getValueFloat();
        System.out.println(value);
    }
}
