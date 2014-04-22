/*
 * =============================================================================
 * 
 *   Copyright (c) 2014, The UNBESCAPE team (http://www.unbescape.org)
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

import java.io.IOException;
import java.io.StringWriter;

import org.junit.Assert;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.0
 *
 */
public class CssStringEscapeTestUtil {







    public static void testEscapeBECompact1(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_COMPACT_HEXA,
                CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
    }


    public static void testEscapeBESixDigit1(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_SIX_DIGIT_HEXA,
                CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
    }


    public static void testEscapeCompact1(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, CssStringEscapeType.COMPACT_HEXA,
                CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
    }


    public static void testEscapeSixDigit1(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, CssStringEscapeType.SIX_DIGIT_HEXA,
                CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
    }




    public static void testEscapeBECompact2(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_COMPACT_HEXA,
                CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
    }


    public static void testEscapeBESixDigit2(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_SIX_DIGIT_HEXA,
                CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
    }


    public static void testEscapeCompact2(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, CssStringEscapeType.COMPACT_HEXA,
                CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
    }


    public static void testEscapeSixDigit2(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, CssStringEscapeType.SIX_DIGIT_HEXA,
                CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
    }




    public static void testEscapeBECompact3(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_COMPACT_HEXA,
                CssStringEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC);
    }


    public static void testEscapeBESixDigit3(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_SIX_DIGIT_HEXA,
                CssStringEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC);
    }


    public static void testEscapeCompact3(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, CssStringEscapeType.COMPACT_HEXA,
                CssStringEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC);
    }


    public static void testEscapeSixDigit3(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, CssStringEscapeType.SIX_DIGIT_HEXA,
                CssStringEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC);
    }




    public static void testEscapeBECompact4(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_COMPACT_HEXA,
                CssStringEscapeLevel.LEVEL_4_ALL_CHARACTERS);
    }


    public static void testEscapeBESixDigit4(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_SIX_DIGIT_HEXA,
                CssStringEscapeLevel.LEVEL_4_ALL_CHARACTERS);
    }


    public static void testEscapeCompact4(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, CssStringEscapeType.COMPACT_HEXA,
                CssStringEscapeLevel.LEVEL_4_ALL_CHARACTERS);
    }


    public static void testEscapeSixDigit4(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, CssStringEscapeType.SIX_DIGIT_HEXA,
                CssStringEscapeLevel.LEVEL_4_ALL_CHARACTERS);
    }







    public static void testEscape(final String text, final String expected,
                                   final CssStringEscapeType type, final CssStringEscapeLevel level)
                                   throws IOException {

        final String resultStr = CssStringEscapeUtil.escape(text, type, level);
        Assert.assertEquals(expected, resultStr);
        if (resultStr != null && resultStr.equals(text)) {
            Assert.assertSame(text, resultStr);
        }

        final char[] textCharArray = (text == null? null : text.toCharArray());
        StringWriter stringWriter = new StringWriter();
        CssStringEscapeUtil.escape(textCharArray, 0, (textCharArray == null ? 0 : textCharArray.length), stringWriter, type, level);
        if (textCharArray == null) {
            Assert.assertEquals("", stringWriter.toString());
        } else {
            Assert.assertEquals(expected,stringWriter.toString());
        }

        if (textCharArray == null) {
            return;
        }

        final char[] fill = "AAAAAAAAAA".toCharArray();
        for (int i = 0; i < 10; i++) {
            final char[] array = new char[fill.length + textCharArray.length];
            if (i > 0) {
                System.arraycopy(fill,0,array,0,i);
            }
            System.arraycopy(textCharArray,0,array,i,textCharArray.length);
            if ((i + 1) < 10) {
                System.arraycopy(fill,i,array,i + textCharArray.length,(10 - (i+1)));
            }

            stringWriter = new StringWriter();
            CssStringEscapeUtil.escape(array, i, textCharArray.length, stringWriter, type, level);
            if (textCharArray == null) {
                Assert.assertEquals("", stringWriter.toString());
            } else {
                Assert.assertEquals(expected,stringWriter.toString());
            }

        }

    }






    public static void testUnescape(final String text, final String expected)
                                    throws IOException {

        final String resultStr = CssUnescapeUtil.unescape(text);
        Assert.assertEquals(expected, resultStr);
        if (resultStr != null && resultStr.equals(text)) {
            Assert.assertSame(text, resultStr);
        }

        final char[] textCharArray = (text == null? null : text.toCharArray());
        StringWriter stringWriter = new StringWriter();
        CssUnescapeUtil.unescape(textCharArray, 0, (textCharArray == null ? 0 : textCharArray.length), stringWriter);
        if (textCharArray == null) {
            Assert.assertEquals("", stringWriter.toString());
        } else {
            Assert.assertEquals(expected,stringWriter.toString());
        }

        if (textCharArray == null) {
            return;
        }

        final char[] fill = "AAAAAAAAAA".toCharArray();
        for (int i = 0; i < 10; i++) {
            final char[] array = new char[fill.length + textCharArray.length];
            if (i > 0) {
                System.arraycopy(fill,0,array,0,i);
            }
            System.arraycopy(textCharArray,0,array,i,textCharArray.length);
            if ((i + 1) < 10) {
                System.arraycopy(fill,i,array,i + textCharArray.length,(10 - (i+1)));
            }

            stringWriter = new StringWriter();
            CssUnescapeUtil.unescape(array, i, textCharArray.length, stringWriter);
            if (textCharArray == null) {
                Assert.assertEquals("", stringWriter.toString());
            } else {
                Assert.assertEquals(expected,stringWriter.toString());
            }

        }

    }





    private CssStringEscapeTestUtil() {
        super();
    }


}

