package com.chatbot.blip.service;

import com.chatbot.blip.model.Intention;
import com.chatbot.blip.model.Message;
import com.chatbot.blip.model.User;
import com.chatbot.blip.model.UserHistory;
import com.chatbot.blip.repository.UserHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserHistoryService {

    @Autowired
    public UserHistoryRepository userHistoryRepository;

    public UserHistory findByUser(User user) {
        return userHistoryRepository.findFirstByUserOrderByIdDesc(user).orElse(null);
    }

    public UserHistory create(User user, Message message, Intention intention, Intention nextIntention) {
        UserHistory userHistory = new UserHistory();
        userHistory.setUser(user);
        userHistory.setMessage(message);
        userHistory.setIntention(intention);
        userHistory.setNextIntention(nextIntention);
        return userHistoryRepository.save(userHistory);
    }
}
