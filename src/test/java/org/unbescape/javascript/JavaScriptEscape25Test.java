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
package org.unbescape.javascript;

import org.junit.jupiter.api.Test;

import static org.unbescape.javascript.JavaScriptEscapeTestUtil.testEscape;
import static org.unbescape.javascript.JavaScriptEscapeTestUtil.testUnescape;

/**
 * <p>
 *   U+0000 followed by a digit: the <kbd>&#92;0</kbd> Single Escape Character cannot be used, as it would be read
 *   together with the digit as an octal escape, so U+0000 is escaped as hexadecimal instead.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.8
 *
 */
public class JavaScriptEscape25Test {




    @Test
    public void testFollowedByDigit() throws Exception {

        for (char digit = '0'; digit <= '9'; digit++) {
            final String text = "\u0000" + digit;
            for (final JavaScriptEscapeLevel level : new JavaScriptEscapeLevel[] {
                    JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET,
                    JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET,
                    JavaScriptEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC }) {
                testEscape(text, "\\x00" + digit, JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, level);
                testEscape(text, "\\u0000" + digit, JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, level);
            }
            testUnescape("\\x00" + digit, text);
            testUnescape("\\u0000" + digit, text);
        }

        testEscape("a\u00001b", "a\\x001b",
                JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);

    }




    @Test
    public void testNotFollowedByDigit() throws Exception {

        // Positive controls: the '\0' Single Escape Character is still used when no digit follows
        for (final String[] textAndExpected : new String[][] {
                { "\u0000", "\\0" }, { "\u0000a", "\\0a" }, { "\u0000\u0000", "\\0\\0" }, { "a\u0000 b", "a\\0 b" } }) {
            testEscape(textAndExpected[0], textAndExpected[1],
                    JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
            testEscape(textAndExpected[0], textAndExpected[1],
                    JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
            testUnescape(textAndExpected[1], textAndExpected[0]);
        }

    }




    public JavaScriptEscape25Test() {
        super();
    }


}
