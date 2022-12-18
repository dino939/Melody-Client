package com.denger.melody.module.test;

import com.denger.melody.module.Module;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static com.denger.melody.Melody.mc;

public class noNight extends Module {
    public noNight(){
        super("noNight",0,Category.MISC,"no MoonLight");
    }
long Day = (long) 6164.0;
    @SubscribeEvent
    public void onTick(TickEvent e) {
        if (isToggled()) {
            mc.level.setDayTime(Day);
        }
    }

}
//Day == 1037.0
//Midnight == 18037.0
//Night == 13042.0
//Noon == 6164.0