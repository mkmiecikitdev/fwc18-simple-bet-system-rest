package eu.bambz.fwc18simplebetsystem.domain.players.query;

import eu.bambz.fwc18simplebetsystem.domain.players.api.PlayerType;
import eu.bambz.fwc18simplebetsystem.domain.players.api.PlayersSummaryDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PlayersQueryFacade {

    private final PlayersQueryRepository queryRepository;

    public PlayerType currentPlayer() {
        return null;
    }

    public PlayersSummaryDto playersSummary() {
        return PlayersSummaryDto.builder()
                .player1Name(PlayerType.M.getLabel())
                .player1Score(queryRepository.player1Score())
                .player2Name(PlayerType.T.getLabel())
                .player2Score(queryRepository.player2Score())
                .build();
    }


}
