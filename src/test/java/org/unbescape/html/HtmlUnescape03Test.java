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
 *   Unescape of numeric character references with values that do not fit in an int: they are out of the
 *   Unicode range (and replaced with U+FFFD as such), and must not wrap around into a valid code point.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class HtmlUnescape03Test {




    @Test
    public void testOutOfRange() throws Exception {

        testUnescape("&#4294967361;", "\uFFFD");
        testUnescape("&#4294967361", "\uFFFD");
        testUnescape("&#x100000041;", "\uFFFD");
        testUnescape("&#x10000000000000041;", "\uFFFD");
        testUnescape("&#18446744073709551681;", "\uFFFD");
        testUnescape("a&#4294967356;b", "a\uFFFDb");

    }




    @Test
    public void testLeadingZeros() throws Exception {

        testUnescape("&#000000000000000000065;", "A");
        testUnescape("&#x000000000000000000041;", "A");

    }




    public HtmlUnescape03Test() {
        super();
    }


}
