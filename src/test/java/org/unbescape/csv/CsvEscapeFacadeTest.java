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
package org.unbescape.csv;

import org.junit.jupiter.api.Test;
import org.unbescape.FacadeTestUtil;

import static org.unbescape.FacadeTestUtil.COMMON_TEXTS;
import static org.unbescape.FacadeTestUtil.check;

/**
 * <p>
 *   Tests for the public {@link CsvEscape} facade: every method must behave like the escape utility in all of its
 *   variants, and honour the documented argument contract.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class CsvEscapeFacadeTest {


    private static final String[] TEXTS = COMMON_TEXTS;




    @Test
    public void testEscapeCsv() throws Exception {
        check("escapeCsv", TEXTS,
                CsvEscapeUtil::escape,
                CsvEscape::escapeCsv, CsvEscape::escapeCsv, CsvEscape::escapeCsv, CsvEscape::escapeCsv);
    }


    @Test
    public void testUnescapeCsv() throws Exception {
        check("unescapeCsv", FacadeTestUtil.unescapeTexts(TEXTS, FacadeTestUtil.operations(CsvEscapeUtil::escape)),
                CsvEscapeUtil::unescape,
                CsvEscape::unescapeCsv, CsvEscape::unescapeCsv, CsvEscape::unescapeCsv, CsvEscape::unescapeCsv);
    }




    public CsvEscapeFacadeTest() {
        super();
    }


}
