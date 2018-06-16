package eu.bambz.fwc18simplebetsystem.domain.bets;

import eu.bambz.fwc18simplebetsystem.domain.bets.query.InMemoryBetsQueryRepository;
import eu.bambz.fwc18simplebetsystem.domain.players.query.PlayersFacade;
import eu.bambz.fwc18simplebetsystem.infrastructure.TimeService;
import org.springframework.context.annotation.Configuration;

@Configuration
class BetsConfig {

    BetsFacade betsFacade(PlayersFacade playersFacade) {
        TimeService timeService = TimeService.testTimeService();
        return new BetsFacade(
                new InMemoryBetsRepository(new InMemoryBetsQueryRepository(), timeService),
                timeService,
                playersFacade);
    }

}
