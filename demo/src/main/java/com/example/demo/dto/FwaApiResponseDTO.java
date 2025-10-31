package com.example.demo.dto;

public class FwaApiResponseDTO<T>{

    private T response;

    public FwaApiResponseDTO(){}

    public FwaApiResponseDTO(T response) {
        this.response = response;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
