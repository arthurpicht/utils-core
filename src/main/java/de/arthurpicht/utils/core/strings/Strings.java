package de.arthurpicht.utils.core.strings;

import de.arthurpicht.utils.core.assertion.MethodPreconditions;

import java.util.List;

import static de.arthurpicht.utils.core.assertion.MethodPreconditions.*;

@SuppressWarnings("WeakerAccess")
public class Strings {

    /**
     * Checks if specified string is null.
     */
    public static boolean isNull(String string) {
        return (string == null);
    }

    /**
     * Checks if specified string is null or empty.
     */
    public static boolean isNullOrEmpty(String string) {
        return (string == null || string.equals(""));
    }

    /**
     * Checks if specified string is unspecified. Alias for {@link #isNullOrEmpty}
     */
    public static boolean isUnspecified(String string) {
        return isNullOrEmpty(string);
    }

    /**
     * Checks if specified string is not null and not empty.
     */
    public static boolean isNotNullAndNotEmpty(String string) {
        return (string != null && !string.equals(""));
    }

    /**
     * Checks if specified string is specified. Alias for {@link #isNotNullAndNotEmpty(String)}
     */
    public static boolean isSpecified(String string) {
        return isNotNullAndNotEmpty(string);
    }

    /**
     * Checks if specified string contains at least one control character. Control characters are specified in
     * category cC of unicode.
     */
    public static boolean containsControlCharacter(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (Character.getType(string.charAt(i)) == Character.CONTROL) return true;
        }
        return false;
    }

    /**
     * Prüft, ob der spezifizierte *indexString* mit mindestens einem der übergebenen *strings* übereinstimmt.
     *
     * Voraussetzungen:
     * - der *indexString* ist nicht null.
     * - alle Elemente von *strings* sind nicht null.
     *
     * @throws IllegalArgumentException bei Verletzung der Voraussetzungen.
     */
    public static boolean isOneOf(String indexString, String... strings) {

        assertArgumentNotNull("indexString", indexString);
        assertArgumentNotNull("strings", strings);

        for (String string : strings) {
            if (Strings.isNull(string)) throw new IllegalArgumentException("Element of parameter 'strings' is null.");
            if (indexString.equals(string)) return true;
        }

        return false;
    }

    /**
     * Prüft, ob der spezifizierte *indexString* mit mindestens einem Element der übergebenen Liste von *strings*
     * übereinstimmt.
     *
     * Voraussetzungen:
     * - der *indexString* ist nicht null.
     * - *strings* ist nicht null.
     *
     * @throws IllegalArgumentException bei Verletzung der Voraussetzungen.
     *
     */
    public static boolean isOneOf(String indexString, List<String> strings) {

        assertArgumentNotNull("indexString", indexString);
        assertArgumentNotNull("indexString", indexString);
        assertArgumentNotNull("strings", strings);

        return Strings.isOneOf(indexString, strings.toArray(new String[]{}));
    }


    /**
     * Splits specified string in two substrings: one before and one after the specified
     * delimiter. If starter string contains delimiter more then once, then the
     * first occurrence is recognized only.
     *
     * @throws IllegalArgumentException If the specified string does not contain delimiter
     */
    public static String[] splitAtDelimiter(String starter, String delimiter) {
        assertArgumentNotNull("starter", starter);
        assertArgumentNotNull("delimiter", delimiter);

        if (!starter.contains(delimiter)) {
            throw new IllegalArgumentException("Delimiter not contained in specified string.");
        }

        int index = starter.indexOf(delimiter);

        String pre = starter.substring(0, index);
        String post = starter.substring(index + delimiter.length());

        return new String[] {pre, post};
    }

    /**
     * Teilt den spezifizierten String Starter in Teilstrings unter Anwendung der spezifizierten Delimiter.
     * Die Delimiter sind nicht Teil der resultierenden Teilstrings.
     *
     * Voraussetzungen: starter und delimiter sind nicht null, delimiter enthält keine null-Elemente,
     * delimiter-Elemente sind im starter enthalten, delimiter-Elemente sind im Starter in genau der
     * Reihenfolge enthalten, in der sie definiert sind.
     *
     * Wenn der delimiter einzig aus einem leeren Element besteht, wird der starter als Ergebnis
     * zurück gegeben.
     *
     * @throws IllegalArgumentException Wenn die Delimiter nicht bzw. nicht in der gegebenen Reihenfolge
     * im Starter enthalten sind.
     */
    public static String[] multiSplit(String starter, String... delimiter) {
        assertArgumentNotNull("starter", starter);
        assertArgumentNotNull("delimiter", delimiter);

        if (delimiter.length == 0) return new String[] {starter};

        String[] tokens = new String[delimiter.length + 1];
        String workingString = starter;

        for (int i=0; i<delimiter.length; i++) {

            String curDelimiter = delimiter[i];

            if (Strings.isNullOrEmpty(curDelimiter)) {
                throw new IllegalArgumentException("Delimiter ist null oder leer.");
            }

            String[] simpleSplitTokens;
            try {
                simpleSplitTokens = Strings.splitAtDelimiter(workingString, curDelimiter);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Token nicht oder nicht in der erwarteten Reihenfolge im starter-String gefunden: '" + curDelimiter + "'.");
            }

            tokens[i] = simpleSplitTokens[0];
            workingString = simpleSplitTokens[1];

            if (i== delimiter.length - 1) {
                tokens[i + 1] = workingString;
            }

        }

        return tokens;
    }

    /**
     * Returns the first line of specified string. Those are the characters before the first occurrence of the newline
     * control character. If specified string does not contain any newline control character, then the specified string
     * is returned.
     */
    public static String getFirstLine(String string) {
        assertArgumentNotNull("string", string);

        if (!string.contains("\n")) return string;
        return splitAtDelimiter(string, "\n")[0];
    }

    /**
     * Schneidet am Ende des spezifizierten Strings n Zeichen ab. Wenn n der Länge
     * des Strings entspricht, wird ein leerer String zurück gegeben. Wenn n größer
     * als die Länge des Strings ist, wird eine IllegalArgumentException geworfen.
     */
    public static String cutEnd(String string, int n) {
        assertArgumentNotNull("string", string);

        if (n < 0) throw new IllegalArgumentException("Parameter n ist negativ.");
        if (string.length() < n) throw new IllegalArgumentException("Überschreitung der Länge des Strings.");

        return string.substring(0, string.length() - n);
    }

    /**
     * Erzeugt aus einem Iterable von Objekten einen zusammengsetzten String unter
     * Verwendung der jeweiligen Stringrepräsentationen und des spezifizierten Delimiters.
     * Null-Elemente werden als "null" repräsentiert.
     *
     * @param objects Iterable von Objects
     * @param delimiter Trennzeichen zwischen Elementen
     * @return zusammengesetzter String
     */
    public static String listing(Iterable<?> objects, String delimiter) {
        assertArgumentNotNull("objects", objects);
        assertArgumentNotNull("delimiter", delimiter);

        StringBuilder stringBuilder = new StringBuilder();
        for (Object object : objects) {
            String string = object != null ? object.toString() : "null";
            if (stringBuilder.length() > 0) stringBuilder.append(delimiter);
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    /**
     * Erzeugt aus einem Iterable von Objekten einen zusammengesetzten String unter
     * Verwendung des spezifizierten Delimiters sowie eine pre- und post-String.
     *
     * @param objects Iterable von Objekten
     * @param delimiter Trennzeichen zwischen Elementen
     * @param pre Zeichen am Anfang des zusammengesetzten Strings
     * @param post Zeichen am Ende des zusammengesetzten Strings
     * @return zusammengesetzter String
     */
    public static String listing(Iterable<?> objects, String delimiter, String pre, String post) {
        assertArgumentNotNull("objects", objects);
        assertArgumentNotNull("delimiter", delimiter);
        assertArgumentNotNull("pre", pre);
        assertArgumentNotNull("post", post);

        return pre + listing(objects, delimiter) + post;
    }

    /**
     * Erzeugt aus einem Iterable von Objekten einen zusammengesetzten String. Jede Stringrepresentation des jeweiligen
     * Elements wird von den spezifizierten Strings preElement und postElement eingerahmt. Zur Trennung der Elemente in
     * der Liste kommt der spez. Delimiter zur Anwendung. Der Gesamtstring wird eingerahmt von den spez. pre und post
     * String. Nullelemente werden als 'null' repräsentiert.
     *
     * @param objects
     * @param delimiter
     * @param pre
     * @param post
     * @param preElement
     * @param postElement
     * @return
     */
    public static String listing(Iterable<?> objects, String delimiter, String pre, String post, String preElement, String postElement) {
        assertArgumentNotNull("objects", objects);
        assertArgumentNotNull("delimiter", delimiter);
        assertArgumentNotNull("pre", pre);
        assertArgumentNotNull("post", post);
        assertArgumentNotNull("preElement", preElement);
        assertArgumentNotNull("postElement", postElement);

        StringBuilder stringBuilder = new StringBuilder();
        for (Object object : objects) {
            String string = object != null ? object.toString() : "null";
            if (stringBuilder.length() > 0) stringBuilder.append(delimiter);
            stringBuilder.append(preElement).append(string).append(postElement);
        }
        stringBuilder.insert(0, pre);
        stringBuilder.append(post);

        return stringBuilder.toString();
    }

    /**
     * Füllt den spez. und initialisierten StringBuilder bis zur spez. Länge auf.
     * Wenn die spez. Länge bereits initial gegeben oder überschritten ist, bleibt
     * der spez. StringBuilder unverändert.
     *
     * @param stringBuilder
     * @param fillChar
     * @param minLength
     */
    public static void fillUpAfter(StringBuilder stringBuilder, char fillChar, int minLength) {
        assertArgumentNotNull("stringBuilder", stringBuilder);

        if (stringBuilder.length() >= minLength) return;
        int nrOfCharsToFill = minLength - stringBuilder.length();
        stringBuilder.append(String.valueOf(fillChar).repeat(Math.max(0, nrOfCharsToFill)));
    }

    /**
     * Füllt den spez. String durch wiederholte Hinzufügung bis zur spez. Länge auf.
     * Wenn die spez. Länge bereits initial gegeben oder überschritten ist, wird der spez. String
     * unverändert zurück gegeben.
     *
     * @param string
     * @param fillChar
     * @param minLength
     * @return@NotNull
     */
    public static String fillUpAfter(String string, char fillChar, int minLength) {
        assertArgumentNotNull("string", string);
        assertArgumentIsEqualToOrGreaterThanZero("minLength", minLength);

        StringBuilder stringBuilder = new StringBuilder(string);
        fillUpAfter(stringBuilder, fillChar, minLength);
        return stringBuilder.toString();
    }

    /**
     * Reduziert white space zu maximal einem Leerzeichen zwischen Wörtern.
     * Aus einem String mit mehreren Zeilen wird so ein einzeiliger String,
     * bei dem maximal ein Leerzeichen zwischen zwei Wörtern oder Zeichen
     * zu finden ist.
     *
     */
    public static String linearize(String string) {
        assertArgumentNotNull("string", string);

        string = string.trim();
        return string.replaceAll("\\s+", " ");
    }

    /**
     * Makes sure that specified string ends with specified ending.
     *
     * @param string
     * @param ending
     * @return specified string or specified string with added specified ending if specified string does not end
     * with specified ending.
     */
    public static String assureEndsWith(String string, String ending) {
        assertArgumentNotNull("string", string);
        assertArgumentNotNull("ending", ending);
        if (string.endsWith(ending)) return string;
        return string + ending;
    }

    /**
     * Concatenates specified objects to one string by using each toString
     * method.
     *
     * @param objects
     * @return
     */
    public static String concat(Iterable<?> objects) {
        assertArgumentNotNull("objects", objects);
        StringBuilder stringBuilder = new StringBuilder();
        objects.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    /**
     * Returns array of string for specified list of strings.
     *
     * @param list list of strings
     * @return
     */
    public static String[] toArray(List<String> list) {
        assertArgumentNotNull("list", list);
        return list.toArray(new String[0]);
    }

    /**
     * Fills up specified string with spaces until specified minLength is reached.
     * If length of specified string is equal or greater than specified length, then specified string
     * is returned unmodified.
     *
     * @param string
     * @param minLength
     * @return
     */
    public static String rightPad(String string, int minLength) {
        assertArgumentNotNull("string", string);
        assertArgumentIsGreaterThanZero("minLength", minLength);
        return Strings.fillUpAfter(string, ' ', minLength);
    }

    /**
     * Limits specified string to maximum length as specified limit.
     *
     * @param string string to be limited in length
     * @param limit maximum length of string
     * @return specified string or first part of string with length equals limit if specified string exceeds length
     * limit.
     */
    public static String limit(String string, int limit) {
        assertArgumentNotNull("string", string);
        if (limit < 0) throw new IllegalArgumentException("Specified limit less than 0.");
        if (string.length() <= limit) {
            return string;
        } else {
            return string.substring(0, limit);
        }
    }

}
