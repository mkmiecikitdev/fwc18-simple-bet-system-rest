package eu.bambz.fwc18simplebetsystem.infrastructure.rest;

import eu.bambz.fwc18simplebetsystem.domain.common.AppError;
import eu.bambz.fwc18simplebetsystem.domain.common.ErrorCode;
import io.vavr.collection.HashMap;
import io.vavr.collection.Map;
import io.vavr.control.Either;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseResolver {

    private final static Map<ErrorCode, HttpStatus> HTTP_STATUS_MAP =
            HashMap.of(
                    ErrorCode.BET_NOT_FOUND, HttpStatus.NOT_FOUND,
                    ErrorCode.CANNOT_BET, HttpStatus.BAD_REQUEST
            );

    public <T> ResponseEntity<Object> resolve(Either<AppError, T> either) {
        return either
                .map(this::createObject)
                .getOrElseGet(this::createError);
    }

    private ResponseEntity<Object> createObject(Object object) {
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    private ResponseEntity<Object> createError(AppError error) {
        return new ResponseEntity<>(error.getError(), HTTP_STATUS_MAP.getOrElse(error.getError().getErrorCode(), HttpStatus.BAD_REQUEST));
    }

}
