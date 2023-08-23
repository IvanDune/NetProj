package com.example.servingwebcontent.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name="gameSystem")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class GameSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="comments")
    private String comments;
    @Column(name="dices")
    private String dices;
    public GameSystem(String name, String description, String comments, String dices){
        this.name=name;
        this.description=description;
        this.comments=comments;
        this.dices=dices;
    }
}
