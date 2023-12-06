Write a function in Python (note the version of python used is version 3) which evaluates an arithmetic expression in Polish Notation ([https://en.wikipedia.org/wiki/Polish_notation](http://libproxy.bath.ac.uk/login?qurl=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FPolish_notation)) and returns the answer as an integer or `None` if the expression is invalid. 

For example,

Input: `["+", "3", "3"]`

Output: `6`

Input: `["*", "+", "3", "3", "-10"]`

Output: `-60`

You must complete the solution by creating a function called `evaluatePNExpression`  (see below for further information). You may create and use additional functions in your solution. Your solution must return an answer within 30 seconds. 

Note that:

-   The input to the function is a list of tokens (represented as strings) e.g. `["+", "3", "3"]`
-   A token is either a valid operator (see below) or an integer in the range `-300` to `300` e.g. `["+", "301", "3"]` is an invalid expression so should return `None`. However, `["+", "300", "3"]` is a valid expression

-   The valid operators are `+`, `-`, `*`, and `/`
-   The division between two integers always truncates toward zero e.g. `1 / 2 = 0` or `12 / 7 = 1`
-   If the expression contains a divide by `0` the function should return `None`

-   The input does not always represent a valid arithmetic expression in polish notation e.g. `["+", "-", "3", "4"]`
