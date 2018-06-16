package eu.bambz.fwc18simplebetsystem.domain.bets.query;


import eu.bambz.fwc18simplebetsystem.infrastructure.TimeService;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BetsQueryConfig {

    public BetsQueryFacade betsQueryFacade() {
        return new BetsQueryFacade(new InMemoryBetsQueryRepository(), TimeService.testTimeService());
    }

}
