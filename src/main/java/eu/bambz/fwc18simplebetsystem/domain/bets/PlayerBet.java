package eu.bambz.fwc18simplebetsystem.domain.bets;

import eu.bambz.fwc18simplebetsystem.domain.bets.api.BetForm;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.security.core.parameters.P;

import javax.persistence.Embeddable;

@Embeddable
@Value
class PlayerBet {

    private final Integer team1Bet;
    private final Integer team2Bet;

    static PlayerBet of(BetForm betForm) {
        return new PlayerBet(betForm.getTeam1Bet(), betForm.getTeam2Bet());
    }

    PlayerBet update(BetForm betForm) {
        return new PlayerBet(betForm.getTeam1Bet(), betForm.getTeam2Bet());
    }

}
