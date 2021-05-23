package com.example.javatests.movies.service;

import com.example.javatests.movies.data.MovieRepository;
import com.example.javatests.movies.model.Genre;
import com.example.javatests.movies.model.Movie;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.javatests.movies.model.Genre.*;
import static org.junit.Assert.*;

public class MovieServiceShould {

    private MovieService movieService;

    @Before
    public void setUp() throws Exception {
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);

        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, ACTION),
                        new Movie(2, "Memento", 113, THRILLER),
                        new Movie(3, "There's Something About Mary", 119, COMEDY),
                        new Movie(4, "Super 8", 112, THRILLER),
                        new Movie(5, "Scream", 111, HORROR),
                        new Movie(6, "Home Alone", 103, COMEDY),
                        new Movie(7, "Matrix", 136, ACTION)
                )
        );

        movieService = new MovieService(movieRepository);
    }

    @Test
    public void returnMoviesByGenre() {
        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);

        assertEquals(Arrays.asList(3, 6), getMovieIds(movies));
    }

    @Test
    public void returnMoviesByLength() {
        Collection<Movie> movies = movieService.findMoviesByLength(119);

        assertEquals(Arrays.asList(2, 3, 4, 5, 6), getMovieIds(movies));
    }

    private List<Integer> getMovieIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }
}