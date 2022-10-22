package com.chatbot.blip.service;


import com.chatbot.blip.controller.dto.MessageDto;
import com.chatbot.blip.controller.dto.NotificationDto;
import com.chatbot.blip.model.Intention;
import com.chatbot.blip.model.Message;
import com.chatbot.blip.model.User;
import com.chatbot.blip.model.UserHistory;
import com.chatbot.blip.service.client.TakeBlipClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TakeBlipWebhookService {

    @Autowired
    public UserService userService;
    @Autowired
    public UserHistoryService userHistoryService;
    @Autowired
    public MessageService messageService;

    @Autowired
    public TakeBlipClient takeBlipClient;

    public void receiveMessage(MessageDto messageDto) {

        Message message = messageDto.convertToMessage(messageDto);
        Intention intention = null;
        Intention nextIntention = null;
        String content = null;

        User user = userService.findByIdTakeBlip(message.getIdMessageTakeBlip());

        UserHistory userHistory = userHistoryService.findByUser(user);

        if (userHistory == null || userHistory.getNextIntention() == Intention.GREETING) {
            if (user.getName() == null || user.getName().isEmpty()) {
                content = "Olá, estou feliz que veio falar comigo, meu nome é BrunoFelixBot, como posso te chamar?";
            } else {
                content = "Olá, que bom que voltou " + user.getName() + ", já estava com saudades!";
            }
            intention = Intention.GREETING;
            nextIntention = Intention.REQUEST_NAME;
        }

        //TO DO - rest of intentions

        userHistoryService.create(user, message, intention, nextIntention);

        this.sendMessage(messageDto.getFrom(), content);
        this.sendNotification(messageDto.getId(), messageDto.getFrom(), NotificationDto.Event.RECEIVED);
    }

    public void receiveNotification(NotificationDto notificationDto) {
        Message message = messageService.findByIdMessageTakeBlip(notificationDto.getId());
        message.setShippingStatus(notificationDto.getEvent().toString());
        /*if (notificationDto.getReason() != null) {
            //TO DO
        }*/
    }

    public void sendMessage(String to, String content) {
        MessageDto messageDto = new MessageDto();
        messageDto.setId(UUID.randomUUID().toString());
        messageDto.setTo(to);
        messageDto.setType("application/vnd.lime.collection+json");
        messageDto.setContent(content);

        takeBlipClient.postNotification(messageDto.toString());
    }
    public void sendNotification(String idMessageTakeBlip, String from, NotificationDto.Event event) {
        NotificationDto notificationDto = new NotificationDto();
        notificationDto.setId(idMessageTakeBlip);
        notificationDto.setFrom(from);
        notificationDto.setEvent(event);

        takeBlipClient.postNotification(notificationDto.toString());
    }

}
