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

import static org.unbescape.uri.UriEscapeTestUtil.testUnescapeFragmentId;
import static org.unbescape.uri.UriEscapeTestUtil.testUnescapePath;
import static org.unbescape.uri.UriEscapeTestUtil.testUnescapeQueryParam;

/**
 * <p>
 *   Unescape of query parameters: a <kbd>+</kbd> must be unescaped as whitespace also when it directly
 *   follows a percent-encoded sequence. All variants (String, char[], Reader) must agree.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class UriEscape05Test {




    @Test
    public void testPlusAfterEscapedSequence() throws Exception {

        testUnescapeQueryParam("a%20+b", "a  b");
        testUnescapeQueryParam("%41+%42+", "A B ");
        testUnescapeQueryParam("+%2B+", " + ");
        testUnescapeQueryParam("%C3%A1+%C3%A9", "\u00E1 \u00E9");
        testUnescapeQueryParam("a%20", "a ");

        // Outside query parameters, '+' is never whitespace
        testUnescapePath("a%20+b", "a +b");
        testUnescapeFragmentId("a%20+b", "a +b");

    }




    public UriEscape05Test() {
        super();
    }


}
