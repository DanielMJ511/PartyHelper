package org.helper.partyhelper.listener;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.stereotype.Component;

@Component
public class WarListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getAuthor().isBot())
            return;
        if(event.getMessage().getContentRaw().contentEquals("ping")){
            event.getChannel().sendMessage("pong").queue();
        }
    }

}
