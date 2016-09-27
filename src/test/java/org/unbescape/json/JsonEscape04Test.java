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
package org.unbescape.json;

import org.junit.Test;

import static org.unbescape.json.JsonEscapeTestUtil.testEscapeSECUHexa1;
import static org.unbescape.json.JsonEscapeTestUtil.testEscapeSECUHexa2;
import static org.unbescape.json.JsonEscapeTestUtil.testEscapeSECUHexa3;
import static org.unbescape.json.JsonEscapeTestUtil.testEscapeSECUHexa4;
import static org.unbescape.json.JsonEscapeTestUtil.testEscapeUHexa1;
import static org.unbescape.json.JsonEscapeTestUtil.testEscapeUHexa2;
import static org.unbescape.json.JsonEscapeTestUtil.testEscapeUHexa3;
import static org.unbescape.json.JsonEscapeTestUtil.testEscapeUHexa4;
import static org.unbescape.json.JsonEscapeTestUtil.testUnescape;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.0
 *
 */
public class JsonEscape04Test {


    private static final String TEXT =
            "<>&'\"ABCDEFGHIJKLMNOPQRSTUVWXYZ <>&'\" \u00E0\u00E1\u00E2\u00E3\u00E4\u00E5\u00E6abcdefghijklmnopqrstuvwxyz <&'\"> 0123456789&<'\">";




    @Test
    public void testSECUHexa() throws Exception {

        final String textSECUHexaLevel1 =
                "<>\\u0026'\\\"ABCDEFGHIJKLMNOPQRSTUVWXYZ <>\\u0026'\\\" \u00E0\u00E1\u00E2\u00E3\u00E4\u00E5\u00E6abcdefghijklmnopqrstuvwxyz <\\u0026'\\\"> 0123456789\\u0026<'\\\">";
        final String textSECUHexaLevel2 =
                "<>\\u0026'\\\"ABCDEFGHIJKLMNOPQRSTUVWXYZ <>\\u0026'\\\" \\u00E0\\u00E1\\u00E2\\u00E3\\u00E4\\u00E5\\u00E6abcdefghijklmnopqrstuvwxyz <\\u0026'\\\"> 0123456789\\u0026<'\\\">";
        final String textSECUHexaLevel3 =
                "\\u003C\\u003E\\u0026\\u0027\\\"ABCDEFGHIJKLMNOPQRSTUVWXYZ\\u0020\\u003C\\u003E\\u0026\\u0027\\\"\\u0020\\u00E0\\u00E1\\u00E2\\u00E3\\u00E4\\u00E5\\u00E6abcdefghijklmnopqrstuvwxyz\\u0020\\u003C\\u0026\\u0027\\\"\\u003E\\u00200123456789\\u0026\\u003C\\u0027\\\"\\u003E";
        final String textSECUHexaLevel4 =
                "\\u003C\\u003E\\u0026\\u0027\\\"\\u0041\\u0042\\u0043\\u0044\\u0045\\u0046\\u0047\\u0048" +
                "\\u0049\\u004A\\u004B\\u004C\\u004D\\u004E\\u004F\\u0050\\u0051\\u0052\\u0053\\u0054" +
                "\\u0055\\u0056\\u0057\\u0058\\u0059\\u005A\\u0020\\u003C\\u003E\\u0026\\u0027\\\"\\u0020" +
                "\\u00E0\\u00E1\\u00E2\\u00E3\\u00E4\\u00E5\\u00E6\\u0061\\u0062\\u0063\\u0064\\u0065" +
                "\\u0066\\u0067\\u0068\\u0069\\u006A\\u006B\\u006C\\u006D\\u006E\\u006F\\u0070\\u0071" +
                "\\u0072\\u0073\\u0074\\u0075\\u0076\\u0077\\u0078\\u0079\\u007A\\u0020\\u003C\\u0026" +
                "\\u0027\\\"\\u003E\\u0020\\u0030\\u0031\\u0032\\u0033\\u0034\\u0035\\u0036\\u0037\\u0038" +
                "\\u0039\\u0026\\u003C\\u0027\\\"\\u003E";

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
    public void testUHexa() throws Exception {

        final String textUHexaLevel1 =
                "<>\\u0026'\\u0022ABCDEFGHIJKLMNOPQRSTUVWXYZ <>\\u0026'\\u0022 \u00E0\u00E1\u00E2\u00E3\u00E4\u00E5\u00E6abcdefghijklmnopqrstuvwxyz <\\u0026'\\u0022> 0123456789\\u0026<'\\u0022>";
        final String textUHexaLevel2 =
                "<>\\u0026'\\u0022ABCDEFGHIJKLMNOPQRSTUVWXYZ <>\\u0026'\\u0022 \\u00E0\\u00E1\\u00E2\\u00E3\\u00E4\\u00E5\\u00E6abcdefghijklmnopqrstuvwxyz <\\u0026'\\u0022> 0123456789\\u0026<'\\u0022>";
        final String textUHexaLevel3 =
                "\\u003C\\u003E\\u0026\\u0027\\u0022ABCDEFGHIJKLMNOPQRSTUVWXYZ\\u0020\\u003C\\u003E\\u0026\\u0027\\u0022\\u0020\\u00E0\\u00E1\\u00E2\\u00E3\\u00E4\\u00E5\\u00E6abcdefghijklmnopqrstuvwxyz\\u0020\\u003C\\u0026\\u0027\\u0022\\u003E\\u00200123456789\\u0026\\u003C\\u0027\\u0022\\u003E";
        final String textUHexaLevel4 =
                "\\u003C\\u003E\\u0026\\u0027\\u0022\\u0041\\u0042\\u0043\\u0044\\u0045\\u0046\\u0047" +
                "\\u0048\\u0049\\u004A\\u004B\\u004C\\u004D\\u004E\\u004F\\u0050\\u0051\\u0052\\u0053" +
                "\\u0054\\u0055\\u0056\\u0057\\u0058\\u0059\\u005A\\u0020\\u003C\\u003E\\u0026\\u0027" +
                "\\u0022\\u0020\\u00E0\\u00E1\\u00E2\\u00E3\\u00E4\\u00E5\\u00E6\\u0061\\u0062\\u0063" +
                "\\u0064\\u0065\\u0066\\u0067\\u0068\\u0069\\u006A\\u006B\\u006C\\u006D\\u006E\\u006F" +
                "\\u0070\\u0071\\u0072\\u0073\\u0074\\u0075\\u0076\\u0077\\u0078\\u0079\\u007A\\u0020" +
                "\\u003C\\u0026\\u0027\\u0022\\u003E\\u0020\\u0030\\u0031\\u0032\\u0033\\u0034\\u0035" +
                "\\u0036\\u0037\\u0038\\u0039\\u0026\\u003C\\u0027\\u0022\\u003E";

        testEscapeUHexa1(TEXT, textUHexaLevel1);
        testEscapeUHexa2(TEXT, textUHexaLevel2);
        testEscapeUHexa3(TEXT, textUHexaLevel3);
        testEscapeUHexa4(TEXT, textUHexaLevel4);

        testUnescape(textUHexaLevel1, TEXT);
        testUnescape(textUHexaLevel2, TEXT);
        testUnescape(textUHexaLevel3, TEXT);
        testUnescape(textUHexaLevel4, TEXT);

    }








    public JsonEscape04Test() {
        super();
    }


}

