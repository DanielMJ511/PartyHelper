package org.helper.partyhelper.config;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.EventListener;
import java.util.List;

@Configuration

public class DiscordConfig {

    @Value("${DISCORD_TOKEN}")
    private String discordToken;

    @Bean
    public JDA jda (List<EventListener> listeners) {

        try{
            JDABuilder builder =  JDABuilder.createLight(discordToken, GatewayIntent.GUILD_MEMBERS,
                    GatewayIntent.GUILD_MESSAGES,
                    GatewayIntent.MESSAGE_CONTENT);

            for(EventListener listener : listeners){
                builder.addEventListeners(listener);
            }

            return builder.build().awaitReady();

        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
            throw new RuntimeException("Error fatal al conectar el bot a Discord", e);
        }

    }

}
