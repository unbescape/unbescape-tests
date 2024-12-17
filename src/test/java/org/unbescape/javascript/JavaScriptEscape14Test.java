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
public class JavaScriptEscape14Test {


    // The solidus character should be escaped, but only when it appears right after '<' (in order to avoid
    // closing a <script> tag in an HTML file.
    private static final String TEXT = "/something</script></anything> but http://example.com";




    @Test
    public void testSECXHexaUHexa() throws Exception {

        final String textSECXHexaUHexaLevel1 = "/something<\\/script><\\/anything> but http://example.com";
        final String textSECXHexaUHexaLevel2 = "/something<\\/script><\\/anything> but http://example.com";
        final String textSECXHexaUHexaLevel3 = "\\/something\\x3C\\/script\\x3E\\x3C\\/anything\\x3E\\x20but\\x20http\\x3A\\/\\/example\\x2Ecom";
        final String textSECXHexaUHexaLevel4 = "\\/\\x73\\x6F\\x6D\\x65\\x74\\x68\\x69\\x6E\\x67\\x3C\\/\\x73\\x63\\x72\\x69\\x70\\x74\\x3E\\x3C\\/\\x61\\x6E\\x79\\x74\\x68\\x69\\x6E\\x67\\x3E\\x20\\x62\\x75\\x74\\x20\\x68\\x74\\x74\\x70\\x3A\\/\\/\\x65\\x78\\x61\\x6D\\x70\\x6C\\x65\\x2E\\x63\\x6F\\x6D";

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

        final String textSECUHexaLevel1 = "/something<\\/script><\\/anything> but http://example.com";
        final String textSECUHexaLevel2 = "/something<\\/script><\\/anything> but http://example.com";
        final String textSECUHexaLevel3 = "\\/something\\u003C\\/script\\u003E\\u003C\\/anything\\u003E\\u0020but\\u0020http\\u003A\\/\\/example\\u002Ecom";
        final String textSECUHexaLevel4 = "\\/\\u0073\\u006F\\u006D\\u0065\\u0074\\u0068\\u0069\\u006E\\u0067\\u003C\\/\\u0073\\u0063\\u0072\\u0069\\u0070\\u0074\\u003E\\u003C\\/\\u0061\\u006E\\u0079\\u0074\\u0068\\u0069\\u006E\\u0067\\u003E\\u0020\\u0062\\u0075\\u0074\\u0020\\u0068\\u0074\\u0074\\u0070\\u003A\\/\\/\\u0065\\u0078\\u0061\\u006D\\u0070\\u006C\\u0065\\u002E\\u0063\\u006F\\u006D";

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

        final String textXHexaUHexaLevel1 = "/something<\\x2Fscript><\\x2Fanything> but http://example.com";
        final String textXHexaUHexaLevel2 = "/something<\\x2Fscript><\\x2Fanything> but http://example.com";
        final String textXHexaUHexaLevel3 = "\\x2Fsomething\\x3C\\x2Fscript\\x3E\\x3C\\x2Fanything\\x3E\\x20but\\x20http\\x3A\\x2F\\x2Fexample\\x2Ecom";
        final String textXHexaUHexaLevel4 = "\\x2F\\x73\\x6F\\x6D\\x65\\x74\\x68\\x69\\x6E\\x67\\x3C\\x2F\\x73\\x63\\x72\\x69\\x70\\x74\\x3E\\x3C\\x2F\\x61\\x6E\\x79\\x74\\x68\\x69\\x6E\\x67\\x3E\\x20\\x62\\x75\\x74\\x20\\x68\\x74\\x74\\x70\\x3A\\x2F\\x2F\\x65\\x78\\x61\\x6D\\x70\\x6C\\x65\\x2E\\x63\\x6F\\x6D";

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

        final String textUHexaLevel1 = "/something<\\u002Fscript><\\u002Fanything> but http://example.com";
        final String textUHexaLevel2 = "/something<\\u002Fscript><\\u002Fanything> but http://example.com";
        final String textUHexaLevel3 = "\\u002Fsomething\\u003C\\u002Fscript\\u003E\\u003C\\u002Fanything\\u003E\\u0020but\\u0020http\\u003A\\u002F\\u002Fexample\\u002Ecom";
        final String textUHexaLevel4 = "\\u002F\\u0073\\u006F\\u006D\\u0065\\u0074\\u0068\\u0069\\u006E\\u0067\\u003C\\u002F\\u0073\\u0063\\u0072\\u0069\\u0070\\u0074\\u003E\\u003C\\u002F\\u0061\\u006E\\u0079\\u0074\\u0068\\u0069\\u006E\\u0067\\u003E\\u0020\\u0062\\u0075\\u0074\\u0020\\u0068\\u0074\\u0074\\u0070\\u003A\\u002F\\u002F\\u0065\\u0078\\u0061\\u006D\\u0070\\u006C\\u0065\\u002E\\u0063\\u006F\\u006D";

        testEscapeUHexa1(TEXT, textUHexaLevel1);
        testEscapeUHexa2(TEXT, textUHexaLevel2);
        testEscapeUHexa3(TEXT, textUHexaLevel3);
        testEscapeUHexa4(TEXT, textUHexaLevel4);

        testUnescape(textUHexaLevel1, TEXT);
        testUnescape(textUHexaLevel2, TEXT);
        testUnescape(textUHexaLevel3, TEXT);
        testUnescape(textUHexaLevel4, TEXT);

    }








    public JavaScriptEscape14Test() {
        super();
    }


}

