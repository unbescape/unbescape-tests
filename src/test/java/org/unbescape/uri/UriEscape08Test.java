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

import org.junit.jupiter.api.Test;

import static org.unbescape.uri.UriEscapeTestUtil.testEscape;
import static org.unbescape.uri.UriEscapeTestUtil.testEscapeFragmentId;
import static org.unbescape.uri.UriEscapeTestUtil.testEscapePath;
import static org.unbescape.uri.UriEscapeTestUtil.testEscapePathSegment;
import static org.unbescape.uri.UriEscapeTestUtil.testEscapeQueryParam;
import static org.unbescape.uri.UriEscapeTestUtil.testUnescapePath;

/**
 * <p>
 *   Escape of lone (unpaired) surrogates: they cannot be encoded, so they are encoded as U+FFFD (REPLACEMENT
 *   CHARACTER), as established by the WHATWG URL Standard.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class UriEscape08Test {


    private static final String REPLACEMENT = "%EF%BF%BD";




    @Test
    public void testLoneSurrogates() throws Exception {

        testEscapePath("\uD800", REPLACEMENT);
        testEscapePath("\uDC00", REPLACEMENT);
        testEscapePath("a\uD800b", "a" + REPLACEMENT + "b");
        testEscapePath("a\uDC00b", "a" + REPLACEMENT + "b");
        testEscapePath("\uDC00\uD800", REPLACEMENT + REPLACEMENT);
        testEscapePath("a\uD800", "a" + REPLACEMENT);
        testEscapePathSegment("a\uD800b", "a" + REPLACEMENT + "b");
        testEscapeQueryParam("a\uD800b", "a" + REPLACEMENT + "b");
        testEscapeFragmentId("a\uD800b", "a" + REPLACEMENT + "b");

        testUnescapePath(REPLACEMENT, "\uFFFD");

    }




    @Test
    public void testValidSurrogatePairs() throws Exception {

        testEscapePath("\uD83D\uDE00", "%F0%9F%98%80");
        testEscapePath("\uD800\uD83D\uDE00\uDC00", REPLACEMENT + "%F0%9F%98%80" + REPLACEMENT);

    }




    @Test
    public void testEncodingWithoutReplacementChar() throws Exception {

        // ISO-8859-1 cannot represent U+FFFD either, so it applies its own replacement
        testEscape("a\uD800b", "a%3Fb", UriEscapeUtil.UriEscapeType.PATH, "ISO-8859-1");

    }




    public UriEscape08Test() {
        super();
    }


}
