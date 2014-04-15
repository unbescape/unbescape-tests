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
public class XmlI18nEscapeTest {



    private static final String TEXT =
            "Jako efektivn\u0115j\u0161\u00ED se n\u00E1m jev\u00ED po\u0159\u00E1d\u00E1n\u00ED tzv.\n" +
            "Gira prost\u0159ednictv\u00EDm na\u0161ich autorizovan\u00FDch dealer\u016F v " +
            "\u010Cech\u00E1ch a na Morav\u011B, kter\u00E9 prob\u011Bhnou v pr\u016Fb\u011Bhu " +
            "z\u00E1\u0159\u00ED a \u0159\u00EDjna.";




    @Test
    public void testXml11() throws Exception {


        final String textXml11DecLevel1 = TEXT;
        final String textXml11DecLevel2 =
                "Jako efektivn&#277;j&#353;&#237; se n&#225;m jev&#237; po&#345;&#225;d&#225;n&#237; tzv.\n" +
                "Gira prost&#345;ednictv&#237;m na&#353;ich autorizovan&#253;ch dealer&#367; v " +
                "&#268;ech&#225;ch a na Morav&#283;, kter&#233; prob&#283;hnou v pr&#367;b&#283;hu " +
                "z&#225;&#345;&#237; a &#345;&#237;jna.";
        final String textXml11DecLevel3 =
                "Jako&#32;efektivn&#277;j&#353;&#237;&#32;se&#32;n&#225;m&#32;jev&#237;&#32;po&#345;&#225;d&#225;n&#237;&#32;tzv&#46;&#10;" +
                "Gira&#32;prost&#345;ednictv&#237;m&#32;na&#353;ich&#32;autorizovan&#253;ch&#32;dealer&#367;&#32;v&#32;" +
                "&#268;ech&#225;ch&#32;a&#32;na&#32;Morav&#283;&#44;&#32;kter&#233;&#32;prob&#283;hnou&#32;v&#32;pr&#367;b&#283;hu&#32;" +
                "z&#225;&#345;&#237;&#32;a&#32;&#345;&#237;jna&#46;";
        final String textXml11DecLevel4 =
                "&#74;&#97;&#107;&#111;&#32;&#101;&#102;&#101;&#107;&#116;&#105;&#118;&#110;&#277;&#106;&#353;&#237;&#32;" +
                "&#115;&#101;&#32;&#110;&#225;&#109;&#32;&#106;&#101;&#118;&#237;&#32;&#112;&#111;&#345;&#225;&#100;&#225;&#110;&#237;&#32;" +
                "&#116;&#122;&#118;&#46;&#10;&#71;&#105;&#114;&#97;&#32;&#112;&#114;&#111;&#115;&#116;&#345;&#101;&#100;&#110;&#105;&#99;&#116;&#118;&#237;&#109;&#32;" +
                "&#110;&#97;&#353;&#105;&#99;&#104;&#32;&#97;&#117;&#116;&#111;&#114;&#105;&#122;&#111;&#118;&#97;&#110;&#253;&#99;&#104;&#32;" +
                "&#100;&#101;&#97;&#108;&#101;&#114;&#367;&#32;&#118;&#32;&#268;&#101;&#99;&#104;&#225;&#99;&#104;&#32;&#97;&#32;&#110;&#97;&#32;" +
                "&#77;&#111;&#114;&#97;&#118;&#283;&#44;&#32;&#107;&#116;&#101;&#114;&#233;&#32;&#112;&#114;&#111;&#98;&#283;&#104;&#110;&#111;&#117;&#32;" +
                "&#118;&#32;&#112;&#114;&#367;&#98;&#283;&#104;&#117;&#32;&#122;&#225;&#345;&#237;&#32;&#97;&#32;&#345;&#237;&#106;&#110;&#97;&#46;";

        testEscapeXml11Decimal1(TEXT, textXml11DecLevel1);
        testEscapeXml11Decimal2(TEXT, textXml11DecLevel2);
        testEscapeXml11Decimal3(TEXT, textXml11DecLevel3);
        testEscapeXml11Decimal4(TEXT, textXml11DecLevel4);

        testUnescape(textXml11DecLevel1, TEXT);
        testUnescape(textXml11DecLevel2, TEXT);
        testUnescape(textXml11DecLevel3, TEXT);
        testUnescape(textXml11DecLevel4, TEXT);


        final String textXml11HexaLevel1 = TEXT;
        final String textXml11HexaLevel2 =
                "Jako efektivn&#x115;j&#x161;&#xed; se n&#xe1;m jev&#xed; po&#x159;&#xe1;d&#xe1;n&#xed; tzv.\n" +
                "Gira prost&#x159;ednictv&#xed;m na&#x161;ich autorizovan&#xfd;ch dealer&#x16f; v " +
                "&#x10c;ech&#xe1;ch a na Morav&#x11b;, kter&#xe9; prob&#x11b;hnou v pr&#x16f;b&#x11b;hu " +
                "z&#xe1;&#x159;&#xed; a &#x159;&#xed;jna.";
        final String textXml11HexaLevel3 =
                "Jako&#x20;efektivn&#x115;j&#x161;&#xed;&#x20;se&#x20;n&#xe1;m&#x20;jev&#xed;&#x20;po&#x159;&#xe1;d&#xe1;n&#xed;&#x20;tzv&#x2e;&#xa;" +
                "Gira&#x20;prost&#x159;ednictv&#xed;m&#x20;na&#x161;ich&#x20;autorizovan&#xfd;ch&#x20;dealer&#x16f;&#x20;v&#x20;" +
                "&#x10c;ech&#xe1;ch&#x20;a&#x20;na&#x20;Morav&#x11b;&#x2c;&#x20;kter&#xe9;&#x20;prob&#x11b;hnou&#x20;v&#x20;pr&#x16f;b&#x11b;hu&#x20;" +
                "z&#xe1;&#x159;&#xed;&#x20;a&#x20;&#x159;&#xed;jna&#x2e;";
        final String textXml11HexaLevel4 =
                "&#x4a;&#x61;&#x6b;&#x6f;&#x20;&#x65;&#x66;&#x65;&#x6b;&#x74;&#x69;&#x76;&#x6e;&#x115;&#x6a;&#x161;&#xed;&#x20;" +
                "&#x73;&#x65;&#x20;&#x6e;&#xe1;&#x6d;&#x20;&#x6a;&#x65;&#x76;&#xed;&#x20;&#x70;&#x6f;&#x159;&#xe1;" +
                "&#x64;&#xe1;&#x6e;&#xed;&#x20;&#x74;&#x7a;&#x76;&#x2e;&#xa;&#x47;&#x69;&#x72;&#x61;&#x20;&#x70;&#x72;" +
                "&#x6f;&#x73;&#x74;&#x159;&#x65;&#x64;&#x6e;&#x69;&#x63;&#x74;&#x76;&#xed;&#x6d;&#x20;&#x6e;&#x61;" +
                "&#x161;&#x69;&#x63;&#x68;&#x20;&#x61;&#x75;&#x74;&#x6f;&#x72;&#x69;&#x7a;&#x6f;&#x76;&#x61;&#x6e;" +
                "&#xfd;&#x63;&#x68;&#x20;&#x64;&#x65;&#x61;&#x6c;&#x65;&#x72;&#x16f;&#x20;&#x76;&#x20;&#x10c;&#x65;" +
                "&#x63;&#x68;&#xe1;&#x63;&#x68;&#x20;&#x61;&#x20;&#x6e;&#x61;&#x20;&#x4d;&#x6f;&#x72;&#x61;&#x76;" +
                "&#x11b;&#x2c;&#x20;&#x6b;&#x74;&#x65;&#x72;&#xe9;&#x20;&#x70;&#x72;&#x6f;&#x62;&#x11b;&#x68;&#x6e;" +
                "&#x6f;&#x75;&#x20;&#x76;&#x20;&#x70;&#x72;&#x16f;&#x62;&#x11b;&#x68;&#x75;&#x20;&#x7a;&#xe1;&#x159;" +
                "&#xed;&#x20;&#x61;&#x20;&#x159;&#xed;&#x6a;&#x6e;&#x61;&#x2e;";

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
        final String textXml10DecLevel2 =
                "Jako efektivn&#277;j&#353;&#237; se n&#225;m jev&#237; po&#345;&#225;d&#225;n&#237; tzv.\n" +
                "Gira prost&#345;ednictv&#237;m na&#353;ich autorizovan&#253;ch dealer&#367; v " +
                "&#268;ech&#225;ch a na Morav&#283;, kter&#233; prob&#283;hnou v pr&#367;b&#283;hu " +
                "z&#225;&#345;&#237; a &#345;&#237;jna.";
        final String textXml10DecLevel3 =
                "Jako&#32;efektivn&#277;j&#353;&#237;&#32;se&#32;n&#225;m&#32;jev&#237;&#32;po&#345;&#225;d&#225;n&#237;&#32;tzv&#46;&#10;" +
                "Gira&#32;prost&#345;ednictv&#237;m&#32;na&#353;ich&#32;autorizovan&#253;ch&#32;dealer&#367;&#32;v&#32;" +
                "&#268;ech&#225;ch&#32;a&#32;na&#32;Morav&#283;&#44;&#32;kter&#233;&#32;prob&#283;hnou&#32;v&#32;pr&#367;b&#283;hu&#32;" +
                "z&#225;&#345;&#237;&#32;a&#32;&#345;&#237;jna&#46;";
        final String textXml10DecLevel4 =
                "&#74;&#97;&#107;&#111;&#32;&#101;&#102;&#101;&#107;&#116;&#105;&#118;&#110;&#277;&#106;&#353;&#237;&#32;" +
                "&#115;&#101;&#32;&#110;&#225;&#109;&#32;&#106;&#101;&#118;&#237;&#32;&#112;&#111;&#345;&#225;&#100;&#225;&#110;&#237;&#32;" +
                "&#116;&#122;&#118;&#46;&#10;&#71;&#105;&#114;&#97;&#32;&#112;&#114;&#111;&#115;&#116;&#345;&#101;&#100;&#110;&#105;&#99;&#116;&#118;&#237;&#109;&#32;" +
                "&#110;&#97;&#353;&#105;&#99;&#104;&#32;&#97;&#117;&#116;&#111;&#114;&#105;&#122;&#111;&#118;&#97;&#110;&#253;&#99;&#104;&#32;" +
                "&#100;&#101;&#97;&#108;&#101;&#114;&#367;&#32;&#118;&#32;&#268;&#101;&#99;&#104;&#225;&#99;&#104;&#32;&#97;&#32;&#110;&#97;&#32;" +
                "&#77;&#111;&#114;&#97;&#118;&#283;&#44;&#32;&#107;&#116;&#101;&#114;&#233;&#32;&#112;&#114;&#111;&#98;&#283;&#104;&#110;&#111;&#117;&#32;" +
                "&#118;&#32;&#112;&#114;&#367;&#98;&#283;&#104;&#117;&#32;&#122;&#225;&#345;&#237;&#32;&#97;&#32;&#345;&#237;&#106;&#110;&#97;&#46;";

        testEscapeXml10Decimal1(TEXT, textXml10DecLevel1);
        testEscapeXml10Decimal2(TEXT, textXml10DecLevel2);
        testEscapeXml10Decimal3(TEXT, textXml10DecLevel3);
        testEscapeXml10Decimal4(TEXT, textXml10DecLevel4);

        testUnescape(textXml10DecLevel1, TEXT);
        testUnescape(textXml10DecLevel2, TEXT);
        testUnescape(textXml10DecLevel3, TEXT);
        testUnescape(textXml10DecLevel4, TEXT);


        final String textXml10HexaLevel1 = TEXT;
        final String textXml10HexaLevel2 =
                "Jako efektivn&#x115;j&#x161;&#xed; se n&#xe1;m jev&#xed; po&#x159;&#xe1;d&#xe1;n&#xed; tzv.\n" +
                "Gira prost&#x159;ednictv&#xed;m na&#x161;ich autorizovan&#xfd;ch dealer&#x16f; v " +
                "&#x10c;ech&#xe1;ch a na Morav&#x11b;, kter&#xe9; prob&#x11b;hnou v pr&#x16f;b&#x11b;hu " +
                "z&#xe1;&#x159;&#xed; a &#x159;&#xed;jna.";
        final String textXml10HexaLevel3 =
                "Jako&#x20;efektivn&#x115;j&#x161;&#xed;&#x20;se&#x20;n&#xe1;m&#x20;jev&#xed;&#x20;po&#x159;&#xe1;d&#xe1;n&#xed;&#x20;tzv&#x2e;&#xa;" +
                "Gira&#x20;prost&#x159;ednictv&#xed;m&#x20;na&#x161;ich&#x20;autorizovan&#xfd;ch&#x20;dealer&#x16f;&#x20;v&#x20;" +
                "&#x10c;ech&#xe1;ch&#x20;a&#x20;na&#x20;Morav&#x11b;&#x2c;&#x20;kter&#xe9;&#x20;prob&#x11b;hnou&#x20;v&#x20;pr&#x16f;b&#x11b;hu&#x20;" +
                "z&#xe1;&#x159;&#xed;&#x20;a&#x20;&#x159;&#xed;jna&#x2e;";
        final String textXml10HexaLevel4 =
                "&#x4a;&#x61;&#x6b;&#x6f;&#x20;&#x65;&#x66;&#x65;&#x6b;&#x74;&#x69;&#x76;&#x6e;&#x115;&#x6a;&#x161;&#xed;&#x20;" +
                "&#x73;&#x65;&#x20;&#x6e;&#xe1;&#x6d;&#x20;&#x6a;&#x65;&#x76;&#xed;&#x20;&#x70;&#x6f;&#x159;&#xe1;" +
                "&#x64;&#xe1;&#x6e;&#xed;&#x20;&#x74;&#x7a;&#x76;&#x2e;&#xa;&#x47;&#x69;&#x72;&#x61;&#x20;&#x70;&#x72;" +
                "&#x6f;&#x73;&#x74;&#x159;&#x65;&#x64;&#x6e;&#x69;&#x63;&#x74;&#x76;&#xed;&#x6d;&#x20;&#x6e;&#x61;" +
                "&#x161;&#x69;&#x63;&#x68;&#x20;&#x61;&#x75;&#x74;&#x6f;&#x72;&#x69;&#x7a;&#x6f;&#x76;&#x61;&#x6e;" +
                "&#xfd;&#x63;&#x68;&#x20;&#x64;&#x65;&#x61;&#x6c;&#x65;&#x72;&#x16f;&#x20;&#x76;&#x20;&#x10c;&#x65;" +
                "&#x63;&#x68;&#xe1;&#x63;&#x68;&#x20;&#x61;&#x20;&#x6e;&#x61;&#x20;&#x4d;&#x6f;&#x72;&#x61;&#x76;" +
                "&#x11b;&#x2c;&#x20;&#x6b;&#x74;&#x65;&#x72;&#xe9;&#x20;&#x70;&#x72;&#x6f;&#x62;&#x11b;&#x68;&#x6e;" +
                "&#x6f;&#x75;&#x20;&#x76;&#x20;&#x70;&#x72;&#x16f;&#x62;&#x11b;&#x68;&#x75;&#x20;&#x7a;&#xe1;&#x159;" +
                "&#xed;&#x20;&#x61;&#x20;&#x159;&#xed;&#x6a;&#x6e;&#x61;&#x2e;";

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
        final String textDecLevel2 =
                "Jako efektivn&#277;j&#353;&#237; se n&#225;m jev&#237; po&#345;&#225;d&#225;n&#237; tzv.\n" +
                "Gira prost&#345;ednictv&#237;m na&#353;ich autorizovan&#253;ch dealer&#367; v " +
                "&#268;ech&#225;ch a na Morav&#283;, kter&#233; prob&#283;hnou v pr&#367;b&#283;hu " +
                "z&#225;&#345;&#237; a &#345;&#237;jna.";
        final String textDecLevel3 =
                "Jako&#32;efektivn&#277;j&#353;&#237;&#32;se&#32;n&#225;m&#32;jev&#237;&#32;po&#345;&#225;d&#225;n&#237;&#32;tzv&#46;&#10;" +
                "Gira&#32;prost&#345;ednictv&#237;m&#32;na&#353;ich&#32;autorizovan&#253;ch&#32;dealer&#367;&#32;v&#32;" +
                "&#268;ech&#225;ch&#32;a&#32;na&#32;Morav&#283;&#44;&#32;kter&#233;&#32;prob&#283;hnou&#32;v&#32;pr&#367;b&#283;hu&#32;" +
                "z&#225;&#345;&#237;&#32;a&#32;&#345;&#237;jna&#46;";
        final String textDecLevel4 =
                "&#74;&#97;&#107;&#111;&#32;&#101;&#102;&#101;&#107;&#116;&#105;&#118;&#110;&#277;&#106;&#353;&#237;&#32;" +
                "&#115;&#101;&#32;&#110;&#225;&#109;&#32;&#106;&#101;&#118;&#237;&#32;&#112;&#111;&#345;&#225;&#100;&#225;&#110;&#237;&#32;" +
                "&#116;&#122;&#118;&#46;&#10;&#71;&#105;&#114;&#97;&#32;&#112;&#114;&#111;&#115;&#116;&#345;&#101;&#100;&#110;&#105;&#99;&#116;&#118;&#237;&#109;&#32;" +
                "&#110;&#97;&#353;&#105;&#99;&#104;&#32;&#97;&#117;&#116;&#111;&#114;&#105;&#122;&#111;&#118;&#97;&#110;&#253;&#99;&#104;&#32;" +
                "&#100;&#101;&#97;&#108;&#101;&#114;&#367;&#32;&#118;&#32;&#268;&#101;&#99;&#104;&#225;&#99;&#104;&#32;&#97;&#32;&#110;&#97;&#32;" +
                "&#77;&#111;&#114;&#97;&#118;&#283;&#44;&#32;&#107;&#116;&#101;&#114;&#233;&#32;&#112;&#114;&#111;&#98;&#283;&#104;&#110;&#111;&#117;&#32;" +
                "&#118;&#32;&#112;&#114;&#367;&#98;&#283;&#104;&#117;&#32;&#122;&#225;&#345;&#237;&#32;&#97;&#32;&#345;&#237;&#106;&#110;&#97;&#46;";

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
        final String textHexaLevel2 =
                "Jako efektivn&#x115;j&#x161;&#xed; se n&#xe1;m jev&#xed; po&#x159;&#xe1;d&#xe1;n&#xed; tzv.\n" +
                "Gira prost&#x159;ednictv&#xed;m na&#x161;ich autorizovan&#xfd;ch dealer&#x16f; v " +
                "&#x10c;ech&#xe1;ch a na Morav&#x11b;, kter&#xe9; prob&#x11b;hnou v pr&#x16f;b&#x11b;hu " +
                "z&#xe1;&#x159;&#xed; a &#x159;&#xed;jna.";
        final String textHexaLevel3 =
                "Jako&#x20;efektivn&#x115;j&#x161;&#xed;&#x20;se&#x20;n&#xe1;m&#x20;jev&#xed;&#x20;po&#x159;&#xe1;d&#xe1;n&#xed;&#x20;tzv&#x2e;&#xa;" +
                "Gira&#x20;prost&#x159;ednictv&#xed;m&#x20;na&#x161;ich&#x20;autorizovan&#xfd;ch&#x20;dealer&#x16f;&#x20;v&#x20;" +
                "&#x10c;ech&#xe1;ch&#x20;a&#x20;na&#x20;Morav&#x11b;&#x2c;&#x20;kter&#xe9;&#x20;prob&#x11b;hnou&#x20;v&#x20;pr&#x16f;b&#x11b;hu&#x20;" +
                "z&#xe1;&#x159;&#xed;&#x20;a&#x20;&#x159;&#xed;jna&#x2e;";
        final String textHexaLevel4 =
                "&#x4a;&#x61;&#x6b;&#x6f;&#x20;&#x65;&#x66;&#x65;&#x6b;&#x74;&#x69;&#x76;&#x6e;&#x115;&#x6a;&#x161;&#xed;&#x20;" +
                "&#x73;&#x65;&#x20;&#x6e;&#xe1;&#x6d;&#x20;&#x6a;&#x65;&#x76;&#xed;&#x20;&#x70;&#x6f;&#x159;&#xe1;" +
                "&#x64;&#xe1;&#x6e;&#xed;&#x20;&#x74;&#x7a;&#x76;&#x2e;&#xa;&#x47;&#x69;&#x72;&#x61;&#x20;&#x70;&#x72;" +
                "&#x6f;&#x73;&#x74;&#x159;&#x65;&#x64;&#x6e;&#x69;&#x63;&#x74;&#x76;&#xed;&#x6d;&#x20;&#x6e;&#x61;" +
                "&#x161;&#x69;&#x63;&#x68;&#x20;&#x61;&#x75;&#x74;&#x6f;&#x72;&#x69;&#x7a;&#x6f;&#x76;&#x61;&#x6e;" +
                "&#xfd;&#x63;&#x68;&#x20;&#x64;&#x65;&#x61;&#x6c;&#x65;&#x72;&#x16f;&#x20;&#x76;&#x20;&#x10c;&#x65;" +
                "&#x63;&#x68;&#xe1;&#x63;&#x68;&#x20;&#x61;&#x20;&#x6e;&#x61;&#x20;&#x4d;&#x6f;&#x72;&#x61;&#x76;" +
                "&#x11b;&#x2c;&#x20;&#x6b;&#x74;&#x65;&#x72;&#xe9;&#x20;&#x70;&#x72;&#x6f;&#x62;&#x11b;&#x68;&#x6e;" +
                "&#x6f;&#x75;&#x20;&#x76;&#x20;&#x70;&#x72;&#x16f;&#x62;&#x11b;&#x68;&#x75;&#x20;&#x7a;&#xe1;&#x159;" +
                "&#xed;&#x20;&#x61;&#x20;&#x159;&#xed;&#x6a;&#x6e;&#x61;&#x2e;";

        testEscapeHexa1(TEXT, textHexaLevel1);
        testEscapeHexa2(TEXT, textHexaLevel2);
        testEscapeHexa3(TEXT, textHexaLevel3);
        testEscapeHexa4(TEXT, textHexaLevel4);

        testUnescape(textHexaLevel1, TEXT);
        testUnescape(textHexaLevel2, TEXT);
        testUnescape(textHexaLevel3, TEXT);
        testUnescape(textHexaLevel4, TEXT);

    }





    public XmlI18nEscapeTest() {
        super();
    }


}

