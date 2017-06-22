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
public class JavaScriptEscape01Test {


    private static final String TEXT =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";




    @Test
    public void testSECXHexaUHexa() throws Exception {

        final String textSECXHexaUHexaLevel1 = TEXT;
        final String textSECXHexaUHexaLevel2 = TEXT;
        final String textSECXHexaUHexaLevel3 = TEXT;
        final String textSECXHexaUHexaLevel4 =
                "\\x41\\x42\\x43\\x44\\x45\\x46\\x47\\x48\\x49\\x4A\\x4B\\x4C\\x4D\\x4E\\x4F\\x50\\x51\\x52" +
                "\\x53\\x54\\x55\\x56\\x57\\x58\\x59\\x5A\\x61\\x62\\x63\\x64\\x65\\x66\\x67\\x68\\x69\\x6A" +
                "\\x6B\\x6C\\x6D\\x6E\\x6F\\x70\\x71\\x72\\x73\\x74\\x75\\x76\\x77\\x78\\x79\\x7A\\x30\\x31" +
                "\\x32\\x33\\x34\\x35\\x36\\x37\\x38\\x39";

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

        final String textSECUHexaLevel1 = TEXT;
        final String textSECUHexaLevel2 = TEXT;
        final String textSECUHexaLevel3 = TEXT;
        final String textSECUHexaLevel4 =
                "\\u0041\\u0042\\u0043\\u0044\\u0045\\u0046\\u0047\\u0048\\u0049\\u004A\\u004B\\u004C" +
                "\\u004D\\u004E\\u004F\\u0050\\u0051\\u0052\\u0053\\u0054\\u0055\\u0056\\u0057\\u0058" +
                "\\u0059\\u005A\\u0061\\u0062\\u0063\\u0064\\u0065\\u0066\\u0067\\u0068\\u0069\\u006A" +
                "\\u006B\\u006C\\u006D\\u006E\\u006F\\u0070\\u0071\\u0072\\u0073\\u0074\\u0075\\u0076" +
                "\\u0077\\u0078\\u0079\\u007A\\u0030\\u0031\\u0032\\u0033\\u0034\\u0035\\u0036\\u0037" +
                "\\u0038\\u0039";

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

        final String textXHexaUHexaLevel1 = TEXT;
        final String textXHexaUHexaLevel2 = TEXT;
        final String textXHexaUHexaLevel3 = TEXT;
        final String textXHexaUHexaLevel4 =
                "\\x41\\x42\\x43\\x44\\x45\\x46\\x47\\x48\\x49\\x4A\\x4B\\x4C\\x4D\\x4E\\x4F\\x50\\x51\\x52" +
                "\\x53\\x54\\x55\\x56\\x57\\x58\\x59\\x5A\\x61\\x62\\x63\\x64\\x65\\x66\\x67\\x68\\x69\\x6A" +
                "\\x6B\\x6C\\x6D\\x6E\\x6F\\x70\\x71\\x72\\x73\\x74\\x75\\x76\\x77\\x78\\x79\\x7A\\x30\\x31" +
                "\\x32\\x33\\x34\\x35\\x36\\x37\\x38\\x39";

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

        final String textUHexaLevel1 = TEXT;
        final String textUHexaLevel2 = TEXT;
        final String textUHexaLevel3 = TEXT;
        final String textUHexaLevel4 =
                "\\u0041\\u0042\\u0043\\u0044\\u0045\\u0046\\u0047\\u0048\\u0049\\u004A\\u004B\\u004C" +
                "\\u004D\\u004E\\u004F\\u0050\\u0051\\u0052\\u0053\\u0054\\u0055\\u0056\\u0057\\u0058" +
                "\\u0059\\u005A\\u0061\\u0062\\u0063\\u0064\\u0065\\u0066\\u0067\\u0068\\u0069\\u006A" +
                "\\u006B\\u006C\\u006D\\u006E\\u006F\\u0070\\u0071\\u0072\\u0073\\u0074\\u0075\\u0076" +
                "\\u0077\\u0078\\u0079\\u007A\\u0030\\u0031\\u0032\\u0033\\u0034\\u0035\\u0036\\u0037" +
                "\\u0038\\u0039";

        testEscapeUHexa1(TEXT, textUHexaLevel1);
        testEscapeUHexa2(TEXT, textUHexaLevel2);
        testEscapeUHexa3(TEXT, textUHexaLevel3);
        testEscapeUHexa4(TEXT, textUHexaLevel4);

        testUnescape(textUHexaLevel1, TEXT);
        testUnescape(textUHexaLevel2, TEXT);
        testUnescape(textUHexaLevel3, TEXT);
        testUnescape(textUHexaLevel4, TEXT);

    }








    public JavaScriptEscape01Test() {
        super();
    }


}

