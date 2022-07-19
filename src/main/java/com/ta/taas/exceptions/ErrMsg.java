package com.ta.taas.exceptions;

import lombok.Getter;

@Getter
public enum ErrMsg {

    ID_NOT_EXIST("Id not found"),
    ID_ALREADY_EXIST("Id already exist"),
    INVALID_DATES("start date must be before end date"),
    NOT_AUTHORIZED("Un authorized access");

    private String msg;

    ErrMsg(String msg) {
        this.msg = msg;
    }
}
