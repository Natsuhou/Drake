package me.Shogatsu.TheDrakeProject.Commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Platform;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.summoner.Summoner;
import me.Shogatsu.TheDrakeProject.Core;
import me.Shogatsu.TheDrakeProject.Managers.APIKey;
import me.Shogatsu.TheDrakeProject.Managers.DrakeManager;
import me.Shogatsu.TheDrakeProject.Managers.LeagueInfo;
import me.Shogatsu.TheDrakeProject.Menus.ErrorMenu;
import net.dv8tion.jda.api.Permission;

public class DemoCommand extends Command {
    public DemoCommand() {
        this.name = "demo";
        this.cooldown = 5;
        this.aliases = new String[] {"d", "test"};
        this.userPermissions = new Permission[] {Permission.ADMINISTRATOR};
    }
    @Override
    protected void execute(CommandEvent e) {
        DrakeManager drakeManager = new DrakeManager(e.getSelfUser());
        if (!e.getAuthor().isBot() && !e.getAuthor().isFake()) {
            if (e.getArgs().isEmpty()) {
                ErrorMenu errorMenu = new ErrorMenu(e.getAuthor());
                e.reply(errorMenu.noArgs(drakeManager.getDrakeIconURL(Core.getDrake())).build());
            } else {
                APIKey apiKey = new APIKey();
                Orianna.setRiotAPIKey(apiKey.getKey());
                final Summoner summoner = Summoner
                        .named(e.getArgs())
                        .withRegion(Region.NORTH_AMERICA)
                        .withPlatform(Platform.NORTH_AMERICA)
                        .get();
                if (summoner.exists()) {
                    //Put test stuff here
                    LeagueInfo leagueInfo = new LeagueInfo(summoner);
                    e.reply(leagueInfo.getLeagueName());
                } else {
                    ErrorMenu errorMenu = new ErrorMenu(e.getAuthor());
                    e.reply(errorMenu.invalidLeagueUser(drakeManager.getDrakeIconURL(Core.getDrake())).build());
                }
            }
        } else {
            ErrorMenu errorMenu = new ErrorMenu(e.getAuthor());
            e.reply(errorMenu.invalidUser(drakeManager.getDrakeIconURL(Core.getDrake())).build());
        }
    }
}
