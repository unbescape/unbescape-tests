/*
 * =============================================================================
 * 
 *   Copyright (c) 2014-2017, The UNBESCAPE team (http://www.unbescape.org)
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
package org.unbescape.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import org.apache.commons.lang3.StringEscapeUtils;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.0
 *
 */
public final class JsonBenchmark {

    private static final int BENCHMARK_EXECS = 1000000;

    private static final String[] ESCAPE_TEXTS =
            new String[] {
                    "<\"[\u0163\u00E1aeiouABC0123\uD840\uDC00']\ud835\udccd>",
                    "<\"[\u0163\u00E1&aeiouABC0123\uD840\uDC00']\ud835\udccd>",
                    "<\"[\u00E1aeiouABC0123']>",
                    "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
            };
    // Arrays containing textual results
    private static final String[] ESCAPE_TEXTS_UNBESCAPE = new String[ESCAPE_TEXTS.length];
    private static final String[] ESCAPE_TEXTS_STRING_ESCAPE_UTILS = new String[ESCAPE_TEXTS.length];
    private static final boolean[] ESCAPE_NEW_OBJECT_UNBESCAPE = new boolean[ESCAPE_TEXTS.length];
    private static final boolean[] ESCAPE_NEW_OBJECT_STRING_ESCAPE_UTILS = new boolean[ESCAPE_TEXTS.length];



    private static final String[] UNESCAPE_TEXTS =
            new String[] {
                    "<\\\"[\\u0163\\xE1aeiouABC0123\\uD840\\uDC00\\']\\uD835\\uDCCD>",
                    "<\\\"[\\u0163\\xE1&aeiouABC0123\\uD840\\uDC00\\']\\uD835\\uDCCD>",
                    "<\\\"[\\xE1aeiouABC0123\\']>",
                    "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
            };
    // Arrays containing textual results
    private static final String[] UNESCAPE_TEXTS_UNBESCAPE = new String[UNESCAPE_TEXTS.length];
    private static final String[] UNESCAPE_TEXTS_STRING_ESCAPE_UTILS = new String[UNESCAPE_TEXTS.length];
    private static final boolean[] UNESCAPE_NEW_OBJECT_UNBESCAPE = new boolean[UNESCAPE_TEXTS.length];
    private static final boolean[] UNESCAPE_NEW_OBJECT_STRING_ESCAPE_UTILS = new boolean[UNESCAPE_TEXTS.length];




    static {

        // Compute textual escape results
        for (int i = 0; i < ESCAPE_TEXTS.length; i++) {

            ESCAPE_TEXTS_UNBESCAPE[i] = JsonEscape.escapeJson(ESCAPE_TEXTS[i]);
            ESCAPE_NEW_OBJECT_UNBESCAPE[i] = (ESCAPE_TEXTS[i] == ESCAPE_TEXTS_UNBESCAPE[i]);

            ESCAPE_TEXTS_STRING_ESCAPE_UTILS[i] = StringEscapeUtils.escapeJson(ESCAPE_TEXTS[i]);
            ESCAPE_NEW_OBJECT_STRING_ESCAPE_UTILS[i] = (ESCAPE_TEXTS[i] == ESCAPE_TEXTS_STRING_ESCAPE_UTILS[i]);

        }

        // Compute textual unescape results
        for (int i = 0; i < UNESCAPE_TEXTS.length; i++) {

            UNESCAPE_TEXTS_UNBESCAPE[i] = JsonEscape.unescapeJson(UNESCAPE_TEXTS[i]);
            UNESCAPE_NEW_OBJECT_UNBESCAPE[i] = (UNESCAPE_TEXTS[i] == UNESCAPE_TEXTS_UNBESCAPE[i]);

            UNESCAPE_TEXTS_STRING_ESCAPE_UTILS[i] = StringEscapeUtils.unescapeJson(UNESCAPE_TEXTS[i]);
            UNESCAPE_NEW_OBJECT_STRING_ESCAPE_UTILS[i] = (UNESCAPE_TEXTS[i] == UNESCAPE_TEXTS_STRING_ESCAPE_UTILS[i]);

        }

    }



    private static void warmup(final Writer writer) throws IOException {
        final int warmupIters = 10000;
        writer.write(String.format("[BENCHMARK][WARMUP] Starting warmup (%d iterations)\n", Integer.valueOf(warmupIters))); writer.flush();
        for (int i = 0; i < warmupIters; i++) {
            final String res01 = JsonEscape.escapeJson(ESCAPE_TEXTS[i % ESCAPE_TEXTS.length]);
            final String res02 = StringEscapeUtils.escapeJson(ESCAPE_TEXTS[i % ESCAPE_TEXTS.length]);
        }
        for (int i = 0; i < warmupIters; i++) {
            final String res01 = JsonEscape.unescapeJson(UNESCAPE_TEXTS[i % UNESCAPE_TEXTS.length]);
            final String res02 = StringEscapeUtils.unescapeJson(UNESCAPE_TEXTS[i % UNESCAPE_TEXTS.length]);
        }
        writer.write(String.format("[BENCHMARK][WARMUP] Finished warmup (%d iterations)\n", Integer.valueOf(warmupIters))); writer.flush();
    }



    private static void performEscapeBenchmark(final int n, final Writer writer) throws IOException {

        writer.write(String.format("[BENCHMARK][ESCAPE  ][%02d][START  ] Starting benchmark\n", Integer.valueOf(n)));
        writer.write(String.format("[BENCHMARK][ESCAPE  ][%02d][DATA   ] Escaping %10d times:                                   \"%s\"\n",
                Integer.valueOf(n), Integer.valueOf(BENCHMARK_EXECS), ESCAPE_TEXTS[n]));
        writer.flush();

        final long ustart = System.nanoTime();
        for (int i = 0; i < BENCHMARK_EXECS; i++) {
            final String result = JsonEscape.escapeJson(ESCAPE_TEXTS[n]);
        }
        final long ufinish = System.nanoTime();

        final long cstart = System.nanoTime();
        for (int i = 0; i < BENCHMARK_EXECS; i++) {
            final String result = StringEscapeUtils.escapeJson(ESCAPE_TEXTS[n]);
        }
        final long cfinish = System.nanoTime();

        writer.write(String.format("[BENCHMARK][ESCAPE  ][%02d][FINISH ] Finished benchmark\n", Integer.valueOf(n)));

        final long utime = ufinish - ustart;
        final long ctime = cfinish - cstart;

        final double cdiff = (100 / (double)utime) * (double)ctime;

        writer.write(String.format("[BENCHMARK][ESCAPE  ][%02d][RESULTS] Unbescape:         %15d nanosecs [**********] (%1s) \"%s\"\n",
                new Object[] { Integer.valueOf(n), Long.valueOf(utime), (ESCAPE_NEW_OBJECT_UNBESCAPE[n]? "*" : ""), ESCAPE_TEXTS_UNBESCAPE[n] }));
        writer.write(String.format("[BENCHMARK][ESCAPE  ][%02d][RESULTS] StringEscapeUtils: %15d nanosecs [%9.2f%%] (%1s) \"%s\"\n",
                new Object[] { Integer.valueOf(n), Long.valueOf(ctime), Double.valueOf(cdiff), (ESCAPE_NEW_OBJECT_STRING_ESCAPE_UTILS[n]? "*" : ""), ESCAPE_TEXTS_STRING_ESCAPE_UTILS[n] }));
        writer.flush();

    }




    private static void performUnescapeBenchmark(final int n, final Writer writer) throws IOException {

        writer.write(String.format("[BENCHMARK][UNESCAPE][%02d][START  ] Starting benchmark\n", Integer.valueOf(n)));
        writer.write(String.format("[BENCHMARK][UNESCAPE][%02d][DATA   ] Unescaping %10d times:                                 \"%s\"\n",
                Integer.valueOf(n), Integer.valueOf(BENCHMARK_EXECS), UNESCAPE_TEXTS[n]));
        writer.flush();

        final long ustart = System.nanoTime();
        for (int i = 0; i < BENCHMARK_EXECS; i++) {
            final String result = JsonEscape.unescapeJson(UNESCAPE_TEXTS[n]);
        }
        final long ufinish = System.nanoTime();

        final long cstart = System.nanoTime();
        for (int i = 0; i < BENCHMARK_EXECS; i++) {
            final String result = StringEscapeUtils.unescapeJson(UNESCAPE_TEXTS[n]);
        }
        final long cfinish = System.nanoTime();

        writer.write(String.format("[BENCHMARK][UNESCAPE][%02d][FINISH ] Finished benchmark\n", Integer.valueOf(n)));

        final long utime = ufinish - ustart;
        final long ctime = cfinish - cstart;

        final double cdiff = (100 / (double)utime) * (double)ctime;

        writer.write(String.format("[BENCHMARK][UNESCAPE][%02d][RESULTS] Unbescape:         %15d nanosecs [**********] (%1s) \"%s\"\n",
                new Object[] { Integer.valueOf(n), Long.valueOf(utime), (UNESCAPE_NEW_OBJECT_UNBESCAPE[n]? "*" : ""), UNESCAPE_TEXTS_UNBESCAPE[n] }));
        writer.write(String.format("[BENCHMARK][UNESCAPE][%02d][RESULTS] StringEscapeUtils: %15d nanosecs [%9.2f%%] (%1s) \"%s\"\n",
                new Object[] { Integer.valueOf(n), Long.valueOf(ctime), Double.valueOf(cdiff), (UNESCAPE_NEW_OBJECT_STRING_ESCAPE_UTILS[n]? "*" : ""), UNESCAPE_TEXTS_STRING_ESCAPE_UTILS[n] }));
        writer.flush();

    }




    public static void main(String[] args) throws Exception {

        final Writer writer = new PrintWriter(System.out, true);

        writer.write("\n");
        writer.write("[BENCHMARK] --------------------------------------\n");
        writer.write("[BENCHMARK] STARTING UNBESCAPE BENCHMARK FOR: JSON\n");
        writer.write("[BENCHMARK] --------------------------------------\n");

        warmup(writer);

        for (int i = 0; i < ESCAPE_TEXTS.length; i++) {
            performEscapeBenchmark(i, writer);
        }

        for (int i = 0; i < UNESCAPE_TEXTS.length; i++) {
            performUnescapeBenchmark(i, writer);
        }

        writer.flush();

    }


    public JsonBenchmark() {
        super();
    }


}

