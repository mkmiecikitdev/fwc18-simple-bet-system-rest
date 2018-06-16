package eu.bambz.fwc18simplebetsystem.domain.bets.query;

import eu.bambz.fwc18simplebetsystem.domain.bets.api.BetDto;
import eu.bambz.fwc18simplebetsystem.infrastructure.TimeService;
import io.vavr.collection.List;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class BetsQueryFacade {

    private final BetsQueryRepository betsQueryRepository;
    private final TimeService timeService;

    public List<BetDto> list() {
        return betsQueryRepository.loadAll()
                .map(m -> m.dto(timeService.now()));
    }

    public BetDto find(long id) {
        return betsQueryRepository.findOrThrow(id)
                .dto(timeService.now());
    }

}
