package eu.bambz.fwc18simplebetsystem.domain.matches.query;

import eu.bambz.fwc18simplebetsystem.domain.matches.api.MatchDto;
import eu.bambz.fwc18simplebetsystem.infrastructure.TimeService;
import io.vavr.collection.List;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class MatchesQueryFacade {

    private final InMemoryMatchesQueryRepository inMemoryMatchesQueryRepository;
    private final TimeService timeService;

    public List<MatchDto> list() {
        return inMemoryMatchesQueryRepository.loadAll()
                .map(m -> m.dto(timeService.now()));
    }

}
