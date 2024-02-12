package com.yourdomain.q3;

import java.util.ArrayList;

// Implements a sorting algorithm using a custom gap sequence.
public class CustomSort implements SortingInterface {
    // List to hold the values to be sorted.
    private ArrayList<Double> values;
    // List to hold the gap sequence used in the sorting algorithm.
    private ArrayList<Integer> gaps;

    // Initializes the sorting algorithm with empty values and gaps lists.
    public CustomSort() {
        this.values = new ArrayList<>();
        this.gaps = new ArrayList<>();
    }

    // Sets the values to be sorted and immediately sorts them.
    @Override
    public void setValues(ArrayList<Double> values) {
        this.values = values;
        sort();
    }

    // Returns the gap sequence used in the last sort operation.
    @Override
    public ArrayList<Integer> getGaps() {
        return gaps;
    }

    // Adds a new value to the list and sorts the list again.
    @Override
    public void add(Double value) {
        values.add(value);
        sort();
    }

    // Removes a value at a specified index from the list.
    @Override
    public void remove(int index) {
        if (index >= 0 && index < values.size()) {
            values.remove(index);
        }
    }

    // Sorts the list of values using the custom gap sequence.
    @Override
    public void sort() {
        int n = values.size();
        calculateGaps(n);

        for (int gap : gaps) {
            for (int i = gap; i < n; i++) {
                double temp = values.get(i);
                int j;
                for (j = i; j >= gap && values.get(j - gap) > temp; j -= gap) {
                    values.set(j, values.get(j - gap));
                }
                values.set(j, temp);
            }
        }
    }

    // Calculates the gap sequence to be used for sorting based on the size of the list.
    private void calculateGaps(int n) {
        gaps.clear();

        ArrayList<Integer> temp = new ArrayList<>();
        int gap = 1, i = 2;
        while (gap < n) {
            temp.add(gap);
            gap = (int) Math.pow(2, i) - 1;
            i++;
        }

        for (i = temp.size() - 1; i >= 0; i--) {
            gaps.add(temp.get(i));
        }
    }
}
