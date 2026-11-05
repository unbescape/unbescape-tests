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

import static org.unbescape.css.CssStringEscapeTestUtil.testEscapeBECompact2;
import static org.unbescape.css.CssStringEscapeTestUtil.testEscapeBESixDigit2;
import static org.unbescape.css.CssStringEscapeTestUtil.testUnescape;

/**
 * <p>
 *   Unescape of hexadecimal escapes (with the whitespace that may end them), escaped newlines and malformed
 *   escapes, and escape of NUL and lone (unpaired) surrogates.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class CssStringEscape26Test {




    @Test
    public void testUnescapeHexa() throws Exception {

        // A single whitespace ends a hexadecimal escape and is removed
        testUnescape("\\41 b", "Ab");
        testUnescape("\\41  b", "A b");
        testUnescape("\\41g", "Ag");
        // Up to six hexadecimal digits
        testUnescape("\\0041b", "\u041B");
        testUnescape("\\00004142", "A42");
        testUnescape("\\1F600x", "\uD83D\uDE00x");
        testUnescape("\\1f600x", "\uD83D\uDE00x");

    }




    @Test
    public void testUnescapeOther() throws Exception {

        testUnescape("a\\\nb", "ab");
        testUnescape("\\\\", "\\");
        testUnescape("\\'", "'");
        testUnescape("\\g", "g");
        testUnescape("\\", "\\");
        testUnescape("a\\", "a\\");

    }




    @Test
    public void testEscapeNulAndLoneSurrogates() throws Exception {

        testEscapeBECompact2("\u0000", "\\0");
        testEscapeBECompact2("a\u0000b", "a\\0 b");
        testEscapeBECompact2("\uD800", "\\D800");
        testEscapeBECompact2("a\uDC00b", "a\\DC00 b");
        testEscapeBECompact2("\uDC00\uD800", "\\DC00\\D800");
        testEscapeBECompact2("a\uD800", "a\\D800");
        testEscapeBECompact2("\uD83D\uDE00", "\\1F600");
        testEscapeBESixDigit2("a\uDC00b", "a\\00DC00b");

    }




    public CssStringEscape26Test() {
        super();
    }


}
