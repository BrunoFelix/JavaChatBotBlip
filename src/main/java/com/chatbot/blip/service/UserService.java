package com.chatbot.blip.service;

import com.chatbot.blip.model.User;
import com.chatbot.blip.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public User create(User user){
        return userRepository.save(user);
    }

    public User findByIdTakeBlip(String idTakeBlio) {
        return userRepository.findByIdTakeBlip(this.getUserIdentifier(idTakeBlio)).orElseGet(() -> {
            User newUser = new User();
            newUser.setId(this.getUserIdentifier(idTakeBlio));
            return this.create(newUser);
        });
    }

    private String getUserIdentifier(String data) {
        return data.substring(0, data.indexOf("@"));
    }
}
