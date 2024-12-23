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
public class CssIdentifierEscape22Test {


    // Decimal numbers at the beginning of the identifier should be escaped
    private static final String TEXT = "a0123456789";




    @Test
    public void testBECompact() throws Exception {

        final String textBECompactLevel1 = "a0123456789";
        final String textBECompactLevel2 = "a0123456789";
        final String textBECompactLevel3 = "a0123456789";
        final String textBECompactLevel4 = "\\61\\30\\31\\32\\33\\34\\35\\36\\37\\38\\39";

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

        final String textBESixDigitLevel1 = "a0123456789";
        final String textBESixDigitLevel2 = "a0123456789";
        final String textBESixDigitLevel3 = "a0123456789";
        final String textBESixDigitLevel4 = "\\000061\\000030\\000031\\000032\\000033\\000034\\000035\\000036\\000037\\000038\\000039";

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

        final String textCompactLevel1 = "a0123456789";
        final String textCompactLevel2 = "a0123456789";
        final String textCompactLevel3 = "a0123456789";
        final String textCompactLevel4 = "\\61\\30\\31\\32\\33\\34\\35\\36\\37\\38\\39";

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

        final String textSixDigitLevel1 = "a0123456789";
        final String textSixDigitLevel2 = "a0123456789";
        final String textSixDigitLevel3 = "a0123456789";
        final String textSixDigitLevel4 = "\\000061\\000030\\000031\\000032\\000033\\000034\\000035\\000036\\000037\\000038\\000039";

        testEscapeSixDigit1(TEXT, textSixDigitLevel1);
        testEscapeSixDigit2(TEXT, textSixDigitLevel2);
        testEscapeSixDigit3(TEXT, textSixDigitLevel3);
        testEscapeSixDigit4(TEXT, textSixDigitLevel4);

        testUnescape(textSixDigitLevel1, TEXT);
        testUnescape(textSixDigitLevel2, TEXT);
        testUnescape(textSixDigitLevel3, TEXT);
        testUnescape(textSixDigitLevel4, TEXT);

    }








    public CssIdentifierEscape22Test() {
        super();
    }


}

