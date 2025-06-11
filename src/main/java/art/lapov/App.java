package art.lapov;

import art.lapov.data.FakeDatabase;
import art.lapov.model.Book;
import art.lapov.model.Review;
import art.lapov.service.BookService;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("*".repeat(100));
        System.out.println("\nBienvenue à notre club de lecture\n");
        System.out.println("*".repeat(100));

        System.out.println("Tous les livres de la base de données originale: ");
        List<Book> books = FakeDatabase.getBooks();
        List<Review> reviews = FakeDatabase.getReviews();
        System.out.println(books);
        System.out.println("\n" + "=".repeat(100));

        System.out.println("\nAfficher la liste des livres triés par moyenne des notes : ");

        List<Book> sortedBooks = BookService.getBooksSortedByAverageRating(books, reviews);
        sortedBooks.forEach(book -> {
        double averageRating = BookService.calculateAverageRating(book, reviews);
        System.out.printf("Livre: %s (Auteur: %s) - Note moyenne: %.2f%n",
                book.getName(),
                book.getAuthor(),
                averageRating
        );});
        System.out.println("=".repeat(100));

        System.out.println("\nAfficher les critiques d’un auteur donné, triées par date décroissante.");
    }
}
