# Question 2

This is the folder for Question 2 of Coursework 1. The specification for the question is available in the [./SPEC.md](./SPEC.md) file.

The code here contains a reference solution, and some unit tests. There's also a Makefile to coordinate the compilation and running of the test suite.

Install dependencies e.g. `pytest`

```sh
$ pip install -r ./requirements.txt
```

Run the tests:

```sh
$ python -m pytest -v
============================================= test session starts ==============================================
...
collected 5 items                                                                                              

test_polish_notation.py::test_normal_operations PASSED                                                   [ 20%]
test_polish_notation.py::test_division_truncation PASSED                                                 [ 40%]
test_polish_notation.py::test_invalid_input PASSED                                                       [ 60%]
test_polish_notation.py::test_incorrect_number_of_tokens PASSED                                          [ 80%]
test_polish_notation.py::test_nested_expressions PASSED                                                  [100%]

============================================== 5 passed in 0.01s ==============================================
```

Run a benchmark with large input, with 10000 expressions:

```sh
$ python ./benchmark_polish_notation.py
Profiling evaluatePNExpression on large input, with 10000 expression/s...

         100011 function calls in 0.018 seconds

   Ordered by: standard name

   ncalls  tottime  percall  cumtime  percall filename:lineno(function)
        1    0.000    0.000    0.018    0.018 <string>:1(<module>)
        1    0.000    0.000    0.000    0.000 benchmark_polish_notation.py:11(assertEqual)
        1    0.011    0.011    0.018    0.018 polish_notation.py:18(evaluatePNExpression)
    10000    0.000    0.000    0.000    0.000 polish_notation.py:5(<lambda>)
        1    0.000    0.000    0.018    0.018 {built-in method builtins.exec}
    20002    0.001    0.000    0.001    0.000 {built-in method builtins.isinstance}
    10002    0.000    0.000    0.000    0.000 {built-in method builtins.len}
    20001    0.001    0.000    0.001    0.000 {method 'append' of 'list' objects}
        1    0.000    0.000    0.000    0.000 {method 'disable' of '_lsprof.Profiler' objects}
    20001    0.004    0.000    0.004    0.000 {method 'match' of 're.Pattern' objects}
    20000    0.001    0.000    0.001    0.000 {method 'pop' of 'list' objects}
```