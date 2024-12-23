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
package org.unbescape.javascript;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;

import org.junit.jupiter.api.Assertions;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.0
 *
 */
public class JavaScriptEscapeTestUtil {







    public static void testEscapeSECXHexaUHexa1(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA,
                JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
    }


    public static void testEscapeSECUHexa1(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA,
                JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
    }


    public static void testEscapeXHexaUHexa1(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA,
                JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
    }


    public static void testEscapeUHexa1(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, JavaScriptEscapeType.UHEXA,
                JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
    }




    public static void testEscapeSECXHexaUHexa2(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA,
                JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
    }


    public static void testEscapeSECUHexa2(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA,
                JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
    }


    public static void testEscapeXHexaUHexa2(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA,
                JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
    }


    public static void testEscapeUHexa2(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, JavaScriptEscapeType.UHEXA,
                JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
    }




    public static void testEscapeSECXHexaUHexa3(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA,
                JavaScriptEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC);
    }


    public static void testEscapeSECUHexa3(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA,
                JavaScriptEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC);
    }


    public static void testEscapeXHexaUHexa3(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA,
                JavaScriptEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC);
    }


    public static void testEscapeUHexa3(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, JavaScriptEscapeType.UHEXA,
                JavaScriptEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC);
    }




    public static void testEscapeSECXHexaUHexa4(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA,
                JavaScriptEscapeLevel.LEVEL_4_ALL_CHARACTERS);
    }


    public static void testEscapeSECUHexa4(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA,
                JavaScriptEscapeLevel.LEVEL_4_ALL_CHARACTERS);
    }


    public static void testEscapeXHexaUHexa4(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA,
                JavaScriptEscapeLevel.LEVEL_4_ALL_CHARACTERS);
    }


    public static void testEscapeUHexa4(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, JavaScriptEscapeType.UHEXA,
                JavaScriptEscapeLevel.LEVEL_4_ALL_CHARACTERS);
    }







    public static void testEscape(final String text, final String expected,
                                   final JavaScriptEscapeType type, final JavaScriptEscapeLevel level)
                                   throws IOException {

        final String resultStr = JavaScriptEscapeUtil.escape(text, type, level);
        Assertions.assertEquals(expected, resultStr);
        if (resultStr != null && resultStr.equals(text)) {
            Assertions.assertSame(text, resultStr);
        }

        final char[] textCharArray = (text == null? null : text.toCharArray());
        StringWriter stringWriter = new StringWriter();
        JavaScriptEscapeUtil.escape(textCharArray, 0, (textCharArray == null ? 0 : textCharArray.length), stringWriter, type, level);
        if (textCharArray == null) {
            Assertions.assertEquals("", stringWriter.toString());
        } else {
            Assertions.assertEquals(expected,stringWriter.toString());
        }

        final Reader textReader2 = (text == null? null : new StringReader(text));
        StringWriter stringWriter2 = new StringWriter();
        JavaScriptEscapeUtil.escape(textReader2, stringWriter2, type, level);
        if (textReader2 == null) {
            Assertions.assertEquals("", stringWriter2.toString());
        } else {
            Assertions.assertEquals(expected,stringWriter2.toString());
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
            JavaScriptEscapeUtil.escape(array, i, textCharArray.length, stringWriter, type, level);
            if (textCharArray == null) {
                Assertions.assertEquals("", stringWriter.toString());
            } else {
                Assertions.assertEquals(expected,stringWriter.toString());
            }

        }

    }






    public static void testUnescape(final String text, final String expected)
                                    throws IOException {

        final String resultStr = JavaScriptEscapeUtil.unescape(text);
        Assertions.assertEquals(expected, resultStr);
        if (resultStr != null && resultStr.equals(text)) {
            Assertions.assertSame(text, resultStr);
        }

        final char[] textCharArray = (text == null? null : text.toCharArray());
        StringWriter stringWriter = new StringWriter();
        JavaScriptEscapeUtil.unescape(textCharArray, 0, (textCharArray == null ? 0 : textCharArray.length), stringWriter);
        if (textCharArray == null) {
            Assertions.assertEquals("", stringWriter.toString());
        } else {
            Assertions.assertEquals(expected,stringWriter.toString());
        }

        final Reader textReader2 = (text == null? null : new StringReader(text));
        StringWriter stringWriter2 = new StringWriter();
        JavaScriptEscapeUtil.unescape(textReader2, stringWriter2);
        if (textReader2 == null) {
            Assertions.assertEquals("", stringWriter2.toString());
        } else {
            Assertions.assertEquals(expected,stringWriter2.toString());
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
            JavaScriptEscapeUtil.unescape(array, i, textCharArray.length, stringWriter);
            if (textCharArray == null) {
                Assertions.assertEquals("", stringWriter.toString());
            } else {
                Assertions.assertEquals(expected,stringWriter.toString());
            }

        }

    }





    private JavaScriptEscapeTestUtil() {
        super();
    }


}

