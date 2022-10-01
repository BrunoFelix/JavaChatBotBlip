package com.chatbot.blip.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="Message")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "id_message_take_blip")
    public String idMessageTakeBlip;

    @Column(name = "origin")
    public String origin;

    @Column(name = "receiver")
    public String receiver;

    @Column(name = "content_type")
    public String contentType;

    @Lob
    @Column(name = "content")
    public String content;

    @Column(name = "status")
    @Enumerated
    public Status status;

    @Column(name = "shipping_status")
    public String shippingStatus;

    @Column(name = "failure")
    public String failure;

    @Column(name = "failure_description")
    public String failureDescription;
}
