package eu.bambz.fwc18simplebetsystem.domain.bets.api;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BetForm {

    @NotNull(message = "bet cannot be null")
    @Min(value = 0, message = "Must be 0 or more")
    private Integer team1Bet;

    @Min(value = 0, message = "Must be 0 or more")
    @NotNull(message = "bet cannot be null")
    private Integer team2Bet;

}
