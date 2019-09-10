package me.Shogatsu.TheDrakeProject.Managers;

import net.dv8tion.jda.api.entities.Icon;
import net.dv8tion.jda.api.entities.SelfUser;
import net.dv8tion.jda.api.managers.AccountManager;
import net.dv8tion.jda.internal.managers.AccountManagerImpl;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class DrakeManager {
    private SelfUser selfUser;
    private int key;
    public DrakeManager(SelfUser sU) {
        this.selfUser = sU;
        Random random = new Random();
        key = random.nextInt(3);
    }
    public void changeDrake() throws IOException {
        Icon[] drakeAvatar = {
                Icon.from(new File("me/Shogatsu/TheDrakeProject/Drake/Resources/Images/Mark/infernalicon.jpg")),
                Icon.from(new File("me/Shogatsu/TheDrakeProject/Drake/Resources/Images/Mark/oceanicon.jpg")),
                Icon.from(new File("me/Shogatsu/TheDrakeProject/Drake/Resources/Images/Mark/cloudicon.jpg")),
                Icon.from(new File("me/Shogatsu/TheDrakeProject/Drake/Resources/Images/Mark/mountainicon.jpg"))
        };
        String[] drakeName = {
                "Infernal Drake",
                "Ocean Drake",
                "Cloud Drake",
                "Mountain Drake"
        };
        AccountManager manager = new AccountManagerImpl(selfUser);
        manager.reset(AccountManager.NAME, AccountManager.AVATAR).queue();
        manager.setAvatar(drakeAvatar[key]).setName(drakeName[key]).queue();
    }
    public String getDrakeIconURL() {
        String[] drakeIcon = {
                "https://i.imgur.com/1BFObdg.jpg",
                "https://i.imgur.com/vKOccEV.jpg",
                "https://i.imgur.com/pyCO9Of.jpg",
                "https://i.imgur.com/ns2mXjK.jpg"
        };
        return drakeIcon[key];
    }
}
