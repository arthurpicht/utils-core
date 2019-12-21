package de.arthurpicht.utils.core.strings;

import de.arthurpicht.utils.core.assertion.MethodPreconditionFailedException;
import de.arthurpicht.utils.core.collection.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringsListingTest {

    @Test
    void listingOne() {
        List<String> stringList = Lists.newArrayList("string1");
        String listing = Strings.listing(stringList, ", ");
        assertEquals("string1", listing);
    }

    @Test
    void listingMultiple() {
        List<String> stringList = Lists.newArrayList("string1", "string2", "string3");
        String listing = Strings.listing(stringList, ", ");
        assertEquals("string1, string2, string3", listing);
    }

    @Test
    void listingMultipleWithNullElement() {
        List<String> stringList = Lists.newArrayList("string1", null, "string3");
        String listing = Strings.listing(stringList, ", ");
        assertEquals("string1, null, string3", listing);
    }

    @Test
    void listingNullList() {
        try {
            Strings.listing(null, ", ");
            fail();
        } catch (MethodPreconditionFailedException e) {
            // intended
        }
    }

    @Test
    void listingNullDelimiter() {
        try {
            Strings.listing(Lists.newArrayList("string1", "string2", "string3"), null);
            fail();
        } catch (MethodPreconditionFailedException e) {
            // intended
        }
    }

    @Test
    void listingPrePostOne() {
        List<String> stringList = Lists.newArrayList("string1");
        String listing = Strings.listing(stringList, ", ", "{", "}");
        assertEquals("{string1}", listing);
    }

    @Test
    void listingPrePostMultiple() {
        List<String> stringList = Lists.newArrayList("string1", "string2", "string3");
        String listing = Strings.listing(stringList, ", ", "{", "}");
        assertEquals("{string1, string2, string3}", listing);
    }

    @Test
    void listingPrePostNullList() {
        try {
            Strings.listing(null, ", ", "{", "}");
            fail();
        } catch (MethodPreconditionFailedException e) {
            // intended
        }
    }

    @Test
    void listingPrePostNullDelimiter() {
        try {
            Strings.listing(Lists.newArrayList("string1", "string2", "string3"), null, "{", "}");
            fail();
        } catch (MethodPreconditionFailedException e) {
            // intended
        }
    }

    @Test
    void listingPrePostNullPre() {
        try {
            Strings.listing(Lists.newArrayList("string1", "string2", "string3"), ", ", null, "}");
            fail();
        } catch (MethodPreconditionFailedException e) {
            // intended
        }
    }

    @Test
    void listingPrePostNullPost() {
        try {
            Strings.listing(Lists.newArrayList("string1", "string2", "string3"), ", ", "{", null);
            fail();
        } catch (MethodPreconditionFailedException e) {
            // intended
        }
    }


}