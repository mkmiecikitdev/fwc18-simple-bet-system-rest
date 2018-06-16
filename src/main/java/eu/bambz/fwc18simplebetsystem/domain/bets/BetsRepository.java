package eu.bambz.fwc18simplebetsystem.domain.bets;

public interface BetsRepository {

    Bet findOrThrow(long id);

    void save(Bet bet);

}
