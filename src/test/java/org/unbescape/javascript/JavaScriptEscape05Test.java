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
public class JavaScriptEscape05Test {


    private static final String TEXT =
            "<>&'\"ABCDEFGHIJKLMNOPQRSTUVWXYZ <>&'\" \u0163\uD840\uDC00\ud835\udccd-\u0163-\uD840\uDC00-\ud835\udccd\u00E0\u00E1\u00E2\u00E3\u00E4\u00E5\u00E6abcdefghijklmnopqrstuvwxyz <&'\"> 0123456789&<'\">";




    @Test
    public void testSECXHexaUHexa() throws Exception {

        final String textSECXHexaUHexaLevel1 =
                "<>&\\'\\\"ABCDEFGHIJKLMNOPQRSTUVWXYZ <>&\\'\\\" \u0163\uD840\uDC00\ud835\udccd-\u0163-\uD840\uDC00-\ud835\udccd\u00E0\u00E1\u00E2\u00E3\u00E4\u00E5\u00E6abcdefghijklmnopqrstuvwxyz <&\\'\\\"> 0123456789&<\\'\\\">";
        final String textSECXHexaUHexaLevel2 =
                "<>&\\'\\\"ABCDEFGHIJKLMNOPQRSTUVWXYZ <>&\\'\\\" \\u0163\\uD840\\uDC00\\uD835\\uDCCD-\\u0163-\\uD840\\uDC00-\\uD835\\uDCCD\\xE0\\xE1\\xE2\\xE3\\xE4\\xE5\\xE6abcdefghijklmnopqrstuvwxyz <&\\'\\\"> 0123456789&<\\'\\\">";
        final String textSECXHexaUHexaLevel3 =
                "\\x3C\\x3E\\x26\\'\\\"ABCDEFGHIJKLMNOPQRSTUVWXYZ\\x20\\x3C\\x3E\\x26\\'\\\"\\x20\\u0163\\uD840\\uDC00\\uD835\\uDCCD\\x2D\\u0163\\x2D\\uD840\\uDC00\\x2D\\uD835\\uDCCD\\xE0\\xE1\\xE2\\xE3\\xE4\\xE5\\xE6abcdefghijklmnopqrstuvwxyz\\x20\\x3C\\x26\\'\\\"\\x3E\\x200123456789\\x26\\x3C\\'\\\"\\x3E";
        final String textSECXHexaUHexaLevel4 =
                "\\x3C\\x3E\\x26\\'\\\"\\x41\\x42\\x43\\x44\\x45\\x46\\x47\\x48\\x49\\x4A\\x4B\\x4C\\x4D\\x4E" +
                "\\x4F\\x50\\x51\\x52\\x53\\x54\\x55\\x56\\x57\\x58\\x59\\x5A\\x20\\x3C\\x3E\\x26\\'\\\"\\x20" +
                "\\u0163\\uD840\\uDC00\\uD835\\uDCCD\\x2D\\u0163\\x2D\\uD840\\uDC00\\x2D\\uD835\\uDCCD\\xE0" +
                "\\xE1\\xE2\\xE3\\xE4\\xE5\\xE6\\x61\\x62\\x63\\x64\\x65\\x66\\x67\\x68\\x69\\x6A\\x6B\\x6C" +
                "\\x6D\\x6E\\x6F\\x70\\x71\\x72\\x73\\x74\\x75\\x76\\x77\\x78\\x79\\x7A\\x20\\x3C\\x26\\'\\\"" +
                "\\x3E\\x20\\x30\\x31\\x32\\x33\\x34\\x35\\x36\\x37\\x38\\x39\\x26\\x3C\\'\\\"\\x3E";

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
                "<>&\\'\\\"ABCDEFGHIJKLMNOPQRSTUVWXYZ <>&\\'\\\" \u0163\uD840\uDC00\ud835\udccd-\u0163-\uD840\uDC00-\ud835\udccd\u00E0\u00E1\u00E2\u00E3\u00E4\u00E5\u00E6abcdefghijklmnopqrstuvwxyz <&\\'\\\"> 0123456789&<\\'\\\">";
        final String textSECUHexaLevel2 =
                "<>&\\'\\\"ABCDEFGHIJKLMNOPQRSTUVWXYZ <>&\\'\\\" \\u0163\\uD840\\uDC00\\uD835\\uDCCD-\\u0163-\\uD840\\uDC00-\\uD835\\uDCCD\\u00E0\\u00E1\\u00E2\\u00E3\\u00E4\\u00E5\\u00E6abcdefghijklmnopqrstuvwxyz <&\\'\\\"> 0123456789&<\\'\\\">";
        final String textSECUHexaLevel3 =
                "\\u003C\\u003E\\u0026\\'\\\"ABCDEFGHIJKLMNOPQRSTUVWXYZ\\u0020\\u003C\\u003E\\u0026\\'\\\"\\u0020\\u0163\\uD840\\uDC00\\uD835\\uDCCD\\u002D\\u0163\\u002D\\uD840\\uDC00\\u002D\\uD835\\uDCCD\\u00E0\\u00E1\\u00E2\\u00E3\\u00E4\\u00E5\\u00E6abcdefghijklmnopqrstuvwxyz\\u0020\\u003C\\u0026\\'\\\"\\u003E\\u00200123456789\\u0026\\u003C\\'\\\"\\u003E";
        final String textSECUHexaLevel4 =
                "\\u003C\\u003E\\u0026\\'\\\"\\u0041\\u0042\\u0043\\u0044\\u0045\\u0046\\u0047\\u0048" +
                "\\u0049\\u004A\\u004B\\u004C\\u004D\\u004E\\u004F\\u0050\\u0051\\u0052\\u0053\\u0054" +
                "\\u0055\\u0056\\u0057\\u0058\\u0059\\u005A\\u0020\\u003C\\u003E\\u0026\\'\\\"\\u0020" +
                "\\u0163\\uD840\\uDC00\\uD835\\uDCCD\\u002D\\u0163\\u002D\\uD840\\uDC00\\u002D\\uD835" +
                "\\uDCCD\\u00E0\\u00E1\\u00E2\\u00E3\\u00E4\\u00E5\\u00E6\\u0061\\u0062\\u0063\\u0064" +
                "\\u0065\\u0066\\u0067\\u0068\\u0069\\u006A\\u006B\\u006C\\u006D\\u006E\\u006F\\u0070" +
                "\\u0071\\u0072\\u0073\\u0074\\u0075\\u0076\\u0077\\u0078\\u0079\\u007A\\u0020\\u003C" +
                "\\u0026\\'\\\"\\u003E\\u0020\\u0030\\u0031\\u0032\\u0033\\u0034\\u0035\\u0036\\u0037" +
                "\\u0038\\u0039\\u0026\\u003C\\'\\\"\\u003E";

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
                "<>&\\x27\\x22ABCDEFGHIJKLMNOPQRSTUVWXYZ <>&\\x27\\x22 \u0163\uD840\uDC00\ud835\udccd-\u0163-\uD840\uDC00-\ud835\udccd\u00E0\u00E1\u00E2\u00E3\u00E4\u00E5\u00E6abcdefghijklmnopqrstuvwxyz <&\\x27\\x22> 0123456789&<\\x27\\x22>";
        final String textXHexaUHexaLevel2 =
                "<>&\\x27\\x22ABCDEFGHIJKLMNOPQRSTUVWXYZ <>&\\x27\\x22 \\u0163\\uD840\\uDC00\\uD835\\uDCCD-\\u0163-\\uD840\\uDC00-\\uD835\\uDCCD\\xE0\\xE1\\xE2\\xE3\\xE4\\xE5\\xE6abcdefghijklmnopqrstuvwxyz <&\\x27\\x22> 0123456789&<\\x27\\x22>";
        final String textXHexaUHexaLevel3 =
                "\\x3C\\x3E\\x26\\x27\\x22ABCDEFGHIJKLMNOPQRSTUVWXYZ\\x20\\x3C\\x3E\\x26\\x27\\x22\\x20\\u0163\\uD840\\uDC00\\uD835\\uDCCD\\x2D\\u0163\\x2D\\uD840\\uDC00\\x2D\\uD835\\uDCCD\\xE0\\xE1\\xE2\\xE3\\xE4\\xE5\\xE6abcdefghijklmnopqrstuvwxyz\\x20\\x3C\\x26\\x27\\x22\\x3E\\x200123456789\\x26\\x3C\\x27\\x22\\x3E";
        final String textXHexaUHexaLevel4 =
                "\\x3C\\x3E\\x26\\x27\\x22\\x41\\x42\\x43\\x44\\x45\\x46\\x47\\x48\\x49\\x4A\\x4B\\x4C\\x4D" +
                "\\x4E\\x4F\\x50\\x51\\x52\\x53\\x54\\x55\\x56\\x57\\x58\\x59\\x5A\\x20\\x3C\\x3E\\x26\\x27" +
                "\\x22\\x20\\u0163\\uD840\\uDC00\\uD835\\uDCCD\\x2D\\u0163\\x2D\\uD840\\uDC00\\x2D\\uD835" +
                "\\uDCCD\\xE0\\xE1\\xE2\\xE3\\xE4\\xE5\\xE6\\x61\\x62\\x63\\x64\\x65\\x66\\x67\\x68\\x69" +
                "\\x6A\\x6B\\x6C\\x6D\\x6E\\x6F\\x70\\x71\\x72\\x73\\x74\\x75\\x76\\x77\\x78\\x79\\x7A\\x20" +
                "\\x3C\\x26\\x27\\x22\\x3E\\x20\\x30\\x31\\x32\\x33\\x34\\x35\\x36\\x37\\x38\\x39\\x26\\x3C" +
                "\\x27\\x22\\x3E";

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
                "<>&\\u0027\\u0022ABCDEFGHIJKLMNOPQRSTUVWXYZ <>&\\u0027\\u0022 \u0163\uD840\uDC00\ud835\udccd-\u0163-\uD840\uDC00-\ud835\udccd\u00E0\u00E1\u00E2\u00E3\u00E4\u00E5\u00E6abcdefghijklmnopqrstuvwxyz <&\\u0027\\u0022> 0123456789&<\\u0027\\u0022>";
        final String textUHexaLevel2 =
                "<>&\\u0027\\u0022ABCDEFGHIJKLMNOPQRSTUVWXYZ <>&\\u0027\\u0022 \\u0163\\uD840\\uDC00\\uD835\\uDCCD-\\u0163-\\uD840\\uDC00-\\uD835\\uDCCD\\u00E0\\u00E1\\u00E2\\u00E3\\u00E4\\u00E5\\u00E6abcdefghijklmnopqrstuvwxyz <&\\u0027\\u0022> 0123456789&<\\u0027\\u0022>";
        final String textUHexaLevel3 =
                "\\u003C\\u003E\\u0026\\u0027\\u0022ABCDEFGHIJKLMNOPQRSTUVWXYZ\\u0020\\u003C\\u003E\\u0026\\u0027\\u0022\\u0020\\u0163\\uD840\\uDC00\\uD835\\uDCCD\\u002D\\u0163\\u002D\\uD840\\uDC00\\u002D\\uD835\\uDCCD\\u00E0\\u00E1\\u00E2\\u00E3\\u00E4\\u00E5\\u00E6abcdefghijklmnopqrstuvwxyz\\u0020\\u003C\\u0026\\u0027\\u0022\\u003E\\u00200123456789\\u0026\\u003C\\u0027\\u0022\\u003E";
        final String textUHexaLevel4 =
                "\\u003C\\u003E\\u0026\\u0027\\u0022\\u0041\\u0042\\u0043\\u0044\\u0045\\u0046\\u0047\\u0048" +
                "\\u0049\\u004A\\u004B\\u004C\\u004D\\u004E\\u004F\\u0050\\u0051\\u0052\\u0053\\u0054\\u0055" +
                "\\u0056\\u0057\\u0058\\u0059\\u005A\\u0020\\u003C\\u003E\\u0026\\u0027\\u0022\\u0020\\u0163" +
                "\\uD840\\uDC00\\uD835\\uDCCD\\u002D\\u0163\\u002D\\uD840\\uDC00\\u002D\\uD835\\uDCCD\\u00E0" +
                "\\u00E1\\u00E2\\u00E3\\u00E4\\u00E5\\u00E6\\u0061\\u0062\\u0063\\u0064\\u0065\\u0066\\u0067" +
                "\\u0068\\u0069\\u006A\\u006B\\u006C\\u006D\\u006E\\u006F\\u0070\\u0071\\u0072\\u0073\\u0074" +
                "\\u0075\\u0076\\u0077\\u0078\\u0079\\u007A\\u0020\\u003C\\u0026\\u0027\\u0022\\u003E\\u0020" +
                "\\u0030\\u0031\\u0032\\u0033\\u0034\\u0035\\u0036\\u0037\\u0038\\u0039\\u0026\\u003C\\u0027" +
                "\\u0022\\u003E";

        testEscapeUHexa1(TEXT, textUHexaLevel1);
        testEscapeUHexa2(TEXT, textUHexaLevel2);
        testEscapeUHexa3(TEXT, textUHexaLevel3);
        testEscapeUHexa4(TEXT, textUHexaLevel4);

        testUnescape(textUHexaLevel1, TEXT);
        testUnescape(textUHexaLevel2, TEXT);
        testUnescape(textUHexaLevel3, TEXT);
        testUnescape(textUHexaLevel4, TEXT);

    }








    public JavaScriptEscape05Test() {
        super();
    }


}

