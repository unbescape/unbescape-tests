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
package org.unbescape.java;

import org.junit.jupiter.api.Test;

import static org.unbescape.java.JavaEscapeTestUtil.testEscape2;
import static org.unbescape.java.JavaEscapeTestUtil.testUnescape;

/**
 * <p>
 *   Unescape of escaped backslashes, lowercase hexadecimal, Unicode escapes with several <kbd>u</kbd>, octal
 *   and malformed or incomplete escapes, and escape of lone (unpaired) surrogates.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class JavaEscape19Test {




    @Test
    public void testUnescapeBackslash() throws Exception {

        testUnescape("\\\\", "\\");
        testUnescape("a\\\\b", "a\\b");
        testUnescape("\\\\\\\\", "\\\\");
        testUnescape("\\\\u0041", "\\u0041");
        testUnescape("\\\\101", "\\101");

    }




    @Test
    public void testUnescapeHexa() throws Exception {

        testUnescape("\\u004a", "J");
        testUnescape("\\u004A", "J");
        testUnescape("\\u00e1", "\u00E1");
        testUnescape("\\uuuu0041", "A");
        testUnescape("\\ud83d\\ude00", "\uD83D\uDE00");

    }




    @Test
    public void testUnescapeOctal() throws Exception {

        testUnescape("\\101", "A");
        testUnescape("\\0", "\u0000");
        testUnescape("\\08", "\u00008");
        testUnescape("\\377", "\u00FF");
        testUnescape("\\400", " 0");

    }




    @Test
    public void testUnescapeMalformed() throws Exception {

        testUnescape("\\", "\\");
        testUnescape("a\\", "a\\");
        testUnescape("\\8", "\\8");
        testUnescape("\\q", "\\q");
        testUnescape("\\u12", "\\u12");
        testUnescape("\\u12g4", "\\u12g4");

    }




    @Test
    public void testEscapeLoneSurrogates() throws Exception {

        testEscape2("\uD800", "\\uD800");
        testEscape2("a\uDC00b", "a\\uDC00b");
        testEscape2("\uDC00\uD800", "\\uDC00\\uD800");
        testEscape2("a\uD800", "a\\uD800");
        testEscape2("\uD83D\uDE00", "\\uD83D\\uDE00");

        testUnescape("\\uD800", "\uD800");
        testUnescape("a\\uDC00b", "a\uDC00b");

    }




    public JavaEscape19Test() {
        super();
    }


}
