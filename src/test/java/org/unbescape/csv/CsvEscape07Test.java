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
public class CsvEscape07Test {


    private static final String TEXT_UNESC = "a";
    private static final String TEXT_ESC = "a";




    @Test
    public void test() throws Exception {

        testEscape(TEXT_UNESC, TEXT_ESC);
        testUnescape(TEXT_ESC, TEXT_UNESC);

    }








    public CsvEscape07Test() {
        super();
    }


}

