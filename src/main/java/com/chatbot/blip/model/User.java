package com.chatbot.blip.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "User", uniqueConstraints = {@UniqueConstraint(name = "UniqueIdTakeBlip", columnNames = {"id_take_blip"})})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String id;

    @Column(name = "id_take_blip", unique = true)
    public String idTakeBlip;

    @Column(name = "name", nullable = false, length = 100)
    public String name;
}
