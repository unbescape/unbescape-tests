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

import static org.unbescape.csv.CsvEscapeTestUtil.testUnescape;


/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.0
 *
 */
public class CsvEscape08Test {


    private static final String TEXT_ESC_0 = "\\a";
    private static final String TEXT_UNESC_0 = "\\a";

    private static final String TEXT_ESC_1 = "\\a\\z";
    private static final String TEXT_UNESC_1 = "\\a\\z";

    private static final String TEXT_ESC_2 = "\\u";
    private static final String TEXT_UNESC_2 = "\\u";

    private static final String TEXT_ESC_3 = "\\a\\b\\c\\d\\e\\f\\g\\h\\i\\j\\k\\l\\m\\n\\o\\p\\q\\r\\s\\t\\u\\v\\w\\x\\y\\z";
    private static final String TEXT_UNESC_3 = "\\a\\b\\c\\d\\e\\f\\g\\h\\i\\j\\k\\l\\m\\n\\o\\p\\q\\r\\s\\t\\u\\v\\w\\x\\y\\z";

    private static final String TEXT_ESC_4 = "\\0\\1\\2\\3\\4\\5\\6\\7\\8\\9";
    private static final String TEXT_UNESC_4 = "\\0\\1\\2\\3\\4\\5\\6\\7\\8\\9";

    private static final String TEXT_ESC_5 = "\\\n\\\r\\\u2028\\\u2029";
    private static final String TEXT_UNESC_5 = "\\\n\\\r\\\u2028\\\u2029";

    private static final String TEXT_ESC_6 = "\\x";
    private static final String TEXT_UNESC_6 = "\\x";




    @Test
    public void testUnescape01() throws Exception {

        testUnescape(TEXT_ESC_0, TEXT_UNESC_0);
        testUnescape(TEXT_ESC_1, TEXT_UNESC_1);
        testUnescape(TEXT_ESC_2, TEXT_UNESC_2);
        testUnescape(TEXT_ESC_3, TEXT_UNESC_3);
        testUnescape(TEXT_ESC_4, TEXT_UNESC_4);
        testUnescape(TEXT_ESC_5, TEXT_UNESC_5);
        testUnescape(TEXT_ESC_6, TEXT_UNESC_6);

    }




    public CsvEscape08Test() {
        super();
    }


}

