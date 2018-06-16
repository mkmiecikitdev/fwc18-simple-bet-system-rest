package eu.bambz.fwc18simplebetsystem.domain.bets.query;

import eu.bambz.fwc18simplebetsystem.domain.bets.api.MatchDto;
import eu.bambz.fwc18simplebetsystem.infrastructure.TimeService;
import io.vavr.collection.List;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class BetsQueryFacade {

    private final InMemoryBetsQueryRepository inMemoryBetsQueryRepository;
    private final TimeService timeService;

    public List<MatchDto> list() {
        return inMemoryBetsQueryRepository.loadAll()
                .map(m -> m.dto(timeService.now()));
    }

}
