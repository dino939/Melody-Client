package com.denger.melody.clickgui;

import com.denger.melody.module.Category;
import com.denger.melody.module.Module;
import com.denger.melody.utils.HoverUtil;
import com.denger.melody.utils.RenderUtil;
import com.denger.melody.utils.TimerUtil;
import com.denger.melody.Melody;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.denger.melody.clickgui.components.Component;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;


public class Frame {
    public List<Button> buttonList = new ArrayList<>();
    public int x, y, width, height;
    public boolean extended, dragging;
    public Category category;
    static int scrollHeight = 160;
    int scrollShifting;
    TimerUtil scrollDelay = new TimerUtil();

    public Frame(int x, int y, int width, int height, Category category) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.category = category;
        int y1 = y + height;
        int shifting = height;

        for (Module m : Melody.modules) {
            if (m.getCategory() == category) {
                buttonList.add(new Button(m, x, y1, width + 2, height, this, shifting));
                y1 += height;
                shifting += height;
            }
        }
    }

    public void render(MatrixStack m, int mouseX, int mouseY, float partialTicks) {
        RenderUtil.drawCastom( x, y, x + width, extended ? y + height + scrollHeight : y + height, 1);
        RenderUtil.drawCastom(x - 1, y - 1, x + width + 1, y, 1);
        RenderUtil.drawCastom( x - 1, extended ? y + height + scrollHeight : y + height, x + width + 1, extended ? y + height + scrollHeight + 1 : y + height + 1, 1);
        RenderUtil.drawSmoothRect( x + width / 2 - Melody.mc.font.width(category.name()) / 2, y + 13, x + width / 2 + Melody.mc.font.width(category.name()) / 2, y + 14, -1);
        Melody.mc.font.drawShadow(m, category.name(), x + width / 2 - Melody.mc.font.width(category.name()) / 2, y + 3, -1);
        if (extended) {
            int y1 = y + height;

            for (Button b : buttonList) {
                b.x = x;
                b.y = y1;
                y1 += height;
                if (b.shifting > 0 && b.shifting < scrollHeight + 16) {
                    b.render(m, mouseX, mouseY, partialTicks);
                }
            }
        }
        if (dragging) {
            x = mouseX - width / 2;
            y = mouseY - height / 2;
        }
    }

    public void mouseClicked(double mouseX, double mouseY, int mouseButton) {
        if (mouseX > x - 1 && mouseY > y + height + scrollHeight && mouseX < x + width + 1 && mouseY < y + height + scrollHeight + 5) {
            if (mouseButton == 0 && scrollHeight < 240) {
                scrollHeight += 16;
            } else if (mouseButton == 1 && scrollHeight > 96) {
                scrollHeight -= 16;
            }
        }
        if (mouseX > x && mouseY > y && mouseX < x + width && mouseY < y + height && mouseButton == 0) {
            dragging = true;
        }
        if (HoverUtil.hovered((int) mouseX, (int) mouseY, x, y, x + width, y + height)) {
            if (mouseButton == 1) {
                extended = !extended;
            }
        }
        if (extended) {
            for (Button b : buttonList) {
                if (b.shifting > 0 && b.shifting < scrollHeight + 16) {
                    b.mouseClicked(mouseX, mouseY, mouseButton);
                }
            }
        }
    }

    public void keyPressed(int keyCode) {
        if (keyCode == GLFW.GLFW_KEY_RIGHT) {
            x += 10;
        }
        if (keyCode == GLFW.GLFW_KEY_LEFT) {
            x -= 10;
        }
        if (keyCode == GLFW.GLFW_KEY_DOWN) {
            y += 10;
        }
        if (keyCode == GLFW.GLFW_KEY_UP) {
            y -= 10;
        }
        for (Button b : buttonList) {
            b.keyPressed(keyCode);
        }
    }

    public void mouseReleased(double p_231044_1_, double p_231044_3_, int p_231044_5_) {
        dragging = false;
        for (Button b : buttonList) {
            b.mouseReleased(p_231044_1_, p_231044_3_, p_231044_5_);
        }
    }

    public void mouseScrolled(double p_231043_1_, double p_231043_3_, double p_231043_5_) {
        for (Button b : buttonList) {
            if (scrollDelay.hasReached(1) && HoverUtil.hovered((int) p_231043_1_, (int) p_231043_3_, x, y, x + width, y + height + scrollHeight)) {
                if (p_231043_5_ == 1) {
                    if (b.shifting > scrollHeight - 16) {
                        scrollShifting -= 16;
                        updateButtons();
                        scrollDelay.reset();
                    }
                } else if (b.shifting < 32) {
                    scrollShifting += 16;
                    updateButtons();
                    scrollDelay.reset();
                }
            }
        }
    }

    public void updateButtons() {
        int shifting = height;

        for (Button b : buttonList) {
            b.shifting = shifting + scrollShifting;
            shifting += height;
            if (b.extended) {
                for (Component c : b.components) {
                    if (c.setting.isVisible()) {
                        shifting += height;
                    }
                }
            }
        }
    }
}
