package eu.bambz.fwc18simplebetsystem.domain.bets.query;

import io.vavr.collection.HashMap;
import io.vavr.collection.List;
import io.vavr.collection.Map;

import java.time.LocalDateTime;


class InMemoryBetsQueryRepository {

    private final static BetView MATCH_1 = BetView.builder()
            .id(1L)
            .time(new MatchTime(LocalDateTime.of(2018, 6, 14, 18, 0)))
            .teamSection1(new TeamScoreSection(TeamType.RUS, 5))
            .teamSection2(new TeamScoreSection(TeamType.ARA, 0))
            .playerBetSection1(new PlayerBetSection("Michal", 3, 1))
            .playerBetSection2(new PlayerBetSection("Tomek", 2, 1))
            .build();

    private final static BetView MATCH_2 = BetView.builder()
            .id(2L)
            .time(new MatchTime(LocalDateTime.of(2018, 6, 15, 14, 0)))
            .teamSection1(new TeamScoreSection(TeamType.EGI, null))
            .teamSection2(new TeamScoreSection(TeamType.URU, null))
            .playerBetSection1(new PlayerBetSection("Michal", 2, 0))
            .playerBetSection2(new PlayerBetSection("Tomek", 0, 1))
            .build();

    private final static Map<Long, BetView> MAP = HashMap.of(1L, MATCH_1, 2L, MATCH_2);


    List<BetView> loadAll() {
        return List.of(MATCH_1, MATCH_2);
    }
}
