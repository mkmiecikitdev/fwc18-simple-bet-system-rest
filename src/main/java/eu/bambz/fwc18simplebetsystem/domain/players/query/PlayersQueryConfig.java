package eu.bambz.fwc18simplebetsystem.domain.players.query;

import eu.bambz.fwc18simplebetsystem.domain.players.api.PlayerType;
import io.vavr.Function0;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlayersQueryConfig {

    public PlayersQueryFacade playersQueryFacade() {
        return new PlayersQueryFacade(new InMemoryPlayersQueryRepository(), () -> PlayerType.M);
    }

    @Bean
    public PlayersQueryFacade playersQueryFacade(JpaPlayersQueryRepository jpaPlayersQueryRepository, Function0<PlayerType> currentPlayerProvider) {
        return new PlayersQueryFacade(jpaPlayersQueryRepository, currentPlayerProvider);
    }

}
