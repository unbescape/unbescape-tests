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
package org.unbescape.css;

import org.junit.jupiter.api.Test;

import static org.unbescape.css.CssIdentifierEscapeTestUtil.testEscapeBECompact1;
import static org.unbescape.css.CssIdentifierEscapeTestUtil.testEscapeBECompact2;
import static org.unbescape.css.CssIdentifierEscapeTestUtil.testEscapeBECompact3;
import static org.unbescape.css.CssIdentifierEscapeTestUtil.testEscapeBECompact4;
import static org.unbescape.css.CssIdentifierEscapeTestUtil.testUnescape;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.0
 *
 */
public class CssIdentifierEscape12Test {


    private static final String TEXT_UNESC;
    private static final String TEXT_ESC;



    static {
        final StringBuilder textUnescBuilder = new StringBuilder();
        for (int i = 0x7F; i <= 0x9F; i++) {
            textUnescBuilder.append((char)i);
        }
        TEXT_UNESC = textUnescBuilder.toString();

        final StringBuilder textEscBuilder = new StringBuilder();
        for (int i = 0x7F; i <= 0x9F; i++) {
            textEscBuilder.append("\\" + new String(CssIdentifierEscapeUtil.toCompactHexa(i, (char) 0x0, 4)));
        }
        TEXT_ESC = textEscBuilder.toString();

    }



    @Test
    public void testBECompact() throws Exception {

        final String textBECompactLevel1 = TEXT_ESC;
        final String textBECompactLevel2 = TEXT_ESC;
        final String textBECompactLevel3 = TEXT_ESC;
        final String textBECompactLevel4 = TEXT_ESC;

        testEscapeBECompact1(TEXT_UNESC, textBECompactLevel1);
        testEscapeBECompact2(TEXT_UNESC, textBECompactLevel2);
        testEscapeBECompact3(TEXT_UNESC, textBECompactLevel3);
        testEscapeBECompact4(TEXT_UNESC, textBECompactLevel4);

        testUnescape(textBECompactLevel1, TEXT_UNESC);
        testUnescape(textBECompactLevel2, TEXT_UNESC);
        testUnescape(textBECompactLevel3, TEXT_UNESC);
        testUnescape(textBECompactLevel4, TEXT_UNESC);

    }




    public CssIdentifierEscape12Test() {
        super();
    }


}

