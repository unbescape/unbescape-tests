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
package org.unbescape.javascript;

import org.junit.jupiter.api.Test;

import static org.unbescape.javascript.JavaScriptEscapeTestUtil.testEscapeSECXHexaUHexa2;
import static org.unbescape.javascript.JavaScriptEscapeTestUtil.testEscapeUHexa2;
import static org.unbescape.javascript.JavaScriptEscapeTestUtil.testUnescape;

/**
 * <p>
 *   Unescape of escaped backslashes, lowercase hexadecimal, octal and malformed or incomplete escapes, and
 *   escape of lone (unpaired) surrogates.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class JavaScriptEscape18Test {




    @Test
    public void testUnescapeBackslash() throws Exception {

        testUnescape("\\\\", "\\");
        testUnescape("a\\\\b", "a\\b");
        testUnescape("\\\\\\\\", "\\\\");
        // An escaped backslash followed by something that looks like an escape is not an escape
        testUnescape("\\\\u0041", "\\u0041");
        testUnescape("\\\\x41", "\\x41");
        testUnescape("\\\\101", "\\101");
        testUnescape("\\\\\\u0041", "\\A");

    }




    @Test
    public void testUnescapeHexa() throws Exception {

        testUnescape("\\u004a", "J");
        testUnescape("\\u004A", "J");
        testUnescape("\\u00e1", "\u00E1");
        testUnescape("\\x4a", "J");
        testUnescape("\\x4A", "J");
        testUnescape("\\xe1", "\u00E1");
        testUnescape("\\ud83d\\ude00", "\uD83D\uDE00");

    }




    @Test
    public void testUnescapeOctal() throws Exception {

        testUnescape("\\101", "A");
        testUnescape("\\0", "\u0000");
        testUnescape("\\08", "\u00008");
        testUnescape("\\7", "\u0007");
        testUnescape("\\77", "?");
        testUnescape("\\377", "\u00FF");
        // Octal escapes go up to \377: longer sequences end before the digit that would exceed it
        testUnescape("\\400", " 0");
        testUnescape("\\1234", "S4");

    }




    @Test
    public void testUnescapeMalformed() throws Exception {

        testUnescape("\\", "\\");
        testUnescape("a\\", "a\\");
        testUnescape("\\u12", "\\u12");
        testUnescape("\\u12g4", "\\u12g4");
        testUnescape("\\x4", "\\x4");
        testUnescape("\\x4g", "\\x4g");
        testUnescape("\\q", "q");
        testUnescape("a\\\nb", "ab");

    }




    @Test
    public void testEscapeLoneSurrogates() throws Exception {

        testEscapeSECXHexaUHexa2("\uD800", "\\uD800");
        testEscapeSECXHexaUHexa2("a\uDC00b", "a\\uDC00b");
        testEscapeSECXHexaUHexa2("\uDC00\uD800", "\\uDC00\\uD800");
        testEscapeSECXHexaUHexa2("a\uD800", "a\\uD800");
        testEscapeSECXHexaUHexa2("\uD83D\uDE00", "\\uD83D\\uDE00");
        testEscapeUHexa2("a\uDC00b", "a\\uDC00b");

        testUnescape("\\uD800", "\uD800");
        testUnescape("a\\uDC00b", "a\uDC00b");

    }




    public JavaScriptEscape18Test() {
        super();
    }


}
