package eu.bambz.fwc18simplebetsystem.domain.bets.query;

import lombok.Value;


@Value
class TeamScoreSection {

    private TeamType teamType;
    private Integer score;

}
