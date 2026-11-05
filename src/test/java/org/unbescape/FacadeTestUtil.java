/*
 * =============================================================================
 *
 *   Copyright (c) 2014-2026 Unbescape (https://www.unbescape.org)
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 * =============================================================================
 */
package org.unbescape;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;

/**
 * <p>
 *   Shared checks for the public facade classes ({@code HtmlEscape}, {@code XmlEscape}, etc.).
 * </p>
 * <p>
 *   Each facade operation exists in four variants ({@code String}, {@code String} + {@code Writer},
 *   {@code Reader} + {@code Writer} and {@code char[]} + {@code Writer}). These checks verify that every variant
 *   produces the expected result (usually the result of the escape utility called with the type and level that
 *   the facade method documents), and that all of them honour the documented contract for {@code null} input,
 *   {@code null} writers and invalid {@code char[]} ranges.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public final class FacadeTestUtil {


    public interface StringOperation {
        String apply(final String text);
    }

    public interface WriterOperation {
        void apply(final String text, final Writer writer) throws IOException;
    }

    public interface ReaderOperation {
        void apply(final Reader reader, final Writer writer) throws IOException;
    }

    public interface ArrayOperation {
        void apply(final char[] text, final int offset, final int len, final Writer writer) throws IOException;
    }




    /*
     * Texts that exercise markup-significant characters, whitespace and control characters, the special characters
     * of every supported format, non-ASCII and supplementary characters, unpaired surrogates, already-escaped
     * content, and a text long enough to cross the internal buffer sizes of the Reader-based implementations.
     */
    public static final String[] COMMON_TEXTS;

    static {
        final StringBuilder longText = new StringBuilder();
        for (int i = 0; i < 400; i++) {
            longText.append("a<b>&\"'\u00E1\uD835\uDC9C\\ =:;%+ \n");
        }
        COMMON_TEXTS = new String[] {
                "",
                "a",
                "plain text without any special characters 0123456789",
                "<>&\"'",
                "a < b && c > d",
                " \t\n\r\f\u000B",
                "\u0000\u0001\u001F\u007F\u0080\u009F",
                "\\ / : = ; , . ? # [ ] @ ! $ ( ) * + - _ ` ~ ^ | { }",
                "\u00E1\u00E9\u00ED\u00F3\u00FA \u00F1 \u20AC \u2122 \u00A0",
                "\uD835\uDC9C\uD83D\uDE00",
                "\uD800",
                "a\uDC00b",
                "a\uD800",
                "&amp; &#39; &#x27; &lt &notin; \\u0041 \\x41 \\101 \\41 %41 \"\"",
                longText.toString()
        };
    }




    /**
     * Builds the inputs for checking an unescape operation: the given texts, plus the result of every given
     * escape operation applied to each of them (so that real escaped content is unescaped).
     */
    public static String[] unescapeTexts(final String[] texts, final List<StringOperation> escapes) {
        final Set<String> result = new LinkedHashSet<String>(Arrays.asList(texts));
        for (final StringOperation escape : escapes) {
            for (final String text : texts) {
                result.add(escape.apply(text));
            }
        }
        return result.toArray(new String[result.size()]);
    }


    public static List<StringOperation> operations(final StringOperation... operations) {
        return new ArrayList<StringOperation>(Arrays.asList(operations));
    }




    /**
     * Checks the four variants of an operation against the expected result for each text, plus the documented
     * contract for {@code null} input, {@code null} writers and invalid {@code char[]} ranges.
     * If the expected operation throws {@link IllegalArgumentException} for a text, every variant must throw it too.
     */
    public static void check(final String name, final String[] texts, final StringOperation expected,
                             final StringOperation stringOp, final WriterOperation writerOp,
                             final ReaderOperation readerOp, final ArrayOperation arrayOp) throws IOException {

        for (final String text : texts) {

            final String message = name + " for text [" + text + "]";

            final String expectedResult;
            try {
                expectedResult = expected.apply(text);
            } catch (final IllegalArgumentException e) {
                checkAllThrow(message, text, stringOp, writerOp, readerOp, arrayOp);
                continue;
            }

            final String stringResult = stringOp.apply(text);
            Assertions.assertEquals(expectedResult, stringResult, message + " (String)");
            if (text.equals(stringResult)) {
                // Documented: the exact same object is returned if no modifications were required
                Assertions.assertSame(text, stringResult, message + " (String, same object)");
            }

            final StringWriter writer1 = new StringWriter();
            writerOp.apply(text, writer1);
            Assertions.assertEquals(expectedResult, writer1.toString(), message + " (String + Writer)");

            final StringWriter writer2 = new StringWriter();
            readerOp.apply(new StringReader(text), writer2);
            Assertions.assertEquals(expectedResult, writer2.toString(), message + " (Reader + Writer)");

            final char[] padded = ("XY" + text + "Z").toCharArray();
            final StringWriter writer3 = new StringWriter();
            arrayOp.apply(padded, 2, text.length(), writer3);
            Assertions.assertEquals(expectedResult, writer3.toString(), message + " (char[] + Writer)");

        }

        checkNullAndArguments(name, stringOp, writerOp, readerOp, arrayOp);

    }




    /**
     * Checks that every variant of an operation rejects a {@code null} value for a mandatory argument (type,
     * level, encoding...) with {@link IllegalArgumentException}, even when the text itself is {@code null}.
     */
    public static void checkRejected(final String name,
                                     final StringOperation stringOp, final WriterOperation writerOp,
                                     final ReaderOperation readerOp, final ArrayOperation arrayOp) {
        for (final String text : new String[] { "a<b", null }) {
            final String message = name + " for text [" + text + "]";
            assertIllegalArgument(message + " (String)", () -> stringOp.apply(text));
            assertIllegalArgument(message + " (String + Writer)", () -> writerOp.apply(text, new StringWriter()));
            assertIllegalArgument(message + " (Reader + Writer)",
                    () -> readerOp.apply((text == null ? null : new StringReader(text)), new StringWriter()));
            assertIllegalArgument(message + " (char[] + Writer)",
                    () -> arrayOp.apply((text == null ? null : text.toCharArray()), 0,
                                        (text == null ? 0 : text.length()), new StringWriter()));
        }
    }




    private static void checkAllThrow(final String message, final String text,
                                      final StringOperation stringOp, final WriterOperation writerOp,
                                      final ReaderOperation readerOp, final ArrayOperation arrayOp) {
        assertIllegalArgument(message + " (String)", () -> stringOp.apply(text));
        assertIllegalArgument(message + " (String + Writer)", () -> writerOp.apply(text, new StringWriter()));
        assertIllegalArgument(message + " (Reader + Writer)",
                () -> readerOp.apply(new StringReader(text), new StringWriter()));
        assertIllegalArgument(message + " (char[] + Writer)",
                () -> arrayOp.apply(text.toCharArray(), 0, text.length(), new StringWriter()));
    }


    private static void checkNullAndArguments(final String name,
                                              final StringOperation stringOp, final WriterOperation writerOp,
                                              final ReaderOperation readerOp, final ArrayOperation arrayOp)
                                              throws IOException {

        // Documented: null input returns null, or writes nothing at all to the writer
        Assertions.assertNull(stringOp.apply(null), name + " for null (String)");

        final StringWriter writer1 = new StringWriter();
        writerOp.apply(null, writer1);
        Assertions.assertEquals("", writer1.toString(), name + " for null (String + Writer)");

        final StringWriter writer2 = new StringWriter();
        readerOp.apply(null, writer2);
        Assertions.assertEquals("", writer2.toString(), name + " for null (Reader + Writer)");

        final StringWriter writer3 = new StringWriter();
        arrayOp.apply(null, 0, 0, writer3);
        Assertions.assertEquals("", writer3.toString(), name + " for null (char[] + Writer)");

        // A null writer is always rejected, whatever the input
        for (final String text : new String[] { "a<b", null }) {
            final String message = name + " with null writer for text [" + text + "]";
            assertIllegalArgument(message + " (String + Writer)", () -> writerOp.apply(text, null));
            assertIllegalArgument(message + " (Reader + Writer)",
                    () -> readerOp.apply((text == null ? null : new StringReader(text)), null));
            assertIllegalArgument(message + " (char[] + Writer)",
                    () -> arrayOp.apply((text == null ? null : text.toCharArray()), 0,
                                        (text == null ? 0 : text.length()), null));
        }

        // Invalid (offset, len) ranges are rejected
        final char[] array = "abc".toCharArray();
        final int[][] invalidRanges = { { -1, 1 }, { 0, -1 }, { 4, 0 }, { 0, 4 }, { 2, 2 } };
        for (final int[] range : invalidRanges) {
            assertIllegalArgument(name + " with range " + Arrays.toString(range) + " (char[] + Writer)",
                    () -> arrayOp.apply(array, range[0], range[1], new StringWriter()));
        }
        assertIllegalArgument(name + " with null array and len 1 (char[] + Writer)",
                () -> arrayOp.apply(null, 0, 1, new StringWriter()));

    }


    private static void assertIllegalArgument(final String message, final Executable executable) {
        Assertions.assertThrows(IllegalArgumentException.class, executable, message);
    }




    private FacadeTestUtil() {
        super();
    }


}
