package eu.bambz.fwc18simplebetsystem.domain.bets.query;

import eu.bambz.fwc18simplebetsystem.domain.bets.api.BetDto;
import eu.bambz.fwc18simplebetsystem.domain.bets.api.PlayerBetDto;
import eu.bambz.fwc18simplebetsystem.domain.bets.api.TeamDto;
import eu.bambz.fwc18simplebetsystem.domain.bets.common.MatchTime;
import eu.bambz.fwc18simplebetsystem.domain.players.api.PlayerType;
import lombok.Builder;
import org.hibernate.annotations.Immutable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Table(name = "bets")
@Immutable
@Entity
@Builder
class BetView {

    @Id
    private long id;

    @Embedded
    private MatchTime time;

    @Embedded
    private TeamScoreView team1View;

    @Embedded
    private TeamScoreView team2View;

    @Embedded
    private PlayerBetsView player1BetView;

    @Embedded
    private PlayerBetsView player2BetView;


    BetDto dto(LocalDateTime now) {
        TeamDto teamDto1 = new TeamDto(team1View.getTeamType().getLabel(), team1View.getScore());
        TeamDto teamDto2 = new TeamDto(team2View.getTeamType().getLabel(), team2View.getScore());

        PlayerBetDto playerBetDto1 = PlayerBetDto.builder()
                .name(PlayerType.M.getLabel())
                .team1Bet(player1BetView.getTeam1Bet())
                .team2Bet(player1BetView.getTeam2Bet())
                .score(player1BetView.calculateScore(teamDto1.getScore(), teamDto2.getScore()).getOrNull())
                .build();

        PlayerBetDto playerBetDto2 = PlayerBetDto.builder()
                .name(PlayerType.T.getLabel())
                .team1Bet(player2BetView.getTeam1Bet())
                .team2Bet(player2BetView.getTeam2Bet())
                .score(player2BetView.calculateScore(teamDto1.getScore(), teamDto2.getScore()).getOrNull())
                .build();

        return BetDto.builder()
                .id(id)
                .time(time.getTime())
                .team1(teamDto1)
                .team2(teamDto2)
                .player1(playerBetDto1)
                .player2(playerBetDto2)
                .canBet(time.canBet(now))
                .build();

    }


}
