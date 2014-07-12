/*
 * =============================================================================
 * 
 *   Copyright (c) 2014, The UNBESCAPE team (http://www.unbescape.org)
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
package org.unbescape.uri;

import java.net.URLDecoder;
import java.net.URLEncoder;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.0
 *
 */
public class WhitespaceEscapeTest {




    @Test
    public void testWhitespace() throws Exception {

        /*
         * Note on the escaping of QUERY PARAMETERS (and only those)
         * ---------------------------------------------------------
         *
         * Browsers would encode this text in a form textarea as
         * "a+a%0D%0Ab" because http://www.w3.org/TR/html401/interact/forms.html#h-17.13.4
         * establishes that:
         *
         *    - ' ' is encoded as '+'
         *    - '\n' is encoded as CRLF, '%0D%0A'
         *
         * Unbescape's support is for URI escaping/encoding, not for form value encoding, so it will not
         * apply these rules when escaping and will instead apply RFC3986, which establishes
         * '%20' as escape of ' ' and no conversion LF -> CRLF.
         *
         * However, unbescape will correctly unescape both '%20' and '+' as replacements for
         * whitespece in query parameters. Note that '%0D%0A' will be unescaped as '\r\n', which
         * is in fact 100% compatible with the behaviour of the Servlet API
         * HttpServletRequest#getParameterValues() and also java.net.URLDecoder.decode(...).
         */

        testWhitespaceForEscapeType(UriEscapeUtil.UriEscapeType.QUERY_PARAM, true);
        testWhitespaceForEscapeType(UriEscapeUtil.UriEscapeType.FRAGMENT_ID, false);
        testWhitespaceForEscapeType(UriEscapeUtil.UriEscapeType.PATH, false);
        testWhitespaceForEscapeType(UriEscapeUtil.UriEscapeType.PATH_SEGMENT, false);

    }




    public static void testWhitespaceForEscapeType(final UriEscapeUtil.UriEscapeType type, final boolean plusEscapingAllowed) throws Exception {

        final String inputMsg1 = "a a\nb";
        final String outputMsg1_1 = "a%20a%0Ab";
        final String outputMsg1_2 = "a+a%0Ab";
        final String outputMsg1_3 = "a a\nb";
        final String outputMsg1_4 = "a+a\nb";

        final String inputMsg2 = "a a\r\nb";
        final String outputMsg2_1 = "a%20a%0D%0Ab";
        final String outputMsg2_2 = "a+a%0D%0Ab";
        final String outputMsg2_3 = "a a\r\nb";
        final String outputMsg2_4 = "a+a\r\nb";

        final String result1_1 = UriEscapeUtil.escape(inputMsg1, type, "UTF-8");
        final String result1_2 = URLEncoder.encode(inputMsg1, "UTF-8");
        final String result1_3 = UriEscapeUtil.unescape(result1_1, type, "UTF-8");
        final String result1_4 = UriEscapeUtil.unescape(result1_2, type, "UTF-8");
        final String result1_5 = URLDecoder.decode(result1_1, "UTF-8");
        final String result1_6 = URLDecoder.decode(result1_2, "UTF-8");

        final String result2_1 = UriEscapeUtil.escape(inputMsg2, type, "UTF-8");
        final String result2_2 = URLEncoder.encode(inputMsg2, "UTF-8");
        final String result2_3 = UriEscapeUtil.unescape(result2_1, type, "UTF-8");
        final String result2_4 = UriEscapeUtil.unescape(result2_2, type, "UTF-8");
        final String result2_5 = URLDecoder.decode(result2_1, "UTF-8");
        final String result2_6 = URLDecoder.decode(result2_2, "UTF-8");

        Assert.assertEquals(outputMsg1_1, result1_1);
        Assert.assertEquals(outputMsg1_2, result1_2);
        Assert.assertEquals(outputMsg1_3, result1_3);
        if (plusEscapingAllowed) {
            Assert.assertEquals(outputMsg1_3, result1_4);
        } else {
            Assert.assertEquals(outputMsg1_4, result1_4);
        }
        Assert.assertEquals(outputMsg1_3, result1_5);
        Assert.assertEquals(outputMsg1_3, result1_6);

        Assert.assertEquals(outputMsg2_1, result2_1);
        Assert.assertEquals(outputMsg2_2, result2_2);
        Assert.assertEquals(outputMsg2_3, result2_3);
        if (plusEscapingAllowed) {
            Assert.assertEquals(outputMsg2_3, result2_4);
        } else {
            Assert.assertEquals(outputMsg2_4, result2_4);
        }
        Assert.assertEquals(outputMsg2_3, result2_5);
        Assert.assertEquals(outputMsg2_3, result2_6);

    }




    public WhitespaceEscapeTest() {
        super();
    }


}

