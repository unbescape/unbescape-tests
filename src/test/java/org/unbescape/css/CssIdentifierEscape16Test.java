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

import org.junit.jupiter.api.Test;

import static org.unbescape.css.CssIdentifierEscapeTestUtil.testEscapeBECompact1;
import static org.unbescape.css.CssIdentifierEscapeTestUtil.testEscapeBECompact2;
import static org.unbescape.css.CssIdentifierEscapeTestUtil.testEscapeBECompact3;
import static org.unbescape.css.CssIdentifierEscapeTestUtil.testEscapeBECompact4;
import static org.unbescape.css.CssIdentifierEscapeTestUtil.testEscapeBESixDigit1;
import static org.unbescape.css.CssIdentifierEscapeTestUtil.testEscapeBESixDigit2;
import static org.unbescape.css.CssIdentifierEscapeTestUtil.testEscapeBESixDigit3;
import static org.unbescape.css.CssIdentifierEscapeTestUtil.testEscapeBESixDigit4;
import static org.unbescape.css.CssIdentifierEscapeTestUtil.testEscapeCompact1;
import static org.unbescape.css.CssIdentifierEscapeTestUtil.testEscapeCompact2;
import static org.unbescape.css.CssIdentifierEscapeTestUtil.testEscapeCompact3;
import static org.unbescape.css.CssIdentifierEscapeTestUtil.testEscapeCompact4;
import static org.unbescape.css.CssIdentifierEscapeTestUtil.testEscapeSixDigit1;
import static org.unbescape.css.CssIdentifierEscapeTestUtil.testEscapeSixDigit2;
import static org.unbescape.css.CssIdentifierEscapeTestUtil.testEscapeSixDigit3;
import static org.unbescape.css.CssIdentifierEscapeTestUtil.testEscapeSixDigit4;
import static org.unbescape.css.CssIdentifierEscapeTestUtil.testUnescape;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.0
 *
 */
public class CssIdentifierEscape16Test {


    // The underscore character should only be escaped at the beginning of an identifier.
    private static final String TEXT = "__";




    @Test
    public void testBECompact() throws Exception {

        final String textBECompactLevel1 = "\\__";
        final String textBECompactLevel2 = "\\__";
        final String textBECompactLevel3 = "\\_\\_";
        final String textBECompactLevel4 = "\\_\\_";

        testEscapeBECompact1(TEXT, textBECompactLevel1);
        testEscapeBECompact2(TEXT, textBECompactLevel2);
        testEscapeBECompact3(TEXT, textBECompactLevel3);
        testEscapeBECompact4(TEXT, textBECompactLevel4);

        testUnescape(textBECompactLevel1, TEXT);
        testUnescape(textBECompactLevel2, TEXT);
        testUnescape(textBECompactLevel3, TEXT);
        testUnescape(textBECompactLevel4, TEXT);

    }





    @Test
    public void testBESixDigit() throws Exception {

        final String textBESixDigitLevel1 = "\\__";
        final String textBESixDigitLevel2 = "\\__";
        final String textBESixDigitLevel3 = "\\_\\_";
        final String textBESixDigitLevel4 = "\\_\\_";

        testEscapeBESixDigit1(TEXT, textBESixDigitLevel1);
        testEscapeBESixDigit2(TEXT, textBESixDigitLevel2);
        testEscapeBESixDigit3(TEXT, textBESixDigitLevel3);
        testEscapeBESixDigit4(TEXT, textBESixDigitLevel4);

        testUnescape(textBESixDigitLevel1, TEXT);
        testUnescape(textBESixDigitLevel2, TEXT);
        testUnescape(textBESixDigitLevel3, TEXT);
        testUnescape(textBESixDigitLevel4, TEXT);

    }





    @Test
    public void testCompact() throws Exception {

        final String textCompactLevel1 = "\\5F_";
        final String textCompactLevel2 = "\\5F_";
        final String textCompactLevel3 = "\\5F\\5F";
        final String textCompactLevel4 = "\\5F\\5F";

        testEscapeCompact1(TEXT, textCompactLevel1);
        testEscapeCompact2(TEXT, textCompactLevel2);
        testEscapeCompact3(TEXT, textCompactLevel3);
        testEscapeCompact4(TEXT, textCompactLevel4);

        testUnescape(textCompactLevel1, TEXT);
        testUnescape(textCompactLevel2, TEXT);
        testUnescape(textCompactLevel3, TEXT);
        testUnescape(textCompactLevel4, TEXT);

    }





    @Test
    public void testSixDigit() throws Exception {

        final String textSixDigitLevel1 = "\\00005F_";
        final String textSixDigitLevel2 = "\\00005F_";
        final String textSixDigitLevel3 = "\\00005F\\00005F";
        final String textSixDigitLevel4 = "\\00005F\\00005F";

        testEscapeSixDigit1(TEXT, textSixDigitLevel1);
        testEscapeSixDigit2(TEXT, textSixDigitLevel2);
        testEscapeSixDigit3(TEXT, textSixDigitLevel3);
        testEscapeSixDigit4(TEXT, textSixDigitLevel4);

        testUnescape(textSixDigitLevel1, TEXT);
        testUnescape(textSixDigitLevel2, TEXT);
        testUnescape(textSixDigitLevel3, TEXT);
        testUnescape(textSixDigitLevel4, TEXT);

    }








    public CssIdentifierEscape16Test() {
        super();
    }


}

