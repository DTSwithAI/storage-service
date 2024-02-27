package com.dts.storageserice.base.exception;

public class ExceptionWithStatusCode extends BaseException{

    int httpStatusCode;
    String messageKey;

    Object[] args;

    public ExceptionWithStatusCode(int httpStatusCode, String messageKey) {
        this.httpStatusCode = httpStatusCode;
        this.messageKey = messageKey;
    }

    public ExceptionWithStatusCode(Throwable throwable, int httpStatusCode, String messageKey) {
        super(throwable);
        this.httpStatusCode = httpStatusCode;
        this.messageKey = messageKey;
    }

    public ExceptionWithStatusCode(int httpStatusCode, String messageKey, Object[] args) {
        this.httpStatusCode = httpStatusCode;
        this.messageKey = messageKey;
        this.args = args;
    }

    public ExceptionWithStatusCode(Throwable throwable, int httpStatusCode, String messageKey, Object[] args) {
        super(throwable);
        this.httpStatusCode = httpStatusCode;
        this.messageKey = messageKey;
        this.args = args;
    }


    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
