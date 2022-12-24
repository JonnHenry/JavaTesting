package org.example.movies.data;

import org.example.movies.model.Genre;
import org.example.movies.model.Movie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class MovieRepositoryImplShould {

    DataSource dataSource;

    @Mock
    JdbcTemplate jdbcTemplate;

    @InjectMocks
    MovieRepositoryImpl movieRepository;

    @BeforeEach
    void setUp() throws SQLException {
        dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));

        jdbcTemplate = new JdbcTemplate(dataSource);
        movieRepository = new MovieRepositoryImpl(jdbcTemplate);
    }

    @Test
    public void loadAllMovies() throws SQLException {
        Collection<Movie> movies = movieRepository.findAll();
        assertThat(movies,
                is(
                    Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Genre.ACTION) ,
                        new Movie(2, "Memento", 113, Genre.THRILLER) ,
                        new Movie(3, "Matrix", 136, Genre.ACTION)
                    )
                )
        );
    }

    @Test
    public void loadMovieById() throws SQLException {

        Movie movie = movieRepository.findById(2);
        assertThat(movie,
                is(new Movie(2, "Memento", 113, Genre.THRILLER))
        );
    }

    @Test
    public void loadMovieByName() throws SQLException {
        Movie movie = movieRepository.findByName("Memento");
        assertThat(movie,
                is(new Movie(2, "Memento", 113, Genre.THRILLER))
        );
    }

    @Test
    public void insertMovie() throws SQLException {
        Movie movieInser = new Movie("Super 8", 112, Genre.THRILLER);
        movieRepository.saveOrUpdate(movieInser);
        Movie movieLoaded = movieRepository.findById(4);
        Movie movieCompare = new Movie(4,"Super 8", 112, Genre.THRILLER);
        assertThat(movieLoaded, is(movieCompare));
    }

    @AfterEach
    public void tearDown() throws Exception{
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("DROP ALL objects DELETE files");
    }

}