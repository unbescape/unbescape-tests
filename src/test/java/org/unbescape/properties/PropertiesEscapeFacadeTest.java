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
 *   Tests for the public {@link PropertiesEscape} facade: every method must apply the level its documentation
 *   states, in all of its variants, and honour the documented argument contract.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class PropertiesEscapeFacadeTest {


    private static final String[] TEXTS = COMMON_TEXTS;




    @Test
    public void testEscapePropertiesValueMinimal() throws Exception {
        check("escapePropertiesValueMinimal", TEXTS,
                t -> PropertiesValueEscapeUtil.escape(t, PropertiesValueEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET),
                PropertiesEscape::escapePropertiesValueMinimal, (t, w) -> PropertiesEscape.escapePropertiesValueMinimal(t, w),
                PropertiesEscape::escapePropertiesValueMinimal, PropertiesEscape::escapePropertiesValueMinimal);
    }


    @Test
    public void testEscapePropertiesValue() throws Exception {
        check("escapePropertiesValue", TEXTS,
                t -> PropertiesValueEscapeUtil.escape(t,
                        PropertiesValueEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET),
                PropertiesEscape::escapePropertiesValue, (t, w) -> PropertiesEscape.escapePropertiesValue(t, w),
                PropertiesEscape::escapePropertiesValue, PropertiesEscape::escapePropertiesValue);
    }


    @Test
    public void testEscapePropertiesValueConfigurable() throws Exception {
        for (final PropertiesValueEscapeLevel level : PropertiesValueEscapeLevel.values()) {
            check("escapePropertiesValue(" + level + ")", TEXTS,
                    t -> PropertiesValueEscapeUtil.escape(t, level),
                    t -> PropertiesEscape.escapePropertiesValue(t, level),
                    (t, w) -> PropertiesEscape.escapePropertiesValue(t, w, level),
                    (r, w) -> PropertiesEscape.escapePropertiesValue(r, w, level),
                    (t, o, l, w) -> PropertiesEscape.escapePropertiesValue(t, o, l, w, level));
        }
        checkRejected("escapePropertiesValue(null level)",
                t -> PropertiesEscape.escapePropertiesValue(t, (PropertiesValueEscapeLevel) null),
                (t, w) -> PropertiesEscape.escapePropertiesValue(t, w, null),
                (r, w) -> PropertiesEscape.escapePropertiesValue(r, w, null),
                (t, o, l, w) -> PropertiesEscape.escapePropertiesValue(t, o, l, w, null));
    }


    @Test
    public void testEscapePropertiesKeyMinimal() throws Exception {
        check("escapePropertiesKeyMinimal", TEXTS,
                t -> PropertiesKeyEscapeUtil.escape(t, PropertiesKeyEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET),
                PropertiesEscape::escapePropertiesKeyMinimal, (t, w) -> PropertiesEscape.escapePropertiesKeyMinimal(t, w),
                PropertiesEscape::escapePropertiesKeyMinimal, PropertiesEscape::escapePropertiesKeyMinimal);
    }


    @Test
    public void testEscapePropertiesKey() throws Exception {
        check("escapePropertiesKey", TEXTS,
                t -> PropertiesKeyEscapeUtil.escape(t,
                        PropertiesKeyEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET),
                PropertiesEscape::escapePropertiesKey, (t, w) -> PropertiesEscape.escapePropertiesKey(t, w),
                PropertiesEscape::escapePropertiesKey, PropertiesEscape::escapePropertiesKey);
    }


    @Test
    public void testEscapePropertiesKeyConfigurable() throws Exception {
        for (final PropertiesKeyEscapeLevel level : PropertiesKeyEscapeLevel.values()) {
            check("escapePropertiesKey(" + level + ")", TEXTS,
                    t -> PropertiesKeyEscapeUtil.escape(t, level),
                    t -> PropertiesEscape.escapePropertiesKey(t, level),
                    (t, w) -> PropertiesEscape.escapePropertiesKey(t, w, level),
                    (r, w) -> PropertiesEscape.escapePropertiesKey(r, w, level),
                    (t, o, l, w) -> PropertiesEscape.escapePropertiesKey(t, o, l, w, level));
        }
        checkRejected("escapePropertiesKey(null level)",
                t -> PropertiesEscape.escapePropertiesKey(t, (PropertiesKeyEscapeLevel) null),
                (t, w) -> PropertiesEscape.escapePropertiesKey(t, w, null),
                (r, w) -> PropertiesEscape.escapePropertiesKey(r, w, null),
                (t, o, l, w) -> PropertiesEscape.escapePropertiesKey(t, o, l, w, null));
    }


    @Test
    public void testUnescapeProperties() throws Exception {
        final List<StringOperation> escapes = FacadeTestUtil.operations();
        for (final PropertiesValueEscapeLevel level : PropertiesValueEscapeLevel.values()) {
            escapes.add(t -> PropertiesValueEscapeUtil.escape(t, level));
        }
        for (final PropertiesKeyEscapeLevel level : PropertiesKeyEscapeLevel.values()) {
            escapes.add(t -> PropertiesKeyEscapeUtil.escape(t, level));
        }
        check("unescapeProperties", FacadeTestUtil.unescapeTexts(TEXTS, escapes),
                PropertiesUnescapeUtil::unescape,
                PropertiesEscape::unescapeProperties, (t, w) -> PropertiesEscape.unescapeProperties(t, w),
                PropertiesEscape::unescapeProperties, PropertiesEscape::unescapeProperties);
    }


    @Test
    public void testEscapeLevelForLevel() {
        for (final PropertiesValueEscapeLevel level : PropertiesValueEscapeLevel.values()) {
            Assertions.assertSame(level, PropertiesValueEscapeLevel.forLevel(level.getEscapeLevel()));
        }
        for (final PropertiesKeyEscapeLevel level : PropertiesKeyEscapeLevel.values()) {
            Assertions.assertSame(level, PropertiesKeyEscapeLevel.forLevel(level.getEscapeLevel()));
        }
        final PropertiesValueEscapeLevel[] values = PropertiesValueEscapeLevel.values();
        final int valueMin = values[0].getEscapeLevel();
        final int valueMax = values[values.length - 1].getEscapeLevel();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> PropertiesValueEscapeLevel.forLevel(valueMin - 1));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> PropertiesValueEscapeLevel.forLevel(valueMax + 1));
        final PropertiesKeyEscapeLevel[] keys = PropertiesKeyEscapeLevel.values();
        final int keyMin = keys[0].getEscapeLevel();
        final int keyMax = keys[keys.length - 1].getEscapeLevel();
        Assertions.assertThrows(IllegalArgumentException.class, () -> PropertiesKeyEscapeLevel.forLevel(keyMin - 1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> PropertiesKeyEscapeLevel.forLevel(keyMax + 1));
    }




    public PropertiesEscapeFacadeTest() {
        super();
    }


}
