package com.dolsoft.bookservice.model;

import org.springframework.hateoas.RepresentationModel;

public class Book extends RepresentationModel<Book> {
    private Long id;
    private String title;
    private String coverType;
    private String publisher;
    private int year;
    private String genre;

    public Book() {}

    public Book(Long id, String title, String coverType, String publisher, int year, String genre) {
        this.id = id;
        this.title = title;
        this.coverType = coverType;
        this.publisher = publisher;
        this.year = year;
        this.genre = genre;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoverType() {
        return coverType;
    }

    public void setCoverType(String coverType) {
        this.coverType = coverType;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}