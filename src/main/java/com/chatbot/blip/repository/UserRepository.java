package com.chatbot.blip.repository;

import com.chatbot.blip.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {

    Optional<User> findByIdTakeBlip(String idTakeBlip);
}