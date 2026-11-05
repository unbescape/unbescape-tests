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
 *   Unescape of <kbd>\8</kbd> and <kbd>\9</kbd>: '8' and '9' are not octal digits, so they are not escapes
 *   either, and are unescaped as normal chars (NonEscapeCharacter).
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class JavaScriptEscape20Test {




    @Test
    public void testUnescapeNonOctalDigits() throws Exception {

        testUnescape("\\8", "8");
        testUnescape("\\9", "9");
        testUnescape("a\\8b\\9c", "a8b9c");
        testUnescape("\\18", "\u00018");

    }




    public JavaScriptEscape20Test() {
        super();
    }


}
