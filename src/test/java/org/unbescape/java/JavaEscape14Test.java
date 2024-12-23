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
public class JavaEscape14Test {


    // The solidus character should be escaped, but only when it appears right after '<' (in order to avoid
    // closing a <script> tag in an HTML file.
    private static final String TEXT = "/something</script></anything> but http://example.com";




    @Test
    public void test() throws Exception {

        final String textLevel1 = "/something</script></anything> but http://example.com";
        final String textLevel2 = "/something</script></anything> but http://example.com";
        final String textLevel3 = "\\u002Fsomething\\u003C\\u002Fscript\\u003E\\u003C\\u002Fanything\\u003E\\u0020but\\u0020http\\u003A\\u002F\\u002Fexample\\u002Ecom";
        final String textLevel4 = "\\u002F\\u0073\\u006F\\u006D\\u0065\\u0074\\u0068\\u0069\\u006E\\u0067\\u003C\\u002F\\u0073\\u0063\\u0072\\u0069\\u0070\\u0074\\u003E\\u003C\\u002F\\u0061\\u006E\\u0079\\u0074\\u0068\\u0069\\u006E\\u0067\\u003E\\u0020\\u0062\\u0075\\u0074\\u0020\\u0068\\u0074\\u0074\\u0070\\u003A\\u002F\\u002F\\u0065\\u0078\\u0061\\u006D\\u0070\\u006C\\u0065\\u002E\\u0063\\u006F\\u006D";

        testEscape1(TEXT, textLevel1);
        testEscape2(TEXT, textLevel2);
        testEscape3(TEXT, textLevel3);
        testEscape4(TEXT, textLevel4);

        testUnescape(textLevel1, TEXT);
        testUnescape(textLevel2, TEXT);
        testUnescape(textLevel3, TEXT);
        testUnescape(textLevel4, TEXT);

    }







    public JavaEscape14Test() {
        super();
    }


}

