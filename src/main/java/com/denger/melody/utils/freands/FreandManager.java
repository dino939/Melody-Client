package com.denger.melody.utils.freands;

import com.denger.melody.notifications.Notification;
import com.denger.melody.notifications.NotificationManager;
import com.denger.melody.notifications.NotificationType;

import java.util.ArrayList;

public class FreandManager {
    public static ArrayList<String> FRIEND = new ArrayList<String>();

    public static void toggleFriend(String nick){
        if (isFriend(nick)){
            FRIEND.remove(nick);
            NotificationManager.show(new Notification(NotificationType.ERROR, "FreandMananager",  nick+" remove from Friend list", 1));

        }else{
            FRIEND.add(nick);
            NotificationManager.show(new Notification(NotificationType.WARNING, "FreandMananager",  nick+" add in Friend list", 1));

        }


    }
    public static boolean isFriend(String nick) {
        return FRIEND.contains(nick);
    }
}
