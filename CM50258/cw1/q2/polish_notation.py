import re

# Supported operations
supportedOperations = {
    '+': lambda a, b: a + b,
    '-': lambda a, b: a - b,
    '*': lambda a, b: a * b,
    '/': lambda a, b: None if b == 0 else int(a / b),
}

# Regex pattern for decimal integers, avoids leading zeros.
decimalIntegerRegexPattern = re.compile(r'^[-+]?([1-9]\d*|0)$')

# Evaluates a Polish Notation expression through an iterative approach. 
# Could be done recursively, where the stack is implicit (the call stack)
# but with Python's default maximum recursion depth of 1000, this would
# limit the size of the expression that could be evaluated.
def evaluatePNExpression(expression): 
    if not isinstance(expression, list): # Expression is not a list
        return None

    if not expression or len(expression) == 0: # Empty expression
        return None

    stack = []

    # Iterating through the expression in reverse allows us to consume operators in the correct order
    # and arguments as they become available. The stack is really a clever way to collect arguments
    for token in reversed(expression):
        if not isinstance(token, str): # Token is not string
            return None
    
        if decimalIntegerRegexPattern.match(token):  # Token is a number
            number = int(token)
            if not -300 <= number <= 300: # Number out of valid range
                return None  

            stack.append(number)
        elif token in supportedOperations:  # Token is an operator
            if len(stack) < 2:  # Not enough operands
                return None

            operand1 = stack.pop()
            if operand1 is None:
                return None

            operand2 = stack.pop()
            if operand2 is None:
                return None

            result = supportedOperations[token](operand1, operand2)
            if result is None:
                return None

            stack.append(result)
        else: # Invalid token
            return None 

    if len(stack) != 1: # Too many operands
        return None

    return stack[0]


# Evaluates a Polish Notation expression through recursion.
# Just a fun exercise.
def evaluatePNExpressionRecursive(expression):
    if not isinstance(expression, list): # Expression is not a list
        return None

    if not expression or len(expression) == 0: # Empty expression
        return None

    # Helper function to recursively evaluate the expression
    def evaluate(index):
        if index >= len(expression):
            return None, index

        token = expression[index]

        if not isinstance(token, str): # Token is not string
            return None, index

        # If the token is a number, return it as integer
        if decimalIntegerRegexPattern.match(token):
            number = int(token)
            if not -300 <= number <= 300: # Number out of valid range
                return None, index
            return number, index + 1

        elif token in supportedOperations:
            # Recursively evaluate the next two operands
            operand1, next_index = evaluate(index + 1)
            if operand1 is None:
                return None, next_index

            operand2, next_index = evaluate(next_index)
            if operand2 is None:
                return None, next_index

            # Perform the operation
            result = supportedOperations[token](operand1, operand2)
            return result, next_index
        else:
            # Invalid token
            return None, index + 1

    # Start the recursive evaluation from the first token
    result, _ = evaluate(0)

    # If the final index is not the length of the expression, we have leftover tokens 
    # which is an invalid expression
    if _ != len(expression):
        return None

    return result

