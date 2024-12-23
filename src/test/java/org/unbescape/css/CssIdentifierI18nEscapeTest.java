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
public class CssIdentifierI18nEscapeTest {



    private static final String TEXT =
            "Jako efektivn\u0115j\u0161\u00ED se n\u00E1m jev\u00ED po\u0159\u00E1d\u00E1n\u00ED tzv.\n" +
            "Gira prost\u0159ednictv\u00EDm na\u0161ich autorizovan\u00FDch dealer\u016F v " +
            "\u010Cech\u00E1ch a na Morav\u011B, kter\u00E9 prob\u011Bhnou v pr\u016Fb\u011Bhu " +
            "z\u00E1\u0159\u00ED a \u0159\u00EDjna.";




    @Test
    public void testBECompact() throws Exception {


        final String textBECompactLevel1 =
                "Jako\\ efektivn\u0115j\u0161\u00ED\\ se\\ n\u00E1m\\ jev\u00ED\\ po\u0159\u00E1d\u00E1n\u00ED\\ tzv\\.\\A" +
                "Gira\\ prost\u0159ednictv\u00EDm\\ na\u0161ich\\ autorizovan\u00FDch\\ dealer\u016F\\ v\\ " +
                "\u010Cech\u00E1ch\\ a\\ na\\ Morav\u011B\\,\\ kter\u00E9\\ prob\u011Bhnou\\ v\\ pr\u016Fb\u011Bhu\\ " +
                "z\u00E1\u0159\u00ED\\ a\\ \u0159\u00EDjna\\.";
        final String textBECompactLevel2 =
                "Jako\\ efektivn\\115j\\161\\ED\\ se\\ n\\E1m\\ jev\\ED\\ po\\159\\E1 d\\E1n\\ED\\ tzv\\.\\A" +
                "Gira\\ prost\\159 ednictv\\EDm\\ na\\161ich\\ autorizovan\\FD ch\\ dealer\\16F\\ v\\ \\10C ech\\E1 " +
                "ch\\ a\\ na\\ Morav\\11B\\,\\ kter\\E9\\ prob\\11Bhnou\\ v\\ pr\\16F b\\11Bhu\\ z\\E1\\159\\ED\\ " +
                "a\\ \\159\\EDjna\\.";
        final String textBECompactLevel3 =
                "Jako\\ efektivn\\115j\\161\\ED\\ se\\ n\\E1m\\ jev\\ED\\ po\\159\\E1 d\\E1n\\ED\\ tzv\\.\\A" +
                "Gira\\ prost\\159 ednictv\\EDm\\ na\\161ich\\ autorizovan\\FD ch\\ dealer\\16F\\ v\\ \\10C ech\\E1 " +
                "ch\\ a\\ na\\ Morav\\11B\\,\\ kter\\E9\\ prob\\11Bhnou\\ v\\ pr\\16F b\\11Bhu\\ z\\E1\\159\\ED\\ " +
                "a\\ \\159\\EDjna\\.";
        final String textBECompactLevel4 =
                "\\4A\\61\\6B\\6F\\ \\65\\66\\65\\6B\\74\\69\\76\\6E\\115\\6A\\161\\ED\\ \\73\\65\\ \\6E\\E1" +
                "\\6D\\ \\6A\\65\\76\\ED\\ \\70\\6F\\159\\E1\\64\\E1\\6E\\ED\\ \\74\\7A\\76\\.\\A\\47\\69\\72" +
                "\\61\\ \\70\\72\\6F\\73\\74\\159\\65\\64\\6E\\69\\63\\74\\76\\ED\\6D\\ \\6E\\61\\161\\69\\63\\68" +
                "\\ \\61\\75\\74\\6F\\72\\69\\7A\\6F\\76\\61\\6E\\FD\\63\\68\\ \\64\\65\\61\\6C\\65\\72\\16F\\ " +
                "\\76\\ \\10C\\65\\63\\68\\E1\\63\\68\\ \\61\\ \\6E\\61\\ \\4D\\6F\\72\\61\\76\\11B\\,\\ \\6B\\74" +
                "\\65\\72\\E9\\ \\70\\72\\6F\\62\\11B\\68\\6E\\6F\\75\\ \\76\\ \\70\\72\\16F\\62\\11B\\68\\75\\ " +
                "\\7A\\E1\\159\\ED\\ \\61\\ \\159\\ED\\6A\\6E\\61\\.";

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
                "Jako\\ efektivn\u0115j\u0161\u00ED\\ se\\ n\u00E1m\\ jev\u00ED\\ po\u0159\u00E1d\u00E1n\u00ED\\ tzv\\.\\00000A" +
                "Gira\\ prost\u0159ednictv\u00EDm\\ na\u0161ich\\ autorizovan\u00FDch\\ dealer\u016F\\ v\\ " +
                "\u010Cech\u00E1ch\\ a\\ na\\ Morav\u011B\\,\\ kter\u00E9\\ prob\u011Bhnou\\ v\\ pr\u016Fb\u011Bhu\\ " +
                "z\u00E1\u0159\u00ED\\ a\\ \u0159\u00EDjna\\.";
        final String textBESixDigitLevel2 =
                "Jako\\ efektivn\\000115j\\000161\\0000ED\\ se\\ n\\0000E1m\\ jev\\0000ED\\ " +
                "po\\000159\\0000E1d\\0000E1n\\0000ED\\ tzv\\.\\00000AGira\\ prost\\000159ednictv\\0000EDm\\ " +
                "na\\000161ich\\ autorizovan\\0000FDch\\ dealer\\00016F\\ v\\ \\00010Cech\\0000E1ch\\ a\\ na\\ " +
                "Morav\\00011B\\,\\ kter\\0000E9\\ prob\\00011Bhnou\\ v\\ pr\\00016Fb\\00011Bhu\\ " +
                "z\\0000E1\\000159\\0000ED\\ a\\ \\000159\\0000EDjna\\.";
        final String textBESixDigitLevel3 =
                "Jako\\ efektivn\\000115j\\000161\\0000ED\\ se\\ n\\0000E1m\\ jev\\0000ED\\ " +
                "po\\000159\\0000E1d\\0000E1n\\0000ED\\ tzv\\.\\00000AGira\\ prost\\000159ednictv\\0000EDm\\ " +
                "na\\000161ich\\ autorizovan\\0000FDch\\ dealer\\00016F\\ v\\ \\00010Cech\\0000E1ch\\ a\\ na\\ " +
                "Morav\\00011B\\,\\ kter\\0000E9\\ prob\\00011Bhnou\\ v\\ pr\\00016Fb\\00011Bhu\\ " +
                "z\\0000E1\\000159\\0000ED\\ a\\ \\000159\\0000EDjna\\.";
        final String textBESixDigitLevel4 =
                "\\00004A\\000061\\00006B\\00006F\\ \\000065\\000066\\000065\\00006B\\000074\\000069\\000076" +
                "\\00006E\\000115\\00006A\\000161\\0000ED\\ \\000073\\000065\\ \\00006E\\0000E1\\00006D\\ \\00006A" +
                "\\000065\\000076\\0000ED\\ \\000070\\00006F\\000159\\0000E1\\000064\\0000E1\\00006E\\0000ED\\ " +
                "\\000074\\00007A\\000076\\.\\00000A\\000047\\000069\\000072\\000061\\ \\000070\\000072\\00006F" +
                "\\000073\\000074\\000159\\000065\\000064\\00006E\\000069\\000063\\000074\\000076\\0000ED\\00006D" +
                "\\ \\00006E\\000061\\000161\\000069\\000063\\000068\\ \\000061\\000075\\000074\\00006F\\000072" +
                "\\000069\\00007A\\00006F\\000076\\000061\\00006E\\0000FD\\000063\\000068\\ \\000064\\000065\\000061" +
                "\\00006C\\000065\\000072\\00016F\\ \\000076\\ \\00010C\\000065\\000063\\000068\\0000E1\\000063" +
                "\\000068\\ \\000061\\ \\00006E\\000061\\ \\00004D\\00006F\\000072\\000061\\000076\\00011B\\,\\ " +
                "\\00006B\\000074\\000065\\000072\\0000E9\\ \\000070\\000072\\00006F\\000062\\00011B\\000068" +
                "\\00006E\\00006F\\000075\\ \\000076\\ \\000070\\000072\\00016F\\000062\\00011B\\000068\\000075\\ " +
                "\\00007A\\0000E1\\000159\\0000ED\\ \\000061\\ \\000159\\0000ED\\00006A\\00006E\\000061\\.";

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
                "Jako\\20 efektivn\u0115j\u0161\u00ED\\20se\\20n\u00E1m\\20jev\u00ED\\20po\u0159\u00E1d\u00E1n\u00ED\\20tzv\\2E\\A" +
                "Gira\\20prost\u0159ednictv\u00EDm\\20na\u0161ich\\20 autorizovan\u00FDch\\20 dealer\u016F\\20v\\20" +
                "\u010Cech\u00E1ch\\20 a\\20na\\20Morav\u011B\\2C\\20kter\u00E9\\20prob\u011Bhnou\\20v\\20pr\u016Fb\u011Bhu\\20" +
                "z\u00E1\u0159\u00ED\\20 a\\20\u0159\u00EDjna\\2E";
        final String textCompactLevel2 =
                "Jako\\20 efektivn\\115j\\161\\ED\\20se\\20n\\E1m\\20jev\\ED\\20po\\159\\E1 d\\E1n\\ED\\20tzv\\2E\\A" +
                "Gira\\20prost\\159 ednictv\\EDm\\20na\\161ich\\20 autorizovan\\FD ch\\20 dealer\\16F\\20v\\20\\10C " +
                "ech\\E1 ch\\20 a\\20na\\20Morav\\11B\\2C\\20kter\\E9\\20prob\\11Bhnou\\20v\\20pr\\16F b\\11Bhu\\20" +
                "z\\E1\\159\\ED\\20 a\\20\\159\\EDjna\\2E";
        final String textCompactLevel3 =
                "Jako\\20 efektivn\\115j\\161\\ED\\20se\\20n\\E1m\\20jev\\ED\\20po\\159\\E1 d\\E1n\\ED\\20tzv\\2E\\A" +
                "Gira\\20prost\\159 ednictv\\EDm\\20na\\161ich\\20 autorizovan\\FD ch\\20 dealer\\16F\\20v\\20\\10C " +
                "ech\\E1 ch\\20 a\\20na\\20Morav\\11B\\2C\\20kter\\E9\\20prob\\11Bhnou\\20v\\20pr\\16F b\\11Bhu\\20" +
                "z\\E1\\159\\ED\\20 a\\20\\159\\EDjna\\2E";
        final String textCompactLevel4 =
                "\\4A\\61\\6B\\6F\\20\\65\\66\\65\\6B\\74\\69\\76\\6E\\115\\6A\\161\\ED\\20\\73\\65\\20\\6E" +
                "\\E1\\6D\\20\\6A\\65\\76\\ED\\20\\70\\6F\\159\\E1\\64\\E1\\6E\\ED\\20\\74\\7A\\76\\2E\\A\\47" +
                "\\69\\72\\61\\20\\70\\72\\6F\\73\\74\\159\\65\\64\\6E\\69\\63\\74\\76\\ED\\6D\\20\\6E\\61\\161" +
                "\\69\\63\\68\\20\\61\\75\\74\\6F\\72\\69\\7A\\6F\\76\\61\\6E\\FD\\63\\68\\20\\64\\65\\61\\6C\\65" +
                "\\72\\16F\\20\\76\\20\\10C\\65\\63\\68\\E1\\63\\68\\20\\61\\20\\6E\\61\\20\\4D\\6F\\72\\61\\76\\11B" +
                "\\2C\\20\\6B\\74\\65\\72\\E9\\20\\70\\72\\6F\\62\\11B\\68\\6E\\6F\\75\\20\\76\\20\\70\\72\\16F\\62" +
                "\\11B\\68\\75\\20\\7A\\E1\\159\\ED\\20\\61\\20\\159\\ED\\6A\\6E\\61\\2E";

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
                "Jako\\000020efektivn\u0115j\u0161\u00ED\\000020se\\000020n\u00E1m\\000020jev\u00ED\\000020po\u0159\u00E1d\u00E1n\u00ED\\000020tzv\\00002E\\00000A" +
                "Gira\\000020prost\u0159ednictv\u00EDm\\000020na\u0161ich\\000020autorizovan\u00FDch\\000020dealer\u016F\\000020v\\000020" +
                "\u010Cech\u00E1ch\\000020a\\000020na\\000020Morav\u011B\\00002C\\000020kter\u00E9\\000020prob\u011Bhnou\\000020v\\000020pr\u016Fb\u011Bhu\\000020" +
                "z\u00E1\u0159\u00ED\\000020a\\000020\u0159\u00EDjna\\00002E";
        final String textSixDigitLevel2 =
                "Jako\\000020efektivn\\000115j\\000161\\0000ED\\000020se\\000020n\\0000E1m\\000020jev\\0000ED" +
                "\\000020po\\000159\\0000E1d\\0000E1n\\0000ED\\000020tzv\\00002E\\00000AGira\\000020prost" +
                "\\000159ednictv\\0000EDm\\000020na\\000161ich\\000020autorizovan\\0000FDch\\000020dealer" +
                "\\00016F\\000020v\\000020\\00010Cech\\0000E1ch\\000020a\\000020na\\000020Morav\\00011B" +
                "\\00002C\\000020kter\\0000E9\\000020prob\\00011Bhnou\\000020v\\000020pr\\00016Fb\\00011Bhu" +
                "\\000020z\\0000E1\\000159\\0000ED\\000020a\\000020\\000159\\0000EDjna\\00002E";
        final String textSixDigitLevel3 =
                "Jako\\000020efektivn\\000115j\\000161\\0000ED\\000020se\\000020n\\0000E1m\\000020jev" +
                "\\0000ED\\000020po\\000159\\0000E1d\\0000E1n\\0000ED\\000020tzv\\00002E\\00000A" +
                "Gira\\000020prost\\000159ednictv\\0000EDm\\000020na\\000161ich\\000020autorizovan\\0000FD" +
                "ch\\000020dealer\\00016F\\000020v\\000020\\00010Cech\\0000E1ch\\000020a\\000020na\\000020" +
                "Morav\\00011B\\00002C\\000020kter\\0000E9\\000020prob\\00011Bhnou\\000020v\\000020pr\\00016Fb" +
                "\\00011Bhu\\000020z\\0000E1\\000159\\0000ED\\000020a\\000020\\000159\\0000EDjna\\00002E";
        final String textSixDigitLevel4 =
                "\\00004A\\000061\\00006B\\00006F\\000020\\000065\\000066\\000065\\00006B\\000074\\000069" +
                "\\000076\\00006E\\000115\\00006A\\000161\\0000ED\\000020\\000073\\000065\\000020\\00006E" +
                "\\0000E1\\00006D\\000020\\00006A\\000065\\000076\\0000ED\\000020\\000070\\00006F\\000159" +
                "\\0000E1\\000064\\0000E1\\00006E\\0000ED\\000020\\000074\\00007A\\000076\\00002E\\00000A" +
                "\\000047\\000069\\000072\\000061\\000020\\000070\\000072\\00006F\\000073\\000074\\000159" +
                "\\000065\\000064\\00006E\\000069\\000063\\000074\\000076\\0000ED\\00006D\\000020\\00006E" +
                "\\000061\\000161\\000069\\000063\\000068\\000020\\000061\\000075\\000074\\00006F\\000072" +
                "\\000069\\00007A\\00006F\\000076\\000061\\00006E\\0000FD\\000063\\000068\\000020\\000064" +
                "\\000065\\000061\\00006C\\000065\\000072\\00016F\\000020\\000076\\000020\\00010C\\000065" +
                "\\000063\\000068\\0000E1\\000063\\000068\\000020\\000061\\000020\\00006E\\000061\\000020" +
                "\\00004D\\00006F\\000072\\000061\\000076\\00011B\\00002C\\000020\\00006B\\000074\\000065" +
                "\\000072\\0000E9\\000020\\000070\\000072\\00006F\\000062\\00011B\\000068\\00006E\\00006F" +
                "\\000075\\000020\\000076\\000020\\000070\\000072\\00016F\\000062\\00011B\\000068\\000075" +
                "\\000020\\00007A\\0000E1\\000159\\0000ED\\000020\\000061\\000020\\000159\\0000ED\\00006A" +
                "\\00006E\\000061\\00002E";

        testEscapeSixDigit1(TEXT, textSixDigitLevel1);
        testEscapeSixDigit2(TEXT, textSixDigitLevel2);
        testEscapeSixDigit3(TEXT, textSixDigitLevel3);
        testEscapeSixDigit4(TEXT, textSixDigitLevel4);

        testUnescape(textSixDigitLevel1, TEXT);
        testUnescape(textSixDigitLevel2, TEXT);
        testUnescape(textSixDigitLevel3, TEXT);
        testUnescape(textSixDigitLevel4, TEXT);

    }



    public CssIdentifierI18nEscapeTest() {
        super();
    }


}

