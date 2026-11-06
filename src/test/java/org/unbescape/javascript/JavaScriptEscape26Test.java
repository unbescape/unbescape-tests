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
package org.unbescape.javascript;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.unbescape.FacadeTestUtil;

import static org.unbescape.javascript.JavaScriptEscapeTestUtil.testEscape;
import static org.unbescape.javascript.JavaScriptEscapeTestUtil.testUnescape;

/**
 * <p>
 *   Template literals: the grave accent (U+0060) is always escaped, the dollar sign (U+0024) is escaped when it is
 *   followed by an opening curly bracket or is the last char, and the opening curly bracket (U+007B) is escaped
 *   when it is the first char.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.8
 *
 */
public class JavaScriptEscape26Test {


    private static final String[] TEXTS =
            new String[] { "`", "${", "${x}", "$", "{", "{$", "a$", "{a", "$$", "{{", "$${", "`${a}`", "$ {", "price: $5 {x}" };




    @Test
    public void testTemplateLiteralChars() throws Exception {

        testEscape("`", "\\`", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("a`b", "a\\`b", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("${x}", "\\${x}", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("a$b", "a$b", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("$5", "$5", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("a$", "a\\$", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("$", "\\$", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("{a}", "\\{a}", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("a{b}", "a{b}", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("{", "\\{", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("${", "\\${", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("{$", "\\{\\$", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("$${", "$\\${", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);

        testEscape("`", "\\`", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("a`b", "a\\`b", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("${x}", "\\${x}", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("a$b", "a$b", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("$5", "$5", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("a$", "a\\$", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("$", "\\$", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("{a}", "\\{a}", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("a{b}", "a{b}", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("{", "\\{", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("${", "\\${", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("{$", "\\{\\$", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("$${", "$\\${", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);

        testEscape("`", "\\`", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("a`b", "a\\`b", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("${x}", "\\${x}", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("a$b", "a$b", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("$5", "$5", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("a$", "a\\$", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("$", "\\$", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("{a}", "\\{a}", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("a{b}", "a{b}", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("{", "\\{", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("${", "\\${", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("{$", "\\{\\$", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("$${", "$\\${", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);

        testEscape("`", "\\`", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("a`b", "a\\`b", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("${x}", "\\${x}", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("a$b", "a$b", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("$5", "$5", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("a$", "a\\$", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("$", "\\$", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("{a}", "\\{a}", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("a{b}", "a{b}", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("{", "\\{", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("${", "\\${", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("{$", "\\{\\$", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("$${", "$\\${", JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);

        testEscape("`", "\\x60", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("a`b", "a\\x60b", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("${x}", "\\x24{x}", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("a$b", "a$b", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("$5", "$5", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("a$", "a\\x24", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("$", "\\x24", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("{a}", "\\x7Ba}", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("a{b}", "a{b}", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("{", "\\x7B", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("${", "\\x24{", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("{$", "\\x7B\\x24", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("$${", "$\\x24{", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);

        testEscape("`", "\\x60", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("a`b", "a\\x60b", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("${x}", "\\x24{x}", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("a$b", "a$b", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("$5", "$5", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("a$", "a\\x24", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("$", "\\x24", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("{a}", "\\x7Ba}", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("a{b}", "a{b}", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("{", "\\x7B", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("${", "\\x24{", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("{$", "\\x7B\\x24", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("$${", "$\\x24{", JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);

        testEscape("`", "\\u0060", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("a`b", "a\\u0060b", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("${x}", "\\u0024{x}", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("a$b", "a$b", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("$5", "$5", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("a$", "a\\u0024", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("$", "\\u0024", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("{a}", "\\u007Ba}", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("a{b}", "a{b}", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("{", "\\u007B", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("${", "\\u0024{", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("{$", "\\u007B\\u0024", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        testEscape("$${", "$\\u0024{", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);

        testEscape("`", "\\u0060", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("a`b", "a\\u0060b", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("${x}", "\\u0024{x}", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("a$b", "a$b", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("$5", "$5", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("a$", "a\\u0024", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("$", "\\u0024", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("{a}", "\\u007Ba}", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("a{b}", "a{b}", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("{", "\\u007B", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("${", "\\u0024{", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("{$", "\\u007B\\u0024", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        testEscape("$${", "$\\u0024{", JavaScriptEscapeType.UHEXA, JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);

    }




    @Test
    public void testAllLevels() throws Exception {

        // Levels 3 and 4 escape these chars anyway (as non-alphanumeric), now using Single Escape Characters
        testEscape("a$b{c`", "a\\$b\\{c\\`",
                JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA, JavaScriptEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC);
        testEscape("a$b{c`", "a\\x24b\\x7Bc\\x60",
                JavaScriptEscapeType.XHEXA_DEFAULT_TO_UHEXA, JavaScriptEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC);

    }




    @Test
    public void testUnescapeTemplateLiteralChars() throws Exception {

        testUnescape("\\`", "`");
        testUnescape("\\$", "$");
        testUnescape("\\{", "{");
        testUnescape("\\${x}", "${x}");

    }




    @Test
    public void testNoTemplateLiteralSyntaxInEscapedText() throws Exception {

        for (final String[] texts : new String[][] { TEXTS, FacadeTestUtil.COMMON_TEXTS }) {
            for (final String text : texts) {
                for (final JavaScriptEscapeType type : JavaScriptEscapeType.values()) {
                    for (final JavaScriptEscapeLevel level : JavaScriptEscapeLevel.values()) {
                        final String escaped = JavaScriptEscape.escapeJavaScript(text, type, level);
                        checkNoTemplateLiteralSyntax(escaped);
                        Assertions.assertEquals(text, JavaScriptEscape.unescapeJavaScript(escaped));
                    }
                }
            }
        }

    }


    // Outside escape sequences, escaped text must not contain '`' or '${', start with '{' or end with '$'
    private static void checkNoTemplateLiteralSyntax(final String escaped) {
        for (int i = 0; i < escaped.length(); i++) {
            final char c = escaped.charAt(i);
            if (c == '\\') {
                i++; // skip the escaped char (hexadecimal escapes only contain alphanumeric chars after it)
                continue;
            }
            Assertions.assertNotEquals('`', c, "Found '`' in: " + escaped);
            Assertions.assertFalse(c == '$' && (i + 1 >= escaped.length() || escaped.charAt(i + 1) == '{'),
                    "Found '$' before '{' or at the end in: " + escaped);
            Assertions.assertFalse(c == '{' && i == 0, "Found '{' at the start of: " + escaped);
        }
    }




    public JavaScriptEscape26Test() {
        super();
    }


}
