package eu.bambz.fwc18simplebetsystem.domain.players.query;

import eu.bambz.fwc18simplebetsystem.domain.players.api.PlayerType;

public interface CurrentPlayerLoader {

    PlayerType load();

}
