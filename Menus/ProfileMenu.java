package me.Shogatsu.TheDrakeProject.Menus;

import com.merakianalytics.orianna.types.core.summoner.Summoner;
import me.Shogatsu.TheDrakeProject.Managers.LeagueInfo;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;

import java.awt.*;

public class ProfileMenu {
    private User user;
    private EmbedBuilder builder;
    public ProfileMenu(User u) {
        this.user = u;
        this.builder = new EmbedBuilder()
                .setAuthor(user.getName(), null, user.getAvatarUrl())
                .setColor(new Color(119, 233, 255));
    }
    public EmbedBuilder displayProfile(Summoner summoner) {
        LeagueInfo leagueInfo = new LeagueInfo(summoner);
        return builder
                .setTitle(":bust_in_silhouette: " + summoner.getName() + "'s Profile")
                .setDescription("Summoner Level: " + summoner.getLevel())
                .setThumbnail(leagueInfo.getSoloRankedIcon())
                .addField(":star2:  Mastery 7", String.join(", ", leagueInfo.getM7()), true)
                .addField(":star: Mastery 6", String.join(", ", leagueInfo.getM6()), true)
                .setImage(summoner.getProfileIcon().getImage().getURL());
    }
}
