package eu.bambz.fwc18simplebetsystem.domain.matches.api;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class MatchDto {

    private long id;
    private LocalDateTime time;
    private TeamDto team1;
    private TeamDto team2;
    private PlayerScoreDto player1;
    private PlayerScoreDto player2;
    private boolean canBet;

}
