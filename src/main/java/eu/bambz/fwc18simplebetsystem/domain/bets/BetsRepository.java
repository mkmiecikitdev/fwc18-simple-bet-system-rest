package eu.bambz.fwc18simplebetsystem.domain.bets;

import eu.bambz.fwc18simplebetsystem.domain.common.AppError;
import io.vavr.control.Either;

interface BetsRepository {

    Either<AppError, Bet> load(long id);

    void update(Bet bet);

}
