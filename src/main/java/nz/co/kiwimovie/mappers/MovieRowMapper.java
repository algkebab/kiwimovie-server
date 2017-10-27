package nz.co.kiwimovie.mappers;

import nz.co.kiwimovie.domains.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class MovieRowMapper implements RowMapper {

    @Override
    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {

        Movie movie = new Movie();
        movie.setId(UUID.fromString(rs.getString("id")));
        movie.setIdCinema(UUID.fromString(rs.getString("id_cinema")));
        movie.setTitle(rs.getString("title"));
        movie.setTime(rs.getTimestamp("time"));
        movie.setDescription(rs.getString("description"));
        movie.setImdb(rs.getString("imdb"));
        movie.setImdbLink(rs.getString("imdb_link"));
        movie.setCreated(rs.getTimestamp("created"));
        movie.setUpdated(rs.getTimestamp("updated"));

        return movie;
    }
}
