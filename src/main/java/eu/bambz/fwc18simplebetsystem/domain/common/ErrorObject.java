package eu.bambz.fwc18simplebetsystem.domain.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorObject {

    private final ErrorCode errorCode;
    private final String message;

}
