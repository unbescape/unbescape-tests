/*
 * =============================================================================
 * 
 *   Copyright (c) 2014-2025 Unbescape (http://www.unbescape.org)
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

import org.junit.Test;

import static org.unbescape.css.CssStringEscapeTestUtil.testEscapeBECompact1;
import static org.unbescape.css.CssStringEscapeTestUtil.testEscapeBECompact2;
import static org.unbescape.css.CssStringEscapeTestUtil.testEscapeBECompact3;
import static org.unbescape.css.CssStringEscapeTestUtil.testEscapeBECompact4;
import static org.unbescape.css.CssStringEscapeTestUtil.testEscapeBESixDigit1;
import static org.unbescape.css.CssStringEscapeTestUtil.testEscapeBESixDigit2;
import static org.unbescape.css.CssStringEscapeTestUtil.testEscapeBESixDigit3;
import static org.unbescape.css.CssStringEscapeTestUtil.testEscapeBESixDigit4;
import static org.unbescape.css.CssStringEscapeTestUtil.testEscapeCompact1;
import static org.unbescape.css.CssStringEscapeTestUtil.testEscapeCompact2;
import static org.unbescape.css.CssStringEscapeTestUtil.testEscapeCompact3;
import static org.unbescape.css.CssStringEscapeTestUtil.testEscapeCompact4;
import static org.unbescape.css.CssStringEscapeTestUtil.testEscapeSixDigit1;
import static org.unbescape.css.CssStringEscapeTestUtil.testEscapeSixDigit2;
import static org.unbescape.css.CssStringEscapeTestUtil.testEscapeSixDigit3;
import static org.unbescape.css.CssStringEscapeTestUtil.testEscapeSixDigit4;
import static org.unbescape.css.CssStringEscapeTestUtil.testUnescape;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.1.6
 *
 */
public class CssStringEscape25Test {


    // According to the spec, inside a String a backslash followed by a line feed should be completely ignored
    // It's controversial whether this should be considered an escape sequence or a parsing artifact, but the CSS
    // specification names this artifact twice as an escape, so it seems it makes sense (according to spec) to have
    // this in Unbescape.
    // See https://www.w3.org/TR/CSS2/syndata.html#escaped-characters
    // See https://www.w3.org/TR/CSS2/syndata.html#strings
    private static final String[] TEXT_ESCAPED = new String[] { "a\\\nb", "\\\nba", "ab\\\n", "\\\n", "\\\n\\\n", "a\\\nba\\\nba\\\nb", "a\\\n   ba\\\n   ba\\\n   b"};
    private static final String[] TEXT_UNESCAPED = new String[] { "ab", "ba", "ab", "", "", "ababab", "a   ba   ba   b"};




    @Test
    public void testBECompact() throws Exception {

        for (int i = 0; i < TEXT_ESCAPED.length; i++) {
            testUnescape(TEXT_ESCAPED[i],TEXT_UNESCAPED[i]);
        }

    }









    public CssStringEscape25Test() {
        super();
    }


}

