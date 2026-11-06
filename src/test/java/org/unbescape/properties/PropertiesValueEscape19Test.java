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
package org.unbescape.properties;

import org.junit.jupiter.api.Test;

import static org.unbescape.properties.PropertiesValueEscapeTestUtil.testUnescape;

/**
 * <p>
 *   Unescape of <kbd>&#92;u</kbd> escapes with lowercase, uppercase and mixed-case hexadecimal digits.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class PropertiesValueEscape19Test {




    @Test
    public void testUnescapeHexaCase() throws Exception {

        testUnescape("\\u00e1", "\u00E1");
        testUnescape("\\u00E1", "\u00E1");
        testUnescape("\\uabcd", "\uABCD");
        testUnescape("\\uABcd", "\uABCD");
        testUnescape("\\ufafa", "\uFAFA");
        testUnescape("\\u0aF0", "\u0AF0");
        // Incomplete escapes are left untouched
        testUnescape("\\u00e", "\\u00e");
        testUnescape("\\u00eg", "\\u00eg");

    }




    public PropertiesValueEscape19Test() {
        super();
    }


}
