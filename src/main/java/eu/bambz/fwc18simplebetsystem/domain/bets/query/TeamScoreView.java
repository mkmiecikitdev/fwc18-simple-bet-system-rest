package eu.bambz.fwc18simplebetsystem.domain.bets.query;

import lombok.Value;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Embeddable
@Value
class TeamScoreView {

    @Enumerated(EnumType.STRING)
    private final TeamType teamType;

    private final Integer score;

}
