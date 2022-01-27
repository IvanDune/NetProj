package com.example.servingwebcontent.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer value = 0;

    private Double mean = 0d;

    public Grade(){

    }

//    public Grade(Integer number) {
//        if (value != 0){
//            double sum = value * mean + number;
//            value++;
//            mean=sum/value;
//        }
//    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

//    public Double getMean() {
//        return mean;
//    }
//
//    public void setMean(Double mean) {
//        this.mean = mean;
//    }
}
