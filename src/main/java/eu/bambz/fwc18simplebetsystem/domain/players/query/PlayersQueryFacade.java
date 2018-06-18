package eu.bambz.fwc18simplebetsystem.domain.players.query;

import eu.bambz.fwc18simplebetsystem.domain.players.api.PlayerType;
import io.vavr.Function0;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PlayersQueryFacade {

    private final Function0<PlayerType> currentPlayerLoader;

    public PlayerType currentPlayer() {
        return currentPlayerLoader.apply();
    }

}
