package art.lapov.service;

import art.lapov.model.Book;
import art.lapov.model.Genre;
import art.lapov.model.Review;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookService {
    private static List<Book> books;
    private static List<Review> reviews;

    public BookService(List<Book> books, List<Review> reviews) {
        this.books = books;
        this.reviews = reviews;
    }

    public static double calculateAverageRating(Book book) {
        return reviews.stream()
                .filter(review -> review.getBookId() == book.getId())
                .mapToDouble(Review::getRating)
                .average()
                .orElse(0.0);
    }

    public static List<Book> getBooksSortedByAverageRating() {
        return books.stream()
                .sorted(Comparator.comparingDouble(book -> calculateAverageRating((Book) book)).reversed())
                .collect(Collectors.toList());
    }

    public static Book getBookById(int id, List<Book> books) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public static Book getTheBestBooksByGenre(Genre genre) {
       return books.stream()
                .filter(b -> b.getGenre() == genre)
                .max(Comparator.comparingDouble(b -> calculateAverageRating(b)))
               .orElse(null);
    }



}
