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

import java.io.StringReader;
import java.io.StringWriter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.unbescape.FacadeTestUtil;

import static org.unbescape.css.CssStringEscapeTestUtil.testEscape;
import static org.unbescape.css.CssStringEscapeTestUtil.testUnescape;

/**
 * <p>
 *   The less-than symbol (U+003C) is always escaped as a hexadecimal escape, at every escape level and with every
 *   escape type, so that escaped text never contains it. Unescape still supports the <kbd>&#92;&lt;</kbd> backslash
 *   escape.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.8
 *
 */
public class CssStringEscape27Test {


    private static final String[] TEXTS =
            new String[] { "<", "a<b", "<<", "</", "<!", "<a", "<1", "< ", "<>", "x<" };




    @Test
    public void testLessThan() throws Exception {

        testEscape("a<b", "a\\3C b", CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_COMPACT_HEXA, CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("<", "\\3C", CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_COMPACT_HEXA, CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("<x", "\\3Cx", CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_COMPACT_HEXA, CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("x<", "x\\3C", CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_COMPACT_HEXA, CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);

        testEscape("a<b", "a\\3C b", CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_COMPACT_HEXA, CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("<", "\\3C", CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_COMPACT_HEXA, CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("<x", "\\3Cx", CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_COMPACT_HEXA, CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("x<", "x\\3C", CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_COMPACT_HEXA, CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);

        testEscape("a<b", "a\\00003Cb", CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_SIX_DIGIT_HEXA, CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("<", "\\00003C", CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_SIX_DIGIT_HEXA, CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("<x", "\\00003Cx", CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_SIX_DIGIT_HEXA, CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("x<", "x\\00003C", CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_SIX_DIGIT_HEXA, CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);

        testEscape("a<b", "a\\00003Cb", CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_SIX_DIGIT_HEXA, CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("<", "\\00003C", CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_SIX_DIGIT_HEXA, CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("<x", "\\00003Cx", CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_SIX_DIGIT_HEXA, CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("x<", "x\\00003C", CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_SIX_DIGIT_HEXA, CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);

        testEscape("a<b", "a\\3C b", CssStringEscapeType.COMPACT_HEXA, CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("<", "\\3C", CssStringEscapeType.COMPACT_HEXA, CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("<x", "\\3Cx", CssStringEscapeType.COMPACT_HEXA, CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("x<", "x\\3C", CssStringEscapeType.COMPACT_HEXA, CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);

        testEscape("a<b", "a\\3C b", CssStringEscapeType.COMPACT_HEXA, CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("<", "\\3C", CssStringEscapeType.COMPACT_HEXA, CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("<x", "\\3Cx", CssStringEscapeType.COMPACT_HEXA, CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("x<", "x\\3C", CssStringEscapeType.COMPACT_HEXA, CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);

        testEscape("a<b", "a\\00003Cb", CssStringEscapeType.SIX_DIGIT_HEXA, CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("<", "\\00003C", CssStringEscapeType.SIX_DIGIT_HEXA, CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("<x", "\\00003Cx", CssStringEscapeType.SIX_DIGIT_HEXA, CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("x<", "x\\00003C", CssStringEscapeType.SIX_DIGIT_HEXA, CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);

        testEscape("a<b", "a\\00003Cb", CssStringEscapeType.SIX_DIGIT_HEXA, CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("<", "\\00003C", CssStringEscapeType.SIX_DIGIT_HEXA, CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("<x", "\\00003Cx", CssStringEscapeType.SIX_DIGIT_HEXA, CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("x<", "x\\00003C", CssStringEscapeType.SIX_DIGIT_HEXA, CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);

    }




    @Test
    public void testUnescapeLessThan() throws Exception {

        testUnescape("\\<", "<");
        testUnescape("a\\<b", "a<b");
        testUnescape("\\3C", "<");
        testUnescape("\\00003C", "<");

    }




    @Test
    public void testNeverInEscapedText() throws Exception {

        for (final String[] texts : new String[][] { TEXTS, FacadeTestUtil.COMMON_TEXTS }) {
            for (final String text : texts) {
                for (final CssStringEscapeType type : CssStringEscapeType.values()) {
                    for (final CssStringEscapeLevel level : CssStringEscapeLevel.values()) {

                        final String escaped = CssEscape.escapeCssString(text, type, level);
                        Assertions.assertEquals(-1, escaped.indexOf('<'), "Found '<' in: " + escaped);

                        final StringWriter writer = new StringWriter();
                        CssEscape.escapeCssString(new StringReader(text), writer, type, level);
                        Assertions.assertEquals(escaped, writer.toString());

                    }
                }
            }
        }

    }




    public CssStringEscape27Test() {
        super();
    }


}
