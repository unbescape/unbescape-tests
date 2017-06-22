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
package org.unbescape.html;

import org.junit.Test;

import static org.unbescape.html.HtmlEscapeTestUtil.testUnescape;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.0
 *
 */
public class HtmlEscape11Test {


    private static final String TEXT_ESC = "&euro; - &#X20aC; - &#8364; - &#X80; - &#128; - &#X80gs - &#X20ACgs - &#8364as - &#8364as";
    private static final String TEXT_UNESC = "\u20AC - \u20AC - \u20AC - \u20AC - \u20AC - \u20ACgs - \u20ACgs - \u20ACas - \u20ACas";




    @Test
    public void testUnescape01() throws Exception {

        testUnescape(TEXT_ESC, TEXT_UNESC);
        testUnescape(TEXT_UNESC, TEXT_UNESC);

    }




    public HtmlEscape11Test() {
        super();
    }


}

