package eu.bambz.fwc18simplebetsystem.domain.bets.query;

import eu.bambz.fwc18simplebetsystem.domain.bets.api.MatchDto;
import eu.bambz.fwc18simplebetsystem.domain.bets.api.PlayerScoreDto;
import eu.bambz.fwc18simplebetsystem.domain.bets.api.TeamDto;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
class BetView {

    private long id;
    private MatchTime time;

    private TeamScoreSection teamSection1;
    private TeamScoreSection teamSection2;

    private PlayerBetSection playerBetSection1;
    private PlayerBetSection playerBetSection2;


    MatchDto dto(LocalDateTime now) {
        TeamDto teamDto1 = new TeamDto(teamSection1.getTeamType().getLabel(), teamSection1.getScore());
        TeamDto teamDto2 = new TeamDto(teamSection2.getTeamType().getLabel(), teamSection2.getScore());

        PlayerScoreDto playerScoreDto1 = PlayerScoreDto.builder()
                .name(playerBetSection1.getPlayerName())
                .team1Bet(playerBetSection1.getTeam1Bet())
                .team2Bet(playerBetSection1.getTeam2Bet())
                .score(playerBetSection1.calculateScore(teamDto1.getScore(), teamDto2.getScore()).getOrNull())
                .build();

        PlayerScoreDto playerScoreDto2 = PlayerScoreDto.builder()
                .name(playerBetSection2.getPlayerName())
                .team1Bet(playerBetSection2.getTeam1Bet())
                .team2Bet(playerBetSection2.getTeam2Bet())
                .score(playerBetSection2.calculateScore(teamDto1.getScore(), teamDto2.getScore()).getOrNull())
                .build();

        return MatchDto.builder()
                .id(id)
                .time(time.getTime())
                .team1(teamDto1)
                .team2(teamDto2)
                .player1(playerScoreDto1)
                .player2(playerScoreDto2)
                .canBet(time.canBet(now))
                .build();

    }


}
