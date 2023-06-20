package com.example.demo.dto;

public class FactDTO {
    public String fact;

    public FactDTO() {
        this.fact = "";
    }

    public FactDTO(String fact) {
        this.fact = fact;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }
}
