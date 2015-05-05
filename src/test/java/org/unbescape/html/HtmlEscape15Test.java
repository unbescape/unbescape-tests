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
package org.unbescape.html;

import org.junit.Test;

import static org.unbescape.html.HtmlEscapeTestUtil.testUnescape;

/**
 *
 * @author Brandon Forehand
 *
 * @since 1.1.1
 *
 */
public class HtmlEscape15Test {

    private static final String NCR_START = "&#";
    private static final String HEX = "x";
    private static final String NCR_END = ";";
    private static final String REPLACEMENT = "\uFFFD";

    @Test
    public void testUnescapeHex() throws Exception {

        for (int i = 0xD800; i <= 0xDFFF; ++i) {
            final StringBuilder builder = new StringBuilder();
            builder.append(NCR_START);
            builder.append(HEX);
            builder.append(Integer.toString(i, 16));
            builder.append(NCR_END);
            testUnescape(builder.toString(), REPLACEMENT);
        }

    }

    @Test
    public void testUnescapeDec() throws Exception {

        for (int i = 0xD800; i <= 0xDFFF; ++i) {
            final StringBuilder builder = new StringBuilder();
            builder.append(NCR_START);
            builder.append(Integer.toString(i));
            builder.append(NCR_END);
            testUnescape(builder.toString(), REPLACEMENT);
        }

    }

    @Test
    public void testUnescapeReplacement() throws Exception {

        testUnescape(REPLACEMENT, REPLACEMENT);

    }

    public HtmlEscape15Test() {
        super();
    }

}
