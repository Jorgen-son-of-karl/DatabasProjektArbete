package com.karlsson.exception;

public class MasterException extends RuntimeException {
    public MasterException(String message) {
        super(message);
    }

    public MasterException(String message, Throwable cause) {super(message, cause);}
}
