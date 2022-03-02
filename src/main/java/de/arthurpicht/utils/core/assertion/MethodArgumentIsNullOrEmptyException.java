package de.arthurpicht.utils.core.assertion;

public class MethodArgumentIsNullOrEmptyException extends MethodPreconditionFailedException {

    public MethodArgumentIsNullOrEmptyException(String name) {
        super("Method precondition failed. Method argument [" + name + "] is null or empty.");
    }
}
