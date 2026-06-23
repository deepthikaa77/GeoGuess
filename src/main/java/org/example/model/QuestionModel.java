package org.example.model;

public class QuestionModel {
    private String capital;
    private String country;

    public QuestionModel(String captial, String country){
        this.capital = captial;
        this.country = country;
    }

    public String getCapital() {
        return capital;
    }

    public String getCountry() {
        return country;
    }
}

