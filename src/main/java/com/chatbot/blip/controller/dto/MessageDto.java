package com.chatbot.blip.controller.dto;

import com.chatbot.blip.model.Message;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("from")
    private String from;

    @JsonProperty("to")
    private String to;

    @JsonProperty("type")
    private String type;

    @JsonProperty("content")
    private String content;

    public Message convertToMessage(MessageDto messageDto) {
        Message message = new Message();
        message.setIdMessageTakeBlip(messageDto.getId());
        message.setOrigin(messageDto.getFrom());
        message.setReceiver(messageDto.getTo());
        message.setContentType(messageDto.getType());
        message.setContent(messageDto.getContent());
        return message;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            System.out.println("Error to converter JSON: " + e.getMessage());
        }
        return null;
    }
}
