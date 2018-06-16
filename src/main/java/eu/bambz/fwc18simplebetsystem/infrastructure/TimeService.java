package eu.bambz.fwc18simplebetsystem.infrastructure;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TimeService {

    private final Clock clock;

    public static TimeService defaultTimeService() {
        return new TimeService(Clock.systemDefaultZone());
    }

    public static TimeService testTimeService() {
        final LocalDateTime REFERENCE_DATE_TIME = LocalDateTime.of(2018, 6, 15, 13, 45);
        final ZoneId defaultZone = ZoneId.systemDefault();
        final Clock FIXED_CLOCK = Clock.fixed(REFERENCE_DATE_TIME.atZone(defaultZone).toInstant(), defaultZone);

        return new TimeService(FIXED_CLOCK);
    }

    public LocalDateTime now() {
        return LocalDateTime.now(clock);
    }

}
