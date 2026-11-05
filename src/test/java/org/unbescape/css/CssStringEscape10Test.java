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

import org.junit.jupiter.api.Test;

import static org.unbescape.css.CssStringEscapeTestUtil.testUnescape;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.0
 *
 */
public class CssStringEscape10Test {


    private static final String TEXT_ESC_1 = "\\00";
    private static final String TEXT_UNESC_1 = "\uFFFD";
    private static final String TEXT_ESC_2 = "\\0 0";
    private static final String TEXT_UNESC_2 = "\uFFFD0";
    private static final String TEXT_ESC_3 = "\\0000000";
    private static final String TEXT_UNESC_3 = "\uFFFD0";
    private static final String TEXT_ESC_4 = "\\0h";
    private static final String TEXT_UNESC_4 = "\uFFFDh";
    private static final String TEXT_ESC_5 = "\\0 h";
    private static final String TEXT_UNESC_5 = "\uFFFDh";
    private static final String TEXT_ESC_6 = "\\000000 0";
    private static final String TEXT_UNESC_6 = "\uFFFD0";
    private static final String TEXT_ESC_7 = "\\000000 h";
    private static final String TEXT_UNESC_7 = "\uFFFDh";




    @Test
    public void testUnescape01() throws Exception {

        testUnescape(TEXT_ESC_1, TEXT_UNESC_1);
        testUnescape(TEXT_ESC_2, TEXT_UNESC_2);
        testUnescape(TEXT_ESC_3, TEXT_UNESC_3);
        testUnescape(TEXT_ESC_4, TEXT_UNESC_4);
        testUnescape(TEXT_ESC_5, TEXT_UNESC_5);
        testUnescape(TEXT_ESC_6, TEXT_UNESC_6);
        testUnescape(TEXT_ESC_7, TEXT_UNESC_7);

    }




    public CssStringEscape10Test() {
        super();
    }


}

