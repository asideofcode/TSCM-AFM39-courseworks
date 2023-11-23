# Question 1

This is the folder for Question 1 of Coursework 1. The specification for the question is available in the [./SPEC.md](./SPEC.md) file. 

The code here contains a reference solution, and some unit tests. There's also a Makefile to coordinate the compilation and running of the test suite.

Run the tests:

```sh
$ make      
mkdir -p out
gcc -c -o out/lib.o lib.c -I.
gcc -c -o out/test_lib.o test_lib.c -I.
gcc -o out/test out/lib.o out/test_lib.o -I.
./out/test
✅ Test passed: 1600 is a leap year
✅ Test passed: 1700 is not a leap year
✅ Test passed: 2000 is a leap year
✅ Test passed: 2001 is not a leap year
✅ Test passed: January 2001 has 31 days
✅ Test passed: February 2001 has 28 days
✅ Test passed: February 2000 has 29 days
✅ Test passed: April 2001 has 30 days
Unit tests completed.
```