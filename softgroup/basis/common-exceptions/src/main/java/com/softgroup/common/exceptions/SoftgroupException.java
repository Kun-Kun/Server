package com.softgroup.common.exceptions;

/**
 * @author odin
 * @since 15.02.17.
 */
public class SoftgroupException extends RuntimeException {

    private static final long serialVersionUID = 5235385826696520626L;

    public SoftgroupException() {
        super();
    }

    public SoftgroupException(String message) {
        super(message);
    }

    public SoftgroupException(String format, Object... args) {
        this(String.format(format, args));
    }

    public SoftgroupException(String message, Throwable cause) {
        super(message, cause);
    }

    public SoftgroupException(String format, Throwable cause, Object... args) {
        this(String.format(format, args), cause);
    }

    public SoftgroupException(Throwable cause) {
        super(cause);
    }

    public SoftgroupException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
