/*
 * =============================================================================
 * 
 *   Copyright (c) 2014-2017, The UNBESCAPE team (http://www.unbescape.org)
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
 * @since 1.0
 *
 */
public class CssStringEscape07Test {


    private static final String TEXT = "a";




    @Test
    public void testBECompact() throws Exception {

        final String textBECompactLevel1 = "a";
        final String textBECompactLevel2 = "a";
        final String textBECompactLevel3 = "a";
        final String textBECompactLevel4 = "\\61";

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

        final String textBESixDigitLevel1 = "a";
        final String textBESixDigitLevel2 = "a";
        final String textBESixDigitLevel3 = "a";
        final String textBESixDigitLevel4 = "\\000061";

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

        final String textCompactLevel1 = "a";
        final String textCompactLevel2 = "a";
        final String textCompactLevel3 = "a";
        final String textCompactLevel4 = "\\61";

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

        final String textSixDigitLevel1 = "a";
        final String textSixDigitLevel2 = "a";
        final String textSixDigitLevel3 = "a";
        final String textSixDigitLevel4 = "\\000061";

        testEscapeSixDigit1(TEXT, textSixDigitLevel1);
        testEscapeSixDigit2(TEXT, textSixDigitLevel2);
        testEscapeSixDigit3(TEXT, textSixDigitLevel3);
        testEscapeSixDigit4(TEXT, textSixDigitLevel4);

        testUnescape(textSixDigitLevel1, TEXT);
        testUnescape(textSixDigitLevel2, TEXT);
        testUnescape(textSixDigitLevel3, TEXT);
        testUnescape(textSixDigitLevel4, TEXT);

    }








    public CssStringEscape07Test() {
        super();
    }


}

