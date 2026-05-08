package org.helper.partyhelper.listener;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.helper.partyhelper.service.OcrService;
import org.springframework.stereotype.Component;

import java.io.InputStream;


@Component
public class WarListener extends ListenerAdapter {

    private final OcrService ocrService;
    public WarListener(OcrService ocrService)
    {
        this.ocrService = ocrService;
    }


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getAuthor().isBot())
            return;
        if(event.getMessage().getContentRaw().contentEquals("ping")){
            event.getChannel().sendMessage("pong").queue();
            return;
        }
        if(event.getMessage().getAttachments().isEmpty()){
           event.getChannel().sendMessage("No attachments").queue();
           return;
        }else{
                Message message = event.getMessage();
                Message.Attachment attachment = message.getAttachments().getFirst();
                attachment.getProxy().download().thenAccept(inputStream -> {
                    try (InputStream is = inputStream) {
                        String text = ocrService.extractText(is);

                        event.getChannel()
                                .sendMessage(text)
                                .queue();

                    } catch (Exception e) {
                        event.getChannel()
                                .sendMessage("OCR failed")
                                .queue();
                    }
                })
                        .exceptionally(error -> {
                            event.getChannel()
                                    .sendMessage("Failed to download attachment")
                                    .queue();
                            error.printStackTrace();
                            return null;
                        });

        }
    }


}
