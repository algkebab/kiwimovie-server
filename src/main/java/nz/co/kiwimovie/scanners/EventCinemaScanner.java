package nz.co.kiwimovie.scanners;

import nz.co.kiwimovie.dao.CinemaDAO;
import nz.co.kiwimovie.dao.MovieDAO;
import nz.co.kiwimovie.domains.Cinema;
import nz.co.kiwimovie.domains.Movie;
import nz.co.kiwimovie.services.ImdbService;
import org.apache.commons.lang.time.DateUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import us.codecraft.xsoup.Xsoup;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EventCinemaScanner extends CinemaScanner {

    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    public EventCinemaScanner(CinemaDAO cinemaDAO, MovieDAO movieDAO, Cinema cinema, ImdbService imdbService) {
        super(cinemaDAO, movieDAO, cinema, imdbService);
    }

    @Override
    public void scan() throws IOException, ParseException {
        Date date = DateUtils.addDays(new Date(), 3);
        Document doc = (Document) Jsoup.connect(cinema.getWebsite() + "?date=" + df.format(date));
        Elements moviesEl = Xsoup.compile("//*[contains(@class, 'movie-list-item')]").evaluate(doc).getElements();

        if (moviesEl != null && !moviesEl.isEmpty()) {
            for (Element movieEl : moviesEl) {
                String title = Xsoup.compile("//*[@class='title']").evaluate(movieEl).get();
                Elements dates = Xsoup.compile("//a[@class='session-btn']").evaluate(movieEl).getElements();

                Movie movie = imdbService.getMovieMetadata(title);
                movie.setIdCinema(cinema.getId());
                movie.setId(UUID.randomUUID());
                movie.setCreated(new Date());
                movie.setUpdated(new Date());

                SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                timeFormat.setTimeZone(TimeZone.getTimeZone("NZST"));

                List<Movie> movies = new ArrayList<>();
                if (dates != null && !dates.isEmpty()) {
                    for (Element dateEl : dates) {
                        String timeStr = dateEl.attr("data-time");
                        Date time = timeFormat.parse(timeStr);
                        Movie newMovie = movie.copy();
                        newMovie.setTime(time);
                        movies.add(newMovie);
                    }
                }

            }
        }
    }
}
