package art.lapov.service;

import art.lapov.model.Book;
import art.lapov.model.Review;

import java.util.List;

public class ReviewService {
    private static List<Book> books;
    private static List<Review> reviews;

    public ReviewService(List<Book> books, List<Review> reviews) {
        this.books = books;
        this.reviews = reviews;
    }

    public List<Review> getReviewsByAuthor(String name) {
        return reviews.stream()
                .filter(review -> review.getUserName().equals(name))
                .sorted( (r1, r2) -> r2.getDateOfComment().compareTo(r1.getDateOfComment()))
                .toList();
    }

    public List<Review> getReviewsByBookId(int bookId) {
        return reviews.stream()
                .filter(r -> r.getBookId() == bookId)
                .toList();
    }

    public void showReviewsByBookId(int bookId) {
        System.out.println("\nAvis pour le livre " + BookService.getBookById(bookId, books).getName() + " :");
        getReviewsByBookId(bookId).forEach(System.out::println);
    }
}
