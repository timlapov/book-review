package art.lapov.service;

import art.lapov.model.Book;
import art.lapov.model.Review;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookService {

    public static double calculateAverageRating(Book book, List<Review> allReviews) {
        return allReviews.stream()
                .filter(review -> review.getBookId() == book.getId())
                .mapToDouble(Review::getRating)
                .average()
                .orElse(0.0);
    }

    public static List<Book> getBooksSortedByAverageRating(List<Book> books, List<Review> reviews) {
        return books.stream()
                .sorted(Comparator.comparingDouble(book -> calculateAverageRating((Book) book, reviews)).reversed())
                .collect(Collectors.toList());
    }

}
