package eu.bambz.fwc18simplebetsystem.domain.matches.query;


import eu.bambz.fwc18simplebetsystem.infrastructure.TimeService;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Configuration
class MatchesQueryConfig {

    MatchesQueryFacade matchesQueryFacade() {
        final LocalDateTime REFERENCE_DATE_TIME = LocalDateTime.of(2018, 6, 15, 13, 45);
        final ZoneId defaultZone = ZoneId.systemDefault();
        final Clock FIXED_CLOCK = Clock.fixed(REFERENCE_DATE_TIME.atZone(defaultZone).toInstant(), defaultZone);

        return new MatchesQueryFacade(new InMemoryMatchesQueryRepository(), new TimeService(FIXED_CLOCK));
    }

}
