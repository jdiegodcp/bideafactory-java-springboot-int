package com.juandiegodelacruz.bookingapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBooked;

    public Long getIdBooked() {
        return idBooked;
    }

    public void setIdBooked(Long idBooked) {
        this.idBooked = idBooked;
    }

    private String id;
    private String name;
    private String lastname;
    private Integer age;
    private String phoneNumber;
    private String startDate;
    private String endDate;
    private String houseId;
    private String discountCode;

    public Book(){}

    public Book(Long idBooked, String id, String name, String lastname, Integer age, String phoneNumber, String startDate, String endDate, String houseId, String discountCode) {
        this.idBooked = idBooked;
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.houseId = houseId;
        this.discountCode = discountCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    @Override
    public String toString() {
        return "Book{" +
                "idBooked=" + idBooked +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", houseId='" + houseId + '\'' +
                ", discountCode='" + discountCode + '\'' +
                '}';
    }
}