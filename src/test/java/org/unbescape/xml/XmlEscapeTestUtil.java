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
package org.unbescape.xml;

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
public class XmlEscapeTestUtil {







    public static void testEscapeXml11Decimal1(final String text, final String expected)
            throws IOException {
        testEscape11(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_DECIMAL,
                XmlEscapeLevel.LEVEL_1_ONLY_MARKUP_SIGNIFICANT, false);
    }


    public static void testEscapeXml11Hexa1(final String text, final String expected)
            throws IOException {
        testEscape11(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_HEXA,
                XmlEscapeLevel.LEVEL_1_ONLY_MARKUP_SIGNIFICANT, false);
    }


    public static void testEscapeXml10Decimal1(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_DECIMAL,
                XmlEscapeLevel.LEVEL_1_ONLY_MARKUP_SIGNIFICANT, false);
    }


    public static void testEscapeXml10Hexa1(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_HEXA,
                XmlEscapeLevel.LEVEL_1_ONLY_MARKUP_SIGNIFICANT, false);
    }


    public static void testEscapeDecimal1(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.DECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_1_ONLY_MARKUP_SIGNIFICANT, false);
        testEscape11(text, expected, XmlEscapeType.DECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_1_ONLY_MARKUP_SIGNIFICANT, false);
    }


    public static void testEscapeHexa1(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.HEXADECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_1_ONLY_MARKUP_SIGNIFICANT, false);
        testEscape11(text, expected, XmlEscapeType.HEXADECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_1_ONLY_MARKUP_SIGNIFICANT, false);
    }




    public static void testEscapeXml11AttributeDecimal1(final String text, final String expected)
            throws IOException {
        testEscape11(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_DECIMAL,
                XmlEscapeLevel.LEVEL_1_ONLY_MARKUP_SIGNIFICANT, true);
    }


    public static void testEscapeXml11AttributeHexa1(final String text, final String expected)
            throws IOException {
        testEscape11(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_HEXA,
                XmlEscapeLevel.LEVEL_1_ONLY_MARKUP_SIGNIFICANT, true);
    }


    public static void testEscapeXml10AttributeDecimal1(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_DECIMAL,
                XmlEscapeLevel.LEVEL_1_ONLY_MARKUP_SIGNIFICANT, true);
    }


    public static void testEscapeXml10AttributeHexa1(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_HEXA,
                XmlEscapeLevel.LEVEL_1_ONLY_MARKUP_SIGNIFICANT, true);
    }


    public static void testEscapeAttributeDecimal1(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.DECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_1_ONLY_MARKUP_SIGNIFICANT, true);
        testEscape11(text, expected, XmlEscapeType.DECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_1_ONLY_MARKUP_SIGNIFICANT, true);
    }


    public static void testEscapeAttributeHexa1(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.HEXADECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_1_ONLY_MARKUP_SIGNIFICANT, true);
        testEscape11(text, expected, XmlEscapeType.HEXADECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_1_ONLY_MARKUP_SIGNIFICANT, true);
    }




    public static void testEscapeXml11Decimal2(final String text, final String expected)
            throws IOException {
        testEscape11(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_DECIMAL,
                XmlEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_MARKUP_SIGNIFICANT, false);
    }


    public static void testEscapeXml11Hexa2(final String text, final String expected)
            throws IOException {
        testEscape11(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_HEXA,
                XmlEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_MARKUP_SIGNIFICANT, false);
    }


    public static void testEscapeXml10Decimal2(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_DECIMAL,
                XmlEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_MARKUP_SIGNIFICANT, false);
    }


    public static void testEscapeXml10Hexa2(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_HEXA,
                XmlEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_MARKUP_SIGNIFICANT, false);
    }


    public static void testEscapeDecimal2(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.DECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_MARKUP_SIGNIFICANT, false);
        testEscape11(text, expected, XmlEscapeType.DECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_MARKUP_SIGNIFICANT, false);
    }


    public static void testEscapeHexa2(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.HEXADECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_MARKUP_SIGNIFICANT, false);
        testEscape11(text, expected, XmlEscapeType.HEXADECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_MARKUP_SIGNIFICANT, false);
    }


    public static void testEscapeXml11AttributeDecimal2(final String text, final String expected)
            throws IOException {
        testEscape11(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_DECIMAL,
                XmlEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_MARKUP_SIGNIFICANT, true);
    }


    public static void testEscapeXml11AttributeHexa2(final String text, final String expected)
            throws IOException {
        testEscape11(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_HEXA,
                XmlEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_MARKUP_SIGNIFICANT, true);
    }


    public static void testEscapeXml10AttributeDecimal2(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_DECIMAL,
                XmlEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_MARKUP_SIGNIFICANT, true);
    }


    public static void testEscapeXml10AttributeHexa2(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_HEXA,
                XmlEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_MARKUP_SIGNIFICANT, true);
    }


    public static void testEscapeAttributeDecimal2(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.DECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_MARKUP_SIGNIFICANT, true);
        testEscape11(text, expected, XmlEscapeType.DECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_MARKUP_SIGNIFICANT, true);
    }


    public static void testEscapeAttributeHexa2(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.HEXADECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_MARKUP_SIGNIFICANT, true);
        testEscape11(text, expected, XmlEscapeType.HEXADECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_MARKUP_SIGNIFICANT, true);
    }


    /*
     * For levels 3 and up, we will perform the same test for content and attributes because \t,\n,\r would
     * be escaped anyway.
     */


    public static void testEscapeXml11Decimal3(final String text, final String expected)
            throws IOException {
        testEscape11(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_DECIMAL,
                XmlEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC, false);
        testEscape11(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_DECIMAL,
                XmlEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC, true);
    }


    public static void testEscapeXml11Hexa3(final String text, final String expected)
            throws IOException {
        testEscape11(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_HEXA,
                XmlEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC, false);
        testEscape11(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_HEXA,
                XmlEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC, true);
    }


    public static void testEscapeXml10Decimal3(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_DECIMAL,
                XmlEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC, false);
        testEscape10(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_DECIMAL,
                XmlEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC, true);
    }


    public static void testEscapeXml10Hexa3(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_HEXA,
                XmlEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC, false);
        testEscape10(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_HEXA,
                XmlEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC, true);
    }


    public static void testEscapeDecimal3(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.DECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC, false);
        testEscape11(text, expected, XmlEscapeType.DECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC, false);
        testEscape10(text, expected, XmlEscapeType.DECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC, true);
        testEscape11(text, expected, XmlEscapeType.DECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC, true);
    }


    public static void testEscapeHexa3(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.HEXADECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC, false);
        testEscape11(text, expected, XmlEscapeType.HEXADECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC, false);
        testEscape10(text, expected, XmlEscapeType.HEXADECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC, true);
        testEscape11(text, expected, XmlEscapeType.HEXADECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC, true);
    }




    public static void testEscapeXml11Decimal4(final String text, final String expected)
            throws IOException {
        testEscape11(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_DECIMAL,
                XmlEscapeLevel.LEVEL_4_ALL_CHARACTERS, false);
        testEscape11(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_DECIMAL,
                XmlEscapeLevel.LEVEL_4_ALL_CHARACTERS, true);
    }


    public static void testEscapeXml11Hexa4(final String text, final String expected)
            throws IOException {
        testEscape11(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_HEXA,
                XmlEscapeLevel.LEVEL_4_ALL_CHARACTERS, false);
        testEscape11(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_HEXA,
                XmlEscapeLevel.LEVEL_4_ALL_CHARACTERS, true);
    }


    public static void testEscapeXml10Decimal4(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_DECIMAL,
                XmlEscapeLevel.LEVEL_4_ALL_CHARACTERS, false);
        testEscape10(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_DECIMAL,
                XmlEscapeLevel.LEVEL_4_ALL_CHARACTERS, true);
    }


    public static void testEscapeXml10Hexa4(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_HEXA,
                XmlEscapeLevel.LEVEL_4_ALL_CHARACTERS, false);
        testEscape10(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_HEXA,
                XmlEscapeLevel.LEVEL_4_ALL_CHARACTERS, true);
    }


    public static void testEscapeDecimal4(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.DECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_4_ALL_CHARACTERS, false);
        testEscape11(text, expected, XmlEscapeType.DECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_4_ALL_CHARACTERS, false);
        testEscape10(text, expected, XmlEscapeType.DECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_4_ALL_CHARACTERS, true);
        testEscape11(text, expected, XmlEscapeType.DECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_4_ALL_CHARACTERS, true);
    }


    public static void testEscapeHexa4(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.HEXADECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_4_ALL_CHARACTERS, false);
        testEscape11(text, expected, XmlEscapeType.HEXADECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_4_ALL_CHARACTERS, false);
        testEscape10(text, expected, XmlEscapeType.HEXADECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_4_ALL_CHARACTERS, true);
        testEscape11(text, expected, XmlEscapeType.HEXADECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_4_ALL_CHARACTERS, true);
    }







    public static void testEscape11(final String text, final String expected,
                                    final XmlEscapeType type, final XmlEscapeLevel level,
                                    final boolean attributes)
                                    throws IOException {

        XmlEscapeSymbols symbols = (attributes? XmlEscapeSymbols.XML11_ATTRIBUTE_SYMBOLS : XmlEscapeSymbols.XML11_SYMBOLS);

        final String resultStr = XmlEscapeUtil.escape(text, symbols, type, level);
        Assert.assertEquals(expected, resultStr);
        if (resultStr != null && resultStr.equals(text)) {
            Assert.assertSame(text, resultStr);
        }

        final char[] textCharArray = (text == null? null : text.toCharArray());
        StringWriter stringWriter = new StringWriter();
        XmlEscapeUtil.escape(textCharArray, 0, (textCharArray == null ? 0 : textCharArray.length), stringWriter, symbols, type, level);
        if (textCharArray == null) {
            Assert.assertEquals("", stringWriter.toString());
        } else {
            Assert.assertEquals(expected,stringWriter.toString());
        }

        final Reader textReader2 = (text == null? null : new StringReader(text));
        StringWriter stringWriter2 = new StringWriter();
        XmlEscapeUtil.escape(textReader2, stringWriter2, symbols, type, level);
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
            XmlEscapeUtil.escape(array, i, textCharArray.length, stringWriter, symbols, type, level);
            if (textCharArray == null) {
                Assert.assertEquals("", stringWriter.toString());
            } else {
                Assert.assertEquals(expected,stringWriter.toString());
            }

        }

    }


    public static void testEscape10(final String text, final String expected,
                                    final XmlEscapeType type, final XmlEscapeLevel level,
                                    final boolean attributes)
                                    throws IOException {

        XmlEscapeSymbols symbols = (attributes? XmlEscapeSymbols.XML10_ATTRIBUTE_SYMBOLS : XmlEscapeSymbols.XML10_SYMBOLS);

        final String resultStr = XmlEscapeUtil.escape(text, symbols, type, level);
        Assert.assertEquals(expected, resultStr);
        if (resultStr != null && resultStr.equals(text)) {
            Assert.assertSame(text, resultStr);
        }

        final char[] textCharArray = (text == null? null : text.toCharArray());
        StringWriter stringWriter = new StringWriter();
        XmlEscapeUtil.escape(textCharArray, 0, (textCharArray == null ? 0 : textCharArray.length), stringWriter, symbols, type, level);
        if (textCharArray == null) {
            Assert.assertEquals("", stringWriter.toString());
        } else {
            Assert.assertEquals(expected,stringWriter.toString());
        }

        final Reader textReader2 = (text == null? null : new StringReader(text));
        StringWriter stringWriter2 = new StringWriter();
        XmlEscapeUtil.escape(textReader2, stringWriter2, symbols, type, level);
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
            XmlEscapeUtil.escape(array, i, textCharArray.length, stringWriter, symbols, type, level);
            if (textCharArray == null) {
                Assert.assertEquals("", stringWriter.toString());
            } else {
                Assert.assertEquals(expected,stringWriter.toString());
            }

        }

    }






    public static void testUnescape(final String text, final String expected)
                                    throws IOException {

        final String resultStr = XmlEscapeUtil.unescape(text, XmlEscapeSymbols.XML11_SYMBOLS);
        Assert.assertEquals(expected, resultStr);
        if (resultStr != null && resultStr.equals(text)) {
            Assert.assertSame(text, resultStr);
        }

        final char[] textCharArray = (text == null? null : text.toCharArray());
        StringWriter stringWriter = new StringWriter();
        XmlEscapeUtil.unescape(textCharArray, 0, (textCharArray == null ? 0 : textCharArray.length), stringWriter, XmlEscapeSymbols.XML11_SYMBOLS);
        if (textCharArray == null) {
            Assert.assertEquals("", stringWriter.toString());
        } else {
            Assert.assertEquals(expected,stringWriter.toString());
        }

        final Reader textReader2 = (text == null? null : new StringReader(text));
        StringWriter stringWriter2 = new StringWriter();
        XmlEscapeUtil.unescape(textReader2, stringWriter2, XmlEscapeSymbols.XML11_SYMBOLS);
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
            XmlEscapeUtil.unescape(array, i, textCharArray.length, stringWriter, XmlEscapeSymbols.XML11_SYMBOLS);
            if (textCharArray == null) {
                Assert.assertEquals("", stringWriter.toString());
            } else {
                Assert.assertEquals(expected,stringWriter.toString());
            }

        }

    }





    private XmlEscapeTestUtil() {
        super();
    }


}

