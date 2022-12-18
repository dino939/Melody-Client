package com.denger.melody.clickgui.components;

import com.denger.melody.clickgui.Button;
import com.denger.melody.clickgui.settings.ModeSetting;
import com.denger.melody.clickgui.settings.Setting;
import com.denger.melody.Melody;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.IngameGui;

import java.awt.*;

public class ModeBox extends Component {
    private final ModeSetting modeSetting;

    public ModeBox(Setting setting, Button parent, int shifting) {
        super(setting, parent, shifting);
        this.modeSetting = (ModeSetting) setting;
    }

    @Override
    public void draw(MatrixStack m, int mouseX, int mouseY) {
        int textShifting = ((parent.parent.height / 2) - Melody.mc.font.lineHeight / 2);

        IngameGui.fill(m, parent.parent.x, parent.parent.y + parent.shifting + shifting - 2, parent.parent.x + parent.parent.width, parent.parent.y + parent.shifting + shifting + parent.parent.height - 2, new Color(0x33000000, true).hashCode());
        Melody.mc.font.draw(m, modeSetting.getName() + ":" + modeSetting.getMode(), parent.parent.x + textShifting, parent.parent.y + parent.shifting + shifting + textShifting - 3, -1);
        super.draw(m, mouseX, mouseY);
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (isHovered(mouseX, mouseY)) {
            if (mouseButton == 0) {
                modeSetting.cycle();
            }
        }
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }
}
