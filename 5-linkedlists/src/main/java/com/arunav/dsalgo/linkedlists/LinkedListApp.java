package com.arunav.dsalgo.linkedlists;

public class LinkedListApp {

    public static void main(String[] args) {
        testSortedLinkedList();
        testQueueUsingDLL();
        testStackUsingDLL();
        testDoublyLinkedList();
        testCircularLinkedList();
        testSinglyLinkedList();
        buildALinkedList();
    }

    private static void testSortedLinkedList() {
        System.out.println("\n\n------ Testing Sorted Linked List -------\n");
        SortedLinkedList<Integer> linkedList = new SortedLinkedList<>();
        System.out.println("Testing Insert... \n");
        System.out.println("\nInsert 99, 101");
        linkedList.insert(99);
        linkedList.insert(101);
        linkedList.displayLinkedList();
        System.out.println("Insert 50, 30, 40, 109");
        linkedList.insert(50);
        linkedList.insert(30);
//        linkedList.insert(40);
        linkedList.insert(109);
        linkedList.displayLinkedList();
        System.out.println("Insert 70, 40");
        linkedList.insert(70);
        linkedList.insert(40);
        linkedList.displayLinkedList();
        System.out.println("Insert 10, 20");
        linkedList.insert(10);
        linkedList.insert(20);
        linkedList.displayLinkedList();
        System.out.println("Insert 90");
        linkedList.insert(90);
        linkedList.displayLinkedList();
        linkedList.insert(190);
        linkedList.displayLinkedList();

        System.out.println("\nTesting Delete... \n");
        System.out.println("Delete 40" + linkedList.delete(40));
        linkedList.displayLinkedList();

        System.out.println("Delete 190" + linkedList.delete(190));
        linkedList.displayLinkedList();

        System.out.println("Delete 10" + linkedList.delete(10));
        linkedList.displayLinkedList();

        System.out.println("Delete 20" + linkedList.delete(20));
        linkedList.displayLinkedList();

        System.out.println("Delete 20" + linkedList.delete(20));
        linkedList.displayLinkedList();
    }

    private static void testQueueUsingDLL() {
        System.out.println("\n\n------ Testing Queue Impl using Linked List -------\n");
        Queue<Integer> queue = new Queue<>();
        queue.insert(101);
        queue.insert(201);
        queue.insert(302);
        queue.insert(403);
        queue.insert(504);
        queue.insert(605);
        queue.displayQueue();
        System.out.println("\nRemove=" + queue.remove());
        queue.displayQueue();
        queue.insert(6012);
        System.out.println("\nAfter Insert");
        queue.displayQueue();
        System.out.println("\nRemove=" + queue.remove());
        queue.insert(99);
        queue.displayQueue();
        System.out.println("\nRemove=" + queue.remove());
        System.out.println("Remove=" + queue.remove());
        System.out.println("Remove=" + queue.remove());
        queue.displayQueue();
        System.out.println("\nNo. of Elements=" + queue.getNoOfItems());
        System.out.println("\nPeek queue front=" + queue.peek());
    }

    private static void testStackUsingDLL() {
        System.out.println("\n\n------ Testing Stack Impl using Linked List -------\n");
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(10);
        integerStack.push(20);
        integerStack.push(30);
        integerStack.push(40);
        integerStack.displayStack();
        System.out.println("\nDeleting=" + integerStack.pop());
        integerStack.displayStack();
        System.out.println("\nDeleting=" + integerStack.pop());
        integerStack.displayStack();
        System.out.println("\nPeeking=" + integerStack.peek());
        integerStack.displayStack();
    }

    private static void testDoublyLinkedList() {
        System.out.println("\n\n------ Testing Doubly Linked List -------\n");
        LinkedList<Integer> linkedList = new DoublyLinkedList<>();
        insertIntoLinkedList(linkedList);
        findInLinkedList(linkedList);
        deleteFromLinkedList(linkedList);
        findInLinkedList(linkedList);
    }

    private static void testCircularLinkedList() {
        System.out.println("\n\n------ Testing Circular Linked List -------\n");
        LinkedList<Integer> linkedList = new CircularLinkedList<>();
        insertIntoLinkedList(linkedList);
        deleteFromLinkedList(linkedList);
    }

    private static void testSinglyLinkedList() {
        System.out.println("\n\n------ Testing Singly Linked List -------\n");
        LinkedList<Integer> linkedList = new SinglyLinkedList<>();
        insertIntoLinkedList(linkedList);
        deleteFromLinkedList(linkedList);
    }

    private static void findInLinkedList(LinkedList<Integer> linkedList) {
        System.out.println("\nFinding 10=" + linkedList.find(10));
        System.out.println("Finding 30=" + linkedList.find(30));
        System.out.println("Finding 99=" + linkedList.find(99));
    }

    private static void deleteFromLinkedList(LinkedList<Integer> linkedList) {
        System.out.print("\n\nDeleting from Front");
        System.out.println("\nDeleted=" + linkedList.deleteFirst());
        linkedList.displayLinkedList();
        System.out.println("\nDeleted=" + linkedList.deleteFirst());
        linkedList.displayLinkedList();
        System.out.println("\nDeleted=" + linkedList.deleteFirst());
        linkedList.displayLinkedList();

        System.out.print("\n\nDeleting from Back");
        System.out.println("\nDeleted=" + linkedList.deleteLast());
        linkedList.displayLinkedList();
        System.out.println("\nDeleted=" + linkedList.deleteLast());
        linkedList.displayLinkedList();
        System.out.println("\nDeleted=" + linkedList.deleteLast());
        linkedList.displayLinkedList();
    }

    private static void insertIntoLinkedList(LinkedList<Integer> linkedList) {
        System.out.println("Inserting at Back");
        linkedList.insertLast(99);
        linkedList.displayLinkedList();
        System.out.println("\n\nInserting at Front");
        linkedList.insertFirst(50);
        linkedList.insertFirst(30);
        linkedList.insertFirst(40);
        linkedList.displayLinkedList();
        System.out.println("\n\nInserting at Back");
        linkedList.insertLast(70);
        linkedList.displayLinkedList();
        System.out.println("\n\nInserting at Front");
        linkedList.insertFirst(10);
        linkedList.insertFirst(20);
        linkedList.displayLinkedList();
        System.out.println("\n\nInserting at Back");
        linkedList.insertLast(90);
        linkedList.displayLinkedList();
    }

    private static void buildALinkedList() {

        System.out.println("\n\n------ Testing a Standalone Linked List -------");

        Node<Integer> nodeA = new Node<Integer>();
        nodeA.setData(20);

        Node<Integer> nodeB = new Node<Integer>();
        nodeB.setData(10);

        Node<Integer> nodeC = new Node<Integer>();
        nodeC.setData(40);

        Node<Integer> nodeD = new Node<Integer>();
        nodeD.setData(30);

        nodeA.setNext(nodeB);
        nodeB.setNext(nodeC);
        nodeC.setNext(nodeD);

        System.out.println();
        System.out.println(getLinkedListLength(nodeA));
        System.out.println(getLinkedListLength(nodeB));
        System.out.println(getLinkedListLength(nodeC));
        System.out.println(getLinkedListLength(nodeD));
    }

    private static int getLinkedListLength(Node<Integer> node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.getNext();
        }
        return count;
    }
}
