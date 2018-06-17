package eu.bambz.fwc18simplebetsystem.domain.bets;

import eu.bambz.fwc18simplebetsystem.domain.bets.api.BetDto;
import eu.bambz.fwc18simplebetsystem.domain.bets.api.BetNotFound;
import eu.bambz.fwc18simplebetsystem.domain.bets.query.InMemoryBetsQueryRepository;
import eu.bambz.fwc18simplebetsystem.domain.bets.common.MatchTime;
import eu.bambz.fwc18simplebetsystem.domain.common.AppError;
import eu.bambz.fwc18simplebetsystem.domain.common.TimeService;
import io.vavr.control.Either;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InMemoryBetsRepository implements BetsRepository {

    private final InMemoryBetsQueryRepository queryRepository;
    private final TimeService timeService;

    @Override
    public Either<AppError, Bet> load(long id) {
        return queryRepository.getDto(id, timeService.now())
                .map(this::convert)
                .toEither(new BetNotFound(id));

    }

    private Bet convert(BetDto dto) {
        return Bet.builder()
                .id(dto.getId())
                .player1Bet(new PlayerBet(dto.getPlayer1().getTeam1Bet(), dto.getPlayer1().getTeam2Bet()))
                .player2Bet(new PlayerBet(dto.getPlayer2().getTeam1Bet(), dto.getPlayer2().getTeam2Bet()))
                .time(new MatchTime(dto.getTime()))
                .build();
    }

    @Override
    public void save(Bet bet) {
        queryRepository.saveDto(bet.getId(), bet.betScores());
    }

}
