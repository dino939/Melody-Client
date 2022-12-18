package com.denger.melody.module.test;

import com.denger.melody.module.Module;
import com.denger.melody.utils.ColorUtil;
import com.denger.melody.utils.RenderUtil;
import com.denger.melody.utils.Vec3dUtil;
import com.mojang.blaze3d.platform.GlStateManager;
import com.sun.javafx.geom.Vec3d;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.lwjgl.opengl.GL11;

import java.awt.*;

import static com.denger.melody.Melody.mc;

public class BetaFunc extends Module
{
    public BetaFunc(){
        super("BetaFunc",0,Category.HUD," ");
    }







}
//    final double x = entity.xOld + (entity.getX() - entity.xOld) * mc.getCameraEntity().tickCount - mc.getCameraEntity().getX();
//    final double y = entity.yOld + (entity.getY() - entity.yOld) * mc.getCameraEntity().tickCount - mc.getCameraEntity().getY();
//    final double z = entity.zOld + (entity.getZ() - entity.zOld) * mc.getCameraEntity().tickCount - mc.getCameraEntity().getZ();
//                GL11.glPushMatrix();
//                        GL11.glDisable(2929);
//                        GL11.glEnable(3042);
//                        GL11.glBlendFunc(770, 771);
//                        GL11.glNormal3f(0.0f, 1.0f, 0.0f);
//final float size = Math.min(Math.max(1.2f * (mc.player.distanceTo(entity) * 0.15f), 1.25f), 6.0f) * 0.015f;
//        GL11.glTranslatef((float)x, (float)y + entity.getBbHeight() + 0.6f, (float)z);
//        GlStateManager._normal3f(0.0f, 1.0f, 0.0f);
//        GlStateManager._rotatef((float) -mc.getCameraEntity().getY(), 0.0f, 1.0f, 0.0f);
//        GlStateManager._rotatef((float) mc.getCameraEntity().getX(), 1.0f, 0.0f, 0.0f);
//        GL11.glScalef(-size, -size, -size);
//        RenderUtil.drawCastomLitium(-9, 0, 10, 15, 3);
//
//        GL11.glEnable(2929);
//        GL11.glColor3f(255.0f, 255.0f, 255.0f);
//        GL11.glEnable(2929);
//        GL11.glPopMatrix();