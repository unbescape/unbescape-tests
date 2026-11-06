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
 *   Unescape of chars after <kbd>&amp;</kbd> that can never start a reference, and of malformed numeric and
 *   named references (which are left untouched), and numeric references with lowercase hexadecimal digits.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class XmlEscape14Test {




    @Test
    public void testNotReferences() throws Exception {

        testUnescape("&\tx", "&\tx");
        testUnescape("&\nx", "&\nx");
        testUnescape("&\fx", "&\fx");
        testUnescape("&<x", "&<x");
        testUnescape("& x", "& x");
        testUnescape("&&amp;", "&&");

    }




    @Test
    public void testMalformed() throws Exception {

        testUnescape("&#x41", "&#x41");
        testUnescape("&#6x;", "&#6x;");
        testUnescape("&#;x", "&#;x");
        testUnescape("&#xg;", "&#xg;");
        testUnescape("&#a;", "&#a;");
        testUnescape("&a1b;", "&a1b;");
        testUnescape("&amp1;", "&amp1;");

    }




    @Test
    public void testNumericReferences() throws Exception {

        testUnescape("&#x4a;", "J");
        testUnescape("&#xaf;", "\u00AF");
        testUnescape("&#xAf;", "\u00AF");

    }




    public XmlEscape14Test() {
        super();
    }


}
