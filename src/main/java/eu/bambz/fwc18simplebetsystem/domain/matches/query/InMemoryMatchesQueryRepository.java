package eu.bambz.fwc18simplebetsystem.domain.matches.query;

import io.vavr.collection.HashMap;
import io.vavr.collection.List;
import io.vavr.collection.Map;

import java.time.LocalDateTime;


class InMemoryMatchesQueryRepository  {

    private final static MatchView MATCH_1 = MatchView.builder()
            .id(1L)
            .time(LocalDateTime.of(2018, 6, 14, 18, 0))
            .teamSection1(new TeamMatchSection(TeamType.RUS, 5))
            .teamSection2(new TeamMatchSection(TeamType.ARA, 0))
            .build();

    private final static MatchView MATCH_2 = MatchView.builder()
            .id(2L)
            .time(LocalDateTime.of(2018, 6, 15, 14, 0))
            .teamSection1(new TeamMatchSection(TeamType.EGI, null))
            .teamSection2(new TeamMatchSection(TeamType.URU, null))
            .build();

    private final static Map<Long, MatchView> MAP = HashMap.of(1L, MATCH_1, 2L, MATCH_2);


    List<MatchView> loadAll() {
        return List.of(MATCH_1, MATCH_2);
    }
}
