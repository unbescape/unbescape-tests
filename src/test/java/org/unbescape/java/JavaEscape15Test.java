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

import org.junit.Test;

import static org.unbescape.java.JavaEscapeTestUtil.testUnescape;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.0
 *
 */
public class JavaEscape15Test {


    private static final String TEXT_ESC_1 = "\\u0E1";
    private static final String TEXT_UNESC_1 = "\\u0E1";
    private static final String TEXT_ESC_2 = "\\u0E1o";
    private static final String TEXT_UNESC_2 = "\\u0E1o";
    private static final String TEXT_ESC_3 = "\\x0";
    private static final String TEXT_UNESC_3 = "\\x0";
    private static final String TEXT_ESC_4 = "\\x0o";
    private static final String TEXT_UNESC_4 = "\\x0o";
    private static final String TEXT_ESC_5 = "o\\u0E1";
    private static final String TEXT_UNESC_5 = "o\\u0E1";
    private static final String TEXT_ESC_6 = "o\\u0E1o";
    private static final String TEXT_UNESC_6 = "o\\u0E1o";
    private static final String TEXT_ESC_7 = "o\\x0";
    private static final String TEXT_UNESC_7 = "o\\x0";
    private static final String TEXT_ESC_8 = "o\\x0o";
    private static final String TEXT_UNESC_8 = "o\\x0o";




    @Test
    public void testUnescape01() throws Exception {

        testUnescape(TEXT_ESC_1, TEXT_UNESC_1);
        testUnescape(TEXT_ESC_2, TEXT_UNESC_2);
        testUnescape(TEXT_ESC_3, TEXT_UNESC_3);
        testUnescape(TEXT_ESC_4, TEXT_UNESC_4);
        testUnescape(TEXT_ESC_5, TEXT_UNESC_5);
        testUnescape(TEXT_ESC_6, TEXT_UNESC_6);
        testUnescape(TEXT_ESC_7, TEXT_UNESC_7);
        testUnescape(TEXT_ESC_8, TEXT_UNESC_8);

    }




    public JavaEscape15Test() {
        super();
    }


}

