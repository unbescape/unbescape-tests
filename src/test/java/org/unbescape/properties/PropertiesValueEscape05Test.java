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
package org.unbescape.properties;

import org.junit.jupiter.api.Test;

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
public class PropertiesValueEscape05Test {


    private static final String TEXT =
            "<>&'\"ABCDEFGHIJKLMNOPQRSTUVWXYZ <>&'\" \u0163\uD840\uDC00\ud835\udccd-\u0163-\uD840\uDC00-\ud835\udccd\u00E0\u00E1\u00E2\u00E3\u00E4\u00E5\u00E6abcdefghijklmnopqrstuvwxyz <&'\"> 0123456789&<'\">";




    @Test
    public void test() throws Exception {

        final String textLevel1 =
                "<>&'\"ABCDEFGHIJKLMNOPQRSTUVWXYZ <>&'\" \u0163\uD840\uDC00\ud835\udccd-\u0163-\uD840\uDC00-\ud835\udccd\u00E0\u00E1\u00E2\u00E3\u00E4\u00E5\u00E6abcdefghijklmnopqrstuvwxyz <&'\"> 0123456789&<'\">";
        final String textLevel2 =
                "<>&'\"ABCDEFGHIJKLMNOPQRSTUVWXYZ <>&'\" \\u0163\\uD840\\uDC00\\uD835\\uDCCD-\\u0163-\\uD840\\uDC00-\\uD835\\uDCCD\\u00E0\\u00E1\\u00E2\\u00E3\\u00E4\\u00E5\\u00E6abcdefghijklmnopqrstuvwxyz <&'\"> 0123456789&<'\">";
        final String textLevel3 =
                "\\u003C\\u003E\\u0026\\u0027\\u0022ABCDEFGHIJKLMNOPQRSTUVWXYZ\\u0020\\u003C\\u003E\\u0026\\u0027\\u0022\\u0020\\u0163\\uD840\\uDC00\\uD835\\uDCCD\\u002D\\u0163\\u002D\\uD840\\uDC00\\u002D\\uD835\\uDCCD\\u00E0\\u00E1\\u00E2\\u00E3\\u00E4\\u00E5\\u00E6abcdefghijklmnopqrstuvwxyz\\u0020\\u003C\\u0026\\u0027\\u0022\\u003E\\u00200123456789\\u0026\\u003C\\u0027\\u0022\\u003E";
        final String textLevel4 =
                "\\u003C\\u003E\\u0026\\u0027\\u0022\\u0041\\u0042\\u0043\\u0044\\u0045\\u0046\\u0047\\u0048\\u0049\\u004A\\u004B\\u004C\\u004D\\u004E\\u004F\\u0050\\u0051\\u0052\\u0053\\u0054\\u0055\\u0056\\u0057\\u0058\\u0059\\u005A\\u0020\\u003C\\u003E\\u0026\\u0027\\u0022\\u0020\\u0163\\uD840\\uDC00\\uD835\\uDCCD\\u002D\\u0163\\u002D\\uD840\\uDC00\\u002D\\uD835\\uDCCD\\u00E0\\u00E1\\u00E2\\u00E3\\u00E4\\u00E5\\u00E6\\u0061\\u0062\\u0063\\u0064\\u0065\\u0066\\u0067\\u0068\\u0069\\u006A\\u006B\\u006C\\u006D\\u006E\\u006F\\u0070\\u0071\\u0072\\u0073\\u0074\\u0075\\u0076\\u0077\\u0078\\u0079\\u007A\\u0020\\u003C\\u0026\\u0027\\u0022\\u003E\\u0020\\u0030\\u0031\\u0032\\u0033\\u0034\\u0035\\u0036\\u0037\\u0038\\u0039\\u0026\\u003C\\u0027\\u0022\\u003E";

        testEscape1(TEXT, textLevel1);
        testEscape2(TEXT, textLevel2);
        testEscape3(TEXT, textLevel3);
        testEscape4(TEXT, textLevel4);

        testUnescape(textLevel1, TEXT);
        testUnescape(textLevel2, TEXT);
        testUnescape(textLevel3, TEXT);
        testUnescape(textLevel4, TEXT);

    }






    public PropertiesValueEscape05Test() {
        super();
    }


}

