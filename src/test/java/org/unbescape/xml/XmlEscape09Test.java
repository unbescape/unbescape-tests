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
package org.unbescape.xml;

import org.junit.Test;

import static org.unbescape.xml.XmlEscapeTestUtil.testEscapeXml10Hexa1;
import static org.unbescape.xml.XmlEscapeTestUtil.testEscapeXml11Hexa1;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.0
 *
 */
public class XmlEscape09Test {


    private static final String TEXT_UNESC =
            "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\u0008\u0009\n\u000B\u000C\r\u000E\u000F" +
            "\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001A\u001B\u001C\u001D\u001E\u001F\u0020";
    private static final String TEXT_ESC_10 =
            "\u0009\n\r\u0020";
    private static final String TEXT_ESC_11 =
            "&#x1;&#x2;&#x3;&#x4;&#x5;&#x6;&#x7;&#x8;\u0009\n&#xb;&#xc;\r&#xe;&#xf;" +
            "&#x10;&#x11;&#x12;&#x13;&#x14;&#x15;&#x16;&#x17;&#x18;&#x19;&#x1a;&#x1b;&#x1c;&#x1d;&#x1e;&#x1f;\u0020";




    @Test
    public void testUnescape01() throws Exception {

        testEscapeXml10Hexa1(TEXT_UNESC, TEXT_ESC_10);
        testEscapeXml11Hexa1(TEXT_UNESC, TEXT_ESC_11);

    }




    public XmlEscape09Test() {
        super();
    }


}

