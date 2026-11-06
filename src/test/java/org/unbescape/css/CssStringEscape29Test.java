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
 *   The ampersand (U+0026) is always escaped as a hexadecimal escape, at every escape level and with every escape
 *   type, so that escaped text never contains it.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.8
 *
 */
public class CssStringEscape29Test {


    private static final String[] TEXTS =
            new String[] { "&", "a&b", "&&", "&1", "& ", "x&" };




    @Test
    public void testHexadecimalEscape() throws Exception {

        testEscape("&", "\\26", CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_COMPACT_HEXA, CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("a&b", "a\\26 b", CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_COMPACT_HEXA, CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("&x", "\\26x", CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_COMPACT_HEXA, CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("x&", "x\\26", CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_COMPACT_HEXA, CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);

        testEscape("&", "\\26", CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_COMPACT_HEXA, CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("a&b", "a\\26 b", CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_COMPACT_HEXA, CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("&x", "\\26x", CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_COMPACT_HEXA, CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("x&", "x\\26", CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_COMPACT_HEXA, CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);

        testEscape("&", "\\000026", CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_SIX_DIGIT_HEXA, CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("a&b", "a\\000026b", CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_SIX_DIGIT_HEXA, CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("&x", "\\000026x", CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_SIX_DIGIT_HEXA, CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("x&", "x\\000026", CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_SIX_DIGIT_HEXA, CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);

        testEscape("&", "\\000026", CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_SIX_DIGIT_HEXA, CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("a&b", "a\\000026b", CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_SIX_DIGIT_HEXA, CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("&x", "\\000026x", CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_SIX_DIGIT_HEXA, CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("x&", "x\\000026", CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_SIX_DIGIT_HEXA, CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);

        testEscape("&", "\\26", CssStringEscapeType.COMPACT_HEXA, CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("a&b", "a\\26 b", CssStringEscapeType.COMPACT_HEXA, CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("&x", "\\26x", CssStringEscapeType.COMPACT_HEXA, CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("x&", "x\\26", CssStringEscapeType.COMPACT_HEXA, CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);

        testEscape("&", "\\26", CssStringEscapeType.COMPACT_HEXA, CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("a&b", "a\\26 b", CssStringEscapeType.COMPACT_HEXA, CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("&x", "\\26x", CssStringEscapeType.COMPACT_HEXA, CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("x&", "x\\26", CssStringEscapeType.COMPACT_HEXA, CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);

        testEscape("&", "\\000026", CssStringEscapeType.SIX_DIGIT_HEXA, CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("a&b", "a\\000026b", CssStringEscapeType.SIX_DIGIT_HEXA, CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("&x", "\\000026x", CssStringEscapeType.SIX_DIGIT_HEXA, CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("x&", "x\\000026", CssStringEscapeType.SIX_DIGIT_HEXA, CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);

        testEscape("&", "\\000026", CssStringEscapeType.SIX_DIGIT_HEXA, CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("a&b", "a\\000026b", CssStringEscapeType.SIX_DIGIT_HEXA, CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("&x", "\\000026x", CssStringEscapeType.SIX_DIGIT_HEXA, CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("x&", "x\\000026", CssStringEscapeType.SIX_DIGIT_HEXA, CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);

    }




    @Test
    public void testUnescapeBackslashEscape() throws Exception {

        // The backslash escape is no longer used when escaping, but it is still supported when unescaping
        testUnescape("\\&", "&");
        testUnescape("\\26", "&");
        testUnescape("\\000026", "&");

    }




    @Test
    public void testNeverInEscapedText() throws Exception {

        for (final String[] texts : new String[][] { TEXTS, FacadeTestUtil.COMMON_TEXTS }) {
            for (final String text : texts) {
                for (final CssStringEscapeType type : CssStringEscapeType.values()) {
                    for (final CssStringEscapeLevel level : CssStringEscapeLevel.values()) {

                        final String escaped = CssEscape.escapeCssString(text, type, level);
                        Assertions.assertEquals(-1, escaped.indexOf('&'), "Found '&' in: " + escaped);

                        final StringWriter writer = new StringWriter();
                        CssEscape.escapeCssString(new StringReader(text), writer, type, level);
                        Assertions.assertEquals(escaped, writer.toString());

                    }
                }
            }
        }

    }




    public CssStringEscape29Test() {
        super();
    }


}
