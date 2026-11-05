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
package org.unbescape.uri;

import java.io.StringReader;
import java.io.StringWriter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * <p>
 *   Unescape of invalid percent-encoded sequences: every '%' must be followed by two hexadecimal digits, and
 *   anything else must be rejected by all variants (String, char[], Reader).
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class UriEscape07Test {




    @Test
    public void testTrailingPercent() {

        for (final String text : new String[] { "%", "a%", "%41%" }) {
            assertUnescapeRejected(text);
        }

    }




    @Test
    public void testInvalidHexadecimal() {

        for (final String text : new String[] { "%G1", "%1G", "%zz", "a%4gb", "%%41", "%41%4%", "% 1", "%-1" }) {
            assertUnescapeRejected(text);
        }

    }




    private static void assertUnescapeRejected(final String text) {
        final char[] chars = text.toCharArray();
        Assertions.assertThrows(IllegalArgumentException.class, () -> UriEscape.unescapeUriPath(text), text);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> UriEscape.unescapeUriPath(new StringReader(text), new StringWriter()), text);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> UriEscape.unescapeUriPath(chars, 0, chars.length, new StringWriter()), text);
        Assertions.assertThrows(IllegalArgumentException.class, () -> UriEscape.unescapeUriQueryParam(text), text);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> UriEscape.unescapeUriQueryParam(new StringReader(text), new StringWriter()), text);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> UriEscape.unescapeUriQueryParam(chars, 0, chars.length, new StringWriter()), text);
    }




    public UriEscape07Test() {
        super();
    }


}
