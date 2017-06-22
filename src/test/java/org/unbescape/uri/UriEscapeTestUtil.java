/*
 * =============================================================================
 * 
 *   Copyright (c) 2014-2017, The UNBESCAPE team (http://www.unbescape.org)
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
package org.unbescape.uri;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;

import org.junit.Assert;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.1
 *
 */
public class UriEscapeTestUtil {





    public static void testEscapePath(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, UriEscapeUtil.UriEscapeType.PATH, "UTF-8");
    }

    public static void testUnescapePath(final String text, final String expected)
            throws IOException {
        testUnescape(text, expected, UriEscapeUtil.UriEscapeType.PATH, "UTF-8");
    }


    public static void testEscapePathSegment(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, UriEscapeUtil.UriEscapeType.PATH_SEGMENT, "UTF-8");
    }

    public static void testUnescapePathSegment(final String text, final String expected)
            throws IOException {
        testUnescape(text, expected, UriEscapeUtil.UriEscapeType.PATH_SEGMENT, "UTF-8");
    }


    public static void testEscapeQueryParam(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, UriEscapeUtil.UriEscapeType.QUERY_PARAM, "UTF-8");
    }

    public static void testUnescapeQueryParam(final String text, final String expected)
            throws IOException {
        testUnescape(text, expected, UriEscapeUtil.UriEscapeType.QUERY_PARAM, "UTF-8");
    }


    public static void testEscapeFragmentId(final String text, final String expected)
            throws IOException {
        testEscape(text, expected, UriEscapeUtil.UriEscapeType.FRAGMENT_ID, "UTF-8");
    }

    public static void testUnescapeFragmentId(final String text, final String expected)
            throws IOException {
        testUnescape(text, expected, UriEscapeUtil.UriEscapeType.FRAGMENT_ID, "UTF-8");
    }






    public static void testEscape(final String text, final String expected,
                                   final UriEscapeUtil.UriEscapeType escapeType, final String encoding)
                                   throws IOException {

        final String resultStr = UriEscapeUtil.escape(text, escapeType, encoding);
        Assert.assertEquals(expected, resultStr);
        if (resultStr != null && resultStr.equals(text)) {
            Assert.assertSame(text, resultStr);
        }

        final char[] textCharArray = (text == null? null : text.toCharArray());
        StringWriter stringWriter = new StringWriter();
        UriEscapeUtil.escape(textCharArray, 0, (textCharArray == null ? 0 : textCharArray.length), stringWriter, escapeType, encoding);
        if (textCharArray == null) {
            Assert.assertEquals("", stringWriter.toString());
        } else {
            Assert.assertEquals(expected,stringWriter.toString());
        }

        final Reader textReader2 = (text == null? null : new StringReader(text));
        StringWriter stringWriter2 = new StringWriter();
        UriEscapeUtil.escape(textReader2, stringWriter2, escapeType, encoding);
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
            UriEscapeUtil.escape(array, i, textCharArray.length, stringWriter, escapeType, encoding);
            if (textCharArray == null) {
                Assert.assertEquals("", stringWriter.toString());
            } else {
                Assert.assertEquals(expected,stringWriter.toString());
            }

        }

    }






    public static void testUnescape(final String text, final String expected,
                                    final UriEscapeUtil.UriEscapeType escapeType, final String encoding)
                                    throws IOException {

        final String resultStr = UriEscapeUtil.unescape(text, escapeType, encoding);
        Assert.assertEquals(expected, resultStr);
        if (resultStr != null && resultStr.equals(text)) {
            Assert.assertSame(text, resultStr);
        }

        final char[] textCharArray = (text == null? null : text.toCharArray());
        StringWriter stringWriter = new StringWriter();
        UriEscapeUtil.unescape(textCharArray, 0, (textCharArray == null ? 0 : textCharArray.length), stringWriter, escapeType, encoding);
        if (textCharArray == null) {
            Assert.assertEquals("", stringWriter.toString());
        } else {
            Assert.assertEquals(expected,stringWriter.toString());
        }

        final Reader textReader2 = (text == null? null : new StringReader(text));
        StringWriter stringWriter2 = new StringWriter();
        UriEscapeUtil.unescape(textReader2, stringWriter2, escapeType, encoding);
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
            UriEscapeUtil.unescape(array, i, textCharArray.length, stringWriter, escapeType, encoding);
            if (textCharArray == null) {
                Assert.assertEquals("", stringWriter.toString());
            } else {
                Assert.assertEquals(expected,stringWriter.toString());
            }

        }

    }





    private UriEscapeTestUtil() {
        super();
    }


}

