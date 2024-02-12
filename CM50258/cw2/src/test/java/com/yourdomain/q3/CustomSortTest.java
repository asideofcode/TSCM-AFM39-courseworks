package com.yourdomain.q3;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

public class CustomSortTest {
    private CustomSort customSort;

    @Before
    public void setUp() {
        customSort = new CustomSort();
    }
   
    @Test
    public void testSort() {
        ArrayList<Double> values = new ArrayList<>(Arrays.asList(3.0, 1.0, 4.0, 1.5));
        customSort.setValues(values);
        ArrayList<Double> expected = new ArrayList<>(Arrays.asList(1.0, 1.5, 3.0, 4.0));
        assertEquals(expected, values); // Use a getter method for validation
    }

    @Test
    public void testAdd() {
        ArrayList values = new ArrayList<>(Arrays.asList());
        customSort.setValues(values);
        customSort.add(5.0);
        customSort.add(2.0);
        customSort.add(3.0);
        ArrayList<Double> expected = new ArrayList<>(Arrays.asList(2.0, 3.0, 5.0));
        assertEquals(expected, values); // Use a getter method for validation
    }

    @Test
    public void testRemove() {
        ArrayList values = new ArrayList<>(Arrays.asList(2.0, 4.0, 6.0));
        customSort.setValues(values);
        customSort.remove(1); // Remove 4.0
        assertEquals(Arrays.asList(2.0, 6.0), values);
    }

   @Test
    public void testGetGaps() {
        ArrayList values = new ArrayList<>(Arrays.asList(2.0, 4.0, 6.0, 8.0, 10.0));
        customSort.setValues(values);
        ArrayList<Integer> expectedGaps = new ArrayList<>(Arrays.asList(3, 1)); // Adjusted expected gaps
        assertEquals(expectedGaps, customSort.getGaps());
    }

    

    @Test
    public void testSetValues() {
        ArrayList<Double> values = new ArrayList<>(Arrays.asList(9.0, 8.0, 7.0, 6.0, 5.0, 4.0, 3.0, 2.0, 1.0));
        customSort.setValues(values);
        assertEquals(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0), values);
    }

    @Test
    public void testSortingEmptyList() {
         ArrayList values = new ArrayList<>(Arrays.asList());
        customSort.setValues(new ArrayList<>());
        assertTrue(values.isEmpty());
    }

    @Test
    public void testRemoveFromEmptyList() {
        ArrayList values = new ArrayList<>(Arrays.asList());
        customSort.setValues(values);
        customSort.remove(0);
        assertTrue(values.isEmpty());
    }

    @Test
    public void testRemoveInvalidIndex() {
        ArrayList values = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0));
        customSort.setValues(values);
        customSort.remove(3); // Invalid index
        assertEquals(3, values.size());
    }
}
