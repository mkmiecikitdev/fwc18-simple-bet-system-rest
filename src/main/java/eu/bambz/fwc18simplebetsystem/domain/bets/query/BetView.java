package eu.bambz.fwc18simplebetsystem.domain.bets.query;

import eu.bambz.fwc18simplebetsystem.domain.bets.api.BetDto;
import eu.bambz.fwc18simplebetsystem.domain.bets.api.PlayerBetDto;
import eu.bambz.fwc18simplebetsystem.domain.bets.api.TeamDto;
import eu.bambz.fwc18simplebetsystem.domain.bets.common.MatchTime;
import eu.bambz.fwc18simplebetsystem.domain.players.api.PlayerType;
import io.vavr.control.Option;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;


@Table(name = "bets")
@Immutable
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
class BetView {

    @Id
    private long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="time",
                    column=@Column(name="match_time")),
    })
    private MatchTime time;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="teamType",
                    column=@Column(name="team_1_type")),
            @AttributeOverride(name="score",
                    column=@Column(name="team_1_score")),
    })
    private TeamScoreView team1View;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="teamType",
                    column=@Column(name="team_2_type")),
            @AttributeOverride(name="score",
                    column=@Column(name="team_2_score")),
    })
    private TeamScoreView team2View;

    @Nullable
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="team1Bet",
                    column=@Column(name="team_1_bet_player1")),
            @AttributeOverride(name="team2Bet",
                    column=@Column(name="team_2_bet_player1")),
    })
    private PlayerBetsView player1BetView;

    @Nullable
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="team1Bet",
                    column=@Column(name="team_1_bet_player2")),
            @AttributeOverride(name="team2Bet",
                    column=@Column(name="team_2_bet_player2")),
    })
    private PlayerBetsView player2BetView;


    BetDto dto(LocalDateTime now) {
        TeamDto teamDto1 = new TeamDto(team1View.getTeamType().getLabel(), team1View.getScore());
        TeamDto teamDto2 = new TeamDto(team2View.getTeamType().getLabel(), team2View.getScore());

        Option<PlayerBetsView> player1bet = Option.of(player1BetView);
        Option<PlayerBetsView> player2bet = Option.of(player2BetView);

        PlayerBetDto playerBetDto1 = PlayerBetDto.builder()
                .name(PlayerType.M.getLabel())
                .team1Bet(player1bet.map(PlayerBetsView::getTeam1Bet).getOrNull())
                .team2Bet(player1bet.map(PlayerBetsView::getTeam2Bet).getOrNull())
                .score(player1bet.flatMap( p -> p.calculateScore(teamDto1.getScore(), teamDto2.getScore())).getOrNull())
                .build();

        PlayerBetDto playerBetDto2 = PlayerBetDto.builder()
                .name(PlayerType.T.getLabel())
                .team1Bet(player2bet.map(PlayerBetsView::getTeam1Bet).getOrNull())
                .team2Bet(player2bet.map(PlayerBetsView::getTeam2Bet).getOrNull())
                .score(player2bet.flatMap( p -> p.calculateScore(teamDto1.getScore(), teamDto2.getScore())).getOrNull())
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
