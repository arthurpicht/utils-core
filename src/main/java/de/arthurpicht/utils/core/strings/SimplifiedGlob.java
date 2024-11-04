package de.arthurpicht.utils.core.strings;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import static de.arthurpicht.utils.core.assertion.MethodPreconditions.assertArgumentNotNullAndNotEmpty;

/// A pattern matcher with simplified glob syntax. Meta characters are '*' for 0..n signs and '?' for
/// one sign. Escaping '\*' and '\?' will suppress escape feature of respective character.
/// The specified glob expression is internally translated to a regex expression. Method 'compile'
/// returns a regex Pattern object.
///
/// For further info see:
///   - <a href="https://stackoverflow.com/questions/1247772/is-there-an-equivalent-of-java-util-regex-for-glob-type-patterns">SO</a>
///   - <a href="https://pubs.opengroup.org/onlinepubs/009695399/utilities/xcu_chap02.html#tag_02_13_01">Full Glob specification</a>
public class SimplifiedGlob {

    public static class SimplifiedGlobSyntaxException extends IllegalArgumentException {
        public SimplifiedGlobSyntaxException(String simplifiedGlob, String regex, PatternSyntaxException e) {
            super("Syntax error for simplified glob [" + simplifiedGlob + "] which was internally translated " +
                    "to regex [" + regex + "].", e);
        }
    }

    public static Pattern compile(String simplifiedGlob) {
        assertArgumentNotNullAndNotEmpty("simplifiedGlob", simplifiedGlob);

        String regex = simplifiedGlobToRegex(simplifiedGlob);

        try {
            return Pattern.compile(regex);
        } catch (PatternSyntaxException e) {
            throw new SimplifiedGlobSyntaxException(simplifiedGlob, regex, e);
        }
    }

    private static String simplifiedGlobToRegex(String simplifiedGlob) {
        char[] simplifiedGlobArray = simplifiedGlob.toCharArray();
        StringBuilder regex = new StringBuilder("^");

        boolean escaped = false;

        for (char c : simplifiedGlobArray) {
            if (escaped) {
                regex.append(c);
                escaped = false;
            } else if (c == '*') {
                regex.append(".*");
            } else if (c == '?') {
                regex.append(".");
            } else if (c == '\\') {
                regex.append("\\");
                escaped = true;
            } else if (isRegexMetaSymbolMinusGlobMetaSymbol(c)) {
                regex.append("\\").append(c);
            } else {
                regex.append(c);
            }
        }
        regex.append("$");
        return regex.toString();
    }

    private static boolean isRegexMetaSymbolMinusGlobMetaSymbol(char c) {
        // see https://de.wikipedia.org/wiki/Regul%C3%A4rer_Ausdruck
        return (c == '[' || c == ']' || c == '(' || c == ')' || c == '{' || c == '}' || c == '|'
                || c == '+' || c == '-' || c == '^' || c == '$' || c == '\\' || c == '.' || c == '*' || c == '?');
    }

}
