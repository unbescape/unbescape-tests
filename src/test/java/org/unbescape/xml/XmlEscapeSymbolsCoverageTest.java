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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * <p>
 *   Coverage of the CER/codepoint lookup structures built inside {@link XmlEscapeSymbols} for each of its four
 *   symbol sets (XML 1.0 / 1.1, content and attribute variants): SORTED_CODEPOINTS, SORTED_CERS_BY_CODEPOINT
 *   (escape), SORTED_CERS and SORTED_CODEPOINTS_BY_CER (unescape).
 * </p>
 * <p>
 *   The escape and unescape arrays are built from the same reference list and must be mutually consistent
 *   (XML defines a single CER per codepoint), so these tests walk every entry of every symbol set and verify
 *   that wiring, plus a public-API unescape round-trip for each CER. They act as a regression guard for the
 *   code that derives those arrays.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class XmlEscapeSymbolsCoverageTest {


    @Test
    public void testXml10() throws Exception {
        checkSymbols(XmlEscapeSymbols.XML10_SYMBOLS);
    }

    @Test
    public void testXml11() throws Exception {
        checkSymbols(XmlEscapeSymbols.XML11_SYMBOLS);
    }

    @Test
    public void testXml10Attribute() throws Exception {
        checkSymbols(XmlEscapeSymbols.XML10_ATTRIBUTE_SYMBOLS);
    }

    @Test
    public void testXml11Attribute() throws Exception {
        checkSymbols(XmlEscapeSymbols.XML11_ATTRIBUTE_SYMBOLS);
    }


    /*
     * Independent, hard-coded ground truth: the five predefined XML entities must unescape to their exact
     * characters. This holds for all XML flavours (there is a single, shared unescapeXml).
     */
    @Test
    public void testPredefinedEntitiesUnescapeToGroundTruth() {
        Assertions.assertEquals("<", XmlEscape.unescapeXml("&lt;"));
        Assertions.assertEquals(">", XmlEscape.unescapeXml("&gt;"));
        Assertions.assertEquals("&", XmlEscape.unescapeXml("&amp;"));
        Assertions.assertEquals("\"", XmlEscape.unescapeXml("&quot;"));
        Assertions.assertEquals("'", XmlEscape.unescapeXml("&apos;"));
    }


    private static void checkSymbols(final XmlEscapeSymbols symbols) {

        final int len = symbols.SORTED_CODEPOINTS.length;

        // All four parallel arrays must share the same length.
        Assertions.assertEquals(len, symbols.SORTED_CERS_BY_CODEPOINT.length);
        Assertions.assertEquals(len, symbols.SORTED_CERS.length);
        Assertions.assertEquals(len, symbols.SORTED_CODEPOINTS_BY_CER.length);
        Assertions.assertTrue(len > 0);

        // SORTED_CODEPOINTS must be sorted ascending (precondition for the codepoint binary search).
        for (int i = 1; i < len; i++) {
            Assertions.assertTrue(
                    symbols.SORTED_CODEPOINTS[i - 1] <= symbols.SORTED_CODEPOINTS[i],
                    "SORTED_CODEPOINTS not ascending at index " + i);
        }

        // Every XML flavour must define exactly the five predefined entities, no more, no less.
        final Set<Integer> codepointSet = new HashSet<Integer>();
        for (int i = 0; i < len; i++) {
            codepointSet.add(Integer.valueOf(symbols.SORTED_CODEPOINTS[i]));
        }
        final Set<Integer> expected = new HashSet<Integer>(Arrays.asList(
                Integer.valueOf('"'), Integer.valueOf('&'), Integer.valueOf('\''),
                Integer.valueOf('<'), Integer.valueOf('>')));
        Assertions.assertEquals(expected, codepointSet);

        int checkedCers = 0;

        // Unescape direction: every (non-null) CER maps to a codepoint, and that codepoint's escape entry maps
        // back to the very same CER (XML has exactly one CER per codepoint, so the two directions are inverses).
        for (int i = 0; i < len; i++) {

            final char[] cer = symbols.SORTED_CERS[i];
            if (cer == null) {
                continue;
            }

            final int cp = symbols.SORTED_CODEPOINTS_BY_CER[i];

            // Find that codepoint in the (ascending) escape array and confirm its preferred CER is this CER.
            final int k = indexOfCodepoint(symbols.SORTED_CODEPOINTS, cp);
            Assertions.assertTrue(k >= 0, "Codepoint U+" + Integer.toHexString(cp) + " missing from SORTED_CODEPOINTS");
            Assertions.assertNotNull(
                    symbols.SORTED_CERS_BY_CODEPOINT[k],
                    "Escape entry for U+" + Integer.toHexString(cp) + " unexpectedly null");
            Assertions.assertTrue(
                    Arrays.equals(cer, symbols.SORTED_CERS_BY_CODEPOINT[k]),
                    "Escape/unescape disagree on the CER for U+" + Integer.toHexString(cp));

            // Public-API round-trip: the CER must unescape to its codepoint.
            Assertions.assertEquals(
                    new String(Character.toChars(cp)), XmlEscape.unescapeXml(new String(cer)),
                    "Bad unescape for CER: " + new String(cer));

            checkedCers++;
        }

        Assertions.assertTrue(checkedCers > 0);

        // Escape direction: every non-null preferred CER lines up with the codepoint at the same index.
        for (int i = 0; i < len; i++) {
            final char[] cer = symbols.SORTED_CERS_BY_CODEPOINT[i];
            if (cer == null) {
                continue;
            }
            Assertions.assertEquals(
                    new String(Character.toChars(symbols.SORTED_CODEPOINTS[i])),
                    XmlEscape.unescapeXml(new String(cer)),
                    "Escape entry CER " + new String(cer) + " does not unescape to its codepoint");
        }
    }


    private static int indexOfCodepoint(final int[] codepoints, final int cp) {
        for (int i = 0; i < codepoints.length; i++) {
            if (codepoints[i] == cp) {
                return i;
            }
        }
        return -1;
    }


    public XmlEscapeSymbolsCoverageTest() {
        super();
    }


}
