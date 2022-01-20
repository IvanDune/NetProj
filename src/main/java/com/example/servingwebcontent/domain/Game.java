package com.example.servingwebcontent.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Table(name ="game", schema = "public")
@Entity
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

    /*@ManyToMany
    @JoinTable(
            name = "user_sub",
            joinColumns = { @JoinColumn(name ="game_id")},
            inverseJoinColumns = { @JoinColumn(name = "user_id")}
    )
    private Set<User> subscribers = new HashSet<>();*/




    public Game(){

    }

    public Game(String name, String description, System system, String discord, Date date) {
        this.name = name;
        this.description = description;
        this.system = system;
        this.discord = discord;
        this.date = date;

    }

   /* public Set<User> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Set<User> subscribers) {
        this.subscribers = subscribers;
    }*/

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public System getSystem() {
        return system;
    }

    public void setSystem(System system) {
        this.system = system;
    }

    public String getDiscord() {
        return discord;
    }

    public void setDiscord(String discord) {
        this.discord = discord;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
