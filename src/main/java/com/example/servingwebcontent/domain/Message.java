//package com.example.servingwebcontent.domain;
//
//import javax.persistence.*;
//
//// DELETE
//@Table(name = "message")
//@Entity
//public class Message {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    private String text;
//
//    private Integer num;
//
//    private String master;
//    private String author;
//
//    public Message() {
//    }
//    public Message(String text, String master, String author, Integer number) {
//        this.master=master;
//        this.author=author;
//        this.text = text;
//        this.num=number;
//    }
//
//    public Integer getNumber() {
//        return num;
//    }
//
//    public void setNumber(Integer number) {
//        this.num = number;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//
//    public String getText() {
//        return text;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }
//
//    public Integer getNum() {
//        return num;
//    }
//
//    public void setNum(Integer num) {
//        this.num = num;
//    }
//
//    public String getMaster() {
//        return master;
//    }
//
//    public void setMaster(String master) {
//        this.master = master;
//    }
//}
