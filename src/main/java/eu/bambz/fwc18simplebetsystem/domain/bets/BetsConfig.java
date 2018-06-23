package eu.bambz.fwc18simplebetsystem.domain.bets;

import eu.bambz.fwc18simplebetsystem.domain.bets.query.BetsQueryConfig;
import eu.bambz.fwc18simplebetsystem.domain.bets.query.BetsQueryFacade;
import eu.bambz.fwc18simplebetsystem.domain.bets.query.InMemoryBetsQueryRepository;
import eu.bambz.fwc18simplebetsystem.domain.players.query.PlayersQueryFacade;
import eu.bambz.fwc18simplebetsystem.domain.common.TimeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class BetsConfig {

    BetsFacade betsFacade(PlayersQueryFacade playersQueryFacade) {
        TimeService timeService = TimeService.testTimeService();
        return new BetsFacade(
                new BetsQueryConfig().betsQueryFacade(),
                new InMemoryBetsRepository(new InMemoryBetsQueryRepository(), timeService),
                timeService,
                playersQueryFacade);
    }

    @Bean
    BetsFacade betsFacade(BetsQueryFacade betsQueryFacade, PlayersQueryFacade playersQueryFacade, JpaBetsRepository jpaBetsRepository) {
        return new BetsFacade(
                betsQueryFacade,
                jpaBetsRepository,
                TimeService.defaultTimeService(),
                playersQueryFacade);
    }

}
