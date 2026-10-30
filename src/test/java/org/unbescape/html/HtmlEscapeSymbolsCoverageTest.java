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

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * <p>
 *   Exhaustive coverage of the NCR/codepoint lookup structures built inside {@link HtmlEscapeSymbols}
 *   (SORTED_NCRS, SORTED_CODEPOINTS, NCRS_BY_CODEPOINT, the overflow map and DOUBLE_CODEPOINTS).
 * </p>
 * <p>
 *   The tests walk <em>every</em> entry of those structures in both directions, and additionally assert the
 *   presence of every edge-case category they must contain (no-semicolon NCRs, double-codepoint NCRs,
 *   direct-indexed vs overflow codepoints, BMP vs supplementary-plane overflow, and codepoints with several
 *   NCRs), plus a set of hand-picked ground-truth cases, so the coverage cannot silently become vacuous.
 * </p>
 * <p>
 *   Note unescaping is always HTML5-canonical in Unbescape (there is a single {@code unescapeHtml}), and a few
 *   NCRs (e.g. {@code &lang;}) map to a different codepoint in HTML5 than in HTML4. Public round-trip checks
 *   are therefore exercised against the HTML5 table; the HTML4 table is validated through the escape direction
 *   and through structural-consistency checks that do not route through the unescaper.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class HtmlEscapeSymbolsCoverageTest {


    /*
     * Hand-picked ground-truth NCR -> unescaped-text cases. These values are independent of the structures
     * under test (they are spec facts), and they deliberately span every edge-case category.
     */
    private static final String[][] HTML5_GROUND_TRUTH = new String[][] {
            { "&aacute;",        "\u00e1" },              // ordinary single BMP codepoint
            { "&amp",            "&" },                   // legacy NCR with NO trailing ';'
            { "&copy",           "\u00a9" },              // legacy NCR with NO trailing ';'
            { "&lt;",            "<" },                   // markup-significant
            { "&gt;",            ">" },                   // codepoint shared by several NCRs ...
            { "&GT;",            ">" },                   // ... (U+003E has both &gt; and &GT;)
            { "&fjlig;",         "fj" },                  // double-codepoint NCR (U+0066 U+006A)
            { "&NotEqualTilde;", "\u2242\u0338" },        // double-codepoint NCR (with combining mark)
            { "&bnequiv;",       "\u2261\u20e5" },        // double-codepoint NCR
            { "&Ascr;",          "\ud835\udc9c" }         // overflow + supplementary plane (U+1D49C)
    };


    @Test
    public void testHtml4EscapeTableIsInternallyConsistent() throws Exception {
        checkEscapeTableConsistency(HtmlEscapeSymbols.HTML4_SYMBOLS);
    }

    @Test
    public void testHtml5EscapeTableIsInternallyConsistent() throws Exception {
        checkEscapeTableConsistency(HtmlEscapeSymbols.HTML5_SYMBOLS);
    }

    @Test
    public void testHtml4EscapeEveryCodepointToItsPreferredNcr() throws Exception {
        // HTML4 escape uses the HTML4 table; we do not round-trip through the (HTML5-canonical) unescaper.
        checkEveryCodepointEscapesToItsPreferredNcr(
                HtmlEscapeSymbols.HTML4_SYMBOLS, HtmlEscapeType.HTML4_NAMED_REFERENCES_DEFAULT_TO_DECIMAL, false);
    }

    @Test
    public void testHtml5EscapeEveryCodepointToItsPreferredNcr() throws Exception {
        checkEveryCodepointEscapesToItsPreferredNcr(
                HtmlEscapeSymbols.HTML5_SYMBOLS, HtmlEscapeType.HTML5_NAMED_REFERENCES_DEFAULT_TO_DECIMAL, true);
    }

    @Test
    public void testHtml5UnescapeEveryNcrToExactCodepoints() throws Exception {
        checkEveryNcrUnescapesToExactCodepoints(HtmlEscapeSymbols.HTML5_SYMBOLS);
    }


    /*
     * Asserts that the HTML5 table actually CONTAINS every edge-case category these tests rely on (so none of
     * the exhaustive walks above can pass vacuously), and that the direct-indexed / overflow partition is sound.
     */
    @Test
    public void testHtml5ContainsEveryEdgeCaseCategoryAndIsPartitioned() {

        final HtmlEscapeSymbols s = HtmlEscapeSymbols.HTML5_SYMBOLS;

        int noSemicolon = 0;
        int doubleCodepoint = 0;
        for (int i = 0; i < s.SORTED_NCRS.length; i++) {
            final char[] ncr = s.SORTED_NCRS[i];
            if (ncr[ncr.length - 1] != ';') {
                noSemicolon++;
            }
            if (s.SORTED_CODEPOINTS[i] < 0) {
                doubleCodepoint++;
            }
        }
        Assertions.assertTrue(noSemicolon > 0, "Expected some no-semicolon (legacy) NCRs");
        Assertions.assertTrue(doubleCodepoint > 0, "Expected some double-codepoint NCRs");

        // DOUBLE_CODEPOINTS must hold exactly one entry per negative SORTED_CODEPOINTS value.
        Assertions.assertNotNull(s.DOUBLE_CODEPOINTS);
        Assertions.assertEquals(doubleCodepoint, s.DOUBLE_CODEPOINTS.length);

        // Overflow must exist and must contain BOTH a BMP (<= 0xFFFF) and a supplementary (> 0xFFFF) codepoint.
        Assertions.assertNotNull(s.NCRS_BY_CODEPOINT_OVERFLOW);
        boolean overflowBmp = false;
        boolean overflowSupplementary = false;
        for (final Map.Entry<Integer,Short> entry : s.NCRS_BY_CODEPOINT_OVERFLOW.entrySet()) {
            final int cp = entry.getKey().intValue();
            // Partition invariant: overflow codepoints are always >= NCRS_BY_CODEPOINT_LEN.
            Assertions.assertTrue(cp >= HtmlEscapeSymbols.NCRS_BY_CODEPOINT_LEN,
                    "Overflow codepoint U+" + Integer.toHexString(cp) + " should not be in the overflow map");
            if (cp > 0xFFFF) {
                overflowSupplementary = true;
            } else {
                overflowBmp = true;
            }
        }
        Assertions.assertTrue(overflowBmp, "Expected a BMP codepoint in the overflow map");
        Assertions.assertTrue(overflowSupplementary, "Expected a supplementary-plane codepoint in the overflow map");

        // At least one codepoint must be referenced by more than one NCR (escape "first specified wins").
        Assertions.assertTrue(countCodepointsWithMultipleNcrs(s) > 0, "Expected codepoints with several NCRs");
    }


    /*
     * HTML4's highest codepoint is below the overflow threshold and it has no double-codepoint NCRs, so both
     * the overflow map and the DOUBLE_CODEPOINTS array must be absent, and no codepoint may be negative.
     */
    @Test
    public void testHtml4HasNoOverflowNorDoubleCodepoints() {
        final HtmlEscapeSymbols s = HtmlEscapeSymbols.HTML4_SYMBOLS;
        Assertions.assertNull(s.NCRS_BY_CODEPOINT_OVERFLOW);
        Assertions.assertNull(s.DOUBLE_CODEPOINTS);
        for (int i = 0; i < s.SORTED_CODEPOINTS.length; i++) {
            Assertions.assertTrue(s.SORTED_CODEPOINTS[i] >= 0,
                    "HTML4 must not contain double-codepoint (negative) entries");
            Assertions.assertTrue(s.SORTED_CODEPOINTS[i] < HtmlEscapeSymbols.NCRS_BY_CODEPOINT_LEN,
                    "HTML4 codepoints are all expected below the overflow threshold");
        }
    }


    /*
     * Independent, hard-coded ground-truth verification of the trickiest categories.
     */
    @Test
    public void testHtml5KnownNcrsUnescapeToGroundTruth() {
        for (final String[] entry : HTML5_GROUND_TRUTH) {
            Assertions.assertEquals(entry[1], HtmlEscape.unescapeHtml(entry[0]),
                    "Bad unescape for NCR: " + entry[0]);
        }
    }


    /*
     * Double-codepoint NCRs exist only for unescaping: they must never be selected to escape a codepoint
     * sequence. Verified both structurally (no escape entry points at a negative-codepoint NCR) and
     * behaviourally (escaping the two-codepoint sequence does not reproduce the single NCR, and round-trips).
     */
    @Test
    public void testHtml5DoubleCodepointNcrsAreNeverUsedForEscaping() throws Exception {

        final HtmlEscapeSymbols s = HtmlEscapeSymbols.HTML5_SYMBOLS;

        final Set<Integer> escapeNcrIndexes = new HashSet<Integer>();
        for (int cp = 0; cp < HtmlEscapeSymbols.NCRS_BY_CODEPOINT_LEN; cp++) {
            if (s.NCRS_BY_CODEPOINT[cp] != HtmlEscapeSymbols.NO_NCR) {
                escapeNcrIndexes.add(Integer.valueOf(s.NCRS_BY_CODEPOINT[cp]));
            }
        }
        for (final Map.Entry<Integer,Short> entry : s.NCRS_BY_CODEPOINT_OVERFLOW.entrySet()) {
            escapeNcrIndexes.add(Integer.valueOf(entry.getValue().shortValue()));
        }
        for (final Integer idx : escapeNcrIndexes) {
            Assertions.assertTrue(s.SORTED_CODEPOINTS[idx.intValue()] >= 0,
                    "A double-codepoint NCR is wrongly referenced from the escape tables");
        }

        // Behavioural: "fj" and U+2242 U+0338 must not escape to their double NCR, and must round-trip.
        assertNotEscapedToDoubleNcr("fj", "&fjlig;");
        assertNotEscapedToDoubleNcr("\u2242\u0338", "&NotEqualTilde;");
    }


    private void assertNotEscapedToDoubleNcr(final String sequence, final String doubleNcr) throws Exception {
        final String escaped = HtmlEscape.escapeHtml(
                sequence, HtmlEscapeType.HTML5_NAMED_REFERENCES_DEFAULT_TO_DECIMAL,
                HtmlEscapeLevel.LEVEL_4_ALL_CHARACTERS);
        Assertions.assertNotEquals(doubleNcr, escaped);
        Assertions.assertEquals(sequence, HtmlEscape.unescapeHtml(escaped));
    }


    private static int countCodepointsWithMultipleNcrs(final HtmlEscapeSymbols s) {
        final java.util.Map<Integer,Integer> counts = new java.util.HashMap<Integer,Integer>();
        for (int i = 0; i < s.SORTED_CODEPOINTS.length; i++) {
            final int cp = s.SORTED_CODEPOINTS[i];
            if (cp >= 0) {
                final Integer c = counts.get(Integer.valueOf(cp));
                counts.put(Integer.valueOf(cp), Integer.valueOf(c == null ? 1 : c.intValue() + 1));
            }
        }
        int multi = 0;
        for (final Integer c : counts.values()) {
            if (c.intValue() > 1) {
                multi++;
            }
        }
        return multi;
    }


    /*
     * Structural invariant of the escape lookup: every codepoint that points (through NCRS_BY_CODEPOINT or the
     * overflow map) to a preferred NCR must point to an NCR whose own recorded codepoint (in SORTED_CODEPOINTS)
     * is that very codepoint. Validates the codepoint <-> sorted-array wiring for BOTH tables without depending
     * on the HTML5-canonical unescaper.
     */
    private static void checkEscapeTableConsistency(final HtmlEscapeSymbols symbols) {

        Assertions.assertEquals(symbols.SORTED_NCRS.length, symbols.SORTED_CODEPOINTS.length);
        Assertions.assertTrue(symbols.SORTED_NCRS.length > 0);

        int checked = 0;

        for (int cp = 0; cp < HtmlEscapeSymbols.NCRS_BY_CODEPOINT_LEN; cp++) {
            final short idx = symbols.NCRS_BY_CODEPOINT[cp];
            if (idx != HtmlEscapeSymbols.NO_NCR) {
                Assertions.assertEquals(
                        cp, symbols.SORTED_CODEPOINTS[idx],
                        "Escape entry for U+" + Integer.toHexString(cp) + " points to a mismatched codepoint");
                checked++;
            }
        }

        if (symbols.NCRS_BY_CODEPOINT_OVERFLOW != null) {
            for (final Map.Entry<Integer,Short> entry : symbols.NCRS_BY_CODEPOINT_OVERFLOW.entrySet()) {
                final int cp = entry.getKey().intValue();
                final short idx = entry.getValue().shortValue();
                Assertions.assertEquals(
                        cp, symbols.SORTED_CODEPOINTS[idx],
                        "Overflow escape entry for U+" + Integer.toHexString(cp) + " points to a mismatched codepoint");
                checked++;
            }
        }

        Assertions.assertTrue(checked > 0);
    }


    /*
     * Walks the whole SORTED_NCRS / SORTED_CODEPOINTS pair (which includes every NCR, even the legacy ones
     * without a trailing ';' and the double-codepoint, unescape-only ones) and verifies each NCR unescapes to
     * EXACTLY the codepoint(s) the structure says it should -- resolving negative codepoints through
     * DOUBLE_CODEPOINTS exactly as the unescape engine does. Also asserts that the legacy and double-codepoint
     * categories were actually exercised.
     */
    private static void checkEveryNcrUnescapesToExactCodepoints(final HtmlEscapeSymbols symbols) {

        final char[][] sortedNcrs = symbols.SORTED_NCRS;
        final int[] sortedCodepoints = symbols.SORTED_CODEPOINTS;

        Assertions.assertEquals(sortedNcrs.length, sortedCodepoints.length);
        Assertions.assertTrue(sortedNcrs.length > 0);

        int noSemicolonSeen = 0;
        int doubleSeen = 0;

        for (int i = 0; i < sortedNcrs.length; i++) {

            final String ncr = new String(sortedNcrs[i]);
            final int cp = sortedCodepoints[i];

            if (sortedNcrs[i][sortedNcrs[i].length - 1] != ';') {
                noSemicolonSeen++;
            }

            final String expected;
            if (cp >= 0) {
                expected = new String(Character.toChars(cp));
            } else {
                // Negative codepoint -> a two-codepoint sequence, resolved through DOUBLE_CODEPOINTS exactly
                // as HtmlEscapeUtil does: index = ((-1) * cp) - 1.
                final int[] doubleCodepoints = symbols.DOUBLE_CODEPOINTS[((-1) * cp) - 1];
                expected = new String(Character.toChars(doubleCodepoints[0]))
                        + new String(Character.toChars(doubleCodepoints[1]));
                doubleSeen++;
            }

            Assertions.assertEquals(expected, HtmlEscape.unescapeHtml(ncr), "Bad unescape for NCR: " + ncr);
        }

        Assertions.assertTrue(noSemicolonSeen > 0, "No legacy (no-semicolon) NCRs were exercised");
        Assertions.assertTrue(doubleSeen > 0, "No double-codepoint NCRs were exercised");
    }


    /*
     * Walks every codepoint that has a 'preferred' NCR for escaping -- both the ones held in the direct-indexed
     * NCRS_BY_CODEPOINT array and the ones held in the NCRS_BY_CODEPOINT_OVERFLOW map -- and verifies that
     * escaping that codepoint (forcing escape of all chars, with a named-reference type) produces EXACTLY the
     * preferred NCR the structure points to. When 'alsoRoundTrip' is set, the result is unescaped back and must
     * yield the original codepoint (only valid for the HTML5 table, see class javadoc).
     */
    private static void checkEveryCodepointEscapesToItsPreferredNcr(
            final HtmlEscapeSymbols symbols, final HtmlEscapeType namedType, final boolean alsoRoundTrip)
            throws Exception {

        final HtmlEscapeLevel allChars = HtmlEscapeLevel.LEVEL_4_ALL_CHARACTERS;

        int checked = 0;
        int supplementaryChecked = 0;

        for (int cp = 0; cp < HtmlEscapeSymbols.NCRS_BY_CODEPOINT_LEN; cp++) {
            final short ncrIndex = symbols.NCRS_BY_CODEPOINT[cp];
            if (ncrIndex != HtmlEscapeSymbols.NO_NCR) {
                checkCodepointEscapesTo(symbols, namedType, allChars, cp, ncrIndex, alsoRoundTrip);
                checked++;
            }
        }

        if (symbols.NCRS_BY_CODEPOINT_OVERFLOW != null) {
            for (final Map.Entry<Integer,Short> entry : symbols.NCRS_BY_CODEPOINT_OVERFLOW.entrySet()) {
                final int cp = entry.getKey().intValue();
                checkCodepointEscapesTo(symbols, namedType, allChars, cp, entry.getValue().shortValue(), alsoRoundTrip);
                checked++;
                if (cp > 0xFFFF) {
                    supplementaryChecked++;
                }
            }
        }

        Assertions.assertTrue(checked > 0);
        if (symbols.NCRS_BY_CODEPOINT_OVERFLOW != null) {
            Assertions.assertTrue(supplementaryChecked > 0, "No supplementary-plane codepoints were escaped");
        }
    }


    private static void checkCodepointEscapesTo(
            final HtmlEscapeSymbols symbols, final HtmlEscapeType namedType, final HtmlEscapeLevel level,
            final int codepoint, final short ncrIndex, final boolean alsoRoundTrip) throws Exception {

        final String preferredNcr = new String(symbols.SORTED_NCRS[ncrIndex]);
        final String codepointStr = new String(Character.toChars(codepoint));

        final String escaped = HtmlEscape.escapeHtml(codepointStr, namedType, level);
        Assertions.assertEquals(
                preferredNcr, escaped,
                "Codepoint U+" + Integer.toHexString(codepoint) + " did not escape to its preferred NCR");

        if (alsoRoundTrip) {
            Assertions.assertEquals(
                    codepointStr, HtmlEscape.unescapeHtml(escaped),
                    "Round-trip failed for codepoint U+" + Integer.toHexString(codepoint));
        }
    }


    public HtmlEscapeSymbolsCoverageTest() {
        super();
    }


}
