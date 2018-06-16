package eu.bambz.fwc18simplebetsystem.domain.players.query;

import eu.bambz.fwc18simplebetsystem.domain.players.api.PlayerType;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PlayersFacade {

    public PlayerType currentPlayer() {
        return PlayerType.M;
    }

}
