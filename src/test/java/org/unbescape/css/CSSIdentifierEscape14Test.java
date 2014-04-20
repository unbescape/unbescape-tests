/*
 * =============================================================================
 * 
 *   Copyright (c) 2014, The UNBESCAPE team (http://www.unbescape.org)
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

import static org.unbescape.css.CSSIdentifierEscapeTestUtil.testEscapeBECompact1;
import static org.unbescape.css.CSSIdentifierEscapeTestUtil.testEscapeBECompact2;
import static org.unbescape.css.CSSIdentifierEscapeTestUtil.testEscapeBECompact3;
import static org.unbescape.css.CSSIdentifierEscapeTestUtil.testEscapeBECompact4;
import static org.unbescape.css.CSSIdentifierEscapeTestUtil.testEscapeBESixDigit1;
import static org.unbescape.css.CSSIdentifierEscapeTestUtil.testEscapeBESixDigit2;
import static org.unbescape.css.CSSIdentifierEscapeTestUtil.testEscapeBESixDigit3;
import static org.unbescape.css.CSSIdentifierEscapeTestUtil.testEscapeBESixDigit4;
import static org.unbescape.css.CSSIdentifierEscapeTestUtil.testEscapeCompact1;
import static org.unbescape.css.CSSIdentifierEscapeTestUtil.testEscapeCompact2;
import static org.unbescape.css.CSSIdentifierEscapeTestUtil.testEscapeCompact3;
import static org.unbescape.css.CSSIdentifierEscapeTestUtil.testEscapeCompact4;
import static org.unbescape.css.CSSIdentifierEscapeTestUtil.testEscapeSixDigit1;
import static org.unbescape.css.CSSIdentifierEscapeTestUtil.testEscapeSixDigit2;
import static org.unbescape.css.CSSIdentifierEscapeTestUtil.testEscapeSixDigit3;
import static org.unbescape.css.CSSIdentifierEscapeTestUtil.testEscapeSixDigit4;
import static org.unbescape.css.CSSIdentifierEscapeTestUtil.testUnescape;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.0
 *
 */
public class CSSIdentifierEscape14Test {


    // The solidus character should be escaped, but only when it appears right after '<' (in order to avoid
    // closing a <script> tag in an HTML file.
    private static final String TEXT = "/something</script></anything> but http://example.com";




    @Test
    public void testBECompact() throws Exception {

        final String textBECompactLevel1 = "\\/something\\<\\/script\\>\\<\\/anything\\>\\ but\\ http\\3A \\/\\/example\\.com";
        final String textBECompactLevel2 = "\\/something\\<\\/script\\>\\<\\/anything\\>\\ but\\ http\\3A \\/\\/example\\.com";
        final String textBECompactLevel3 = "\\/something\\<\\/script\\>\\<\\/anything\\>\\ but\\ http\\3A \\/\\/example\\.com";
        final String textBECompactLevel4 = "\\/\\73 \\6F \\6D \\65 \\74 \\68 \\69 \\6E \\67 \\<\\/\\73 \\63 \\72 \\69 \\70 \\74 \\>\\<\\/\\61 \\6E \\79 \\74 \\68 \\69 \\6E \\67 \\>\\ \\62 \\75 \\74 \\ \\68 \\74 \\74 \\70 \\3A \\/\\/\\65 \\78 \\61 \\6D \\70 \\6C \\65 \\.\\63 \\6F \\6D ";

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

        final String textBESixDigitLevel1 = "\\/something\\<\\/script\\>\\<\\/anything\\>\\ but\\ http\\00003A\\/\\/example\\.com";
        final String textBESixDigitLevel2 = "\\/something\\<\\/script\\>\\<\\/anything\\>\\ but\\ http\\00003A\\/\\/example\\.com";
        final String textBESixDigitLevel3 = "\\/something\\<\\/script\\>\\<\\/anything\\>\\ but\\ http\\00003A\\/\\/example\\.com";
        final String textBESixDigitLevel4 = "\\/\\000073\\00006F\\00006D\\000065\\000074\\000068\\000069\\00006E\\000067\\<\\/\\000073\\000063\\000072\\000069\\000070\\000074\\>\\<\\/\\000061\\00006E\\000079\\000074\\000068\\000069\\00006E\\000067\\>\\ \\000062\\000075\\000074\\ \\000068\\000074\\000074\\000070\\00003A\\/\\/\\000065\\000078\\000061\\00006D\\000070\\00006C\\000065\\.\\000063\\00006F\\00006D";

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

        final String textCompactLevel1 = "\\2F something\\3C \\2F script\\3E \\3C \\2F anything\\3E \\20 but\\20 http\\3A \\2F \\2F example\\2E com";
        final String textCompactLevel2 = "\\2F something\\3C \\2F script\\3E \\3C \\2F anything\\3E \\20 but\\20 http\\3A \\2F \\2F example\\2E com";
        final String textCompactLevel3 = "\\2F something\\3C \\2F script\\3E \\3C \\2F anything\\3E \\20 but\\20 http\\3A \\2F \\2F example\\2E com";
        final String textCompactLevel4 = "\\2F \\73 \\6F \\6D \\65 \\74 \\68 \\69 \\6E \\67 \\3C \\2F \\73 \\63 \\72 \\69 \\70 \\74 \\3E \\3C \\2F \\61 \\6E \\79 \\74 \\68 \\69 \\6E \\67 \\3E \\20 \\62 \\75 \\74 \\20 \\68 \\74 \\74 \\70 \\3A \\2F \\2F \\65 \\78 \\61 \\6D \\70 \\6C \\65 \\2E \\63 \\6F \\6D ";

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

        final String textSixDigitLevel1 = "\\00002Fsomething\\00003C\\00002Fscript\\00003E\\00003C\\00002Fanything\\00003E\\000020but\\000020http\\00003A\\00002F\\00002Fexample\\00002Ecom";
        final String textSixDigitLevel2 = "\\00002Fsomething\\00003C\\00002Fscript\\00003E\\00003C\\00002Fanything\\00003E\\000020but\\000020http\\00003A\\00002F\\00002Fexample\\00002Ecom";
        final String textSixDigitLevel3 = "\\00002Fsomething\\00003C\\00002Fscript\\00003E\\00003C\\00002Fanything\\00003E\\000020but\\000020http\\00003A\\00002F\\00002Fexample\\00002Ecom";
        final String textSixDigitLevel4 = "\\00002F\\000073\\00006F\\00006D\\000065\\000074\\000068\\000069\\00006E\\000067\\00003C\\00002F\\000073\\000063\\000072\\000069\\000070\\000074\\00003E\\00003C\\00002F\\000061\\00006E\\000079\\000074\\000068\\000069\\00006E\\000067\\00003E\\000020\\000062\\000075\\000074\\000020\\000068\\000074\\000074\\000070\\00003A\\00002F\\00002F\\000065\\000078\\000061\\00006D\\000070\\00006C\\000065\\00002E\\000063\\00006F\\00006D";

        testEscapeSixDigit1(TEXT, textSixDigitLevel1);
        testEscapeSixDigit2(TEXT, textSixDigitLevel2);
        testEscapeSixDigit3(TEXT, textSixDigitLevel3);
        testEscapeSixDigit4(TEXT, textSixDigitLevel4);

        testUnescape(textSixDigitLevel1, TEXT);
        testUnescape(textSixDigitLevel2, TEXT);
        testUnescape(textSixDigitLevel3, TEXT);
        testUnescape(textSixDigitLevel4, TEXT);

    }








    public CSSIdentifierEscape14Test() {
        super();
    }


}

