package eu.bambz.fwc18simplebetsystem.domain.bets;

import eu.bambz.fwc18simplebetsystem.domain.bets.api.BetNotFound;
import eu.bambz.fwc18simplebetsystem.domain.common.AppError;
import io.vavr.control.Either;
import io.vavr.control.Option;
import org.springframework.data.jpa.repository.JpaRepository;

interface JpaBetsRepository extends BetsRepository, JpaRepository<Bet, Long> {

    default Either<AppError, Bet> load(long id) {
        return Option.ofOptional(findById(id))
                .toEither(new BetNotFound(id));
    }

    default void update(Bet bet) {
        save(bet);
    }

}
