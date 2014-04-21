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

import org.junit.Test;

import static org.unbescape.css.CssStringEscapeTestUtil.testUnescape;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.0
 *
 */
public class CssStringEscape23Test {


    // This should verify that not only the 'standard' >U+FFFF syntax works when unescaping, but also the
    // non standard (older Webkit) surrogate-based one.
    private static final String TEXT_ESC =
            "\\<\\>\\&\\'\\\"ABCDEFGHIJKLMNOPQRSTUVWXYZ\\ \\<\\>\\&\\'\\\"\\ \\163 \\D840 \\DC00 \\D835 \\DCCD -\\163 -\\20000 -\\1D4CD \\E0\\E1\\E2\\E3\\E4\\E5\\E6 abcdefghijklmnopqrstuvwxyz\\ \\<\\&\\'\\\"\\>\\ 0123456789\\&\\<\\'\\\"\\>";
    private static final String TEXT_UNESC =
            "<>&'\"ABCDEFGHIJKLMNOPQRSTUVWXYZ <>&'\" \u0163\uD840\uDC00\ud835\udccd-\u0163-\uD840\uDC00-\ud835\udccd\u00E0\u00E1\u00E2\u00E3\u00E4\u00E5\u00E6abcdefghijklmnopqrstuvwxyz <&'\"> 0123456789&<'\">";





    @Test
    public void testUnescape01() throws Exception {

        testUnescape(TEXT_ESC, TEXT_UNESC);

    }





    public CssStringEscape23Test() {
        super();
    }


}

