package com.example.servingwebcontent.dto.dnd.characters;

import jakarta.persistence.*;

@Entity
public class DHNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "num")
    private Integer num;

    public DHNumber() {

    }

    public DHNumber(Integer num) {
        this.num = num;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
