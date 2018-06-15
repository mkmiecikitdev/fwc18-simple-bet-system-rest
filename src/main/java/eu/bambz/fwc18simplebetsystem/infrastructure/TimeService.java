package eu.bambz.fwc18simplebetsystem.infrastructure;


import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.LocalDateTime;

@AllArgsConstructor
public class TimeService {

    private final Clock clock;

    public TimeService() {
        this.clock = Clock.systemDefaultZone();
    }

    public LocalDateTime now() {
        return LocalDateTime.now(clock);
    }

}
