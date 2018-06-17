package eu.bambz.fwc18simplebetsystem.domain.players.query;

import eu.bambz.fwc18simplebetsystem.domain.players.api.PlayerType;
import eu.bambz.fwc18simplebetsystem.domain.players.api.PlayersSummaryDto;
import io.vavr.Function0;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PlayersQueryFacade {

    private final PlayersQueryRepository queryRepository;
    private final Function0<PlayerType> currentPlayerLoader;

    public PlayerType currentPlayer() {
        return currentPlayerLoader.apply();
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
