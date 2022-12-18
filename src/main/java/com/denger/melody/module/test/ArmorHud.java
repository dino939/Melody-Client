package com.denger.melody.module.test;

import com.denger.melody.module.Module;
import com.denger.melody.utils.RenderUtil;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.awt.*;
import java.util.Iterator;

import static com.denger.melody.Melody.mc;

public class ArmorHud extends Module
{
    public ArmorHud(){
        super("ArmorHud",0,Category.HUD,"Show your armor");
    }



    @SubscribeEvent
    public void onRender(final RenderGameOverlayEvent.Text text) {
        final float n = 20.0f;
        float n2 = 50.0f;
        RenderUtil.drawRect(n, n2, n + 20.0f, n2 + 80.0f, new Color(0x49000000, true).hashCode());

        final Iterator<ItemStack> iterator = mc.player.inventory.armor.stream().iterator();
        while (iterator.hasNext()) {
           // RenderUtil.renderItem(iterator.next(), (int)(n + 2.0f), n2 + 2);
            n2 -= 15;
        }
    }
}
