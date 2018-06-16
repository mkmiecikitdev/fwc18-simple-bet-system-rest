package eu.bambz.fwc18simplebetsystem.domain.bets;

import eu.bambz.fwc18simplebetsystem.domain.bets.api.BetForm;
import eu.bambz.fwc18simplebetsystem.domain.players.query.PlayersFacade;
import eu.bambz.fwc18simplebetsystem.infrastructure.TimeService;
import io.vavr.control.Option;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BetsFacade {

    private final BetsRepository betsRepository;
    private final TimeService timeService;
    private final PlayersFacade playersFacade;

    public Option<Long> bet(long id, BetForm betForm) {

        Bet bet = betsRepository.findOrThrow(id);
        if(!bet.canUpdate(timeService.now()))
            return Option.none();

        bet.update(betForm, playersFacade.currentPlayer());
        betsRepository.save(bet);
        return Option.of(bet.getId());

    }


}
