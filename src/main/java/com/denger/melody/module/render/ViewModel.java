package com.denger.melody.module.render;

import com.denger.melody.clickgui.settings.NumberSetting;
import com.denger.melody.module.Module;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static org.lwjgl.opengl.GL11.glTranslated;

public class ViewModel extends Module {
    public static NumberSetting X = new NumberSetting("posX",-2,2,0,1);
    public static NumberSetting Y = new NumberSetting("posY",-2,2,0,1);
    public static NumberSetting Z = new NumberSetting("posZ",-2,2,0,1);
    public ViewModel(){
        super("ViewModel",0, Category.RENDER," ");
        addSetting(X);
        addSetting(Y);
        addSetting(Z);
    }


    @SubscribeEvent
    public void onRender(final RenderHandEvent event) {
        float PosX = (float) X.getValueFloat();
        float PosY = (float) Y.getValueFloat();
        float PosZ = (float) Z.getValueFloat();
        glTranslated(PosX, PosY, PosZ);
    }

}
