package me.Shogatsu.TheDrakeProject;

import com.jagrosh.jdautilities.command.CommandClientBuilder;
import me.Shogatsu.TheDrakeProject.Commands.DemoCommand;
import me.Shogatsu.TheDrakeProject.Commands.HelpCommand;
import me.Shogatsu.TheDrakeProject.Commands.LeagueProfileCommand;
import me.Shogatsu.TheDrakeProject.Managers.DrakeManager;
import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Core extends ListenerAdapter {
    private static int drakeID;
    public static void main(String[] args) {
        final String token = "";
        try {
            CommandClientBuilder builder = new CommandClientBuilder()
                    .setOwnerId("381773847357161482")
                    .setPrefix("!")
                    .setActivity(Activity.listening("toxic League players"))
                    .addCommands(
                            //Help Command
                            new HelpCommand(),
                            //Main Commands
                            new LeagueProfileCommand(),
                            //Test Command
                            new DemoCommand()
                    );
            JDA jda = new JDABuilder(AccountType.BOT)
                    .setToken(token)
                    .setStatus(OnlineStatus.ONLINE)
                    .addEventListeners(builder.build())
                    .build();
            Runnable setDrake = () -> {
                DrakeManager drakeManager = new DrakeManager(jda.getSelfUser());
                drakeManager.changeDrake(getDrake());
                System.out.println("Drake has been changed");
            };
            ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
            service.scheduleAtFixedRate(setDrake, 0, 6, TimeUnit.HOURS);

            drakeID = -1;
            Runnable incrementDrakeId = () -> {
                if (drakeID == 3) {
                    drakeID = -1;
                } else {
                    drakeID += 1;
                }
            };
            service.scheduleAtFixedRate(incrementDrakeId, 0, 5, TimeUnit.HOURS);
        } catch (LoginException exception) {
            exception.printStackTrace();
        }
    }
    public static int getDrake() {
        return drakeID;
    }
}
