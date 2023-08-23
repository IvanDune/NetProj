package com.example.servingwebcontent.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name="review")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="message")
    private String message;
    @Column(name="grade")
    private int grade;
    @Column(name="master")
    private String master;
    @Column(name="author")
    private String author;
    public Review(String message, int grade, String master, String author) {
        this.message = message;
        this.grade = grade;
        this.master = master;
        this.author = author;
    }

}
