/*
 * =============================================================================
 *
 *   Copyright (c) 2014-2026 Unbescape (https://www.unbescape.org)
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

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.unbescape.csv.CsvEscapeTestUtil.testUnescape;

/**
 * <p>
 *   Unescape of malformed values: a non-escaped double-quote inside a quoted value must be kept as a normal
 *   char, and double-quotes in a value that is not quoted must not be unescaped. All variants (String, char[],
 *   Reader) must agree.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class CsvEscape16Test {




    @Test
    public void testNonEscapedQuoteInQuotedValue() {

        // Run preemptively with a timeout so that a regression fails the test instead of hanging the build
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {

            testUnescape("\"a\"b\"", "a\"b");
            testUnescape("\"a\" b\"", "a\" b");
            testUnescape("\"a\"b\"\"c\"", "a\"b\"c");
            testUnescape("\"a\"\"\"", "a\"");
            testUnescape("\"a\"\"", "a\"");

        });

    }




    @Test
    public void testDoubleQuotesInUnquotedValue() throws Exception {

        testUnescape("a\"\"b", "a\"\"b");
        testUnescape("a\"\"", "a\"\"");
        testUnescape("a \"\" b \"\"", "a \"\" b \"\"");
        testUnescape("a\"b", "a\"b");

        // Positive control: quoted value
        testUnescape("\"a\"\"b\"", "a\"b");

    }




    public CsvEscape16Test() {
        super();
    }


}
