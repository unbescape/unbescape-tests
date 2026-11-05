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

import org.junit.jupiter.api.Test;

import static org.unbescape.xml.XmlEscapeTestUtil.testEscapeXml10Hexa1;
import static org.unbescape.xml.XmlEscapeTestUtil.testEscapeXml10Hexa3;
import static org.unbescape.xml.XmlEscapeTestUtil.testEscapeXml11Hexa1;
import static org.unbescape.xml.XmlEscapeTestUtil.testEscapeXml11Hexa3;

/**
 * <p>
 *   Escape of chars that XML 1.0 and XML 1.1 do not allow, or only allow as character references:
 *   non-characters and lone surrogates are removed, restricted chars are escaped, and every other
 *   char at or above U+E000 (including supplementary chars) is kept.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class XmlEscape10Test {




    @Test
    public void testHighChars() throws Exception {

        testEscapeXml10Hexa1("\uE000", "\uE000");
        testEscapeXml10Hexa1("\uFFFD", "\uFFFD");
        testEscapeXml10Hexa1("\uFFFE", "");
        testEscapeXml10Hexa1("\uFFFF", "");
        testEscapeXml10Hexa1("a\uFFFEb\uFFFFc", "abc");
        testEscapeXml10Hexa1("\uD800\uDC00", "\uD800\uDC00");
        testEscapeXml10Hexa1("\uDBFF\uDFFF", "\uDBFF\uDFFF");

        testEscapeXml11Hexa1("\uE000", "\uE000");
        testEscapeXml11Hexa1("\uFFFD", "\uFFFD");
        testEscapeXml11Hexa1("\uFFFE", "");
        testEscapeXml11Hexa1("\uFFFF", "");
        testEscapeXml11Hexa1("\uD800\uDC00", "\uD800\uDC00");

        testEscapeXml10Hexa3("\uE000", "&#xe000;");
        testEscapeXml10Hexa3("\uFFFD", "&#xfffd;");
        testEscapeXml10Hexa3("\uFFFE", "");
        testEscapeXml10Hexa3("\uD800\uDC00", "&#x10000;");
        testEscapeXml11Hexa3("\uE000", "&#xe000;");
        testEscapeXml11Hexa3("\uFFFF", "");
        testEscapeXml11Hexa3("\uDBFF\uDFFF", "&#x10ffff;");

    }




    @Test
    public void testLoneSurrogates() throws Exception {

        testEscapeXml10Hexa1("\uD800", "");
        testEscapeXml10Hexa1("\uDC00", "");
        testEscapeXml10Hexa1("a\uD800b", "ab");
        testEscapeXml10Hexa1("a\uDC00b", "ab");
        testEscapeXml10Hexa1("\uDC00\uD800", "");
        testEscapeXml10Hexa1("a\uD800", "a");
        testEscapeXml11Hexa1("\uD800", "");
        testEscapeXml11Hexa1("a\uDC00b", "ab");
        testEscapeXml10Hexa3("a\uD800b", "ab");
        testEscapeXml11Hexa3("a\uDC00b", "ab");

    }




    @Test
    public void testControlChars() throws Exception {

        // XML 1.0 does not allow most C0 controls at all; XML 1.1 allows them only as references
        testEscapeXml10Hexa1("\u0001", "");
        testEscapeXml10Hexa1("\u000B", "");
        testEscapeXml10Hexa1("\t", "\t");
        testEscapeXml10Hexa1("\u007F", "&#x7f;");
        testEscapeXml10Hexa1("\u0085", "\u0085");
        testEscapeXml10Hexa1("\u2028", "\u2028");

        testEscapeXml11Hexa1("\u0001", "&#x1;");
        testEscapeXml11Hexa1("\u000B", "&#xb;");
        testEscapeXml11Hexa1("\t", "\t");
        testEscapeXml11Hexa1("\u007F", "&#x7f;");
        testEscapeXml11Hexa1("\u0085", "\u0085");
        testEscapeXml11Hexa1("\u2028", "\u2028");

    }




    public XmlEscape10Test() {
        super();
    }


}
