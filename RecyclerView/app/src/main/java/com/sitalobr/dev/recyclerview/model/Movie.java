package com.sitalobr.dev.recyclerview.model;

public class Movie {
    private String title;
    private Integer year;
    private String gender;

    public Movie(String title, Integer year, String gender) {
        this.title = title;
        this.year = year;
        this.gender = gender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
