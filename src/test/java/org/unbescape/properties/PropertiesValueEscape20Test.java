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
package org.unbescape.properties;

import java.io.StringReader;
import java.util.Properties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.unbescape.properties.PropertiesValueEscapeTestUtil.testEscape1;
import static org.unbescape.properties.PropertiesValueEscapeTestUtil.testEscape2;
import static org.unbescape.properties.PropertiesValueEscapeTestUtil.testEscape3;
import static org.unbescape.properties.PropertiesValueEscapeTestUtil.testEscape4;
import static org.unbescape.properties.PropertiesValueEscapeTestUtil.testUnescape;

/**
 * <p>
 *   First char of values: a whitespace (U+0020), <kbd>:</kbd> (U+003A) or <kbd>=</kbd> (U+003D) at the start of a
 *   value must be escaped, as it would otherwise be read as part of the key-value separator. Anywhere else in the
 *   value, these chars need no escape.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.8
 *
 */
public class PropertiesValueEscape20Test {


    private static final String[] VALUES =
            new String[] { " ", " a", "  a", " a ", "=", "=a", "==a", ":a", " =a", "a b", "a=b:c", "plain value" };

    private static final String[] SEPARATORS = new String[] { "=", ":", " ", " = ", "\t" };




    @Test
    public void testLeadingWhitespace() throws Exception {

        testEscape1(" a", "\\ a");
        testEscape2(" a", "\\ a");
        testEscape3(" a", "\\u0020a");
        testEscape4(" a", "\\u0020\\u0061");

        // Only the first char needs the escape
        testEscape1("  a ", "\\  a ");
        testEscape2("  a ", "\\  a ");

        testUnescape("\\ a", " a");
        testUnescape("\\  a ", "  a ");

    }




    @Test
    public void testLeadingSeparator() throws Exception {

        testEscape1("=a", "\\=a");
        testEscape2("=a", "\\=a");
        testEscape3("=a", "\\u003Da");
        testEscape1(":a", "\\:a");
        testEscape2(":a", "\\:a");
        testEscape3(":a", "\\u003Aa");

        testUnescape("\\=a", "=a");
        testUnescape("\\:a", ":a");

    }




    @Test
    public void testNotAtStart() throws Exception {

        // Positive control: whitespaces and separators after the first char are not escaped at levels 1 and 2
        testEscape1("a b=c:d ", "a b=c:d ");
        testEscape2("a b=c:d ", "a b=c:d ");

    }




    @Test
    public void testLoadedByJavaUtilProperties() throws Exception {

        // Every escaped value must be read back by java.util.Properties as exactly the original value, at every
        // escape level and with every kind of key-value separator.
        for (final String value : VALUES) {
            for (final String separator : SEPARATORS) {
                for (final PropertiesValueEscapeLevel level : PropertiesValueEscapeLevel.values()) {

                    final String line =
                            PropertiesEscape.escapePropertiesKey("key") + separator +
                            PropertiesEscape.escapePropertiesValue(value, level);

                    final Properties properties = new Properties();
                    properties.load(new StringReader(line));

                    Assertions.assertEquals(1, properties.size(), "Bad entry count for line: " + line);
                    Assertions.assertEquals(value, properties.getProperty("key"), "Bad value for line: " + line);

                }
            }
        }

    }




    public PropertiesValueEscape20Test() {
        super();
    }


}
