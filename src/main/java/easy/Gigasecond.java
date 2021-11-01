package easy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Gigasecond {
    private final LocalDateTime localDateTime;
    public Gigasecond(LocalDate moment) {
        localDateTime = moment.atStartOfDay();
    }

    public Gigasecond(LocalDateTime moment) {
        localDateTime = moment;
    }

    public LocalDateTime getDateTime() {
        return localDateTime.plus(1000000000, ChronoUnit.SECONDS);
    }
}
