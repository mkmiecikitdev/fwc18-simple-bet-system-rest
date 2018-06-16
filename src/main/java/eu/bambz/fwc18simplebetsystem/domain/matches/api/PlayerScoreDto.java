package eu.bambz.fwc18simplebetsystem.domain.matches.api;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
public class PlayerScoreDto {

    private String name;
    private Integer team1Bet;
    private Integer team2Bet;
    private Integer score;

}
