package com.example.servingwebcontent.domain;

import javax.persistence.*;
import java.util.Date;

@Table(name ="game", schema = "public")
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name="system")
    private System system;

    @Column(name="discord")
    private String discord;

    @Column(name="dt")
    private Date dateTime;

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Game(){

    }

    public Game(String name, String description, System system, String discord, Date dateTime) {
        this.name = name;
        this.description = description;
        this.system = system;
        this.discord = discord;
        this.dateTime = dateTime;
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

    public Integer getId() {
        return id;
    }
}
