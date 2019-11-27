package de.arthurpicht.utils.core.assertion;

public class MethodPreconditionFailedException extends IllegalArgumentException {

    public MethodPreconditionFailedException() {
        super();
    }

    public MethodPreconditionFailedException(String s) {
        super(s);
    }

    public MethodPreconditionFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public MethodPreconditionFailedException(Throwable cause) {
        super(cause);
    }
}
