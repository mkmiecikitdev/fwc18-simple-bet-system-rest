package eu.bambz.fwc18simplebetsystem.domain.bets.query;

import eu.bambz.fwc18simplebetsystem.domain.common.AppError;
import io.vavr.collection.List;
import io.vavr.control.Either;

public interface BetsQueryRepository {

    List<BetView> loadAll();

    Either<AppError, BetView> load(long id);
}
