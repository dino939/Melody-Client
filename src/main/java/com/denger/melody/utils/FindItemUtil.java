package com.denger.melody.utils;

import com.denger.melody.Melody;
import net.minecraft.item.Item;

public class FindItemUtil {

    public static int findItem36(Item item) {
        for (int i = 0; i < 36; ++i) {
            assert Melody.mc.player != null;
            if (Melody.mc.player.inventory.getItem(i).getItem() == item) {
                return i;
            }
        }
        return -1;
    }

    public static int findItem9(Item item) {
        for (int i = 0; i < 9; ++i) {
            assert Melody.mc.player != null;
            if (Melody.mc.player.inventory.getItem(i).getItem() == item) {
                return i;
            }
        }
        return -1;
    }
}
