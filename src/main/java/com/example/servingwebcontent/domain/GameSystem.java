package com.example.servingwebcontent.domain;

import javax.persistence.*;

@Table(name="gameSystem")
@Entity
public class GameSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private String comments;

    private String dices;

    //private String - движок (?)

    public GameSystem(){

    }

    public GameSystem(String name, String description, String comments, String dices){
        this.name=name;
        this.description=description;
        this.comments=comments;
        this.dices=dices;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDices() {
        return dices;
    }

    public void setDices(String dices) {
        this.dices = dices;
    }
}
