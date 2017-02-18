package com.softgroup.common.exceptions;

/**
 * @author odin
 * @since 15.02.17.
 */
public class MapperException extends YouaException {//NOSONAR: this is exception class
    private static final long serialVersionUID = 1400802494145013136L;

    public MapperException(String message, Throwable cause) {
        super(message, cause);
    }

    public MapperException(String message) {
        super(message);
    }
}
