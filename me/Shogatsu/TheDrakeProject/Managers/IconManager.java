package me.Shogatsu.TheDrakeProject.Managers;

import java.awt.*;
import java.util.Random;

public class IconManager {
    public String getDrakeIcon() {
        String[] drakeIcons = {
                "https://i.imgur.com/2KNDrma.png", //Infernal Drake
                "https://i.imgur.com/TO15eES.png", //Mountain Drake
                "https://i.imgur.com/Mr1KWKc.png", //Cloud Drake
                "https://i.imgur.com/kgeuPiP.png"  //Ocean Drake
        };

        Random rng = new Random();
        return drakeIcons[rng.nextInt(drakeIcons.length)];
    }
    public Color getDrakeColor() {
        Color[] drakeColor = {Color.red};
        return drakeColor[0];
    }
}
