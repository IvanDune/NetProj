//package com.example.servingwebcontent.domain;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
////DELETE
//@Entity
//public class Grade {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;
//
//    private Integer masterNumber;
//
//    private Integer value = 0;
//
//    private Double mean = 0d;
//
//    public Grade(){
//
//    }
//
//    public Grade(Integer masterNumber, Integer num){
//        this.masterNumber=masterNumber;
//        value++;
//        mean = (double) num/value;
//    }
//
//    public void addGrade(Integer number) {
//        if (value != 0){
//            double sum = value * mean + number;
//            value++;
//            mean=sum/value;
//        }
//    }
//
//    public Integer getMasterNumber() {
//        return masterNumber;
//    }
//
//    public void setMasterNumber(Integer masterNumber) {
//        this.masterNumber = masterNumber;
//    }
//
//    public Integer getValue() {
//        return value;
//    }
//
//    public void setValue(Integer value) {
//        this.value = value;
//    }
//
//    public Double getMean() {
//        return mean;
//    }
//
//    public void setMean(Double mean) {
//        this.mean = mean;
//    }
//}
