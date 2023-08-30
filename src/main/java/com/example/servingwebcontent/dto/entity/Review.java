package com.example.servingwebcontent.dto.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

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
    private Long masterId;
    @Column(name="author")
    private Long authorId;
    public Review(String message, int grade, Long masterId, Long authorId) {
        this.message = message;
        this.grade = grade;
        this.masterId = masterId;
        this.authorId = authorId;
    }

}
