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

import static org.unbescape.javascript.JavaScriptEscapeTestUtil.testUnescape;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.0
 *
 */
public class JavaScriptEscape12Test {


    private static final String TEXT_UNESC;
    private static final String TEXT_ESC;



    static {

        final StringBuilder textEscBuilder = new StringBuilder();
        for (int i = 0; i < 0x20; i++) {
            if (i == 0x0) {
                textEscBuilder.append("\\0");
                continue;
            }
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
            if (i == 0xB) {
                textEscBuilder.append("\\v");
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
            textEscBuilder.append("\\x");
            textEscBuilder.append(JavaScriptEscapeUtil.toXHexa(i));
        }
        TEXT_ESC = textEscBuilder.toString();

        final StringBuilder textUnescBuilder = new StringBuilder();
        for (int i = 0; i < 0x20; i++) {
            textUnescBuilder.append((char)i);
        }
        TEXT_UNESC = textUnescBuilder.toString();

    }



    @Test
    public void testUnescapeWithSlashV() throws Exception {

        testUnescape(TEXT_ESC, TEXT_UNESC);

    }





    public JavaScriptEscape12Test() {
        super();
    }


}

