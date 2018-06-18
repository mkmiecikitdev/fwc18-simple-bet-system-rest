package eu.bambz.fwc18simplebetsystem.domain.bets;

import eu.bambz.fwc18simplebetsystem.domain.bets.api.BetForm;
import lombok.Value;

import javax.persistence.Embeddable;

@Embeddable
@Value
class PlayerBet {

    private final Integer team1Bet;
    private final Integer team2Bet;

    PlayerBet update(BetForm betForm) {
        return new PlayerBet(betForm.getTeam1Bet(), betForm.getTeam2Bet());
    }

}
