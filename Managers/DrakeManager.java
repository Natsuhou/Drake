package me.Shogatsu.TheDrakeProject.Managers;

import net.dv8tion.jda.api.entities.Icon;
import net.dv8tion.jda.api.entities.SelfUser;
import net.dv8tion.jda.api.managers.AccountManager;
import net.dv8tion.jda.internal.managers.AccountManagerImpl;

import java.io.*;
import java.net.URL;

public class DrakeManager {
    private static SelfUser selfUser;
    public DrakeManager(SelfUser sU) {
        selfUser = sU;
    }
    public void changeDrake(int drakeType) {
        try {
            InputStream[] drakeProfileIcon = {
                    new URL("https://i.imgur.com/1BFObdg.jpg").openStream(), //Infernal Drake
                    new URL("https://i.imgur.com/vKOccEV.jpg").openStream(), //Ocean Drake
                    new URL("https://i.imgur.com/pyCO9Of.jpg").openStream(), //Cloud Drake
                    new URL("https://i.imgur.com/ns2mXjK.jpg").openStream(), //Mountain Drake
            };
            String[] drakeProfileName = {
                    "Infernal Drake",
                    "Ocean Drake",
                    "Cloud Drake",
                    "Mountain Drake"
            };
            AccountManager manager = new AccountManagerImpl(selfUser);
            manager.reset(AccountManager.NAME, AccountManager.AVATAR).queue();
            manager.setAvatar(Icon.from(drakeProfileIcon[drakeType])).setName(drakeProfileName[drakeType]).queue();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
    public String getDrakeIconURL(int drakeType) {
        String[] drakeIcon = {
                "https://i.imgur.com/2KNDrma.png", //Infernal Drake
                "https://i.imgur.com/kgeuPiP.png", //Ocean Drake
                "https://i.imgur.com/Mr1KWKc.png", //Cloud Drake
                "https://i.imgur.com/TO15eES.png" //Mountain Drake
        };
        return drakeIcon[drakeType];
    }
}
