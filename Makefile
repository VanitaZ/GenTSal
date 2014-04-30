.PHONY: all clean

SOURCES=$(wildcard GenTravSal/src/*.java)
CLASS=$(SOURCES:GenTravSal/src/%.java=out/%.class)

CLASSPATH=GenTravSal/JUNG/jung-api-2.0.1.jar:GenTravSal/JUNG/jung-graph-impl-2.0.1.jar:GenTravSal/JUNG/jung-algorithms-2.0.1.jar:GenTravSal/JUNG/jung-visualization-2.0.1.jar

export CLASSPATH

all: $(CLASS)

out/%.class: GenTravSal/src/%.java
	javac -g -d out/ -sourcepath GenTravSal/src/ $<

clean:
	rm -f out/*
