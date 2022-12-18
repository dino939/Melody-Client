package com.denger.melody.utils;

import com.sun.javafx.geom.Vec3d;
import net.minecraft.util.math.MathHelper;

public class Vec3dUtil {
    public double x;

    /**
     * The y coordinate.
     */
    public double y;

    /**
     * The z coordinate.
     */
    public double z;
    public Vec3dUtil () { }

    public Vec3dUtil(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Vec3d rotatePitch(float pitch)
    {
        float f = MathHelper.cos(pitch);
        float f1 = MathHelper.sin(pitch);
        double d0 = this.x;
        double d1 = this.y * (double)f + this.z * (double)f1;
        double d2 = this.z * (double)f - this.y * (double)f1;
        return new Vec3d(d0, d1, d2);
    }

    public Vec3d rotateYaw(float yaw)
    {
        float f = MathHelper.cos(yaw);
        float f1 = MathHelper.sin(yaw);
        double d0 = this.x * (double)f + this.z * (double)f1;
        double d1 = this.y;
        double d2 = this.z * (double)f - this.x * (double)f1;
        return new Vec3d(d0, d1, d2);
    }

    public void add(Vec3d t1, Vec3d t2) {
        this.x = t1.x + t2.x;
        this.y = t1.y + t2.y;
        this.z = t1.z + t2.z;
    }


    public void add(Vec3d t1) {
        this.x += t1.x;
        this.y += t1.y;
        this.z += t1.z;
    }
}
