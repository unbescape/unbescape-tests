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
package org.unbescape.xml;

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
 *   Tests for the public {@link XmlEscape} facade: every method must apply the symbols (XML 1.0 or 1.1, content
 *   or attribute), type and level its documentation states, in all of its variants, and honour the documented
 *   argument contract.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class XmlEscapeFacadeTest {


    private static final String[] TEXTS = COMMON_TEXTS;

    private static final XmlEscapeType DEFAULT_TYPE = XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_HEXA;
    private static final XmlEscapeLevel MINIMAL = XmlEscapeLevel.LEVEL_1_ONLY_MARKUP_SIGNIFICANT;
    private static final XmlEscapeLevel DEFAULT = XmlEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_MARKUP_SIGNIFICANT;




    @Test
    public void testEscapeXml10Minimal() throws Exception {
        check("escapeXml10Minimal", TEXTS,
                t -> XmlEscapeUtil.escape(t, XmlEscapeSymbols.XML10_SYMBOLS, DEFAULT_TYPE, MINIMAL),
                XmlEscape::escapeXml10Minimal, XmlEscape::escapeXml10Minimal, XmlEscape::escapeXml10Minimal,
                XmlEscape::escapeXml10Minimal);
    }


    @Test
    public void testEscapeXml11Minimal() throws Exception {
        check("escapeXml11Minimal", TEXTS,
                t -> XmlEscapeUtil.escape(t, XmlEscapeSymbols.XML11_SYMBOLS, DEFAULT_TYPE, MINIMAL),
                XmlEscape::escapeXml11Minimal, XmlEscape::escapeXml11Minimal, XmlEscape::escapeXml11Minimal,
                XmlEscape::escapeXml11Minimal);
    }


    @Test
    public void testEscapeXml10AttributeMinimal() throws Exception {
        check("escapeXml10AttributeMinimal", TEXTS,
                t -> XmlEscapeUtil.escape(t, XmlEscapeSymbols.XML10_ATTRIBUTE_SYMBOLS, DEFAULT_TYPE, MINIMAL),
                XmlEscape::escapeXml10AttributeMinimal, XmlEscape::escapeXml10AttributeMinimal,
                XmlEscape::escapeXml10AttributeMinimal, XmlEscape::escapeXml10AttributeMinimal);
    }


    @Test
    public void testEscapeXml11AttributeMinimal() throws Exception {
        check("escapeXml11AttributeMinimal", TEXTS,
                t -> XmlEscapeUtil.escape(t, XmlEscapeSymbols.XML11_ATTRIBUTE_SYMBOLS, DEFAULT_TYPE, MINIMAL),
                XmlEscape::escapeXml11AttributeMinimal, XmlEscape::escapeXml11AttributeMinimal,
                XmlEscape::escapeXml11AttributeMinimal, XmlEscape::escapeXml11AttributeMinimal);
    }


    @Test
    public void testEscapeXml10() throws Exception {
        check("escapeXml10", TEXTS,
                t -> XmlEscapeUtil.escape(t, XmlEscapeSymbols.XML10_SYMBOLS, DEFAULT_TYPE, DEFAULT),
                XmlEscape::escapeXml10, XmlEscape::escapeXml10, XmlEscape::escapeXml10, XmlEscape::escapeXml10);
    }


    @Test
    public void testEscapeXml11() throws Exception {
        check("escapeXml11", TEXTS,
                t -> XmlEscapeUtil.escape(t, XmlEscapeSymbols.XML11_SYMBOLS, DEFAULT_TYPE, DEFAULT),
                XmlEscape::escapeXml11, XmlEscape::escapeXml11, XmlEscape::escapeXml11, XmlEscape::escapeXml11);
    }


    @Test
    public void testEscapeXml10Attribute() throws Exception {
        check("escapeXml10Attribute", TEXTS,
                t -> XmlEscapeUtil.escape(t, XmlEscapeSymbols.XML10_ATTRIBUTE_SYMBOLS, DEFAULT_TYPE, DEFAULT),
                XmlEscape::escapeXml10Attribute, XmlEscape::escapeXml10Attribute, XmlEscape::escapeXml10Attribute,
                XmlEscape::escapeXml10Attribute);
    }


    @Test
    public void testEscapeXml11Attribute() throws Exception {
        check("escapeXml11Attribute", TEXTS,
                t -> XmlEscapeUtil.escape(t, XmlEscapeSymbols.XML11_ATTRIBUTE_SYMBOLS, DEFAULT_TYPE, DEFAULT),
                XmlEscape::escapeXml11Attribute, XmlEscape::escapeXml11Attribute, XmlEscape::escapeXml11Attribute,
                XmlEscape::escapeXml11Attribute);
    }


    @Test
    public void testEscapeXmlConfigurable() throws Exception {
        for (final XmlEscapeType type : XmlEscapeType.values()) {
            for (final XmlEscapeLevel level : XmlEscapeLevel.values()) {
                final String config = "(" + type + ", " + level + ")";
                check("escapeXml10" + config, TEXTS,
                        t -> XmlEscapeUtil.escape(t, XmlEscapeSymbols.XML10_SYMBOLS, type, level),
                        t -> XmlEscape.escapeXml10(t, type, level),
                        (t, w) -> XmlEscape.escapeXml10(t, w, type, level),
                        (r, w) -> XmlEscape.escapeXml10(r, w, type, level),
                        (t, o, l, w) -> XmlEscape.escapeXml10(t, o, l, w, type, level));
                check("escapeXml11" + config, TEXTS,
                        t -> XmlEscapeUtil.escape(t, XmlEscapeSymbols.XML11_SYMBOLS, type, level),
                        t -> XmlEscape.escapeXml11(t, type, level),
                        (t, w) -> XmlEscape.escapeXml11(t, w, type, level),
                        (r, w) -> XmlEscape.escapeXml11(r, w, type, level),
                        (t, o, l, w) -> XmlEscape.escapeXml11(t, o, l, w, type, level));
                check("escapeXml10Attribute" + config, TEXTS,
                        t -> XmlEscapeUtil.escape(t, XmlEscapeSymbols.XML10_ATTRIBUTE_SYMBOLS, type, level),
                        t -> XmlEscape.escapeXml10Attribute(t, type, level),
                        (t, w) -> XmlEscape.escapeXml10Attribute(t, w, type, level),
                        (r, w) -> XmlEscape.escapeXml10Attribute(r, w, type, level),
                        (t, o, l, w) -> XmlEscape.escapeXml10Attribute(t, o, l, w, type, level));
                check("escapeXml11Attribute" + config, TEXTS,
                        t -> XmlEscapeUtil.escape(t, XmlEscapeSymbols.XML11_ATTRIBUTE_SYMBOLS, type, level),
                        t -> XmlEscape.escapeXml11Attribute(t, type, level),
                        (t, w) -> XmlEscape.escapeXml11Attribute(t, w, type, level),
                        (r, w) -> XmlEscape.escapeXml11Attribute(r, w, type, level),
                        (t, o, l, w) -> XmlEscape.escapeXml11Attribute(t, o, l, w, type, level));
            }
        }
        checkRejected("escapeXml10(null type)",
                t -> XmlEscape.escapeXml10(t, null, DEFAULT),
                (t, w) -> XmlEscape.escapeXml10(t, w, null, DEFAULT),
                (r, w) -> XmlEscape.escapeXml10(r, w, null, DEFAULT),
                (t, o, l, w) -> XmlEscape.escapeXml10(t, o, l, w, null, DEFAULT));
        checkRejected("escapeXml11Attribute(null level)",
                t -> XmlEscape.escapeXml11Attribute(t, DEFAULT_TYPE, null),
                (t, w) -> XmlEscape.escapeXml11Attribute(t, w, DEFAULT_TYPE, null),
                (r, w) -> XmlEscape.escapeXml11Attribute(r, w, DEFAULT_TYPE, null),
                (t, o, l, w) -> XmlEscape.escapeXml11Attribute(t, o, l, w, DEFAULT_TYPE, null));
    }


    @Test
    public void testUnescapeXml() throws Exception {
        final List<StringOperation> escapes = FacadeTestUtil.operations();
        for (final XmlEscapeType type : XmlEscapeType.values()) {
            for (final XmlEscapeLevel level : XmlEscapeLevel.values()) {
                escapes.add(t -> XmlEscapeUtil.escape(t, XmlEscapeSymbols.XML10_SYMBOLS, type, level));
                escapes.add(t -> XmlEscapeUtil.escape(t, XmlEscapeSymbols.XML11_ATTRIBUTE_SYMBOLS, type, level));
            }
        }
        // XML 1.0 and 1.1 define the same five CERs, so unescaping is the same for both
        final String[] texts = FacadeTestUtil.unescapeTexts(TEXTS, escapes);
        check("unescapeXml (as XML 1.0)", texts,
                t -> XmlEscapeUtil.unescape(t, XmlEscapeSymbols.XML10_SYMBOLS),
                XmlEscape::unescapeXml, XmlEscape::unescapeXml, XmlEscape::unescapeXml, XmlEscape::unescapeXml);
        check("unescapeXml (as XML 1.1)", texts,
                t -> XmlEscapeUtil.unescape(t, XmlEscapeSymbols.XML11_SYMBOLS),
                XmlEscape::unescapeXml, XmlEscape::unescapeXml, XmlEscape::unescapeXml, XmlEscape::unescapeXml);
    }


    @Test
    public void testEscapeLevelForLevel() {
        for (final XmlEscapeLevel level : XmlEscapeLevel.values()) {
            Assertions.assertSame(level, XmlEscapeLevel.forLevel(level.getEscapeLevel()));
        }
        final int min = XmlEscapeLevel.values()[0].getEscapeLevel();
        final int max = XmlEscapeLevel.values()[XmlEscapeLevel.values().length - 1].getEscapeLevel();
        Assertions.assertThrows(IllegalArgumentException.class, () -> XmlEscapeLevel.forLevel(min - 1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> XmlEscapeLevel.forLevel(max + 1));
    }




    public XmlEscapeFacadeTest() {
        super();
    }


}
