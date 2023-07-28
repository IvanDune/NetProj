package com.example.servingwebcontent.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Table(name ="game", schema = "public")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name="system")
    private System system;
    @Column(name="discord")
    private String discord;
    @Column(name="dateTime")
    private Date date;
    @ManyToMany //(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_sub",
            joinColumns = { @JoinColumn(name ="game_id")},
            inverseJoinColumns = { @JoinColumn(name = "user_id")}
    )
    private Set<User> subscribers = new HashSet<>();
    public Game(String name, String description, System system, String discord, Date date) {
        this.name = name;
        this.description = description;
        this.system = system;
        this.discord = discord;
        this.date = date;
    }
}
