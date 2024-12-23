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
package org.unbescape.xml;

import org.junit.jupiter.api.Test;

import static org.unbescape.xml.XmlEscapeTestUtil.testUnescape;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.0
 *
 */
public class XmlEscape07Test {


    private static final String TEXT_ESC = "&euro; - &#x20aC; - &#X20aC; - &#8364; - &#x80; - &#128; - &#x80gs - &#x20ACgs - &#8364as - &#8364as";
    private static final String TEXT_UNESC = "&euro; - \u20AC - &#X20aC; - \u20AC - \u0080 - \u0080 - &#x80gs - &#x20ACgs - &#8364as - &#8364as";




    @Test
    public void testUnescape01() throws Exception {

        testUnescape(TEXT_ESC, TEXT_UNESC);
        testUnescape(TEXT_UNESC, TEXT_UNESC);

    }




    public XmlEscape07Test() {
        super();
    }


}

