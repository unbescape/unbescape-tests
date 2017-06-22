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
package org.unbescape.javascript;

import org.junit.Test;

import static org.unbescape.javascript.JavaScriptEscapeTestUtil.testEscapeSECUHexa1;
import static org.unbescape.javascript.JavaScriptEscapeTestUtil.testEscapeSECUHexa2;
import static org.unbescape.javascript.JavaScriptEscapeTestUtil.testEscapeSECUHexa3;
import static org.unbescape.javascript.JavaScriptEscapeTestUtil.testEscapeSECUHexa4;
import static org.unbescape.javascript.JavaScriptEscapeTestUtil.testEscapeSECXHexaUHexa1;
import static org.unbescape.javascript.JavaScriptEscapeTestUtil.testEscapeSECXHexaUHexa2;
import static org.unbescape.javascript.JavaScriptEscapeTestUtil.testEscapeSECXHexaUHexa3;
import static org.unbescape.javascript.JavaScriptEscapeTestUtil.testEscapeSECXHexaUHexa4;
import static org.unbescape.javascript.JavaScriptEscapeTestUtil.testEscapeUHexa1;
import static org.unbescape.javascript.JavaScriptEscapeTestUtil.testEscapeUHexa2;
import static org.unbescape.javascript.JavaScriptEscapeTestUtil.testEscapeUHexa3;
import static org.unbescape.javascript.JavaScriptEscapeTestUtil.testEscapeUHexa4;
import static org.unbescape.javascript.JavaScriptEscapeTestUtil.testEscapeXHexaUHexa1;
import static org.unbescape.javascript.JavaScriptEscapeTestUtil.testEscapeXHexaUHexa2;
import static org.unbescape.javascript.JavaScriptEscapeTestUtil.testEscapeXHexaUHexa3;
import static org.unbescape.javascript.JavaScriptEscapeTestUtil.testEscapeXHexaUHexa4;
import static org.unbescape.javascript.JavaScriptEscapeTestUtil.testUnescape;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.0
 *
 */
public class JavaScriptI18nEscapeTest {



    private static final String TEXT =
            "Jako efektivn\u0115j\u0161\u00ED se n\u00E1m jev\u00ED po\u0159\u00E1d\u00E1n\u00ED tzv.\n" +
            "Gira prost\u0159ednictv\u00EDm na\u0161ich autorizovan\u00FDch dealer\u016F v " +
            "\u010Cech\u00E1ch a na Morav\u011B, kter\u00E9 prob\u011Bhnou v pr\u016Fb\u011Bhu " +
            "z\u00E1\u0159\u00ED a \u0159\u00EDjna.";




    @Test
    public void testSECXHexaUHexa() throws Exception {


        final String textSECXHexaUHexaLevel1 =
                "Jako efektivn\u0115j\u0161\u00ED se n\u00E1m jev\u00ED po\u0159\u00E1d\u00E1n\u00ED tzv.\\n" +
                "Gira prost\u0159ednictv\u00EDm na\u0161ich autorizovan\u00FDch dealer\u016F v " +
                "\u010Cech\u00E1ch a na Morav\u011B, kter\u00E9 prob\u011Bhnou v pr\u016Fb\u011Bhu " +
                "z\u00E1\u0159\u00ED a \u0159\u00EDjna.";
        final String textSECXHexaUHexaLevel2 =
                "Jako efektivn\\u0115j\\u0161\\xED se n\\xE1m jev\\xED po\\u0159\\xE1d\\xE1n\\xED tzv.\\n" +
                "Gira prost\\u0159ednictv\\xEDm na\\u0161ich autorizovan\\xFDch dealer\\u016F v " +
                "\\u010Cech\\xE1ch a na Morav\\u011B, kter\\xE9 prob\\u011Bhnou v pr\\u016Fb\\u011Bhu " +
                "z\\xE1\\u0159\\xED a \\u0159\\xEDjna.";
        final String textSECXHexaUHexaLevel3 =
                "Jako\\x20efektivn\\u0115j\\u0161\\xED\\x20se\\x20n\\xE1m\\x20jev\\xED\\x20po" +
                "\\u0159\\xE1d\\xE1n\\xED\\x20tzv\\x2E\\nGira\\x20prost\\u0159ednictv\\xEDm" +
                "\\x20na\\u0161ich\\x20autorizovan\\xFDch\\x20dealer\\u016F\\x20v\\x20\\u010Cech" +
                "\\xE1ch\\x20a\\x20na\\x20Morav\\u011B\\x2C\\x20kter\\xE9\\x20prob\\u011Bhnou" +
                "\\x20v\\x20pr\\u016Fb\\u011Bhu\\x20z\\xE1\\u0159\\xED\\x20a\\x20\\u0159\\xEDjna" +
                "\\x2E";
        final String textSECXHexaUHexaLevel4 =
                "\\x4A\\x61\\x6B\\x6F\\x20\\x65\\x66\\x65\\x6B\\x74\\x69\\x76\\x6E\\u0115" +
                "\\x6A\\u0161\\xED\\x20\\x73\\x65\\x20\\x6E\\xE1\\x6D\\x20\\x6A\\x65\\x76" +
                "\\xED\\x20\\x70\\x6F\\u0159\\xE1\\x64\\xE1\\x6E\\xED\\x20\\x74\\x7A\\x76" +
                "\\x2E\\n\\x47\\x69\\x72\\x61\\x20\\x70\\x72\\x6F\\x73\\x74\\u0159\\x65" +
                "\\x64\\x6E\\x69\\x63\\x74\\x76\\xED\\x6D\\x20\\x6E\\x61\\u0161\\x69\\x63" +
                "\\x68\\x20\\x61\\x75\\x74\\x6F\\x72\\x69\\x7A\\x6F\\x76\\x61\\x6E\\xFD" +
                "\\x63\\x68\\x20\\x64\\x65\\x61\\x6C\\x65\\x72\\u016F\\x20\\x76\\x20\\u010C" +
                "\\x65\\x63\\x68\\xE1\\x63\\x68\\x20\\x61\\x20\\x6E\\x61\\x20\\x4D\\x6F" +
                "\\x72\\x61\\x76\\u011B\\x2C\\x20\\x6B\\x74\\x65\\x72\\xE9\\x20\\x70\\x72" +
                "\\x6F\\x62\\u011B\\x68\\x6E\\x6F\\x75\\x20\\x76\\x20\\x70\\x72\\u016F\\x62" +
                "\\u011B\\x68\\x75\\x20\\x7A\\xE1\\u0159\\xED\\x20\\x61\\x20\\u0159\\xED\\x6A" +
                "\\x6E\\x61\\x2E";

        testEscapeSECXHexaUHexa1(TEXT, textSECXHexaUHexaLevel1);
        testEscapeSECXHexaUHexa2(TEXT, textSECXHexaUHexaLevel2);
        testEscapeSECXHexaUHexa3(TEXT, textSECXHexaUHexaLevel3);
        testEscapeSECXHexaUHexa4(TEXT, textSECXHexaUHexaLevel4);

        testUnescape(textSECXHexaUHexaLevel1, TEXT);
        testUnescape(textSECXHexaUHexaLevel2, TEXT);
        testUnescape(textSECXHexaUHexaLevel3, TEXT);
        testUnescape(textSECXHexaUHexaLevel4, TEXT);

    }





    @Test
    public void testSECUHexa() throws Exception {

        final String textSECUHexaLevel1 =
                "Jako efektivn\u0115j\u0161\u00ED se n\u00E1m jev\u00ED po\u0159\u00E1d\u00E1n\u00ED tzv.\\n" +
                "Gira prost\u0159ednictv\u00EDm na\u0161ich autorizovan\u00FDch dealer\u016F v " +
                "\u010Cech\u00E1ch a na Morav\u011B, kter\u00E9 prob\u011Bhnou v pr\u016Fb\u011Bhu " +
                "z\u00E1\u0159\u00ED a \u0159\u00EDjna.";
        final String textSECUHexaLevel2 =
                "Jako efektivn\\u0115j\\u0161\\u00ED se n\\u00E1m jev\\u00ED po\\u0159\\u00E1d\\u00E1n\\u00ED tzv.\\n" +
                "Gira prost\\u0159ednictv\\u00EDm na\\u0161ich autorizovan\\u00FDch dealer\\u016F v " +
                "\\u010Cech\\u00E1ch a na Morav\\u011B, kter\\u00E9 prob\\u011Bhnou v pr\\u016Fb\\u011Bhu z\\u00E1\\u0159\\u00ED a \\u0159\\u00EDjna.";
        final String textSECUHexaLevel3 =
                "Jako\\u0020efektivn\\u0115j\\u0161\\u00ED\\u0020se\\u0020n\\u00E1m\\u0020jev\\u00ED\\u0020po" +
                "\\u0159\\u00E1d\\u00E1n\\u00ED\\u0020tzv\\u002E\\nGira\\u0020prost\\u0159ednictv\\u00EDm" +
                "\\u0020na\\u0161ich\\u0020autorizovan\\u00FDch\\u0020dealer\\u016F\\u0020v\\u0020\\u010Cech" +
                "\\u00E1ch\\u0020a\\u0020na\\u0020Morav\\u011B\\u002C\\u0020kter\\u00E9\\u0020prob\\u011Bhnou" +
                "\\u0020v\\u0020pr\\u016Fb\\u011Bhu\\u0020z\\u00E1\\u0159\\u00ED\\u0020a\\u0020\\u0159\\u00EDjna" +
                "\\u002E";
        final String textSECUHexaLevel4 =
                "\\u004A\\u0061\\u006B\\u006F\\u0020\\u0065\\u0066\\u0065\\u006B\\u0074\\u0069\\u0076\\u006E\\u0115" +
                "\\u006A\\u0161\\u00ED\\u0020\\u0073\\u0065\\u0020\\u006E\\u00E1\\u006D\\u0020\\u006A\\u0065\\u0076" +
                "\\u00ED\\u0020\\u0070\\u006F\\u0159\\u00E1\\u0064\\u00E1\\u006E\\u00ED\\u0020\\u0074\\u007A\\u0076" +
                "\\u002E\\n\\u0047\\u0069\\u0072\\u0061\\u0020\\u0070\\u0072\\u006F\\u0073\\u0074\\u0159\\u0065" +
                "\\u0064\\u006E\\u0069\\u0063\\u0074\\u0076\\u00ED\\u006D\\u0020\\u006E\\u0061\\u0161\\u0069\\u0063" +
                "\\u0068\\u0020\\u0061\\u0075\\u0074\\u006F\\u0072\\u0069\\u007A\\u006F\\u0076\\u0061\\u006E\\u00FD" +
                "\\u0063\\u0068\\u0020\\u0064\\u0065\\u0061\\u006C\\u0065\\u0072\\u016F\\u0020\\u0076\\u0020\\u010C" +
                "\\u0065\\u0063\\u0068\\u00E1\\u0063\\u0068\\u0020\\u0061\\u0020\\u006E\\u0061\\u0020\\u004D\\u006F" +
                "\\u0072\\u0061\\u0076\\u011B\\u002C\\u0020\\u006B\\u0074\\u0065\\u0072\\u00E9\\u0020\\u0070\\u0072" +
                "\\u006F\\u0062\\u011B\\u0068\\u006E\\u006F\\u0075\\u0020\\u0076\\u0020\\u0070\\u0072\\u016F\\u0062" +
                "\\u011B\\u0068\\u0075\\u0020\\u007A\\u00E1\\u0159\\u00ED\\u0020\\u0061\\u0020\\u0159\\u00ED\\u006A" +
                "\\u006E\\u0061\\u002E";

        testEscapeSECUHexa1(TEXT, textSECUHexaLevel1);
        testEscapeSECUHexa2(TEXT, textSECUHexaLevel2);
        testEscapeSECUHexa3(TEXT, textSECUHexaLevel3);
        testEscapeSECUHexa4(TEXT, textSECUHexaLevel4);

        testUnescape(textSECUHexaLevel1, TEXT);
        testUnescape(textSECUHexaLevel2, TEXT);
        testUnescape(textSECUHexaLevel3, TEXT);
        testUnescape(textSECUHexaLevel4, TEXT);

    }





    @Test
    public void testXHexaUHexa() throws Exception {

        final String textXHexaUHexaLevel1 =
                "Jako efektivn\u0115j\u0161\u00ED se n\u00E1m jev\u00ED po\u0159\u00E1d\u00E1n\u00ED tzv.\\x0A" +
                "Gira prost\u0159ednictv\u00EDm na\u0161ich autorizovan\u00FDch dealer\u016F v " +
                "\u010Cech\u00E1ch a na Morav\u011B, kter\u00E9 prob\u011Bhnou v pr\u016Fb\u011Bhu " +
                "z\u00E1\u0159\u00ED a \u0159\u00EDjna.";
        final String textXHexaUHexaLevel2 =
                "Jako efektivn\\u0115j\\u0161\\xED se n\\xE1m jev\\xED po\\u0159\\xE1d\\xE1n\\xED tzv.\\x0A" +
                "Gira prost\\u0159ednictv\\xEDm na\\u0161ich autorizovan\\xFDch dealer\\u016F v " +
                "\\u010Cech\\xE1ch a na Morav\\u011B, kter\\xE9 prob\\u011Bhnou v pr\\u016Fb\\u011Bhu " +
                "z\\xE1\\u0159\\xED a \\u0159\\xEDjna.";
        final String textXHexaUHexaLevel3 =
                "Jako\\x20efektivn\\u0115j\\u0161\\xED\\x20se\\x20n\\xE1m\\x20jev\\xED\\x20po" +
                "\\u0159\\xE1d\\xE1n\\xED\\x20tzv\\x2E\\x0AGira\\x20prost\\u0159ednictv\\xEDm" +
                "\\x20na\\u0161ich\\x20autorizovan\\xFDch\\x20dealer\\u016F\\x20v\\x20\\u010Cech" +
                "\\xE1ch\\x20a\\x20na\\x20Morav\\u011B\\x2C\\x20kter\\xE9\\x20prob\\u011Bhnou" +
                "\\x20v\\x20pr\\u016Fb\\u011Bhu\\x20z\\xE1\\u0159\\xED\\x20a\\x20\\u0159\\xEDjna" +
                "\\x2E";
        final String textXHexaUHexaLevel4 =
                "\\x4A\\x61\\x6B\\x6F\\x20\\x65\\x66\\x65\\x6B\\x74\\x69\\x76\\x6E\\u0115" +
                "\\x6A\\u0161\\xED\\x20\\x73\\x65\\x20\\x6E\\xE1\\x6D\\x20\\x6A\\x65\\x76" +
                "\\xED\\x20\\x70\\x6F\\u0159\\xE1\\x64\\xE1\\x6E\\xED\\x20\\x74\\x7A\\x76" +
                "\\x2E\\x0A\\x47\\x69\\x72\\x61\\x20\\x70\\x72\\x6F\\x73\\x74\\u0159\\x65" +
                "\\x64\\x6E\\x69\\x63\\x74\\x76\\xED\\x6D\\x20\\x6E\\x61\\u0161\\x69\\x63" +
                "\\x68\\x20\\x61\\x75\\x74\\x6F\\x72\\x69\\x7A\\x6F\\x76\\x61\\x6E\\xFD" +
                "\\x63\\x68\\x20\\x64\\x65\\x61\\x6C\\x65\\x72\\u016F\\x20\\x76\\x20\\u010C" +
                "\\x65\\x63\\x68\\xE1\\x63\\x68\\x20\\x61\\x20\\x6E\\x61\\x20\\x4D\\x6F" +
                "\\x72\\x61\\x76\\u011B\\x2C\\x20\\x6B\\x74\\x65\\x72\\xE9\\x20\\x70\\x72" +
                "\\x6F\\x62\\u011B\\x68\\x6E\\x6F\\x75\\x20\\x76\\x20\\x70\\x72\\u016F\\x62" +
                "\\u011B\\x68\\x75\\x20\\x7A\\xE1\\u0159\\xED\\x20\\x61\\x20\\u0159\\xED\\x6A" +
                "\\x6E\\x61\\x2E";

        testEscapeXHexaUHexa1(TEXT, textXHexaUHexaLevel1);
        testEscapeXHexaUHexa2(TEXT, textXHexaUHexaLevel2);
        testEscapeXHexaUHexa3(TEXT, textXHexaUHexaLevel3);
        testEscapeXHexaUHexa4(TEXT, textXHexaUHexaLevel4);

        testUnescape(textXHexaUHexaLevel1, TEXT);
        testUnescape(textXHexaUHexaLevel2, TEXT);
        testUnescape(textXHexaUHexaLevel3, TEXT);
        testUnescape(textXHexaUHexaLevel4, TEXT);

    }





    @Test
    public void testUHexa() throws Exception {

        final String textUHexaLevel1 =
                "Jako efektivn\u0115j\u0161\u00ED se n\u00E1m jev\u00ED po\u0159\u00E1d\u00E1n\u00ED tzv.\\u000A" +
                "Gira prost\u0159ednictv\u00EDm na\u0161ich autorizovan\u00FDch dealer\u016F v " +
                "\u010Cech\u00E1ch a na Morav\u011B, kter\u00E9 prob\u011Bhnou v pr\u016Fb\u011Bhu " +
                "z\u00E1\u0159\u00ED a \u0159\u00EDjna.";
        final String textUHexaLevel2 =
                "Jako efektivn\\u0115j\\u0161\\u00ED se n\\u00E1m jev\\u00ED po\\u0159\\u00E1d\\u00E1n\\u00ED tzv.\\u000A" +
                "Gira prost\\u0159ednictv\\u00EDm na\\u0161ich autorizovan\\u00FDch dealer\\u016F v " +
                "\\u010Cech\\u00E1ch a na Morav\\u011B, kter\\u00E9 prob\\u011Bhnou v pr\\u016Fb\\u011Bhu z\\u00E1\\u0159\\u00ED a \\u0159\\u00EDjna.";
        final String textUHexaLevel3 =
                "Jako\\u0020efektivn\\u0115j\\u0161\\u00ED\\u0020se\\u0020n\\u00E1m\\u0020jev\\u00ED\\u0020po" +
                "\\u0159\\u00E1d\\u00E1n\\u00ED\\u0020tzv\\u002E\\u000AGira\\u0020prost\\u0159ednictv\\u00EDm" +
                "\\u0020na\\u0161ich\\u0020autorizovan\\u00FDch\\u0020dealer\\u016F\\u0020v\\u0020\\u010Cech" +
                "\\u00E1ch\\u0020a\\u0020na\\u0020Morav\\u011B\\u002C\\u0020kter\\u00E9\\u0020prob\\u011Bhnou" +
                "\\u0020v\\u0020pr\\u016Fb\\u011Bhu\\u0020z\\u00E1\\u0159\\u00ED\\u0020a\\u0020\\u0159\\u00EDjna" +
                "\\u002E";
        final String textUHexaLevel4 =
                "\\u004A\\u0061\\u006B\\u006F\\u0020\\u0065\\u0066\\u0065\\u006B\\u0074\\u0069\\u0076\\u006E\\u0115" +
                "\\u006A\\u0161\\u00ED\\u0020\\u0073\\u0065\\u0020\\u006E\\u00E1\\u006D\\u0020\\u006A\\u0065\\u0076" +
                "\\u00ED\\u0020\\u0070\\u006F\\u0159\\u00E1\\u0064\\u00E1\\u006E\\u00ED\\u0020\\u0074\\u007A\\u0076" +
                "\\u002E\\u000A\\u0047\\u0069\\u0072\\u0061\\u0020\\u0070\\u0072\\u006F\\u0073\\u0074\\u0159\\u0065" +
                "\\u0064\\u006E\\u0069\\u0063\\u0074\\u0076\\u00ED\\u006D\\u0020\\u006E\\u0061\\u0161\\u0069\\u0063" +
                "\\u0068\\u0020\\u0061\\u0075\\u0074\\u006F\\u0072\\u0069\\u007A\\u006F\\u0076\\u0061\\u006E\\u00FD" +
                "\\u0063\\u0068\\u0020\\u0064\\u0065\\u0061\\u006C\\u0065\\u0072\\u016F\\u0020\\u0076\\u0020\\u010C" +
                "\\u0065\\u0063\\u0068\\u00E1\\u0063\\u0068\\u0020\\u0061\\u0020\\u006E\\u0061\\u0020\\u004D\\u006F" +
                "\\u0072\\u0061\\u0076\\u011B\\u002C\\u0020\\u006B\\u0074\\u0065\\u0072\\u00E9\\u0020\\u0070\\u0072" +
                "\\u006F\\u0062\\u011B\\u0068\\u006E\\u006F\\u0075\\u0020\\u0076\\u0020\\u0070\\u0072\\u016F\\u0062" +
                "\\u011B\\u0068\\u0075\\u0020\\u007A\\u00E1\\u0159\\u00ED\\u0020\\u0061\\u0020\\u0159\\u00ED\\u006A" +
                "\\u006E\\u0061\\u002E";

        testEscapeUHexa1(TEXT, textUHexaLevel1);
        testEscapeUHexa2(TEXT, textUHexaLevel2);
        testEscapeUHexa3(TEXT, textUHexaLevel3);
        testEscapeUHexa4(TEXT, textUHexaLevel4);

        testUnescape(textUHexaLevel1, TEXT);
        testUnescape(textUHexaLevel2, TEXT);
        testUnescape(textUHexaLevel3, TEXT);
        testUnescape(textUHexaLevel4, TEXT);

    }





    @Test
    public void testOctal() throws Exception {


        final String textOctalLevel1 =
                "Jako efektivn\u0115j\u0161\u00ED se n\u00E1m jev\u00ED po\u0159\u00E1d\u00E1n\u00ED tzv.\\012" +
                "Gira prost\u0159ednictv\u00EDm na\u0161ich autorizovan\u00FDch dealer\u016F v " +
                "\u010Cech\u00E1ch a na Morav\u011B, kter\u00E9 prob\u011Bhnou v pr\u016Fb\u011Bhu " +
                "z\u00E1\u0159\u00ED a \u0159\u00EDjna.";
        final String textOctalLevel2 =
                "Jako efektivn\\u0115j\\u0161\\xED se n\\341m jev\\xED po\\u0159\\341d\\341n\\xED tzv.\\12" +
                "Gira prost\\u0159ednictv\\xEDm na\\u0161ich autorizovan\\xFDch dealer\\u016F v " +
                "\\u010Cech\\341ch a na Morav\\u011B, kter\\xE9 prob\\u011Bhnou v pr\\u016Fb\\u011Bhu " +
                "z\\341\\u0159\\xED a \\u0159\\xEDjna.";
        final String textOctalLevel3 =
                "Jako\\x20efektivn\\u0115j\\u0161\\xED\\x20se\\x20n\\341m\\x20jev\\xED\\x20po" +
                "\\u0159\\341d\\341n\\xED\\x20tzv\\56\\012Gira\\x20prost\\u0159ednictv\\xEDm" +
                "\\x20na\\u0161ich\\x20autorizovan\\xFDch\\x20dealer\\u016F\\x20v\\x20\\u010Cech" +
                "\\341ch\\x20a\\x20na\\x20Morav\\u011B\\x2C\\x20kter\\xE9\\x20prob\\u011Bhnou" +
                "\\x20v\\x20pr\\u016Fb\\u011Bhu\\x20z\\341\\u0159\\xED\\x20a\\x20\\u0159\\xEDjna" +
                "\\056";
        final String textOctalLevel4 =
                "\\112\\x61\\153\\x6F\\x20\\x65\\x66\\x65\\153\\x74\\x69\\x76\\x6E\\u0115" +
                "\\x6A\\u0161\\xED\\x20\\x73\\x65\\x20\\x6E\\341\\x6D\\x20\\x6A\\x65\\x76" +
                "\\xED\\x20\\x70\\x6F\\u0159\\341\\x64\\341\\x6E\\xED\\x20\\x74\\x7A\\x76" +
                "\\56\\12\\x47\\x69\\x72\\141\\x20\\x70\\x72\\x6F\\x73\\x74\\u0159\\x65" +
                "\\x64\\x6E\\x69\\x63\\x74\\x76\\xED\\x6D\\x20\\x6E\\141\\u0161\\x69\\x63" +
                "\\x68\\x20\\141\\x75\\x74\\x6F\\x72\\x69\\x7A\\x6F\\x76\\141\\x6E\\xFD" +
                "\\x63\\x68\\x20\\x64\\x65\\141\\x6C\\x65\\x72\\u016F\\x20\\x76\\x20\\u010C" +
                "\\x65\\x63\\x68\\341\\x63\\x68\\x20\\141\\x20\\x6E\\141\\x20\\x4D\\x6F" +
                "\\x72\\141\\x76\\u011B\\x2C\\x20\\153\\x74\\x65\\x72\\xE9\\x20\\x70\\x72" +
                "\\x6F\\x62\\u011B\\x68\\x6E\\x6F\\x75\\x20\\x76\\x20\\x70\\x72\\u016F\\x62" +
                "\\u011B\\x68\\x75\\x20\\x7A\\341\\u0159\\xED\\x20\\141\\x20\\u0159\\xED\\x6A" +
                "\\x6E\\141\\56";

        testUnescape(textOctalLevel1, TEXT);
        testUnescape(textOctalLevel2, TEXT);
        testUnescape(textOctalLevel3, TEXT);
        testUnescape(textOctalLevel4, TEXT);

    }



    public JavaScriptI18nEscapeTest() {
        super();
    }


}

