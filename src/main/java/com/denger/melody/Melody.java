package com.denger.melody;

import com.denger.melody.clickgui.ClickGUIScreen;
import com.denger.melody.module.Module;
import com.denger.melody.module.ModuleManager;
import com.denger.melody.module.test.BetaFunc;
import com.denger.melody.utils.PythonUtills;
import com.denger.melody.utils.ChatUtills;
import com.denger.melody.utils.Names;
import com.denger.melody.utils.hwid.Hwider;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.io.IOException;
import java.util.ArrayList;

@Mod(Names.Moded)
public class Melody {
    public static final Minecraft mc = Minecraft.getInstance();
    public static final PythonUtills py = PythonUtills.python;

    public static ClickGUIScreen GuiScreen;
    public static ModuleManager MManager;
    public static Melody instance;

    public static ArrayList<Module> modules = new ArrayList<>();
    public Melody() throws IOException {
        instance = this;
        Hwider.Alfa();
        MinecraftForge.EVENT_BUS.register(new ChatUtills());
        MinecraftForge.EVENT_BUS.register(this);

    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent e) {
        if (mc.level != null && mc.player != null) {
            if (e.getAction() == 1 && mc.screen == null) {
               for (Module m : modules) {
                   if (m.getKeyCode() == e.getKey()) {
                        m.toggle();
                   }
                }
            }
        }
    }
}
