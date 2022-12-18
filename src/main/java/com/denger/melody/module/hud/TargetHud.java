package com.denger.melody.module.hud;

import com.denger.melody.module.Module;
import com.denger.melody.utils.ColorUtil;
import com.denger.melody.utils.RenderUtil;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static com.denger.melody.Melody.mc;

public class TargetHud extends Module {
    public TargetHud(){
        super("TargetHud",0,Category.HUD,"Show data with Entity");
    }
    int x = 10;
    int y = 10;
    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent e) {
        if (isToggled()) {
            if (e.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
                assert mc.player != null;

                if (mc.screen instanceof ChatScreen) {
                    PlayerEntity target = mc.player;
                    String TargetName = (" Name: "+target.getName().getString());
                    float m1 = (int) ((x + (71.5)/2) - (mc.font.width(TargetName))/2) + 45;
                    RenderUtil.drawCastom(x, y, x + 165, y + 50,2);
                    InventoryScreen.renderEntityInInventory(x + 24, y + 48, 20, 0, 0,target);
                    mc.font.drawShadow(e.getMatrixStack(),TargetName, m1+3,y + 12,-1);
                    RenderUtil.drawCastom(x + 42,y + 28 ,x + 142 ,y + 38 ,2);
                    RenderUtil.drawSmoothGradientRect(x + 42,y + 28,x + (int) (((target).getHealth() * 5) + 43) ,y + 38,ColorUtil.getColor(),ColorUtil.getColor2());
                    mc.font.drawShadow(e.getMatrixStack(), "HP: "+(Math.round(target.getHealth())+"/20"),x + 46,y + 29,-1);}
                try {
                    Entity target = ((EntityRayTraceResult) mc.hitResult).getEntity();

                    if (target != null){
                    if (target instanceof PlayerEntity){
                        String TargetName = (" Name: "+target.getName().getString());
                        float m1 = (int) ((x + (71.5)/2) - (mc.font.width(TargetName))/2) + 45;
                        RenderUtil.drawCastom(x, y, x + 165, y + 50,2);
                        InventoryScreen.renderEntityInInventory(x + 24, y + 48, 20, 0, 0, (LivingEntity) target);
                        mc.font.drawShadow(e.getMatrixStack(),TargetName, m1+3,y + 12,-1);
                        RenderUtil.drawCastom(x + 42,y + 28 ,x + 142 ,y + 38 ,2);
                        RenderUtil.drawSmoothGradientRect(x + 42,y + 28,x + (int) ((((PlayerEntity) target).getHealth() * 5) + 43) ,y + 38,ColorUtil.getColor(),ColorUtil.getColor2());
                        mc.font.drawShadow(e.getMatrixStack(), "HP: "+(Math.round(((PlayerEntity) target).getHealth())+"/20"),x + 46,y + 29,-1);

                    }
}
                }catch (Exception ignored) {
                }


            }
        }
    }


    @SubscribeEvent
    public void onMouseDrag(GuiScreenEvent.MouseDragEvent e) {
        if (mc.screen instanceof ChatScreen) {
            assert mc.player != null;
                if (e.getMouseX() > x && e.getMouseX() < x + 165 && e.getMouseY() > y && e.getMouseY() < y + 50) {
                    x = (int) e.getMouseX() - 165/2 ;
                    y = (int) e.getMouseY() - 22;
                }

        }
    }
}
