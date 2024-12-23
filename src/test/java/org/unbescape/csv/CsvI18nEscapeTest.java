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
package org.unbescape.csv;

import org.junit.jupiter.api.Test;

import static org.unbescape.csv.CsvEscapeTestUtil.testEscape;
import static org.unbescape.csv.CsvEscapeTestUtil.testUnescape;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.0
 *
 */
public class CsvI18nEscapeTest {



    private static final String TEXT_UNESC =
            "Jako efektivn\u0115j\u0161\u00ED se n\u00E1m jev\u00ED po\u0159\u00E1d\u00E1n\u00ED tzv.\n" +
            "Gira prost\u0159ednictv\u00EDm na\u0161ich autorizovan\u00FDch dealer\u016F v " +
            "\u010Cech\u00E1ch a na Morav\u011B, kter\u00E9 prob\u011Bhnou v pr\u016Fb\u011Bhu " +
            "z\u00E1\u0159\u00ED a \u0159\u00EDjna.";
    private static final String TEXT_ESC =
            "\"Jako efektivn\u0115j\u0161\u00ED se n\u00E1m jev\u00ED po\u0159\u00E1d\u00E1n\u00ED tzv.\n" +
            "Gira prost\u0159ednictv\u00EDm na\u0161ich autorizovan\u00FDch dealer\u016F v " +
            "\u010Cech\u00E1ch a na Morav\u011B, kter\u00E9 prob\u011Bhnou v pr\u016Fb\u011Bhu " +
            "z\u00E1\u0159\u00ED a \u0159\u00EDjna.\"";




    @Test
    public void test() throws Exception {

        testEscape(TEXT_UNESC, TEXT_ESC);
        testUnescape(TEXT_ESC, TEXT_UNESC);

    }



    public CsvI18nEscapeTest() {
        super();
    }


}

