package com.karlsson.exception;

public class EntitySaveException extends MasterException {
    public EntitySaveException(String message) {
        super(message);
    }
    public EntitySaveException(String message, Throwable cause) {
        super(message, cause);
    }
}
