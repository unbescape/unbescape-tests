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
package org.unbescape.java;

import org.junit.jupiter.api.Test;

import static org.unbescape.java.JavaEscapeTestUtil.testUnescape;

/**
 * <p>
 *   Unescape of <kbd>&#92;u</kbd> escapes with lowercase, uppercase and mixed-case hexadecimal digits in every
 *   position.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class JavaEscape21Test {




    @Test
    public void testUnescapeHexaCase() throws Exception {

        testUnescape("\\uabcd", "\uABCD");
        testUnescape("\\uABcd", "\uABCD");
        testUnescape("\\ufafa", "\uFAFA");
        testUnescape("\\u0aF0", "\u0AF0");
        testUnescape("\\uuuuabcd", "\uABCD");

    }




    @Test
    public void testUnescapeNonHexaInEscape() throws Exception {

        // Chars right after '9' and 'F' are not hexadecimal digits either: incomplete escapes are left untouched
        testUnescape("\\u12:4", "\\u12:4");
        testUnescape("\\u12G4", "\\u12G4");

    }




    public JavaEscape21Test() {
        super();
    }


}
