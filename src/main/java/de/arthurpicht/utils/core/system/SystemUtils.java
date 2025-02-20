package de.arthurpicht.utils.core.system;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class SystemUtils {

    /**
     * @return the name of the local host and "UNKNOWN" if no host name can be determined.
     */
    public static String getHostname() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            return "UNKNOWN";
        }
    }

}
