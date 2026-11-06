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

import static org.unbescape.properties.PropertiesKeyEscapeTestUtil.testEscape1;
import static org.unbescape.properties.PropertiesKeyEscapeTestUtil.testEscape2;
import static org.unbescape.properties.PropertiesKeyEscapeTestUtil.testEscape3;
import static org.unbescape.properties.PropertiesKeyEscapeTestUtil.testEscape4;
import static org.unbescape.properties.PropertiesKeyEscapeTestUtil.testUnescape;

/**
 * <p>
 *   Comment chars in keys: <kbd>#</kbd> (U+0023) and <kbd>!</kbd> (U+0021) must always be escaped as
 *   <kbd>&#92;#</kbd> and <kbd>&#92;!</kbd>, as a line starting with any of them is a comment.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.8
 *
 */
public class PropertiesKeyEscape19Test {


    private static final String[] KEYS =
            new String[] { "#", "!", "#a", "!a", "a#b!c", "##", " #a", "plain.key" };




    @Test
    public void testHash() throws Exception {

        testEscape1("#a", "\\#a");
        testEscape2("#a", "\\#a");
        testEscape3("#a", "\\#a");
        testEscape4("#a", "\\#\\u0061");

        testUnescape("\\#a", "#a");

    }




    @Test
    public void testExclamation() throws Exception {

        testEscape1("!a", "\\!a");
        testEscape2("!a", "\\!a");
        testEscape3("!a", "\\!a");
        testEscape4("!a", "\\!\\u0061");

        testUnescape("\\!a", "!a");

    }




    @Test
    public void testNotAtStart() throws Exception {

        testEscape1("a#b!c", "a\\#b\\!c");
        testEscape2("a#b!c", "a\\#b\\!c");

        testUnescape("a\\#b\\!c", "a#b!c");

    }




    @Test
    public void testLoadedByJavaUtilProperties() throws Exception {

        // Every escaped key must be read back by java.util.Properties as exactly one entry with the original
        // key and value, at every escape level (the last key is a positive control without any comment char).
        for (final String key : KEYS) {
            for (final PropertiesKeyEscapeLevel level : PropertiesKeyEscapeLevel.values()) {

                final String line =
                        PropertiesEscape.escapePropertiesKey(key, level) + "=" +
                        PropertiesEscape.escapePropertiesValue("value");

                final Properties properties = new Properties();
                properties.load(new StringReader(line));

                Assertions.assertEquals(1, properties.size(), "Bad entry count for line: " + line);
                Assertions.assertEquals("value", properties.getProperty(key), "Bad key/value for line: " + line);

            }
        }

    }




    public PropertiesKeyEscape19Test() {
        super();
    }


}
