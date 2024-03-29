package com.denger.melody.clickgui;

import com.denger.melody.clickgui.components.CheckBox;
import com.denger.melody.clickgui.settings.BooleanSetting;
import com.denger.melody.clickgui.settings.ModeSetting;
import com.denger.melody.clickgui.settings.Setting;
import com.denger.melody.module.Module;
import com.denger.melody.utils.RenderUtil;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.denger.melody.clickgui.components.Component;
import com.denger.melody.clickgui.components.ModeBox;
import com.denger.melody.clickgui.components.Slider;
import com.denger.melody.clickgui.settings.NumberSetting;
import net.minecraft.client.gui.IngameGui;
import org.lwjgl.glfw.GLFW;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static com.denger.melody.Melody.mc;

public class Button {
    public Module module;
    public int x, y, width, height;
    public boolean extended;
    public com.denger.melody.clickgui.Frame parent;
    public int shifting;
    public boolean binding;
    public List<Component> components = new ArrayList<>();

    public Button(Module module, int x, int y, int width, int height, Frame parent, int shifting) {
        this.module = module;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.parent = parent;
        this.shifting = shifting;

        int setShifting = parent.height;

        for (Setting s : module.settingList) {
            if (s instanceof BooleanSetting) {
                components.add(new CheckBox(s, this, setShifting));
            } else if (s instanceof ModeSetting) {
                components.add(new ModeBox(s, this, setShifting));
            } else if (s instanceof NumberSetting) {
                components.add(new Slider(s, this, setShifting, ((NumberSetting) s).getDefaultvalue()));
            }
            setShifting += parent.height;
        }
    }

    public void render(MatrixStack m, int mx, int my, float partialTicks) {
        IngameGui.fill(m, isHovered(mx, my) ? parent.x - 2 : parent.x, parent.y + shifting, isHovered(mx, my) ? parent.x + parent.width + 2 : parent.x + parent.width, parent.y + shifting + parent.height, new Color(0x1A000000, true).hashCode());
        if (binding) {
            mc.font.drawShadow(m, "Press the key...", parent.x + parent.width / 2 - mc.font.width("Press the key...") / 2, parent.y + shifting + 2, -1);
        } else {
            if (module.isToggled()){
                int a = (mc.font.width(module.name));
                RenderUtil.drawCastom(parent.x + parent.width / 2 - mc.font.width(module.name) / 2 , parent.y + shifting + 1, parent.x + parent.width / 2 - mc.font.width(module.name) / 2 + a ,parent.y + shifting + 10, 1);
            }
            mc.font.drawShadow(m, module.name, parent.x + parent.width / 2 - mc.font.width(module.name) / 2, parent.y + shifting + 2,  -1);

        }
        if (!module.settingList.isEmpty()) {
            mc.font.drawShadow(m, extended ? ">" : "<", parent.x + width - 10, parent.y + shifting + 2,  -1);

        }
        if (isHovered(mx, my)) {
            RenderUtil.drawSmoothRect(mx + 10, my, mx + 11 + mc.font.width(module.getDescription()), my - 10, new Color(0x000000).hashCode());
            mc.font.drawShadow(m, module.getDescription(), mx + 11, my - 9, -1);
        }
        if (extended) {
            for (Component c : components) {
                c.draw(m, mx, my);
            }
        }
    }

    public void mouseReleased(double p_231044_1_, double p_231044_3_, int p_231044_5_) {
        for (Component c : components) {
            c.mouseReleased(p_231044_1_, p_231044_3_, p_231044_5_);
        }
    }

    public void mouseClicked(double mouseX, double mouseY, int mouseButton) {
        if (isHovered(mouseX, mouseY)) {
            if (mouseButton == 0) {
                module.toggle();
            } else if (mouseButton == 1) {
                extended = !extended;
                parent.updateButtons();
            } else if (mouseButton == 2) {
                binding = !binding;
            }
        }
        if (extended) {
            for (Component c : components) {
                c.mouseClicked((int) mouseX, (int) mouseY, mouseButton);
            }
        }
    }

    protected void keyPressed(int keyCode) {
        if (binding) {
            if (keyCode != GLFW.GLFW_KEY_ESCAPE) {
                if (keyCode != GLFW.GLFW_KEY_DELETE) {
                    module.keyCode = keyCode;
                } else {
                    module.keyCode = 0;
                }
            }
            binding = false;
        }
    }

    public boolean isHovered(double mouseX, double mouseY) {
        return mouseX > parent.x && mouseX < parent.x + parent.width && mouseY > parent.y + shifting && mouseY < parent.y + shifting + parent.height;
    }
}
