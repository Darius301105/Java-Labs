package app;

import model.Movie;
import repository.MovieRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MovieRepository repository = new MovieRepository();

        repository.createTable();

        repository.addMovie(new Movie("Inception", "Christopher Nolan", 2010));
        repository.addMovie(new Movie("Interstellar", "Christopher Nolan", 2014));
        repository.addMovie(new Movie("The Matrix", "Wachowski Sisters", 1999));

        System.out.println("\nAll movies after insert:");
        printMovies(repository.getAllMovies());

        repository.updateMovieTitle(2, "Interstellar Updated");
        System.out.println("\nAll movies after update:");
        printMovies(repository.getAllMovies());

        repository.deleteMovie(1);
        System.out.println("\nAll movies after delete:");
        printMovies(repository.getAllMovies());
    }

    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
}