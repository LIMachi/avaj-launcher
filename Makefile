MAIN = Main

SRCS = $(shell find src -name "*.java")
.PHONY: all, clean, run

run: all
	java -cp build Main scenario.txt

all: build/${MAIN}.class

build/${MAIN}.class: sources.txt
	javac -d build @sources.txt

sources.txt: ${SRCS}
	echo "${SRCS}" > sources.txt

clean:
	rm -rf build
	rm sources.txt