package eu.bambz.fwc18simplebetsystem.domain.bets.query;

import eu.bambz.fwc18simplebetsystem.domain.bets.api.BetDto;
import eu.bambz.fwc18simplebetsystem.domain.common.AppError;
import eu.bambz.fwc18simplebetsystem.domain.common.TimeService;
import io.vavr.collection.List;
import io.vavr.control.Either;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class BetsQueryFacade {

    private final BetsQueryRepository betsQueryRepository;
    private final TimeService timeService;

    public List<BetDto> list() {
        return betsQueryRepository.loadAll()
                .map(m -> m.dto(timeService.now()));
    }

    public Either<AppError, BetDto> find(long id) {
        return betsQueryRepository.load(id)
                .map(bet -> bet.dto(timeService.now()));
    }

}
