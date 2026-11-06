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
package org.unbescape.css;

import org.junit.jupiter.api.Test;

import static org.unbescape.css.CssStringEscapeTestUtil.testUnescape;

/**
 * <p>
 *   Unescape of hexadecimal escapes starting with lowercase and uppercase digits, of an escaped carriage return at
 *   the end of the input, and of high surrogate escapes not followed by a low surrogate escape.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class CssUnescape01Test {




    @Test
    public void testHexaCase() throws Exception {

        testUnescape("\\e1 ", "\u00E1");
        testUnescape("\\E1 ", "\u00E1");
        testUnescape("\\a ", "\n");
        testUnescape("\\A ", "\n");
        testUnescape("\\fa ", "\u00FA");

    }




    @Test
    public void testLineContinuationAtEnd() throws Exception {

        testUnescape("a\\\r", "a");
        testUnescape("a\\\r\n", "a");

    }




    @Test
    public void testHighSurrogateNotPaired() throws Exception {

        testUnescape("\\D840x", "\uFFFDx");
        testUnescape("\\D840\\DBFF", "\uFFFD\uFFFD");
        testUnescape("\\D840\\E000", "\uFFFD\uE000");
        testUnescape("\\D840 \\", "\uFFFD\\");
        testUnescape("\\D840\\ x", "\uFFFD x");
        // Positive control: the highest high surrogate with the highest low surrogate
        testUnescape("\\DBFF\\DFFF", "\uDBFF\uDFFF");

    }




    public CssUnescape01Test() {
        super();
    }


}
