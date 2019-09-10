package me.Shogatsu.TheDrakeProject.Menus;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;

import java.awt.*;

public class ErrorMenu {
    private User user;
    private EmbedBuilder builder;
    public ErrorMenu(User u) {
        this.user = u;
        builder = new EmbedBuilder()
                .setAuthor(user.getName(), user.getAvatarUrl())
                .setColor(Color.red);
    }
    public EmbedBuilder invalidUserMenu(String drakeIconURL) {
        return builder
                .setTitle(":x: Invalid User")
                .setDescription(user.getName() + " is a bot or a fake account!")
                .setThumbnail(drakeIconURL)
                .setFooter("Type !errors for more info!");
    }
}
