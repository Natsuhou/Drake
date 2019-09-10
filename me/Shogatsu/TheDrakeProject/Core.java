package me.Shogatsu.TheDrakeProject;

import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import me.Shogatsu.TheDrakeProject.Commands.HelpCommand;
import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class Core extends ListenerAdapter {
    public static void main(String[] args) {
        final String token = "";
        EventWaiter waiter = new EventWaiter();
        try {
            CommandClientBuilder builder = new CommandClientBuilder()
                    .setOwnerId("381773847357161482")
                    .setPrefix("!")
                    .setActivity(Activity.listening("toxic League players"))
                    .addCommands(
                            //Help Command
                            new HelpCommand()
                            //Main Commands

                    );
            Runnable runnable = () -> {

            };
            new JDABuilder(AccountType.BOT)
                    .setToken(token)
                    .setStatus(OnlineStatus.ONLINE)
                    .addEventListeners(builder.build())
                    .build();
        } catch (LoginException exception) {
            exception.printStackTrace();
        }
    }
}
