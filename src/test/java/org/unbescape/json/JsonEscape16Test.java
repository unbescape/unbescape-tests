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
package org.unbescape.json;

import org.junit.jupiter.api.Test;

import static org.unbescape.json.JsonEscapeTestUtil.testEscapeSECUHexa2;
import static org.unbescape.json.JsonEscapeTestUtil.testEscapeUHexa2;
import static org.unbescape.json.JsonEscapeTestUtil.testUnescape;

/**
 * <p>
 *   Unescape of escaped backslashes, lowercase hexadecimal and escapes that JSON does not define (which are
 *   left untouched), and escape of lone (unpaired) surrogates.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class JsonEscape16Test {




    @Test
    public void testUnescapeBackslash() throws Exception {

        testUnescape("\\\\", "\\");
        testUnescape("a\\\\b", "a\\b");
        testUnescape("\\\\\\\\", "\\\\");
        testUnescape("\\\\u0041", "\\u0041");
        testUnescape("\\\\\\u0041", "\\A");
        testUnescape("\\/", "/");

    }




    @Test
    public void testUnescapeHexa() throws Exception {

        testUnescape("\\u004a", "J");
        testUnescape("\\u004A", "J");
        testUnescape("\\u00e1", "\u00E1");
        testUnescape("\\ud83d\\ude00", "\uD83D\uDE00");

    }




    @Test
    public void testUnescapeNotJson() throws Exception {

        testUnescape("\\x41", "\\x41");
        testUnescape("\\101", "\\101");
        testUnescape("\\0", "\\0");
        testUnescape("\\'", "\\'");
        testUnescape("\\v", "\\v");
        testUnescape("\\q", "\\q");
        testUnescape("\\", "\\");
        testUnescape("a\\", "a\\");
        testUnescape("\\u12", "\\u12");
        testUnescape("\\u12g4", "\\u12g4");

    }




    @Test
    public void testEscapeLoneSurrogates() throws Exception {

        testEscapeSECUHexa2("\uD800", "\\uD800");
        testEscapeSECUHexa2("a\uDC00b", "a\\uDC00b");
        testEscapeSECUHexa2("\uDC00\uD800", "\\uDC00\\uD800");
        testEscapeSECUHexa2("a\uD800", "a\\uD800");
        testEscapeSECUHexa2("\uD83D\uDE00", "\\uD83D\\uDE00");
        testEscapeUHexa2("a\uDC00b", "a\\uDC00b");

        testUnescape("\\uD800", "\uD800");
        testUnescape("a\\uDC00b", "a\uDC00b");

    }




    public JsonEscape16Test() {
        super();
    }


}
