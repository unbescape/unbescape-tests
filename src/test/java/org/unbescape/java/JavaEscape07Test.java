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
package org.unbescape.java;

import org.junit.jupiter.api.Test;

import static org.unbescape.java.JavaEscapeTestUtil.testEscape1;
import static org.unbescape.java.JavaEscapeTestUtil.testEscape2;
import static org.unbescape.java.JavaEscapeTestUtil.testEscape3;
import static org.unbescape.java.JavaEscapeTestUtil.testEscape4;
import static org.unbescape.java.JavaEscapeTestUtil.testUnescape;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.0
 *
 */
public class JavaEscape07Test {


    private static final String TEXT = "a";




    @Test
    public void test() throws Exception {

        final String textLevel1 = "a";
        final String textLevel2 = "a";
        final String textLevel3 = "a";
        final String textLevel4 = "\\u0061";

        testEscape1(TEXT, textLevel1);
        testEscape2(TEXT, textLevel2);
        testEscape3(TEXT, textLevel3);
        testEscape4(TEXT, textLevel4);

        testUnescape(textLevel1, TEXT);
        testUnescape(textLevel2, TEXT);
        testUnescape(textLevel3, TEXT);
        testUnescape(textLevel4, TEXT);

    }








    public JavaEscape07Test() {
        super();
    }


}

