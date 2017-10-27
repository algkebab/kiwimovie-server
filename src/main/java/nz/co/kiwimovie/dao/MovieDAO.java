package nz.co.kiwimovie.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@Repository
public class MovieDAO {

    private JdbcTemplate template;

    @Autowired
    public MovieDAO(DataSource dataSource) throws IOException {
        this.template = new JdbcTemplate(dataSource);
    }

    public int insert(String title, String description, UUID idCinema, String imdb, String imdbLink, Date time) {
        return template.update("INSERT INTO movies VALUES (?,?,?,?,?,?,?,?,?)", new Object[] {
                new Date(),
                description,
                UUID.randomUUID(),
                idCinema,
                imdb,
                imdbLink,
                time,
                title,
                new Date()
        });
    }
}
