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
package org.unbescape.uri;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.unbescape.FacadeTestUtil;
import org.unbescape.FacadeTestUtil.StringOperation;
import org.unbescape.uri.UriEscapeUtil.UriEscapeType;

import static org.unbescape.FacadeTestUtil.COMMON_TEXTS;
import static org.unbescape.FacadeTestUtil.check;
import static org.unbescape.FacadeTestUtil.checkRejected;

/**
 * <p>
 *   Tests for the public {@link UriEscape} facade: every method must apply the URI part (path, path segment,
 *   query parameter or fragment identifier) and the encoding its documentation states (UTF-8 by default), in all
 *   of its variants, and honour the documented argument contract.
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.1.7
 *
 */
public class UriEscapeFacadeTest {


    private static final String[] TEXTS = COMMON_TEXTS;

    private static final String UTF8 = "UTF-8";
    private static final String[] ENCODINGS = { "UTF-8", "ISO-8859-1" };




    @Test
    public void testDefaultEncoding() {
        Assertions.assertEquals("UTF-8", UriEscape.DEFAULT_ENCODING);
    }


    @Test
    public void testEscapeUriPath() throws Exception {
        check("escapeUriPath", TEXTS,
                t -> UriEscapeUtil.escape(t, UriEscapeType.PATH, UTF8),
                UriEscape::escapeUriPath, (t, w) -> UriEscape.escapeUriPath(t, w), UriEscape::escapeUriPath,
                UriEscape::escapeUriPath);
        for (final String encoding : ENCODINGS) {
            check("escapeUriPath(" + encoding + ")", TEXTS,
                    t -> UriEscapeUtil.escape(t, UriEscapeType.PATH, encoding),
                    t -> UriEscape.escapeUriPath(t, encoding),
                    (t, w) -> UriEscape.escapeUriPath(t, w, encoding),
                    (r, w) -> UriEscape.escapeUriPath(r, w, encoding),
                    (t, o, l, w) -> UriEscape.escapeUriPath(t, o, l, w, encoding));
        }
        checkRejected("escapeUriPath(null encoding)",
                t -> UriEscape.escapeUriPath(t, (String) null),
                (t, w) -> UriEscape.escapeUriPath(t, w, null),
                (r, w) -> UriEscape.escapeUriPath(r, w, null),
                (t, o, l, w) -> UriEscape.escapeUriPath(t, o, l, w, null));
    }


    @Test
    public void testEscapeUriPathSegment() throws Exception {
        check("escapeUriPathSegment", TEXTS,
                t -> UriEscapeUtil.escape(t, UriEscapeType.PATH_SEGMENT, UTF8),
                UriEscape::escapeUriPathSegment, (t, w) -> UriEscape.escapeUriPathSegment(t, w), UriEscape::escapeUriPathSegment,
                UriEscape::escapeUriPathSegment);
        for (final String encoding : ENCODINGS) {
            check("escapeUriPathSegment(" + encoding + ")", TEXTS,
                    t -> UriEscapeUtil.escape(t, UriEscapeType.PATH_SEGMENT, encoding),
                    t -> UriEscape.escapeUriPathSegment(t, encoding),
                    (t, w) -> UriEscape.escapeUriPathSegment(t, w, encoding),
                    (r, w) -> UriEscape.escapeUriPathSegment(r, w, encoding),
                    (t, o, l, w) -> UriEscape.escapeUriPathSegment(t, o, l, w, encoding));
        }
        checkRejected("escapeUriPathSegment(null encoding)",
                t -> UriEscape.escapeUriPathSegment(t, (String) null),
                (t, w) -> UriEscape.escapeUriPathSegment(t, w, null),
                (r, w) -> UriEscape.escapeUriPathSegment(r, w, null),
                (t, o, l, w) -> UriEscape.escapeUriPathSegment(t, o, l, w, null));
    }


    @Test
    public void testEscapeUriQueryParam() throws Exception {
        check("escapeUriQueryParam", TEXTS,
                t -> UriEscapeUtil.escape(t, UriEscapeType.QUERY_PARAM, UTF8),
                UriEscape::escapeUriQueryParam, (t, w) -> UriEscape.escapeUriQueryParam(t, w), UriEscape::escapeUriQueryParam,
                UriEscape::escapeUriQueryParam);
        for (final String encoding : ENCODINGS) {
            check("escapeUriQueryParam(" + encoding + ")", TEXTS,
                    t -> UriEscapeUtil.escape(t, UriEscapeType.QUERY_PARAM, encoding),
                    t -> UriEscape.escapeUriQueryParam(t, encoding),
                    (t, w) -> UriEscape.escapeUriQueryParam(t, w, encoding),
                    (r, w) -> UriEscape.escapeUriQueryParam(r, w, encoding),
                    (t, o, l, w) -> UriEscape.escapeUriQueryParam(t, o, l, w, encoding));
        }
        checkRejected("escapeUriQueryParam(null encoding)",
                t -> UriEscape.escapeUriQueryParam(t, (String) null),
                (t, w) -> UriEscape.escapeUriQueryParam(t, w, null),
                (r, w) -> UriEscape.escapeUriQueryParam(r, w, null),
                (t, o, l, w) -> UriEscape.escapeUriQueryParam(t, o, l, w, null));
    }


    @Test
    public void testEscapeUriFragmentId() throws Exception {
        check("escapeUriFragmentId", TEXTS,
                t -> UriEscapeUtil.escape(t, UriEscapeType.FRAGMENT_ID, UTF8),
                UriEscape::escapeUriFragmentId, (t, w) -> UriEscape.escapeUriFragmentId(t, w), UriEscape::escapeUriFragmentId,
                UriEscape::escapeUriFragmentId);
        for (final String encoding : ENCODINGS) {
            check("escapeUriFragmentId(" + encoding + ")", TEXTS,
                    t -> UriEscapeUtil.escape(t, UriEscapeType.FRAGMENT_ID, encoding),
                    t -> UriEscape.escapeUriFragmentId(t, encoding),
                    (t, w) -> UriEscape.escapeUriFragmentId(t, w, encoding),
                    (r, w) -> UriEscape.escapeUriFragmentId(r, w, encoding),
                    (t, o, l, w) -> UriEscape.escapeUriFragmentId(t, o, l, w, encoding));
        }
        checkRejected("escapeUriFragmentId(null encoding)",
                t -> UriEscape.escapeUriFragmentId(t, (String) null),
                (t, w) -> UriEscape.escapeUriFragmentId(t, w, null),
                (r, w) -> UriEscape.escapeUriFragmentId(r, w, null),
                (t, o, l, w) -> UriEscape.escapeUriFragmentId(t, o, l, w, null));
    }


    @Test
    public void testUnescapeUriPath() throws Exception {
        final String[] texts = unescapeTexts();
        check("unescapeUriPath", texts,
                t -> UriEscapeUtil.unescape(t, UriEscapeType.PATH, UTF8),
                UriEscape::unescapeUriPath, (t, w) -> UriEscape.unescapeUriPath(t, w), UriEscape::unescapeUriPath,
                UriEscape::unescapeUriPath);
        for (final String encoding : ENCODINGS) {
            check("unescapeUriPath(" + encoding + ")", texts,
                    t -> UriEscapeUtil.unescape(t, UriEscapeType.PATH, encoding),
                    t -> UriEscape.unescapeUriPath(t, encoding),
                    (t, w) -> UriEscape.unescapeUriPath(t, w, encoding),
                    (r, w) -> UriEscape.unescapeUriPath(r, w, encoding),
                    (t, o, l, w) -> UriEscape.unescapeUriPath(t, o, l, w, encoding));
        }
        checkRejected("unescapeUriPath(null encoding)",
                t -> UriEscape.unescapeUriPath(t, (String) null),
                (t, w) -> UriEscape.unescapeUriPath(t, w, null),
                (r, w) -> UriEscape.unescapeUriPath(r, w, null),
                (t, o, l, w) -> UriEscape.unescapeUriPath(t, o, l, w, null));
    }


    @Test
    public void testUnescapeUriPathSegment() throws Exception {
        final String[] texts = unescapeTexts();
        check("unescapeUriPathSegment", texts,
                t -> UriEscapeUtil.unescape(t, UriEscapeType.PATH_SEGMENT, UTF8),
                UriEscape::unescapeUriPathSegment, (t, w) -> UriEscape.unescapeUriPathSegment(t, w),
                UriEscape::unescapeUriPathSegment, UriEscape::unescapeUriPathSegment);
        for (final String encoding : ENCODINGS) {
            check("unescapeUriPathSegment(" + encoding + ")", texts,
                    t -> UriEscapeUtil.unescape(t, UriEscapeType.PATH_SEGMENT, encoding),
                    t -> UriEscape.unescapeUriPathSegment(t, encoding),
                    (t, w) -> UriEscape.unescapeUriPathSegment(t, w, encoding),
                    (r, w) -> UriEscape.unescapeUriPathSegment(r, w, encoding),
                    (t, o, l, w) -> UriEscape.unescapeUriPathSegment(t, o, l, w, encoding));
        }
        checkRejected("unescapeUriPathSegment(null encoding)",
                t -> UriEscape.unescapeUriPathSegment(t, (String) null),
                (t, w) -> UriEscape.unescapeUriPathSegment(t, w, null),
                (r, w) -> UriEscape.unescapeUriPathSegment(r, w, null),
                (t, o, l, w) -> UriEscape.unescapeUriPathSegment(t, o, l, w, null));
    }


    @Test
    public void testUnescapeUriQueryParam() throws Exception {
        final String[] texts = unescapeTexts();
        check("unescapeUriQueryParam", texts,
                t -> UriEscapeUtil.unescape(t, UriEscapeType.QUERY_PARAM, UTF8),
                UriEscape::unescapeUriQueryParam, (t, w) -> UriEscape.unescapeUriQueryParam(t, w),
                UriEscape::unescapeUriQueryParam, UriEscape::unescapeUriQueryParam);
        for (final String encoding : ENCODINGS) {
            check("unescapeUriQueryParam(" + encoding + ")", texts,
                    t -> UriEscapeUtil.unescape(t, UriEscapeType.QUERY_PARAM, encoding),
                    t -> UriEscape.unescapeUriQueryParam(t, encoding),
                    (t, w) -> UriEscape.unescapeUriQueryParam(t, w, encoding),
                    (r, w) -> UriEscape.unescapeUriQueryParam(r, w, encoding),
                    (t, o, l, w) -> UriEscape.unescapeUriQueryParam(t, o, l, w, encoding));
        }
        checkRejected("unescapeUriQueryParam(null encoding)",
                t -> UriEscape.unescapeUriQueryParam(t, (String) null),
                (t, w) -> UriEscape.unescapeUriQueryParam(t, w, null),
                (r, w) -> UriEscape.unescapeUriQueryParam(r, w, null),
                (t, o, l, w) -> UriEscape.unescapeUriQueryParam(t, o, l, w, null));
    }


    @Test
    public void testUnescapeUriFragmentId() throws Exception {
        final String[] texts = unescapeTexts();
        check("unescapeUriFragmentId", texts,
                t -> UriEscapeUtil.unescape(t, UriEscapeType.FRAGMENT_ID, UTF8),
                UriEscape::unescapeUriFragmentId, (t, w) -> UriEscape.unescapeUriFragmentId(t, w),
                UriEscape::unescapeUriFragmentId, UriEscape::unescapeUriFragmentId);
        for (final String encoding : ENCODINGS) {
            check("unescapeUriFragmentId(" + encoding + ")", texts,
                    t -> UriEscapeUtil.unescape(t, UriEscapeType.FRAGMENT_ID, encoding),
                    t -> UriEscape.unescapeUriFragmentId(t, encoding),
                    (t, w) -> UriEscape.unescapeUriFragmentId(t, w, encoding),
                    (r, w) -> UriEscape.unescapeUriFragmentId(r, w, encoding),
                    (t, o, l, w) -> UriEscape.unescapeUriFragmentId(t, o, l, w, encoding));
        }
        checkRejected("unescapeUriFragmentId(null encoding)",
                t -> UriEscape.unescapeUriFragmentId(t, (String) null),
                (t, w) -> UriEscape.unescapeUriFragmentId(t, w, null),
                (r, w) -> UriEscape.unescapeUriFragmentId(r, w, null),
                (t, o, l, w) -> UriEscape.unescapeUriFragmentId(t, o, l, w, null));
    }


    private static String[] unescapeTexts() {
        final List<StringOperation> escapes = FacadeTestUtil.operations();
        for (final UriEscapeType type : UriEscapeType.values()) {
            for (final String encoding : ENCODINGS) {
                escapes.add(t -> UriEscapeUtil.escape(t, type, encoding));
            }
        }
        return FacadeTestUtil.unescapeTexts(TEXTS, escapes);
    }




    public UriEscapeFacadeTest() {
        super();
    }


}
