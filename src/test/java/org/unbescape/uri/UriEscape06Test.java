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

import static org.unbescape.uri.UriEscapeTestUtil.testUnescapePath;
import static org.unbescape.uri.UriEscapeTestUtil.testUnescapeQueryParam;

/**
 * <p>
 *   Incomplete percent-encoded sequences, bytes that are not valid in the encoding and unsupported encodings.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class UriEscape06Test {




    @Test
    public void testIncompleteSequence() {

        for (final String text : new String[] { "%4", "a%4", "%41%4" }) {
            assertUnescapeRejected(text, "UTF-8");
        }

    }




    @Test
    public void testInvalidBytes() throws Exception {

        testUnescapePath("%FF", "\uFFFD");
        testUnescapePath("%C3", "\uFFFD");
        testUnescapePath("%C3%28", "\uFFFD(");
        testUnescapeQueryParam("%E2%82+", "\uFFFD ");

    }




    @Test
    public void testUnsupportedEncoding() {

        assertUnescapeRejected("%41", "X-UNSUPPORTED");
        assertEscapeRejected(" ", "X-UNSUPPORTED");

        // The encoding is only needed if there is something to escape or unescape
        Assertions.assertEquals("a", UriEscape.unescapeUriPath("a", "X-UNSUPPORTED"));
        Assertions.assertEquals("a", UriEscape.escapeUriPath("a", "X-UNSUPPORTED"));

    }




    private static void assertUnescapeRejected(final String text, final String encoding) {
        final char[] chars = text.toCharArray();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> UriEscape.unescapeUriPath(text, encoding), text);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> UriEscape.unescapeUriPath(new StringReader(text), new StringWriter(), encoding), text);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> UriEscape.unescapeUriPath(chars, 0, chars.length, new StringWriter(), encoding), text);
    }


    private static void assertEscapeRejected(final String text, final String encoding) {
        final char[] chars = text.toCharArray();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> UriEscape.escapeUriPath(text, encoding), text);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> UriEscape.escapeUriPath(new StringReader(text), new StringWriter(), encoding), text);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> UriEscape.escapeUriPath(chars, 0, chars.length, new StringWriter(), encoding), text);
    }




    public UriEscape06Test() {
        super();
    }


}
