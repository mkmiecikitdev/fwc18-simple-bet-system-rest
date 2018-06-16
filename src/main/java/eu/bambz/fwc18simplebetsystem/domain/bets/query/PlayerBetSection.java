package eu.bambz.fwc18simplebetsystem.domain.bets.query;


import io.vavr.control.Option;
import lombok.Value;

@Value
class PlayerBetSection {

    private static final int SCORE_MAX = 4;
    private static final int SCORE_STANDARD = 1;
    private static final int SCORE_NONE = 0;

    private enum Result { WIN, LOSE, DRAW }

    private String playerName;
    private Integer team1Bet;
    private Integer team2Bet;


    Option<Integer> calculateScore(Integer team1Score, Integer team2Score) {

        if(team1Score == null || team2Score == null)
            return Option.none();

        int score1 = team1Score;
        int score2 = team2Score;

        if(score1 == team1Bet && score2 == team2Bet)
            return Option.of(SCORE_MAX);

        if(result(score1, score2) == result(team1Bet, team2Bet))
            return Option.of(SCORE_STANDARD);

        return Option.of(SCORE_NONE);
    }

    private Result result(int score1, int score2) {
        if(score1 == score2)
            return Result.DRAW;

        if(score1 > score2)
            return Result.WIN;

        return Result.LOSE;
    }



}
