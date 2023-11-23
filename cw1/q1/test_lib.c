#include <stdio.h>
#include <math.h>
#include <assert.h>
#include "lib.h"

void assertEqualInt(int actual, int expected, const char *actualExpr, const char *file, int line, const char *message)
{
    if (expected != actual)
    {
        printf("❌ Test failed: %s\n", message);
        printf("At %s:%d\n\n", file, line);
        printf("Expected %d, but got expr = %s, val = %d\n\n", expected, actualExpr, actual);
    } else {
        printf("✅ Test passed: %s\n", message);
    }
}

#define ASSERT_EQUAL_INT(actual, expected, message) assertEqualInt(actual, expected, #actual, __FILE__, __LINE__, message)

// Unit tests for isLeapYear
void testIsLeapYear()
{
    ASSERT_EQUAL_INT(isLeapYear(1600), 1, "1600 is a leap year");
    ASSERT_EQUAL_INT(isLeapYear(1700), 0, "1700 is not a leap year");
    ASSERT_EQUAL_INT(isLeapYear(2000), 1, "2000 is a leap year");
    ASSERT_EQUAL_INT(isLeapYear(2001), 0, "2001 is not a leap year");
}

// Unit tests for getDaysInMonth
void testGetDaysInMonth()
{
    ASSERT_EQUAL_INT(getDaysInMonth(2001, 1), 31, "January 2001 has 31 days");
    ASSERT_EQUAL_INT(getDaysInMonth(2001, 2), 28, "February 2001 has 28 days");
    ASSERT_EQUAL_INT(getDaysInMonth(2000, 2), 29, "February 2000 has 29 days");
    ASSERT_EQUAL_INT(getDaysInMonth(2001, 4), 30, "April 2001 has 30 days");
}

int main()
{
    testIsLeapYear();
    testGetDaysInMonth();

    printf("Unit tests completed.\n");
    return 0;
}
