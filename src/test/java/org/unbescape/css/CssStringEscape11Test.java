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

import static org.unbescape.css.CssStringEscapeTestUtil.testEscapeBECompact1;
import static org.unbescape.css.CssStringEscapeTestUtil.testEscapeBECompact2;
import static org.unbescape.css.CssStringEscapeTestUtil.testUnescape;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.0
 *
 */
public class CssStringEscape11Test {


    private static final String TEXT_UNESC;
    private static final String TEXT_ESC;



    static {
        final StringBuilder textUnescBuilder = new StringBuilder();
        for (int i = 0; i <= '~'; i++) {
            textUnescBuilder.append((char)i);
        }
        TEXT_UNESC = textUnescBuilder.toString();

        final StringBuilder textEscBuilder = new StringBuilder();
        for (int i = 0; i <= '~'; i++) {

            if (i < 0x20) {
                textEscBuilder.append("\\" + new String(CssIdentifierEscapeUtil.toCompactHexa(i, (char) 0x0, 4)));
                continue;
            } else {
                switch(i) {
                    case ' ':textEscBuilder.append("  "); continue;
                    case '\\':
                    case '"':
                    case '&':
                    case '/':
                    case ';':
                    case '\'':textEscBuilder.append("\\" + (char)i); continue;
                }

            }
            textEscBuilder.append((char)i);
        }
        TEXT_ESC = textEscBuilder.toString();

    }



    @Test
    public void testBECompact() throws Exception {

        final String textBECompactLevel1 = TEXT_ESC;
        final String textBECompactLevel2 = TEXT_ESC;

        testEscapeBECompact1(TEXT_UNESC, textBECompactLevel1);
        testEscapeBECompact2(TEXT_UNESC, textBECompactLevel2);

        testUnescape(textBECompactLevel1, TEXT_UNESC);
        testUnescape(textBECompactLevel2, TEXT_UNESC);

    }





    public CssStringEscape11Test() {
        super();
    }


}

