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
package org.unbescape.css;

import org.junit.jupiter.api.Test;

import static org.unbescape.css.CssIdentifierEscapeTestUtil.testEscapeBECompact1;
import static org.unbescape.css.CssIdentifierEscapeTestUtil.testEscapeBECompact2;
import static org.unbescape.css.CssIdentifierEscapeTestUtil.testEscapeBESixDigit1;
import static org.unbescape.css.CssIdentifierEscapeTestUtil.testEscapeBESixDigit2;
import static org.unbescape.css.CssIdentifierEscapeTestUtil.testEscapeCompact1;
import static org.unbescape.css.CssIdentifierEscapeTestUtil.testEscapeSixDigit1;
import static org.unbescape.css.CssIdentifierEscapeTestUtil.testUnescape;

/**
 * <p>
 *   An identifier consisting only of a hyphen (U+002D) must be escaped, as a single hyphen is not a valid CSS
 *   identifier (see the CSSOM <em>serialize an identifier</em> algorithm).
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.8
 *
 */
public class CssIdentifierEscape26Test {




    @Test
    public void testOnlyHyphen() throws Exception {

        testEscapeBECompact1("-", "\\-");
        testEscapeBECompact2("-", "\\-");
        testEscapeBESixDigit1("-", "\\-");
        testEscapeBESixDigit2("-", "\\-");
        testEscapeCompact1("-", "\\2D");
        testEscapeSixDigit1("-", "\\00002D");

        testUnescape("\\-", "-");

    }




    @Test
    public void testHyphenWithOtherChars() throws Exception {

        // Positive controls: a hyphen followed by anything other than a hyphen or a digit, or not at the start of
        // the identifier, is still not escaped at levels 1 and 2
        testEscapeBECompact1("-a", "-a");
        testEscapeBECompact2("-a", "-a");
        testEscapeBECompact1("a-", "a-");
        testEscapeBECompact2("a-b", "a-b");

        // A hyphen followed by a hyphen or a digit is escaped, as before
        testEscapeBECompact1("--", "\\--");
        testEscapeBECompact1("-1", "\\-1");

    }




    public CssIdentifierEscape26Test() {
        super();
    }


}
