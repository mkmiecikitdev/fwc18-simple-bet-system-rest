package eu.bambz.fwc18simplebetsystem.domain.bets.query;

import lombok.Value;


@Value
class TeamScoreSection {

    private final TeamType teamType;
    private final Integer score;

}
