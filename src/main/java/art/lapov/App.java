package art.lapov;

import art.lapov.data.FakeDatabase;
import art.lapov.model.Book;
import art.lapov.model.Genre;
import art.lapov.model.Review;
import art.lapov.service.BookService;
import art.lapov.service.ReviewService;

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

        BookService bookService = new BookService(books, reviews);
        ReviewService reviewService = new ReviewService(books, reviews);

        System.out.println(books);
        System.out.println("\n" + "=".repeat(100));

        System.out.println("\nAfficher la liste des livres triés par moyenne des notes : ");

        List<Book> sortedBooks = bookService.getBooksSortedByAverageRating();
        sortedBooks.forEach(book -> {
        double averageRating = bookService.calculateAverageRating(book);
        System.out.printf("Livre: %s (Auteur: %s) - Note moyenne: %.2f%n",
                book.getName(),
                book.getAuthor(),
                averageRating
        );});
        System.out.println("=".repeat(100));

        System.out.println("\nAfficher les critiques d’un auteur donné, triées par date décroissante.");
        System.out.println("Alice : " + reviewService.getReviewsByAuthor("Alice"));
        System.out.println("=".repeat(100));

        System.out.println("\nRechercher les meilleurs livres par genre, avec la meilleure moyenne.");
        System.out.println("Les meilleurs livres de la fantasy : " + bookService.getTheBestBooksByGenre(Genre.SCIENCE_FICTION));
        System.out.println("=".repeat(100));

        System.out.println("\nFiltrer les livres publiés avant une certaine année et afficher leurs critiques.");
        bookService.getBooksBeforeYear(1954).forEach(book -> reviewService.showReviewsByBookId(book.getId()));
        System.out.println("=".repeat(100));

        System.out.println("\nGrouper les livres par genre et afficher, pour chaque groupe, le nombre de livres et la note moyenne globale.");
        System.out.println("\nSCIENCE_FICTION : " + bookService.getBooksByGenre(Genre.SCIENCE_FICTION).size() + " livre(s)");
        System.out.println("La note moyenne des livres de ce genre est de : " + bookService.getAverageRatingByGenre(Genre.SCIENCE_FICTION));
        System.out.println("\nFANTASY : " + bookService.getBooksByGenre(Genre.FANTASY).size() + " livre(s)");
        System.out.println("La note moyenne des livres de ce genre est de : " + bookService.getAverageRatingByGenre(Genre.FANTASY));
        System.out.println("\nPOLICIER : " + bookService.getBooksByGenre(Genre.POLICIER).size() + " livre(s)");
        System.out.println("La note moyenne des livres de ce genre est de : " + bookService.getAverageRatingByGenre(Genre.POLICIER));
        System.out.println("=".repeat(100));

    }
}
