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

import java.net.URLEncoder;

import org.junit.jupiter.api.Test;
import org.springframework.web.util.UriUtils;

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
public class UriEscape03Test {


    private static final String TEXT =
            "<>\\\"-._~!$&'()*+,;=:@/?{}ABCDEFGHIJKLMNOPQRSTUVWXYZ <>\\\"-._~!$&'()*+,;=:@/?{} abcdefghijklmnopqrstuvwxyz<>\\\"-._~!$&'()*+,;=:@/?{}0123456789<>\\\"-._~!$&'()*+,;=:@/?{}";


    @Test
    public void test() throws Exception {

        final String textPath =
                "%3C%3E%5C%22-._~!$&'()*+,;=:@/%3F%7B%7DABCDEFGHIJKLMNOPQRSTUVWXYZ%20%3C%3E%5C%22-._~!$&'()*+,;=:@/%3F%7B%7D%20abcdefghijklmnopqrstuvwxyz%3C%3E%5C%22-._~!$&'()*+,;=:@/%3F%7B%7D0123456789%3C%3E%5C%22-._~!$&'()*+,;=:@/%3F%7B%7D";
        final String textPathSegment =
                "%3C%3E%5C%22-._~!$&'()*+,;=:@%2F%3F%7B%7DABCDEFGHIJKLMNOPQRSTUVWXYZ%20%3C%3E%5C%22-._~!$&'()*+,;=:@%2F%3F%7B%7D%20abcdefghijklmnopqrstuvwxyz%3C%3E%5C%22-._~!$&'()*+,;=:@%2F%3F%7B%7D0123456789%3C%3E%5C%22-._~!$&'()*+,;=:@%2F%3F%7B%7D";
        final String textQueryParam =
                "%3C%3E%5C%22-._~!$%26'()*%2B,;%3D:@/?%7B%7DABCDEFGHIJKLMNOPQRSTUVWXYZ%20%3C%3E%5C%22-._~!$%26'()*%2B,;%3D:@/?%7B%7D%20abcdefghijklmnopqrstuvwxyz%3C%3E%5C%22-._~!$%26'()*%2B,;%3D:@/?%7B%7D0123456789%3C%3E%5C%22-._~!$%26'()*%2B,;%3D:@/?%7B%7D";
        final String textFragmentId =
                "%3C%3E%5C%22-._~!$&'()*+,;=:@/?%7B%7DABCDEFGHIJKLMNOPQRSTUVWXYZ%20%3C%3E%5C%22-._~!$&'()*+,;=:@/?%7B%7D%20abcdefghijklmnopqrstuvwxyz%3C%3E%5C%22-._~!$&'()*+,;=:@/?%7B%7D0123456789%3C%3E%5C%22-._~!$&'()*+,;=:@/?%7B%7D";

        testEscapePath(TEXT, textPath);
        testEscapePathSegment(TEXT, textPathSegment);
        testEscapeQueryParam(TEXT, textQueryParam);
        testEscapeFragmentId(TEXT, textFragmentId);

        testUnescapePath(textPath, TEXT);
        testUnescapePathSegment(textPathSegment, TEXT);
        testUnescapeQueryParam(textQueryParam, TEXT);
        testUnescapeFragmentId(textFragmentId, TEXT);

    }






    public UriEscape03Test() {
        super();
    }


}

