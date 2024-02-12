package com.yourdomain.q2;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SortedLinkedListTest {
    private SortedLinkedList list;

    @Before
    public void setUp() {
        list = new SortedLinkedList();
    }

    @Test
    public void testAddAndSize() {
        list.add("Charlie");
        list.add("Alice");
        list.add("Bob");
        assertEquals(3, list.size());
    }

    @Test
    public void testOrderAscending() {
        list.add("Charlie");
        list.add("Alice");
        list.add("Bob");
        list.orderAscending();
        assertEquals("Alice", list.getFirst().getString());
        assertEquals("Charlie", list.getLast().getString());
    }

    @Test
    public void testOrderDescending() {
        list.add("Delta");
        list.add("Charlie");
        list.add("Alice");
        list.add("Bob");

        list.orderDescending();

        assertEquals("Delta", list.getFirst().getString());
        assertEquals("Alice", list.getLast().getString());
    }

    @Test
    public void testRemoveFirst() {
        list.add("Charlie");
        list.add("Alice");
        list.add("Bob");
        assertTrue(list.removeFirst());
        assertEquals(2, list.size());
        assertEquals("Bob", list.getFirst().getString());
    }

    @Test
    public void testRemoveLast() {
        list.add("Charlie");
        list.add("Alice");
        list.add("Bob");
        assertTrue(list.removeLast());
        assertEquals(2, list.size());
        assertEquals("Bob", list.getLast().getString()); // "Bob" should be the last after removing "Charlie"
    }


    @Test
    public void testRemoveByIndex() {
        list.add("Charlie");
        list.add("Alice");
        list.add("Bob");

        assertTrue(list.remove(1)); // Remove 'Bob'

        assertEquals(2, list.size());
        assertEquals("Alice", list.get(0).getString());
        assertEquals("Charlie", list.get(1).getString());
        assertNull(list.get(2));
    }

    @Test
    public void testRemoveByString() {
        list.add("Charlie");
        list.add("Alice");
        list.add("Bob");
        assertTrue(list.remove("Bob"));
        assertEquals(2, list.size());
        assertFalse(list.isPresent("Bob"));
    }

    @Test
    public void testGetByIndex() {
        list.add("Charlie");
        list.add("Alice");
        list.add("Bob");
        assertEquals("Bob", list.get(1).getString());
    }

    @Test
    public void testIsPresent() {
        list.add("Charlie");
        list.add("Alice");
        assertTrue(list.isPresent("Alice"));
        assertFalse(list.isPresent("David"));
    }

    // Add more tests as needed to cover edge cases and additional functionality

    @Test
    public void testAddDuplicateStrings() {
        list.add("Hello");
        list.add("World");
        list.add("hello"); // Duplicate with different case
        assertEquals(2, list.size());
    }

    @Test
    public void testRemoveFromEmptyList() {
        assertFalse(list.removeFirst());
        assertFalse(list.removeLast());
        assertFalse(list.remove("NonExistent"));
        assertFalse(list.remove(5));
    }

    @Test
    public void testRemoveNonExistentElement() {
        list.add("Hello");
        list.add("World");
        assertFalse(list.remove("NonExistent"));
    }

    @Test
    public void testGetFromEmptyList() {
        assertNull(list.get(0));
        assertNull(list.get(5));
        assertNull(list.getFirst());
        assertNull(list.getLast());
    }

    @Test
    public void testOutOfBoundsGet() {
        list.add("Hello");
        assertNull(list.get(1)); // Index out of bounds
    }

    @Test
    public void testAddNull() {
        list.add((String) null);
        assertEquals(0, list.size());
    }

    @Test
    public void testAddEmptyString() {
        list.add("");
        assertEquals(1, list.size());
        assertTrue(list.isPresent(""));
    }

    @Test
    public void testRemoveAtIndexOutOfBounds() {
        list.add("Hello");
        assertFalse(list.remove(1)); // Index out of bounds
    }

    @Test
    public void testPrintEmptyList() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        list.print(); // Should not print anything

        System.setOut(originalOut); // Reset to the original standard out

        assertEquals("", outContent.toString()); // Check that nothing was printed
    }

    @Test
    public void testPrintAscendingList() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        list.add("Hello");
        list.add("Goodbye");
        list.print(); // Should not print anything

        System.setOut(originalOut); // Reset to the original standard out

        assertEquals("Goodbye\nHello\n", outContent.toString()); // Check that nothing was printed
    }

    @Test
    public void testPrintDescendingList() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        list.add("Hello");
        list.add("Goodbye");
        list.orderDescending();
        list.print(); // Should not print anything

        System.setOut(originalOut); // Reset to the original standard out

        assertEquals("Hello\nGoodbye\n", outContent.toString()); // Check that nothing was printed
    }

    @Test
    public void testGetPerformance() {
        long startTime, endTime;
        startTime = System.nanoTime();
        // Add more elements to increase list size
        for (int i = 0; i < 10000; i++) {
            list.add("Fruit" + i);
        }
        endTime = System.nanoTime();

        assertTrue(endTime - startTime < 1000 * 1000000);

        startTime = System.nanoTime();
        list.get(5000); // Access the middle element
        endTime = System.nanoTime();

        // Assert that it completes within a reasonable time
        assertTrue(endTime - startTime < 1000000);
    }

    @Test
    public void testAllMethodsOnAscendingList() {
        list.orderAscending();
        list.add("Charlie");
        list.add("Alice");
        list.add("Bob");
        assertEquals(3, list.size());
        assertEquals("Alice", list.getFirst().getString());
        assertEquals("Charlie", list.getLast().getString());
        assertTrue(list.isPresent("Bob"));
        assertEquals("Bob", list.get(1).getString());
        assertTrue(list.remove("Bob"));
        assertEquals(2, list.size());
        assertFalse(list.isPresent("Bob"));
        assertTrue(list.removeFirst());
        assertEquals("Charlie", list.getFirst().getString());
        assertTrue(list.removeLast());
        assertEquals(0, list.size());
    }

    @Test
    public void testAllMethodsOnDescendingList() {
        list.orderDescending();
        list.add("Alice");
        list.add("Charlie");
        list.add("Bob");
        assertEquals(3, list.size());
        assertEquals("Charlie", list.getFirst().getString());
        assertEquals("Alice", list.getLast().getString());
        assertTrue(list.isPresent("Bob"));
        assertEquals("Bob", list.get(1).getString());
        assertTrue(list.remove("Bob"));
        assertEquals(2, list.size());
        assertFalse(list.isPresent("Bob"));
        assertTrue(list.removeFirst());
        assertEquals("Alice", list.getFirst().getString());
        assertTrue(list.removeLast());
        assertEquals(0, list.size());
    }


    @Test
    // @Ignore
    public void testOrderAscendingWithMutations() {
        Node a = new Node("Alpha");
        Node b = new Node("Beta");
        Node c = new Node("Charlie");
        Node d = new Node("Delta");

        list.add(c);
        list.add(a);
        list.add(d);
        list.add(b);

        a.setString("Z");
        b.setString("W");
        c.setString("X");
        d.setString("Y");

        assertFalse(list.isSorted());

        list.orderAscending();

        assertEquals(list.getFirst(), b);
        assertEquals(list.getLast(), a);
        assertTrue(list.isSorted());
    }

}

// 1. Add empty
// 2. Remove empty
// 3. Add null
// 4. Remove null
// 5. Remove non-existent
// 6. Remove end of list
// 7. Remove start of list
// 8. Remove middle of list
// 9. Try all the methods on ascending and descending lists
