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
package org.unbescape.csv;

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
public class CsvEscapeTestUtil {






    public static void testEscape(final String text, final String expected)
                                   throws IOException {

        final String resultStr = CsvEscapeUtil.escape(text);
        Assert.assertEquals(expected, resultStr);
        if (resultStr != null && resultStr.equals(text)) {
            Assert.assertSame(text, resultStr);
        }

        final char[] textCharArray = (text == null? null : text.toCharArray());
        StringWriter stringWriter = new StringWriter();
        CsvEscapeUtil.escape(textCharArray, 0, (textCharArray == null ? 0 : textCharArray.length), stringWriter);
        if (textCharArray == null) {
            Assert.assertEquals("", stringWriter.toString());
        } else {
            Assert.assertEquals(expected,stringWriter.toString());
        }

        final Reader textReader2 = (text == null? null : new StringReader(text));
        StringWriter stringWriter2 = new StringWriter();
        CsvEscapeUtil.escape(textReader2, stringWriter2);
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
            CsvEscapeUtil.escape(array, i, textCharArray.length, stringWriter);
            if (textCharArray == null) {
                Assert.assertEquals("", stringWriter.toString());
            } else {
                Assert.assertEquals(expected,stringWriter.toString());
            }

        }

    }






    public static void testUnescape(final String text, final String expected)
                                    throws IOException {

        final String resultStr = CsvEscapeUtil.unescape(text);
        Assert.assertEquals(expected, resultStr);
        if (resultStr != null && resultStr.equals(text)) {
            Assert.assertSame(text, resultStr);
        }

        final char[] textCharArray = (text == null? null : text.toCharArray());
        StringWriter stringWriter = new StringWriter();
        CsvEscapeUtil.unescape(textCharArray, 0, (textCharArray == null ? 0 : textCharArray.length), stringWriter);
        if (textCharArray == null) {
            Assert.assertEquals("", stringWriter.toString());
        } else {
            Assert.assertEquals(expected,stringWriter.toString());
        }

        final Reader textReader2 = (text == null? null : new StringReader(text));
        StringWriter stringWriter2 = new StringWriter();
        CsvEscapeUtil.unescape(textReader2, stringWriter2);
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
            CsvEscapeUtil.unescape(array, i, textCharArray.length, stringWriter);
            if (textCharArray == null) {
                Assert.assertEquals("", stringWriter.toString());
            } else {
                Assert.assertEquals(expected,stringWriter.toString());
            }

        }

    }





    private CsvEscapeTestUtil() {
        super();
    }


}

