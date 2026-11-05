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

import static org.unbescape.properties.PropertiesValueEscapeTestUtil.testEscape2;
import static org.unbescape.properties.PropertiesValueEscapeTestUtil.testUnescape;

/**
 * <p>
 *   Escape of lone (unpaired) surrogates in values.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class PropertiesValueEscape18Test {




    @Test
    public void testEscapeLoneSurrogates() throws Exception {

        testEscape2("\uD800", "\\uD800");
        testEscape2("a\uDC00b", "a\\uDC00b");
        testEscape2("\uDC00\uD800", "\\uDC00\\uD800");
        testEscape2("a\uD800", "a\\uD800");
        testEscape2("\uD83D\uDE00", "\\uD83D\\uDE00");

        testUnescape("\\uD800", "\uD800");
        testUnescape("a\\uDC00b", "a\uDC00b");

    }




    public PropertiesValueEscape18Test() {
        super();
    }


}
