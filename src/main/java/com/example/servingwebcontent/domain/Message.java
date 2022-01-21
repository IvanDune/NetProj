package com.example.servingwebcontent.domain;

import javax.persistence.*;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;

    private Integer num;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public Message() {
    }
    public Message(String text, User author, Integer number) {
        this.author=author;
        this.text = text;
        this.num=number;
    }

    public Integer getNumber() {
        return num;
    }

    public void setNumber(Integer number) {
        this.num = number;
    }

    public String getAuthorName(){
        return author!=null?author.getNickname():"none";
    }
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
