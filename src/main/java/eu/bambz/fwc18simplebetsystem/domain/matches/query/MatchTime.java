package eu.bambz.fwc18simplebetsystem.domain.matches.query;


import lombok.Value;

import java.time.LocalDateTime;

@Value
class MatchTime {

    private static final int TIME_OFFSET = 10;

    private LocalDateTime time;

    boolean canBet(LocalDateTime now) {
        return now.plusMinutes(TIME_OFFSET).isBefore(time);
    }

}
