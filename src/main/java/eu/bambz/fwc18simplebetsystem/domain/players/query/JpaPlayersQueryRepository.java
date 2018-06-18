package eu.bambz.fwc18simplebetsystem.domain.players.query;

import eu.bambz.fwc18simplebetsystem.domain.players.api.PlayerType;
import org.springframework.data.jpa.repository.JpaRepository;

interface JpaPlayersQueryRepository extends PlayersQueryRepository, JpaRepository<PlayerScoreView, PlayerType> {

    default int player1Score() {
        return 0;
    }

    default int player2Score() {
        return 0;
    }

}
