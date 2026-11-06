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
package org.unbescape.json;

import java.io.StringReader;
import java.io.StringWriter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.unbescape.FacadeTestUtil;

import static org.unbescape.json.JsonEscapeTestUtil.testEscape;

/**
 * <p>
 *   The greater-than symbol (U+003E) is always escaped, at every escape level and with every escape type, so
 *   that escaped text never contains it.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.8
 *
 */
public class JsonEscape19Test {


    private static final String[] TEXTS =
            new String[] { ">", "a>b", ">>", "->", "]]>", "<>", "x>", "> " };




    @Test
    public void testGreaterThan() throws Exception {

        testEscape(">", "\\u003E", JsonEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JsonEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("a>b", "a\\u003Eb", JsonEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JsonEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("->", "-\\u003E", JsonEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JsonEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("]]>", "]]\\u003E", JsonEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JsonEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("x>", "x\\u003E", JsonEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JsonEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);

        testEscape(">", "\\u003E", JsonEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JsonEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("a>b", "a\\u003Eb", JsonEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JsonEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("->", "-\\u003E", JsonEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JsonEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("]]>", "]]\\u003E", JsonEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JsonEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("x>", "x\\u003E", JsonEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JsonEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);

        testEscape(">", "\\u003E", JsonEscapeType.UHEXA, JsonEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("a>b", "a\\u003Eb", JsonEscapeType.UHEXA, JsonEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("->", "-\\u003E", JsonEscapeType.UHEXA, JsonEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("]]>", "]]\\u003E", JsonEscapeType.UHEXA, JsonEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("x>", "x\\u003E", JsonEscapeType.UHEXA, JsonEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);

        testEscape(">", "\\u003E", JsonEscapeType.UHEXA, JsonEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("a>b", "a\\u003Eb", JsonEscapeType.UHEXA, JsonEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("->", "-\\u003E", JsonEscapeType.UHEXA, JsonEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("]]>", "]]\\u003E", JsonEscapeType.UHEXA, JsonEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("x>", "x\\u003E", JsonEscapeType.UHEXA, JsonEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);

    }




    @Test
    public void testNeverInEscapedText() throws Exception {

        for (final String[] texts : new String[][] { TEXTS, FacadeTestUtil.COMMON_TEXTS }) {
            for (final String text : texts) {
                for (final JsonEscapeType type : JsonEscapeType.values()) {
                    for (final JsonEscapeLevel level : JsonEscapeLevel.values()) {

                        final String escaped = JsonEscape.escapeJson(text, type, level);
                        Assertions.assertEquals(-1, escaped.indexOf('>'), "Found '>' in: " + escaped);

                        final StringWriter writer = new StringWriter();
                        JsonEscape.escapeJson(new StringReader(text), writer, type, level);
                        Assertions.assertEquals(escaped, writer.toString());

                    }
                }
            }
        }

    }




    public JsonEscape19Test() {
        super();
    }


}
