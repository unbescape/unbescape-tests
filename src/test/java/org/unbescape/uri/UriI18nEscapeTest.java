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
package org.unbescape.uri;

import org.junit.Test;

import static org.unbescape.uri.UriEscapeTestUtil.testEscapeFragmentId;
import static org.unbescape.uri.UriEscapeTestUtil.testEscapePath;
import static org.unbescape.uri.UriEscapeTestUtil.testEscapePathSegment;
import static org.unbescape.uri.UriEscapeTestUtil.testEscapeQueryParam;
import static org.unbescape.uri.UriEscapeTestUtil.testUnescapeFragmentId;
import static org.unbescape.uri.UriEscapeTestUtil.testUnescapePath;
import static org.unbescape.uri.UriEscapeTestUtil.testUnescapePathSegment;
import static org.unbescape.uri.UriEscapeTestUtil.testUnescapeQueryParam;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.0
 *
 */
public class UriI18nEscapeTest {



    private static final String TEXT =
            "Jako efektivn\u0115j\u0161\u00ED se n\u00E1m jev\u00ED po\u0159\u00E1d\u00E1n\u00ED tzv.\n" +
            "Gira prost\u0159ednictv\u00EDm na\u0161ich autorizovan\u00FDch dealer\u016F v " +
            "\u010Cech\u00E1ch a na Morav\u011B, kter\u00E9 prob\u011Bhnou v pr\u016Fb\u011Bhu " +
            "z\u00E1\u0159\u00ED a \u0159\u00EDjna.";





    @Test
    public void testPath() throws Exception {

        final String textPath =
                "Jako%20efektivn%C4%95j%C5%A1%C3%AD%20se%20n%C3%A1m%20jev%C3%AD%20po%C5%99%C3%A1d%C3%A1n%C3%AD%20tzv." +
                "%0AGira%20prost%C5%99ednictv%C3%ADm%20na%C5%A1ich%20autorizovan%C3%BDch%20dealer%C5%AF%20v" +
                "%20%C4%8Cech%C3%A1ch%20a%20na%20Morav%C4%9B,%20kter%C3%A9%20prob%C4%9Bhnou%20v%20pr%C5%AFb%C4%9B" +
                "hu%20z%C3%A1%C5%99%C3%AD%20a%20%C5%99%C3%ADjna.";

        testEscapePath(TEXT, textPath);
        testUnescapePath(textPath, TEXT);

    }



    @Test
    public void testPathSegment() throws Exception {

        final String textPathSegment =
                "Jako%20efektivn%C4%95j%C5%A1%C3%AD%20se%20n%C3%A1m%20jev%C3%AD%20po%C5%99%C3%A1d%C3%A1n%C3%AD%20tzv." +
                "%0AGira%20prost%C5%99ednictv%C3%ADm%20na%C5%A1ich%20autorizovan%C3%BDch%20dealer%C5%AF%20v" +
                "%20%C4%8Cech%C3%A1ch%20a%20na%20Morav%C4%9B,%20kter%C3%A9%20prob%C4%9Bhnou%20v%20pr%C5%AFb%C4%9B" +
                "hu%20z%C3%A1%C5%99%C3%AD%20a%20%C5%99%C3%ADjna.";

        testEscapePathSegment(TEXT, textPathSegment);
        testUnescapePathSegment(textPathSegment, TEXT);

    }



    @Test
    public void testPathQueryParam() throws Exception {

        final String textQueryParam =
                "Jako%20efektivn%C4%95j%C5%A1%C3%AD%20se%20n%C3%A1m%20jev%C3%AD%20po%C5%99%C3%A1d%C3%A1n%C3%AD%20tzv." +
                "%0AGira%20prost%C5%99ednictv%C3%ADm%20na%C5%A1ich%20autorizovan%C3%BDch%20dealer%C5%AF%20v" +
                "%20%C4%8Cech%C3%A1ch%20a%20na%20Morav%C4%9B,%20kter%C3%A9%20prob%C4%9Bhnou%20v%20pr%C5%AFb%C4%9B" +
                "hu%20z%C3%A1%C5%99%C3%AD%20a%20%C5%99%C3%ADjna.";

        testEscapeQueryParam(TEXT, textQueryParam);
        testUnescapeQueryParam(textQueryParam, TEXT);

    }




    @Test
    public void testPathFragmentId() throws Exception {

        final String textFragmentId =
                "Jako%20efektivn%C4%95j%C5%A1%C3%AD%20se%20n%C3%A1m%20jev%C3%AD%20po%C5%99%C3%A1d%C3%A1n%C3%AD%20tzv." +
                "%0AGira%20prost%C5%99ednictv%C3%ADm%20na%C5%A1ich%20autorizovan%C3%BDch%20dealer%C5%AF%20v" +
                "%20%C4%8Cech%C3%A1ch%20a%20na%20Morav%C4%9B,%20kter%C3%A9%20prob%C4%9Bhnou%20v%20pr%C5%AFb%C4%9B" +
                "hu%20z%C3%A1%C5%99%C3%AD%20a%20%C5%99%C3%ADjna.";

        testEscapeFragmentId(TEXT, textFragmentId);
        testUnescapeFragmentId(textFragmentId, TEXT);

    }






    public UriI18nEscapeTest() {
        super();
    }


}

