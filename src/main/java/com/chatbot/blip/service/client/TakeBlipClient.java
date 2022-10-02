package com.chatbot.blip.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "takeBlip", url = "${take.blip.url}")
public interface TakeBlipClient {


    @PostMapping("/messages")
    public String postMessage(@RequestBody String request);

    @PostMapping("/notifications")
    public String postNotification(@RequestBody String request);

    @PostMapping("/commands")
    public String postCommand(@RequestBody String request);
}
