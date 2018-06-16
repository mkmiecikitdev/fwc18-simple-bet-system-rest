package eu.bambz.fwc18simplebetsystem.domain.matches.query;

import eu.bambz.fwc18simplebetsystem.domain.matches.api.MatchDto;
import eu.bambz.fwc18simplebetsystem.domain.matches.api.PlayerScoreDto;
import eu.bambz.fwc18simplebetsystem.domain.matches.api.TeamDto;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
class MatchView {

    private long id;
    private MatchTime time;

    private TeamMatchSection teamSection1;
    private TeamMatchSection teamSection2;

    private BetMatchSection betMatchSection1;
    private BetMatchSection betMatchSection2;


    MatchDto dto(LocalDateTime now) {
        TeamDto teamDto1 = new TeamDto(teamSection1.getTeamType().getLabel(), teamSection1.getScore());
        TeamDto teamDto2 = new TeamDto(teamSection2.getTeamType().getLabel(), teamSection2.getScore());

        PlayerScoreDto playerScoreDto1 = PlayerScoreDto.builder()
                .name(betMatchSection1.getPlayerName())
                .team1Bet(betMatchSection1.getTeam1Bet())
                .team2Bet(betMatchSection1.getTeam2Bet())
                .score(betMatchSection1.calculateScore(teamDto1.getScore(), teamDto2.getScore()).getOrNull())
                .build();

        PlayerScoreDto playerScoreDto2 = PlayerScoreDto.builder()
                .name(betMatchSection2.getPlayerName())
                .team1Bet(betMatchSection2.getTeam1Bet())
                .team2Bet(betMatchSection2.getTeam2Bet())
                .score(betMatchSection2.calculateScore(teamDto1.getScore(), teamDto2.getScore()).getOrNull())
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
