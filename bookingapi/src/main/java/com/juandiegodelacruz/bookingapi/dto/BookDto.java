package com.juandiegodelacruz.bookingapi.dto;

import jakarta.validation.constraints.*;

// DTO have different notations to strick to the constraints mentioned in the .pdf sent

public class BookDto {

    @NotBlank(message = "Required property 'id'")
    @Size(min = 9, max = 10, message = "Id must be between 9 and 10 characters")
    private String id;

    @NotBlank(message = "Required property 'name'")
    @Size(min = 2, max = 50, message = "name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Required property 'lastname'")
    @Size(min = 2, max = 50, message = "lastname must be between 2 and 50 characters")
    private String lastname;

    @NotNull(message = "Required property 'age'")
    @Min(value = 18, message = "age should be at least 18")
    @Max(value = 100, message = "age should not be greater than 100")
    private Integer age;

    @NotBlank(message = "Required property 'phoneNumber'")
    @Size(min = 9, max = 20, message = "phoneNumber must be between 9 and 20 characters")
    private String phoneNumber;

    @NotBlank(message = "Required property 'startDate'")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Date must be in the format yyyy-MM-dd")
    private String startDate;

    @NotBlank(message = "Required property 'endDate'")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Date must be in the format yyyy-MM-dd")
    private String endDate;

    @NotBlank(message = "Required property 'houseId'")
    @Size(min = 6, max = 15, message = "houseId must be between 6 and 15 characters")
    private String houseId;

    @Size(min = 8, max = 8, message = "discountCode must be just 8 characters")
    private String discountCode;

    public BookDto(){}

    public BookDto(String id, String name, String lastname, Integer age, String phoneNumber, String startDate, String endDate, String houseId, String discountCode) {
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

    public @NotBlank(message = "Required property 'id'") String getId() {
        return id;
    }

    public void setId(@NotBlank(message = "Required property 'id'") String id) {
        this.id = id;
    }

    public @NotBlank(message = "Required property 'name'") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Required property 'name'") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Required property 'lastname'") String getLastname() {
        return lastname;
    }

    public void setLastname(@NotBlank(message = "Required property 'lastname'") String lastname) {
        this.lastname = lastname;
    }

    public @NotNull(message = "Required property 'age'") Integer getAge() {
        return age;
    }

    public void setAge(@NotNull(message = "Required property 'age'") Integer age) {
        this.age = age;
    }

    public @NotBlank(message = "Required property 'phoneNumber'") String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@NotBlank(message = "Required property 'phoneNumber'") String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public @NotBlank(message = "Required property 'startDate'") String getStartDate() {
        return startDate;
    }

    public void setStartDate(@NotBlank(message = "Required property 'startDate'") String startDate) {
        this.startDate = startDate;
    }

    public @NotBlank(message = "Required property 'endDate'") String getEndDate() {
        return endDate;
    }

    public void setEndDate(@NotBlank(message = "Required property 'endDate'") String endDate) {
        this.endDate = endDate;
    }

    public @NotBlank(message = "Required property 'houseId'") String getHouseId() {
        return houseId;
    }

    public void setHouseId(@NotBlank(message = "Required property 'houseId'") String houseId) {
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
        return "BookDto{" +
                "id='" + id + '\'' +
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
