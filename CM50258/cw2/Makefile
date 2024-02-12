# Default target to run when no arguments are given to make
all: compile-test

# Target for compiling and testing the project
compile-test:
	mvn compile test

# A 'clean' target might be useful for cleaning up Maven's output
clean:
	mvn clean

# Prevent make from doing something with a file named like the targets
.PHONY: all compile-test clean
