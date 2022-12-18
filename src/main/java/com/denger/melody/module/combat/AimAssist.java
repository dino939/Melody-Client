package com.denger.melody.module.combat;

import com.denger.melody.module.Module;
import com.denger.melody.utils.freands.FreandManager;
import com.denger.melody.clickgui.settings.NumberSetting;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Comparator;

import static com.denger.melody.Melody.mc;

public class AimAssist extends Module {
    public static NumberSetting range2 = new NumberSetting("range", 0, 10, 6,1);

    public AimAssist(){super("AimAssist",0,Category.COMBAT,"Help to Assist");
        addSetting(range2);

    }


    @SubscribeEvent
    public void onUpdate(RenderWorldLastEvent e) {
        double range = range2.getValueFloat();
        PlayerEntity target  = mc.level.players().stream().filter(entityPlayer -> entityPlayer != mc.player).min(Comparator.comparing(entityPlayer ->
                entityPlayer.distanceTo(mc.player))).filter(entityPlayer -> entityPlayer.distanceTo(mc.player) <= range).orElse(null);
        if (target != null && mc.player.canSee(target) && !FreandManager.isFriend(target.getName().getString())) {
            mc.player.yRot = rotations(target)[0];
                mc.player.xRot = rotations(target)[1];

        }
    }


    public float[] rotations(PlayerEntity entity) {
        double x = entity.getX() - mc.player.getX();
        double y = entity.getY() - (mc.player.getY() + mc.player.getEyeHeight()) + 1.5;
        double z = entity.getZ() - mc.player.getZ();

        double u = MathHelper.sqrt(x * x + z * z);

        float u2 = (float) (MathHelper.atan2(z, x) * (180D / Math.PI) - 90.0F);
        float u3 = (float) (-MathHelper.atan2(y, u) * (180D / Math.PI));

        return new float[]{u2, u3};

    }

}