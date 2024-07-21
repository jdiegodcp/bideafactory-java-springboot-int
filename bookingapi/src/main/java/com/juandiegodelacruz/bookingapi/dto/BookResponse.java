package com.juandiegodelacruz.bookingapi.dto;

public class BookResponse {
    private int code;
    private String message;

    public BookResponse(){}

    public BookResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "BookResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
