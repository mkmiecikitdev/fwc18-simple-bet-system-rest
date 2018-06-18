package eu.bambz.fwc18simplebetsystem.domain.bets;


import eu.bambz.fwc18simplebetsystem.domain.bets.api.BetForm;
import eu.bambz.fwc18simplebetsystem.domain.bets.common.MatchTime;
import eu.bambz.fwc18simplebetsystem.domain.players.api.PlayerType;
import io.vavr.Tuple;
import io.vavr.Tuple4;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "bets")
@Entity
@Builder
class Bet {

    @Id
    @Getter
    private long id;

    @Embedded
    private MatchTime time;

    @Embedded
    private PlayerBet player1Bet;

    @Embedded
    private PlayerBet player2Bet;

    boolean canUpdate(LocalDateTime now) {
        return time.canBet(now);
    }

    void update(BetForm betForm, PlayerType playerType) {
        if(playerType == PlayerType.M) {
            player1Bet = player1Bet.update(betForm);
        } else {
            player2Bet = player2Bet.update(betForm);
        }
    }

    Tuple4<Integer, Integer, Integer, Integer> betScores() {
        return Tuple.of(player1Bet.getTeam1Bet(), player1Bet.getTeam2Bet(), player2Bet.getTeam1Bet(), player2Bet.getTeam2Bet());
    }

}
