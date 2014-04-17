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

import static org.unbescape.json.JSONEscapeTestUtil.testEscapeSECUHexa1;
import static org.unbescape.json.JSONEscapeTestUtil.testEscapeSECUHexa2;
import static org.unbescape.json.JSONEscapeTestUtil.testEscapeSECUHexa3;
import static org.unbescape.json.JSONEscapeTestUtil.testEscapeSECUHexa4;
import static org.unbescape.json.JSONEscapeTestUtil.testUnescape;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.0
 *
 */
public class JSONEscape11Test {


    private static final String TEXT_UNESC;
    private static final String TEXT_ESC;



    static {
        final StringBuilder textUnescBuilder = new StringBuilder();
        for (int i = 0; i < 0x20; i++) {
            textUnescBuilder.append((char)i);
        }
        TEXT_UNESC = textUnescBuilder.toString();

        final StringBuilder textEscBuilder = new StringBuilder();
        for (int i = 0; i < 0x20; i++) {
            if (i == 0x8) {
                textEscBuilder.append("\\b");
                continue;
            }
            if (i == 0x9) {
                textEscBuilder.append("\\t");
                continue;
            }
            if (i == 0xA) {
                textEscBuilder.append("\\n");
                continue;
            }
            if (i == 0xC) {
                textEscBuilder.append("\\f");
                continue;
            }
            if (i == 0xD) {
                textEscBuilder.append("\\r");
                continue;
            }
            textEscBuilder.append("\\u");
            textEscBuilder.append(JSONEscapeUtil.toUHexa(i));
        }
        TEXT_ESC = textEscBuilder.toString();

    }



    @Test
    public void testSECUHexa() throws Exception {

        final String textSECUHexaLevel1 = TEXT_ESC;
        final String textSECUHexaLevel2 = TEXT_ESC;
        final String textSECUHexaLevel3 = TEXT_ESC;
        final String textSECUHexaLevel4 = TEXT_ESC;

        testEscapeSECUHexa1(TEXT_UNESC, textSECUHexaLevel1);
        testEscapeSECUHexa2(TEXT_UNESC, textSECUHexaLevel2);
        testEscapeSECUHexa3(TEXT_UNESC, textSECUHexaLevel3);
        testEscapeSECUHexa4(TEXT_UNESC, textSECUHexaLevel4);

        testUnescape(textSECUHexaLevel1, TEXT_UNESC);
        testUnescape(textSECUHexaLevel2, TEXT_UNESC);
        testUnescape(textSECUHexaLevel3, TEXT_UNESC);
        testUnescape(textSECUHexaLevel4, TEXT_UNESC);

    }





    public JSONEscape11Test() {
        super();
    }


}

