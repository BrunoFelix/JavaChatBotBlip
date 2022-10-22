package com.chatbot.blip.repository;

import com.chatbot.blip.model.Message;
import com.chatbot.blip.model.Status;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MessageRepository extends CrudRepository<Message, Long> {

    Optional<Message> findByIdMessageTakeBlip(String id);
    List<Message> findAllByStatusOrderByIdAsc(Status status);
}