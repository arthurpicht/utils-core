package de.arthurpicht.utils.core.assertion;

public class MethodArgumentIsNullException extends MethodPreconditionFailedException {

    public MethodArgumentIsNullException(String name) {
        super("Method precondition failed. Method argument [" + name + "] is null.");
    }
}
