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
package org.unbescape.java;

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
 *   Tests for the public {@link JavaEscape} facade: every method must apply the level its documentation states,
 *   in all of its variants, and honour the documented argument contract.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class JavaEscapeFacadeTest {


    private static final String[] TEXTS = COMMON_TEXTS;




    @Test
    public void testEscapeJavaMinimal() throws Exception {
        check("escapeJavaMinimal", TEXTS,
                t -> JavaEscapeUtil.escape(t, JavaEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET),
                JavaEscape::escapeJavaMinimal, (t, w) -> JavaEscape.escapeJavaMinimal(t, w), JavaEscape::escapeJavaMinimal,
                JavaEscape::escapeJavaMinimal);
    }


    @Test
    public void testEscapeJava() throws Exception {
        check("escapeJava", TEXTS,
                t -> JavaEscapeUtil.escape(t, JavaEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET),
                JavaEscape::escapeJava, (t, w) -> JavaEscape.escapeJava(t, w), JavaEscape::escapeJava, JavaEscape::escapeJava);
    }


    @Test
    public void testEscapeJavaConfigurable() throws Exception {
        for (final JavaEscapeLevel level : JavaEscapeLevel.values()) {
            check("escapeJava(" + level + ")", TEXTS,
                    t -> JavaEscapeUtil.escape(t, level),
                    t -> JavaEscape.escapeJava(t, level),
                    (t, w) -> JavaEscape.escapeJava(t, w, level),
                    (r, w) -> JavaEscape.escapeJava(r, w, level),
                    (t, o, l, w) -> JavaEscape.escapeJava(t, o, l, w, level));
        }
        checkRejected("escapeJava(null level)",
                t -> JavaEscape.escapeJava(t, (JavaEscapeLevel) null),
                (t, w) -> JavaEscape.escapeJava(t, w, null),
                (r, w) -> JavaEscape.escapeJava(r, w, null),
                (t, o, l, w) -> JavaEscape.escapeJava(t, o, l, w, null));
    }


    @Test
    public void testUnescapeJava() throws Exception {
        final List<StringOperation> escapes = FacadeTestUtil.operations();
        for (final JavaEscapeLevel level : JavaEscapeLevel.values()) {
            escapes.add(t -> JavaEscapeUtil.escape(t, level));
        }
        check("unescapeJava", FacadeTestUtil.unescapeTexts(TEXTS, escapes),
                JavaEscapeUtil::unescape,
                JavaEscape::unescapeJava, (t, w) -> JavaEscape.unescapeJava(t, w), JavaEscape::unescapeJava,
                JavaEscape::unescapeJava);
    }


    @Test
    public void testEscapeLevelForLevel() {
        for (final JavaEscapeLevel level : JavaEscapeLevel.values()) {
            Assertions.assertSame(level, JavaEscapeLevel.forLevel(level.getEscapeLevel()));
        }
        final int min = JavaEscapeLevel.values()[0].getEscapeLevel();
        final int max = JavaEscapeLevel.values()[JavaEscapeLevel.values().length - 1].getEscapeLevel();
        Assertions.assertThrows(IllegalArgumentException.class, () -> JavaEscapeLevel.forLevel(min - 1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> JavaEscapeLevel.forLevel(max + 1));
    }




    public JavaEscapeFacadeTest() {
        super();
    }


}
