package com.ta.taas.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum SecMsg {
    EMAIL_ALREADY_EXIST("email already exist", HttpStatus.CONFLICT),
    EMAIL_OR_PASSWORD_INCORRECT("email or password incorrect", HttpStatus.UNAUTHORIZED),
    INVALID_TOKEN("invalid token please login again", HttpStatus.UNAUTHORIZED);

    private String msg;
    private HttpStatus status;

    SecMsg(String msg, HttpStatus status) {
        this.msg = msg;
        this.status = status;
    }
}
