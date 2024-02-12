package com.yourdomain.q2;

// Implements a sorted linked list that can be ordered in ascending or descending order.
public class SortedLinkedList implements SortedList {
    // Head node of the list.
    private Node head;
    // Tail node of the list.
    private Node tail;
    // Indicates if the list is sorted in ascending order.
    private boolean isAscending;
    // Number of elements in the list.
    private int size;

    // Initializes an empty list with default sorting order as ascending.
    public SortedLinkedList() {
        head = null;
        tail = null;
        isAscending = true;
        size = 0;
    }

    // Returns the number of elements in the list.
    @Override
    public int size() {
        return size;
    }

    // Adds a string to the list by creating a new Node and inserting it in sorted order.
    @Override
    public void add(String string) {
        if (string == null) {
            return;
        }

        Node newNode = new Node(string);
        add(newNode);
    }

    // Inserts a new Node into the list while maintaining the sorted order.
    @Override
    public void add(Node newNode) {
        // Check for a null newNode
        if (newNode == null) {
            return;
        }

        // Check for a null string
        if (newNode.getString() == null) {
            return;
        }
        
        if (head == null) {
            // The list is empty, initialize it with the new node
            head = newNode;
            tail = newNode;
        } else {
            // Traverse the list to find the correct position for insertion
            Node current = head;
            
            while (current != null) {
                int comparison = current.getString().compareToIgnoreCase(newNode.getString());
                if (comparison == 0) {
                    // Duplicate found, so do not add
                    return;
                } else if (comparison > 0) {
                    // Insert before the current node
                    insertBefore(current, newNode);
                    break;
                }

                if (current.getNext() == null) {
                    // Reached the end of the list; insert here
                    insertAfter(tail, newNode);
                    break;
                }

                // Keep going
                current = current.getNext();
            }
        }
        size++;
    }

    // Returns the first node in the list considering the sorting order.
    @Override
    public Node getFirst() {
        return isAscending ? head : tail;
    }
    
    // Returns the last node in the list considering the sorting order.
    @Override
    public Node getLast() {
        return isAscending ? tail : head;
    }

    // Retrieves a node by its position in the list.
    @Override
    public Node get(int index) {
        // Check if the index is out of bounds
        if (index < 0 || index >= size) {
            return null;
        }
    
        Node current;
    
        if (isAscending) {
            // Traverse from head in ascending order
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
        } else {
            // Traverse from tail in descending order
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.getPrev();
            }
        }
    
        return current;
    }    

    // Checks if a string is present in the list.
    @Override
    public boolean isPresent(String string) {
        return get(string) != null;
    }
    
    // Removes the first element from the list considering the sorting order.
    @Override
    public boolean removeFirst() {
        return removeNode(isAscending ? head : tail);
    }

    // Removes the last element from the list considering the sorting order.
    @Override
    public boolean removeLast() {
        return removeNode(isAscending ? tail : head);
    }

    // Removes an element by its position in the list.
    @Override
    public boolean remove(int index) {       
        return removeNode(get(index));
    }

    // Removes a node that matches the specified string.
    @Override
    public boolean remove(String string) {
        return removeNode(get(string));
    }

    // Sets the list order to ascending and sorts the list if necessary.
    @Override
    public void orderAscending() {
        isAscending = true;
        sort();
    }

    // Sets the list order to descending and sorts the list if necessary.
    @Override
    public void orderDescending() {
        isAscending = false;
        sort();
    }

    // Prints the elements of the list in the current sorting order.
    @Override
    public void print() {
        Node current = isAscending ? head : tail;
        if (head == null) {
            return;
        }

        while (current != null) {
            System.out.println(current.getString());
            current = isAscending ? current.getNext() : current.getPrev();
        }
        
    }

    // Searches for a node containing the specified string.
    private Node get(String string) {
        if (head == null || string == null) {
            // List is empty or the string is null
            return null;
        }
    
        Node current = head;
    
        // Traverse the list to check for the presence of the string
        while (current != null) {
            int comparison = current.getString().compareToIgnoreCase(string);
            
            if (comparison == 0) {
                // String found
                return current;
            } else if (comparison > 0) {
                // The current node's string is greater than the target string, so stop searching
                break;
            }
    
            current = current.getNext();
        }
    
        // String not found
        return null;
    }

    // Handles the removal of a specified node from the list.
    private boolean removeNode(Node node) {
        // Check for a null Node
        if (node == null) {
            return false;
        }

        if (node.getPrev() != null) {
            node.getPrev().setNext(node.getNext());
        } else {
            head = node.getNext();
        }
        if (node.getNext() != null) {
            node.getNext().setPrev(node.getPrev());
        } else {
            tail = node.getPrev();
        }
        size--;

        return true;
    }

    // Assists in inserting nodes before a specified node in the list.
    private void insertBefore(Node node, Node newNode) {
        newNode.setNext(node);
        newNode.setPrev(node.getPrev());
        if (node.getPrev() != null) {
            node.getPrev().setNext(newNode);
        } else {
            head = newNode;
        }
        node.setPrev(newNode);
    }

    // Assists in inserting nodes after a specified node in the list.
    private void insertAfter(Node node, Node newNode) {
        node.setNext(newNode);
        newNode.setPrev(node);
        if (node == tail) {
            tail = newNode;
        }
    }

    // Checks if the list is sorted according to the current sort order.
    public boolean isSorted() {
        if (head == null || head.getNext() == null) {
            // If the list is empty or has only one element, it's sorted
            return true;
        }
    
        Node current = head;
        while (current != null) {
            if (current.getNext() != null) {
                // Compare the current node with the next node for ascending order
                int forwardComparison = current.getString().compareToIgnoreCase(current.getNext().getString());
                if (forwardComparison > 0) {
                    return false;
                }
            }
    
            if (current != head && current.getPrev() != null) {
                // Compare the current node with the previous node for descending order
                // This check is not needed for the head node
                int backwardComparison = current.getString().compareToIgnoreCase(current.getPrev().getString());
                if (backwardComparison < 0) {
                    return false;
                }
            }
    
            current = current.getNext();
        }
    
        return true;
    }
    
    // Sorts the list if it is not already sorted.
    public void sort() {
        if (isSorted()) {
            // The list is already sorted
            return;
        }
    
        // Only sort if necessary
        mergeSort();
    }

    // Implements merge sort on the list.
    // Merge sort, see https://en.wikipedia.org/wiki/Merge_sort
    private void mergeSort() {
        if (head == null || head.getNext() == null) {
            return;
        }
        head = mergeSortRec(head);

        // Update tail after sorting
        tail = head;
        while (tail != null && tail.getNext() != null) {
            tail = tail.getNext();
        }
    }
    
    // Recursively divides the list and merges them in sorted order.
    private Node mergeSortRec(Node h) {
        // Base case: if head is null or only one element
        if (h == null || h.getNext() == null) {
            return h;
        }
    
        // Get the middle of the list
        Node middle = getMiddle(h);
        Node nextOfMiddle = middle.getNext();
    
        // Set the next of middle node to null to split the list
        middle.setNext(null);
    
        // Apply mergeSort on left list
        Node left = mergeSortRec(h);
    
        // Apply mergeSort on right list
        Node right = mergeSortRec(nextOfMiddle);
    
        // Merge the left and right lists
        return merge(left, right);
    }    

    // Finds the middle node of the list for merge sort.
    private Node getMiddle(Node head) {
        if (head == null) {
            return head;
        }
    
        Node slow = head, fast = head.getNext();
        while (fast != null) {
            fast = fast.getNext();
            if (fast != null) {
                slow = slow.getNext();
                fast = fast.getNext();
            }
        }
        return slow;
    }

    // Merges two sublists into a single sorted list.
    private Node merge(Node a, Node b) {
        Node result;
    
        if (a == null) return b;
        if (b == null) return a;
    
        if (a.getString().compareToIgnoreCase(b.getString()) <= 0) {
            result = a;
            result.setNext(merge(a.getNext(), b));
            if (result.getNext() != null) {
                result.getNext().setPrev(result);
            }
        } else {
            result = b;
            result.setNext(merge(a, b.getNext()));
            if (result.getNext() != null) {
                result.getNext().setPrev(result);
            }
        }
        return result;
    }
}
