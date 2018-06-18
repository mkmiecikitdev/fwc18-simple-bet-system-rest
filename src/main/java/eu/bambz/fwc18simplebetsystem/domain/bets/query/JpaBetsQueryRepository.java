package eu.bambz.fwc18simplebetsystem.domain.bets.query;

import eu.bambz.fwc18simplebetsystem.domain.bets.api.BetNotFound;
import eu.bambz.fwc18simplebetsystem.domain.common.AppError;
import io.vavr.collection.List;
import io.vavr.control.Either;
import io.vavr.control.Option;
import org.springframework.data.jpa.repository.JpaRepository;

interface JpaBetsQueryRepository extends BetsQueryRepository, JpaRepository<BetView, Long> {

    default List<BetView> loadAll() {
        return List.ofAll(findAllOrderByTimeTime());
    }

    default Either<AppError, BetView> load(long id) {
        return Option.ofOptional(findById(id))
                .toEither(new BetNotFound(id));
    }

    java.util.List<BetView> findAllOrderByTimeTime();

}
