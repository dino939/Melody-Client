package com.denger.melody.module.hud;

import com.denger.melody.clickgui.settings.ModeSetting;
import com.denger.melody.module.Module;
import com.denger.melody.Melody;
import com.denger.melody.utils.Names;
import com.denger.melody.utils.RenderUtil;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Watermark extends Module {
    int x = 10;
    int y = 10;
    public static ModeSetting Type = new ModeSetting("Type","2","1");
    public Watermark() {
        super("Watermark", 0, Category.HUD, "Shows the watermark of the cheat");
        addSetting(Type);
    }

    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent e) {
        if (isToggled()) {
            if (e.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
                assert Melody.mc.player != null;
                try {
                    if (Type.getMode().equals("1")){
                     RenderUtil.drawCastom(x - 4, y - 1, x + Melody.mc.font.width(Names.Name +" | FPS: " + Melody.mc.fpsString.split("fps")[0]  + " | Ping: " + Melody.mc.getCurrentServer().ping + " | Time: " + new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()))) + 2, y + 10,3);}
                    else if (Type.getMode().equals("2"))
                    {
                        RenderUtil.drawCastomLitium(x - 4, y - 1, x + Melody.mc.font.width(Names.Name +" | FPS: " + Melody.mc.fpsString.split("fps")[0]  + " | Ping: " + Melody.mc.getCurrentServer().ping + " | Time: " + new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()))) + 2, y + 10,3);}
                     Melody.mc.font.drawShadow(e.getMatrixStack(), Names.Name +" | FPS: " + Melody.mc.fpsString.split("fps")[0]  + " | Ping: " + Melody.mc.getCurrentServer().ping + " | Time: " + new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis())), x + 1, y + 1, -1);

                } catch (Exception exception) {
                    if (Type.getMode().equals("1")){
                   RenderUtil.drawCastom(x - 4, y - 1, x + Melody.mc.font.width(Names.Name +" | FPS: " + Melody.mc.fpsString.split("fps")[0] + "| Name: " + Melody.mc.player.getGameProfile().getName() + "| Time:   " + new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()))) + 2, y + 10,2);}
                    else if (Type.getMode().equals("2"))
                    { RenderUtil.drawCastomLitium(x - 4, y - 1, x + Melody.mc.font.width(Names.Name +" | FPS: " + Melody.mc.fpsString.split("fps")[0] + "| Name: " + Melody.mc.player.getGameProfile().getName() + "| Time:   " + new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()))) + 2, y + 10,2);}

                   Melody.mc.font.drawShadow(e.getMatrixStack(), Names.Name +" | FPS: " + Melody.mc.fpsString.split("fps")[0] + "| Name: " + Melody.mc.player.getGameProfile().getName() + " | Time: " + new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis())), x + 1, y + 1, -1);

                }
            }
        }
    }

    @SubscribeEvent
    public void onMouseDrag(GuiScreenEvent.MouseDragEvent e) {
        if (Melody.mc.screen instanceof ChatScreen) {
            assert Melody.mc.player != null;
            try {
                if (e.getMouseX() > x - 1 && e.getMouseX() < x + Melody.mc.font.width(Names.Name +" | FPS: " + Melody.mc.fpsString.split("fps")[0] + " | Ping: " + Objects.requireNonNull(Melody.mc.getCurrentServer()).ping + " | Time: " + new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()))) + 2 && e.getMouseY() > y - 3 - 20 && e.getMouseY() < y + 15 + 20) {
                    x = (int) e.getMouseX() - Melody.mc.font.width(" | FPS: " + Melody.mc.fpsString.split("fps")[0] + "| Name: " + " | Ping: " + Objects.requireNonNull(Melody.mc.getCurrentServer()).ping + " | Time: " + new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()))) / 2 + 1;
                    y = (int) e.getMouseY() - 5;
                }
            } catch (Exception exception) {
                if (e.getMouseX() > x  - 1 && e.getMouseX() < x + Melody.mc.font.width(Names.Name +" | FPS: " + Melody.mc.fpsString.split("fps")[0] + "| Name: " + Melody.mc.player.getGameProfile().getName() + " | Time: " + new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()))) + 2 && e.getMouseY() > y - 3 - 20 && e.getMouseY() < y + 15 + 20) {
                    x = (int) e.getMouseX() - Melody.mc.font.width(Names.Name +" | FPS: " + Melody.mc.fpsString.split("fps")[0] + "| Name: " + Melody.mc.player.getGameProfile().getName() + " | Time: " + new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()))) / 2 + 1;
                    y = (int) e.getMouseY() - 5;
                }
            }
        }
    }
}
