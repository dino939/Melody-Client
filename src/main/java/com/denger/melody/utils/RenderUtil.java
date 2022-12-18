package com.denger.melody.utils;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import static com.denger.melody.Melody.mc;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;

public class RenderUtil {

    private static HashMap<Integer, Integer> shadowCache = new HashMap<Integer, Integer>();
    public static void drawSmoothRect( float left, float top, float right, float bottom, int color) {
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        drawRect( (int) left, (int) top, (int) right, (int) bottom, color);
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        drawRect( (int) (left * 2 - 1), (int) (top * 2), (int) (left * 2), (int) (bottom * 2 - 1), color);
        drawRect( (int) (left * 2), (int) (top * 2 - 1), (int) (right * 2), (int) (top * 2), color);
        drawRect( (int) (right * 2), (int) (top * 2), (int) (right * 2 + 1), (int) (bottom * 2 - 1), color);
        drawRect( (int) (left * 2), (int) (bottom * 2 - 1), (int) (right * 2), (int) (bottom * 2), color);
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glScalef(2F, 2F, 2F);

    }
    public static void enableSmoothLine(final float n) {
        GL11.glDisable(3008);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3553);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glEnable(2884);
        GL11.glEnable(2848);
        GL11.glHint(3154, 4354);
        GL11.glHint(3155, 4354);
        GL11.glLineWidth(n);
    }

    public static void drawSmoothGradientRect(float left, float top, float right, float bottom, int color1, int color2) {
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        drawGradientRect(left, top, right, bottom, color1, color2);
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        drawGradientRect(left * 2 - 1, top * 2, left * 2, bottom * 2 - 1, color1, color1);
        drawGradientRect(left * 2, top * 2 - 1, right * 2, top * 2, color1, color2);
        drawGradientRect(right * 2, top * 2, right * 2 + 1, bottom * 2 - 1, color1, color2);
        drawGradientRect(left * 2, bottom * 2 - 1, right * 2, bottom * 2, color1, color2);
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glScalef(2F, 2F, 2F);
    }

    public static void drawCastom(int startX, int startY, int endX, int endY, int r){
        drawSmoothGradientRect(startX - r,startY - r,endX + r,endY + r,ColorUtil.getColor(),ColorUtil.getColor2());
        drawSmoothRect(startX,startY,endX,endY,new Color(0xFF000000, true).hashCode());

    }

    public static void drawCastomLitium(int startX, int startY, int endX, int endY, int r){
        drawSmoothGradientRect(startX - r,startY - r,endX + r,endY + r,ColorUtil.getColor(),ColorUtil.getColor2());
        drawSmoothRect(startX - r,startY - r,endX + r,endY + r,new Color(0x51000000, true).hashCode());
        drawSmoothGradientRect(startX,startY,endX ,endY,ColorUtil.getColor(),ColorUtil.getColor2());

    }


    public static void drawRect(final float startX, final float startY, final float endX, final float endY, final int color)
    {
        float f = (float)(color >> 24 & 255) / 255.0F;
        float f1 = (float)(color >> 16 & 255) / 255.0F;
        float f2 = (float)(color >> 8 & 255) / 255.0F;
        float f3 = (float)(color & 255) / 255.0F;
        glPushMatrix();
        GL11.glPushAttrib(1048575);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_CULL_FACE);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glColor4f(f1, f2, f3, f);
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2d(startX, startY);
        GL11.glVertex2d(endX, startY);
        GL11.glVertex2d(endX, endY);
        GL11.glVertex2d(startX, endY);
        GL11.glEnd();
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPopAttrib();
        glPopMatrix();
    }
    public static void disableSmoothLine() {
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDisable(3042);
        GL11.glEnable(3008);
        GL11.glDepthMask(true);
        GL11.glCullFace(1029);
        GL11.glDisable(2848);
        GL11.glHint(3154, 4352);
        GL11.glHint(3155, 4352);
    }

    public static void drawGradientRect(float left, float top, float right, float bottom, int color1, int color2) {
        float f1 = (float) (color1 >> 24 & 0xFF) / 255.0f;
        float f2 = (float) (color1 >> 16 & 0xFF) / 255.0f;
        float f3 = (float) (color1 >> 8 & 0xFF) / 255.0f;
        float f4 = (float) (color1 & 0xFF) / 255.0f;
        float f5 = (float) (color2 >> 24 & 0xFF) / 255.0f;
        float f6 = (float) (color2 >> 16 & 0xFF) / 255.0f;
        float f7 = (float) (color2 >> 8 & 0xFF) / 255.0f;
        float f8 = (float) (color2 & 0xFF) / 255.0f;
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glShadeModel(7425);
        glPushMatrix();
        GL11.glBegin(7);
        GL11.glColor4f(f2, f3, f4, f1);
        GL11.glVertex2d(left, top);
        GL11.glVertex2d(left, bottom);
        GL11.glColor4f(f6, f7, f8, f5);
        GL11.glVertex2d(right, bottom);
        GL11.glVertex2d(right, top);
        GL11.glEnd();
        glPopMatrix();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
    }

    public static void glColor(final int n) {
        GlStateManager._blendColor((n >> 16 & 0xFF) / 255.0f, (n >> 8 & 0xFF) / 255.0f, (n & 0xFF) / 255.0f, (n >> 24 & 0xFF) / 255.0f);
    }

    public static void drawFilledCircle(int xx, int yy, float radius, Color color) {
        int sections = 6;
        double dAngle = Math.PI * 2 / (double)sections;
        GL11.glPushAttrib(8192);
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glBegin(6);
        for (int i = 0; i < sections; ++i) {
            float x = (float)((double)radius * Math.sin((double)i * dAngle));
            float y = (float)((double)radius * Math.cos((double)i * dAngle));
            GL11.glColor4f((float)color.getRed() / 255.0f, (float)color.getGreen() / 255.0f, (float)color.getBlue() / 255.0f, (float)color.getAlpha() / 255.0f);
            GL11.glVertex2f((float)xx + x, (float)yy + y);
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glEnd();
        GL11.glPopAttrib();

    }



}
