/*
 * =============================================================================
 * 
 *   Copyright (c) 2014-2025 Unbescape (http://www.unbescape.org)
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

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;

import org.junit.Assert;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.0
 *
 */
public class HtmlEscapeTestUtil {







    public static void testEscapeHtml5Decimal0(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, HtmlEscapeType.HTML5_NAMED_REFERENCES_DEFAULT_TO_DECIMAL,
                HtmlEscapeLevel.LEVEL_0_ONLY_MARKUP_SIGNIFICANT_EXCEPT_APOS);
    }


    public static void testEscapeHtml5Hexa0(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, HtmlEscapeType.HTML5_NAMED_REFERENCES_DEFAULT_TO_HEXA,
                HtmlEscapeLevel.LEVEL_0_ONLY_MARKUP_SIGNIFICANT_EXCEPT_APOS);
    }


    public static void testEscapeHtml4Decimal0(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, HtmlEscapeType.HTML4_NAMED_REFERENCES_DEFAULT_TO_DECIMAL,
                HtmlEscapeLevel.LEVEL_0_ONLY_MARKUP_SIGNIFICANT_EXCEPT_APOS);
    }


    public static void testEscapeHtml4Hexa0(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, HtmlEscapeType.HTML4_NAMED_REFERENCES_DEFAULT_TO_HEXA,
                HtmlEscapeLevel.LEVEL_0_ONLY_MARKUP_SIGNIFICANT_EXCEPT_APOS);
    }


    public static void testEscapeDecimal0(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, HtmlEscapeType.DECIMAL_REFERENCES,
                HtmlEscapeLevel.LEVEL_0_ONLY_MARKUP_SIGNIFICANT_EXCEPT_APOS);
    }


    public static void testEscapeHexa0(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, HtmlEscapeType.HEXADECIMAL_REFERENCES,
                HtmlEscapeLevel.LEVEL_0_ONLY_MARKUP_SIGNIFICANT_EXCEPT_APOS);
    }




    public static void testEscapeHtml5Decimal1(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, HtmlEscapeType.HTML5_NAMED_REFERENCES_DEFAULT_TO_DECIMAL,
                HtmlEscapeLevel.LEVEL_1_ONLY_MARKUP_SIGNIFICANT);
    }


    public static void testEscapeHtml5Hexa1(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, HtmlEscapeType.HTML5_NAMED_REFERENCES_DEFAULT_TO_HEXA,
                HtmlEscapeLevel.LEVEL_1_ONLY_MARKUP_SIGNIFICANT);
    }


    public static void testEscapeHtml4Decimal1(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, HtmlEscapeType.HTML4_NAMED_REFERENCES_DEFAULT_TO_DECIMAL,
                HtmlEscapeLevel.LEVEL_1_ONLY_MARKUP_SIGNIFICANT);
    }


    public static void testEscapeHtml4Hexa1(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, HtmlEscapeType.HTML4_NAMED_REFERENCES_DEFAULT_TO_HEXA,
                HtmlEscapeLevel.LEVEL_1_ONLY_MARKUP_SIGNIFICANT);
    }


    public static void testEscapeDecimal1(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, HtmlEscapeType.DECIMAL_REFERENCES,
                HtmlEscapeLevel.LEVEL_1_ONLY_MARKUP_SIGNIFICANT);
    }


    public static void testEscapeHexa1(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, HtmlEscapeType.HEXADECIMAL_REFERENCES,
                HtmlEscapeLevel.LEVEL_1_ONLY_MARKUP_SIGNIFICANT);
    }




    public static void testEscapeHtml5Decimal2(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, HtmlEscapeType.HTML5_NAMED_REFERENCES_DEFAULT_TO_DECIMAL,
                HtmlEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_MARKUP_SIGNIFICANT);
    }


    public static void testEscapeHtml5Hexa2(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, HtmlEscapeType.HTML5_NAMED_REFERENCES_DEFAULT_TO_HEXA,
                HtmlEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_MARKUP_SIGNIFICANT);
    }


    public static void testEscapeHtml4Decimal2(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, HtmlEscapeType.HTML4_NAMED_REFERENCES_DEFAULT_TO_DECIMAL,
                HtmlEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_MARKUP_SIGNIFICANT);
    }


    public static void testEscapeHtml4Hexa2(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, HtmlEscapeType.HTML4_NAMED_REFERENCES_DEFAULT_TO_HEXA,
                HtmlEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_MARKUP_SIGNIFICANT);
    }


    public static void testEscapeDecimal2(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, HtmlEscapeType.DECIMAL_REFERENCES,
                HtmlEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_MARKUP_SIGNIFICANT);
    }


    public static void testEscapeHexa2(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, HtmlEscapeType.HEXADECIMAL_REFERENCES,
                HtmlEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_MARKUP_SIGNIFICANT);
    }




    public static void testEscapeHtml5Decimal3(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, HtmlEscapeType.HTML5_NAMED_REFERENCES_DEFAULT_TO_DECIMAL,
                HtmlEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC);
    }


    public static void testEscapeHtml5Hexa3(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, HtmlEscapeType.HTML5_NAMED_REFERENCES_DEFAULT_TO_HEXA,
                HtmlEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC);
    }


    public static void testEscapeHtml4Decimal3(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, HtmlEscapeType.HTML4_NAMED_REFERENCES_DEFAULT_TO_DECIMAL,
                HtmlEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC);
    }


    public static void testEscapeHtml4Hexa3(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, HtmlEscapeType.HTML4_NAMED_REFERENCES_DEFAULT_TO_HEXA,
                HtmlEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC);
    }


    public static void testEscapeDecimal3(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, HtmlEscapeType.DECIMAL_REFERENCES,
                HtmlEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC);
    }


    public static void testEscapeHexa3(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, HtmlEscapeType.HEXADECIMAL_REFERENCES,
                HtmlEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC);
    }




    public static void testEscapeHtml5Decimal4(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, HtmlEscapeType.HTML5_NAMED_REFERENCES_DEFAULT_TO_DECIMAL,
                HtmlEscapeLevel.LEVEL_4_ALL_CHARACTERS);
    }


    public static void testEscapeHtml5Hexa4(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, HtmlEscapeType.HTML5_NAMED_REFERENCES_DEFAULT_TO_HEXA,
                HtmlEscapeLevel.LEVEL_4_ALL_CHARACTERS);
    }


    public static void testEscapeHtml4Decimal4(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, HtmlEscapeType.HTML4_NAMED_REFERENCES_DEFAULT_TO_DECIMAL,
                HtmlEscapeLevel.LEVEL_4_ALL_CHARACTERS);
    }


    public static void testEscapeHtml4Hexa4(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, HtmlEscapeType.HTML4_NAMED_REFERENCES_DEFAULT_TO_HEXA,
                HtmlEscapeLevel.LEVEL_4_ALL_CHARACTERS);
    }


    public static void testEscapeDecimal4(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, HtmlEscapeType.DECIMAL_REFERENCES,
                HtmlEscapeLevel.LEVEL_4_ALL_CHARACTERS);
    }


    public static void testEscapeHexa4(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, HtmlEscapeType.HEXADECIMAL_REFERENCES,
                HtmlEscapeLevel.LEVEL_4_ALL_CHARACTERS);
    }







    public static void testEscape(final String text, final String expected,
                                   final HtmlEscapeType type, final HtmlEscapeLevel level)
                                   throws IOException {

        final String resultStr = HtmlEscapeUtil.escape(text, type, level);
        Assert.assertEquals(expected, resultStr);
        if (resultStr != null && resultStr.equals(text)) {
            Assert.assertSame(text, resultStr);
        }

        final char[] textCharArray = (text == null? null : text.toCharArray());
        StringWriter stringWriter = new StringWriter();
        HtmlEscapeUtil.escape(textCharArray, 0, (textCharArray == null? 0 : textCharArray.length), stringWriter, type, level);
        if (textCharArray == null) {
            Assert.assertEquals("", stringWriter.toString());
        } else {
            Assert.assertEquals(expected,stringWriter.toString());
        }

        final Reader textReader2 = (text == null? null : new StringReader(text));
        StringWriter stringWriter2 = new StringWriter();
        HtmlEscapeUtil.escape(textReader2, stringWriter2, type, level);
        if (textReader2 == null) {
            Assert.assertEquals("", stringWriter2.toString());
        } else {
            Assert.assertEquals(expected,stringWriter2.toString());
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
            HtmlEscapeUtil.escape(array, i, textCharArray.length, stringWriter, type, level);
            if (textCharArray == null) {
                Assert.assertEquals("", stringWriter.toString());
            } else {
                Assert.assertEquals(expected,stringWriter.toString());
            }

        }

    }






    public static void testUnescape(final String text, final String expected)
            throws IOException {

        final String resultStr = HtmlEscapeUtil.unescape(text);
        Assert.assertEquals(expected, resultStr);
        if (resultStr != null && resultStr.equals(text)) {
            Assert.assertSame(text, resultStr);
        }

        final char[] textCharArray = (text == null? null : text.toCharArray());
        StringWriter stringWriter = new StringWriter();
        HtmlEscapeUtil.unescape(textCharArray, 0, (textCharArray == null? 0 : textCharArray.length), stringWriter);
        if (textCharArray == null) {
            Assert.assertEquals("", stringWriter.toString());
        } else {
            Assert.assertEquals(expected,stringWriter.toString());
        }

        final Reader textReader2 = (text == null? null : new StringReader(text));
        StringWriter stringWriter2 = new StringWriter();
        HtmlEscapeUtil.unescape(textReader2, stringWriter2);
        if (textReader2 == null) {
            Assert.assertEquals("", stringWriter2.toString());
        } else {
            Assert.assertEquals(expected,stringWriter2.toString());
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
            HtmlEscapeUtil.unescape(array, i, textCharArray.length, stringWriter);
            if (textCharArray == null) {
                Assert.assertEquals("", stringWriter.toString());
            } else {
                Assert.assertEquals(expected,stringWriter.toString());
            }

        }

    }




    private HtmlEscapeTestUtil() {
        super();
    }


}

