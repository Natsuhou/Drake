package me.Shogatsu.TheDrakeProject.Menus;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;

import java.awt.*;

public class HelpMenu {
    private EmbedBuilder builder;
    private User user;

    public HelpMenu(User u) {
        this.user = u;
    }
    public EmbedBuilder HelpMenu(String drakeIconURL) {
        return builder
                .setAuthor(user.getName(), user.getAvatarUrl())
                .setTitle("Infernal Drake")
                .setDescription("This is the help menu!")
                .setThumbnail(drakeIconURL)
                .setColor(Color.red)
                .addField("!whois [args]", "Find a user's League Account", true);
    }
}
