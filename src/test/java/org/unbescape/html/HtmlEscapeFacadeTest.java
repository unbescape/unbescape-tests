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
package org.unbescape.html;

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
 *   Tests for the public {@link HtmlEscape} facade: every method must apply the type and level its documentation
 *   states, in all of its variants, and honour the documented argument contract.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class HtmlEscapeFacadeTest {


    private static final String[] TEXTS = COMMON_TEXTS;




    @Test
    public void testEscapeHtml5() throws Exception {
        check("escapeHtml5", TEXTS,
                t -> HtmlEscapeUtil.escape(t, HtmlEscapeType.HTML5_NAMED_REFERENCES_DEFAULT_TO_DECIMAL,
                                              HtmlEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_MARKUP_SIGNIFICANT),
                HtmlEscape::escapeHtml5, HtmlEscape::escapeHtml5, HtmlEscape::escapeHtml5, HtmlEscape::escapeHtml5);
    }


    @Test
    public void testEscapeHtml5Xml() throws Exception {
        check("escapeHtml5Xml", TEXTS,
                t -> HtmlEscapeUtil.escape(t, HtmlEscapeType.HTML5_NAMED_REFERENCES_DEFAULT_TO_DECIMAL,
                                              HtmlEscapeLevel.LEVEL_1_ONLY_MARKUP_SIGNIFICANT),
                HtmlEscape::escapeHtml5Xml, HtmlEscape::escapeHtml5Xml, HtmlEscape::escapeHtml5Xml,
                HtmlEscape::escapeHtml5Xml);
    }


    @Test
    public void testEscapeHtml4() throws Exception {
        check("escapeHtml4", TEXTS,
                t -> HtmlEscapeUtil.escape(t, HtmlEscapeType.HTML4_NAMED_REFERENCES_DEFAULT_TO_DECIMAL,
                                              HtmlEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_MARKUP_SIGNIFICANT),
                HtmlEscape::escapeHtml4, HtmlEscape::escapeHtml4, HtmlEscape::escapeHtml4, HtmlEscape::escapeHtml4);
    }


    @Test
    public void testEscapeHtml4Xml() throws Exception {
        check("escapeHtml4Xml", TEXTS,
                t -> HtmlEscapeUtil.escape(t, HtmlEscapeType.HTML4_NAMED_REFERENCES_DEFAULT_TO_DECIMAL,
                                              HtmlEscapeLevel.LEVEL_1_ONLY_MARKUP_SIGNIFICANT),
                HtmlEscape::escapeHtml4Xml, HtmlEscape::escapeHtml4Xml, HtmlEscape::escapeHtml4Xml,
                HtmlEscape::escapeHtml4Xml);
    }


    @Test
    public void testEscapeHtmlConfigurable() throws Exception {
        for (final HtmlEscapeType type : HtmlEscapeType.values()) {
            for (final HtmlEscapeLevel level : HtmlEscapeLevel.values()) {
                check("escapeHtml(" + type + ", " + level + ")", TEXTS,
                        t -> HtmlEscapeUtil.escape(t, type, level),
                        t -> HtmlEscape.escapeHtml(t, type, level),
                        (t, w) -> HtmlEscape.escapeHtml(t, w, type, level),
                        (r, w) -> HtmlEscape.escapeHtml(r, w, type, level),
                        (t, o, l, w) -> HtmlEscape.escapeHtml(t, o, l, w, type, level));
            }
        }
        final HtmlEscapeLevel level = HtmlEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_MARKUP_SIGNIFICANT;
        checkRejected("escapeHtml(null type)",
                t -> HtmlEscape.escapeHtml(t, null, level),
                (t, w) -> HtmlEscape.escapeHtml(t, w, null, level),
                (r, w) -> HtmlEscape.escapeHtml(r, w, null, level),
                (t, o, l, w) -> HtmlEscape.escapeHtml(t, o, l, w, null, level));
        final HtmlEscapeType type = HtmlEscapeType.HTML5_NAMED_REFERENCES_DEFAULT_TO_DECIMAL;
        checkRejected("escapeHtml(null level)",
                t -> HtmlEscape.escapeHtml(t, type, null),
                (t, w) -> HtmlEscape.escapeHtml(t, w, type, null),
                (r, w) -> HtmlEscape.escapeHtml(r, w, type, null),
                (t, o, l, w) -> HtmlEscape.escapeHtml(t, o, l, w, type, null));
    }


    @Test
    public void testUnescapeHtml() throws Exception {
        final List<StringOperation> escapes = FacadeTestUtil.operations();
        for (final HtmlEscapeType type : HtmlEscapeType.values()) {
            for (final HtmlEscapeLevel level : HtmlEscapeLevel.values()) {
                escapes.add(t -> HtmlEscapeUtil.escape(t, type, level));
            }
        }
        check("unescapeHtml", FacadeTestUtil.unescapeTexts(TEXTS, escapes),
                HtmlEscapeUtil::unescape,
                HtmlEscape::unescapeHtml, HtmlEscape::unescapeHtml, HtmlEscape::unescapeHtml,
                HtmlEscape::unescapeHtml);
    }


    @Test
    public void testEscapeLevelForLevel() {
        for (final HtmlEscapeLevel level : HtmlEscapeLevel.values()) {
            Assertions.assertSame(level, HtmlEscapeLevel.forLevel(level.getEscapeLevel()));
        }
        final int min = HtmlEscapeLevel.values()[0].getEscapeLevel();
        final int max = HtmlEscapeLevel.values()[HtmlEscapeLevel.values().length - 1].getEscapeLevel();
        Assertions.assertThrows(IllegalArgumentException.class, () -> HtmlEscapeLevel.forLevel(min - 1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> HtmlEscapeLevel.forLevel(max + 1));
    }




    public HtmlEscapeFacadeTest() {
        super();
    }


}
