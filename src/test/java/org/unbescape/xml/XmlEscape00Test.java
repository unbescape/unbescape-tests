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
package org.unbescape.xml;

import org.junit.Test;

import static org.unbescape.xml.XmlEscapeTestUtil.testEscapeDecimal1;
import static org.unbescape.xml.XmlEscapeTestUtil.testEscapeDecimal2;
import static org.unbescape.xml.XmlEscapeTestUtil.testEscapeDecimal3;
import static org.unbescape.xml.XmlEscapeTestUtil.testEscapeDecimal4;
import static org.unbescape.xml.XmlEscapeTestUtil.testEscapeHexa1;
import static org.unbescape.xml.XmlEscapeTestUtil.testEscapeHexa2;
import static org.unbescape.xml.XmlEscapeTestUtil.testEscapeHexa3;
import static org.unbescape.xml.XmlEscapeTestUtil.testEscapeHexa4;
import static org.unbescape.xml.XmlEscapeTestUtil.testEscapeXml10Decimal1;
import static org.unbescape.xml.XmlEscapeTestUtil.testEscapeXml10Decimal2;
import static org.unbescape.xml.XmlEscapeTestUtil.testEscapeXml10Decimal3;
import static org.unbescape.xml.XmlEscapeTestUtil.testEscapeXml10Decimal4;
import static org.unbescape.xml.XmlEscapeTestUtil.testEscapeXml10Hexa1;
import static org.unbescape.xml.XmlEscapeTestUtil.testEscapeXml10Hexa2;
import static org.unbescape.xml.XmlEscapeTestUtil.testEscapeXml10Hexa3;
import static org.unbescape.xml.XmlEscapeTestUtil.testEscapeXml10Hexa4;
import static org.unbescape.xml.XmlEscapeTestUtil.testEscapeXml11Decimal1;
import static org.unbescape.xml.XmlEscapeTestUtil.testEscapeXml11Decimal2;
import static org.unbescape.xml.XmlEscapeTestUtil.testEscapeXml11Decimal3;
import static org.unbescape.xml.XmlEscapeTestUtil.testEscapeXml11Decimal4;
import static org.unbescape.xml.XmlEscapeTestUtil.testEscapeXml11Hexa1;
import static org.unbescape.xml.XmlEscapeTestUtil.testEscapeXml11Hexa2;
import static org.unbescape.xml.XmlEscapeTestUtil.testEscapeXml11Hexa3;
import static org.unbescape.xml.XmlEscapeTestUtil.testEscapeXml11Hexa4;
import static org.unbescape.xml.XmlEscapeTestUtil.testUnescape;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.0
 *
 */
public class XmlEscape00Test {


    private static final String TEXT = null;




    @Test
    public void testXml11() throws Exception {

        final String textXml11DecLevel1 = TEXT;
        final String textXml11DecLevel2 = TEXT;
        final String textXml11DecLevel3 = TEXT;
        final String textXml11DecLevel4 = TEXT;

        testEscapeXml11Decimal1(TEXT, textXml11DecLevel1);
        testEscapeXml11Decimal2(TEXT, textXml11DecLevel2);
        testEscapeXml11Decimal3(TEXT, textXml11DecLevel3);
        testEscapeXml11Decimal4(TEXT, textXml11DecLevel4);

        testUnescape(textXml11DecLevel1, TEXT);
        testUnescape(textXml11DecLevel2, TEXT);
        testUnescape(textXml11DecLevel3, TEXT);
        testUnescape(textXml11DecLevel4, TEXT);

        final String textXml11HexaLevel1 = TEXT;
        final String textXml11HexaLevel2 = TEXT;
        final String textXml11HexaLevel3 = TEXT;
        final String textXml11HexaLevel4 = TEXT;

        testEscapeXml11Hexa1(TEXT, textXml11HexaLevel1);
        testEscapeXml11Hexa2(TEXT, textXml11HexaLevel2);
        testEscapeXml11Hexa3(TEXT, textXml11HexaLevel3);
        testEscapeXml11Hexa4(TEXT, textXml11HexaLevel4);

        testUnescape(textXml11HexaLevel1, TEXT);
        testUnescape(textXml11HexaLevel2, TEXT);
        testUnescape(textXml11HexaLevel3, TEXT);
        testUnescape(textXml11HexaLevel4, TEXT);

    }




    @Test
    public void testXml10() throws Exception {

        final String textXml10DecLevel1 = TEXT;
        final String textXml10DecLevel2 = TEXT;
        final String textXml10DecLevel3 = TEXT;
        final String textXml10DecLevel4 = TEXT;

        testEscapeXml10Decimal1(TEXT, textXml10DecLevel1);
        testEscapeXml10Decimal2(TEXT, textXml10DecLevel2);
        testEscapeXml10Decimal3(TEXT, textXml10DecLevel3);
        testEscapeXml10Decimal4(TEXT, textXml10DecLevel4);

        testUnescape(textXml10DecLevel1, TEXT);
        testUnescape(textXml10DecLevel2, TEXT);
        testUnescape(textXml10DecLevel3, TEXT);
        testUnescape(textXml10DecLevel4, TEXT);

        final String textXml10HexaLevel1 = TEXT;
        final String textXml10HexaLevel2 = TEXT;
        final String textXml10HexaLevel3 = TEXT;
        final String textXml10HexaLevel4 = TEXT;

        testEscapeXml10Hexa1(TEXT, textXml10HexaLevel1);
        testEscapeXml10Hexa2(TEXT, textXml10HexaLevel2);
        testEscapeXml10Hexa3(TEXT, textXml10HexaLevel3);
        testEscapeXml10Hexa4(TEXT, textXml10HexaLevel4);

        testUnescape(textXml10HexaLevel1, TEXT);
        testUnescape(textXml10HexaLevel2, TEXT);
        testUnescape(textXml10HexaLevel3, TEXT);
        testUnescape(textXml10HexaLevel4, TEXT);

    }





    @Test
    public void testDecimal() throws Exception {

        final String textDecLevel1 = TEXT;
        final String textDecLevel2 = TEXT;
        final String textDecLevel3 = TEXT;
        final String textDecLevel4 = TEXT;

        testEscapeDecimal1(TEXT, textDecLevel1);
        testEscapeDecimal2(TEXT, textDecLevel2);
        testEscapeDecimal3(TEXT, textDecLevel3);
        testEscapeDecimal4(TEXT, textDecLevel4);

        testUnescape(textDecLevel1, TEXT);
        testUnescape(textDecLevel2, TEXT);
        testUnescape(textDecLevel3, TEXT);
        testUnescape(textDecLevel4, TEXT);

    }





    @Test
    public void testHexa() throws Exception {

        final String textHexaLevel1 = TEXT;
        final String textHexaLevel2 = TEXT;
        final String textHexaLevel3 = TEXT;
        final String textHexaLevel4 = TEXT;

        testEscapeHexa1(TEXT, textHexaLevel1);
        testEscapeHexa2(TEXT, textHexaLevel2);
        testEscapeHexa3(TEXT, textHexaLevel3);
        testEscapeHexa4(TEXT, textHexaLevel4);

        testUnescape(textHexaLevel1, TEXT);
        testUnescape(textHexaLevel2, TEXT);
        testUnescape(textHexaLevel3, TEXT);
        testUnescape(textHexaLevel4, TEXT);

    }








    public XmlEscape00Test() {
        super();
    }


}

