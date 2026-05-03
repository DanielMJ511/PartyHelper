package org.helper.partyhelper.config;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class DiscordConfig {

    @Value("${DISCORD_TOKEN}")
    private String discordToken;

    @Bean
    public JDA jda () {

        try{
            return JDABuilder.createLight(discordToken, GatewayIntent.GUILD_MEMBERS,
                    GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT).build().awaitReady();

        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
            throw new RuntimeException("Error fatal al conectar el bot a Discord", e);
        }

    }

}
