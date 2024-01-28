package com.denger.melody.utils.hwid;

import com.denger.melody.Melody;
import com.denger.melody.clickgui.ClickGUIScreen;
import com.denger.melody.module.ModuleManager;
import com.denger.melody.utils.WebUtils;
import javax.swing.*;
import java.awt.*;

public class Hwider {

    public static void Alfa() {
        try {
            String a = "1234";
            JPanel jp = new JPanel();
            JTextField hwidfield;
            jp.setLayout(new GridLayout(1, 2));
            jp.add(hwidfield = new JTextField(HWID.bytesToHex(HWID.generateHWID())));
            hwidfield.setEditable(false);
            if (!WebUtils.visitSite(HWID.ABOBA).contains(hwidfield.getText())) {
                System.exit(1);
            }
            else {

            }
        }  catch (Exception ignored) {
            System.exit(1);
        }


    }

}
