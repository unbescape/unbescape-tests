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

import java.io.StringReader;
import java.io.StringWriter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.unbescape.FacadeTestUtil;

import static org.unbescape.javascript.JavaScriptEscapeTestUtil.testEscape;

/**
 * <p>
 *   The less-than symbol (U+003C) is always escaped, at every escape level and with every escape type, so that
 *   escaped text never contains it.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.8
 *
 */
public class JavaScriptEscape23Test {


    private static final String[] TEXTS =
            new String[] { "<", "a<b", "<<", "</", "<!", "<a", "<A", "< ", "<>", "x<" };




    @Test
    public void testLessThan() throws Exception {

        testEscape("<", "\\x3C", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("a<b", "a\\x3Cb", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("<<", "\\x3C\\x3C", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("</", "\\x3C\\/", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("<!", "\\x3C!", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("<a", "\\x3Ca", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("< ", "\\x3C ", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("x<", "x\\x3C", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);

        testEscape("<", "\\x3C", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("a<b", "a\\x3Cb", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("<<", "\\x3C\\x3C", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("</", "\\x3C\\/", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("<!", "\\x3C!", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("<a", "\\x3Ca", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("< ", "\\x3C ", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("x<", "x\\x3C", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);

        testEscape("<", "\\u003C", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("a<b", "a\\u003Cb", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("<<", "\\u003C\\u003C", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("</", "\\u003C\\/", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("<!", "\\u003C!", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("<a", "\\u003Ca", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("< ", "\\u003C ", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("x<", "x\\u003C", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);

        testEscape("<", "\\u003C", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("a<b", "a\\u003Cb", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("<<", "\\u003C\\u003C", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("</", "\\u003C\\/", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("<!", "\\u003C!", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("<a", "\\u003Ca", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("< ", "\\u003C ", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("x<", "x\\u003C", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);

        testEscape("<", "\\x3C", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("a<b", "a\\x3Cb", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("<<", "\\x3C\\x3C", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("</", "\\x3C\\x2F", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("<!", "\\x3C!", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("<a", "\\x3Ca", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("< ", "\\x3C ", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("x<", "x\\x3C", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);

        testEscape("<", "\\x3C", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("a<b", "a\\x3Cb", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("<<", "\\x3C\\x3C", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("</", "\\x3C\\x2F", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("<!", "\\x3C!", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("<a", "\\x3Ca", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("< ", "\\x3C ", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("x<", "x\\x3C", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);

        testEscape("<", "\\u003C", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("a<b", "a\\u003Cb", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("<<", "\\u003C\\u003C", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("</", "\\u003C\\u002F", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("<!", "\\u003C!", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("<a", "\\u003Ca", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("< ", "\\u003C ", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("x<", "x\\u003C", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);

        testEscape("<", "\\u003C", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("a<b", "a\\u003Cb", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("<<", "\\u003C\\u003C", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("</", "\\u003C\\u002F", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("<!", "\\u003C!", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("<a", "\\u003Ca", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("< ", "\\u003C ", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("x<", "x\\u003C", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);

    }




    @Test
    public void testNeverInEscapedText() throws Exception {

        for (final String[] texts : new String[][] { TEXTS, FacadeTestUtil.COMMON_TEXTS }) {
            for (final String text : texts) {
                for (final JavaScriptEscapeType type : JavaScriptEscapeType.values()) {
                    for (final JavaScriptEscapeLevel level : JavaScriptEscapeLevel.values()) {

                        final String escaped = JavaScriptEscape.escapeJavaScript(text, type, level);
                        Assertions.assertEquals(-1, escaped.indexOf('<'), "Found '<' in: " + escaped);
                        Assertions.assertEquals(text, JavaScriptEscape.unescapeJavaScript(escaped));

                        final StringWriter writer = new StringWriter();
                        JavaScriptEscape.escapeJavaScript(new StringReader(text), writer, type, level);
                        Assertions.assertEquals(escaped, writer.toString());

                    }
                }
            }
        }

    }




    public JavaScriptEscape23Test() {
        super();
    }


}
