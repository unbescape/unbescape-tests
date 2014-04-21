#!/bin/sh
# Syntax: "./benchmark.sh {language}
#

LANGUAGE="$1";

if [ "$LANGUAGE" == ''  ];
then
  echo 'Bad syntax: "./benchmark.sh {language}"'
  echo '(language = "html" | "xml" | "javascript" | "json")'
  exit 1;
fi

BENCHMARK_CLASS=""
if [ "$LANGUAGE" == 'html' ];
then
  BENCHMARK_CLASS="org.unbescape.html.HtmlBenchmark";
fi
if [ "$LANGUAGE" == 'xml' ];
then
  BENCHMARK_CLASS="org.unbescape.xml.XmlBenchmark";
fi
if [ "$LANGUAGE" == 'javascript' ];
then
  BENCHMARK_CLASS="org.unbescape.javascript.JavaScriptBenchmark";
fi
if [ "$LANGUAGE" == 'json' ];
then
  BENCHMARK_CLASS="org.unbescape.json.JsonBenchmark";
fi

if [ "$BENCHMARK_CLASS" == '' ];
then
  echo 'Bad syntax: "./benchmark.sh {language}"'
  echo '(language = "html" | "xml" | "javascript" | "json")'
  exit 1;
fi


mvn clean compile exec:java -Dexec.mainClass=$BENCHMARK_CLASS
