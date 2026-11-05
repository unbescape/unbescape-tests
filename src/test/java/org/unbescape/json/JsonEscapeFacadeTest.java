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
package org.unbescape.json;

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
 *   Tests for the public {@link JsonEscape} facade: every method must apply the type and level its documentation
 *   states, in all of its variants, and honour the documented argument contract.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class JsonEscapeFacadeTest {


    private static final String[] TEXTS = COMMON_TEXTS;

    private static final JsonEscapeType DEFAULT_TYPE = JsonEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA;




    @Test
    public void testEscapeJsonMinimal() throws Exception {
        check("escapeJsonMinimal", TEXTS,
                t -> JsonEscapeUtil.escape(t, DEFAULT_TYPE, JsonEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET),
                JsonEscape::escapeJsonMinimal, JsonEscape::escapeJsonMinimal, JsonEscape::escapeJsonMinimal,
                JsonEscape::escapeJsonMinimal);
    }


    @Test
    public void testEscapeJson() throws Exception {
        check("escapeJson", TEXTS,
                t -> JsonEscapeUtil.escape(t, DEFAULT_TYPE, JsonEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET),
                JsonEscape::escapeJson, JsonEscape::escapeJson, JsonEscape::escapeJson, JsonEscape::escapeJson);
    }


    @Test
    public void testEscapeJsonConfigurable() throws Exception {
        for (final JsonEscapeType type : JsonEscapeType.values()) {
            for (final JsonEscapeLevel level : JsonEscapeLevel.values()) {
                check("escapeJson(" + type + ", " + level + ")", TEXTS,
                        t -> JsonEscapeUtil.escape(t, type, level),
                        t -> JsonEscape.escapeJson(t, type, level),
                        (t, w) -> JsonEscape.escapeJson(t, w, type, level),
                        (r, w) -> JsonEscape.escapeJson(r, w, type, level),
                        (t, o, l, w) -> JsonEscape.escapeJson(t, o, l, w, type, level));
            }
        }
        final JsonEscapeLevel level = JsonEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET;
        checkRejected("escapeJson(null type)",
                t -> JsonEscape.escapeJson(t, null, level),
                (t, w) -> JsonEscape.escapeJson(t, w, null, level),
                (r, w) -> JsonEscape.escapeJson(r, w, null, level),
                (t, o, l, w) -> JsonEscape.escapeJson(t, o, l, w, null, level));
        checkRejected("escapeJson(null level)",
                t -> JsonEscape.escapeJson(t, DEFAULT_TYPE, null),
                (t, w) -> JsonEscape.escapeJson(t, w, DEFAULT_TYPE, null),
                (r, w) -> JsonEscape.escapeJson(r, w, DEFAULT_TYPE, null),
                (t, o, l, w) -> JsonEscape.escapeJson(t, o, l, w, DEFAULT_TYPE, null));
    }


    @Test
    public void testUnescapeJson() throws Exception {
        final List<StringOperation> escapes = FacadeTestUtil.operations();
        for (final JsonEscapeType type : JsonEscapeType.values()) {
            for (final JsonEscapeLevel level : JsonEscapeLevel.values()) {
                escapes.add(t -> JsonEscapeUtil.escape(t, type, level));
            }
        }
        check("unescapeJson", FacadeTestUtil.unescapeTexts(TEXTS, escapes),
                JsonEscapeUtil::unescape,
                JsonEscape::unescapeJson, JsonEscape::unescapeJson, JsonEscape::unescapeJson,
                JsonEscape::unescapeJson);
    }


    @Test
    public void testEscapeLevelForLevel() {
        for (final JsonEscapeLevel level : JsonEscapeLevel.values()) {
            Assertions.assertSame(level, JsonEscapeLevel.forLevel(level.getEscapeLevel()));
        }
        final int min = JsonEscapeLevel.values()[0].getEscapeLevel();
        final int max = JsonEscapeLevel.values()[JsonEscapeLevel.values().length - 1].getEscapeLevel();
        Assertions.assertThrows(IllegalArgumentException.class, () -> JsonEscapeLevel.forLevel(min - 1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> JsonEscapeLevel.forLevel(max + 1));
    }




    public JsonEscapeFacadeTest() {
        super();
    }


}
