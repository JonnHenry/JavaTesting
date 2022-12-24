package org.example.movies.data;

import org.example.movies.model.Genre;
import org.example.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.util.Collection;
import java.util.Objects;

public class MovieRepositoryImpl implements MovieRepository {

    private JdbcTemplate jdbcTemplate;

    public MovieRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        Object[] args = {id};
        return jdbcTemplate.query("select * from movies where id=?",args,movieMapper).get(0);

    }

    @Override
    public Collection<Movie> findAll() {

        return jdbcTemplate.query("select * from movies",movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {
        jdbcTemplate.update("INSERT INTO movies(name, minutes, genre) VALUES(?, ?, ?)",movie.getName(),
                movie.getMinutes(),
                movie.getGenre().toString());
    }

    @Override
    public Movie findByName(String movieName) {
        Object[] args = {movieName};
        return jdbcTemplate.query("select * from movies where name=?",args,movieMapper).get(0);
    }

    private static RowMapper<Movie> movieMapper = (ResultSet resultSet, int i) -> {
        return new Movie(
            resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getInt("minutes"),
            Genre.valueOf(resultSet.getString("genre"))
        );
    };
}
