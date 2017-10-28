package nz.co.kiwimovie.domains;

import java.util.Date;
import java.util.UUID;

public class Movie {

    private UUID id;
    private UUID idCinema;
    private String title;
    private Date time;
    private String imdb;
    private String imdbLink;
    private Date created;
    private Date updated;
    private String plot;
    private String poster;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdCinema() {
        return idCinema;
    }

    public void setIdCinema(UUID idCinema) {
        this.idCinema = idCinema;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    public String getImdbLink() {
        return imdbLink;
    }

    public void setImdbLink(String imdbLink) {
        this.imdbLink = imdbLink;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Movie copy() {
        Movie newMovie = new Movie();
        newMovie.setId(id);
        newMovie.setIdCinema(idCinema);
        newMovie.setTitle(title);
        newMovie.setTime(time);
        newMovie.setImdb(imdb);
        newMovie.setImdbLink(imdbLink);
        newMovie.setCreated(created);
        newMovie.setUpdated(updated);
        newMovie.setPlot(plot);
        newMovie.setPoster(poster);

        return newMovie;
    }
}
