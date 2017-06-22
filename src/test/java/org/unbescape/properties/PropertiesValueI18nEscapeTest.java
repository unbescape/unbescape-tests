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
package org.unbescape.properties;

import org.junit.Test;

import static org.unbescape.properties.PropertiesValueEscapeTestUtil.testEscape1;
import static org.unbescape.properties.PropertiesValueEscapeTestUtil.testEscape2;
import static org.unbescape.properties.PropertiesValueEscapeTestUtil.testEscape3;
import static org.unbescape.properties.PropertiesValueEscapeTestUtil.testEscape4;
import static org.unbescape.properties.PropertiesValueEscapeTestUtil.testUnescape;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.0
 *
 */
public class PropertiesValueI18nEscapeTest {



    private static final String TEXT =
            "Jako efektivn\u0115j\u0161\u00ED se n\u00E1m jev\u00ED po\u0159\u00E1d\u00E1n\u00ED tzv.\n" +
            "Gira prost\u0159ednictv\u00EDm na\u0161ich autorizovan\u00FDch dealer\u016F v " +
            "\u010Cech\u00E1ch a na Morav\u011B, kter\u00E9 prob\u011Bhnou v pr\u016Fb\u011Bhu " +
            "z\u00E1\u0159\u00ED a \u0159\u00EDjna.";




    @Test
    public void test() throws Exception {

        final String textLevel1 =
                "Jako efektivn\u0115j\u0161\u00ED se n\u00E1m jev\u00ED po\u0159\u00E1d\u00E1n\u00ED tzv.\\n" +
                "Gira prost\u0159ednictv\u00EDm na\u0161ich autorizovan\u00FDch dealer\u016F v " +
                "\u010Cech\u00E1ch a na Morav\u011B, kter\u00E9 prob\u011Bhnou v pr\u016Fb\u011Bhu " +
                "z\u00E1\u0159\u00ED a \u0159\u00EDjna.";
        final String textLevel2 =
                "Jako efektivn\\u0115j\\u0161\\u00ED se n\\u00E1m jev\\u00ED po\\u0159\\u00E1d\\u00E1n\\u00ED tzv.\\n" +
                "Gira prost\\u0159ednictv\\u00EDm na\\u0161ich autorizovan\\u00FDch dealer\\u016F v " +
                "\\u010Cech\\u00E1ch a na Morav\\u011B, kter\\u00E9 prob\\u011Bhnou v pr\\u016Fb\\u011Bhu z\\u00E1\\u0159\\u00ED a \\u0159\\u00EDjna.";
        final String textLevel3 =
                "Jako\\u0020efektivn\\u0115j\\u0161\\u00ED\\u0020se\\u0020n\\u00E1m\\u0020jev\\u00ED\\u0020po" +
                "\\u0159\\u00E1d\\u00E1n\\u00ED\\u0020tzv\\u002E\\nGira\\u0020prost\\u0159ednictv\\u00EDm" +
                "\\u0020na\\u0161ich\\u0020autorizovan\\u00FDch\\u0020dealer\\u016F\\u0020v\\u0020\\u010Cech" +
                "\\u00E1ch\\u0020a\\u0020na\\u0020Morav\\u011B\\u002C\\u0020kter\\u00E9\\u0020prob\\u011Bhnou" +
                "\\u0020v\\u0020pr\\u016Fb\\u011Bhu\\u0020z\\u00E1\\u0159\\u00ED\\u0020a\\u0020\\u0159\\u00EDjna" +
                "\\u002E";
        final String textLevel4 =
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

        testEscape1(TEXT, textLevel1);
        testEscape2(TEXT, textLevel2);
        testEscape3(TEXT, textLevel3);
        testEscape4(TEXT, textLevel4);

        testUnescape(textLevel1, TEXT);
        testUnescape(textLevel2, TEXT);
        testUnescape(textLevel3, TEXT);
        testUnescape(textLevel4, TEXT);

    }



    public PropertiesValueI18nEscapeTest() {
        super();
    }


}

