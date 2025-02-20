package de.arthurpicht.utils.core.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtils {

    /**
     * Transforms specified throwable as a string.
     *
     * @param throwable some class extending throwable
     * @return stacktrace as a string
     */
    public static String getStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        throwable.printStackTrace(pw);
        return sw.toString();
    }

}
