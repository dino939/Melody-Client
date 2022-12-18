package com.denger.melody.module;

import com.denger.melody.clickgui.settings.Setting;
import com.denger.melody.notifications.Notification;
import com.denger.melody.notifications.NotificationManager;
import com.denger.melody.notifications.NotificationType;
import net.minecraftforge.common.MinecraftForge;

import java.util.ArrayList;
import java.util.List;

import static com.denger.melody.utils.hwid.HWID.ABOBA;

public class Module {
    public String name;
    public boolean toggled;
    public float anim;
    public int keyCode;

    public static Category Category;
    public String description;
    public Category category;
    public List<Setting> settingList = new ArrayList<>();

    public void addSetting(Setting c) {
        settingList.add(c);
    }

    public Module(String name, int key, Category category, String description) {
        this.name = name;
        this.keyCode = key;
        this.category = category;
        this.description = description;
    }

    public boolean onEnable() {
        if (ABOBA.equals(null)) {System.exit(1);}
        MinecraftForge.EVENT_BUS.register(this);
        return false;
    }

    public void onDisable() {
        if (ABOBA.equals(null)) {System.exit(1);}
        MinecraftForge.EVENT_BUS.unregister(this);
    }

    public String getName() {
        return name;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public Category getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public boolean isToggled() {
        return toggled;
    }

    public void toggle() {
        toggled = !toggled;
        if (toggled) {
            onEnable();
            if (!this.name.equals("Notifications")){
            NotificationManager.show(new Notification(NotificationType.INFO, "Info", getName() + " was ON!", 1));
        }} else {
            onDisable();
            NotificationManager.show(new Notification(NotificationType.INFO, "Info", getName() + " was OFF!", 1));
        }
    }

    public void setKeyCode(int keyCode) {
        this.keyCode = keyCode;
    }

    public void setToggled(boolean toggled) {
        this.toggled = toggled;
        if (this.toggled) {
            this.onEnable();
        } else {
            this.onDisable();
        }
    }

}
