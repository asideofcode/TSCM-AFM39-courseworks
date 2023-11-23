#include <stdio.h>
#include <stdbool.h>

// normaliseDayOfTheWeek ensures that the day of the week is between 1 and 7
// even after subtracting or adding a large number of days using modulo arithmetic
int normaliseDayOfTheWeek(int dayOfWeek)
{
    // Switch to 0-based day of the week, which is more appropriate for modulo arithmetic
    // 1-based day of the week would have 7 wrapping around to become 0 :( (e.g. 7 % 7 = 0)
    int zeroBasedDayOfWeek = dayOfWeek - 1;
    
    // Normalise 0-based day of the week to be between 0 and 6
    zeroBasedDayOfWeek = ((zeroBasedDayOfWeek % 7) + 7) % 7;

    // Switch back to 1-based day of the week
    return zeroBasedDayOfWeek + 1;
}

// Function to check if a given year is a leap year
bool isLeapYear(int year)
{
    if (year % 4 != 0)
        return false;
    if (year % 100 == 0 && year % 400 != 0)
        return false;
    return true;
}

// Function to get the number of days in a given month of a given year
int getDaysInMonth(int year, int month)
{
    if (month == 2) // February
        return isLeapYear(year) ? 29 : 28;
    if (month == 4 || month == 6 || month == 9 || month == 11)
        return 30;
    return 31;
}


// Function to calculate how many Mondays fall on the 12th of the month
// 
// The approach here involves counting month by month in reverse from a known reference date (12th of a specific month and year).
// By subtracting the number of days in the preceding month from the day of the week of the current 12th, 
// we determine the day of the week for the 12th of the previous month.
// 
// This approach only works if the range of years is altogether earlier than the reference date.
// It would need to be adapted to account for ranges that fall elsewhere.
int howManyDays() {
    int dayOfMonthToCount = 12;
    int dayOfWeekToCount = 1;

    int refDayOfWeek = 2; // May 18, 2007 was a Tuesday (2nd day of the week if we consider Monday as the 1st day)
    int refDay = 18;
    int refMonth = 5;
    int refYear = 2007;

    int startYear = 1401;
    int endYear = 1800;
    int dayOfMonth = dayOfMonthToCount;

    // Count of the configured day of the month (e.g. 12th) that falls on the configured day of the week (e.g. Monday)
    int count = 0;

    // The day of week of the week of the configured day of the month (e.g. 12th) of the current month
    // Use arithmetic on the reference date to determine the day of the week of the configured day of the month
    int dayOfWeek = normaliseDayOfTheWeek(refDayOfWeek - (refDay - dayOfMonthToCount)); 
    int month = refMonth;
    int year = refYear;


    while (year >= startYear) { // Loop back in time until the start year of the range
        if (year <= endYear && dayOfWeek == dayOfWeekToCount) { // Count if it's a Monday and within the range
            count++;
        }

        // Move to the previous month
        if (--month == 0) {
            month = 12;
            year--;
        }

        // Update the day of the week for the 12th of the new month
        dayOfWeek = normaliseDayOfTheWeek(dayOfWeek - getDaysInMonth(year, month));
    }

    return count;
}
