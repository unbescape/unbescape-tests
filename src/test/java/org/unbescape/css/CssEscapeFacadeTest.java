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
package org.unbescape.css;

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
 *   Tests for the public {@link CssEscape} facade: every method must apply the type and level its documentation
 *   states, in all of its variants, and honour the documented argument contract.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class CssEscapeFacadeTest {


    private static final String[] TEXTS = COMMON_TEXTS;




    @Test
    public void testEscapeCssStringMinimal() throws Exception {
        check("escapeCssStringMinimal", TEXTS,
                t -> CssStringEscapeUtil.escape(t, CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_COMPACT_HEXA,
                                                   CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET),
                CssEscape::escapeCssStringMinimal, CssEscape::escapeCssStringMinimal,
                CssEscape::escapeCssStringMinimal, CssEscape::escapeCssStringMinimal);
    }


    @Test
    public void testEscapeCssString() throws Exception {
        check("escapeCssString", TEXTS,
                t -> CssStringEscapeUtil.escape(t, CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_COMPACT_HEXA,
                                                   CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET),
                CssEscape::escapeCssString, CssEscape::escapeCssString, CssEscape::escapeCssString,
                CssEscape::escapeCssString);
    }


    @Test
    public void testEscapeCssStringConfigurable() throws Exception {
        for (final CssStringEscapeType type : CssStringEscapeType.values()) {
            for (final CssStringEscapeLevel level : CssStringEscapeLevel.values()) {
                check("escapeCssString(" + type + ", " + level + ")", TEXTS,
                        t -> CssStringEscapeUtil.escape(t, type, level),
                        t -> CssEscape.escapeCssString(t, type, level),
                        (t, w) -> CssEscape.escapeCssString(t, w, type, level),
                        (r, w) -> CssEscape.escapeCssString(r, w, type, level),
                        (t, o, l, w) -> CssEscape.escapeCssString(t, o, l, w, type, level));
            }
        }
        final CssStringEscapeType type = CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_COMPACT_HEXA;
        final CssStringEscapeLevel level = CssStringEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET;
        checkRejected("escapeCssString(null type)",
                t -> CssEscape.escapeCssString(t, null, level),
                (t, w) -> CssEscape.escapeCssString(t, w, null, level),
                (r, w) -> CssEscape.escapeCssString(r, w, null, level),
                (t, o, l, w) -> CssEscape.escapeCssString(t, o, l, w, null, level));
        checkRejected("escapeCssString(null level)",
                t -> CssEscape.escapeCssString(t, type, null),
                (t, w) -> CssEscape.escapeCssString(t, w, type, null),
                (r, w) -> CssEscape.escapeCssString(r, w, type, null),
                (t, o, l, w) -> CssEscape.escapeCssString(t, o, l, w, type, null));
    }


    @Test
    public void testEscapeCssIdentifierMinimal() throws Exception {
        check("escapeCssIdentifierMinimal", TEXTS,
                t -> CssIdentifierEscapeUtil.escape(t,
                        CssIdentifierEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_COMPACT_HEXA,
                        CssIdentifierEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET),
                CssEscape::escapeCssIdentifierMinimal, CssEscape::escapeCssIdentifierMinimal,
                CssEscape::escapeCssIdentifierMinimal, CssEscape::escapeCssIdentifierMinimal);
    }


    @Test
    public void testEscapeCssIdentifier() throws Exception {
        check("escapeCssIdentifier", TEXTS,
                t -> CssIdentifierEscapeUtil.escape(t,
                        CssIdentifierEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_COMPACT_HEXA,
                        CssIdentifierEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET),
                CssEscape::escapeCssIdentifier, CssEscape::escapeCssIdentifier, CssEscape::escapeCssIdentifier,
                CssEscape::escapeCssIdentifier);
    }


    @Test
    public void testEscapeCssIdentifierConfigurable() throws Exception {
        for (final CssIdentifierEscapeType type : CssIdentifierEscapeType.values()) {
            for (final CssIdentifierEscapeLevel level : CssIdentifierEscapeLevel.values()) {
                check("escapeCssIdentifier(" + type + ", " + level + ")", TEXTS,
                        t -> CssIdentifierEscapeUtil.escape(t, type, level),
                        t -> CssEscape.escapeCssIdentifier(t, type, level),
                        (t, w) -> CssEscape.escapeCssIdentifier(t, w, type, level),
                        (r, w) -> CssEscape.escapeCssIdentifier(r, w, type, level),
                        (t, o, l, w) -> CssEscape.escapeCssIdentifier(t, o, l, w, type, level));
            }
        }
        final CssIdentifierEscapeType type = CssIdentifierEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_COMPACT_HEXA;
        final CssIdentifierEscapeLevel level = CssIdentifierEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET;
        checkRejected("escapeCssIdentifier(null type)",
                t -> CssEscape.escapeCssIdentifier(t, null, level),
                (t, w) -> CssEscape.escapeCssIdentifier(t, w, null, level),
                (r, w) -> CssEscape.escapeCssIdentifier(r, w, null, level),
                (t, o, l, w) -> CssEscape.escapeCssIdentifier(t, o, l, w, null, level));
        checkRejected("escapeCssIdentifier(null level)",
                t -> CssEscape.escapeCssIdentifier(t, type, null),
                (t, w) -> CssEscape.escapeCssIdentifier(t, w, type, null),
                (r, w) -> CssEscape.escapeCssIdentifier(r, w, type, null),
                (t, o, l, w) -> CssEscape.escapeCssIdentifier(t, o, l, w, type, null));
    }


    @Test
    public void testUnescapeCss() throws Exception {
        final List<StringOperation> escapes = FacadeTestUtil.operations();
        for (final CssStringEscapeType type : CssStringEscapeType.values()) {
            for (final CssStringEscapeLevel level : CssStringEscapeLevel.values()) {
                escapes.add(t -> CssStringEscapeUtil.escape(t, type, level));
            }
        }
        for (final CssIdentifierEscapeType type : CssIdentifierEscapeType.values()) {
            for (final CssIdentifierEscapeLevel level : CssIdentifierEscapeLevel.values()) {
                escapes.add(t -> CssIdentifierEscapeUtil.escape(t, type, level));
            }
        }
        check("unescapeCss", FacadeTestUtil.unescapeTexts(TEXTS, escapes),
                CssUnescapeUtil::unescape,
                CssEscape::unescapeCss, CssEscape::unescapeCss, CssEscape::unescapeCss, CssEscape::unescapeCss);
    }


    @Test
    public void testEscapeLevelForLevel() {
        for (final CssStringEscapeLevel level : CssStringEscapeLevel.values()) {
            Assertions.assertSame(level, CssStringEscapeLevel.forLevel(level.getEscapeLevel()));
        }
        for (final CssIdentifierEscapeLevel level : CssIdentifierEscapeLevel.values()) {
            Assertions.assertSame(level, CssIdentifierEscapeLevel.forLevel(level.getEscapeLevel()));
        }
        final int stringMin = CssStringEscapeLevel.values()[0].getEscapeLevel();
        final int stringMax = CssStringEscapeLevel.values()[CssStringEscapeLevel.values().length - 1].getEscapeLevel();
        Assertions.assertThrows(IllegalArgumentException.class, () -> CssStringEscapeLevel.forLevel(stringMin - 1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> CssStringEscapeLevel.forLevel(stringMax + 1));
        final int idMin = CssIdentifierEscapeLevel.values()[0].getEscapeLevel();
        final int idMax =
                CssIdentifierEscapeLevel.values()[CssIdentifierEscapeLevel.values().length - 1].getEscapeLevel();
        Assertions.assertThrows(IllegalArgumentException.class, () -> CssIdentifierEscapeLevel.forLevel(idMin - 1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> CssIdentifierEscapeLevel.forLevel(idMax + 1));
    }




    public CssEscapeFacadeTest() {
        super();
    }


}
