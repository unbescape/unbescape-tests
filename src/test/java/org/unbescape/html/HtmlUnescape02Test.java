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
 *   Unescape of malformed or incomplete references: references without a closing semicolon are
 *   unescaped as HTML5 does, and anything that is not a reference is left untouched.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class HtmlUnescape02Test {




    @Test
    public void testNotReferences() throws Exception {

        testUnescape("&", "&");
        testUnescape("a&", "a&");
        testUnescape("&;", "&;");
        testUnescape("& b", "& b");
        testUnescape("&#", "&#");
        testUnescape("&#;", "&#;");
        testUnescape("&#x", "&#x");
        testUnescape("&#x;", "&#x;");
        testUnescape("&#xg;", "&#xg;");
        testUnescape("&unknown;", "&unknown;");
        testUnescape("&notit;", "&notit;");

    }




    @Test
    public void testNumericWithoutSemicolon() throws Exception {

        testUnescape("&#65", "A");
        testUnescape("&#65x", "Ax");
        testUnescape("&#x41g", "Ag");
        testUnescape("&#65;&#66", "AB");

    }




    @Test
    public void testNamedWithoutSemicolon() throws Exception {

        // Only the legacy named references can appear without a semicolon
        testUnescape("&amp", "&");
        testUnescape("&ampx", "&x");
        testUnescape("&amp;x", "&x");
        testUnescape("&lt&gt", "<>");
        testUnescape("&notin", "\u00ACin");
        testUnescape("&notin;", "\u2209");
        testUnescape("&AMP;", "&");

    }




    public HtmlUnescape02Test() {
        super();
    }


}
