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
import me.Shogatsu.TheDrakeProject.Menus.ErrorMenu;

public class LeagueProfileCommand extends Command {
    public LeagueProfileCommand() {
        this.name = "searchUser";
        this.aliases = new String[] {"sU"};
        this.cooldown = 5;
    }
    @Override
    protected void execute(CommandEvent e) {
        DrakeManager drakeManager = new DrakeManager(e.getSelfUser());
        if (!e.getAuthor().isBot() && !e.getAuthor().isFake()) {
            APIKey apiKey = new APIKey();
            Orianna.setRiotAPIKey(apiKey.returnAPIKey());
            Orianna.setDefaultPlatform(Platform.NORTH_AMERICA);
            final Summoner summoner = Summoner.named(e.getArgs()).withRegion(Region.NORTH_AMERICA).withPlatform(Platform.NORTH_AMERICA).get();
        } else {
            ErrorMenu errorMenu = new ErrorMenu(e.getAuthor());
            e.reply(errorMenu.invalidUserMenu(drakeManager.getDrakeIconURL(Core.getDrake())).build());
        }
    }
}
