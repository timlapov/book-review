package art.lapov.model;

import java.time.LocalDate;

public class Review {
    private int bookId;
    private String userName;
    private Double rating;
    private String comment;
    private LocalDate dateOfComment;

    public Review(int bookId, String userName, Double rating, String comment, LocalDate dateOfComment) {
        this.bookId = bookId;
        this.userName = userName;
        this.rating = rating;
        this.comment = comment;
        this.dateOfComment = dateOfComment;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getDateOfComment() {
        return dateOfComment;
    }

    public void setDateOfComment(LocalDate dateOfComment) {
        this.dateOfComment = dateOfComment;
    }
}
