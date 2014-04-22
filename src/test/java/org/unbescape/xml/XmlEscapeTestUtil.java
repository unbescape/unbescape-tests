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
package org.unbescape.xml;

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
public class XmlEscapeTestUtil {







    public static void testEscapeXml11Decimal1(final String text, final String expected)
            throws IOException {
        testEscape11(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_DECIMAL,
                XmlEscapeLevel.LEVEL_1_ONLY_MARKUP_SIGNIFICANT);
    }


    public static void testEscapeXml11Hexa1(final String text, final String expected)
            throws IOException {
        testEscape11(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_HEXA,
                XmlEscapeLevel.LEVEL_1_ONLY_MARKUP_SIGNIFICANT);
    }


    public static void testEscapeXml10Decimal1(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_DECIMAL,
                XmlEscapeLevel.LEVEL_1_ONLY_MARKUP_SIGNIFICANT);
    }


    public static void testEscapeXml10Hexa1(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_HEXA,
                XmlEscapeLevel.LEVEL_1_ONLY_MARKUP_SIGNIFICANT);
    }


    public static void testEscapeDecimal1(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.DECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_1_ONLY_MARKUP_SIGNIFICANT);
        testEscape11(text, expected, XmlEscapeType.DECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_1_ONLY_MARKUP_SIGNIFICANT);
    }


    public static void testEscapeHexa1(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.HEXADECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_1_ONLY_MARKUP_SIGNIFICANT);
        testEscape11(text, expected, XmlEscapeType.HEXADECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_1_ONLY_MARKUP_SIGNIFICANT);
    }




    public static void testEscapeXml11Decimal2(final String text, final String expected)
            throws IOException {
        testEscape11(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_DECIMAL,
                XmlEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_MARKUP_SIGNIFICANT);
    }


    public static void testEscapeXml11Hexa2(final String text, final String expected)
            throws IOException {
        testEscape11(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_HEXA,
                XmlEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_MARKUP_SIGNIFICANT);
    }


    public static void testEscapeXml10Decimal2(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_DECIMAL,
                XmlEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_MARKUP_SIGNIFICANT);
    }


    public static void testEscapeXml10Hexa2(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_HEXA,
                XmlEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_MARKUP_SIGNIFICANT);
    }


    public static void testEscapeDecimal2(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.DECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_MARKUP_SIGNIFICANT);
        testEscape11(text, expected, XmlEscapeType.DECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_MARKUP_SIGNIFICANT);
    }


    public static void testEscapeHexa2(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.HEXADECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_MARKUP_SIGNIFICANT);
        testEscape11(text, expected, XmlEscapeType.HEXADECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_MARKUP_SIGNIFICANT);
    }




    public static void testEscapeXml11Decimal3(final String text, final String expected)
            throws IOException {
        testEscape11(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_DECIMAL,
                XmlEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC);
    }


    public static void testEscapeXml11Hexa3(final String text, final String expected)
            throws IOException {
        testEscape11(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_HEXA,
                XmlEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC);
    }


    public static void testEscapeXml10Decimal3(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_DECIMAL,
                XmlEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC);
    }


    public static void testEscapeXml10Hexa3(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_HEXA,
                XmlEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC);
    }


    public static void testEscapeDecimal3(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.DECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC);
        testEscape11(text, expected, XmlEscapeType.DECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC);
    }


    public static void testEscapeHexa3(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.HEXADECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC);
        testEscape11(text, expected, XmlEscapeType.HEXADECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC);
    }




    public static void testEscapeXml11Decimal4(final String text, final String expected)
            throws IOException {
        testEscape11(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_DECIMAL,
                XmlEscapeLevel.LEVEL_4_ALL_CHARACTERS);
    }


    public static void testEscapeXml11Hexa4(final String text, final String expected)
            throws IOException {
        testEscape11(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_HEXA,
                XmlEscapeLevel.LEVEL_4_ALL_CHARACTERS);
    }


    public static void testEscapeXml10Decimal4(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_DECIMAL,
                XmlEscapeLevel.LEVEL_4_ALL_CHARACTERS);
    }


    public static void testEscapeXml10Hexa4(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_HEXA,
                XmlEscapeLevel.LEVEL_4_ALL_CHARACTERS);
    }


    public static void testEscapeDecimal4(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.DECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_4_ALL_CHARACTERS);
        testEscape11(text, expected, XmlEscapeType.DECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_4_ALL_CHARACTERS);
    }


    public static void testEscapeHexa4(final String text, final String expected)
            throws IOException {
        testEscape10(text, expected, XmlEscapeType.HEXADECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_4_ALL_CHARACTERS);
        testEscape11(text, expected, XmlEscapeType.HEXADECIMAL_REFERENCES,
                XmlEscapeLevel.LEVEL_4_ALL_CHARACTERS);
    }







    public static void testEscape11(final String text, final String expected,
                                   final XmlEscapeType type, final XmlEscapeLevel level)
                                   throws IOException {

        final String resultStr = XmlEscape.escapeXml11(text, type, level);
        Assert.assertEquals(expected, resultStr);
        if (resultStr != null && resultStr.equals(text)) {
            Assert.assertSame(text, resultStr);
        }

        final char[] textCharArray = (text == null? null : text.toCharArray());
        StringWriter stringWriter = new StringWriter();
        XmlEscape.escapeXml11(textCharArray, 0, (textCharArray == null ? 0 : textCharArray.length), stringWriter, type, level);
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
            XmlEscape.escapeXml11(array, i, textCharArray.length, stringWriter, type, level);
            if (textCharArray == null) {
                Assert.assertEquals("", stringWriter.toString());
            } else {
                Assert.assertEquals(expected,stringWriter.toString());
            }

        }

    }


    public static void testEscape10(final String text, final String expected,
                                  final XmlEscapeType type, final XmlEscapeLevel level)
            throws IOException {

        final String resultStr = XmlEscape.escapeXml10(text, type, level);
        Assert.assertEquals(expected, resultStr);
        if (resultStr != null && resultStr.equals(text)) {
            Assert.assertSame(text, resultStr);
        }

        final char[] textCharArray = (text == null? null : text.toCharArray());
        StringWriter stringWriter = new StringWriter();
        XmlEscape.escapeXml10(textCharArray, 0, (textCharArray == null ? 0 : textCharArray.length), stringWriter, type, level);
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
            XmlEscape.escapeXml10(array, i, textCharArray.length, stringWriter, type, level);
            if (textCharArray == null) {
                Assert.assertEquals("", stringWriter.toString());
            } else {
                Assert.assertEquals(expected,stringWriter.toString());
            }

        }

    }






    public static void testUnescape(final String text, final String expected)
                                    throws IOException {

        final String resultStr = XmlEscape.unescapeXml(text);
        Assert.assertEquals(expected, resultStr);
        if (resultStr != null && resultStr.equals(text)) {
            Assert.assertSame(text, resultStr);
        }

        final char[] textCharArray = (text == null? null : text.toCharArray());
        StringWriter stringWriter = new StringWriter();
        XmlEscape.unescapeXml(textCharArray, 0, (textCharArray == null ? 0 : textCharArray.length), stringWriter);
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
            XmlEscape.unescapeXml(array, i, textCharArray.length, stringWriter);
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

