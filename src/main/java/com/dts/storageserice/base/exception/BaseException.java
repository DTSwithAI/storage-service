package com.dts.storageserice.base.exception;

public abstract class BaseException extends RuntimeException {
    public BaseException(){}

    public BaseException(Throwable throwable){
        super(throwable);
    }
}
