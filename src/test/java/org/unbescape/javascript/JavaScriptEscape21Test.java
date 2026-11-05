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
package org.unbescape.javascript;

import org.junit.jupiter.api.Test;

import static org.unbescape.javascript.JavaScriptEscapeTestUtil.testUnescape;

/**
 * <p>
 *   Unescape of escaped line terminators: a backslash followed by any LineTerminatorSequence (LF, CR, CR LF,
 *   U+2028 or U+2029) is a LineContinuation, and is ignored in output.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class JavaScriptEscape21Test {




    @Test
    public void testLineContinuation() throws Exception {

        testUnescape("a\\\nb", "ab");
        testUnescape("a\\\rb", "ab");
        testUnescape("a\\\r\nb", "ab");
        testUnescape("a\\\u2028b", "ab");
        testUnescape("a\\\u2029b", "ab");
        testUnescape("a\\\n\\\r\\\r\n\\\u2028\\\u2029b", "ab");
        testUnescape("\\\r", "");
        testUnescape("\\\r\n", "");

    }




    @Test
    public void testOnlyOneLineTerminator() throws Exception {

        // CR LF is a single line terminator, but any other line terminator after it is not part of the escape
        testUnescape("a\\\r\n\nb", "a\nb");
        testUnescape("a\\\r\rb", "a\rb");
        testUnescape("a\\\n\rb", "a\rb");
        testUnescape("a\\\u2028\nb", "a\nb");

        // Line terminators that are not escaped are left untouched
        testUnescape("a\r\n\u2028\u2029b", "a\r\n\u2028\u2029b");

    }




    public JavaScriptEscape21Test() {
        super();
    }


}
