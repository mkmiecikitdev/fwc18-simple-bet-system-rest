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
    @AttributeOverrides({
            @AttributeOverride(name="time",
                    column=@Column(name="match_time")),
    })
    private MatchTime time;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="team1Bet",
                    column=@Column(name="team_1_bet_player1")),
            @AttributeOverride(name="team2Bet",
                    column=@Column(name="team_2_bet_player1")),
    })
    private PlayerBet player1Bet;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="team1Bet",
                    column=@Column(name="team_1_bet_player2")),
            @AttributeOverride(name="team2Bet",
                    column=@Column(name="team_2_bet_player2")),
    })
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
