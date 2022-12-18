package com.denger.melody.module.hud;

import com.denger.melody.clickgui.settings.ModeSetting;
import com.denger.melody.module.Module;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import com.denger.melody.utils.MathUtils;
import com.denger.melody.utils.RenderUtil;


import static com.denger.melody.Melody.mc;
import static com.denger.melody.Melody.modules;

public class ModuleList extends Module {

    public static ModeSetting mode = new ModeSetting("Mode","Left","Right");
    public static ModeSetting Type = new ModeSetting("Type","2","1");

    public ModuleList() {
        super("ModuleList", 0, Category.HUD, "Shows enabled modules");
        addSetting(mode);
        addSetting(Type);}
    float x;
    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent e) {
        String  Mod = mode.getMode();
        if (Mod.equals("Left"))
        {
             x = 10f;
            float y = 25f;
            float distance = 12f;
            if (isToggled()) {

                if (e.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
                    java.util.ArrayList<Module> enabledMods = new java.util.ArrayList<>();

                    for (Module module : modules) {
                        if (module.isToggled()) {
                            module.anim = MathUtils.harp(module.anim, 1, 0.3f);
                            enabledMods.add(module);
                        } else {
                            module.anim = MathUtils.harp(module.anim, -10, 0.3f);
                        }
                    }


                    enabledMods.sort((module1, module2) -> mc.font.width(module2.getName()) - mc.font.width(module1.getName()));

                    for (Module m : enabledMods) {
                        if (Type.getMode().equals("1")){
                        RenderUtil.drawCastom((int) (x * m.anim), (int) y, (int) (x * m.anim + mc.font.width(m.name) + 6), (int) (y + 10), 1);}
                        else   if (Type.getMode().equals("2")){
                            RenderUtil.drawCastomLitium((int) (x * m.anim), (int) y, (int) (x * m.anim + mc.font.width(m.name) + 6), (int) (y + 10), 1);}


                        mc.font.drawShadow(e.getMatrixStack(), m.name, x * m.anim + 5, y + 1, -1);
                        y += distance;

                    }
                }
            }
        }



        if (Mod.equals("Right")){
            try {
                x = mc.screen.width - 15;
            }catch (Exception exception){}
            float y = 25f;
            float distance = 12f;
            if (isToggled()) {

                if (e.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
                    java.util.ArrayList<Module> enabledMods = new java.util.ArrayList<>();

                    for (Module module : modules){
                        if (module.isToggled()){
                            module.anim = MathUtils.lerp(module.anim,1 ,0.3f);
                            enabledMods.add(module);
                        }
                        else {module.anim = MathUtils.lerp(module.anim,10,0.3f);}
                    }

                    enabledMods.sort((module1, module2) -> mc.font.width(module2.getName()) - mc.font.width(module1.getName()));

                    for (Module m : enabledMods) {

                        int xpos = ((int) (x * m.anim - mc.font.width(m.name)) );
                        if (Type.getMode().equals("1")){
                            RenderUtil.drawCastom((int) (x * m.anim - mc.font.width(m.name)) - 3, (int) y, (int) (x * m.anim) + 2, (int) (y + 10),1);}
                        else   if (Type.getMode().equals("2")){
                            RenderUtil.drawCastomLitium((int) (x * m.anim - mc.font.width(m.name)) - 3, (int) y, (int) (x * m.anim) + 2, (int) (y + 10),1);}
                        mc.font.drawShadow(e.getMatrixStack(), m.name, xpos, y + 1, -1);
                        y += distance;

                    }
                }
            }
        }
    }
}

