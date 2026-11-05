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
package org.unbescape.css;

import org.junit.jupiter.api.Test;

import static org.unbescape.css.CssStringEscapeTestUtil.testUnescape;

/**
 * <p>
 *   Unescape as established by the CSS Syntax specification: escapes for U+0000, for lone surrogates and for
 *   values out of the Unicode range are unescaped as U+FFFD, any whitespace (including newlines, with CR LF
 *   counting as one) ends a hexadecimal escape, and any escaped newline is a line continuation. The
 *   non-standard (older WebKit) surrogate pair syntax is still supported.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class CssUnescape00Test {




    @Test
    public void testReplacementChar() throws Exception {

        testUnescape("\\0", "\uFFFD");
        testUnescape("\\000000", "\uFFFD");
        testUnescape("\\0 0", "\uFFFD0");
        testUnescape("a\\0 b", "a\uFFFDb");
        testUnescape("\\110000", "\uFFFD");
        testUnescape("\\FFFFFF", "\uFFFD");
        testUnescape("\\D800", "\uFFFD");
        testUnescape("\\DBFF", "\uFFFD");
        testUnescape("\\DC00", "\uFFFD");
        testUnescape("\\DFFF", "\uFFFD");
        testUnescape("\\D800 x", "\uFFFDx");
        testUnescape("\\DC00\\D840", "\uFFFD\uFFFD");
        testUnescape("\\D840\\41", "\uFFFDA");
        testUnescape("\\D840\\z", "\uFFFDz");
        testUnescape("\\D840\\", "\uFFFD\\");

    }




    @Test
    public void testValidLimits() throws Exception {

        testUnescape("\\1", "\u0001");
        testUnescape("\\D7FF", "\uD7FF");
        testUnescape("\\E000", "\uE000");
        testUnescape("\\FFFD", "\uFFFD");
        testUnescape("\\10000", "\uD800\uDC00");
        testUnescape("\\10FFFF", "\uDBFF\uDFFF");

    }




    @Test
    public void testSurrogatePairs() throws Exception {

        testUnescape("\\D840\\DC00", "\uD840\uDC00");
        testUnescape("\\D840 \\DC00", "\uD840\uDC00");
        testUnescape("\\D840 \\DC00 x", "\uD840\uDC00x");
        testUnescape("\\D840 \\DC00\r\nx", "\uD840\uDC00x");
        testUnescape("\\D83D\\DE00x", "\uD83D\uDE00x");
        testUnescape("\\D840\\D840\\DC00", "\uFFFD\uD840\uDC00");
        testUnescape("x\\D840 \\DC00 y\\D835 \\DCCD z", "x\uD840\uDC00y\uD835\uDCCDz");

    }




    @Test
    public void testWhitespaceAfterHexa() throws Exception {

        testUnescape("\\41 b", "Ab");
        testUnescape("\\41\tb", "Ab");
        testUnescape("\\41\nb", "Ab");
        testUnescape("\\41\rb", "Ab");
        testUnescape("\\41\r\nb", "Ab");
        testUnescape("\\41\fb", "Ab");
        // Only one whitespace is part of the escape
        testUnescape("\\41  b", "A b");
        testUnescape("\\41\r\n b", "A b");
        testUnescape("\\41\n\nb", "A\nb");

    }




    @Test
    public void testLineContinuation() throws Exception {

        testUnescape("a\\\nb", "ab");
        testUnescape("a\\\rb", "ab");
        testUnescape("a\\\r\nb", "ab");
        testUnescape("a\\\fb", "ab");
        testUnescape("a\\\r\n\nb", "a\nb");
        testUnescape("a\\\n\\\r\\\r\n\\\fb", "ab");

    }




    public CssUnescape00Test() {
        super();
    }


}
