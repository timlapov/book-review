package art.lapov.service;

import art.lapov.model.Book;
import art.lapov.model.Genre;
import art.lapov.model.Review;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookService {
    private final List<Book> books;
    private final List<Review> reviews;

    public BookService(List<Book> books, List<Review> reviews) {
        this.books = books;
        this.reviews = reviews;
    }

    public double calculateAverageRating(Book book) {
        return reviews.stream()
                .filter(review -> review.getBookId() == book.getId())
                .mapToDouble(Review::getRating)
                .average()
                .orElse(0.0);
    }

    public List<Book> getBooksSortedByAverageRating() {
        Map<Book, Double> averageRatings = books.stream()
                .collect(Collectors.toMap(
                        book -> book,
                        this::calculateAverageRating
                ));

        return books.stream()
                .sorted(Comparator.comparingDouble(averageRatings::get).reversed())
                .toList();
    }

    public static Book getBookById(int id, List<Book> books) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Book getTheBestBooksByGenre(Genre genre) {
       return books.stream()
                .filter(b -> b.getGenre() == genre)
                .max(Comparator.comparingDouble(this::calculateAverageRating))
               .orElse(null);
    }

    public List<Book> getBooksBeforeYear(int year) {
        return books.stream()
                .filter(b -> b.getYear() < year)
                .toList();
    }

    public List<Book> getBooksByGenre(Genre genre) {
        return books.stream()
                .filter(book -> book.getGenre().equals(genre))
                .toList();
    }

    public double getAverageRatingByGenre(Genre genre) {
        return books.stream()
                .filter(book -> book.getGenre().equals(genre))
                .mapToDouble(this::calculateAverageRating)
                .average()
                .orElse(0.0);
    }

}
