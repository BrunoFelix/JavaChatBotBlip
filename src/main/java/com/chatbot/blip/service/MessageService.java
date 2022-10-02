package com.chatbot.blip.service;

import com.chatbot.blip.model.Message;
import com.chatbot.blip.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    public MessageRepository messageRepository;

    public Message findByIdMessageTakeBlip(String idMessageTakeBlip) {
        return messageRepository.findByIdMessageTakeBlip(idMessageTakeBlip).orElseThrow(RuntimeException::new);
    }
}
