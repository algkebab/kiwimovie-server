package nz.co.kiwimovie.scanners;

import nz.co.kiwimovie.dao.CinemaDAO;
import nz.co.kiwimovie.dao.MovieDAO;
import nz.co.kiwimovie.domains.Cinema;
import nz.co.kiwimovie.services.ImdbService;

import java.io.IOException;
import java.text.ParseException;

public abstract class CinemaScanner {

    protected CinemaDAO cinemaDAO;
    protected MovieDAO movieDAO;
    protected Cinema cinema;
    protected ImdbService imdbService;

    public CinemaScanner(CinemaDAO cinemaDAO, MovieDAO movieDAO, Cinema cinema, ImdbService imdbService) {
        this.cinemaDAO = cinemaDAO;
        this.movieDAO = movieDAO;
        this.cinema = cinema;
        this.imdbService = imdbService;
    }

    public abstract void scan() throws IOException, ParseException;
}
