package nz.co.kiwimovie;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CinemaScanScheduler {

    @Scheduled
    public void scan() {

    }

}
