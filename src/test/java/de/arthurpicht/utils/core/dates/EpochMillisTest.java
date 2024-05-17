package de.arthurpicht.utils.core.dates;

import org.junit.jupiter.api.Test;
import java.time.ZonedDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EpochMillisTest {

    @Test
    public void testRoundTrip() {
        long currentMillis = System.currentTimeMillis();
        ZonedDateTime zonedDateTime = EpochMillis.asZonedDateTimeBerlin(currentMillis);
        long epochMillis = EpochMillis.from(zonedDateTime);
        assertEquals(currentMillis, epochMillis);
    }

}
