package com.denger.melody.module.misc;

import com.denger.melody.module.Module;

import static com.denger.melody.Melody.mc;
import static com.denger.melody.Melody.modules;

public class Panic extends Module {
    public Panic() {
        super("Panic", 0, Category.MISC, "Off Cheat");
    }

    @Override
    public boolean onEnable() {
        for (Module module : modules){
            module.setToggled(false);
            module.setKeyCode(0);
        }
        mc.setScreen(null);
        return false;
    }
}
