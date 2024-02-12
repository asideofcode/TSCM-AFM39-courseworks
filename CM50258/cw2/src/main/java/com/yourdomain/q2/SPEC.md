Your task is to create a class called `SortedLinkedList` that uses a custom Node class ([available here](https://moodle.bath.ac.uk/pluginfile.php/937279/question/questiontext/1499011/2/2776226/Node.java?time=1648397132016)) to store strings alphabetically in a  [doubly linked list](http://libproxy.bath.ac.uk/login?qurl=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FDoubly_linked_list). The `SortedLinkedList` class should store strings alphabetically (by default this should be in ascending order) and should implement a SortedList interface ([available here](https://moodle.bath.ac.uk/pluginfile.php/937279/question/questiontext/1499011/2/2776226/SortedList.java?time=1648417317338)) containing the following methods:

-   `public int size()`\* - returns the number of Nodes in the linked list.
-   `public void add(String string)` - adds a Node with the specified string to the linked list in the appropriate position given the specified alphabetical order (i.e., ascending/descending).
-   `public void add(Node node)`\* - adds a Node to the linked list in the appropriate position given the specified alphabetical order (i.e., ascending/descending).
-   `public Node getFirst()`\* - returns the first Node of the linked list given the specified alphabetical order (i.e., ascending/descending).
-   `public Node getLast()`\* - returns the last Node of the linked list given the specified alphabetical order (i.e., ascending/descending).
-   `public Node get(int index)`\* - returns the Node at the specified index assuming indices start at 0 and end with size-1 given the specified alphabetical order (i.e., ascending/descending).
-   `public boolean isPresent(String string)` - checks to see if the list contains a Node with the specified string and returns true if successful or false if unsuccessful.
-   `public boolean removeFirst()` - removes the first Node from the list given the alphabetical order (i.e., ascending/descending) and returns true if succesful or false if unsuccessful.
-   `public boolean removeLast()` - removes the last Node from the list given the alphabetical order (i.e., ascending/descending) and returns true if succesful or false if unsuccessful.
-   `public boolean remove(int index)` - removes the Node at the specified index from the list assuming indices start at 0 and end with size-1 given the specified alphabetical order (i.e., ascending/descending) and returns true if succesful or false if unsuccessful.
-   `public boolean remove(String string)` - removes the Node that contains the specified String from the list and returns true if succesful or false if unsuccessful.
-   `public void orderAscending()` - orders the list in ascending alphabetic order.
-   `public void orderDescending()` - orders the list in descending alphabetic order.
-   `public void print()`\* - prints the contents of the linked list in the specified alphabetical order (i.e., ascending/descending) to System.out with each node's string on a new line.

_\* Required to pass the precheck_

Rules:

-   Your implementation must use the [doubly linked list structure](http://libproxy.bath.ac.uk/login?qurl=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FDoubly_linked_list) using the Node class
-   Strings will only contain alphabetic characters (i.e., A-Z and a-z)
-   No duplicate words should be allowed (case insensitive), e.g., if "HELLO" is in the list "hello" would not be allowed
-   You are **not** allowed to modify the SortedList interface or the Node class
-   You are **not** allowed to import any libraries or fully-qualified names of additional classes for this question
-   You are **not** allowed to use any other underlying data structures (including but not limited to arrays, ArrayLists, LinkedList) for your linked list other than the Node class provided
-   Your code will be tested using methods from the SortedList interface
