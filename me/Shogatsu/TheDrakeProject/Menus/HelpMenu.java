package me.Shogatsu.TheDrakeProject.Menus;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;

import java.awt.*;

public class HelpMenu {
    private EmbedBuilder builder;
    private User user;

    public HelpMenu(User u) {
        this.user = u;
        builder = new EmbedBuilder()
                .setAuthor(user.getName(), user.getDefaultAvatarUrl());
    }
    public EmbedBuilder HelpMenu(String drakeIconURL) {
        return builder
                .setTitle("Help Menu")
                .setDescription("Info on usage of certain commands")
                .setThumbnail(drakeIconURL)
                .setColor(Color.red)
                .addField("!whois [args]", "Find a user's League Account", true);
    }
}
