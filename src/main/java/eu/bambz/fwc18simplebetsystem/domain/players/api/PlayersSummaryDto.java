package eu.bambz.fwc18simplebetsystem.domain.players.api;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PlayersSummaryDto {

    private String player1Name;
    private String player2Name;
    private int player1Score;
    private int player2Score;

}
