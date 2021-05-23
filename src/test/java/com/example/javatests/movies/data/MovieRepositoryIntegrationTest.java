package com.example.javatests.movies.data;

import com.example.javatests.movies.model.Movie;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static com.example.javatests.movies.model.Genre.ACTION;
import static com.example.javatests.movies.model.Genre.THRILLER;
import static org.junit.Assert.assertEquals;

public class MovieRepositoryIntegrationTest {

    private MovieRepositoryJdbc movieRepositoryJdbc;
    private DriverManagerDataSource driverManagerDataSource;

    @Before
    public void setUp() throws Exception {
        driverManagerDataSource =
                new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");

        ScriptUtils.executeSqlScript(driverManagerDataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));

        movieRepositoryJdbc = new MovieRepositoryJdbc(driverManagerDataSource);
    }

    @Test
    public void loadAllMovies() throws SQLException {

        Collection<Movie> movies = movieRepositoryJdbc.findAll();

        assertEquals(Arrays.asList(
                new Movie(1, "Dark Knight", 152, ACTION),
                new Movie(2, "Memento", 113, THRILLER),
                new Movie(3, "Matrix", 136, ACTION)
        ), movies);
    }

    @Test
    public void loadMovieById() {
        Movie movie = movieRepositoryJdbc.findById(1);

        assertEquals(new Movie(1, "Dark Knight", 152, ACTION), movie);
    }

    @Test
    public void insertMovie() {

        Movie movie = new Movie("Super 8", 112, THRILLER);

        movieRepositoryJdbc.saveOrUpdate(movie);

        Movie recoveredMovie = movieRepositoryJdbc.findById(4);

        assertEquals(recoveredMovie, new Movie(4, "Super 8", 112, THRILLER));
    }

    @Test
    public void loadMovieByName() {
        Collection<Movie> moviesMemento = movieRepositoryJdbc.findByName("memento");
        Collection<Movie> moviesMat = movieRepositoryJdbc.findByName("mat");

        assertEquals(Arrays.asList(new Movie(2, "Memento", 113, THRILLER)), moviesMemento);
        assertEquals(Arrays.asList(new Movie(3, "Matrix", 136, ACTION)), moviesMat);
    }

    @After
    public void tearDown() throws Exception {
        final Statement s = driverManagerDataSource.getConnection().createStatement();
        s.execute("drop all objects delete files");
    }
}