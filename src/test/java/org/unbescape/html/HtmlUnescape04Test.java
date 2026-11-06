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
 *   Unescape of chars after <kbd>&amp;</kbd> that can never start a reference, and of numeric references with
 *   lowercase and mixed-case hexadecimal digits, with or without a closing semicolon.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class HtmlUnescape04Test {




    @Test
    public void testNotReferences() throws Exception {

        testUnescape("&\tx", "&\tx");
        testUnescape("&\nx", "&\nx");
        testUnescape("&\fx", "&\fx");
        testUnescape("&<x", "&<x");
        testUnescape("& x", "& x");
        testUnescape("&&amp;", "&&");
        testUnescape("&#;x", "&#;x");
        testUnescape("&#a", "&#a");
        testUnescape("&a1b;", "&a1b;");

    }




    @Test
    public void testNumericReferences() throws Exception {

        testUnescape("&#x41", "A");
        testUnescape("&#x4a", "J");
        testUnescape("&#xaf;", "\u00AF");
        testUnescape("&#xAf;", "\u00AF");
        testUnescape("&#6", "\u0006");

    }




    @Test
    public void testLegacyNamedPrefix() throws Exception {

        // A legacy named reference (without semicolon) is unescaped even if more alphanumerics follow
        testUnescape("&amp1;", "&1;");

    }




    public HtmlUnescape04Test() {
        super();
    }


}
