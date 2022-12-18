package com.denger.melody.module.test;

import com.denger.melody.module.Module;
import com.denger.melody.clickgui.settings.NumberSetting;
import com.denger.melody.utils.AnimationUtils;
import com.denger.melody.utils.ColorUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.awt.*;

import static com.denger.melody.Melody.mc;

public class TestUtill extends Module {


    public TestUtill(){super("Test",0,Category.HUD,"Test module");}
    int x = 10;
    int y = 10;
    int range = 2;
    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent e) {

        if (isToggled()) {
            if (e.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
                assert mc.player != null;
                if (mc.screen instanceof ChatScreen) {
                    //RenderUtil.drawSmoothRect(  x , y , x + 165, y + 180/range, new Color(0x4DFFFFFF, true).hashCode());
                }
                            //RenderUtil.renderBlurredShadow(x, y, x + 165, y + 180/range,1,Color.WHITE);

                            //RenderUtil.drawShadow(x, y, x + 165, y + 180/range,5,Color.WHITE.hashCode() );



            }
        }
    }


    @SubscribeEvent
    public void onMouseDrag(GuiScreenEvent.MouseDragEvent e) {
        if (mc.screen instanceof ChatScreen) {
            assert mc.player != null;
            if (e.getMouseX() > x && e.getMouseX() < x + 165 && e.getMouseY() > y && e.getMouseY() < y + 90) {
                if (e.getMouseButton() == 0){
                    x = (int) e.getMouseX() - 165/2 ;
                    y = (int) e.getMouseY() - 90/range;}

            }

        }
    }
}
