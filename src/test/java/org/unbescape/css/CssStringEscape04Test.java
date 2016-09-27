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
public class CssStringEscape04Test {


    private static final String TEXT =
            "<>&'\"ABCDEFGHIJKLMNOPQRSTUVWXYZ <>&'\" \u00E0\u00E1\u00E2\u00E3\u00E4\u00E5\u00E6abcdefghijklmnopqrstuvwxyz <&'\"> 0123456789&<'\">";




    @Test
    public void testBECompact() throws Exception {

        final String textBECompactLevel1 =
                "<>\\&\\'\\\"ABCDEFGHIJKLMNOPQRSTUVWXYZ <>\\&\\'\\\" \u00E0\u00E1\u00E2\u00E3\u00E4\u00E5\u00E6abcdefghijklmnopqrstuvwxyz <\\&\\'\\\"> 0123456789\\&<\\'\\\">";
        final String textBECompactLevel2 =
                "<>\\&\\'\\\"ABCDEFGHIJKLMNOPQRSTUVWXYZ <>\\&\\'\\\" \\E0\\E1\\E2\\E3\\E4\\E5\\E6 abcdefghijklmnopqrstuvwxyz <\\&\\'\\\"> 0123456789\\&<\\'\\\">";
        final String textBECompactLevel3 =
                "\\<\\>\\&\\'\\\"ABCDEFGHIJKLMNOPQRSTUVWXYZ\\ \\<\\>\\&\\'\\\"\\ \\E0\\E1\\E2\\E3\\E4\\E5\\E6 abcdefghijklmnopqrstuvwxyz\\ \\<\\&\\'\\\"\\>\\ 0123456789\\&\\<\\'\\\"\\>";
        final String textBECompactLevel4 =
                "\\<\\>\\&\\'\\\"\\41\\42\\43\\44\\45\\46\\47\\48\\49\\4A\\4B\\4C\\4D\\4E\\4F\\50\\51\\52\\53\\54\\55\\56\\57\\58\\59\\5A\\ \\<\\>\\&\\'\\\"\\ \\E0\\E1\\E2\\E3\\E4\\E5\\E6\\61\\62\\63\\64\\65\\66\\67\\68\\69\\6A\\6B\\6C\\6D\\6E\\6F\\70\\71\\72\\73\\74\\75\\76\\77\\78\\79\\7A\\ \\<\\&\\'\\\"\\>\\ \\30\\31\\32\\33\\34\\35\\36\\37\\38\\39\\&\\<\\'\\\"\\>";

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

        final String textBESixDigitLevel1 =
                "<>\\&\\'\\\"ABCDEFGHIJKLMNOPQRSTUVWXYZ <>\\&\\'\\\" \u00E0\u00E1\u00E2\u00E3\u00E4\u00E5\u00E6abcdefghijklmnopqrstuvwxyz <\\&\\'\\\"> 0123456789\\&<\\'\\\">";
        final String textBESixDigitLevel2 =
                "<>\\&\\'\\\"ABCDEFGHIJKLMNOPQRSTUVWXYZ <>\\&\\'\\\" \\0000E0\\0000E1\\0000E2\\0000E3\\0000E4\\0000E5\\0000E6abcdefghijklmnopqrstuvwxyz <\\&\\'\\\"> 0123456789\\&<\\'\\\">";
        final String textBESixDigitLevel3 =
                "\\<\\>\\&\\'\\\"ABCDEFGHIJKLMNOPQRSTUVWXYZ\\ \\<\\>\\&\\'\\\"\\ \\0000E0\\0000E1\\0000E2\\0000E3\\0000E4\\0000E5\\0000E6abcdefghijklmnopqrstuvwxyz\\ \\<\\&\\'\\\"\\>\\ 0123456789\\&\\<\\'\\\"\\>";
        final String textBESixDigitLevel4 =
                "\\<\\>\\&\\'\\\"\\000041\\000042\\000043\\000044\\000045\\000046\\000047\\000048\\000049\\00004A\\00004B\\00004C\\00004D\\00004E\\00004F\\000050\\000051\\000052\\000053\\000054\\000055\\000056\\000057\\000058\\000059\\00005A\\ \\<\\>\\&\\'\\\"\\ \\0000E0\\0000E1\\0000E2\\0000E3\\0000E4\\0000E5\\0000E6\\000061\\000062\\000063\\000064\\000065\\000066\\000067\\000068\\000069\\00006A\\00006B\\00006C\\00006D\\00006E\\00006F\\000070\\000071\\000072\\000073\\000074\\000075\\000076\\000077\\000078\\000079\\00007A\\ \\<\\&\\'\\\"\\>\\ \\000030\\000031\\000032\\000033\\000034\\000035\\000036\\000037\\000038\\000039\\&\\<\\'\\\"\\>";

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

        final String textCompactLevel1 =
                "<>\\26\\27\\22 ABCDEFGHIJKLMNOPQRSTUVWXYZ <>\\26\\27\\22  \u00E0\u00E1\u00E2\u00E3\u00E4\u00E5\u00E6abcdefghijklmnopqrstuvwxyz <\\26\\27\\22> 0123456789\\26<\\27\\22>";
        final String textCompactLevel2 =
                "<>\\26\\27\\22 ABCDEFGHIJKLMNOPQRSTUVWXYZ <>\\26\\27\\22  \\E0\\E1\\E2\\E3\\E4\\E5\\E6 abcdefghijklmnopqrstuvwxyz <\\26\\27\\22> 0123456789\\26<\\27\\22>";
        final String textCompactLevel3 =
                "\\3C\\3E\\26\\27\\22 ABCDEFGHIJKLMNOPQRSTUVWXYZ\\20\\3C\\3E\\26\\27\\22\\20\\E0\\E1\\E2\\E3\\E4\\E5\\E6 abcdefghijklmnopqrstuvwxyz\\20\\3C\\26\\27\\22\\3E\\20 0123456789\\26\\3C\\27\\22\\3E";
        final String textCompactLevel4 =
                "\\3C\\3E\\26\\27\\22\\41\\42\\43\\44\\45\\46\\47\\48\\49\\4A\\4B\\4C\\4D\\4E\\4F\\50\\51\\52\\53\\54\\55\\56\\57\\58\\59\\5A\\20\\3C\\3E\\26\\27\\22\\20\\E0\\E1\\E2\\E3\\E4\\E5\\E6\\61\\62\\63\\64\\65\\66\\67\\68\\69\\6A\\6B\\6C\\6D\\6E\\6F\\70\\71\\72\\73\\74\\75\\76\\77\\78\\79\\7A\\20\\3C\\26\\27\\22\\3E\\20\\30\\31\\32\\33\\34\\35\\36\\37\\38\\39\\26\\3C\\27\\22\\3E";

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

        final String textSixDigitLevel1 =
                "<>\\000026\\000027\\000022ABCDEFGHIJKLMNOPQRSTUVWXYZ <>\\000026\\000027\\000022  \u00E0\u00E1\u00E2\u00E3\u00E4\u00E5\u00E6abcdefghijklmnopqrstuvwxyz <\\000026\\000027\\000022> 0123456789\\000026<\\000027\\000022>";
        final String textSixDigitLevel2 =
                "<>\\000026\\000027\\000022ABCDEFGHIJKLMNOPQRSTUVWXYZ <>\\000026\\000027\\000022  \\0000E0\\0000E1\\0000E2\\0000E3\\0000E4\\0000E5\\0000E6abcdefghijklmnopqrstuvwxyz <\\000026\\000027\\000022> 0123456789\\000026<\\000027\\000022>";
        final String textSixDigitLevel3 =
                "\\00003C\\00003E\\000026\\000027\\000022ABCDEFGHIJKLMNOPQRSTUVWXYZ\\000020\\00003C\\00003E\\000026\\000027\\000022\\000020\\0000E0\\0000E1\\0000E2\\0000E3\\0000E4\\0000E5\\0000E6abcdefghijklmnopqrstuvwxyz\\000020\\00003C\\000026\\000027\\000022\\00003E\\0000200123456789\\000026\\00003C\\000027\\000022\\00003E";
        final String textSixDigitLevel4 =
                "\\00003C\\00003E\\000026\\000027\\000022\\000041\\000042\\000043\\000044\\000045\\000046\\000047\\000048\\000049\\00004A\\00004B\\00004C\\00004D\\00004E\\00004F\\000050\\000051\\000052\\000053\\000054\\000055\\000056\\000057\\000058\\000059\\00005A\\000020\\00003C\\00003E\\000026\\000027\\000022\\000020\\0000E0\\0000E1\\0000E2\\0000E3\\0000E4\\0000E5\\0000E6\\000061\\000062\\000063\\000064\\000065\\000066\\000067\\000068\\000069\\00006A\\00006B\\00006C\\00006D\\00006E\\00006F\\000070\\000071\\000072\\000073\\000074\\000075\\000076\\000077\\000078\\000079\\00007A\\000020\\00003C\\000026\\000027\\000022\\00003E\\000020\\000030\\000031\\000032\\000033\\000034\\000035\\000036\\000037\\000038\\000039\\000026\\00003C\\000027\\000022\\00003E";

        testEscapeSixDigit1(TEXT, textSixDigitLevel1);
        testEscapeSixDigit2(TEXT, textSixDigitLevel2);
        testEscapeSixDigit3(TEXT, textSixDigitLevel3);
        testEscapeSixDigit4(TEXT, textSixDigitLevel4);

        testUnescape(textSixDigitLevel1, TEXT);
        testUnescape(textSixDigitLevel2, TEXT);
        testUnescape(textSixDigitLevel3, TEXT);
        testUnescape(textSixDigitLevel4, TEXT);

    }








    public CssStringEscape04Test() {
        super();
    }


}

