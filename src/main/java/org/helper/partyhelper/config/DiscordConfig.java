package org.helper.partyhelper.config;

import net.dv8tion.jda.api.JDA;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class DiscordConfig {

    @Value("${DISCORD_TOKEN}")
    private String discordToken;

    @Bean
    public JDA jda (){

        return JDA;
    }



}
