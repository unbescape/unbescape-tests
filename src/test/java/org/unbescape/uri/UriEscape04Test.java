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
package org.unbescape.uri;

import org.junit.jupiter.api.Test;

import static org.unbescape.uri.UriEscapeTestUtil.testEscapeFragmentId;
import static org.unbescape.uri.UriEscapeTestUtil.testEscapePath;
import static org.unbescape.uri.UriEscapeTestUtil.testEscapePathSegment;
import static org.unbescape.uri.UriEscapeTestUtil.testEscapeQueryParam;
import static org.unbescape.uri.UriEscapeTestUtil.testUnescapeFragmentId;
import static org.unbescape.uri.UriEscapeTestUtil.testUnescapePath;
import static org.unbescape.uri.UriEscapeTestUtil.testUnescapePathSegment;
import static org.unbescape.uri.UriEscapeTestUtil.testUnescapeQueryParam;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.1
 *
 */
public class UriEscape04Test {


    private static final String TEXT =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ\u0163\uD840\uDC00\ud835\udccd-\u0163-\uD840\uDC00-\ud835\udccd\u00E0\u00E1\u00E2\u00E3\u00E4\u00E5\u00E6abcdefghijklmnopqrstuvwxyz";




    @Test
    public void test() throws Exception {

        final String textPath =
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ%C5%A3%F0%A0%80%80%F0%9D%93%8D-%C5%A3-%F0%A0%80%80-%F0%9D%93%8D%C3%A0%C3%A1%C3%A2%C3%A3%C3%A4%C3%A5%C3%A6abcdefghijklmnopqrstuvwxyz";
        final String textPathSegment =
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ%C5%A3%F0%A0%80%80%F0%9D%93%8D-%C5%A3-%F0%A0%80%80-%F0%9D%93%8D%C3%A0%C3%A1%C3%A2%C3%A3%C3%A4%C3%A5%C3%A6abcdefghijklmnopqrstuvwxyz";
        final String textQueryParam =
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ%C5%A3%F0%A0%80%80%F0%9D%93%8D-%C5%A3-%F0%A0%80%80-%F0%9D%93%8D%C3%A0%C3%A1%C3%A2%C3%A3%C3%A4%C3%A5%C3%A6abcdefghijklmnopqrstuvwxyz";
        final String textFragmentId =
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ%C5%A3%F0%A0%80%80%F0%9D%93%8D-%C5%A3-%F0%A0%80%80-%F0%9D%93%8D%C3%A0%C3%A1%C3%A2%C3%A3%C3%A4%C3%A5%C3%A6abcdefghijklmnopqrstuvwxyz";

        testEscapePath(TEXT, textPath);
        testEscapePathSegment(TEXT, textPathSegment);
        testEscapeQueryParam(TEXT, textQueryParam);
        testEscapeFragmentId(TEXT, textFragmentId);

        testUnescapePath(textPath, TEXT);
        testUnescapePathSegment(textPathSegment, TEXT);
        testUnescapeQueryParam(textQueryParam, TEXT);
        testUnescapeFragmentId(textFragmentId, TEXT);

    }










    public UriEscape04Test() {
        super();
    }


}

