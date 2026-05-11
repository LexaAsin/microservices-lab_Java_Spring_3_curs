package com.dolsoft.authorservice.model;

import org.springframework.hateoas.RepresentationModel;
import javax.persistence.*;

@Entity
@Table(name = "authors")
public class Author extends RepresentationModel<Author> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "rating")
    private int rating;

    public Author() {}

    public Author(Long id, String fullName, String phone, String email, int rating) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.rating = rating;
    }

    // Геттеры и сеттеры
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
}