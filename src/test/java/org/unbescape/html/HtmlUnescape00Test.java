/*
 * =============================================================================
 * 
 *   Copyright (c) 2014, The UNBESCAPE team (http://www.unbescape.org)
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

import java.io.IOException;
import java.io.StringWriter;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.0
 *
 */
public class HtmlUnescape00Test {


    @Test
    public void testHtml5() throws Exception {
        final HtmlEscapeSymbols symbols = HtmlEscapeSymbols.HTML5_SYMBOLS;
        final char[][] sortedNCRs = symbols.SORTED_NCRS;
        for (final char[] ncr : sortedNCRs) {
            checkNCR(ncr);
        }
    }


    @Test
    public void testHtml4() throws Exception {
        final HtmlEscapeSymbols symbols = HtmlEscapeSymbols.HTML4_SYMBOLS;
        final char[][] sortedNCRs = symbols.SORTED_NCRS;
        for (final char[] ncr : sortedNCRs) {
            checkNCR(ncr);
        }
    }



    private static void checkNCR(final char[] ncr) throws IOException {
        checkNCRString(new String(ncr));
        checkNCRChar(ncr);
    }


    private static void checkNCRString(final String ncr) {

        Assert.assertFalse("Not being unescaped: " + ncr, ncr.equals(HtmlEscape.unescapeHtml(ncr)));

        final String unescapedLettersLow = "aeiou" + HtmlEscape.unescapeHtml(ncr) + "aeiou";

        final StringBuilder strBuilderEscapedLettersLow = new StringBuilder();
        strBuilderEscapedLettersLow.append("aeiou");
        strBuilderEscapedLettersLow.append(ncr);
        strBuilderEscapedLettersLow.append("aeiou");

        final String resultLettersLow = HtmlEscape.unescapeHtml(strBuilderEscapedLettersLow.toString());

        Assert.assertEquals(unescapedLettersLow, resultLettersLow);

        final String unescapedLettersUp = "AEIOU" + HtmlEscape.unescapeHtml(ncr) + "AEIOU";

        final StringBuilder strBuilderEscapedLettersUp = new StringBuilder();
        strBuilderEscapedLettersUp.append("AEIOU");
        strBuilderEscapedLettersUp.append(ncr);
        strBuilderEscapedLettersUp.append("AEIOU");

        final String resultLettersUp = HtmlEscape.unescapeHtml(strBuilderEscapedLettersUp.toString());

        Assert.assertEquals(unescapedLettersUp, resultLettersUp);

        final String unescapedLettersNum = "01234" + HtmlEscape.unescapeHtml(ncr) + "01234";

        final StringBuilder strBuilderEscapedLettersNum = new StringBuilder();
        strBuilderEscapedLettersNum.append("01234");
        strBuilderEscapedLettersNum.append(ncr);
        strBuilderEscapedLettersNum.append("01234");

        final String resultLettersNum = HtmlEscape.unescapeHtml(strBuilderEscapedLettersNum.toString());

        Assert.assertEquals(unescapedLettersNum, resultLettersNum);

    }


    private static void checkNCRChar(final char[] ncr) throws IOException {

        final String ncrStr = new String(ncr);
        final StringWriter ncrWriter = new StringWriter();
        HtmlEscape.unescapeHtml(ncr, 0, ncr.length, ncrWriter);
        Assert.assertFalse("Not being unescaped: " + ncrStr, ncrStr.equals(ncrWriter.toString()));

        final StringWriter writerLow = new StringWriter();
        HtmlEscape.unescapeHtml(ncr, 0, ncr.length, writerLow);
        final String unescapedLettersLow = "aeiou" + writerLow.toString() + "aeiou";

        final StringBuilder strBuilderEscapedLettersLow = new StringBuilder();
        strBuilderEscapedLettersLow.append("aeiou");
        strBuilderEscapedLettersLow.append(ncr);
        strBuilderEscapedLettersLow.append("aeiou");
        final String escapedLettersLow = strBuilderEscapedLettersLow.toString();

        final StringWriter writerResultLow = new StringWriter();
        HtmlEscape.unescapeHtml(escapedLettersLow.toCharArray(), 0, escapedLettersLow.length(), writerResultLow);

        Assert.assertEquals(unescapedLettersLow, writerResultLow.toString());

        final StringWriter writerUp = new StringWriter();
        HtmlEscape.unescapeHtml(ncr, 0, ncr.length, writerUp);
        final String unescapedLettersUp = "AEIOU" + writerUp.toString() + "AEIOU";

        final StringBuilder strBuilderEscapedLettersUp = new StringBuilder();
        strBuilderEscapedLettersUp.append("AEIOU");
        strBuilderEscapedLettersUp.append(ncr);
        strBuilderEscapedLettersUp.append("AEIOU");
        final String escapedLettersUp = strBuilderEscapedLettersUp.toString();

        final StringWriter writerResultUp = new StringWriter();
        HtmlEscape.unescapeHtml(escapedLettersUp.toCharArray(), 0, escapedLettersUp.length(), writerResultUp);

        Assert.assertEquals(unescapedLettersUp, writerResultUp.toString());

        final StringWriter writerNum = new StringWriter();
        HtmlEscape.unescapeHtml(ncr, 0, ncr.length, writerNum);
        final String unescapedLettersNum = "01234" + writerNum.toString() + "01234";

        final StringBuilder strBuilderEscapedLettersNum = new StringBuilder();
        strBuilderEscapedLettersNum.append("01234");
        strBuilderEscapedLettersNum.append(ncr);
        strBuilderEscapedLettersNum.append("01234");
        final String escapedLettersNum = strBuilderEscapedLettersNum.toString();

        final StringWriter writerResultNum = new StringWriter();
        HtmlEscape.unescapeHtml(escapedLettersNum.toCharArray(), 0, escapedLettersNum.length(), writerResultNum);

        Assert.assertEquals(unescapedLettersNum, writerResultNum.toString());

    }


    public HtmlUnescape00Test() {
        super();
    }


}

