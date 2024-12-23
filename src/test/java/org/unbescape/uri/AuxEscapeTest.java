/*
 * =============================================================================
 * 
 *   Copyright (c) 2014-2025 Unbescape (http://www.unbescape.org)
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
package org.unbescape.uri;

import java.net.URLDecoder;
import java.net.URLEncoder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.1
 *
 */
public class AuxEscapeTest {




    @Test
    public void testHexa() throws Exception {

        {
            final String uhexaFF =
                    "000102030405060708090A0B0C0D0E0F101112131415161718191A1B1C1D1E1F202122232425262728292A2B2C2D2E2F303132333435363738393A3B3C3D3E3F404142434445464748494A4B4C4D4E4F505152535455565758595A5B5C5D5E5F606162636465666768696A6B6C6D6E6F707172737475767778797A7B7C7D7E7F808182838485868788898A8B8C8D8E8F909192939495969798999A9B9C9D9E9FA0A1A2A3A4A5A6A7A8A9AAABACADAEAFB0B1B2B3B4B5B6B7B8B9BABBBCBDBEBFC0C1C2C3C4C5C6C7C8C9CACBCCCDCECFD0D1D2D3D4D5D6D7D8D9DADBDCDDDEDFE0E1E2E3E4E5E6E7E8E9EAEBECEDEEEFF0F1F2F3F4F5F6F7F8F9FAFBFCFDFEFF";

            final StringBuilder strBuilder = new StringBuilder();
            for (int i = 0; i <= 0xFF; i++) {
                strBuilder.append(UriEscapeUtil.printHexa((byte)i));
            }

            final String result = strBuilder.toString();
            Assertions.assertEquals(uhexaFF, result);
        }

        {

            for (int codepoint = 0; codepoint <= 0x10FFFF; codepoint++) {
                if (UriEscapeUtil.UriEscapeType.QUERY_PARAM.isAllowed(codepoint)) {
                    continue;
                }
                if (codepoint == ' ') {
                    // URI/URLs should escape whitespace as '%20'
                    // Form data (application/x-www-form-urlencoded) escape whitespace as '+'
                    // Java's URLEncoder uses '+', even if it is used for URLs and not form data,
                    // so we just avoid the test in this case
                    continue;
                }
                if (Character.isHighSurrogate((char)codepoint) || Character.isLowSurrogate((char)codepoint)) {
                    // These would never appear as separate codepoints
                    continue;
                }
                final StringBuilder strBuilder = new StringBuilder();
                final String original = new String(Character.toChars(codepoint));
                final byte[] bb = original.getBytes("UTF-8");
                for (final byte b : bb) {
                    strBuilder.append('%');
                    strBuilder.append(UriEscapeUtil.printHexa(b));
                }
                final String result = strBuilder.toString();
                final String encoded = URLEncoder.encode(new String(Character.toChars(codepoint)), "UTF-8");
                final String decoded = URLDecoder.decode(result, "UTF-8");
                Assertions.assertEquals(
                        encoded, result,
                        "Error testing encoded version of codepoint: " + Integer.toHexString(codepoint) + " [" + original + "|" + result + "|" + encoded + "|" + decoded + "]");
                Assertions.assertEquals(
                        original, decoded,
                        "Error testing decoded version of codepoint: " + Integer.toHexString(codepoint) + " [" + original + "|" + result + "|" + encoded + "|" + decoded + "]");



                byte[] bytes = new byte[result.length()/3];
                for (int i = 0; i < result.length(); i += 3) {
                    final char c1 = result.charAt(i + 1);
                    final char c2 = result.charAt(i + 2);
                    bytes[i / 3] = UriEscapeUtil.parseHexa(c1, c2);
                }
                String parseResult = new String(bytes, "UTF-8");

                Assertions.assertEquals(
                        original, parseResult,
                        "Error testing decoded version of codepoint: " + Integer.toHexString(codepoint) + " [" + original + "|" + result + "|" + parseResult + "|" + encoded + "|" + decoded + "]");


                bytes = new byte[result.length()/3];
                for (int i = 0; i < result.length(); i += 3) {
                    final char c1 = result.toLowerCase().charAt(i + 1);
                    final char c2 = result.toLowerCase().charAt(i + 2);
                    bytes[i / 3] = UriEscapeUtil.parseHexa(c1, c2);
                }
                parseResult = new String(bytes, "UTF-8");

                Assertions.assertEquals(
                        original, parseResult,
                        "Error testing decoded version of codepoint: " + Integer.toHexString(codepoint) + " [" + original + "|" + result + "|" + parseResult + "|" + encoded + "|" + decoded + "]");

            }

        }

    }




    public AuxEscapeTest() {
        super();
    }


}

