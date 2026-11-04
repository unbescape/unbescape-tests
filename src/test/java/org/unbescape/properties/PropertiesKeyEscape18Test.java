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
 *   Key/value separators in keys: <kbd>=</kbd> (U+003D) must always be escaped as <kbd>\=</kbd>, and
 *   <kbd>;</kbd> (U+003B), which is not a separator, must not be turned into <kbd>\=</kbd>.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class PropertiesKeyEscape18Test {


    private static final String[] KEYS =
            new String[] { "=", ";", "a=b;c:d e", "=a=", "a;b", "plain.key" };




    @Test
    public void testEquals() throws Exception {

        final String text = "=";

        testEscape1(text, "\\=");
        testEscape2(text, "\\=");
        testEscape3(text, "\\=");
        testEscape4(text, "\\=");

        testUnescape("\\=", text);

    }




    @Test
    public void testSemicolon() throws Exception {

        final String text = ";";

        testEscape1(text, ";");
        testEscape2(text, ";");
        testEscape3(text, "\\u003B");
        testEscape4(text, "\\u003B");

        testUnescape(";", text);
        testUnescape("\\u003B", text);

    }




    @Test
    public void testMixed() throws Exception {

        final String text = "a=b;c:d e";

        final String textLevel1 = "a\\=b;c\\:d\\ e";
        final String textLevel2 = "a\\=b;c\\:d\\ e";
        final String textLevel3 = "a\\=b\\u003Bc\\:d\\ e";
        final String textLevel4 = "\\u0061\\=\\u0062\\u003B\\u0063\\:\\u0064\\ \\u0065";

        testEscape1(text, textLevel1);
        testEscape2(text, textLevel2);
        testEscape3(text, textLevel3);
        testEscape4(text, textLevel4);

        testUnescape(textLevel1, text);
        testUnescape(textLevel2, text);
        testUnescape(textLevel3, text);
        testUnescape(textLevel4, text);

    }




    @Test
    public void testLoadedByJavaUtilProperties() throws Exception {

        // Every escaped key must be read back by java.util.Properties as exactly one entry with the original
        // key and value, at every escape level (the last key is a positive control without any separator).
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




    public PropertiesKeyEscape18Test() {
        super();
    }


}
