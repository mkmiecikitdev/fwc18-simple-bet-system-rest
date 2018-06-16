package eu.bambz.fwc18simplebetsystem.domain.players.query;

import org.springframework.context.annotation.Configuration;

@Configuration
public class PlayersQueryConfig {

    public PlayersQueryFacade playersQueryFacade() {
        return new PlayersQueryFacade(new InMemoryPlayersQueryRepository());
    }

}
