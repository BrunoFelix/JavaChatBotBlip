package com.chatbot.blip.controller;

import com.chatbot.blip.controller.dto.MessageDto;
import com.chatbot.blip.controller.dto.NotificationDto;
import com.chatbot.blip.service.TakeBlipWebhookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/v1/take-blip-webhook")
public class TakeBlipWebhookController {

    @Autowired
    public TakeBlipWebhookService takeBlipWebhookService;
    @PostMapping("/message")
    @ResponseStatus(HttpStatus.OK)
    private void getMessage(@RequestBody MessageDto message) throws InterruptedException, ExecutionException {
        CompletableFuture.runAsync(() -> {
            takeBlipWebhookService.receiveMessage(message);
        });
    }

    @PostMapping("/notification")
    @ResponseStatus(HttpStatus.OK)
    private void getNotification(@RequestBody NotificationDto notification) {
        CompletableFuture.runAsync(() -> {
            takeBlipWebhookService.receiveNotification(notification);
        });
    }
}
