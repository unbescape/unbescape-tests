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
package org.unbescape.css;

import org.junit.Test;

import static org.unbescape.css.CssIdentifierEscapeTestUtil.testEscapeBECompact1;
import static org.unbescape.css.CssIdentifierEscapeTestUtil.testEscapeBECompact2;
import static org.unbescape.css.CssIdentifierEscapeTestUtil.testEscapeBECompact3;
import static org.unbescape.css.CssIdentifierEscapeTestUtil.testUnescape;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.0
 *
 */
public class CssIdentifierEscape11Test {


    private static final String TEXT_UNESC;
    private static final String TEXT_ESC;
    private static final String TEXT_ESC_3;



    static {
        final StringBuilder textUnescBuilder = new StringBuilder();
        for (int i = 0; i <= '~'; i++) {
            textUnescBuilder.append((char)i);
        }
        TEXT_UNESC = textUnescBuilder.toString();

        final StringBuilder textEscBuilder = new StringBuilder();
        final StringBuilder textEsc3Builder = new StringBuilder();
        for (int i = 0; i <= '~'; i++) {

            if (i < 0x20) {
                textEscBuilder.append("\\" + new String(CssIdentifierEscapeUtil.toCompactHexa(i, (char) 0x0, 4)));
                textEsc3Builder.append("\\" + new String(CssIdentifierEscapeUtil.toCompactHexa(i, (char) 0x0, 4)));
                continue;
            } else {
                switch(i) {
                    case ' ':
                    case '!':
                    case '"':
                    case '#':
                    case '$':
                    case '%':
                    case '&':
                    case '\'':
                    case '(':
                    case ')':
                    case '*':
                    case '+':
                    case ',':
                    case '.':
                    case '/':
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                    case '?':
                    case '@':
                    case '[':
                    case '\\':
                    case ']':
                    case '^':
                    case '`':
                    case '{':
                    case '|':
                    case '}':
                    case '~': textEscBuilder.append("\\" + (char)i); textEsc3Builder.append("\\" + (char)i); continue;
                    // colon: will not be used for escaping: not recognized by IE < 8
                    case ':': final String hexa = new String(CssIdentifierEscapeUtil.toCompactHexa(i, (char) 0x0, 4));
                              textEscBuilder.append("\\" + hexa);
                              textEsc3Builder.append("\\" + hexa);
                              continue;
                    // underscore: will only be escaped at the beginning of an identifier (in order to avoid issues in IE6)
                    case '_':
                    // hyphen: will only be escaped when identifer starts with '--' or '-{digit}'
                    case '-': textEscBuilder.append((char)i);
                              textEsc3Builder.append("\\" + (char)i);
                              continue;
                }

            }
            textEscBuilder.append((char)i);
            textEsc3Builder.append((char)i);
        }
        TEXT_ESC = textEscBuilder.toString();
        TEXT_ESC_3 = textEsc3Builder.toString();

    }



    @Test
    public void testBECompact() throws Exception {

        final String textBECompactLevel1 = TEXT_ESC;
        final String textBECompactLevel2 = TEXT_ESC;
        final String textBECompactLevel3 = TEXT_ESC_3;

        testEscapeBECompact1(TEXT_UNESC, textBECompactLevel1);
        testEscapeBECompact2(TEXT_UNESC, textBECompactLevel2);
        testEscapeBECompact3(TEXT_UNESC, textBECompactLevel3);

        testUnescape(textBECompactLevel1, TEXT_UNESC);
        testUnescape(textBECompactLevel2, TEXT_UNESC);
        testUnescape(textBECompactLevel3, TEXT_UNESC);

    }





    public CssIdentifierEscape11Test() {
        super();
    }


}

