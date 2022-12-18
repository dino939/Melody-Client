package com.denger.melody.utils;

import com.mojang.blaze3d.platform.GlStateManager;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class ColorUtil {
    public static int swapAlpha(final int n, final float n2) {
        return ColorUtil.toRGBA(n >> 16 & 0xFF, n >> 8 & 0xFF, n & 0xFF, (int)n2);
    }
    public static int getRainbowShadow() {
        int drgb;
        int color;
        int argb;
        float[] hue = new float[]{(float) (System.currentTimeMillis() % 11520L) / 11520.0f};
        int rgb = Color.HSBtoRGB(hue[0], 1.0f, 1.0f);
        int red = rgb >> 16 & 255;
        int green = rgb >> 8 & 255;
        int blue = rgb & 255;
        color = argb = ColorUtil.toRGBA(red, green, blue, 195);
        return color;
    }
    public static void glColor(Color color) {
        GL11.glColor4f((float)color.getRed() / 255.0f, (float)color.getGreen() / 255.0f, (float)color.getBlue() / 255.0f, (float)color.getAlpha() / 255.0f);
    }
    public static int getRainbow() {
        int drgb;
        int color;
        int argb;
        float[] hue = new float[]{(float) (System.currentTimeMillis() % 11520L) / 11520.0f};
        int rgb = Color.HSBtoRGB(hue[0], 1.0f, 1.0f);
        int red = rgb >> 16 & 255;
        int green = rgb >> 8 & 255;
        int blue = rgb & 255;
        color = argb = ColorUtil.toRGBA(red, green, blue, 255);
        return color;
    }
    public static int getRainbow2() {
        int drgb;
        int color;
        int argb;
        float[] hue = new float[]{(float) (System.currentTimeMillis() % 11520L) / 11520.0f};
        int rgb = Color.HSBtoRGB(hue[0], 1.0f, 1.0f);
        int red = rgb >> 16 & 255;
        int green = rgb >> 8 & 255;
        int blue = rgb & 255;
        color = argb = ColorUtil.toRGBA(red - 15, green- 15, blue -15, 255);
        return color;
    }
    public static Color getRainbow3() {
        int drgb;
        int color;
        int argb;
        float[] hue = new float[]{(float) (System.currentTimeMillis() % 11520L) / 11520.0f};
        int rgb = Color.HSBtoRGB(hue[0], 1.0f, 1.0f);
        int red = rgb >> 16 & 255;
        int green = rgb >> 8 & 255;
        int blue = rgb & 255;
        Color color1 = new Color(red, green, blue);
        return  color1;
    }
    public static int toRGBA(int r, int g, int b, int a) {
        return (r << 16) + (g << 8) + (b << 0) + (a << 24);
    }

    public static int toRGBA3(int r, int g, int b) {
        return (r << 16) + (g << 8) + (b << 0) ;
    }

   public static Color TwoColoreffect(final Color color, final Color color2, final double n) {
        final float clamp = MathUtils.clamp((float)Math.sin(18.84955592153876 * (n / 4.0 % 1.0)) / 2.0f + 0.5f, 0.0f, 1.0f);
        return new Color(MathUtils.lerp(color.getRed() / 255.0f, color2.getRed() / 255.0f, clamp), MathUtils.lerp(color.getGreen() / 255.0f, color2.getGreen() / 255.0f, clamp), MathUtils.lerp(color.getBlue() / 255.0f, color2.getBlue() / 255.0f, clamp), MathUtils.lerp(color.getAlpha() / 255.0f, color2.getAlpha() / 255.0f, clamp));
    }

    public static int getColor() {
        return ColorUtil.TwoColoreffect(new Color(255, 0, 0), new Color(90, 65, 255), Math.abs(System.currentTimeMillis() / 10L) / 100.0 + 0.16999999999999998).getRGB();
    }
    public static int getColor2() {
        return ColorUtil.TwoColoreffect(new Color(90, 65, 255), new Color(255, 0, 0), Math.abs(System.currentTimeMillis() / 10L) / 100.0 + 0.16999999999999998).getRGB();
    }
}
