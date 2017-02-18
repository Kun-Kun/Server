package com.softgroup.common.exceptions;

/**
 * @author odin
 * @since 15.02.17.
 */
public class YouaException extends RuntimeException {

    private static final long serialVersionUID = 5235385826696520626L;

    public YouaException() {
        super();
    }

    public YouaException(String message) {
        super(message);
    }

    public YouaException(String format, Object... args) {
        this(String.format(format, args));
    }

    public YouaException(String message, Throwable cause) {
        super(message, cause);
    }

    public YouaException(String format, Throwable cause, Object... args) {
        this(String.format(format, args), cause);
    }

    public YouaException(Throwable cause) {
        super(cause);
    }

    public YouaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
