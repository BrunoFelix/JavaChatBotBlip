package com.chatbot.blip.repository;

import com.chatbot.blip.model.User;
import com.chatbot.blip.model.UserHistory;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserHistoryRepository extends CrudRepository<UserHistory, Long> {

    Optional<UserHistory> findFirstByUserOrderByIdDesc(User user);
}