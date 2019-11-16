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
                .setAuthor(user.getName(), null, user.getAvatarUrl())
                .setColor(Color.red)
                .setFooter("");
    }
    public EmbedBuilder invalidUser(String drakeIconURL) {
        return builder
                .setTitle(":x: Invalid User")
                .setDescription(user.getName() + " is a bot or a fake account!")
                .setThumbnail(drakeIconURL);
    }
    public EmbedBuilder invalidLeagueUser(String drakeIconURL) {
        return builder
                .setTitle(":x: Invalid League Username")
                .setDescription("Username is invalid or user isn't on platform: North America")
                .setThumbnail(drakeIconURL);
    }
    public EmbedBuilder noArgs(String drakeIconURL) {
        return builder
                .setTitle(":x: No User Specified!")
                .setDescription("Please specify a user to search!")
                .setThumbnail(drakeIconURL);
    }
}
