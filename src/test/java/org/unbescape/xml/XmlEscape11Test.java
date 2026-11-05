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

import static org.unbescape.xml.XmlEscapeTestUtil.testUnescape;

/**
 * <p>
 *   Unescape of malformed or incomplete references: XML requires the closing semicolon, a lowercase
 *   <kbd>x</kbd> in hexadecimal references and one of its five predefined entities, so anything else is
 *   left untouched.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class XmlEscape11Test {




    @Test
    public void testMalformed() throws Exception {

        testUnescape("&", "&");
        testUnescape("a&", "a&");
        testUnescape("&;", "&;");
        testUnescape("&#", "&#");
        testUnescape("&#;", "&#;");
        testUnescape("&#x", "&#x");
        testUnescape("&#x;", "&#x;");
        testUnescape("&#65", "&#65");
        testUnescape("&#x41", "&#x41");
        testUnescape("&amp", "&amp");
        testUnescape("&#X41;", "&#X41;");
        testUnescape("&APOS;", "&APOS;");
        testUnescape("&nbsp;", "&nbsp;");
        testUnescape("&unknown;", "&unknown;");

    }




    @Test
    public void testWellFormed() throws Exception {

        testUnescape("&#65;", "A");
        testUnescape("&#x41;", "A");
        testUnescape("&apos;&quot;&lt;&gt;&amp;", "'\"<>&");
        testUnescape("&#x10FFFF;", "\uDBFF\uDFFF");
        testUnescape("&#65;&#65", "A&#65");

    }




    public XmlEscape11Test() {
        super();
    }


}
