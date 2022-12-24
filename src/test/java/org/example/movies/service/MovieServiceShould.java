package org.example.movies.service;

import org.example.movies.data.MovieRepository;
import org.example.movies.model.Genre;
import org.example.movies.model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class MovieServiceShould {

    MovieRepository movieRepository;
    MovieService movieService;

    @BeforeEach
    void setUp() {
        movieRepository = Mockito.mock(MovieRepository.class);

        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Genre.ACTION),
                        new Movie(2, "Memento", 113, Genre.THRILLER),
                        new Movie(3, "There's Something About Marty", 119, Genre.COMEDY),
                        new Movie(4, "Super 8", 112, Genre.THRILLER),
                        new Movie(5, "Scream", 111, Genre.HORROR),
                        new Movie(6, "Home Alone", 103, Genre.COMEDY),
                        new Movie(7, "Matrix", 136, Genre.ACTION)
                )
        );
        movieService = new MovieService(movieRepository);
    }

    @Test
    public void returnMoviesByGenre(){
        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);
        assertThat(movies.stream().map(movie -> movie.getId()).collect(Collectors.toList()),is(Arrays.asList(3,6)));
    }

    @Test
    public void  returnMoviesByLength(){
        Collection<Movie> movies = movieService.findMoviesByLength(119);
        assertThat(movies.stream().map(movie -> movie.getId()).collect(Collectors.toList()),is(Arrays.asList(2,3,4,5,6)));
    }

}