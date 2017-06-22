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
package org.unbescape.java;

import java.util.Arrays;

import org.junit.Test;

import static org.unbescape.java.JavaEscapeTestUtil.testUnescape;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.0
 *
 */
public class JavaEscape18Test {


    /*
     * These are unicode-escaped octal escapes.
     */
    private static final String TEXT_ESC_1 = "\\u005c\\u0033\\u0034\\u0031";
    private static final String TEXT_UNESC_1 = "\u00E1";
    private static final String TEXT_ESC_2 = "a\\u005c\\u0033\\u0034\\u0031a";
    private static final String TEXT_UNESC_2 = "a\u00E1a";
    private static final String TEXT_ESC_3 = "aaaaaaa\\u005c\\u0033\\u0034\\u0031aaaaaa";
    private static final String TEXT_UNESC_3 = "aaaaaaa\u00E1aaaaaa";
    private static final String TEXT_ESC_4 = "\\u005c341";
    private static final String TEXT_UNESC_4 = "\u00E1";




    @Test
    public void testUnescape01() throws Exception {

        testUnescape(TEXT_ESC_1, TEXT_UNESC_1);
        testUnescape(TEXT_ESC_2, TEXT_UNESC_2);
        testUnescape(TEXT_ESC_3, TEXT_UNESC_3);
        testUnescape(TEXT_ESC_4, TEXT_UNESC_4);

        for (int i = 0; i < 100; i++) {
            final String pad = pad(i);
            testUnescape(pad + TEXT_ESC_1, pad + TEXT_UNESC_1);
            testUnescape(TEXT_ESC_1 + pad, TEXT_UNESC_1 + pad);
            testUnescape(pad + TEXT_ESC_1 + pad, pad + TEXT_UNESC_1 + pad);
            testUnescape(pad + TEXT_ESC_1 + TEXT_ESC_1, pad + TEXT_UNESC_1 + TEXT_UNESC_1);
            testUnescape(TEXT_ESC_1 + TEXT_ESC_1 + pad, TEXT_UNESC_1 + TEXT_UNESC_1 + pad);
            testUnescape(pad + TEXT_ESC_1 + TEXT_ESC_1 + pad, pad + TEXT_UNESC_1 + TEXT_UNESC_1 + pad);
            testUnescape(pad + TEXT_ESC_1 + pad + TEXT_ESC_1, pad + TEXT_UNESC_1 + pad + TEXT_UNESC_1);
            testUnescape(TEXT_ESC_1 + pad + TEXT_ESC_1 + pad, TEXT_UNESC_1 + pad + TEXT_UNESC_1 + pad);
            testUnescape(pad + TEXT_ESC_1 + pad + TEXT_ESC_1 + pad, pad + TEXT_UNESC_1 + pad + TEXT_UNESC_1 + pad);
            testUnescape(TEXT_ESC_1 + pad + TEXT_ESC_1, TEXT_UNESC_1 + pad + TEXT_UNESC_1);
            testUnescape(TEXT_ESC_1 + TEXT_ESC_1, TEXT_UNESC_1 + TEXT_UNESC_1);
        }

        for (int i = 0; i < 100; i++) {
            final String pad = pad(i);
            testUnescape(pad + TEXT_ESC_4, pad + TEXT_UNESC_4);
            testUnescape(TEXT_ESC_4 + pad, TEXT_UNESC_4 + pad);
            testUnescape(pad + TEXT_ESC_4 + pad, pad + TEXT_UNESC_4 + pad);
            testUnescape(pad + TEXT_ESC_4 + TEXT_ESC_4, pad + TEXT_UNESC_4 + TEXT_UNESC_4);
            testUnescape(TEXT_ESC_4 + TEXT_ESC_4 + pad, TEXT_UNESC_4 + TEXT_UNESC_4 + pad);
            testUnescape(pad + TEXT_ESC_4 + TEXT_ESC_4 + pad, pad + TEXT_UNESC_4 + TEXT_UNESC_4 + pad);
            testUnescape(pad + TEXT_ESC_4 + pad + TEXT_ESC_4, pad + TEXT_UNESC_4 + pad + TEXT_UNESC_4);
            testUnescape(TEXT_ESC_4 + pad + TEXT_ESC_4 + pad, TEXT_UNESC_4 + pad + TEXT_UNESC_4 + pad);
            testUnescape(pad + TEXT_ESC_4 + pad + TEXT_ESC_4 + pad, pad + TEXT_UNESC_4 + pad + TEXT_UNESC_4 + pad);
            testUnescape(TEXT_ESC_4 + pad + TEXT_ESC_4, TEXT_UNESC_4 + pad + TEXT_UNESC_4);
            testUnescape(TEXT_ESC_4 + TEXT_ESC_4, TEXT_UNESC_4 + TEXT_UNESC_4);
        }

    }


    private static String pad(final int i) {
        final char[] pad = new char[i];
        Arrays.fill(pad, '.');
        return new String(pad);
    }



    public JavaEscape18Test() {
        super();
    }


}

