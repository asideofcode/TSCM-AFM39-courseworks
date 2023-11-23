import cProfile
from polish_notation import evaluatePNExpression

# Function to generate a large test case
def generate_large_test_case(expressions):
    # Generates a test case like ["+", "1", ["+", "1", ["+", "1", ...]]]
    expression = ["+", "1"] * expressions
    expression.append("1")
    return expression

def assertEqual(a, b):
    if a != b:
        raise AssertionError(f"{a} != {b}")

# Profile the performance of evaluatePNExpression on a large test case
def profile_performance():
    expressions = 10000
    print(f"Profiling evaluatePNExpression on large input with {expressions} expression/s...\n")
    large_test_case = generate_large_test_case(expressions)
    cProfile.runctx(f'assertEqual(evaluatePNExpression(large_test_case), {expressions + 1})', globals(), locals())

profile_performance()
