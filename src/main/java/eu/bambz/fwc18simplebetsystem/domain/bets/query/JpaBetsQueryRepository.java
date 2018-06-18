package eu.bambz.fwc18simplebetsystem.domain.bets.query;

import eu.bambz.fwc18simplebetsystem.domain.bets.api.BetNotFound;
import eu.bambz.fwc18simplebetsystem.domain.common.AppError;
import io.vavr.collection.List;
import io.vavr.control.Either;
import io.vavr.control.Option;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

interface JpaBetsQueryRepository extends BetsQueryRepository, JpaRepository<BetView, Long> {

    default List<BetView> loadAll() {
        return List.ofAll(findAll(new Sort(Sort.Direction.ASC, "timeTime")));
    }

    default Either<AppError, BetView> load(long id) {
        return Option.ofOptional(findById(id))
                .toEither(new BetNotFound(id));
    }

}
