package com.ta.taas.exceptions;

public class TaskSystemException extends Exception{
    public TaskSystemException(ErrMsg errMsg) {
        super(errMsg.getMsg());
    }
}
