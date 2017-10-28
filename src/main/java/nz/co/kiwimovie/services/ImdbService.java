package nz.co.kiwimovie.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import nz.co.kiwimovie.domains.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

@Service
public class ImdbService {

    @Value("${imdb.api.key}")
    private String imdbApiKey;

    @Autowired ObjectMapper mapper;

    private RestTemplate restTemplate = new RestTemplate();

    public Movie getMovieMetadata(String name) throws IOException {
        String json = restTemplate.getForObject(URLEncoder.encode("http://www.omdbapi.com/?apiKey="+imdbApiKey+"&t=" + name, "UTF-8"), String.class);
        Map result = mapper.readValue(json, Map.class);

        Movie movie = new Movie();
        movie.setTitle((String) result.get("Title"));
        movie.setPlot((String) result.get("Plot"));
        movie.setPoster((String) result.get("Poster"));
        movie.setImdb((String)result.get("imdbRating"));
        movie.setImdbLink("http://www.imdb.com/title/" + result.get("imdbID"));

        return movie;
    }


}
