package com.denger.melody.module;

import com.denger.melody.Melody;
import com.denger.melody.module.hud.*;
import com.denger.melody.module.misc.*;
import com.denger.melody.module.combat.*;
import com.denger.melody.module.render.*;
import com.denger.melody.module.test.BetaFunc;
import com.denger.melody.module.test.TestUtill;
import com.denger.melody.module.test.Tracers;

import java.util.ArrayList;

import static com.denger.melody.utils.hwid.HWID.ABOBA;

public class ModuleManager {
    ArrayList<Module> modules = Melody.modules;

    public ModuleManager(){
        //Render
        modules.add(new ESP());
        modules.add(new NoRain());
        modules.add(new setTime());
        modules.add(new FullBright());
        modules.add(new PearlTracer());
        modules.add(new ViewModel());
        //Hud
        modules.add(new Watermark());
        modules.add(new TargetHud());
        modules.add(new Notifications());
        modules.add(new ModuleList());
        modules.add(new ClickGUI());
        //Misc
        modules.add(new AutoRespawn());
        modules.add(new AutoSprint());
        modules.add(new MiddleClick());
        modules.add(new Panic());
        //Combat
        modules.add(new AimAssist());
        modules.add(new AutoClicker());
        modules.add(new TriggerBot());
        modules.add(new AntiBot());
        modules.add(new HitBox());
        //Test
        modules.add(new TestUtill());

        //modules.add(new PopaNegra());

        if (ABOBA.equals(null)) {System.exit(1);}
    }

}
