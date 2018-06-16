package eu.bambz.fwc18simplebetsystem.domain.bets.query;


import eu.bambz.fwc18simplebetsystem.infrastructure.TimeService;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Configuration
class BetsQueryConfig {

    BetsQueryFacade matchesQueryFacade() {
        final LocalDateTime REFERENCE_DATE_TIME = LocalDateTime.of(2018, 6, 15, 13, 45);
        final ZoneId defaultZone = ZoneId.systemDefault();
        final Clock FIXED_CLOCK = Clock.fixed(REFERENCE_DATE_TIME.atZone(defaultZone).toInstant(), defaultZone);

        return new BetsQueryFacade(new InMemoryBetsQueryRepository(), new TimeService(FIXED_CLOCK));
    }

}
