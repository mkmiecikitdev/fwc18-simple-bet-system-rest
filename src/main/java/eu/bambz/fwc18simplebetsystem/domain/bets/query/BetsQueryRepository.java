package eu.bambz.fwc18simplebetsystem.domain.bets.query;

import io.vavr.collection.List;

public interface BetsQueryRepository {

    List<BetView> loadAll();

    BetView findOrThrow(long id);
}
