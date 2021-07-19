package net.causw.domain.exceptions;

import lombok.Getter;

@Getter
public enum ErrorCode {
    ROW_DOES_NOT_EXIST(4000),
    ROW_ALREADY_EXIST(4001),
    NULL_PARAMETER(4002),
    INVALID_PARAMETER(4003),

    INVALID_SIGNIN(4100),
    BLOCKED_USER(4101),
    INACTIVE_USER(4102),
    EXPIRED_JWT(4103),
    API_NOT_ACCESSIBLE(4104),

    INTERNAL_SERVER(5000);

    private int code;

    ErrorCode(int code) {
        this.code = code;
    }
}
