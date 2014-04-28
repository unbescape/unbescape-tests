Unbescape test + benchmark repository
=====================================

This is the repository of tests and benchmarks related to the Unbescape project: http://www.unbescape.org

Executing the benchmark
-----------------------

Simply clone or download this repository and execute the `benchmark.sh` script:

```
$ ./benchmark.sh
Syntax: "./benchmark.sh {language}"
(language = "html" | "xml" | "javascript" | "json" | "csv" | "java")

$ ./benchmark.sh html
[BENCHMARK] --------------------------------------
[BENCHMARK] STARTING UNBESCAPE BENCHMARK FOR: HTML
[BENCHMARK] --------------------------------------
[BENCHMARK][WARMUP] Starting warmup (10000 iterations)
[BENCHMARK][WARMUP] Finished warmup (10000 iterations)
...
[BENCHMARK][ESCAPE  ][01][START  ] Starting benchmark
[BENCHMARK][ESCAPE  ][01][DATA   ] Escaping    1000000 times:                                   "<"[ţá&aeiouABC0123𠀀']>"
[BENCHMARK][ESCAPE  ][01][FINISH ] Finished benchmark
[BENCHMARK][ESCAPE  ][01][RESULTS] Unbescape:               620936118 nanosecs [**********] ( ) "&lt;&quot;[&tcedil;&aacute;&amp;aeiouABC0123&#131072;&apos;]&gt;"
[BENCHMARK][ESCAPE  ][01][RESULTS] StringEscapeUtils:      2174168023 nanosecs [   350,14%] ( ) "&lt;&quot;[ţ&aacute;&amp;aeiouABC0123𠀀']&gt;"
[BENCHMARK][ESCAPE  ][01][RESULTS] Spring HtmlUtils:        363510523 nanosecs [    58,54%] ( ) "&lt;&quot;[ţ&aacute;&amp;aeiouABC0123𠀀&#39;]&gt;"
[BENCHMARK][ESCAPE  ][01][RESULTS] OWASP ESAPI:            2486772953 nanosecs [   400,49%] ( ) "&lt;&quot;&#x5b;&#x163;&aacute;&amp;aeiouABC0123&#xd840;&#xdc00;&#x27;&#x5d;&gt;"
...
[BENCHMARK][ESCAPE  ][03][START  ] Starting benchmark
[BENCHMARK][ESCAPE  ][03][DATA   ] Escaping    1000000 times:                                   "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
[BENCHMARK][ESCAPE  ][03][FINISH ] Finished benchmark
[BENCHMARK][ESCAPE  ][03][RESULTS] Unbescape:               464828653 nanosecs [**********] (*) "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
[BENCHMARK][ESCAPE  ][03][RESULTS] StringEscapeUtils:      6951172692 nanosecs [  1495,43%] ( ) "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
[BENCHMARK][ESCAPE  ][03][RESULTS] Spring HtmlUtils:        460123432 nanosecs [    98,99%] ( ) "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
[BENCHMARK][ESCAPE  ][03][RESULTS] OWASP ESAPI:            4262972393 nanosecs [   917,11%] ( ) "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
...
```

For each language, the benchmark will compare several technologies and show the results of escaping and unescaping
several inputs. For each of them, you will be able to see:

  * The **time required** for the execution (in nanosecs).
  * The **comparison** between the time required by Unbescape and other technologies (in percent, e.g. `[350,14%]`).
  * Whether the returned output was exactly the **same object** as the input (`true` = `(*)`), in order to improve performance.
  * The **result of the escape/unescape operation itself**, so that you can check it's correctness.
