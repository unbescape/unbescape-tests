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

import static org.unbescape.html.HtmlEscapeTestUtil.*;

/**
 * 
 * @author Christian Schuster
 * 
 * @since 1.0
 *
 */
public class HtmlEscape14Test {


    private static final String TEXT_ESC = "&AElig;";
    private static final String TEXT_UNESC = "\u00C6";




    @Test
    public void testEscape01() throws Exception {

        testEscapeHtml4Decimal2(TEXT_UNESC, TEXT_ESC);

    }





    @Test
    public void testEscape02() throws Exception {

        testEscapeHtml5Decimal2(TEXT_UNESC, TEXT_ESC);

    }




    public HtmlEscape14Test() {
        super();
    }


}

