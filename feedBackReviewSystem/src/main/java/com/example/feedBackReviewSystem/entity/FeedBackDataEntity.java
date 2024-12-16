package com.example.feedBackReviewSystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name="feedback_data")
public class FeedBackDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @Column(name = "email" ,unique = true)
    private String email;
    private int rating;
    private  String comment;
    @Column(name = "is_approve", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private  boolean isApprove;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean getApprove() {
        return isApprove;
    }

    public void setApprove(boolean approve) {
        isApprove = approve;
    }


}
