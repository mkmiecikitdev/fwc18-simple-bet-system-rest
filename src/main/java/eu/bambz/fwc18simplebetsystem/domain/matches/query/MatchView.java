package eu.bambz.fwc18simplebetsystem.domain.matches.query;

import eu.bambz.fwc18simplebetsystem.domain.matches.api.MatchDto;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Builder
class MatchView {

    private long id;
    private LocalDateTime time;

    private TeamMatchSection teamSection1;
    private TeamMatchSection teamSection2;


    MatchDto dto(LocalDateTime now) {
        return MatchDto.builder()
                .id(id)
                .time(time)
                .team1(teamSection1.dto())
                .team2(teamSection2.dto())
                .canBet(canBet(now))
                .build();

    }

    private boolean canBet(LocalDateTime now) {
        return now.plusMinutes(10).isBefore(time);
    }


}
