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
package org.unbescape.html;

import org.junit.jupiter.api.Test;

import static org.unbescape.html.HtmlEscapeTestUtil.testUnescape;

/**
 * <p>
 *   Unescape of numeric character references that HTML5 does not map to their own code point: the
 *   Windows-1252 replacements for U+0080 to U+009F, and U+FFFD for NUL, surrogates and values out of the
 *   Unicode range.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class HtmlUnescape01Test {


    // HTML5 numeric character reference replacement table (U+0080 to U+009F). A zero means the
    // code point is not replaced, and maps to itself.
    private static final int[] WINDOWS_1252 = new int[] {
            0x20AC, 0, 0x201A, 0x0192, 0x201E, 0x2026, 0x2020, 0x2021,
            0x02C6, 0x2030, 0x0160, 0x2039, 0x0152, 0, 0x017D, 0,
            0, 0x2018, 0x2019, 0x201C, 0x201D, 0x2022, 0x2013, 0x2014,
            0x02DC, 0x2122, 0x0161, 0x203A, 0x0153, 0, 0x017E, 0x0178 };




    @Test
    public void testWindows1252() throws Exception {

        for (int i = 0; i < WINDOWS_1252.length; i++) {

            final int codepoint = 0x80 + i;
            final String expected =
                    String.valueOf((char) (WINDOWS_1252[i] == 0 ? codepoint : WINDOWS_1252[i]));

            testUnescape("&#" + codepoint + ";", expected);
            testUnescape("&#x" + Integer.toHexString(codepoint) + ";", expected);
            testUnescape("&#X" + Integer.toHexString(codepoint).toUpperCase() + ";", expected);
            testUnescape("a&#" + codepoint + "b", "a" + expected + "b");

        }

    }




    @Test
    public void testReplacementChar() throws Exception {

        testUnescape("&#0;", "\uFFFD");
        testUnescape("&#x0;", "\uFFFD");
        testUnescape("&#xD800;", "\uFFFD");
        testUnescape("&#xDBFF;", "\uFFFD");
        testUnescape("&#xDC00;", "\uFFFD");
        testUnescape("&#xDFFF;", "\uFFFD");
        testUnescape("&#55296;", "\uFFFD");
        testUnescape("&#x110000;", "\uFFFD");
        testUnescape("&#1114112;", "\uFFFD");
        testUnescape("&#99999999999;", "\uFFFD");

    }




    @Test
    public void testValidLimits() throws Exception {

        testUnescape("&#x10FFFF;", "\uDBFF\uDFFF");
        testUnescape("&#1114111;", "\uDBFF\uDFFF");
        testUnescape("&#xD7FF;", "\uD7FF");
        testUnescape("&#xE000;", "\uE000");
        testUnescape("&#xFFFD;", "\uFFFD");
        testUnescape("&#x10000;", "\uD800\uDC00");
        testUnescape("&#1;", "\u0001");
        testUnescape("&#x7F;", "\u007F");
        testUnescape("&#00065;", "A");
        testUnescape("&#x0000041;", "A");

    }




    public HtmlUnescape01Test() {
        super();
    }


}
