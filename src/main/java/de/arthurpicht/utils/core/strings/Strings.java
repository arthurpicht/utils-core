package de.arthurpicht.utils.core.strings;

import de.arthurpicht.utils.core.assertion.AssertMethodPrecondition;

import java.util.List;

public class Strings {

    public static boolean isNull(String string) {
        return (string == null);
    }

    public static boolean isNullOrEmpty(String string) {
        return (string == null || string.equals(""));
    }

    /**
     * Prüft, ob der spezifizierte *indexString* mit mindestens einem der übergebenen *strings* übereinstimmt.
     *
     * Voraussetzungen:
     * - der *indexString* ist nicht null.
     * - alle Elemente von *strings* sind nicht null.
     *
     * @throws IllegalArgumentException bei Verletzung der Voraussetzungen.
     *
     * @param indexString
     * @param strings
     * @return
     */
    public static boolean isOneOf(String indexString, String... strings) {

        if (Strings.isNull(indexString)) throw new IllegalArgumentException("Parameter *indexString* ist null.");

        for (String string : strings) {
            if (Strings.isNull(string)) throw new IllegalArgumentException("Parameter-Element von *strings* ist null.");
            if (indexString.equals(string)) return true;
        }

        return false;
    }

    /**
     * Splits specified string in two substrings: one before and one after the specified
     * delimiter. If the delimiter is contained multiple times in the string, only the
     * first occurrence is recognized.
     *
     * @param starter
     * @param delimiter
     * @return
     * @throws IllegalArgumentException If the specified string does not contain delimiter
     */
    public static String[] splitAtDelimiter(String starter, String delimiter) {

        if (!starter.contains(delimiter)) {
            throw new IllegalArgumentException("Delimiter im zu verarbeitenden String nicht enthalten: '" + delimiter + "'.");
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
     *
     * @param starter
     * @param delimiter
     * @return
     * @throws IllegalArgumentException Wenn die Delimiter nicht bzw. nicht in der gegebenen Reihenfolge
     * im Starter enthalten sind.
     */
    public static String[] multiSplit(String starter, String... delimiter) {

        AssertMethodPrecondition.parameterNotNull("starter", starter);
        AssertMethodPrecondition.parameterNotNull("delimiter", delimiter);

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
     * Schneidet am Ende des spezifizierten Strings n Zeichen ab. Wenn n der Länge
     * des Strings entspricht, wird ein leerer String zurück gegeben. Wenn n größer
     * als die Länge des Strings ist, wird eine IllegalArgumentException geworfen.
     *
     * @param string
     * @param n
     * @return
     */
    public static String cutEnd(String string, int n) {

        AssertMethodPrecondition.parameterNotNull("string", string);

        if (n < 0) throw new IllegalArgumentException("Parameter n ist negativ.");
        if (string.length() < n) throw new IllegalArgumentException("Überschreitung der Länge des Strings.");

        return string.substring(0, string.length() - n);
    }

    /**
     * Erzeugt aus einem Iterable von Strings einen zusammengsetzten String unter
     * Verwendung des spezifizierten Delimiters.
     *
     * @param stringList Iterable von Strings
     * @param delimiter Trennzeichen zwischen Elementen
     * @return zusammengesetzter String
     */
    public static String listing(Iterable<String> stringList, String delimiter) {

        AssertMethodPrecondition.parameterNotNull("stringList", stringList);
        AssertMethodPrecondition.parameterNotNull("delimiter", delimiter);

        StringBuilder stringBuilder = new StringBuilder();
        for (String string : stringList) {
            if (stringBuilder.length() > 0) stringBuilder.append(delimiter);
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    /**
     * Erzeugt aus einem Iteralbe von String einen zusammengesetzten String unter
     * Verwendung des spezifizierten Delimiters sowie eine pre- und post-String.
     *
     * @param stringList Iterable von Strings
     * @param delimiter Trennzeichen zwischen Elementen
     * @param pre Zeichen am Anfang des zusammengesetzten Strings
     * @param post Zeichen am Ende des zusammengesetzten Strings
     * @return zusammengesetzter String
     */
    public static String listing(Iterable<String> stringList, String delimiter, String pre, String post) {

        AssertMethodPrecondition.parameterNotNull("stringList", stringList);
        AssertMethodPrecondition.parameterNotNull("delimiter", delimiter);
        AssertMethodPrecondition.parameterNotNull("pre", pre);
        AssertMethodPrecondition.parameterNotNull("post", post);

        return pre + listing(stringList, delimiter) + post;
    }


}
