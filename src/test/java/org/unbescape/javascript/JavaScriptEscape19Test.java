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
 *   Unescape of octal escapes starting with zero: <kbd>\00</kbd> and <kbd>\000</kbd> are a single U+0000, like
 *   <kbd>\0</kbd>.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class JavaScriptEscape19Test {




    @Test
    public void testUnescapeOctalZero() throws Exception {

        testUnescape("\\00", "\u0000");
        testUnescape("\\000", "\u0000");
        testUnescape("\\0000", "\u00000");
        testUnescape("\\001", "\u0001");
        testUnescape("\\008", "\u00008");
        testUnescape("a\\00b", "a\u0000b");

    }




    public JavaScriptEscape19Test() {
        super();
    }


}
