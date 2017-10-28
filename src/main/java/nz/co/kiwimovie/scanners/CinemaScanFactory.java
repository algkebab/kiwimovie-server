package nz.co.kiwimovie.scanners;

import nz.co.kiwimovie.dao.CinemaDAO;
import nz.co.kiwimovie.dao.MovieDAO;
import nz.co.kiwimovie.domains.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CinemaScanFactory {

    private CinemaDAO cinemaDAO;
    private MovieDAO movieDAO;

    @Autowired
    public CinemaScanFactory(CinemaDAO cinemaDAO, MovieDAO movieDAO) {
        this.cinemaDAO = cinemaDAO;
        this.movieDAO = movieDAO;
    }

    public CinemaScanner getScanner(Cinema cinema) {
        switch(cinema.getCinemaType()) {
            case EVENT:
                return new EventCinemaScanner(cinemaDAO, movieDAO, cinema);
            default:
                return null;
        }
    }
}
