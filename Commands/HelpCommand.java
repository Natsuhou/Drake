package me.Shogatsu.TheDrakeProject.Commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import me.Shogatsu.TheDrakeProject.Core;
import me.Shogatsu.TheDrakeProject.Managers.DrakeManager;
import me.Shogatsu.TheDrakeProject.Menus.ErrorMenu;
import me.Shogatsu.TheDrakeProject.Menus.HelpMenu;
import net.dv8tion.jda.api.Permission;
import org.jetbrains.annotations.NotNull;

public class HelpCommand extends Command {
    public HelpCommand() {
        this.name = "drake";
        this.aliases = new String[] {"Dr", "dragon"};
        this.cooldown = 15;
        this.userPermissions = new Permission[] {Permission.ADMINISTRATOR};
    }

    @Override
    protected void execute(@NotNull CommandEvent e) {
        DrakeManager drakeManager = new DrakeManager(e.getSelfUser());
        if (!e.getAuthor().isFake() && !e.getAuthor().isBot()) {
            HelpMenu helpMenu = new HelpMenu(e.getAuthor());
            e.reply(helpMenu.HelpMenu(drakeManager.getDrakeIconURL(Core.getDrake())).build());
        } else {
            ErrorMenu errorMenu = new ErrorMenu(e.getAuthor());
            e.reply(errorMenu.invalidUser(drakeManager.getDrakeIconURL(Core.getDrake())).build());
        }
    }
}
