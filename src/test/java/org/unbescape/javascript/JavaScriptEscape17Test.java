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

import org.junit.Test;

import static org.unbescape.javascript.JavaScriptEscapeTestUtil.testUnescape;


/**
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.6
 *
 */
public class JavaScriptEscape17Test {


    // Tests for line continuators (escaped line feeds), allowed in ECMAScript 2015
    private static final String[] TEXT_ESCAPED = new String[] { "a\\\nb", "\\\nba", "ab\\\n", "\\\n", "\\\n\\\n", "a\\\nba\\\nba\\\nb", "a\\\n   ba\\\n   ba\\\n   b"};
    private static final String[] TEXT_UNESCAPED = new String[] { "ab", "ba", "ab", "", "", "ababab", "a   ba   ba   b"};




    @Test
    public void testBECompact() throws Exception {

        for (int i = 0; i < TEXT_ESCAPED.length; i++) {
            testUnescape(TEXT_ESCAPED[i],TEXT_UNESCAPED[i]);
        }

    }









    public JavaScriptEscape17Test() {
        super();
    }


}

