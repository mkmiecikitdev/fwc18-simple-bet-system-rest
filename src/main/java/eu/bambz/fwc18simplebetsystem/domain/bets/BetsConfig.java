package eu.bambz.fwc18simplebetsystem.domain.bets;

import eu.bambz.fwc18simplebetsystem.domain.bets.query.InMemoryBetsQueryRepository;
import eu.bambz.fwc18simplebetsystem.domain.players.query.PlayersQueryFacade;
import eu.bambz.fwc18simplebetsystem.infrastructure.TimeService;
import org.springframework.context.annotation.Configuration;

@Configuration
class BetsConfig {

    BetsFacade betsFacade(PlayersQueryFacade playersQueryFacade) {
        TimeService timeService = TimeService.testTimeService();
        return new BetsFacade(
                new InMemoryBetsRepository(new InMemoryBetsQueryRepository(), timeService),
                timeService,
                playersQueryFacade);
    }

}
