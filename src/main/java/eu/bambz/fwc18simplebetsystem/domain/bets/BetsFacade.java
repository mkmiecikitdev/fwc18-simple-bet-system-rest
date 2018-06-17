package eu.bambz.fwc18simplebetsystem.domain.bets;

import eu.bambz.fwc18simplebetsystem.domain.bets.api.BetForm;
import eu.bambz.fwc18simplebetsystem.domain.bets.api.CannotBet;
import eu.bambz.fwc18simplebetsystem.domain.common.AppError;
import eu.bambz.fwc18simplebetsystem.domain.common.TimeService;
import eu.bambz.fwc18simplebetsystem.domain.players.query.PlayersQueryFacade;
import io.vavr.control.Either;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BetsFacade {

    private final BetsRepository betsRepository;
    private final TimeService timeService;
    private final PlayersQueryFacade playersQueryFacade;

    public Either<AppError, Long> bet(long id, BetForm betForm) {

        return betsRepository.load(id)
                .flatMap(bet -> update(bet, betForm));

    }

    private Either<AppError, Long> update(Bet bet, BetForm betForm) {
        if(!bet.canUpdate(timeService.now()))
            return Either.left(new CannotBet());

        bet.update(betForm, playersQueryFacade.currentPlayer());
        betsRepository.save(bet);
        return Either.right(bet.getId());
    }


}
