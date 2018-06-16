package eu.bambz.fwc18simplebetsystem.domain.bets.api;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PlayerBetDto {

    private String name;
    private Integer team1Bet;
    private Integer team2Bet;
    private Integer score;

}
