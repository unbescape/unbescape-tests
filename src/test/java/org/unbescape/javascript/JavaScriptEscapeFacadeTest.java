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

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.unbescape.FacadeTestUtil;
import org.unbescape.FacadeTestUtil.StringOperation;

import static org.unbescape.FacadeTestUtil.COMMON_TEXTS;
import static org.unbescape.FacadeTestUtil.check;
import static org.unbescape.FacadeTestUtil.checkRejected;

/**
 * <p>
 *   Tests for the public {@link JavaScriptEscape} facade: every method must apply the type and level its
 *   documentation states, in all of its variants, and honour the documented argument contract.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class JavaScriptEscapeFacadeTest {


    private static final String[] TEXTS = COMMON_TEXTS;

    private static final JavaScriptEscapeType DEFAULT_TYPE =
            JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA;




    @Test
    public void testEscapeJavaScriptMinimal() throws Exception {
        check("escapeJavaScriptMinimal", TEXTS,
                t -> JavaScriptEscapeUtil.escape(t, DEFAULT_TYPE, JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET),
                JavaScriptEscape::escapeJavaScriptMinimal, JavaScriptEscape::escapeJavaScriptMinimal,
                JavaScriptEscape::escapeJavaScriptMinimal, JavaScriptEscape::escapeJavaScriptMinimal);
    }


    @Test
    public void testEscapeJavaScript() throws Exception {
        check("escapeJavaScript", TEXTS,
                t -> JavaScriptEscapeUtil.escape(t, DEFAULT_TYPE,
                                                    JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET),
                JavaScriptEscape::escapeJavaScript, JavaScriptEscape::escapeJavaScript,
                JavaScriptEscape::escapeJavaScript, JavaScriptEscape::escapeJavaScript);
    }


    @Test
    public void testEscapeJavaScriptConfigurable() throws Exception {
        for (final JavaScriptEscapeType type : JavaScriptEscapeType.values()) {
            for (final JavaScriptEscapeLevel level : JavaScriptEscapeLevel.values()) {
                check("escapeJavaScript(" + type + ", " + level + ")", TEXTS,
                        t -> JavaScriptEscapeUtil.escape(t, type, level),
                        t -> JavaScriptEscape.escapeJavaScript(t, type, level),
                        (t, w) -> JavaScriptEscape.escapeJavaScript(t, w, type, level),
                        (r, w) -> JavaScriptEscape.escapeJavaScript(r, w, type, level),
                        (t, o, l, w) -> JavaScriptEscape.escapeJavaScript(t, o, l, w, type, level));
            }
        }
        final JavaScriptEscapeLevel level = JavaScriptEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET;
        checkRejected("escapeJavaScript(null type)",
                t -> JavaScriptEscape.escapeJavaScript(t, null, level),
                (t, w) -> JavaScriptEscape.escapeJavaScript(t, w, null, level),
                (r, w) -> JavaScriptEscape.escapeJavaScript(r, w, null, level),
                (t, o, l, w) -> JavaScriptEscape.escapeJavaScript(t, o, l, w, null, level));
        checkRejected("escapeJavaScript(null level)",
                t -> JavaScriptEscape.escapeJavaScript(t, DEFAULT_TYPE, null),
                (t, w) -> JavaScriptEscape.escapeJavaScript(t, w, DEFAULT_TYPE, null),
                (r, w) -> JavaScriptEscape.escapeJavaScript(r, w, DEFAULT_TYPE, null),
                (t, o, l, w) -> JavaScriptEscape.escapeJavaScript(t, o, l, w, DEFAULT_TYPE, null));
    }


    @Test
    public void testUnescapeJavaScript() throws Exception {
        final List<StringOperation> escapes = FacadeTestUtil.operations();
        for (final JavaScriptEscapeType type : JavaScriptEscapeType.values()) {
            for (final JavaScriptEscapeLevel level : JavaScriptEscapeLevel.values()) {
                escapes.add(t -> JavaScriptEscapeUtil.escape(t, type, level));
            }
        }
        check("unescapeJavaScript", FacadeTestUtil.unescapeTexts(TEXTS, escapes),
                JavaScriptEscapeUtil::unescape,
                JavaScriptEscape::unescapeJavaScript, JavaScriptEscape::unescapeJavaScript,
                JavaScriptEscape::unescapeJavaScript, JavaScriptEscape::unescapeJavaScript);
    }


    @Test
    public void testEscapeLevelForLevel() {
        for (final JavaScriptEscapeLevel level : JavaScriptEscapeLevel.values()) {
            Assertions.assertSame(level, JavaScriptEscapeLevel.forLevel(level.getEscapeLevel()));
        }
        final int min = JavaScriptEscapeLevel.values()[0].getEscapeLevel();
        final int max = JavaScriptEscapeLevel.values()[JavaScriptEscapeLevel.values().length - 1].getEscapeLevel();
        Assertions.assertThrows(IllegalArgumentException.class, () -> JavaScriptEscapeLevel.forLevel(min - 1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> JavaScriptEscapeLevel.forLevel(max + 1));
    }




    public JavaScriptEscapeFacadeTest() {
        super();
    }


}
