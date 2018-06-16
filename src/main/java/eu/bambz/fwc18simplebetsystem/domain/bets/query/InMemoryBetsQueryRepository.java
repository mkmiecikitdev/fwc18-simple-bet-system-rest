package eu.bambz.fwc18simplebetsystem.domain.bets.query;

import eu.bambz.fwc18simplebetsystem.domain.bets.api.BetDto;
import eu.bambz.fwc18simplebetsystem.domain.bets.shared.MatchTime;
import io.vavr.Tuple4;
import io.vavr.collection.*;
import io.vavr.control.Option;

import java.time.LocalDateTime;


public class InMemoryBetsQueryRepository implements BetsQueryRepository {

    private final static BetView MATCH_1 = BetView.builder()
            .id(1L)
            .time(new MatchTime(LocalDateTime.of(2018, 6, 14, 18, 0)))
            .teamSection1(new TeamScoreSection(TeamType.RUS, 5))
            .teamSection2(new TeamScoreSection(TeamType.ARA, 0))
            .playerBetSection1(new PlayerBetSection("Michal", 5, 0))
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

    private static Map<Long, BetView> MAP = HashMap.of(1L, MATCH_1, 2L, MATCH_2);

    @Override
    public List<BetView> loadAll() {
        return List.of(MATCH_1, MATCH_2);
    }

    @Override
    public BetView findOrThrow(long id) {
        return MAP.get(id)
                .getOrElseThrow(RuntimeException::new);
    }

    public Option<BetDto> getDto(long id, LocalDateTime now) {
        return MAP
                .get(id)
                .map(b -> b.dto(now));
    }

    public void saveDto(long id, Tuple4<Integer,Integer,Integer,Integer> newBets) {
        BetDto updatedDto = MAP.get(id).get().dto(LocalDateTime.now());

        PlayerBetSection playerBetSection1 = new PlayerBetSection(updatedDto.getPlayer1().getName(), newBets._1(), newBets._2());
        PlayerBetSection playerBetSection2 = new PlayerBetSection(updatedDto.getPlayer2().getName(), newBets._3(), newBets._4());

        BetView betView = BetView.builder()
                .id(id)
                .time(new MatchTime(updatedDto.getTime()))
                .teamSection1(new TeamScoreSection(teamType(updatedDto.getTeam1().getName()), updatedDto.getTeam1().getScore()))
                .teamSection2(new TeamScoreSection(teamType(updatedDto.getTeam2().getName()), updatedDto.getTeam2().getScore()))
                .playerBetSection1(playerBetSection1)
                .playerBetSection2(playerBetSection2)
                .build();

        MAP = MAP.put(id, betView);

    }

    private TeamType teamType(String label) {
        return Array.of(TeamType.values())
                .find(s -> s.getLabel().equalsIgnoreCase(label))
                .get();
    }

}
