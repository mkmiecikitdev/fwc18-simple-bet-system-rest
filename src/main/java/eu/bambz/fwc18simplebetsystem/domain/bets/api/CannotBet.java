package eu.bambz.fwc18simplebetsystem.domain.bets.api;

import eu.bambz.fwc18simplebetsystem.domain.common.AppError;
import eu.bambz.fwc18simplebetsystem.domain.common.ErrorCode;
import eu.bambz.fwc18simplebetsystem.domain.common.ErrorObject;

public class CannotBet implements AppError {
    @Override
    public ErrorObject getError() {
        return new ErrorObject(ErrorCode.CANNOT_BET, "Bet is just done");
    }
}
