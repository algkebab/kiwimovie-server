package nz.co.kiwimovie.mappers;

import nz.co.kiwimovie.domains.Cinema;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class CinemaRowMapper implements RowMapper {

    @Override
    public Cinema mapRow(ResultSet rs, int rowNum) throws SQLException {

        Cinema cinema = new Cinema();
        cinema.setId(UUID.fromString(rs.getString("id")));
        cinema.setName(rs.getString("name"));
        cinema.setAddress(rs.getString("address"));
        cinema.setLatitude(Double.parseDouble(rs.getString("latitude")));
        cinema.setLongtitude(Double.parseDouble(rs.getString("longtitude")));
        cinema.setStatus(rs.getString("status"));
        cinema.setCreated(rs.getTimestamp("created"));
        cinema.setUpdated(rs.getTimestamp("updated"));

        return cinema;
    }
}
