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
public class HtmlEscape16Test {

    private static final String NCR_START = "&#";
    private static final String HEX = "x";
    private static final String NCR_END = ";";
    private static final String REPLACEMENT = "\uFFFD";

    /* This actually represents the range 0x007F-0x009F, but some of
       these codepoints are already being replaced by their
       Windows-1252 codes in HtmlEscapeUtil.translateIllFormedCodepoint. */
    private static final int[] REPLACED_CODEPOINTS = {
        0x007F, 0x0081, 0x008D, 0x008F, 0x0090, 0x009D
    };

    private static final int[] RESTRICTED_CODEPOINTS = {
        0x000B, 0xFFFE, 0xFFFF, 0x1FFFE, 0x1FFFF, 0x2FFFE, 0x2FFFF, 0x3FFFE,
        0x3FFFF, 0x4FFFE, 0x4FFFF, 0x5FFFE, 0x5FFFF, 0x6FFFE, 0x6FFFF, 0x7FFFE,
        0x7FFFF, 0x8FFFE, 0x8FFFF, 0x9FFFE, 0x9FFFF, 0xAFFFE, 0xAFFFF, 0xBFFFE,
        0xBFFFF, 0xCFFFE, 0xCFFFF, 0xDFFFE, 0xDFFFF, 0xEFFFE, 0xEFFFF, 0xFFFFE,
        0xFFFFF, 0x10FFFE, 0x10FFFF
    };

    @Test
    public void testUnescapeHex() throws Exception {

        for (int i = 0x0001; i <= 0x0008; ++i) {
            final StringBuilder builder = new StringBuilder();
            builder.append(NCR_START);
            builder.append(HEX);
            builder.append(Integer.toString(i, 16));
            builder.append(NCR_END);
            testUnescape(builder.toString(), REPLACEMENT);
        }

        for (int i = 0x000D; i <= 0x001F; ++i) {
            final StringBuilder builder = new StringBuilder();
            builder.append(NCR_START);
            builder.append(HEX);
            builder.append(Integer.toString(i, 16));
            builder.append(NCR_END);
            testUnescape(builder.toString(), REPLACEMENT);
        }

        for (int codepoint : REPLACED_CODEPOINTS) {
            final StringBuilder builder = new StringBuilder();
            builder.append(NCR_START);
            builder.append(HEX);
            builder.append(Integer.toString(codepoint, 16));
            builder.append(NCR_END);
            testUnescape(builder.toString(), REPLACEMENT);
        }

        for (int i = 0xFDD0; i <= 0xFDEF; ++i) {
            final StringBuilder builder = new StringBuilder();
            builder.append(NCR_START);
            builder.append(HEX);
            builder.append(Integer.toString(i, 16));
            builder.append(NCR_END);
            testUnescape(builder.toString(), REPLACEMENT);
        }

        for (int codepoint : RESTRICTED_CODEPOINTS) {
            final StringBuilder builder = new StringBuilder();
            builder.append(NCR_START);
            builder.append(HEX);
            builder.append(Integer.toString(codepoint, 16));
            builder.append(NCR_END);
            testUnescape(builder.toString(), REPLACEMENT);
        }

    }

    @Test
    public void testUnescapeDec() throws Exception {

        for (int i = 0x0001; i <= 0x0008; ++i) {
            final StringBuilder builder = new StringBuilder();
            builder.append(NCR_START);
            builder.append(Integer.toString(i));
            builder.append(NCR_END);
            testUnescape(builder.toString(), REPLACEMENT);
        }

        for (int i = 0x000D; i <= 0x001F; ++i) {
            final StringBuilder builder = new StringBuilder();
            builder.append(NCR_START);
            builder.append(Integer.toString(i));
            builder.append(NCR_END);
            testUnescape(builder.toString(), REPLACEMENT);
        }

        for (int codepoint : REPLACED_CODEPOINTS) {
            final StringBuilder builder = new StringBuilder();
            builder.append(NCR_START);
            builder.append(Integer.toString(codepoint));
            builder.append(NCR_END);
            testUnescape(builder.toString(), REPLACEMENT);
        }

        for (int i = 0xFDD0; i <= 0xFDEF; ++i) {
            final StringBuilder builder = new StringBuilder();
            builder.append(NCR_START);
            builder.append(Integer.toString(i));
            builder.append(NCR_END);
            testUnescape(builder.toString(), REPLACEMENT);
        }

        for (int codepoint : RESTRICTED_CODEPOINTS) {
            final StringBuilder builder = new StringBuilder();
            builder.append(NCR_START);
            builder.append(Integer.toString(codepoint));
            builder.append(NCR_END);
            testUnescape(builder.toString(), REPLACEMENT);
        }

    }

    public HtmlEscape16Test() {
        super();
    }

}
