package eu.bambz.fwc18simplebetsystem.domain.common;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TimeService {

    private final Clock clock;

    private static final LocalDateTime REFERENCE_DATE_TIME = LocalDateTime.of(2018, 6, 15, 13, 45);
    private static final ZoneId defaultZone = ZoneId.systemDefault();
    private static final Clock FIXED_CLOCK = Clock.fixed(REFERENCE_DATE_TIME.atZone(defaultZone).toInstant(), defaultZone);

    public static TimeService defaultTimeService() {
        return new TimeService(Clock.systemDefaultZone());
    }

    public static TimeService testTimeService() {
        return new TimeService(FIXED_CLOCK);
    }

    public LocalDateTime now() {
        return LocalDateTime.now(clock);
    }

}
