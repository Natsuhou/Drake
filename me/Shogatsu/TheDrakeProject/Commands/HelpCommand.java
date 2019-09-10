package me.Shogatsu.TheDrakeProject.Commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import me.Shogatsu.TheDrakeProject.Managers.DrakeManager;
import me.Shogatsu.TheDrakeProject.Managers.IconManager;
import me.Shogatsu.TheDrakeProject.Menus.ErrorMenu;
import me.Shogatsu.TheDrakeProject.Menus.HelpMenu;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class HelpCommand extends Command {
    public HelpCommand() {
        this.name = "drake";
        this.aliases = new String[] {"Dr", "dragon"};
        this.cooldown = 15;
    }

    @Override
    protected void execute(@NotNull CommandEvent e) {
        IconManager iconManager = new IconManager();
        if (!e.getAuthor().isFake() && !e.getAuthor().isBot()) {
            try {
                DrakeManager drakeManager = new DrakeManager(e.getSelfUser());
                HelpMenu helpMenu = new HelpMenu(e.getAuthor());

                drakeManager.changeDrake();
                e.reply(helpMenu.HelpMenu(drakeManager.getDrakeIconURL()).build());
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        } else {
            ErrorMenu errorMenu = new ErrorMenu(e.getAuthor());
            e.reply(errorMenu.invalidUserMenu(iconManager.getDrakeIcon()).build());
        }
    }
}
