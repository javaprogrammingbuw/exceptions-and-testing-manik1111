# minimal makefile for SE class
all: test

# main depends on all cpp files
%.class: %.java
	javac $^

test: TestSuite.class
	java TinyTestJ.RunTests TestSuite

clean:
	rm *.class

