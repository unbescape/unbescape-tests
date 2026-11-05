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
package org.unbescape.xml;

import java.io.StringReader;
import java.io.StringWriter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.unbescape.xml.XmlEscapeTestUtil.testUnescape;

/**
 * <p>
 *   Unescape of numeric references with values that do not fit in an int: they are out of the Unicode range
 *   (and rejected as such), and must not wrap around into a valid code point.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class XmlEscape12Test {




    @Test
    public void testOutOfRange() {

        for (final String text : new String[] {
                "&#x110000;", "&#1114112;", "&#4294967361;", "&#x100000041;", "&#x10000000000000041;",
                "&#18446744073709551681;", "a&#4294967356;b" }) {
            assertUnescapeRejected(text);
        }

    }




    @Test
    public void testLeadingZeros() throws Exception {

        testUnescape("&#000000000000000000065;", "A");
        testUnescape("&#x000000000000000000041;", "A");

    }




    private static void assertUnescapeRejected(final String text) {
        final char[] chars = text.toCharArray();
        Assertions.assertThrows(IllegalArgumentException.class, () -> XmlEscape.unescapeXml(text), text);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> XmlEscape.unescapeXml(new StringReader(text), new StringWriter()), text);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> XmlEscape.unescapeXml(chars, 0, chars.length, new StringWriter()), text);
    }




    public XmlEscape12Test() {
        super();
    }


}
