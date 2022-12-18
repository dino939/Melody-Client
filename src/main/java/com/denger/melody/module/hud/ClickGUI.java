package com.denger.melody.module.hud;

import com.denger.melody.Melody;
import com.denger.melody.module.Module;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;

import static com.denger.melody.utils.hwid.HWID.ABOBA;

public class ClickGUI extends Module {
    public ClickGUI() {
        super("ClickGUI", GLFW.GLFW_KEY_RIGHT_SHIFT, Category.HUD, "Opens this menu");
    }

    @Override
    public boolean onEnable() {
        if (ABOBA.equals(null)) {System.exit(1);}
        Minecraft.getInstance().setScreen(Melody.instance.GuiScreen);
        this.setToggled(false);
        super.onEnable();
        return false;
    }
}
