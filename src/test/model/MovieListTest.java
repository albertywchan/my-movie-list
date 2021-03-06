package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class MovieListTest {
    MovieList l1;
    MovieList l2;
    MovieList l3;

    @BeforeEach
    void runBefore() {
        l1 = new MovieList("l1");
        l2 = new MovieList("l2");
        l3 = new MovieList("l3");
        Movie m1 = new Movie("Batman", "Action");
        Movie m2 = new Movie("Finding Nemo", "Family");
        Movie m3 = new Movie("Saw", "Horror");
        Movie m4 = new Movie("Superbad", "Comedy");
        l1.addMovie(m1);
        l1.addMovie(m2);
        l2.addMovie(m3);
        l2.addMovie(m4);
    }

    @Test
    void testName() {
        assertEquals(l1.getName(), "l1");
        l1.setName("Test Movie List");
        assertNotEquals(l1.getName(), "l1");
        assertEquals(l1.getName(), "Test Movie List");
    }

    @Test
    void testGetMovies() {
        LinkedList<Movie> movies = new LinkedList<>();
        Movie m1 = new Movie("Star Wars", "Sci-Fi");
        Movie m2 = new Movie("Harry Potter", "Fantasy");
        movies.add(m1);
        l3.addMovie(m1);
        movies.add(m2);
        l3.addMovie(m2);
        assertEquals(movies, l3.getMovies());
    }

    @Test
    void testAddAndRemove() {
        assertEquals(l1.length(), 2);
        assertEquals(l2.length(), 2);
        Movie m1 = new Movie("Spiderman", "Action");
        Movie m2 = new Movie("Frozen", "Family");
        l1.addMovie(m1);
        l1.addMovie(m2);
        l2.removeMovie("Saw");
        l2.removeMovie("Superbad");
        assertEquals(l1.length(), 4);
        assertEquals(l2.length(), 0);
    }

    @Test
    void testReviews() {
        assertEquals(l1.getTitleAndGenre("Batman"), "Title: Batman\nGenre: Action\n");
        assertEquals(l1.getTitleAndGenre("Finding Nemo"), "Title: Finding Nemo\nGenre: Family\n");
        l1.updateReview("Batman", 4, "Excellent movie.");
        l1.updateReview("Finding Nemo", 3, "Great movie for children.");
        assertEquals(l1.getReview("Batman"), "Title: Batman\nGenre: Action\n"
                + "Rating: 4/5\nComment: Excellent movie.\n");
        assertEquals(l1.getReview("Finding Nemo"), "Title: Finding Nemo\nGenre: Family\n"
                + "Rating: 3/5\nComment: Great movie for children.\n");
    }

    @Test
    void testHasMovie() {
        assertFalse(l1.hasMovie("Spiderman"));
        assertTrue(l1.hasMovie("Batman"));
        assertFalse(l2.hasMovie("Saw 2"));
        assertTrue(l2.hasMovie("Saw"));
    }

    @Test
    void testIsEmpty() {
        assertFalse(l1.isEmpty());
        l1.removeMovie("Batman");
        assertFalse(l1.isEmpty());
        l1.removeMovie("Finding Nemo");
        assertTrue(l1.isEmpty());
    }

    @Test
    void testToString() {
        assertEquals(l1.toString(), "Batman, Finding Nemo");
        assertEquals(l2.toString(), "Saw, Superbad");
        Movie m1 = new Movie("Spiderman", "Action");
        Movie m2 = new Movie("Frozen", "Family");
        l1.addMovie(m1);
        l1.addMovie(m2);
        l2.removeMovie("Saw");
        l2.removeMovie("Superbad");
        assertEquals(l1.toString(), "Batman, Finding Nemo, Spiderman, Frozen");
        assertEquals(l2.toString(), "");
    }
}
