package eu.bambz.fwc18simplebetsystem.domain.bets.query;

import lombok.Value;


@Value
class TeamScoreView {

    private final TeamType teamType;
    private final Integer score;

}
