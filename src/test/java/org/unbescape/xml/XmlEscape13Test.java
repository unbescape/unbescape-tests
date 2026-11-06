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
 *   Unescape of numeric references to chars not allowed in XML (U+0000, surrogates, U+FFFE and U+FFFF): these
 *   references are not well-formed, and must be rejected. References to any char allowed in XML 1.0 or XML 1.1
 *   must be unescaped.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class XmlEscape13Test {




    @Test
    public void testNotAllowed() {

        for (final String text : new String[] {
                "&#0;", "&#x0;", "&#00;", "a&#0;b", "&#xD800;", "&#xDBFF;", "&#xDC00;", "&#xDFFF;", "&#55296;",
                "&#xFFFE;", "&#xFFFF;", "&#65535;", "a&#x41;&#xD800;" }) {
            assertUnescapeRejected(text);
        }

    }




    @Test
    public void testAllowed() throws Exception {

        // U+0001 to U+001F are only allowed in XML 1.1 (as references), but unescape is the same for both versions
        testUnescape("&#1;", "\u0001");
        testUnescape("&#x1F;", "\u001F");
        testUnescape("&#9;&#xA;&#xD;", "\t\n\r");
        testUnescape("&#xD7FF;", "\uD7FF");
        testUnescape("&#xE000;", "\uE000");
        testUnescape("&#xFFFD;", "\uFFFD");
        testUnescape("&#x10000;", "\uD800\uDC00");
        testUnescape("&#x10FFFF;", "\uDBFF\uDFFF");
        testUnescape("&lt;&gt;&amp;&quot;&apos;", "<>&\"'");

    }




    private static void assertUnescapeRejected(final String text) {
        final char[] chars = text.toCharArray();
        Assertions.assertThrows(IllegalArgumentException.class, () -> XmlEscape.unescapeXml(text), text);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> XmlEscape.unescapeXml(new StringReader(text), new StringWriter()), text);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> XmlEscape.unescapeXml(chars, 0, chars.length, new StringWriter()), text);
    }




    public XmlEscape13Test() {
        super();
    }


}
