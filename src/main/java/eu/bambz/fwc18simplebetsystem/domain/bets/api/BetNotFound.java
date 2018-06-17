package eu.bambz.fwc18simplebetsystem.domain.bets.api;

import eu.bambz.fwc18simplebetsystem.domain.common.AppError;
import eu.bambz.fwc18simplebetsystem.domain.common.ErrorCode;
import eu.bambz.fwc18simplebetsystem.domain.common.ErrorObject;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BetNotFound implements AppError {

    private final long id;

    @Override
    public ErrorObject getError() {
        return new ErrorObject(ErrorCode.BET_NOT_FOUND, "Bet with id: " + id + " not found");
    }
}
