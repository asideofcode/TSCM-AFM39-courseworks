import pytest
from polish_notation import evaluatePNExpression

def test_normal_operations():
    assert evaluatePNExpression(["+", "+0", "-0"]) == 0
    assert evaluatePNExpression(["+", "+3", "-3"]) == 0
    assert evaluatePNExpression(["+", "1", "+", "35", "300"]) == 336
    assert evaluatePNExpression(["*", "+", "3", "3", "-10"]) == -60
    assert evaluatePNExpression(["/", "6", "3"]) == 2
    assert evaluatePNExpression(["-", "3", "10"]) == -7
    assert evaluatePNExpression(["2"]) == 2

def test_division_truncation():
    assert evaluatePNExpression(["/", "-7", "3"]) == -2
    assert evaluatePNExpression(["/", "7", "-3"]) == -2

def test_invalid_input():
    # Non-list inputs
    assert evaluatePNExpression(("+", "3", "3")) == None
    assert evaluatePNExpression(2) == None

    # Non string values in a list
    assert evaluatePNExpression([1,2,3]) is None

     # Division by 0 fed into another operator
    assert evaluatePNExpression(["*", "/", "3", "0", "1"]) is None

    # Division by 0
    assert evaluatePNExpression(["/", "3", "0"]) is None

    # Invalid operand token
    assert evaluatePNExpression(["+", "three", "3"]) is None

    # Invalid operator token
    assert evaluatePNExpression(["&", "3", "3"]) is None

    # Operand out of range
    assert evaluatePNExpression(["+", "301", "3"]) is None

    # Operator with no operands
    assert evaluatePNExpression(["*"]) is None

    # Leading 0
    assert evaluatePNExpression(["03"]) is None

    # Empty list
    assert evaluatePNExpression([]) is None

    # Too many operands
    assert evaluatePNExpression(["1", "2", "3"]) is None

def test_incorrect_number_of_tokens():
    assert evaluatePNExpression(["+", "3"]) is None
    assert evaluatePNExpression(["+", "3", "5", "5"]) is None

def test_nested_expressions():
    assert evaluatePNExpression(["*", "-", "5", "2", "+", "3", "3"]) == 18
    assert evaluatePNExpression(["*", "-", "5", "6", "7"]) == -7
    assert evaluatePNExpression(["-", "+", "7", "*", "4", "-2", "/", "8", "2"]) == -5
