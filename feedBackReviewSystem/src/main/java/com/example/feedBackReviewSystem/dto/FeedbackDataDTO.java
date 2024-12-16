package com.example.feedBackReviewSystem.dto;

import org.springframework.stereotype.Component;

@Component
public class FeedbackDataDTO {
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String name;
    private String email;
    private int rating;
    private  String comment;
    private boolean isApprove;

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
