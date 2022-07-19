package com.ta.taas.exceptions;

import lombok.Data;

@Data
public class TaskSecurityException extends Exception{

    private SecMsg secMsg;

    public TaskSecurityException(SecMsg secMsg) {
        super(secMsg.getMsg());
        this.secMsg = secMsg;
    }
}
