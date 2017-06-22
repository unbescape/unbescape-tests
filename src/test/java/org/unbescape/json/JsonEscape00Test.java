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
package org.unbescape.json;

import org.junit.Test;

import static org.unbescape.json.JsonEscapeTestUtil.testEscapeSECUHexa1;
import static org.unbescape.json.JsonEscapeTestUtil.testEscapeSECUHexa2;
import static org.unbescape.json.JsonEscapeTestUtil.testEscapeSECUHexa3;
import static org.unbescape.json.JsonEscapeTestUtil.testEscapeSECUHexa4;
import static org.unbescape.json.JsonEscapeTestUtil.testEscapeUHexa1;
import static org.unbescape.json.JsonEscapeTestUtil.testEscapeUHexa2;
import static org.unbescape.json.JsonEscapeTestUtil.testEscapeUHexa3;
import static org.unbescape.json.JsonEscapeTestUtil.testEscapeUHexa4;
import static org.unbescape.json.JsonEscapeTestUtil.testUnescape;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.0
 *
 */
public class JsonEscape00Test {


    private static final String TEXT = null;




    @Test
    public void testSECUHexa() throws Exception {

        final String textSECUHexaLevel1 = TEXT;
        final String textSECUHexaLevel2 = TEXT;
        final String textSECUHexaLevel3 = TEXT;
        final String textSECUHexaLevel4 = TEXT;

        testEscapeSECUHexa1(TEXT, textSECUHexaLevel1);
        testEscapeSECUHexa2(TEXT, textSECUHexaLevel2);
        testEscapeSECUHexa3(TEXT, textSECUHexaLevel3);
        testEscapeSECUHexa4(TEXT, textSECUHexaLevel4);

        testUnescape(textSECUHexaLevel1, TEXT);
        testUnescape(textSECUHexaLevel2, TEXT);
        testUnescape(textSECUHexaLevel3, TEXT);
        testUnescape(textSECUHexaLevel4, TEXT);

    }





    @Test
    public void testUHexa() throws Exception {

        final String textUHexaLevel1 = TEXT;
        final String textUHexaLevel2 = TEXT;
        final String textUHexaLevel3 = TEXT;
        final String textUHexaLevel4 = TEXT;

        testEscapeUHexa1(TEXT, textUHexaLevel1);
        testEscapeUHexa2(TEXT, textUHexaLevel2);
        testEscapeUHexa3(TEXT, textUHexaLevel3);
        testEscapeUHexa4(TEXT, textUHexaLevel4);

        testUnescape(textUHexaLevel1, TEXT);
        testUnescape(textUHexaLevel2, TEXT);
        testUnescape(textUHexaLevel3, TEXT);
        testUnescape(textUHexaLevel4, TEXT);

    }








    public JsonEscape00Test() {
        super();
    }


}

