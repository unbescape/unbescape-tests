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

import static org.unbescape.properties.PropertiesKeyEscapeTestUtil.testEscape1;
import static org.unbescape.properties.PropertiesKeyEscapeTestUtil.testEscape2;
import static org.unbescape.properties.PropertiesKeyEscapeTestUtil.testEscape3;
import static org.unbescape.properties.PropertiesKeyEscapeTestUtil.testEscape4;
import static org.unbescape.properties.PropertiesKeyEscapeTestUtil.testUnescape;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.0
 *
 */
public class PropertiesKeyEscape11Test {


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
            textEscBuilder.append(PropertiesKeyEscapeUtil.toUHexa(i));
        }
        TEXT_ESC = textEscBuilder.toString();

    }



    @Test
    public void test() throws Exception {

        final String textLevel1 = TEXT_ESC;
        final String textLevel2 = TEXT_ESC;
        final String textLevel3 = TEXT_ESC;
        final String textLevel4 = TEXT_ESC;

        testEscape1(TEXT_UNESC, textLevel1);
        testEscape2(TEXT_UNESC, textLevel2);
        testEscape3(TEXT_UNESC, textLevel3);
        testEscape4(TEXT_UNESC, textLevel4);

        testUnescape(textLevel1, TEXT_UNESC);
        testUnescape(textLevel2, TEXT_UNESC);
        testUnescape(textLevel3, TEXT_UNESC);
        testUnescape(textLevel4, TEXT_UNESC);

    }





    public PropertiesKeyEscape11Test() {
        super();
    }


}

